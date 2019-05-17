package com.energylabel.fastrecord.dao;

import org.apache.ibatis.annotations.Param;

import com.energylabel.fastrecord.model.EcMarkingKzTitle;

public interface EcMarkingKzTitleDao {

	void delByMarkingId(@Param("ec_marking_id")int ec_marking_id);

	void insertMarkingKztitle(EcMarkingKzTitle ecMarkingKzTitle);

}
