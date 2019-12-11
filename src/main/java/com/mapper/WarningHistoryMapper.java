package com.mapper;

import com.entity.WarningHistory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface WarningHistoryMapper {
    int deleteByPrimaryKey(Long warningHistoryId);

    int insert(WarningHistory record);

    int insertSelective(WarningHistory record);

    WarningHistory selectByPrimaryKey(Long warningHistoryId);

    int updateByPrimaryKeySelective(WarningHistory record);

    int updateByPrimaryKey(WarningHistory record);
}