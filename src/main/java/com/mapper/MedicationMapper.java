package com.mapper;

import com.entity.Medication;

public interface MedicationMapper {
    int deleteByPrimaryKey(Long medicationId);

    int insert(Medication record);

    int insertSelective(Medication record);

    Medication selectByPrimaryKey(Long medicationId);

    int updateByPrimaryKeySelective(Medication record);

    int updateByPrimaryKey(Medication record);
}