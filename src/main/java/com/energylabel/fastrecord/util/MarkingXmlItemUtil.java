package com.energylabel.fastrecord.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.energylabel.fastrecord.model.EcMarking;
import com.energylabel.fastrecord.model.EcMarkingXmlItem;
import com.energylabel.fastrecord.model.ModelXMLBean;

public class MarkingXmlItemUtil {

	/**
	 * 单眼备案数据处理
	 *
	 * @param modeno
	 * @param request
	 * @return
	 */
	public HashMap<String, String> getMarkingXmlUnitMap(EcMarkingXmlItem newEcmarkingItem, String modeno, String str,
			HttpServletRequest request) {
		HashMap<String, String> beanMap = new HashMap<String, String>();
		ParseModelXML parseModelXML = new ParseModelXML();
		// 获取实体类的所有属性，返回Field数组
		Field[] field = newEcmarkingItem.getClass().getDeclaredFields();
		// 遍历所有属性
		for (int j = 0; j < field.length; j++) {
			// 获取属性的名字
			String name = field[j].getName();
			// 获取属性的类型
			String type = field[j].getGenericType().toString();
			// 如果type是类类型，则前面包含"class "，后面跟类名
			if (type.equals("class java.lang.String")) {
				Method m;
				try {
					m = newEcmarkingItem.getClass().getMethod("get" + name.toUpperCase());
					// 调用getter方法获取属性值
					String value;
					try {
						value = (String) m.invoke(newEcmarkingItem);
						if (value != null) {
							Map<String, ModelXMLBean> itemMess = parseModelXML.getParseModelXML(modeno, request);
							if (name != null && !"".equals(str)) {
								String[] strfen = str.split(",");
								if (strfen.length > 0) {
									for (int i = 0; i < strfen.length; i++) {
										if (name.equals(strfen[i])) {
											String namsUpper = name.toUpperCase();
											if (itemMess.get(namsUpper) != null) {
												if (itemMess.get(namsUpper).getItemText() != null) {
													beanMap.put(name, value);
												}
											}
										}
									}
								}
							}
						}
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}

				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				}
			}
		}

		return beanMap;
	}

	public String getMarkingMark(String modeno, HttpServletRequest request) {
		String markingMark = "";
		ParseModelXML parseModelXML = new ParseModelXML();
		Map<String, ModelXMLBean> itemMess = parseModelXML.getParseModelXML(modeno, request);
		for (int i = 1; i <= itemMess.size(); i++) {
			if ("商标".equals(itemMess.get("C" + i).getItemText())) {
				markingMark = itemMess.get("C" + i).getName();
				break;
			}
		}
		return markingMark;
	}

	/**
	 * 未通过原因
	 *
	 * @param ecMarking
	 * @param request
	 * @return
	 */
	public JSONObject getMarkingNoPassJson(EcMarking ecMarking, HttpServletRequest request) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("ec_marking_title", ecMarking.getEc_marking_title());
		jsonObject.put("ec_model_name", ecMarking.getEc_model_name());
		jsonObject.put("ec_marking_nopassreason", ecMarking.getEc_marking_nopassreason());
		jsonObject.put("ec_marking_nopassmemo", ecMarking.getEc_marking_nopassmemo());
		return jsonObject;
	}

	/**
	 * 根据产品类型编码解析对应模板，生成固定格式的String
	 *
	 * @param ecMarkingXmlItem
	 * @param modeno
	 * @return
	 */
	public String getMarkingXmlStr(EcMarkingXmlItem ecMarkingXmlItem, String modeno, HttpServletRequest request) {
		StringBuffer xmlBuff = new StringBuffer();
		ParseModelXML parseModelXML = new ParseModelXML();
		xmlBuff.append("<Root>");
		String ecMarkingTitle = this.getMarkingTitle(ecMarkingXmlItem, modeno, request);
		xmlBuff.append("<Item Name=\"型号\"  ID=\"Title\">" + ecMarkingTitle + "</Item>");
		// 获取实体类的所有属性，返回Field数组
		Field[] field = ecMarkingXmlItem.getClass().getDeclaredFields();
		// 遍历所有属性
		for (int j = 0; j < field.length; j++) {
			// 获取属性的名字
			String name = field[j].getName();
			if (name != null) {
				// 获取属性的类型
				String type = field[j].getGenericType().toString();
				// 如果type是类类型，则前面包含"class "，后面跟类名
				if (type.equals("class java.lang.String")) {
					Method m;
					try {
						m = ecMarkingXmlItem.getClass().getMethod("get" + name.toUpperCase());
						// 调用getter方法获取属性值
						String value;
						try {
							value = (String) m.invoke(ecMarkingXmlItem);
							if (value != null && !"".equals(value)) {
								value = value.trim();
								// 特殊符号&的转义
								value = value.replaceAll("&", "&amp;");
								value = value.replaceAll(">", "&gt;");
								value = value.replaceAll("<", " &lt;");
								value = value.replaceAll("\"", " &quot;");
								value = value.replaceAll("\'", " &apos;");
								Map<String, ModelXMLBean> itemMess = parseModelXML.getParseModelXML(modeno, request);
								String namsUpper = name.toUpperCase();
								if (itemMess.get(namsUpper) != null && itemMess.get(namsUpper).getItemText() != null) {
									if ("30".equals(modeno)) {
										if (!"C64".equals(namsUpper)) {
											if (value.split(",").length > 0) {
												value = value.replaceAll(",", ";");
											}
											xmlBuff.append("<Item Name=\"" + itemMess.get(namsUpper).getItemText()
													+ "\" ID=\"" + namsUpper + "\">" + value + "</Item>");
										} else {
											// 获取C64值
											if (value.split(",").length > 0) {
												value = value.replaceAll(",", ";");
											}
											xmlBuff.append("<Item Name=\"" + itemMess.get(namsUpper).getItemText()
													+ "\" ID=\"" + namsUpper + "\">" + value + "</Item>");
										}
									} else if ("9".equals(modeno) || "42".equals(modeno) || "40".equals(modeno)
											|| "31".equals(modeno)) {
										if (!"C1".equals(namsUpper)) {
											if (value.split(",").length > 0) {
												value = value.replaceAll(",", ";");
											}
											xmlBuff.append("<Item Name=\"" + itemMess.get(namsUpper).getItemText()
													+ "\" ID=\"" + namsUpper + "\">" + value + "</Item>");
										} else { // ruking 修改没有C1
											xmlBuff.append("<Item Name=\"" + itemMess.get(namsUpper).getItemText()
													+ "\" ID=\"" + namsUpper + "\">" + value + "</Item>");
										}
									} else {
										if (value.split(",").length > 0) {
											value = value.replaceAll(",", ";");
										}
										if ("38".equals(modeno) && "C80".equals(namsUpper)) {
											value = value + ":";
										}
										xmlBuff.append("<Item Name=\"" + itemMess.get(namsUpper).getItemText()
												+ "\" ID=\"" + namsUpper + "\">" + value + "</Item>");
									}
								}
							}
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						} catch (IllegalArgumentException e) {
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							e.printStackTrace();
						}
					} catch (NoSuchMethodException e) {
						e.printStackTrace();
					} catch (SecurityException e) {
						e.printStackTrace();
					}
				}
			}
		}
		xmlBuff.append("</Root>");
		return xmlBuff.toString();
	}

	/**
	 * 功能： 返回该表单数据数据的规格型号数据
	 */
	public String getMarkingTitle(Object obj, String modeno, HttpServletRequest request) {
		String markingTitle = "";
		ParseModelXML parseModelXML = new ParseModelXML();
		// 获取实体类的所有属性，返回Field数组
		Field[] field = obj.getClass().getDeclaredFields();
		// 遍历所有属性
		for (int j = 0; j < field.length; j++) {
			// 获取属性的名字
			String name = field[j].getName();
			// 获取属性的类型
			String type = field[j].getGenericType().toString();
			// 如果type是类类型，则前面包含"class "，后面跟类名
			if (type.equals("class java.lang.String")) {
				Method m;
				try {
					m = obj.getClass().getMethod("get" + name.toUpperCase());
					// 调用getter方法获取属性值
					String value;
					try {
						value = (String) m.invoke(obj);
						if (value != null) {
							Map<String, ModelXMLBean> itemMess = parseModelXML.getParseModelXML(modeno, request);
							if (name != null) {
								String namsUpper = name.toUpperCase();
								if (itemMess.get(namsUpper) != null) {
									if (itemMess.get(namsUpper).getItemText() != null) {
										if ("规格型号".equals(itemMess.get(namsUpper).getItemText())) {
											markingTitle = value;
										}
									}
								}
							}
						}
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}

				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				}
			}
		}
		return markingTitle;
	}

	/**
	 * 能效等级
	 */
	public String getMarkingLevel(Object obj, String modeno, HttpServletRequest request) {
		String markingLevel = "";
		ParseModelXML parseModelXML = new ParseModelXML();
		// 获取实体类的所有属性，返回Field数组
		Field[] field = obj.getClass().getDeclaredFields();
		// 遍历所有属性
		for (int j = 0; j < field.length; j++) {
			// 获取属性的名字
			String name = field[j].getName();
			// 获取属性的类型
			String type = field[j].getGenericType().toString();
			// 如果type是类类型，则前面包含"class "，后面跟类名
			if (type.equals("class java.lang.String")) {
				Method m;
				try {
					m = obj.getClass().getMethod("get" + name.toUpperCase());
					// 调用getter方法获取属性值
					String value;
					try {
						value = (String) m.invoke(obj);
						if (value != null) {
							Map<String, ModelXMLBean> itemMess = parseModelXML.getParseModelXML(modeno, request);
							if (name != null) {
								String namsUpper = name.toUpperCase();
								if (itemMess.get(namsUpper) != null) {
									if (itemMess.get(namsUpper).getItemText() != null) {
										if ("能源效率等级".equals(itemMess.get(namsUpper).getItemText())) {
											markingLevel = value;
										}
									}
								}
							}
						}
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}

				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				}
			}
		}
		return markingLevel;
	}

	/**
	 * 添加时间
	 */
	public static String getMarkingAddtime(Object obj, String modeno, HttpServletRequest request) {
		String markingAddtime = "";
		ParseModelXML parseModelXML = new ParseModelXML();
		// 获取实体类的所有属性，返回Field数组
		Field[] field = obj.getClass().getDeclaredFields();
		// 遍历所有属性
		for (int j = 0; j < field.length; j++) {
			// 获取属性的名字
			String name = field[j].getName();
			// 获取属性的类型
			String type = field[j].getGenericType().toString();
			// 如果type是类类型，则前面包含"class "，后面跟类名
			if (type.equals("class java.lang.String")) {
				Method m;
				try {
					m = obj.getClass().getMethod("get" + name.toUpperCase());
					// 调用getter方法获取属性值
					String value;
					try {
						value = (String) m.invoke(obj);
						if (value != null) {
							Map<String, ModelXMLBean> itemMess = parseModelXML.getParseModelXML(modeno, request);
							if (name != null) {
								String namsUpper = name.toUpperCase();
								if (itemMess.get(namsUpper) != null) {
									if (itemMess.get(namsUpper).getItemText() != null) {
										if ("初始使用日期".equals(itemMess.get(namsUpper).getItemText())) {
											markingAddtime = value;
										}
									}
								}
							}
						}
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}

				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				}
			}
		}
		return markingAddtime;
	}

	/**
	 * Ec_Attach_id转换
	 *
	 * @param string
	 * @param ecMasterChang
	 * @return
	 */

	public static String changeEcAttachId(String oldKey, String ecMasterChang) {
		String key = "";
		if (oldKey != null && !"".equals(oldKey) && ecMasterChang != null && !"".equals(ecMasterChang)) {
			if ("0".equals(ecMasterChang)) {
				key = oldKey;
			}
			if ("1".equals(ecMasterChang)) {
				if ("23".equals(oldKey)) {
					key = "33";
				}
				if ("24".equals(oldKey)) {
					key = "34";
				}
				if ("25".equals(oldKey)) {
					key = "35";
				}
				if ("26".equals(oldKey)) {
					key = "36";
				}
				if ("27".equals(oldKey)) {
					key = "37";
				}
				if ("28".equals(oldKey)) {
					key = "38";
				}
				if ("29".equals(oldKey)) {
					key = "39";
				}
				if ("30".equals(oldKey)) {
					key = "40";
				}
				if ("31".equals(oldKey)) {
					key = "41";
				}
				if ("32".equals(oldKey)) {
					key = "42";
				}
				if ("76".equals(oldKey)) {
					key = "77";
				}
			}
			if ("2".equals(ecMasterChang)) {
				if ("23".equals(oldKey)) {
					key = "44";
				}
				if ("24".equals(oldKey)) {
					key = "45";
				}
				if ("25".equals(oldKey)) {
					key = "46";
				}
				if ("26".equals(oldKey)) {
					key = "47";
				}
				if ("27".equals(oldKey)) {
					key = "48";
				}
				if ("28".equals(oldKey)) {
					key = "49";
				}
				if ("29".equals(oldKey)) {
					key = "50";
				}
				if ("30".equals(oldKey)) {
					key = "51";
				}
				if ("31".equals(oldKey)) {
					key = "52";
				}
				if ("32".equals(oldKey)) {
					key = "53";
				}
				if ("76".equals(oldKey)) {
					key = "78";
				}
			}
		}
		return key;

	}

	public static boolean isEmpty(String str) {
		if (str != null && !"".equals(str) && !"null".equals(str)) {
			return true;
		}
		return false;
	}
}