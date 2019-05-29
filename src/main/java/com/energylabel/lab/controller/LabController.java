package com.energylabel.lab.controller;

import com.energylabel.lab.service.LabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liuyong
 * @datetime 2019/2/27 13:12
 */
@Controller
@RequestMapping("/lab")
public class LabController {
    private final LabService labService;

    @Autowired
    public LabController(LabService labService) {
        this.labService = labService;
    }

    @ResponseBody
    @RequestMapping(value = "/getReport")
    public Object getParams(String barcode) {
        return labService.getReport(barcode);
    }

}
