package com.energylabel.lab.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.energylabel.lab.model.Report;
import com.energylabel.lab.model.ReportParamValue;

/**
 * @author liuyong
 * @datetime 2019/2/25 13:36
 */
public interface LabDAO {
	Report getReport(@Param("barcode") String barcode);

	List<ReportParamValue> getReportParamValues(@Param("barcode") String barcode,
			@Param("categoryid") BigDecimal categoryid);

	/**
	 * 查看一个实验室条码是否已经做过“主型号”备案
	 * 返回0为没做过，大于0为做过
	 * 正常来说，一个实验室报告只可能做一次“主型号”备案
	 * @param barcode
	 * @return
	 */
	Integer count1(@Param("barcode") String barcode);
}
