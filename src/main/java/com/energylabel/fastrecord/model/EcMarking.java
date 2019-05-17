package com.energylabel.fastrecord.model;

import java.util.Date;

public class EcMarking implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3372096969623862571L;
	private int id;
	private int state;
	private int has_html;
	private int ptid;
	private int pltId;
	private String ec_marking_recordno = null;
	private String ec_marking_nopassreason = null;
	private String ec_marking_nopassmemo = null;
	private String ec_marking_userid = null;
	private String ec_marking_title = null;
	private String ec_model_no;
	private String ec_marking_old = null;
	private String ec_marking_level = null;
	private String ec_tingchan = "0";
	private Date ec_tingchandate = null;
	private String ec_master_id;
	private String ec_marking_ispass = null;
	private String ec_marking_passman = null;
	private Date ec_marking_passtime = null;
	private String ec_marking_bulletin = null;
	private Date ec_marking_bulletintime = null;
	private String ec_marking_bulletinuserid = null;
	private String ec_marking_ishidden = "0";
	private Date ec_marking_ishiddentime = null;
	private String ec_marking_ishiddenuserid = null;
	private String ec_marking_isdeleted = "0";
	private Date ec_marking_isdeletedtime = null;
	private String ec_marking_isdeleteduserid = null;
	private String ec_marking_fileno = null;
	private Date ec_marking_filenotime = null;
	private String ec_marking_filenouserid = null;
	private Date ec_marking_addtime = null;
	private String ec_unit_ismaster = null;

	private String ec_labname = null;
	private String ec_labreport_no = null;
	private String ec_labreport_id = null;

	private String ec_marking_pacemaker = null;
	private Date ec_marking_receive_date = null;
	private String ec_marking_receive_userid = null;
	private String ec_marking_hmgc_lock = "0";
	private String ec_qycode_key = null;

	// dongjie
	private String ec_prelimno = null;
	private String username;

	private String ec_model_labcid;

	// dongjie

	// 数据迁移字段
	private String ec_is_move_state;

	// 扩展字段
	private String startTime;
	private String endTime;
	private String startBullTime;
	private String endBullTime;
	private String ec_model_isunit;
	private String indexNo;
	private String enterpriseid;
	// 0917
	private String ec_enterprise_id;

	// 附件字段
	private String ec_master_name = null;
	private String ec_model_name = null;
	private String ec_master_chang = null; // 0:主型号 1:扩展 2：变更
	private String ec_master_parentid = null;
	private String ec_master_kuozhan_text = null;
	private String ec_master_biangeng_text = null;
	private String ec_master_bgkz_main_bulletin = null;
	private String ec_master_chang_style;
	private String ec_master_kuozhan_text_value = null;
	private String ec_master_biangeng_text_value = null;
	private String ec_marking_kz_title;

	// 数据迁移
	private String oldusername;
	private String newusername;

	// 复审功能数据
	private String ec_marking_ispass_review = null;
	private String ec_marking_passman_review = null;
	private String ec_marking_review_datastate = null;
	private Date ec_marking_passtime_review = null;

	// 扩展备案附件
	private String ec_marking_attach23;

	// 停产申请表
	private String ec_stopregain_type;

	// ec_task表数据
	private String ec_task_id;
	private String userid;
	private String ec_task_type;
	private Date ec_task_addtime;
	private String distribute_userid;
	private String ec_task_status;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getHas_html() {
		return has_html;
	}

	public void setHas_html(int has_html) {
		this.has_html = has_html;
	}

	public int getPtid() {
		return ptid;
	}

	public void setPtid(int ptid) {
		this.ptid = ptid;
	}

	public int getPltId() {
		return pltId;
	}

	public void setPltId(int pltId) {
		this.pltId = pltId;
	}

	private String c11kw;
	private String c11kuo;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEc_model_labcid() {
		return ec_model_labcid;
	}

	public void setEc_model_labcid(String ec_model_labcid) {
		this.ec_model_labcid = ec_model_labcid;
	}

	public Date getEc_marking_passtime_review() {
		return ec_marking_passtime_review;
	}

	public void setEc_marking_passtime_review(Date ec_marking_passtime_review) {
		this.ec_marking_passtime_review = ec_marking_passtime_review;
	}

	public String getEc_marking_ispass_review() {
		return ec_marking_ispass_review;
	}

	public void setEc_marking_ispass_review(String ec_marking_ispass_review) {
		this.ec_marking_ispass_review = ec_marking_ispass_review;
	}

	public String getEc_marking_passman_review() {
		return ec_marking_passman_review;
	}

	public void setEc_marking_passman_review(String ec_marking_passman_review) {
		this.ec_marking_passman_review = ec_marking_passman_review;
	}

	public String getEc_marking_review_datastate() {
		return ec_marking_review_datastate;
	}

	public void setEc_marking_review_datastate(String ec_marking_review_datastate) {
		this.ec_marking_review_datastate = ec_marking_review_datastate;
	}

	public void setEc_prelimno(String ec_prelimno) {
		this.ec_prelimno = ec_prelimno;
	}

	public String getEc_prelimno() {
		return ec_prelimno;
	}

	public String getC11kuo() {
		return c11kuo;
	}

	public void setC11kuo(String c11kuo) {
		this.c11kuo = c11kuo;
	}

	public String getC11kw() {
		return c11kw;
	}

	public void setC11kw(String c11kw) {
		this.c11kw = c11kw;
	}

	public String getIndexNo() {
		return indexNo;
	}

	public void setIndexNo(String indexNo) {
		this.indexNo = indexNo;
	}

	public String getEc_master_kuozhan_text_value() {
		return ec_master_kuozhan_text_value;
	}

	public void setEc_master_kuozhan_text_value(String ec_master_kuozhan_text_value) {
		this.ec_master_kuozhan_text_value = ec_master_kuozhan_text_value;
	}

	public String getEc_master_biangeng_text_value() {
		return ec_master_biangeng_text_value;
	}

	public void setEc_master_biangeng_text_value(String ec_master_biangeng_text_value) {
		this.ec_master_biangeng_text_value = ec_master_biangeng_text_value;
	}

	public String getEc_master_chang_style() {
		return ec_master_chang_style;
	}

	public void setEc_master_chang_style(String ec_master_chang_style) {
		this.ec_master_chang_style = ec_master_chang_style;
	}

	public String getEc_master_kuozhan_text() {
		return ec_master_kuozhan_text;
	}

	public void setEc_master_kuozhan_text(String ec_master_kuozhan_text) {
		this.ec_master_kuozhan_text = ec_master_kuozhan_text;
	}

	public String getEc_master_biangeng_text() {
		return ec_master_biangeng_text;
	}

	public void setEc_master_biangeng_text(String ec_master_biangeng_text) {
		this.ec_master_biangeng_text = ec_master_biangeng_text;
	}

	public String getEc_master_bgkz_main_bulletin() {
		return ec_master_bgkz_main_bulletin;
	}

	public void setEc_master_bgkz_main_bulletin(String ec_master_bgkz_main_bulletin) {
		this.ec_master_bgkz_main_bulletin = ec_master_bgkz_main_bulletin;
	}

	public String getEc_stopregain_type() {
		return ec_stopregain_type;
	}

	public void setEc_stopregain_type(String ec_stopregain_type) {
		this.ec_stopregain_type = ec_stopregain_type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEc_marking_recordno() {
		return ec_marking_recordno;
	}

	public void setEc_marking_recordno(String ec_marking_recordno) {
		this.ec_marking_recordno = ec_marking_recordno;
	}

	public String getEc_marking_nopassreason() {
		return ec_marking_nopassreason;
	}

	public void setEc_marking_nopassreason(String ec_marking_nopassreason) {
		this.ec_marking_nopassreason = ec_marking_nopassreason;
	}

	public String getEc_marking_nopassmemo() {
		return ec_marking_nopassmemo;
	}

	public void setEc_marking_nopassmemo(String ec_marking_nopassmemo) {
		this.ec_marking_nopassmemo = ec_marking_nopassmemo;
	}

	public String getEc_marking_userid() {
		return ec_marking_userid;
	}

	public void setEc_marking_userid(String ec_marking_userid) {
		this.ec_marking_userid = ec_marking_userid;
	}

	public String getEc_marking_title() {
		return ec_marking_title;
	}

	public void setEc_marking_title(String ec_marking_title) {
		this.ec_marking_title = ec_marking_title;
	}

	public String getEc_marking_old() {
		return ec_marking_old;
	}

	public void setEc_marking_old(String ec_marking_old) {
		this.ec_marking_old = ec_marking_old;
	}

	public String getEc_marking_level() {
		return ec_marking_level;
	}

	public void setEc_marking_level(String ec_marking_level) {
		this.ec_marking_level = ec_marking_level;
	}

	public String getEc_tingchan() {
		return ec_tingchan;
	}

	public void setEc_tingchan(String ec_tingchan) {
		this.ec_tingchan = ec_tingchan;
	}

	public Date getEc_tingchandate() {
		return ec_tingchandate;
	}

	public void setEc_tingchandate(Date ec_tingchandate) {
		this.ec_tingchandate = ec_tingchandate;
	}

	public String getEc_master_id() {
		return ec_master_id;
	}

	public void setEc_master_id(String ec_master_id) {
		this.ec_master_id = ec_master_id;
	}

	public String getEc_marking_ispass() {
		return ec_marking_ispass;
	}

	public void setEc_marking_ispass(String ec_marking_ispass) {
		this.ec_marking_ispass = ec_marking_ispass;
	}

	public String getEc_marking_passman() {
		return ec_marking_passman;
	}

	public void setEc_marking_passman(String ec_marking_passman) {
		this.ec_marking_passman = ec_marking_passman;
	}

	public Date getEc_marking_passtime() {
		return ec_marking_passtime;
	}

	public void setEc_marking_passtime(Date ec_marking_passtime) {
		this.ec_marking_passtime = ec_marking_passtime;
	}

	public String getEc_marking_bulletin() {
		return ec_marking_bulletin;
	}

	public void setEc_marking_bulletin(String ec_marking_bulletin) {
		this.ec_marking_bulletin = ec_marking_bulletin;
	}

	public Date getEc_marking_bulletintime() {
		return ec_marking_bulletintime;
	}

	public void setEc_marking_bulletintime(Date ec_marking_bulletintime) {
		this.ec_marking_bulletintime = ec_marking_bulletintime;
	}

	public String getEc_marking_bulletinuserid() {
		return ec_marking_bulletinuserid;
	}

	public void setEc_marking_bulletinuserid(String ec_marking_bulletinuserid) {
		this.ec_marking_bulletinuserid = ec_marking_bulletinuserid;
	}

	public String getEc_marking_ishidden() {
		return ec_marking_ishidden;
	}

	public void setEc_marking_ishidden(String ec_marking_ishidden) {
		this.ec_marking_ishidden = ec_marking_ishidden;
	}

	public Date getEc_marking_ishiddentime() {
		return ec_marking_ishiddentime;
	}

	public void setEc_marking_ishiddentime(Date ec_marking_ishiddentime) {
		this.ec_marking_ishiddentime = ec_marking_ishiddentime;
	}

	public String getEc_marking_ishiddenuserid() {
		return ec_marking_ishiddenuserid;
	}

	public void setEc_marking_ishiddenuserid(String ec_marking_ishiddenuserid) {
		this.ec_marking_ishiddenuserid = ec_marking_ishiddenuserid;
	}

	public String getEc_marking_isdeleted() {
		return ec_marking_isdeleted;
	}

	public void setEc_marking_isdeleted(String ec_marking_isdeleted) {
		this.ec_marking_isdeleted = ec_marking_isdeleted;
	}

	public Date getEc_marking_isdeletedtime() {
		return ec_marking_isdeletedtime;
	}

	public void setEc_marking_isdeletedtime(Date ec_marking_isdeletedtime) {
		this.ec_marking_isdeletedtime = ec_marking_isdeletedtime;
	}

	public String getEc_marking_isdeleteduserid() {
		return ec_marking_isdeleteduserid;
	}

	public void setEc_marking_isdeleteduserid(String ec_marking_isdeleteduserid) {
		this.ec_marking_isdeleteduserid = ec_marking_isdeleteduserid;
	}

	public String getEc_marking_fileno() {
		return ec_marking_fileno;
	}

	public void setEc_marking_fileno(String ec_marking_fileno) {
		this.ec_marking_fileno = ec_marking_fileno;
	}

	public Date getEc_marking_filenotime() {
		return ec_marking_filenotime;
	}

	public void setEc_marking_filenotime(Date ec_marking_filenotime) {
		this.ec_marking_filenotime = ec_marking_filenotime;
	}

	public String getEc_marking_filenouserid() {
		return ec_marking_filenouserid;
	}

	public void setEc_marking_filenouserid(String ec_marking_filenouserid) {
		this.ec_marking_filenouserid = ec_marking_filenouserid;
	}

	public Date getEc_marking_addtime() {
		return ec_marking_addtime;
	}

	public void setEc_marking_addtime(Date ec_marking_addtime) {
		this.ec_marking_addtime = ec_marking_addtime;
	}

	public String getEc_unit_ismaster() {
		return ec_unit_ismaster;
	}

	public void setEc_unit_ismaster(String ec_unit_ismaster) {
		this.ec_unit_ismaster = ec_unit_ismaster;
	}

	public String getEc_labname() {
		return ec_labname;
	}

	public void setEc_labname(String ec_labname) {
		this.ec_labname = ec_labname;
	}

	public String getEc_labreport_no() {
		return ec_labreport_no;
	}

	public void setEc_labreport_no(String ec_labreport_no) {
		this.ec_labreport_no = ec_labreport_no;
	}

	public String getEc_labreport_id() {
		return ec_labreport_id;
	}

	public void setEc_labreport_id(String ec_labreport_id) {
		this.ec_labreport_id = ec_labreport_id;
	}

	public Date getEc_marking_receive_date() {
		return ec_marking_receive_date;
	}

	public void setEc_marking_receive_date(Date ec_marking_receive_date) {
		this.ec_marking_receive_date = ec_marking_receive_date;
	}

	public String getEc_marking_receive_userid() {
		return ec_marking_receive_userid;
	}

	public void setEc_marking_receive_userid(String ec_marking_receive_userid) {
		this.ec_marking_receive_userid = ec_marking_receive_userid;
	}

	public String getEc_marking_hmgc_lock() {
		return ec_marking_hmgc_lock;
	}

	public void setEc_marking_hmgc_lock(String ec_marking_hmgc_lock) {
		this.ec_marking_hmgc_lock = ec_marking_hmgc_lock;
	}

	public String getEc_qycode_key() {
		return ec_qycode_key;
	}

	public void setEc_qycode_key(String ec_qycode_key) {
		this.ec_qycode_key = ec_qycode_key;
	}

	public String getEc_model_no() {
		return ec_model_no;
	}

	public void setEc_model_no(String ec_model_no) {
		this.ec_model_no = ec_model_no;
	}

	public String getEc_master_parentid() {
		return ec_master_parentid;
	}

	public void setEc_master_parentid(String ec_master_parentid) {
		this.ec_master_parentid = ec_master_parentid;
	}

	public String getEc_master_name() {
		return ec_master_name;
	}

	public void setEc_master_name(String ec_master_name) {
		this.ec_master_name = ec_master_name;
	}

	public String getEc_model_name() {
		return ec_model_name;
	}

	public void setEc_model_name(String ec_model_name) {
		this.ec_model_name = ec_model_name;
	}

	public String getEc_master_chang() {
		return ec_master_chang;
	}

	public void setEc_master_chang(String ec_master_chang) {
		this.ec_master_chang = ec_master_chang;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getStartBullTime() {
		return startBullTime;
	}

	public void setStartBullTime(String startBullTime) {
		this.startBullTime = startBullTime;
	}

	public String getEndBullTime() {
		return endBullTime;
	}

	public void setEndBullTime(String endBullTime) {
		this.endBullTime = endBullTime;
	}

	public String getEc_marking_attach23() {
		return ec_marking_attach23;
	}

	public void setEc_marking_attach23(String ec_marking_attach23) {
		this.ec_marking_attach23 = ec_marking_attach23;
	}

	public String getEc_model_isunit() {
		return ec_model_isunit;
	}

	public void setEc_model_isunit(String ec_model_isunit) {
		this.ec_model_isunit = ec_model_isunit;
	}

	public String getEnterpriseid() {
		return enterpriseid;
	}

	public void setEnterpriseid(String enterpriseid) {
		this.enterpriseid = enterpriseid;
	}

	public String getEc_enterprise_id() {
		return ec_enterprise_id;
	}

	public void setEc_enterprise_id(String ec_enterprise_id) {
		this.ec_enterprise_id = ec_enterprise_id;
	}

	public String getOldusername() {
		return oldusername;
	}

	public void setOldusername(String oldusername) {
		this.oldusername = oldusername;
	}

	public String getNewusername() {
		return newusername;
	}

	public void setNewusername(String newusername) {
		this.newusername = newusername;
	}

	public String getEc_task_id() {
		return ec_task_id;
	}

	public void setEc_task_id(String ec_task_id) {
		this.ec_task_id = ec_task_id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getEc_task_type() {
		return ec_task_type;
	}

	public void setEc_task_type(String ec_task_type) {
		this.ec_task_type = ec_task_type;
	}

	public Date getEc_task_addtime() {
		return ec_task_addtime;
	}

	public void setEc_task_addtime(Date ec_task_addtime) {
		this.ec_task_addtime = ec_task_addtime;
	}

	public String getDistribute_userid() {
		return distribute_userid;
	}

	public void setDistribute_userid(String distribute_userid) {
		this.distribute_userid = distribute_userid;
	}

	public String getEc_task_status() {
		return ec_task_status;
	}

	public void setEc_task_status(String ec_task_status) {
		this.ec_task_status = ec_task_status;
	}

	public String getEc_marking_kz_title() {
		return ec_marking_kz_title;
	}

	public void setEc_marking_kz_title(String ec_marking_kz_title) {
		this.ec_marking_kz_title = ec_marking_kz_title;
	}

	public String getEc_is_move_state() {
		return ec_is_move_state;
	}

	public void setEc_is_move_state(String ec_is_move_state) {
		this.ec_is_move_state = ec_is_move_state;
	}

	public String getEc_marking_pacemaker() {
		return ec_marking_pacemaker;
	}

	public void setEc_marking_pacemaker(String ec_marking_pacemaker) {
		this.ec_marking_pacemaker = ec_marking_pacemaker;
	}
}