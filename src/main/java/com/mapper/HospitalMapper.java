package com.mapper;

import com.entity.Hospital;

public interface HospitalMapper {
    int deleteByPrimaryKey(Long hospitalId);

    int insert(Hospital record);

    int insertSelective(Hospital record);

    Hospital selectByPrimaryKey(Long hospitalId);

    int updateByPrimaryKeySelective(Hospital record);

    int updateByPrimaryKey(Hospital record);
}