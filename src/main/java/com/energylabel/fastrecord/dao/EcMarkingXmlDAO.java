package com.energylabel.fastrecord.dao;

import org.apache.ibatis.annotations.Param;

import com.energylabel.fastrecord.model.EcMarkingXml;

public interface EcMarkingXmlDAO {

	void insertXml(EcMarkingXml ecMarkingXml);

	String getMarkingXml(@Param("ec_marking_id") int ec_marking_id);
}
