package com.energylabel.fastrecord.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.energylabel.fastrecord.model.CategoryInfo;
import com.energylabel.fastrecord.model.EcMarking;
import com.energylabel.fastrecord.model.EcMarkingAttach;
import com.energylabel.fastrecord.model.EcMarkingXmlItem;
import com.energylabel.fastrecord.model.Marking;
import com.energylabel.fastrecord.service.CategoryService;
import com.energylabel.fastrecord.service.MarkingService;
import com.energylabel.fastrecord.util.InvokeInterfaceUtils;
import com.energylabel.fastrecord.util.StringUtils;
import com.github.pagehelper.PageInfo;

/**
 * 备案
 * 
 * @author ru
 * @date 2019年2月22日
 */
@Controller
@RequestMapping("/marking")
public class MarkingController extends AbstractController {

	private Logger log = Logger.getLogger(MarkingController.class);
	@Autowired
	MarkingService markingService;
	@Autowired
	CategoryService categoryService;
	@Value("${is_check_host}")
	private boolean isCheckHost;
	@Value("${check_url_string}")
	private String checkUrlString;
	@Value("${custom.pltId}")
	private String customPltId;

	/**
	 * 获取模板信息
	 * 
	 * @param model_no
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/getTemplate", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Object getTemplate(int model_no, HttpServletRequest req) {
		String re = "";
		try {
			re = markingService.getTemplate(model_no + 2,
					InvokeInterfaceUtils.checkHost(req, this.isCheckHost, this.checkUrlString));
		} catch (Exception e) {
			log.error("getTemplateList异常", e);
		}
		return jsonp(re, req);
	}

	/**
	 * 获取产品大类列表
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/getCategoryList", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Object getCategoryList(HttpServletRequest req) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result_code", "0");
		try {
			List<CategoryInfo> list = categoryService.getCategoryList();
			if (null != list && !list.isEmpty()) {
				resultMap.put("result_code", "1");
				resultMap.put("data", list);
			}
		} catch (Exception e) {
			log.error("getCategoryList异常", e);
		}
		return jsonp(resultMap, req);
	}

	/**
	 * 获取模板项
	 * 
	 * @param model_no
	 * @param ptid
	 * @param pltId
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/getTemplateItem", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Object getTemplateItem(int model_no, int ptid, int pltId, HttpServletRequest req) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result_code", "0");
		try {
			CategoryInfo c = categoryService.getCategoryByModel_no(model_no);
			if (c != null) {
				resultMap.put("result_code", "1");
				resultMap.put("GB", c.getEc_model_gb());// 国标
				if (customPltId.contains(String.valueOf(pltId))) {// 自定义不判断必填
					resultMap.put("required", "");
				} else {
					// 必填项
					String re = this.markingService.getTemplateItems(ptid, pltId);
					log.info("模板数据：" + re);
					if (!StringUtils.isNullOrEmpty(re)) {
						JSONArray array = JSONArray.parseArray(re);
						JSONObject json = null;
						String attrCode = "";
						String str = "";
						for (Object o : array) {
							json = (JSONObject) o;
							attrCode = json.getString("attrCode");
							if (!StringUtils.isNullOrEmpty(attrCode)) {
								str += "," + attrCode;
							}
						}
						if (str.length() > 0) {
							resultMap.put("required", str.substring(1));
						}
					}
				}
			}
		} catch (Exception e) {
			log.error("getCategoryList异常", e);
		}
		return jsonp(resultMap, req);
	}

	/**
	 * 保存草稿
	 * 
	 * @param ecMarkingXmlItem
	 * @param ecMarking
	 * @param attach_list
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/saveDraft")
	@ResponseBody
	public Object saveDraft(EcMarkingXmlItem ecMarkingXmlItem, EcMarking ecMarking, String attach_list,
			HttpServletRequest req) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result_code", "0");
		try {
			if (markingService.saveDraft(ecMarkingXmlItem, ecMarking, attach_list, getUserId(), req)) {
				resultMap.put("result_code", "1");
				resultMap.put("message", "保存至草稿箱成功");
			}
		} catch (Exception e) {
			log.error("insertDraft异常", e);
			resultMap.put("message", "保存失败");
		}
		return jsonp(resultMap, req);
	}

	/**
	 * 新增备案
	 * 
	 * @param ecMarkingXmlItem
	 * @param ecMarking
	 * @param attach_list
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/save")
	@ResponseBody
	public Object save(EcMarkingXmlItem ecMarkingXmlItem, EcMarking ecMarking, String attach_list,
			HttpServletRequest req) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result_code", "0");
		try {
			if (this.markingService.save(ecMarkingXmlItem, ecMarking, attach_list, getUserId(), req)) {
				resultMap.put("result_code", "1");
				resultMap.put("message", "备案提交成功");
			}
		} catch (Exception e) {
			log.error("save异常", e);
			resultMap.put("message", e.getMessage());
		}
		return jsonp(resultMap, req);
	}

	@RequestMapping(value = "/saveExpand")
	@ResponseBody
	public Object saveExpand(EcMarkingXmlItem ecMarkingXmlItem, EcMarking ecMarking, String attach_list,
			HttpServletRequest req) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result_code", "0");
		try {
			if (this.markingService.saveExpand(ecMarkingXmlItem, ecMarking, attach_list, getUserId(), req)) {
				resultMap.put("result_code", "1");
				resultMap.put("message", "扩展提交成功");
			}
		} catch (Exception e) {
			log.error("saveExpand异常", e);
			resultMap.put("message", e.getMessage());
		}
		return jsonp(resultMap, req);
	}

	@RequestMapping(value = "/saveChange")
	@ResponseBody
	public Object saveChange(EcMarkingXmlItem ecMarkingXmlItem, EcMarking ecMarking, String attach_list,
			HttpServletRequest req) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result_code", "0");
		try {
			if (this.markingService.saveChange(ecMarkingXmlItem, ecMarking, attach_list, getUserId(), req)) {
				resultMap.put("result_code", "1");
				resultMap.put("message", "变更提交成功");
			}
		} catch (Exception e) {
			log.error("saveChange异常", e);
			resultMap.put("message", e.getMessage());
		}
		return jsonp(resultMap, req);
	}

	/**
	 * 草稿箱列表
	 * 
	 * @param req
	 * @param pageSize
	 * @param pageNum
	 * @return
	 */
	@RequestMapping(value = "/draftList", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Object draftList(HttpServletRequest req, int pageSize, int pageNum) {
		PageInfo<Marking> page = null;
		Map<String, Object> map = this.getParamMap(req);
		try {
			page = this.markingService.draftList(pageSize, pageNum, map, this.getUserId());
		} catch (Exception e) {
			log.error("异常：draftList失败！", e);
		}
		return super.jsonp(page, req);
	}

	/**
	 * 备案查询
	 * 
	 * @param req
	 * @param pageSize
	 * @param pageNum
	 * @return
	 */
	@RequestMapping(value = "/list", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Object list(HttpServletRequest req, int pageSize, int pageNum) {
		PageInfo<Marking> page = null;
		Map<String, Object> map = this.getParamMap(req);
		try {
			page = this.markingService.list(pageSize, pageNum, map, this.getUserId());
		} catch (Exception e) {
			log.error("异常：list失败！", e);
		}
		return super.jsonp(page, req);
	}

	/**
	 * 草稿信息
	 * 
	 * @param req
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getDraftInfo", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Object getDraftInfo(HttpServletRequest req, int id) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result_code", "0");
		try {
			Map<String, Object> map = this.markingService.getDraft2Map(id);
			if (map != null) {
				resultMap.put("result_code", "1");
				resultMap.putAll(map);
			}
		} catch (Exception e) {
			log.error("异常：getDraftInfo失败！", e);
		}
		return super.jsonp(resultMap, req);
	}

	/**
	 * 获取备案信息
	 * 
	 * @param req
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getInfo", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Object getInfo(HttpServletRequest req, int id) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result_code", "0");
		try {
			Map<String, Object> map = this.markingService.getInfo2Map(id);
			if (map != null) {
				resultMap.put("result_code", "1");
				resultMap.putAll(map);
			}
		} catch (Exception e) {
			log.error("异常：getDraftInfo失败！", e);
		}
		return super.jsonp(resultMap, req);
	}

	/**
	 * 获取备案信息(没有附件)
	 * 
	 * @param req
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getInfoWithoutAttach", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Object getInfoWithoutAttach(HttpServletRequest req, int id) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result_code", "0");
		try {
			Map<String, Object> map = this.markingService.getInfoWithoutAttach2Map(id);
			if (map != null) {
				resultMap.put("result_code", "1");
				resultMap.putAll(map);
			}
		} catch (Exception e) {
			log.error("异常：getDraftInfo失败！", e);
		}
		return super.jsonp(resultMap, req);
	}

	/**
	 * 下周二维码
	 * 
	 * @param id
	 * @param req
	 * @param res
	 */
	@RequestMapping(value = "/downloadQrcode")
	public void downloadQrcode(int id, HttpServletRequest req, HttpServletResponse res) {
		try {
			String re = this.markingService.downloadQrcode(id);
			if (!StringUtils.isNullOrEmpty(re)) {
				res.setContentType("image/png");
				res.setHeader("content-disposition", "attachment;filename=qrcode.png");
				URL url = new URL(re);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				// 得到输入流
				InputStream inputStream = conn.getInputStream();
				byte[] buffer = new byte[1024];
				int len = 0;
				OutputStream os = res.getOutputStream();
				while ((len = inputStream.read(buffer)) != -1) {
					os.write(buffer, 0, len);
				}
				os.flush();
			}
		} catch (Exception e) {
			log.error("异常：downloadQrcode失败！", e);
		}
	}

	/**
	 * 下周标识图
	 * 
	 * @param id
	 * @param req
	 * @param res
	 */
	@RequestMapping(value = "/downloadELImg")
	public void downloadELImg(int id, HttpServletRequest req, HttpServletResponse res) {
		try {
			String re = this.markingService.downloadELImg(id);
			// re = "http://zip.el.bbqkimg.cn/label/jh/9afjh/9afjh.png";
			if (!StringUtils.isNullOrEmpty(re)) {
				res.setContentType("image/png");
				res.setHeader("content-disposition", "attachment;filename=el.png");
				URL url = new URL(re);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				// 得到输入流
				InputStream inputStream = conn.getInputStream();
				byte[] buffer = new byte[1024];
				int len = 0;
				OutputStream os = res.getOutputStream();
				while ((len = inputStream.read(buffer)) != -1) {
					os.write(buffer, 0, len);
				}
				os.flush();
			}
		} catch (Exception e) {
			log.error("异常：downloadELImg失败！", e);
		}
	}

	/**
	 * 上传标识图
	 * 
	 * @param id
	 * @param attach
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/uploadQrcode")
	@ResponseBody
	public Object uploadQrcode(int id, EcMarkingAttach attach, HttpServletRequest req) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result_code", "0");
		try {
			if (this.markingService.uploadQrcode(id, attach, this.getUserId())) {
				resultMap.put("result_code", "1");
			}
		} catch (Exception e) {
			log.error("异常：uploadQrcode失败！", e);
		}
		return super.jsonp(resultMap, req);
	}

}
