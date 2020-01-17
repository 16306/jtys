package com.mapper;

import com.entity.ObstericalHistory;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ObstericalHistoryMapper {
    int deleteByPrimaryKey(Long obstericalId);

    int insert(ObstericalHistory record);

    int insertSelective(ObstericalHistory record);

    ObstericalHistory selectByPrimaryKey(Long obstericalId);

    List<ObstericalHistory> selectByCardId(String cardId);

    ObstericalHistory getLastOne();

    int updateByPrimaryKeySelective(ObstericalHistory record);

    int updateByPrimaryKey(ObstericalHistory record);
}