package com.mapper;

import com.entity.Measurement;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MeasurementMapper {
    int deleteByPrimaryKey(Long measurementId);

    int insert(Measurement record);

    int insertSelective(Measurement record);

    Measurement selectByPrimaryKey(Long measurementId);

    int updateByPrimaryKeySelective(Measurement record);

    int updateByPrimaryKey(Measurement record);
}