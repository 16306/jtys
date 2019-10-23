package com.mapper;

import com.entity.FamilyDoctor;

public interface FamilyDoctorMapper {
    int deleteByPrimaryKey(Long familyDoctorId);

    int insert(FamilyDoctor record);

    int insertSelective(FamilyDoctor record);

    FamilyDoctor selectByPrimaryKey(Long familyDoctorId);

    int updateByPrimaryKeySelective(FamilyDoctor record);

    int updateByPrimaryKeyWithBLOBs(FamilyDoctor record);

    int updateByPrimaryKey(FamilyDoctor record);
}