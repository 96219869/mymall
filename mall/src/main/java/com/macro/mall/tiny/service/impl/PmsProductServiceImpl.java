package com.macro.mall.tiny.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.macro.mall.tiny.dto.PmsProductQueryParam;
import com.macro.mall.tiny.dto.PmsProductResult;
import com.macro.mall.tiny.mbg.mapper.PmsProductMapper;
import com.macro.mall.tiny.mbg.model.PmsProduct;
import com.macro.mall.tiny.mbg.model.PmsProductExample;
import com.macro.mall.tiny.service.PmsProductCategoryService;
import com.macro.mall.tiny.service.PmsProductService;

@Service
public class PmsProductServiceImpl implements PmsProductService {

	@Autowired
	PmsProductMapper productMapper;
	@Autowired
    private PmsProductCategoryService PmsProductCategoryService;
	
	@Override
	public List<PmsProduct> list(PmsProductQueryParam productQueryParam, Integer pageSize, Integer pageNum) {
		PageHelper.startPage(pageNum, pageSize);
		PmsProductExample productExample = new PmsProductExample();
        PmsProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andDeleteStatusEqualTo(0);
		return productMapper.selectByExample(productExample);
	}

	@Override
	public int updatePublishStatus(Long id, Integer publishStatus) {
		PmsProduct product = new PmsProduct();
		product.setId(id);
		product.setPublishStatus(publishStatus);
		return productMapper.updateByPrimaryKeySelective(product);
	}

	@Override
	public int updateDeleteStatus(List<Long> ids, Integer deleteStatus) {
		PmsProduct record = new PmsProduct();
        record.setDeleteStatus(deleteStatus);
        PmsProductExample example = new PmsProductExample();
        example.createCriteria().andIdIn(ids);
        return productMapper.updateByExampleSelective(record, example);
	}

	@Override
	public PmsProductResult getUpdateInfo(Long id) {
		PmsProduct product = productMapper.selectByPrimaryKey(id);
		PmsProductResult result = new PmsProductResult();
		result.setCateParentId(PmsProductCategoryService.getParentId(product.getProductCategoryId()));
		result.setId(product.getId());
		result.setProductCategoryId(product.getProductCategoryId());
		result.setName(product.getName());
		result.setAlbumPics(product.getAlbumPics());
		result.setSubTitle(product.getSubTitle());
		result.setPrice(product.getPrice());
		result.setProductSn(product.getProductSn());
		result.setDescription(product.getDescription());
		result.setDetailHtml(product.getDetailHtml());
		result.setPic(product.getPic());
		return result;
	}

	@Override
	public int update(Long id, PmsProduct productParam) {
		productParam.setId(id);
		return productMapper.updateByPrimaryKeySelective(productParam);
	}

	@Override
	public int create(PmsProduct productParam) {
		if(productParam.getId() != null) update(productParam.getId(), productParam);
		else productMapper.insertSelective(productParam);
		return 1;
	}

}
