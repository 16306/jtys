package com.mapper;

import com.entity.FamilyDoctor;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface FamilyDoctorMapper {
    int deleteByPrimaryKey(Long familyDoctorId);

    int insert(FamilyDoctor record);

    int insertSelective(FamilyDoctor record);

    FamilyDoctor selectByPrimaryKey(Long familyDoctorId);

    FamilyDoctor selectByFamilyId(Long familyId);

    List<FamilyDoctor> selectByDoctorGroupId(Long doctorGroupId);

    FamilyDoctor getAll();

    int updateByPrimaryKeySelective(FamilyDoctor record);

    int updateByPrimaryKeyWithBLOBs(FamilyDoctor record);

    int updateByPrimaryKey(FamilyDoctor record);
}