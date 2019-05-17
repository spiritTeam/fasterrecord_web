package com.energylabel.fastrecord.model;

import java.util.Date;

public class EcMaster {
	private String ec_master_id;
	private String ec_master_chang = null; // 0：主型号 1：扩展 2：变更
	private String ec_master_userid;
	private Date ec_master_addtime = null;
	private String ec_marking_count;
	private String ec_model_no;
	private String ec_master_name = null;
	private String ec_master_parentid;
	private String ec_master_biangeng_text = "";
	private String ec_master_kuozhan_text = "";
	private String ec_master_bgkz_main_bulletin = "0";

	public String getEc_master_id() {
		return ec_master_id;
	}

	public void setEc_master_id(String ec_master_id) {
		this.ec_master_id = ec_master_id;
	}

	public String getEc_master_chang() {
		return ec_master_chang;
	}

	public void setEc_master_chang(String ec_master_chang) {
		this.ec_master_chang = ec_master_chang;
	}

	public String getEc_master_userid() {
		return ec_master_userid;
	}

	public void setEc_master_userid(String ec_master_userid) {
		this.ec_master_userid = ec_master_userid;
	}

	public Date getEc_master_addtime() {
		return ec_master_addtime;
	}

	public void setEc_master_addtime(Date ec_master_addtime) {
		this.ec_master_addtime = ec_master_addtime;
	}

	public String getEc_marking_count() {
		return ec_marking_count;
	}

	public void setEc_marking_count(String ec_marking_count) {
		this.ec_marking_count = ec_marking_count;
	}

	public String getEc_model_no() {
		return ec_model_no;
	}

	public void setEc_model_no(String ec_model_no) {
		this.ec_model_no = ec_model_no;
	}

	public String getEc_master_name() {
		return ec_master_name;
	}

	public void setEc_master_name(String ec_master_name) {
		this.ec_master_name = ec_master_name;
	}

	public String getEc_master_parentid() {
		return ec_master_parentid;
	}

	public void setEc_master_parentid(String ec_master_parentid) {
		this.ec_master_parentid = ec_master_parentid;
	}

	public String getEc_master_biangeng_text() {
		return ec_master_biangeng_text;
	}

	public void setEc_master_biangeng_text(String ec_master_biangeng_text) {
		this.ec_master_biangeng_text = ec_master_biangeng_text;
	}

	public String getEc_master_kuozhan_text() {
		return ec_master_kuozhan_text;
	}

	public void setEc_master_kuozhan_text(String ec_master_kuozhan_text) {
		this.ec_master_kuozhan_text = ec_master_kuozhan_text;
	}

	public String getEc_master_bgkz_main_bulletin() {
		return ec_master_bgkz_main_bulletin;
	}

	public void setEc_master_bgkz_main_bulletin(String ec_master_bgkz_main_bulletin) {
		this.ec_master_bgkz_main_bulletin = ec_master_bgkz_main_bulletin;
	}
}
