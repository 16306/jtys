package com.mapper;

import com.entity.Unit;

public interface UnitMapper {
    int deleteByPrimaryKey(Long unitId);

    int insert(Unit record);

    int insertSelective(Unit record);

    Unit selectByPrimaryKey(Long unitId);

    int updateByPrimaryKeySelective(Unit record);

    int updateByPrimaryKey(Unit record);
}