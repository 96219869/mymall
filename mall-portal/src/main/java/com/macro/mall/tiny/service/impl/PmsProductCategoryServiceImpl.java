package com.macro.mall.tiny.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.macro.mall.tiny.dao.PmsProductCategoryDao;
import com.macro.mall.tiny.dto.PmsProductCategoryWithChildrenItem;
import com.macro.mall.tiny.mbg.mapper.PmsProductCategoryMapper;
import com.macro.mall.tiny.mbg.model.PmsProductCategory;
import com.macro.mall.tiny.service.PmsProductCategoryService;

@Service
public class PmsProductCategoryServiceImpl implements PmsProductCategoryService{

	@Autowired
    private PmsProductCategoryDao productCategoryDao;
    @Autowired
    private PmsProductCategoryMapper productCategoryMapper;
    
	@Override
	public List<PmsProductCategoryWithChildrenItem> listWithChildren() {
		return productCategoryDao.listWithChildren();
	}

	@Override
	public PmsProductCategory getItem(Long id) {
		return productCategoryMapper.selectByPrimaryKey(id);
	}

	@Override
	public Long getParentId(Long id) {
		return productCategoryMapper.selectByPrimaryKey(id).getParentId();
	}

}
