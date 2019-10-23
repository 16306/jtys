package com.mapper;

import com.entity.AllergyHistory;

public interface AllergyHistoryMapper {
    int deleteByPrimaryKey(Long allergyId);

    int insert(AllergyHistory record);

    int insertSelective(AllergyHistory record);

    AllergyHistory selectByPrimaryKey(Long allergyId);

    int updateByPrimaryKeySelective(AllergyHistory record);

    int updateByPrimaryKey(AllergyHistory record);
}