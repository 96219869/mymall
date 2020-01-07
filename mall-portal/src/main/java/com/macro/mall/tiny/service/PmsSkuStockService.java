package com.macro.mall.tiny.service;



import java.util.List;

import com.macro.mall.tiny.mbg.model.PmsSkuStock;

/**
 * sku商品库存管理Service
 * Created by macro on 2018/4/27.
 */
public interface PmsSkuStockService {
    /**
     * 根据产品id和skuCode模糊搜索
     */
    List<PmsSkuStock> getList(Long pid, String keyword);

    /**
     * 批量更新商品库存信息
     */
    int update(Long pid, List<PmsSkuStock> skuStockList);

	int delete(Long pid);

	int add(PmsSkuStock pmsSkuStock);
}
