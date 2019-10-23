package com.mapper;

import com.entity.Hospitalization;

public interface HospitalizationMapper {
    int deleteByPrimaryKey(Long hospitalizationId);

    int insert(Hospitalization record);

    int insertSelective(Hospitalization record);

    Hospitalization selectByPrimaryKey(Long hospitalizationId);

    int updateByPrimaryKeySelective(Hospitalization record);

    int updateByPrimaryKey(Hospitalization record);
}