package com.mapper;

import com.entity.OperationHistory;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface OperationHistoryMapper {
    int deleteByPrimaryKey(Long operationId);

    int insert(OperationHistory record);

    int insertSelective(OperationHistory record);

    OperationHistory selectByPrimaryKey(Long operationId);

    List<OperationHistory> selectByCardId(String cardId);

    OperationHistory getLastOne();

    int updateByPrimaryKeySelective(OperationHistory record);

    int updateByPrimaryKey(OperationHistory record);
}