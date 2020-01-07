package com.macro.mall.tiny.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.macro.mall.tiny.dto.PmsProductQueryParam;
import com.macro.mall.tiny.dto.PmsProductResult;
import com.macro.mall.tiny.mbg.mapper.PmsProductMapper;
import com.macro.mall.tiny.mbg.mapper.UmsKefuMapper;
import com.macro.mall.tiny.mbg.mapper.UmsSellerMapper;
import com.macro.mall.tiny.mbg.model.PmsProduct;
import com.macro.mall.tiny.mbg.model.PmsProductExample;
import com.macro.mall.tiny.mbg.model.UmsKefu;
import com.macro.mall.tiny.mbg.model.UmsSeller;
import com.macro.mall.tiny.service.KefuService;
import com.macro.mall.tiny.service.PmsProductCategoryService;
import com.macro.mall.tiny.service.PmsProductService;
import com.macro.mall.tiny.service.SellerService;

@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	private UmsSellerMapper UmsSellerMapper;
	
	@Override
	public UmsSeller getById(Long id) {
		return UmsSellerMapper.selectByPrimaryKey(id);
	}


}
