package com.mapper;

import com.entity.Purchase;

public interface PurchaseMapper {
    int deleteByPrimaryKey(Long purchaseId);

    int insert(Purchase record);

    int insertSelective(Purchase record);

    Purchase selectByPrimaryKey(Long purchaseId);

    int updateByPrimaryKeySelective(Purchase record);

    int updateByPrimaryKey(Purchase record);
}