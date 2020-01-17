package com.mapper;

import com.entity.Device;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DeviceMapper
{
    int deleteByPrimaryKey(Long deviceId);

    int insert(Device record);

    int insertSelective(Device record);

    Device selectByPrimaryKey(Long deviceId);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);
}