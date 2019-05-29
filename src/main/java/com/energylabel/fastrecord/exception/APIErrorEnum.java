package com.energylabel.fastrecord.exception;

/**
 * Created by LiuYong on 2018/6/4 9:56
 */
public enum APIErrorEnum {
	UNKNOWN_ERROR("A00000", "未知错误！"), 
	FILE_UPLOAD_ERROR("A00001", "文件上传失败！"), 
	REQUEST_BODY_IS_NULL_ERROR("A00010", "请求body为空！");

	private String code;
	private String desc;

	APIErrorEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}
}