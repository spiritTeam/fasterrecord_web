package com.energylabel.fastrecord.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.energylabel.fastrecord.dao.CategoryDAO;
import com.energylabel.fastrecord.model.CategoryInfo;
import com.energylabel.fastrecord.service.CategoryService;

/**
 * 
 * @author ru
 * @date 2019年1月29日
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDAO categoryDao;
	
	@Value("${model.type.ids}")
	private String modelTypeIds;

	@Override
	public List<CategoryInfo> getCategoryList() {
		return categoryDao.getCategoryList(modelTypeIds);
	}

	@Override
	public CategoryInfo getCategoryByModel_no(int model_no) {
		return categoryDao.getCategoryByModel_no(model_no);
	}

}
