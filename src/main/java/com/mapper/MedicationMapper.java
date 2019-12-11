package com.mapper;

import com.entity.Medication;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MedicationMapper {
    int deleteByPrimaryKey(Long medicationId);

    int insert(Medication record);

    int insertSelective(Medication record);

    Medication selectByPrimaryKey(Long medicationId);

    int updateByPrimaryKeySelective(Medication record);

    int updateByPrimaryKey(Medication record);
}