package com.mapper;

import com.entity.DoctorGroup;

public interface DoctorGroupMapper {
    int deleteByPrimaryKey(Long doctorGroupId);

    int insert(DoctorGroup record);

    int insertSelective(DoctorGroup record);

    DoctorGroup selectByPrimaryKey(Long doctorGroupId);

    int updateByPrimaryKeySelective(DoctorGroup record);

    int updateByPrimaryKey(DoctorGroup record);
}