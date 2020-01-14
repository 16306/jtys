package com.mapper;

import com.entity.AllergyHistory;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AllergyHistoryMapper {
    int deleteByPrimaryKey(Long allergyId);

    int insert(AllergyHistory record);

    int insertSelective(AllergyHistory record);

    AllergyHistory selectByPrimaryKey(Long allergyId);

    List<AllergyHistory> selectByCardId(String cardId);

    AllergyHistory getAll();

    int updateByPrimaryKeySelective(AllergyHistory record);

    int updateByPrimaryKey(AllergyHistory record);
}