package com.energylabel.lab.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.Data;

/**
 * @author liuyong
 * @datetime 2019/2/25 14:31
 */
@Data
public class Report {
    private BigDecimal rid;
    private String barcode;
    private BigDecimal modelNo;
    private String labName;
    private Date upddate;
    // 实验室报告可以使用的备案模板
    private Integer[] templates;

    private List<ReportParamValue> params;

    public static void main(String[] args) {
        String str = "T01;ST02;N03;SN04";
        String regEx ="[0-9]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		System.out.println(m.replaceAll("").trim());
    }
}
