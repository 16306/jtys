package com.mapper;

import com.entity.FamilyHistory;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface FamilyHistoryMapper {
    int deleteByPrimaryKey(Long familyHistoryId);

    int insert(FamilyHistory record);

    int insertSelective(FamilyHistory record);

    FamilyHistory selectByPrimaryKey(Long familyHistoryId);

    List<FamilyHistory> selectByCardId(String cardId);

    FamilyHistory getAll();

    int updateByPrimaryKeySelective(FamilyHistory record);

    int updateByPrimaryKey(FamilyHistory record);
}