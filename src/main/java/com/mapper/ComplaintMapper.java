package com.mapper;

import com.entity.Complaint;

public interface ComplaintMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Complaint record);

    int insertSelective(Complaint record);

    Complaint selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Complaint record);

    int updateByPrimaryKey(Complaint record);
}