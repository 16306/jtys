package com.mapper;

import com.entity.Case;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CaseMapper {
    int deleteByPrimaryKey(Long caseId);

    int insert(Case record);

    int insertSelective(Case record);

    Case selectByPrimaryKey(Long caseId);

    Case getAll();

    List<Case> selectByCardId(String cardId);

    int updateByPrimaryKeySelective(Case record);

    int updateByPrimaryKey(Case record);
}