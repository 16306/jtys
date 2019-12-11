package com.mapper;

import com.entity.device;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface deviceMapper {
    int deleteByPrimaryKey(Long deviceId);

    int insert(device record);

    int insertSelective(device record);

    device selectByPrimaryKey(Long deviceId);

    int updateByPrimaryKeySelective(device record);

    int updateByPrimaryKey(device record);
}