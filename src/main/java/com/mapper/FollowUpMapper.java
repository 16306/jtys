package com.mapper;

import com.entity.FollowUp;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FollowUpMapper {
    int deleteByPrimaryKey(Long followUpId);

    int insert(FollowUp record);

    int insertSelective(FollowUp record);

    FollowUp selectByPrimaryKey(Long followUpId);

    FollowUp getLastOne();

    List<FollowUp> selectByDoctorId(Long doctorId);

    List<FollowUp> selectByPrimaryKeyAndDoctorId(Long followUpId,Long doctorId);

    int updateByPrimaryKeySelective(FollowUp record);

    int updateByPrimaryKeyWithBLOBs(FollowUp record);

    int updateByPrimaryKey(FollowUp record);
}