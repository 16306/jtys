package com.mapper;

import com.entity.HealthKnowledge;

public interface HealthKnowledgeMapper {
    int deleteByPrimaryKey(Long healthKnowledgeId);

    int insert(HealthKnowledge record);

    int insertSelective(HealthKnowledge record);

    HealthKnowledge selectByPrimaryKey(Long healthKnowledgeId);

    int updateByPrimaryKeySelective(HealthKnowledge record);

    int updateByPrimaryKey(HealthKnowledge record);
}