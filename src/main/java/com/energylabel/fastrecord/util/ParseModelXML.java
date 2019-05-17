package com.energylabel.fastrecord.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.energylabel.fastrecord.model.ModelXMLBean;

public class ParseModelXML {
	/**
	 * 读取产品模板
	 * 
	 * @Title: Map @Description: 产品类型模板数据 @return Map 返回类型 @throws
	 */
	public Map<String, ModelXMLBean> getParseModelXML(String modelNo, HttpServletRequest request) {
		File file;
		String xmlSur = "";
		if (modelNo == null || modelNo.trim().length() < 1) {

		}
		file = new File(request.getSession().getServletContext().getRealPath("/xmlModel") + "/" + modelNo + ".xml");
		BufferedReader reader = null;
		StringBuffer sb = new StringBuffer();
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			xmlSur += sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		if (xmlSur == null || xmlSur.trim().length() < 1) {
			return null;
		}
		Map<String, ModelXMLBean> mxMap = new LinkedHashMap<String, ModelXMLBean>();
		try {
			Document document = DocumentHelper.parseText(xmlSur);
			Element root = document.getRootElement();
			Element item;
			ModelXMLBean bean;
			String itemName;
			for (Iterator<?> iterator = root.elementIterator("Item"); iterator.hasNext();) {
				bean = new ModelXMLBean();
				item = (Element) iterator.next();
				itemName = item.attributeValue("Name").trim();
				bean.setName(itemName);
				bean.setMustSet(item.attributeValue("MustSet").trim());
				bean.setItemText(item.getText().trim());
				Attribute att = item.attribute("Example");
				String value = "";
				if (att != null) {
					value = att.getValue().trim();
				}
				bean.setExample(value);
				bean.setControlType(item.attributeValue("ControlType").trim());
				bean.setEditBianGeng(item.attributeValue("editBianGeng").trim());
				bean.setEditKuoZhan(item.attributeValue("editKuoZhan").trim());

				att = item.attribute("Computer");
				String vComputer = "";
				if (att != null) {
					vComputer = att.getValue().trim();
				}
				bean.setComputer(vComputer);

				att = item.attribute("KuoZhanCopyValue");
				String kuozhanCopyValue = "true";
				if (att != null) {
					kuozhanCopyValue = att.getValue().trim();
				}
				bean.setKuozhanCopyValue(kuozhanCopyValue);
				bean.setItemName(itemName);

				mxMap.put(itemName, bean);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}

		return mxMap;
	}
}
