package com.macro.mall.tiny.dto;

import com.macro.mall.tiny.mbg.model.PmsProduct;

/**
 * 查询单个产品进行修改时返回的结果
 * Created by macro on 2018/4/26.
 */
public class PmsProductResult extends PmsProduct {
    //商品所选分类的父id
    private Long cateParentId;

    public PmsProductResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getCateParentId() {
        return cateParentId;
    }

    public void setCateParentId(Long cateParentId) {
        this.cateParentId = cateParentId;
    }
}
