package com.mapper;

import com.entity.Warning;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface WarningMapper {
    int deleteByPrimaryKey(Long warningId);

    int insert(Warning record);

    int insertSelective(Warning record);

    Warning selectByPrimaryKey(Long warningId);

    int updateByPrimaryKeySelective(Warning record);

    int updateByPrimaryKey(Warning record);
}