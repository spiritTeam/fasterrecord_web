package com.energylabel.fastrecord.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class InvokeInterfaceUtils {

	public static String checkHost(HttpServletRequest request, boolean isCheckHost, String checkUrlString) {
		String reStr = "0";// 默认返回值
		if (isCheckHost) {
			String host = request.getHeader("host").split(":")[0];
			if (host.contains(checkUrlString)) {
				reStr = "1";
			}
		}
		return reStr;
	}

	public static String sendHttpPost(String url, Map<String, String> valueMap) throws Exception {
		HttpClient client = null;
		PostMethod method = null;
		NameValuePair[] valuePair = null;
		try {
			if (url == null)
				return "error:-1";
			if (valueMap == null || valueMap.size() == 0)
				return "error:-2;";

			client = new HttpClient();
			method = new PostMethod(url);
			valuePair = new NameValuePair[valueMap.size()];

			int i = 0;
			for (Map.Entry<String, String> entry : valueMap.entrySet())
				valuePair[i++] = new NameValuePair(entry.getKey(), entry.getValue());

			method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
			method.setRequestBody(valuePair);
			client.executeMethod(method);
			return method.getResponseBodyAsString();
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			// CHANGE
			if (method != null)
				method.releaseConnection();
		}
	}

	public static String sendHttpGet(String url, Map<String, String> valueMap) throws Exception {
		HttpClient client = null;
		GetMethod method = null;
		NameValuePair[] valuePair = null;
		try {
			if (url == null)
				return "error:-1";
			if (valueMap == null || valueMap.size() == 0)
				return "error:-2;";

			client = new HttpClient();
			method = new GetMethod(url);
			valuePair = new NameValuePair[valueMap.size()];

			int i = 0;
			for (Map.Entry<String, String> entry : valueMap.entrySet())
				valuePair[i++] = new NameValuePair(entry.getKey(), entry.getValue());
			method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
			method.setQueryString(valuePair);
			client.executeMethod(method);
			if (method.getStatusCode() == 200) {
				return method.getResponseBodyAsString();
			}
			return null;
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			// CHANGE
			if (method != null)
				method.releaseConnection();
		}
	}
}
