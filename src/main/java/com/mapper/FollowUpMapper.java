package com.mapper;

import com.entity.FollowUp;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface FollowUpMapper {
    int deleteByPrimaryKey(Long followUpId);

    int insert(FollowUp record);

    int insertSelective(FollowUp record);

    FollowUp selectByPrimaryKey(Long followUpId);

    int updateByPrimaryKeySelective(FollowUp record);

    int updateByPrimaryKeyWithBLOBs(FollowUp record);

    int updateByPrimaryKey(FollowUp record);
}