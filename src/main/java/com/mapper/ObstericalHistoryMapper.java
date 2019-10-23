package com.mapper;

import com.entity.ObstericalHistory;

public interface ObstericalHistoryMapper {
    int deleteByPrimaryKey(Long obstericalId);

    int insert(ObstericalHistory record);

    int insertSelective(ObstericalHistory record);

    ObstericalHistory selectByPrimaryKey(Long obstericalId);

    int updateByPrimaryKeySelective(ObstericalHistory record);

    int updateByPrimaryKey(ObstericalHistory record);
}