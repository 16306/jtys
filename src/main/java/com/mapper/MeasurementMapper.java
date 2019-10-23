package com.mapper;

import com.entity.Measurement;

public interface MeasurementMapper {
    int deleteByPrimaryKey(Long measurementId);

    int insert(Measurement record);

    int insertSelective(Measurement record);

    Measurement selectByPrimaryKey(Long measurementId);

    int updateByPrimaryKeySelective(Measurement record);

    int updateByPrimaryKey(Measurement record);
}