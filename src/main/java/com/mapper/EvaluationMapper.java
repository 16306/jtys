package com.mapper;

import com.entity.Evaluation;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface EvaluationMapper {
    int deleteByPrimaryKey(Long evaluationId);

    int insert(Evaluation record);

    int insertSelective(Evaluation record);

    Evaluation selectByPrimaryKey(Long evaluationId);

    List<Evaluation> selectAll();

    int updateByPrimaryKeySelective(Evaluation record);

    int updateByPrimaryKey(Evaluation record);
}