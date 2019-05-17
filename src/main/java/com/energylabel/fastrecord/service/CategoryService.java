package com.energylabel.fastrecord.service;

import java.util.List;

import com.energylabel.fastrecord.model.CategoryInfo;

public interface CategoryService {

	List<CategoryInfo> getCategoryList();


	CategoryInfo getCategoryByModel_no(int model_no);

}
