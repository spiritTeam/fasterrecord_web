package com.energylabel.lab.model;

import lombok.Data;

/**
 * @author liuyong
 * @datetime 2019/2/25 13:54
 */
@Data
public class ReportParamValue {
    public ReportParamValue() {
    }

    public ReportParamValue(String recId, String labValue) {
        this.recId = recId;
        this.labValue = labValue;
    }

    private String recId;
    private String recName;
    private String labValue;
}
