package com.mapper;

import com.entity.SelfCheck;

public interface SelfCheckMapper {
    int deleteByPrimaryKey(Long selfCheckId);

    int insert(SelfCheck record);

    int insertSelective(SelfCheck record);

    SelfCheck selectByPrimaryKey(Long selfCheckId);

    int updateByPrimaryKeySelective(SelfCheck record);

    int updateByPrimaryKey(SelfCheck record);
}