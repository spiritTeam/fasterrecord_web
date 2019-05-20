package com.energylabel.fastrecord.service.impl;

import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.energylabel.fastrecord.MakingConstants;
import com.energylabel.fastrecord.dao.EcMarkingAttachDAO;
import com.energylabel.fastrecord.dao.EcMarkingDAO;
import com.energylabel.fastrecord.dao.EcMarkingKzTitleDao;
import com.energylabel.fastrecord.dao.EcMarkingXmlDAO;
import com.energylabel.fastrecord.dao.EcMasterDAO;
import com.energylabel.fastrecord.model.EcMarking;
import com.energylabel.fastrecord.model.EcMarkingAttach;
import com.energylabel.fastrecord.model.EcMarkingKzTitle;
import com.energylabel.fastrecord.model.EcMarkingXml;
import com.energylabel.fastrecord.model.EcMarkingXmlItem;
import com.energylabel.fastrecord.model.EcMaster;
import com.energylabel.fastrecord.model.Marking;
import com.energylabel.fastrecord.service.MarkingService;
import com.energylabel.fastrecord.util.DateUtils;
import com.energylabel.fastrecord.util.Encrypt;
import com.energylabel.fastrecord.util.HttpsUtils;
import com.energylabel.fastrecord.util.InvokeInterfaceUtils;
import com.energylabel.fastrecord.util.MarkingPathUtil;
import com.energylabel.fastrecord.util.MarkingXmlItemUtil;
import com.energylabel.fastrecord.util.StringUtils;
import com.energylabel.fastrecord.vo.EcMarkingAttachVO;
import com.energylabel.fastrecord.vo.EnergyLabelUser;
import com.energylabel.lab.service.LabService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hitworth.framework.base.service.UserService;

/**
 * 
 * @author ru
 * @date 2019年1月29日
 */
@Service("markingService")
public class MarkingServiceImpl implements MarkingService {

	private Logger log = Logger.getLogger(MarkingServiceImpl.class);

	@Value("${beian_domain}")
	private String beianDomain;
	@Value("${qrcode_domain}")
	private String qrcodeDomain;
	@Value("${qrcode_img_root}")
	private String qrcodeImgRoot;
	@Value("${audit.userId}")
	private String auditUserId;
	@Value("${beian.userid}")
	private String beianUserId;
	@Value("${beian.eid}")
	private String beianEid;
	@Value("${beian.ename}")
	private String beianEname;
	@Value("${custom.pltId}")
	private String customPltId;

	@Autowired
	private UserService userService;

	@Autowired
	private EcMarkingDAO ecMarkingDAO;
	@Autowired
	private EcMasterDAO ecMasterDAO;
	@Autowired
	private EcMarkingXmlDAO ecMarkingXmlDAO;
	@Autowired
	private EcMarkingAttachDAO ecMarkingAttachDAO;
	@Autowired
	private EcMarkingKzTitleDao ecMarkingKzTitleDao;
	@Autowired
	private LabService labService;

	@Override
	public String getTemplate(int model_no, String urlType) throws Exception {
		String url = this.qrcodeDomain + "energyLabel/findPLabelTemplateByPtId.json";
		Map<String, String> params = new HashMap<>();
		params.put("ptId", String.valueOf(model_no));
		params.put("urlType", urlType);
		return InvokeInterfaceUtils.sendHttpGet(url, params);
	}

	@Override
	public boolean saveDraft(EcMarkingXmlItem ecMarkingXmlItem, EcMarking ecMarking, String attach_list, String userId,
			HttpServletRequest req) throws Exception {
		// 用户信息
		EnergyLabelUser labUser = this.getEnergyLabelUser(userId);
		if (labUser == null) {
			return false;
		}
		MarkingXmlItemUtil markingXmlItemUtil = new MarkingXmlItemUtil();
		ecMarking.setEc_marking_title(
				markingXmlItemUtil.getMarkingTitle(ecMarkingXmlItem, ecMarking.getEc_model_no(), req));// 规格型号
		ecMarking.setEc_marking_level(
				markingXmlItemUtil.getMarkingLevel(ecMarkingXmlItem, ecMarking.getEc_model_no(), req));// 能效等级
		ecMarking.setEc_marking_review_datastate("2");// 新数据
		ecMarking.setEc_marking_userid(String.valueOf(labUser.getEnergyLabeluserId()));// 备案用户id
		ecMarking.setEc_enterprise_id(String.valueOf(labUser.getEid()));// 企业id

		String ecMasterChang = MakingConstants.Making_Type_New;// 新增备案
		int state = 1;// 草稿
		int id = ecMarking.getId();
		if (id > 0) {
			EcMarking bean = ecMarkingDAO.getEcMarkingById(id);
			if (bean != null) {
				// 1.Ec_marking
				this.updateMarking(ecMarking, bean, state, null);
				// 2.修改Ec_master表数据
				this.updateMaster(ecMarking.getId(), ecMarking.getEc_model_no(), ecMarking.getEc_marking_title());
			}
		} else {
			// 1.新增Ec_master表数据
			EcMaster ecMaster = this.insertMaster(ecMarking.getEc_model_no(), ecMarking.getEc_marking_title(),
					ecMasterChang, ecMarking.getEc_marking_userid(), null, null);
			// 2.新增Ec_marking表数据
			ecMarking.setEc_prelimno(this.getSeq("PRE_NUM"));
			this.insertMarking(ecMarking, ecMaster.getEc_master_id(), state, null);
		}
		// 3.Ec_marking_xml C值
		String ecmarkingXmlStr = markingXmlItemUtil.getMarkingXmlStr(ecMarkingXmlItem, ecMarking.getEc_model_no(), req);
		this.coverXml(String.valueOf(ecMarking.getId()), ecmarkingXmlStr);
		// 微机处理
		if ("30".equals(ecMarking.getEc_model_no())) {
			this.saveC64(ecMarking.getId(), ecMarkingXmlItem.getC64());
		}
		// 4.附件
		this.saveAttachList(attach_list, ecMarking, null);
		return true;
	}

	/**
	 * 微机特殊处理-扩展规格型号C64
	 * 
	 * @param id
	 * @param c64
	 */
	private void saveC64(int id, String c64) {
		if (!StringUtils.isNullOrEmpty(c64)) {
			this.ecMarkingKzTitleDao.delByMarkingId(id);// 全部删除
			String[] array = c64.split(";");
			if (array.length > 0) {
				String idStr = String.valueOf(id);
				for (String title : array) {
					EcMarkingKzTitle ecMarkingKzTitle = new EcMarkingKzTitle();
					ecMarkingKzTitle.setEc_marking_id(idStr);
					ecMarkingKzTitle.setEc_marking_kz_title(title);
					this.ecMarkingKzTitleDao.insertMarkingKztitle(ecMarkingKzTitle);
				}
			}
		}
	}

	@Override
	public boolean save(EcMarkingXmlItem ecMarkingXmlItem, EcMarking ecMarking, String attach_list, String userId,
			HttpServletRequest req) throws Exception {
		// 用户信息
		EnergyLabelUser labUser = this.getEnergyLabelUser(userId);
		if (labUser == null) {
			return false;
		}
		MarkingXmlItemUtil markingXmlItemUtil = new MarkingXmlItemUtil();
		ecMarking.setEc_marking_title(
				markingXmlItemUtil.getMarkingTitle(ecMarkingXmlItem, ecMarking.getEc_model_no(), req));// 规格型号
		ecMarking.setEc_marking_level(
				markingXmlItemUtil.getMarkingLevel(ecMarkingXmlItem, ecMarking.getEc_model_no(), req));// 能效等级
		ecMarking.setEc_marking_review_datastate("2");// 新数据
		ecMarking.setEc_marking_userid(String.valueOf(labUser.getEnergyLabeluserId()));// 备案用户id
		ecMarking.setEc_enterprise_id(String.valueOf(labUser.getEid()));// 企业id

		String ecMasterChang = MakingConstants.Making_Type_New;// 新增备案
		int state = 3;// 待公告
		if (this.customPltId.contains(String.valueOf(ecMarking.getPltId()))) {
			state = 2;// 标识图制作中(家用电冰箱2015自定义模板设置state=2)
		}
		String uid = null;
		EcMaster ecMaster = null;
		if (ecMarking.getId() > 0) {// 修改
			EcMarking bean = ecMarkingDAO.getEcMarkingById(ecMarking.getId());
			if (bean != null) {
				// uid获取
				ecMarking.setEc_prelimno(bean.getEc_prelimno());
				uid = getUid(ecMarkingXmlItem, ecMarking, ecMasterChang, labUser);
				// 1.修改Ec_marking表数据
				this.updateMarking(ecMarking, bean, state, uid);
				// 2.修改Ec_master表数据
				this.updateMaster(ecMarking.getId(), ecMarking.getEc_model_no(), ecMarking.getEc_marking_title());
			}
		} else {// 新增
			// uid获取
			ecMarking.setEc_prelimno(this.getSeq("PRE_NUM"));
			uid = getUid(ecMarkingXmlItem, ecMarking, ecMasterChang, labUser);
			// 1.新增Ec_master表数据
			ecMaster = this.insertMaster(ecMarking.getEc_model_no(), ecMarking.getEc_marking_title(), ecMasterChang,
					ecMarking.getEc_marking_userid(), null, null);
			// 2.新增Ec_marking表数据
			this.insertMarking(ecMarking, ecMaster.getEc_master_id(), state, uid);
		}
		// 3.Ec_marking_xml C值
		String ecmarkingXmlStr = markingXmlItemUtil.getMarkingXmlStr(ecMarkingXmlItem, ecMarking.getEc_model_no(), req);
		this.coverXml(String.valueOf(ecMarking.getId()), ecmarkingXmlStr);
		// 微机处理
		if ("30".equals(ecMarking.getEc_model_no())) {
			this.saveC64(ecMarking.getId(), ecMarkingXmlItem.getC64());
		}
		// 4.附件
		this.saveAttachList(attach_list, ecMarking, uid);
		// 5.公告
		if (state == 3) {
			this.publish(ecMarking, ecMaster, ecMarkingXmlItem);
		}
		return true;
	}

	@Override
	public boolean saveExpand(EcMarkingXmlItem ecMarkingXmlItem, EcMarking ecMarking, String attach_list, String userId,
			HttpServletRequest req) throws Exception {
		// 用户信息
		EnergyLabelUser labUser = this.getEnergyLabelUser(userId);
		if (labUser == null) {
			return false;
		}
		// 判定：A扩展成B，B就不能再扩展
		String ecMasterChang = MakingConstants.Making_Type_Expand;// 扩展
		EcMaster ecMaster = this.ecMasterDAO.getEcMasterByMarkingId(ecMarking.getId());
		if (ecMasterChang.equals(ecMaster.getEc_master_chang())) {
			throw new Exception("已扩展的能效备案产品不能再扩展");
		}
		MarkingXmlItemUtil markingXmlItemUtil = new MarkingXmlItemUtil();
		ecMarking.setEc_marking_title(
				markingXmlItemUtil.getMarkingTitle(ecMarkingXmlItem, ecMarking.getEc_model_no(), req));// 规格型号
		ecMarking.setEc_marking_level(
				markingXmlItemUtil.getMarkingLevel(ecMarkingXmlItem, ecMarking.getEc_model_no(), req));// 能效等级
		ecMarking.setEc_marking_review_datastate("2");// 新数据
		ecMarking.setEc_marking_userid(String.valueOf(labUser.getEnergyLabeluserId()));// 备案用户id
		ecMarking.setEc_enterprise_id(String.valueOf(labUser.getEid()));// 企业id

		int state = 3;// 待公告
		if (this.customPltId.contains(String.valueOf(ecMarking.getPltId()))) {
			state = 2;// 标识图制作中(家用电冰箱2015自定义模板设置state=2)
		}
		// uid获取
		ecMarking.setEc_prelimno(this.getSeq("PRE_NUM"));
		String uid = getUid(ecMarkingXmlItem, ecMarking, ecMasterChang, labUser);
		// 1.新增Ec_master表数据
		ecMaster = this.insertMaster(ecMarking.getEc_model_no(), ecMarking.getEc_marking_title(), ecMasterChang,
				ecMarking.getEc_marking_userid(), ecMarking.getEc_master_kuozhan_text(), ecMaster);
		// 2.新增Ec_marking表数据
		this.insertMarking(ecMarking, ecMaster.getEc_master_id(), state, uid);
		// 3.Ec_marking_xml C值
		String ecmarkingXmlStr = markingXmlItemUtil.getMarkingXmlStr(ecMarkingXmlItem, ecMarking.getEc_model_no(), req);
		this.coverXml(String.valueOf(ecMarking.getId()), ecmarkingXmlStr);
		// 微机处理
		if ("30".equals(ecMarking.getEc_model_no())) {
			this.saveC64(ecMarking.getId(), ecMarkingXmlItem.getC64());
		}
		// 4.附件
		this.saveAttachList(attach_list, ecMarking, uid);
		// 5.公告
		if (state == 3) {
			this.publish(ecMarking, ecMaster, ecMarkingXmlItem);
		}
		return true;
	}

	@Override
	public boolean saveChange(EcMarkingXmlItem ecMarkingXmlItem, EcMarking ecMarking, String attach_list, String userId,
			HttpServletRequest req) throws Exception {
		// 用户信息
		EnergyLabelUser labUser = this.getEnergyLabelUser(userId);
		if (labUser == null) {
			return false;
		}
		// 判定：A变更成B，A就不能再变更
		String ecMasterChang = MakingConstants.Making_Type_Change;// 变更
		int count = this.ecMasterDAO.countChildEcMaster(ecMarking.getId(), ecMasterChang);
		if (count > 0) {
			throw new Exception("已变更过的能效备案产品不能再变更");
		}
		MarkingXmlItemUtil markingXmlItemUtil = new MarkingXmlItemUtil();
		ecMarking.setEc_marking_title(
				markingXmlItemUtil.getMarkingTitle(ecMarkingXmlItem, ecMarking.getEc_model_no(), req));// 规格型号
		ecMarking.setEc_marking_level(
				markingXmlItemUtil.getMarkingLevel(ecMarkingXmlItem, ecMarking.getEc_model_no(), req));// 能效等级
		ecMarking.setEc_marking_review_datastate("2");// 新数据
		ecMarking.setEc_marking_userid(String.valueOf(labUser.getEnergyLabeluserId()));// 备案用户id
		ecMarking.setEc_enterprise_id(String.valueOf(labUser.getEid()));// 企业id

		int state = 3;// 待公告
		if (this.customPltId.contains(String.valueOf(ecMarking.getPltId()))) {
			state = 2;// 标识图制作中(家用电冰箱2015自定义模板设置state=2)
		}
		// uid获取
		ecMarking.setEc_prelimno(this.getSeq("PRE_NUM"));
		String uid = getUid(ecMarkingXmlItem, ecMarking, ecMasterChang, labUser);
		// 1.新增Ec_master表数据
		EcMaster ecMaster = this.ecMasterDAO.getEcMasterByMarkingId(ecMarking.getId());
		if (null != ecMaster && "1".equals(ecMaster.getEc_master_chang())) {
			ecMasterChang = MakingConstants.Making_Type_Expand_Change;// 扩展变更
		}
		ecMaster = this.insertMaster(ecMarking.getEc_model_no(), ecMarking.getEc_marking_title(), ecMasterChang,
				ecMarking.getEc_marking_userid(), ecMarking.getEc_master_kuozhan_text(), ecMaster);// 注意：这里使用的是扩展文本，因为前台将变更的文本赋值在扩展的文本中
		// 2.新增Ec_marking表数据
		this.insertMarking(ecMarking, ecMaster.getEc_master_id(), state, uid);
		// 3.Ec_marking_xml C值
		String ecmarkingXmlStr = markingXmlItemUtil.getMarkingXmlStr(ecMarkingXmlItem, ecMarking.getEc_model_no(), req);
		this.coverXml(String.valueOf(ecMarking.getId()), ecmarkingXmlStr);
		// 微机处理
		if ("30".equals(ecMarking.getEc_model_no())) {
			this.saveC64(ecMarking.getId(), ecMarkingXmlItem.getC64());
		}
		// 4.附件
		this.saveAttachList(attach_list, ecMarking, uid);
		// 5.公告
		if (state == 3) {
			this.publish(ecMarking, ecMaster, ecMarkingXmlItem);
		}
		return true;
	}

	/**
	 * 新增marking表数据
	 * 
	 * @param ecMarking
	 * @param mid
	 * @param state
	 * @param uid
	 * @throws Exception
	 */
	private void insertMarking(EcMarking ecMarking, String mid, int state, String uid) throws Exception {
		ecMarking.setId(Integer.parseInt(getSeq("EC_MARKING")));
		ecMarking.setState(state);
		ecMarking.setEc_master_id(mid);
		ecMarking.setEc_marking_addtime(new Date());
		ecMarking.setEc_marking_ispass("2");
		ecMarking.setEc_marking_passman(this.auditUserId);
		ecMarking.setEc_marking_passtime(ecMarking.getEc_marking_addtime());
		ecMarking.setEc_marking_ispass_review("1");// 复审： 0-初审待审 1-复审通过2-复审不通过
		ecMarking.setEc_marking_passman_review(this.auditUserId);
		ecMarking.setEc_marking_passtime_review(ecMarking.getEc_marking_addtime());
		ecMarking.setEc_marking_review_datastate("2");
		ecMarking.setEc_unit_ismaster("0");
		ecMarking.setEc_marking_recordno(MarkingPathUtil.ecMarkingRecordnoStr(ecMarking));// 备案号
		ecMarking.setEc_qycode_key(uid);
		ecMarking.setEc_marking_bulletintime(ecMarking.getEc_marking_addtime());
		ecMarkingDAO.insertEcMarking(ecMarking);
	}

	/**
	 * 修改marking表数据
	 * 
	 * @param ecMarking
	 * @param bean
	 * @param state
	 * @param uid
	 * @throws Exception
	 */
	private void updateMarking(EcMarking ecMarking, EcMarking bean, int state, String uid) throws Exception {
		bean.setState(state);
		bean.setEc_marking_userid(ecMarking.getEc_marking_userid());// 备案用户id
		bean.setEc_marking_title(ecMarking.getEc_marking_title());
		bean.setEc_marking_level(ecMarking.getEc_marking_level());
		bean.setEc_marking_recordno(MarkingPathUtil.ecMarkingRecordnoStr(ecMarking));// 备案号
		bean.setEc_labname(ecMarking.getEc_labname());
		bean.setEc_labreport_id(ecMarking.getEc_labreport_id());
		bean.setEc_labreport_no(ecMarking.getEc_labreport_no());
		bean.setEc_qycode_key(uid);
		ecMarkingDAO.updateEcMarking(bean);
	}

	/**
	 * 新增master表数据
	 * 
	 * @param model_no
	 * @param ecmarkingTitle
	 * @param ecMasterChang
	 * @param userid
	 * @param txt
	 * @return
	 * @throws Exception
	 */
	private EcMaster insertMaster(String model_no, String ecmarkingTitle, String ecMasterChang, String userid,
			String txt, EcMaster parent) throws Exception {
		EcMaster ecMaster = new EcMaster();
		ecMaster.setEc_master_id(getSeq("EC_MASTER"));
		ecMaster.setEc_master_chang(ecMasterChang);// 0新增, 1扩展,2变更,3扩展变更
		ecMaster.setEc_master_userid(userid);
		ecMaster.setEc_master_addtime(new Date());
		ecMaster.setEc_marking_count("1");
		ecMaster.setEc_model_no(model_no);
		ecMaster.setEc_master_name(ecmarkingTitle);
		if ("1".equals(ecMasterChang)) { // 扩展
			ecMaster.setEc_master_kuozhan_text(txt);
			ecMaster.setEc_master_biangeng_text("");
		} else if ("2".equals(ecMasterChang) || "3".equals(ecMasterChang)) {// 2变更3扩展变更
			ecMaster.setEc_master_kuozhan_text("");
			ecMaster.setEc_master_biangeng_text(txt);
		}
		if (parent != null) {
			ecMaster.setEc_master_parentid(parent.getEc_master_id());
		}
		ecMasterDAO.insertEcMaster(ecMaster);
		return ecMaster;
	}

	/**
	 * 更新master表数据
	 * 
	 * @param id
	 *            marking表id
	 * @param model_no
	 * @param ecmarkingTitle
	 */
	private void updateMaster(int id, String model_no, String ecmarkingTitle) throws Exception {
		EcMaster ecMaster = ecMasterDAO.getEcMasterByMarkingId(id);
		ecMaster.setEc_model_no(model_no);
		ecMaster.setEc_master_name(ecmarkingTitle);
		ecMasterDAO.updateEcMaster(ecMaster);
	}

	/**
	 * 覆盖Ec_marking_xml数据
	 * 
	 * @param id
	 * @param xml
	 * @throws Exception
	 */
	private void coverXml(String id, String xml) throws Exception {
		EcMarkingXml ecMarkingXml = new EcMarkingXml();
		ecMarkingXml.setEc_marking_id(id);
		ecMarkingXml.setEc_marking_xml(xml);
		ecMarkingXmlDAO.insertXml(ecMarkingXml);
	}

	/**
	 * 公告
	 * 
	 * @param ecMarking
	 * @param ecMaster
	 * @param ecMarkingXmlItem
	 * @throws Exception
	 */
	private void publish(EcMarking ecMarking, EcMaster ecMaster, EcMarkingXmlItem ecMarkingXmlItem) throws Exception {
		if (null == ecMarking || null == ecMaster || null == ecMarkingXmlItem) {
			return;
		}
		JSONObject json = new JSONObject();
		json.put("a", ecMarking.getEc_enterprise_id());
		json.put("b", ecMarking.getEc_model_no());
		json.put("c", ecMarking.getEc_marking_title());
		json.put("d", ecMarking.getEc_marking_recordno());
		json.put("e", ecMarking.getEc_marking_level());
		json.put("f", ecMarking.getEc_marking_bulletintime());
		json.put("g", ecMarking.getEc_unit_ismaster());
		json.put("h", ecMarking.getEc_master_id());
		json.put("i", ecMarking.getId());
		json.put("j", ecMaster.getEc_master_chang());
		if (StringUtils.isNullOrEmpty(ecMaster.getEc_master_parentid())) {
			json.put("k", "");
		} else {
			json.put("k", ecMaster.getEc_master_parentid());
		}
		json.put("data", getPubData(ecMarking, ecMarkingXmlItem));
		log.info("同步公告请求数据：" + json.toJSONString());

		String strCode = "updatePubData" + ecMarking.getEc_enterprise_id() + "nengxiaobiaoshiwang123456";
		strCode = Encrypt.md5AndSha(strCode);
		String url = this.qrcodeDomain + "energyLabel/updatePubData.json";
		Map<String, String> params = new HashMap<>();
		params.put("a", URLEncoder.encode(json.toJSONString(), "UTF-8"));
		params.put("e", strCode);
		String result = InvokeInterfaceUtils.sendHttpPost(url, params);
		log.info("同步公告请求数据结果：" + result);
		if (!StringUtils.isNullOrEmpty(result) && result.equals("1")) {
			EcMarking bean = ecMarkingDAO.getEcMarkingById(ecMarking.getId());
			bean.setHas_html(1);// 已生成html
			this.ecMarkingDAO.updateEcMarking(bean);
		} else {
			log.error("公告同步发码平台失败id=" + ecMarking.getId());
		}
	}

	// 获取同步公告数据
	private String getPubData(EcMarking ecMarking, EcMarkingXmlItem ecMarkingXmlItem) throws Exception {
		if (null == ecMarking || StringUtils.isNullOrEmpty(ecMarking.getEc_model_no())) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		String items = "";
		if (ecMarking.getEc_model_no().equals("47")) {
			items = "C1,C14,C25,C27,C29,C30,C34,C35,C39,C40,C124,C126,C8,C200";
		} else if (ecMarking.getEc_model_no().equals("33")) {
			items = "C1,C5,C25,C6,C37,C7,C42,C200";
		} else if (ecMarking.getEc_model_no().equals("31")) {
			items = "C1,C7,C9,C11,C29,C30,C200";
		} else if (ecMarking.getEc_model_no().equals("23")) {
			items = "C1,C6,C9,C12,C200";
		}
		Method method = null;
		for (String c : items.split(",")) {
			method = ecMarkingXmlItem.getClass().getMethod("get" + c);
			sb.append(",").append(c).append(":").append((String) method.invoke(ecMarkingXmlItem));
		}
		if (sb.length() > 0) {
			return sb.substring(1);
		}
		return null;
	}
	
//    public static String[] getModelnoStr(String modelNo) {
//        String modelnoString = "";
//        if ("1".equals(modelNo)) {
//            modelnoString = "C1:,C10:,C8:,C14:,C6:,C12:";
//        } else if ("2".equals(modelNo)) {
//            modelnoString = "C1:,C8:,C6:,C10:";
//        } else if ("3".equals(modelNo)) {
//            modelnoString = "C1:,C7:,C9:,C11:,C13:";
//        } else if ("5".equals(modelNo)) {
//            modelnoString = "C1:,C8:,C7:,C6:";
//        } else if ("10".equals(modelNo)) {
//            modelnoString = "C1:,C5:,C6:,C7:";
//        } else if ("11".equals(modelNo)) {
//            modelnoString = "C1:,C5:,C6:,C200:";
//        } else if ("13".equals(modelNo)) {
//            modelnoString = "C1:,C5:,C6:,C200:";
//        } else if ("14".equals(modelNo)) {
//            modelnoString = "C1:,C31:,C7:,C9:,C200:";
//        } else if ("16".equals(modelNo)) {
//            modelnoString = "C1:,C5:,C9:,C7:,C22:,C200:";
//        } else if ("17".equals(modelNo)) {
//            modelnoString = "C1:,C5:,C7:,C200:";
//        } else if ("20".equals(modelNo)) {
//            modelnoString = "C1:,C6:,C9:,C12:,C39:,C15:,C43:,C18:,C47:,C21:,C51:,C24:,C55:,C27:,C59:,C30:,C76:,C200:";
//        } else if ("23".equals(modelNo)) {
//            modelnoString = "C1:,C6:,C9:,C12:,C200:";
//        } else if ("24".equals(modelNo)) {
//            modelnoString = "C1:,C16:,C7:,C5:";
//        } else if ("25".equals(modelNo)) {
//            modelnoString = "C1:,C5:,C7:,C9:,C11:,C200:";
//        } else if ("26".equals(modelNo)) {
//            modelnoString = "C1:,C76:,C8:,C200:";
//        } else if ("31".equals(modelNo)) {
//            modelnoString = "C1:,C7:,C9:,C11:,C29:,C30:,C200:";
//        } else if ("33".equals(modelNo)) {
//            modelnoString = "C1:,C5:,C25:,C6:,C37:,C7:,C42:,C200:";
//        } else if ("34".equals(modelNo)) {
//            modelnoString = "C1:,C16:,C5:,C7:,C9:,C11:,C200:";
//        } else if ("37".equals(modelNo)) {
//            modelnoString = "C1:,C7:,C10:,C13:,C200:";
//        } else if ("39".equals(modelNo)) {
//            modelnoString = "C1:,C6:,C9:,C12:,C15:,C18:,C200:";
//        } else if ("40".equals(modelNo)) {
//            modelnoString = "C1:,C5:,C6:,C200:";
//        } else if ("38_1".equals(modelNo) || "38_2".equals(modelNo) || "38_3".equals(modelNo) || "38_4".equals(modelNo)) {
//            modelnoString = "C1:,C7:,C11:,C200:";
//        } /*else if ("38_2".equals(modelNo)) {
//            modelnoString = "C1:,C7:,C17:,C200:";
//        } else if ("38_3".equals(modelNo)) {
//            modelnoString = "C1:,C7:,C23:,C200:";
//        } else if ("38_4".equals(modelNo)) {
//            modelnoString = "C1:,C7:,C29:,C200:";
//        } */ else if ("38_5".equals(modelNo) || "38_6".equals(modelNo) || "38_7".equals(modelNo)) {
//            modelnoString = "C1:,C7:,C35:,C38:,C41:,C44:,C200:";
//        } /*else if ("38_6".equals(modelNo)) {
//            modelnoString = "C1:,C7:,C50:,C53:,C56:,C59:,C200:";
//        } else if ("38_7".equals(modelNo)) {
//            modelnoString = "C1:,C7:,C65:,C68:,C71:,C74:,C200:";
//        } */ else if ("41".equals(modelNo)) {
//            modelnoString = "C1:,C8:,C11:,C200:";
//        } else if ("42".equals(modelNo)) {
//            modelnoString = "C1:,C8:,C11:,C18:,C200:";
//        } else if ("43".equals(modelNo)) {
//            modelnoString = "C1:,C8:,C11:,C14:,C17:,C20:,C23:,C200:";
//        } else if ("44".equals(modelNo)) {
//            modelnoString = "C1:,C9:,C12:,C15:,C18:,C21:,C49:,C200:";
//        } else if ("45".equals(modelNo)) {
//            //新16类产品添加二维码
//            modelnoString = "C1:,C9:,C10:,C11:,C13:,C200:";
//        } else if ("46".equals(modelNo)) {
//            modelnoString = "C1:,C8:,C9:,C11:,C12:,C200:";
//        } else if ("47".equals(modelNo)) {
//            modelnoString = "C1:,C14:,C25:,C27:,C8:,C29:,C30:,C34:,C35:,C39:,C40:,C124:,C126:,C200:";
//        } else if ("48".equals(modelNo)) {
//            modelnoString = "C1:,C8:,C14:,C17:,C11:,C20:,C23:,C200:";
//        } else if ("49".equals(modelNo)) {
//            modelnoString = "C1:,C8:,C11:,C15:,C200:";
//        } else if ("4".equals(modelNo)) {
//            modelnoString = "C1:,C6:,C8:,C10:,C200:";
//        } else if ("6".equals(modelNo)) {
//            modelnoString = "C1:,C6:,C7:,C200:";
//        } else if ("8".equals(modelNo)) {
//            modelnoString = "C1:,C7:,C5:,C6:,C200:";
//        } else if ("9".equals(modelNo)) {
//            modelnoString = "C1:,C6:,C7:,C12:,C10:,C13:,C11:,C200:";
//        } else if ("12".equals(modelNo)) {
//            modelnoString = "C1:,C7:,C6:,C5:,C200:";
//        } else if ("15".equals(modelNo)) {
//            modelnoString = "C1:,C5:,C6:,C200:";
//        } else if ("19".equals(modelNo)) {
//            modelnoString = "C1:,C5:,C200:";
//        } else if ("27".equals(modelNo)) {
//            modelnoString = "C1:,C5:,C8:,C11:,C200:";
//        } else if ("30".equals(modelNo)) {
//            modelnoString = "C1:,C5:,C15:,C200:";
//        } else if ("29".equals(modelNo)) {
//            modelnoString = "C1:,C5:,C200:";
//        } else if ("28".equals(modelNo)) {
//            modelnoString = "C1:,C5:,C7:,C9:,C13:,C200:";
//        } else if ("7".equals(modelNo)) {
//            modelnoString = "C1:,C19:,C12:,C14:,C200:";
//        } else if ("21".equals(modelNo)) {
//            modelnoString = "C1:,C11:,C13:,C200:";
//        } else if ("18".equals(modelNo)) {
//            modelnoString = "C1:,C5:,C7:,C200:";
//        } else if ("22".equals(modelNo)) {
//            modelnoString = "C1:,C5:,C7:,C200:";
//        } else if ("32".equals(modelNo)) {
//            modelnoString = "C1:,C7:,C6:,C8:,C200:";
//        } else if ("50".equals(modelNo)) {
//            modelnoString = "C1:,C8:,C7:,C5:,C6:,C200:";
//        } else if ("51".equals(modelNo)) {
//            modelnoString = "C1:,C5:,C7:,C9:,C22:,C200:";
//        } else if ("52".equals(modelNo)) {
//            modelnoString = "C1:,C5:,C7:,C9:,C11:,C200:";
//        } else if ("53".equals(modelNo)) {
//            modelnoString = "C1:,C7:,C10:,C13:,C200:";
//        } else if ("54".equals(modelNo)) {
//            modelnoString = "C1:,C6:,C9:,C12:,C32:,C36:,C200:";
//        }
//        String[] modelNoSTR = modelnoString.split(",", -1);
//        return modelNoSTR;
//    }

	/**
	 * 获取用户能效信息
	 * 
	 * @param userId
	 * @return
	 */
	private EnergyLabelUser getEnergyLabelUser(String userId) {
		EnergyLabelUser user = userService.getEnergyLabelUser(Integer.parseInt(userId));
		return user;
	}

	/**
	 * 获取序列号
	 * 
	 * @param tableName
	 * @return
	 * @throws Exception
	 */
	private String getSeq(String tableName) throws Exception {
		String url = this.beianDomain;// 获取next_id
		if (tableName.equals("EC_MARKING")) {
			url += "fast/getNewEcMarkingId.do";
		} else if (tableName.equals("EC_MASTER")) {
			url += "fast/getNewEcMasterId.do";
		} else if (tableName.equals("PRE_NUM")) {
			url += "fast/getPreNum.do";
		} else {
			url += "fast/getNewEcMarkingAttacheId.do";
		}
		return HttpsUtils.get(url);
	}

	/**
	 * 获取uid
	 * 
	 * @throws Exception
	 */
	private String getUid(EcMarkingXmlItem ecMarkingXmlItem, EcMarking ecMarking, String ecMasterChang,
			EnergyLabelUser user) throws Exception {
		String re = getTemplateItems(ecMarking.getPtid(), ecMarking.getPltId());
		log.info("模板信息:" + re);
		if (!StringUtils.isNullOrEmpty(re)) {
			Map<String, String> valueMap = new HashMap<String, String>();
			JSONArray array = JSONArray.parseArray(re);
			JSONObject json = null;
			String attrNames = "";
			String attrIds = "";
			Method method = null;
			for (Object o : array) {
				json = (JSONObject) o;
				attrNames += "," + json.getString("attrCode");
				attrIds += "," + json.getString("id");
				method = ecMarkingXmlItem.getClass().getMethod("get" + json.getString("attrCode"));
				valueMap.put(json.getString("attrCode"), (String) method.invoke(ecMarkingXmlItem));// 添加模板属性值
			}
			if (attrNames.length() > 0) {
				attrNames = attrNames.substring(1);
			}
			if (attrIds.length() > 0) {
				attrIds = attrIds.substring(1);
			}
			valueMap.put("ptid", "" + ecMarking.getPtid());
			valueMap.put("pltId", "" + ecMarking.getPltId());
			valueMap.put("eid", String.valueOf(user.getEid()));
			valueMap.put("model", ecMarking.getEc_marking_title());
			valueMap.put("typeCode", "T" + ecMarking.getEc_model_no());
			valueMap.put("energyGrade", String.valueOf(ecMarking.getEc_marking_level()));
			valueMap.put("attrNames", attrNames);
			valueMap.put("attrIds", attrIds);
			valueMap.put("labelShowname", ecMarkingXmlItem.getC1());// 生产者名称
			valueMap.put("ename", user.getEname());
			valueMap.put("applyStyle", ecMasterChang);
			valueMap.put("preNum", ecMarking.getEc_prelimno());
			String url = this.qrcodeDomain + "energyLabel/insertRecordAndReturnUid.json";
			re = InvokeInterfaceUtils.sendHttpPost(url, valueMap);
			log.info("UID=" + re);
			if (!StringUtils.isNullOrEmpty(re) && re.length() == 5) {
				return re;
			}
		}
		throw new Exception("操作失败");
	}

	/**
	 * 保存附件
	 * 
	 * @param attach_list
	 * @param ecMarking
	 * @param ecMasterChang
	 * @throws Exception
	 */
	private void saveAttachList(String attach_list, EcMarking ecMarking, String uid) throws Exception {
		EcMarkingAttach attach = null;
		if (!StringUtils.isNullOrEmpty(attach_list)) {
			// 删除附件
			this.ecMarkingAttachDAO.delByEcMarkingId(ecMarking.getId());
			// 保存附件
			JSONArray array = JSONArray.parseArray(attach_list);
			for (Object obj : array) {
				if (obj != null) {
					attach = JSONObject.parseObject(obj.toString(), EcMarkingAttach.class);
					if (null != attach) {
						// Ec_marking_attach表数据存储
						if (null != uid && attach.getEc_attach_id().equals("25")
								&& !this.customPltId.contains(String.valueOf(ecMarking.getPltId()))) {// 排除自定义模板
							String url = getElImgUrl(uid);
							if (!StringUtils.isNullOrEmpty(url)) {
								attach.setEc_attach_path(url);
								attach.setEc_attach_originalname(uid + url.substring(url.lastIndexOf(".")));
								attach.setEc_attach_file(attach.getEc_attach_originalname());
							}
						}
						attach.setEc_marking_attach_id(getSeq("EC_MARKING_ATTACH"));
						attach.setEc_marking_id(String.valueOf(ecMarking.getId()));
						attach.setEc_attach_uploaduserid(ecMarking.getEc_marking_userid());
						attach.setEc_attach_uploadtime(new Date());
						attach.setEc_attach_active("0");
						ecMarkingAttachDAO.insertEcMarkingAttach(attach);
					}
				}
			}
		}
	}

	/**
	 * 获取能效标识图url
	 * 
	 * @param uid
	 * @return
	 */
	private String getElImgUrl(String uid) {
		String url = "";
		if (!StringUtils.isNullOrEmpty(uid) && uid.length() == 5) {
			url = this.qrcodeImgRoot + "label/" + uid.substring(uid.length() - 2) + "/" + uid + "/" + uid + ".png";
		}
		return url;
	}

	@Override
	public PageInfo<Marking> list(int pageSize, int pageNum, Map<String, Object> map, String userId) throws Exception {
		PageInfo<Marking> page = null;
		EnergyLabelUser labUser = getEnergyLabelUser(userId);
		if (null != labUser) {
			map.put("user_id", labUser.getEnergyLabeluserId());
			PageHelper.startPage(pageNum, pageSize);
			List<Marking> list = ecMarkingDAO.list(map);
			if (null != list && !list.isEmpty()) {
				int count = 0;
				for (Marking bean : list) {
					// 扩展判断
					bean.setKz(1);
					if (bean.getType().equals(MakingConstants.Making_Type_Expand)) { // 扩展
						bean.setKz(0);// 扩展类型的数据不能扩展
						bean.setType_name("扩展");
					} else if (bean.getType().equals(MakingConstants.Making_Type_Change)) {
						bean.setType_name("变更");
					} else if (bean.getType().equals(MakingConstants.Making_Type_Expand_Change)) {
						bean.setType_name("变更");
					} else {
						bean.setType_name("新备案");
					}
					// 变更判断
					count = this.ecMasterDAO.countChildEcMaster(bean.getId(), MakingConstants.Making_Type_Change);
					if (count > 0) {
						bean.setBg(0);// A已经变更过，就不能再变更
					} else {
						bean.setBg(1);
					}
				}
			}
			page = new PageInfo<Marking>(list);
		}
		return page;
	}

	@Override
	public PageInfo<Marking> draftList(int pageSize, int pageNum, Map<String, Object> map, String userId)
			throws Exception {
		PageInfo<Marking> page = null;
		EnergyLabelUser labUser = getEnergyLabelUser(userId);
		if (null != labUser) {
			map.put("user_id", labUser.getEnergyLabeluserId());
			PageHelper.startPage(pageNum, pageSize);
			List<Marking> list = ecMarkingDAO.draftList(map);
			page = new PageInfo<Marking>(list);
		}
		return page;
	}

	@Override
	public Map<String, Object> getDraft2Map(int id) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		EcMarking bean = ecMarkingDAO.getEcMarkingById(id);
		if (null == bean) {
			return map;
		}
		// 1.备案信息
		map.put("marking", bean);
		// 2.C值
		map.put("data", this.getXml2Map(id));
		// 3.附件
		map.put("attachList", getAttachVOList(id));// 附件信息
		// 4.实验室数据
		map.put("lab", labService.getReport(bean.getEc_labreport_no()).get("msg"));
		return map;
	}

	@Override
	public Map<String, Object> getInfo2Map(int id) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		EcMarking bean = ecMarkingDAO.getEcMarkingById(id);
		if (null == bean) {
			return map;
		}
		// 1.备案信息
		map.put("marking", bean);
		// 2.C值
		map.put("data", this.getXml2Map(id));
		// 3.附件
		map.put("attachList", this.getAttachVOList(id));// 附件信息
		return map;
	}

	@Override
	public Map<String, Object> getInfoWithoutAttach2Map(int id) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		EcMarking bean = ecMarkingDAO.getEcMarkingById(id);
		if (null == bean) {
			return map;
		}
		// 1.备案信息
		map.put("marking", bean);
		// 2.C值
		map.put("data", this.getXml2Map(id));
		return map;
	}

	/**
	 * xml中获取c值
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	private Map<String, Object> getXml2Map(int id) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		String xml = ecMarkingXmlDAO.getMarkingXml(id);
		if (!StringUtils.isNullOrEmpty(xml)) {
			Document document = DocumentHelper.parseText(xml);
			Element root = document.getRootElement();
			Element item;
			for (Iterator<?> iterator = root.elementIterator("Item"); iterator.hasNext();) {
				item = (Element) iterator.next();
				map.put(item.attributeValue("ID").toLowerCase(), item.getText());
			}
			// 处理初始使用日期
			String c20 = (String) map.get("c20");
			if (c20 != null) {
				map.put("c20", DateUtils.getStr2Date(c20));
			}
		}
		return map;
	}

	/**
	 * 获取附件列表
	 * 
	 * @param id
	 * @return
	 */
	private List<EcMarkingAttachVO> getAttachVOList(int id) {
		List<EcMarkingAttach> attachList = this.ecMarkingAttachDAO.getEcMarkingAttachList(id);
		List<EcMarkingAttachVO> list = null;
		if (null != attachList && !attachList.isEmpty()) {
			list = new ArrayList<EcMarkingAttachVO>(attachList.size());
			EcMarkingAttachVO vo = null;
			for (EcMarkingAttach attach : attachList) {
				vo = new EcMarkingAttachVO();
				vo.setEc_marking_attach_id(attach.getEc_marking_attach_id());
				vo.setEc_attach_file(attach.getEc_attach_file());
				vo.setEc_attach_id(attach.getEc_attach_id());
				vo.setEc_attach_originalname(attach.getEc_attach_originalname());
				vo.setEc_attach_path(attach.getEc_attach_path());
				list.add(vo);
			}
		}
		return list;
	}

	@Override
	public boolean uploadQrcode(int id, EcMarkingAttach attach, String userId) throws Exception {
		// 用户信息
		EnergyLabelUser labUser = this.getEnergyLabelUser(userId);
		if (labUser == null) {
			return false;
		}
		EcMarking bean = ecMarkingDAO.getEcMarkingById(id);
		if (bean != null && attach != null) {
			EcMarkingAttach attach25 = ecMarkingAttachDAO.getEcMarkingAttach25(id);
			if (attach25 != null) {
				attach25.setEc_attach_path(attach.getEc_attach_path());
				attach25.setEc_attach_file(attach.getEc_attach_file());
				attach25.setEc_attach_originalname(attach.getEc_attach_originalname());
				attach25.setEc_attach_uploadtime(new Date());
				ecMarkingAttachDAO.updateEcMarkingAttach(attach25);
			} else {
				attach.setEc_marking_attach_id(getSeq("EC_MARKING_ATTACH"));
				attach.setEc_marking_id(String.valueOf(bean.getId()));
				attach.setEc_attach_uploaduserid(bean.getEc_marking_userid());
				attach.setEc_attach_uploadtime(new Date());
				attach.setEc_attach_active("0");
				ecMarkingAttachDAO.insertEcMarkingAttach(attach);
			}
			bean.setState(3);// 数据同步中
			ecMarkingDAO.updateEcMarking(bean);
			return true;
		}
		return false;
	}

	@Override
	public String downloadQrcode(int id) throws Exception {
		EcMarking bean = ecMarkingDAO.getEcMarkingById(id);
		if (bean == null) {
			return "";
		}
		String uid = bean.getEc_qycode_key();
		if (!StringUtils.isNullOrEmpty(uid)) {
			String url = this.qrcodeImgRoot + "qrcode/" + uid.substring(uid.length() - 2) + "/" + uid + "/" + uid
					+ ".png";
			return url;
		}
		return "";
	}

	@Override
	public String downloadELImg(int id) throws Exception {
		EcMarking bean = ecMarkingDAO.getEcMarkingById(id);
		if (bean == null) {
			return "";
		}
		EcMarkingAttach attach25 = ecMarkingAttachDAO.getEcMarkingAttach25(id);
		if (attach25 != null && !StringUtils.isNullOrEmpty(attach25.getEc_attach_path())) {
			return attach25.getEc_attach_path();
		}
		return this.getElImgUrl(bean.getEc_qycode_key());
	}

	@Override
	public String getTemplateItems(int ptid, int pltId) throws Exception {
		String url = this.qrcodeDomain + "energyLabel/apply/getProdTypeAttrs.json";// 获取模板属性
		Map<String, String> valueMap = new HashMap<String, String>();
		valueMap.put("ptid", String.valueOf(ptid));
		valueMap.put("pltId", String.valueOf(pltId));
		String re = InvokeInterfaceUtils.sendHttpGet(url, valueMap);
		if (StringUtils.isNullOrEmpty(re)) {
			re = "";
		}
		return re;
	}
}
