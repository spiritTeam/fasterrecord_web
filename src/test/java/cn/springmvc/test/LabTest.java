package cn.springmvc.test;

import com.energylabel.lab.model.Report;
import com.energylabel.lab.model.ReportParamValue;
import com.energylabel.lab.service.LabService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

/**
 * @author liuyong
 * @datetime 2019/2/25 14:11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/test/java/main.xml"})
public class LabTest {
    @Autowired
    private LabService labService;

    @Test
    public void getReportParamValues() {
        String barcode = "1546047065161222754";

//        if(! labService.verifyBarcode(barcode)) return;
//
//        List<ReportParamValue> list = labService.getReportParamValues(barcode);
//        list.stream().forEach(System.out :: println);

        Map<String, Object> map = labService.getReport(barcode);

        System.out.println(map);
    }
}
