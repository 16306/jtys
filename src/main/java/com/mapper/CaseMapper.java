package com.mapper;

import com.entity.Case;

public interface CaseMapper {
    int deleteByPrimaryKey(Long caseId);

    int insert(Case record);

    int insertSelective(Case record);

    Case selectByPrimaryKey(Long caseId);

    int updateByPrimaryKeySelective(Case record);

    int updateByPrimaryKey(Case record);
}