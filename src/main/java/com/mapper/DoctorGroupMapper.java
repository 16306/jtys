package com.mapper;

import com.entity.DoctorGroup;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DoctorGroupMapper {
    int deleteByPrimaryKey(Long doctorGroupId);

    int insert(DoctorGroup record);

    int insertSelective(DoctorGroup record);

    DoctorGroup selectByPrimaryKey(Long doctorGroupId);

    List<DoctorGroup> getAllDoctorGroupList(Long hospitalId,@Param("name")String name,@Param("groupLeaderName")String groupLeaderName,@Param("serviceArea")String serviceArea);

    DoctorGroup getAll();

    int updateByPrimaryKeySelective(DoctorGroup record);

    int updateByPrimaryKey(DoctorGroup record);
}