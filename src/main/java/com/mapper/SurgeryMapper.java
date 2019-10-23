package com.mapper;

import com.entity.Surgery;

public interface SurgeryMapper {
    int deleteByPrimaryKey(Long surgeryId);

    int insert(Surgery record);

    int insertSelective(Surgery record);

    Surgery selectByPrimaryKey(Long surgeryId);

    int updateByPrimaryKeySelective(Surgery record);

    int updateByPrimaryKey(Surgery record);
}