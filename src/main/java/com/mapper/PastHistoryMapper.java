package com.mapper;

import com.entity.PastHistory;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface PastHistoryMapper {
    int deleteByPrimaryKey(Long pastId);

    int insert(PastHistory record);

    int insertSelective(PastHistory record);

    PastHistory selectByPrimaryKey(Long pastId);

    List<PastHistory> selectByCardId(String cardId);

    PastHistory getAll();

    int updateByPrimaryKeySelective(PastHistory record);

    int updateByPrimaryKeyWithBLOBs(PastHistory record);

    int updateByPrimaryKey(PastHistory record);
}