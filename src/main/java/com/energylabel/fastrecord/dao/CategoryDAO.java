package com.energylabel.fastrecord.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.energylabel.fastrecord.model.CategoryInfo;

public interface CategoryDAO {

	CategoryInfo getCategoryByModel_no(@Param("model_no") int model_no);

	List<CategoryInfo> getCategoryList(@Param("model_type_ids") String modelTypeIds);

}
