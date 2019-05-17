package com.energylabel.fastrecord.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.energylabel.fastrecord.model.EcMarkingAttach;

public interface EcMarkingAttachDAO {

	void insertEcMarkingAttach(EcMarkingAttach attach);

	EcMarkingAttach getEcMarkingAttachById(@Param("ec_marking_attach_id") int ec_marking_attach_id);

	void delByEcMarkingId(@Param("ec_marking_id") int ec_marking_id);

	List<EcMarkingAttach> getEcMarkingAttachList(@Param("ec_marking_id") int ec_marking_id);

	EcMarkingAttach getEcMarkingAttach25(@Param("ec_marking_id") int ec_marking_id);

	void updateEcMarkingAttach(EcMarkingAttach attach);

}
