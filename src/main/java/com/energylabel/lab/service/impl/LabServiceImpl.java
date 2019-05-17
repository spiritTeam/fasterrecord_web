package com.energylabel.lab.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.energylabel.lab.model.ReportParamValue;
import com.hitworth.framework.base.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.energylabel.lab.dao.LabDAO;
import com.energylabel.lab.model.Report;
import com.energylabel.lab.service.LabService;
import org.springframework.util.StringUtils;

/**
 * @author liuyong
 * @datetime 2019/2/25 14:07
 */
@Service("labService")
public class LabServiceImpl implements LabService {
	private static Logger logger = LoggerFactory.getLogger(LabServiceImpl.class);

	private final LabDAO labDao;

	@Value("${model.type.ids}")
	private String modelTypeIds;
	@Value("${category.ids}")
	private String categoryIds;
	@Value("${report_check_flag}")
	private boolean reportCheckFlag;

	@Autowired
	public LabServiceImpl(LabDAO labDao) {
		this.labDao = labDao;
	}

	@Override
	public Map<String, Object> getReport(String barcode) {
		// 判断实验室报告是否存在
		Report report = getReportByBarcode(barcode);
		if (null == report) {
			return ResponseUtil.fail("该实验室报告不存在！");
		}

		// 判断实验室报告是否已经做过“主型号”备案
		if (reportCheckFlag) {
			Integer num = labDao.count1(barcode);
			if (num != 0) {
				return ResponseUtil.fail("该实验室报告已经做过“主型号”备案了，不能重复申请！");
			}
		}

		List<ReportParamValue> list = labDao.getReportParamValues(barcode, getCategoryIdByModel(report.getModelNo()));
		handleParams(list);
		report.setParams(list);

		if (0 == report.getModelNo().compareTo(new BigDecimal(47))) {
			specHandlingForBingXiang(report);
		}
		return ResponseUtil.success(report);
	}

	/**
	 * 处理C值中的null和/
	 * @param list
	 */
	private void handleParams(List<ReportParamValue> list) {
		if (null == list || list.isEmpty()) {
			return;
		}
		String value = null;
		for (ReportParamValue param : list) {
			value = param.getLabValue();
			if (null == value || value.equals("/")) {
				param.setLabValue("");
			}
		}
	}
	// ----------------------------------------
	
	/**
	 * 针对冰箱参数的特殊处理
	 * 
	 * @param report
	 */
	private void specHandlingForBingXiang(Report report) {
		List<ReportParamValue> list = report.getParams();
		ReportParamValue rpv;
		String value;

		// 得到实验室报告可以使用的备案模板
		if (!isTemplateEmpty(list)) {
			report.setTemplates(new Integer[] { 244 });
		} else if (!isTemplateLc(list) && !isTemplateLd(list)) {
			report.setTemplates(new Integer[] { 241, 242 });
		} else if (!isTemplateLd(list)) {
			report.setTemplates(new Integer[] { 245 });
		} else if (!isTemplateLc(list)) {
			report.setTemplates(new Integer[] { 246 });
		}

		// 气候类型 备案端id 为C23
		rpv = getReportParamValue(list, "c23");
		String regEx = "[0-9]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(rpv.getLabValue());
		value = m.replaceAll("").trim();
		value = removeBlank(value);
		rpv.setLabValue(value);

		// 冷凝器形式 备案端id 为C51，该值为多选值，用;分割
		// 冷凝器形式其他 备案端id 为C52
		// 如果C51值中有“其他”，则应将C52的值填入“其他”选项的文本输入框中
		rpv = getReportParamValue(list, "c51");
		value = removeBlank(rpv.getLabValue());
		rpv.setLabValue(value);

		// 温控器安装位置 备案端id 为C56，该值为多选值，用;分割
		// 温控器安装位置其他 备案端id 为C57
		// 如果C56值中有“其他”，则应将C57的值填入“其他”选项的文本输入框中
		rpv = getReportParamValue(list, "c56");
		value = removeBlank(rpv.getLabValue());
		rpv.setLabValue(value);

		// 照明灯安装位置 备案端id 为C58，该值为多选值，用;分割
		// 照明灯安装位置其他 备案端id 为C59
		// 如果C58值中有“其他”，则应将C59的值填入“其他”选项的文本输入框中
		rpv = getReportParamValue(list, "c58");
		value = removeBlank(rpv.getLabValue());
		rpv.setLabValue(value);

	}

	// -------------------------------------------------------------------------

	// 大类是冰箱时，判断是否有冷藏室
	private boolean isTemplateLc(List<ReportParamValue> list) {
		// 冷藏室-类型 备案端id 为C24
		ReportParamValue rpv24 = getReportParamValue(list, "c24");
		// 冷藏室-标称容积值L 备案端id 为C25
		ReportParamValue rpv25 = getReportParamValue(list, "c25");

		return isEmpty(rpv24) && isEmpty(rpv25);
	}

	// 大类是冰箱时，判断是否有冷冻室
	private boolean isTemplateLd(List<ReportParamValue> list) {
		// 冷冻室-类型 备案端id 为C26
		ReportParamValue rpv26 = getReportParamValue(list, "c26");
		// 冷冻室-标称容积值L 备案端id 为C27
		ReportParamValue rpv27 = getReportParamValue(list, "c27");

		return isEmpty(rpv26) && isEmpty(rpv27);
	}

	// 大类是冰箱时，判断是否是空模板
	private boolean isTemplateEmpty(List<ReportParamValue> list) {
		// 其他间室1-类型 备案端id 为C28
		ReportParamValue rpv28 = getReportParamValue(list, "c28");
		// 其他间室1-名称 备案端id 为C29
		ReportParamValue rpv29 = getReportParamValue(list, "c29");
		// 其他间室1-标称容积值L 备案端id 为C30
		ReportParamValue rpv30 = getReportParamValue(list, "c30");
		// 其他间室1-特性温度℃ 备案端id 为C31
		ReportParamValue rpv31 = getReportParamValue(list, "c31");
		// 其他间室1-低 备案端id 为C32
		ReportParamValue rpv32 = getReportParamValue(list, "c32");

		return isEmpty(rpv28) && isEmpty(rpv29) && isEmpty(rpv30) && isEmpty(rpv31) && isEmpty(rpv32);
	}

	// 删除空格
	private String removeBlank(String value) {
		return StringUtils.replace(value, " ", "");
	}

	private boolean isEmpty(ReportParamValue rpv) {
		String value = rpv.getLabValue();
		return null == value || 0 == value.trim().length() || "/".equals(value.trim());
	}

	private ReportParamValue getReportParamValue(List<ReportParamValue> list, String recId) {
		List<ReportParamValue> temp = list.stream().filter(o -> o.getRecId().equals(recId))
				.collect(Collectors.toList());
		if (0 == temp.size()) {
			return new ReportParamValue(recId, "");
		}
		ReportParamValue result = temp.get(0);

		if (null == result) {
			result = new ReportParamValue(recId, "");
		} else if (StringUtils.isEmpty(result.getLabValue())) {
			result.setLabValue("");
		}

		return result;
	}

	private BigDecimal getCategoryIdByModel(BigDecimal modelNo) {
		String model_no = String.valueOf(modelNo);
		if (modelTypeIds.contains(model_no)) {
			String[] mids = modelTypeIds.split(",");
			String[] cids = categoryIds.split(",");
			for (int i = 0; i < mids.length; i++) {
				if (mids[i].equals(model_no)) {
					return new BigDecimal(cids[i]);
				}
			}
		}
		return new BigDecimal(0);
	}

	private Report getReportByBarcode(String barcode) {
		Report report = labDao.getReport(barcode);
		if (null != report) {
			String[] array = this.modelTypeIds.split(",");
			String model_no = String.valueOf(report.getModelNo());
			for (String id : array) {
				if (id.equals(model_no)) {
					return report;
				}
			}
		}
		return null;
	}
}
