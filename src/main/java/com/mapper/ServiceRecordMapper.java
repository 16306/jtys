package com.mapper;

import com.entity.ServiceRecord;

public interface ServiceRecordMapper {
    int deleteByPrimaryKey(Long serviceId);

    int insert(ServiceRecord record);

    int insertSelective(ServiceRecord record);

    ServiceRecord selectByPrimaryKey(Long serviceId);

    int updateByPrimaryKeySelective(ServiceRecord record);

    int updateByPrimaryKey(ServiceRecord record);
}