package com.energylabel.fastrecord.util;

import java.util.Calendar;

import com.energylabel.fastrecord.model.EcMarking;

public class MarkingPathUtil {

	/**
	 * 新备案号日期部分数据
	 * 
	 * @return
	 */
	public static String newFileNoDateStr() {
		String newFileNoDateStr = "";
		String newMonth = "";
		Calendar now = Calendar.getInstance();
		String year = String.valueOf(now.get(Calendar.YEAR)).trim();
		String month = String.valueOf((now.get(Calendar.MONTH) + 1) + "").trim();
		if (month.length() == 1) {
			newMonth = "0" + month;
		} else {
			newMonth = month;
		}
		newFileNoDateStr = year + newMonth;
		return newFileNoDateStr;
	}
	
	
    /**
     * 备案号
     *
     * @param ecMarking
     * @return
     */
    public static String ecMarkingRecordnoStr(EcMarking ecMarking) {
        String recordNo = "";
        //归类的备案号
        //日期数据 201606
        String yearMonth = newFileNoDateStr();
        String modelNoInitStr = "";
        if (ecMarking.getEc_model_no() != null) {
            modelNoInitStr = modelNoAllInit(String.valueOf(ecMarking.getEc_model_no()));
        }
        String enenpriseId = ecMarking.getEc_enterprise_id();
        //新备案号
        String ecMarkingNewId = ecMarking.getEc_prelimno();
        recordNo = yearMonth + "-" + modelNoInitStr + "-" + enenpriseId + "-" + ecMarkingNewId;
        return recordNo;
    }

    /**
     * 备案编号数据归纳
     */
    public static String modelNoAllInit(String typeCode) {
        String modelNo = "";
        if (typeCode != null && !"".equals(typeCode)) {
            String oldModelNo = typeCode.replace("T", "");
            //家用电冰箱
            if ("1".equals(oldModelNo) || "20".equals(oldModelNo) || "47".equals(oldModelNo)) {
                modelNo = "1";
            }
            //房间空气调节器
            if ("2".equals(oldModelNo) || "23".equals(oldModelNo)) {
                modelNo = "2";
            }
            //电动洗衣机
            if ("3".equals(oldModelNo) || "31".equals(oldModelNo)) {
                modelNo = "3";
            }
            //单元式空气调节机
            if ("4".equals(oldModelNo)) {
                modelNo = "4";
            }
            //自镇流荧光灯
            if ("5".equals(oldModelNo) || "32".equals(oldModelNo)) {
                modelNo = "5";
            }
            //高压钠灯
            if ("6".equals(oldModelNo)) {
                modelNo = "6";
            }
            //中小型三相异步电动机
            if ("7".equals(oldModelNo)) {
                modelNo = "7";
            }
            //冷水机组
            if ("8".equals(oldModelNo) || "50".equals(oldModelNo)) {
                modelNo = "8";
            }
            //家用燃气快速热水器和燃气采暖热水炉
            if ("9".equals(oldModelNo) || "48".equals(oldModelNo)) {
                modelNo = "9";
            }
            //转速可控型房间空气调节器
            if ("10".equals(oldModelNo) || "33".equals(oldModelNo)) {
                modelNo = "10";
            }
            //多联式空调
            if ("12".equals(oldModelNo)) {
                modelNo = "11";
            }
            //储水式电热水器
            if ("13".equals(oldModelNo)) {
                modelNo = "12";
            }
            //家用电磁灶
            if ("11".equals(oldModelNo) || "40".equals(oldModelNo)) {
                modelNo = "13";
            }
            //计算机显示器
            if ("15".equals(oldModelNo) || "46".equals(oldModelNo)) {
                modelNo = "14";
            }
            //复印机、打印机和传真机
            if ("38".equals(oldModelNo)) {
                modelNo = "15";
            }
            //自动电饭锅
            if ("16".equals(oldModelNo)) {
                modelNo = "16";
            }
            //交流电风扇
            if ("17".equals(oldModelNo)) {
                modelNo = "17";
            }
            //交流接触器
            if ("18".equals(oldModelNo)) {
                modelNo = "18";
            }
            //容积式空气压缩机
            if ("19".equals(oldModelNo)) {
                modelNo = "19";
            }
            //电力变压器
            if ("21".equals(oldModelNo)) {
                modelNo = "20";
            }
            //通风机
            if ("22".equals(oldModelNo)) {
                modelNo = "21";
            }
            //平板电视
            if ("24".equals(oldModelNo) || "34".equals(oldModelNo)) {
                modelNo = "22";
            }
            //家用和类似用途微波炉
            if ("25".equals(oldModelNo)) {
                modelNo = "23";
            }
            //数字电视接收器（机顶盒）
            if ("27".equals(oldModelNo)) {
                modelNo = "24";
            }
            //远置冷凝机组冷藏陈列柜
            if ("28".equals(oldModelNo)) {
                modelNo = "25";
            }
            //家用太阳能热水系统
            if ("29".equals(oldModelNo)) {
                modelNo = "26";
            }
            //微型计算机
            if ("30".equals(oldModelNo)) {
                modelNo = "27";
            }
            //吸油烟机
            if ("39".equals(oldModelNo)) {
                modelNo = "28";
            }
            //热泵热水机（器）
            if ("37".equals(oldModelNo)) {
                modelNo = "29";
            }
            //家用燃气灶具
            if ("42".equals(oldModelNo)) {
                modelNo = "30";
            }
            //商用燃气灶具
            if ("41".equals(oldModelNo)) {
                modelNo = "31";
            }
            //水（地）源热泵机组
            if ("44".equals(oldModelNo)) {
                modelNo = "32";
            }
            //溴化锂吸收式冷水机组
            if ("43".equals(oldModelNo)) {
                modelNo = "33";
            }
            //普通照明用非定向自镇流LED灯
            if ("45".equals(oldModelNo)) {
                modelNo = "34";
            }
            //三相配电变压器
            if ("35".equals(oldModelNo)) {
                modelNo = "35";
            }
            //投影机
            if ("49".equals(oldModelNo)) {
                modelNo = "49";
            }
        }
        return modelNo;
    }
}
