package com.energylabel.fastrecord.controller;

import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import com.energylabel.fastrecord.util.OssCommonClient;

import net.sf.json.JSONObject;

/**
 * oss controller
 * 
 * @author LiMingYi
 * @date 2018-07-05
 */
@Controller
@RequestMapping("/oss")
public class OSSController extends AbstractController {

	private Logger logger = LoggerFactory.getLogger(OSSController.class);

	@Autowired
	private OssCommonClient ossCommonClient;

	@Value("${oss.callback.accessurl}")
	private String OSS_CALLBACK_ACCESS_URL;

	@Value("${oss.bucket.domain}")
	private String PUBLIC_BUCKET_DOMAIN_NAME;

	/**
	 * web获取签名
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/token", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public Object token(HttpServletRequest request, HttpServletResponse response) throws Exception {
		OSSClient client = ossCommonClient.getClient();
		String bucket = ossCommonClient.getBucketName();
		String dir = "fastrecord/" + ossCommonClient.getEnv() + "/";// 默认存储路径
		String host = PUBLIC_BUCKET_DOMAIN_NAME;
		String callbackUrl = OSS_CALLBACK_ACCESS_URL + "osscallback/getUploadState.do";// OSS回调请求callback/getUploadState.do

		Map<String, String> respMap = new LinkedHashMap<String, String>();
		try {
			long expireTime = 30;
			long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
			Date expiration = new Date(expireEndTime);
			PolicyConditions policyConds = new PolicyConditions();
			policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 10240000);
			policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dir);

			String postPolicy = client.generatePostPolicy(expiration, policyConds);
			byte[] binaryData = postPolicy.getBytes("utf-8");
			String encodedPolicy = BinaryUtil.toBase64String(binaryData);
			String postSignature = client.calculatePostSignature(postPolicy);

			// 封装signature
			respMap.put("accessid", client.getCredentialsProvider().getCredentials().getAccessKeyId());
			respMap.put("policy", encodedPolicy);
			respMap.put("signature", postSignature);
			respMap.put("bucket", bucket);
			respMap.put("dir", dir);
			respMap.put("host", host);
			respMap.put("expire", String.valueOf(expireEndTime / 1000));

			// 封装回调参数
			Map<String, String> callBackParamMap = new LinkedHashMap<String, String>();
			callBackParamMap.put("callbackUrl", callbackUrl);
			callBackParamMap.put("callbackBody", "filename=${object}");
			callBackParamMap.put("callbackBodyType", "application/x-www-form-urlencoded");
			JSONObject callBackParamJson = JSONObject.fromObject(callBackParamMap);
			logger.debug(callBackParamJson.toString());
			byte[] callBackParamJsonBinaryData = callBackParamJson.toString().getBytes("utf-8");
			respMap.put("callback", BinaryUtil.toBase64String(callBackParamJsonBinaryData));

			JSONObject ja1 = JSONObject.fromObject(respMap);
			logger.debug(ja1.toString());
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Methods", "POST");

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return super.jsonp(respMap, request);
	}

	public OssCommonClient getOssCommonClient() {
		return ossCommonClient;
	}

	public void setOssCommonClient(OssCommonClient ossCommonClient) {
		this.ossCommonClient = ossCommonClient;
	}
}
