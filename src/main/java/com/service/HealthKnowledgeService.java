package com.service;


import com.entity.HealthKnowledge;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.HealthKnowledgeMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HealthKnowledgeService
{
  @Autowired
  private HealthKnowledgeMapper healthKnowledgeMapper;

  public HealthKnowledge selectByPrimaryKey(Long healthKnowledgeId)
  {
    return healthKnowledgeMapper.selectByPrimaryKey(healthKnowledgeId);
  }

  @Transactional
  public int deleteByPrimaryKey(Long healthKnowledgeId)
  {
    return healthKnowledgeMapper.deleteByPrimaryKey(healthKnowledgeId);
  }

  @Transactional
  public int insert(HealthKnowledge record)
  {
    return healthKnowledgeMapper.insert(record);
  }

  public PageInfo<HealthKnowledge> getHealthKnowledgeList(String reviewStatus,int page,int limit,int mark)
  {
    if(mark==1) {
      PageHelper.startPage(page, limit);
    }
    List<HealthKnowledge> list = healthKnowledgeMapper.getHealthKnowledgeList(reviewStatus);
    PageInfo<HealthKnowledge> pageInfo = new PageInfo<>(list);
    return pageInfo;
  }

  @Transactional
  public int updateByPrimaryKey(HealthKnowledge record)
  {
    return healthKnowledgeMapper.updateByPrimaryKey(record);
  }
}
