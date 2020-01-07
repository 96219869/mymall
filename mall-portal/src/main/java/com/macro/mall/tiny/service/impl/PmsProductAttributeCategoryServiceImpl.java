package com.macro.mall.tiny.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.macro.mall.tiny.mbg.mapper.PmsProductAttributeCategoryMapper;
import com.macro.mall.tiny.mbg.model.PmsProductAttributeCategory;
import com.macro.mall.tiny.mbg.model.PmsProductAttributeCategoryExample;
import com.macro.mall.tiny.service.PmsProductAttributeCategoryService;

@Service
public class PmsProductAttributeCategoryServiceImpl implements PmsProductAttributeCategoryService {
    @Autowired
    private PmsProductAttributeCategoryMapper productAttributeCategoryMapper;
    
	@Override
	public List<PmsProductAttributeCategory> getList(Integer pageSize, Integer pageNum) {
		PageHelper.startPage(pageNum,pageSize);
        return productAttributeCategoryMapper.selectByExample(new PmsProductAttributeCategoryExample());
	}

}
