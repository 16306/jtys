package com.mapper;

import com.entity.ServiceRecord;
import com.entity.ServiceRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ServiceRecordMapper {
    int countByExample(ServiceRecordExample example);

    int deleteByExample(ServiceRecordExample example);

    int deleteByPrimaryKey(Long serviceId);

    int insert(ServiceRecord record);

    int insertSelective(ServiceRecord record);

    List<ServiceRecord> selectByExample(ServiceRecordExample example);

    ServiceRecord selectByPrimaryKey(Long serviceId);

    int updateByExampleSelective(@Param("record") ServiceRecord record, @Param("example") ServiceRecordExample example);

    int updateByExample(@Param("record") ServiceRecord record, @Param("example") ServiceRecordExample example);

    int updateByPrimaryKeySelective(ServiceRecord record);

    int updateByPrimaryKey(ServiceRecord record);
}