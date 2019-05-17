package com.energylabel.fastrecord.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.energylabel.fastrecord.model.EcMarking;
import com.energylabel.fastrecord.model.Marking;

public interface EcMarkingDAO {

	void insertEcMarking(EcMarking ecMarking);

	EcMarking getEcMarkingById(@Param("ec_marking_id") int ec_marking_id);
	
	void updateEcMarking(EcMarking bean);

	List<Marking> list(Map<String, Object> map);

	List<Marking> draftList(Map<String, Object> map);

}
