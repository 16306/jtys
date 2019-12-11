package com.mapper;

import com.entity.Threshold;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ThresholdMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Threshold record);

    int insertSelective(Threshold record);

    Threshold selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Threshold record);

    int updateByPrimaryKey(Threshold record);
}