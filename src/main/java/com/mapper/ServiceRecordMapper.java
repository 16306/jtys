package com.mapper;

import com.entity.ServiceRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ServiceRecordMapper {
    int deleteByPrimaryKey(Long serviceId);

    int insert(ServiceRecord record);

    int insertSelective(ServiceRecord record);

    ServiceRecord selectByPrimaryKey(Long serviceId);

    int updateByPrimaryKeySelective(ServiceRecord record);

    int updateByPrimaryKey(ServiceRecord record);
}