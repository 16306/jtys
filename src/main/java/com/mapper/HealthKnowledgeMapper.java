package com.mapper;

import com.entity.HealthKnowledge;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface HealthKnowledgeMapper {
    int deleteByPrimaryKey(Long healthKnowledgeId);

    int insert(HealthKnowledge record);

    int insertSelective(HealthKnowledge record);

    HealthKnowledge selectByPrimaryKey(Long healthKnowledgeId);

    List<HealthKnowledge> getHealthKnowledgeList(String reviewStatus);

    List<HealthKnowledge> selectByPublisherId(Long publisherId);

    HealthKnowledge getLastOng();

    int updateByPrimaryKeySelective(HealthKnowledge record);

    int updateByPrimaryKey(HealthKnowledge record);
}