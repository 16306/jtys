package com.mapper;

import com.entity.HealthKnowledge;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface HealthKnowledgeMapper {
    int deleteByPrimaryKey(Long healthKnowledgeId);

    int insert(HealthKnowledge record);

    int insertSelective(HealthKnowledge record);

    HealthKnowledge selectByPrimaryKey(Long healthKnowledgeId);

    List<HealthKnowledge> getHealthKnowledgeList(String reviewStatus,@Param("title") String title);

    List<HealthKnowledge> selectByPublisherId(Long publisherId,@Param("title") String title);

    HealthKnowledge getLastOng();

    int updateByPrimaryKeySelective(HealthKnowledge record);

    int updateByPrimaryKey(HealthKnowledge record);
}