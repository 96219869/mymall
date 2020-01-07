package com.macro.mall.tiny.service;

import java.util.List;

import com.macro.mall.tiny.dto.PmsProductQueryParam;
import com.macro.mall.tiny.dto.PmsProductResult;
import com.macro.mall.tiny.mbg.model.PmsProduct;

public interface PmsProductService {

	List<PmsProduct> list(PmsProductQueryParam productQueryParam, Integer pageSize, Integer pageNum);
	
	int updatePublishStatus(Long id, Integer publishStatus);

	int updateDeleteStatus(List<Long> ids, Integer deleteStatus);

	PmsProduct getUpdateInfo(Long id);

	int update(Long id, PmsProduct productParam);

	int create(PmsProduct productParam);
}
