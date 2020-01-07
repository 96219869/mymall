package com.macro.mall.tiny.service;

import java.util.List;

import com.macro.mall.tiny.dto.PmsProductCategoryWithChildrenItem;
import com.macro.mall.tiny.mbg.model.PmsProductCategory;

public interface PmsProductCategoryService {

	List<PmsProductCategoryWithChildrenItem> listWithChildren();

	PmsProductCategory getItem(Long id);
	
	Long getParentId(Long id);
}
