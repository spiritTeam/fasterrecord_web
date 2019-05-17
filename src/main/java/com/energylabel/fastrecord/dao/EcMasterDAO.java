package com.energylabel.fastrecord.dao;

import org.apache.ibatis.annotations.Param;

import com.energylabel.fastrecord.model.EcMaster;

public interface EcMasterDAO {

	void insertEcMaster(EcMaster ecMaster);

	EcMaster getEcMasterByMarkingId(@Param("ec_marking_id") int ec_marking_id);

	void updateEcMaster(EcMaster ecMaster);

	int countChildEcMaster(@Param("ec_marking_id")int ec_marking_id, @Param("ec_master_chang")String ec_master_chang);

}
