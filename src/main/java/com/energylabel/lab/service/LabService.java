package com.energylabel.lab.service;

import com.energylabel.lab.model.Report;

import java.util.Map;

/**
 * @author liuyong
 * @datetime 2019/2/25 14:06
 */
public interface LabService {
    Map<String, Object> getReport(String barcode);
}
