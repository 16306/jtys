package com.mapper;

import com.entity.Family;

public interface FamilyMapper {
    int deleteByPrimaryKey(Long familyId);

    int insert(Family record);

    int insertSelective(Family record);

    Family selectByPrimaryKey(Long familyId);

    int updateByPrimaryKeySelective(Family record);

    int updateByPrimaryKey(Family record);
}