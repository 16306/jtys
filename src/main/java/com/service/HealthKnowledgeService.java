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

  public PageInfo<HealthKnowledge> selectByPublisherId(Long publisherId,int page,int limit,int mark)
  {
    if(mark==1) {
      PageHelper.startPage(page, limit);
    }
    List<HealthKnowledge> list = healthKnowledgeMapper.selectByPublisherId(publisherId);
    PageInfo<HealthKnowledge> pageInfo = new PageInfo<>(list);
    return pageInfo;
  }

  public HealthKnowledge getLastOng()
  {
    return healthKnowledgeMapper.getLastOng();
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

  /**
   * 得到某个状态的HealthKnowledge
   * @param reviewStatus
   * @param page
   * @param limit
   * @param mark
   * @return 分页器
   */
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
