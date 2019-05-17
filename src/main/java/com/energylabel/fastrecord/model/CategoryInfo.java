package com.energylabel.fastrecord.model;

public class CategoryInfo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4237812811975505953L;
	private int ec_model_id;
	private String ec_model_title;
	private int ec_model_no;
	private int ec_model_dengji;
	private String ec_model_isunit;
	private int ec_model_labcid;
	private String ec_model_gb;

	public int getEc_model_id() {
		return ec_model_id;
	}

	public void setEc_model_id(int ec_model_id) {
		this.ec_model_id = ec_model_id;
	}

	public String getEc_model_title() {
		return ec_model_title;
	}

	public void setEc_model_title(String ec_model_title) {
		this.ec_model_title = ec_model_title;
	}

	public int getEc_model_no() {
		return ec_model_no;
	}

	public void setEc_model_no(int ec_model_no) {
		this.ec_model_no = ec_model_no;
	}

	public int getEc_model_dengji() {
		return ec_model_dengji;
	}

	public void setEc_model_dengji(int ec_model_dengji) {
		this.ec_model_dengji = ec_model_dengji;
	}

	public String getEc_model_isunit() {
		return ec_model_isunit;
	}

	public void setEc_model_isunit(String ec_model_isunit) {
		this.ec_model_isunit = ec_model_isunit;
	}

	public int getEc_model_labcid() {
		return ec_model_labcid;
	}

	public void setEc_model_labcid(int ec_model_labcid) {
		this.ec_model_labcid = ec_model_labcid;
	}

	public String getEc_model_gb() {
		return ec_model_gb;
	}

	public void setEc_model_gb(String ec_model_gb) {
		this.ec_model_gb = ec_model_gb;
	}
}
