package com.energylabel.fastrecord.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.energylabel.fastrecord.model.EcMarking;
import com.energylabel.fastrecord.model.EcMarkingAttach;
import com.energylabel.fastrecord.model.EcMarkingXmlItem;
import com.energylabel.fastrecord.model.Marking;
import com.github.pagehelper.PageInfo;

public interface MarkingService {

	/**
	 * 获取模板图片列表
	 * 
	 * @param model_no
	 * @param urlType
	 * @return
	 * @throws Exception
	 */
	String getTemplate(int model_no, String urlType) throws Exception;

	/**
	 * 保存草稿
	 * 
	 * @param ecMarkingXmlItem
	 * @param ecMarking
	 * @param attach_list
	 * @param userId
	 * @param req
	 * @return
	 * @throws Exception
	 */
	boolean saveDraft(EcMarkingXmlItem ecMarkingXmlItem, EcMarking ecMarking, String attach_list, String userId,
			HttpServletRequest req) throws Exception;

	/**
	 * 新增备案
	 * 
	 * @param ecMarkingXmlItem
	 * @param ecMarking
	 * @param attach_list
	 * @param userId
	 * @param req
	 * @return
	 * @throws Exception
	 */
	boolean save(EcMarkingXmlItem ecMarkingXmlItem, EcMarking ecMarking, String attach_list, String userId,
			HttpServletRequest req) throws Exception;

	/**
	 * 扩展
	 * 
	 * @param ecMarkingXmlItem
	 * @param ecMarking
	 * @param attach_list
	 * @param userId
	 * @param req
	 * @return
	 */
	boolean saveExpand(EcMarkingXmlItem ecMarkingXmlItem, EcMarking ecMarking, String attach_list, String userId,
			HttpServletRequest req) throws Exception;

	/**
	 * 变更
	 * 
	 * @param ecMarkingXmlItem
	 * @param ecMarking
	 * @param attach_list
	 * @param userId
	 * @param req
	 * @return
	 */
	boolean saveChange(EcMarkingXmlItem ecMarkingXmlItem, EcMarking ecMarking, String attach_list, String userId,
			HttpServletRequest req) throws Exception;

	/**
	 * 备案列表
	 * 
	 * @param pageSize
	 * @param pageNum
	 * @param map
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	PageInfo<Marking> list(int pageSize, int pageNum, Map<String, Object> map, String userId) throws Exception;

	/**
	 * 草稿列表
	 * 
	 * @param pageSize
	 * @param pageNum
	 * @param map
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	PageInfo<Marking> draftList(int pageSize, int pageNum, Map<String, Object> map, String userId) throws Exception;

	Map<String, Object> getDraft2Map(int id) throws Exception;

	/**
	 * 查看信息
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getInfo2Map(int id) throws Exception;

	Map<String, Object> getInfoWithoutAttach2Map(int id) throws Exception;

	/**
	 * 上传标识图
	 * 
	 * @param id
	 * @param attach
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	boolean uploadQrcode(int id, EcMarkingAttach attach, String userId) throws Exception;

	/**
	 * 下载二维码
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	String downloadQrcode(int id) throws Exception;

	/**
	 * 获取模板中的数据项
	 * 
	 * @param ptid
	 * @param pltId
	 * @return
	 * @throws Exception
	 */
	String getTemplateItems(int ptid, int pltId) throws Exception;

	/**
	 * 下载标识图
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	String downloadELImg(int id) throws Exception;
}
