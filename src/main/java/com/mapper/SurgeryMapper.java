package com.mapper;

import com.entity.Surgery;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SurgeryMapper {
    int deleteByPrimaryKey(Long surgeryId);

    int insert(Surgery record);

    int insertSelective(Surgery record);

    Surgery selectByPrimaryKey(Long surgeryId);

    Surgery getAll();

    Surgery selectByCaseId(Long caseId);

    int updateByPrimaryKeySelective(Surgery record);

    int updateByPrimaryKey(Surgery record);
}