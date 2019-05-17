package com.energylabel.fastrecord.vo;

/**
 * 备案附件表k 类名称：EcMarkingAttach
 */
public class EcMarkingAttachVO {

	private String ec_marking_attach_id; // 表id
	private String ec_attach_id; // 附件类型id
	private String ec_attach_file; // 附件文件名
	private String ec_attach_originalname;// 原文件名
	private String ec_attach_path; // 文件库内位置
	
	public String getEc_marking_attach_id() {
		return ec_marking_attach_id;
	}
	public void setEc_marking_attach_id(String ec_marking_attach_id) {
		this.ec_marking_attach_id = ec_marking_attach_id;
	}
	public String getEc_attach_id() {
		return ec_attach_id;
	}
	public void setEc_attach_id(String ec_attach_id) {
		this.ec_attach_id = ec_attach_id;
	}
	public String getEc_attach_file() {
		return ec_attach_file;
	}
	public void setEc_attach_file(String ec_attach_file) {
		this.ec_attach_file = ec_attach_file;
	}
	public String getEc_attach_originalname() {
		return ec_attach_originalname;
	}
	public void setEc_attach_originalname(String ec_attach_originalname) {
		this.ec_attach_originalname = ec_attach_originalname;
	}
	public String getEc_attach_path() {
		return ec_attach_path;
	}
	public void setEc_attach_path(String ec_attach_path) {
		this.ec_attach_path = ec_attach_path;
	}
}
