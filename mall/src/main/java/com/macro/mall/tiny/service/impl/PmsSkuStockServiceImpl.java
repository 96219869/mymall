package com.macro.mall.tiny.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.macro.mall.tiny.mbg.mapper.PmsSkuStockMapper;
import com.macro.mall.tiny.mbg.model.PmsSkuStock;
import com.macro.mall.tiny.mbg.model.PmsSkuStockExample;
import com.macro.mall.tiny.service.PmsSkuStockService;

/**
 * 商品sku库存管理Service实现类
 * Created by macro on 2018/4/27.
 */
@Service
public class PmsSkuStockServiceImpl implements PmsSkuStockService {
    @Autowired
    private PmsSkuStockMapper skuStockMapper;


    @Override
    public List<PmsSkuStock> getList(Long pid, String keyword) {
        PmsSkuStockExample example = new PmsSkuStockExample();
        PmsSkuStockExample.Criteria criteria = example.createCriteria().andProductIdEqualTo(pid);
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andSkuCodeLike("%" + keyword + "%");
        }
        return skuStockMapper.selectByExample(example);
    }

    @Override
    public int update(Long pid, List<PmsSkuStock> skuStockList) {
    	for(PmsSkuStock p : skuStockList) {
    		skuStockMapper.updateByPrimaryKeySelective(p);
    	}
    	return 1;
    }

	@Override
	public int delete(Long pid) {
		return skuStockMapper.deleteByPrimaryKey(pid);
	}

	@Override
	public int add(PmsSkuStock pmsSkuStock) {
		skuStockMapper.insertSelective(pmsSkuStock);
		return 0;
	}
}
