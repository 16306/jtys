package com.mapper;

import com.entity.Inspection;

public interface InspectionMapper {
    int deleteByPrimaryKey(Long inspectionId);

    int insert(Inspection record);

    int insertSelective(Inspection record);

    Inspection selectByPrimaryKey(Long inspectionId);

    int updateByPrimaryKeySelective(Inspection record);

    int updateByPrimaryKey(Inspection record);
}