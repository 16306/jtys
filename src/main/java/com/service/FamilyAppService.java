package com.service;

import com.entity.Family;
import com.entity.FamilyMember;
import com.entity.FollowUp;
import com.entity.HealthKnowledge;
import com.entity.Notice;
import com.mapper.DoctorGroupMapper;
import com.mapper.DoctorMapper;
import com.mapper.FamilyMapper;
import com.mapper.FamilyMemberMapper;
import com.mapper.FollowUpMapper;
import com.mapper.HealthKnowledgeMapper;
import com.mapper.NoticeMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FamilyAppService
{
  @Autowired
  private FamilyMemberMapper familyMemberMapper;

  @Autowired
  private FamilyMapper familyMapper;

  @Autowired
  private DoctorMapper doctorMapper;

  @Autowired
  private DoctorGroupMapper doctorGroupMapper;

  @Autowired
  private NoticeMapper noticeMapper;

  @Autowired
  private HealthKnowledgeMapper healthKnowledgeMapper;

  @Autowired
  private FollowUpMapper followUpMapper;

  /**
   * familyAPP登录功能
   * @param familyMember
   * @return
   */
  public FamilyMember login(FamilyMember familyMember)
  {
    FamilyMember member = familyMemberMapper.selectByCardId(familyMember.getCardId());
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    if(null != member && passwordEncoder.matches(familyMember.getPassword(),member.getPassword()))
    {
      member.setPassword("protected");
    }
    return member;
  }

  /**
   * 查找相同familyId的家庭成员
   * @param familyId
   * @return
   */
  public List<FamilyMember> getAllMember(Long familyId)
  {
    List<FamilyMember> members = new ArrayList<>();
    List<FamilyMember> list = familyMemberMapper.getAllMemberList(familyId);
    if(null != list)
    {
      for(FamilyMember familyMember : list)
      {
        familyMember.setPassword("protected");
        members.add(familyMember);
      }
    }
    return members;
  }

  /**
   * 查找家庭所在的医院的通知
   * @param familyId
   * @param title
   * @param publisher
   * @return
   */
  public List<Notice> getAllNotice(Long familyId, String title, String publisher)
  {
    Family family = familyMapper.selectByPrimaryKey(familyId);
    List<Notice> notice = null;
    if(null != family)
    {
      notice = noticeMapper.getNoticeList(family.getHospitalId(), title, publisher);
    }
    return notice;
  }

  /**
   * 查找所有过审了的健康知识
   * @return
   */
  public List<HealthKnowledge> getAllHealthKnowledge()
  {
    return healthKnowledgeMapper.getHealthKnowledgeList("1");
  }

  /**
   * 创建随访记录
   * @param record
   * @return
   */
  @Transactional(rollbackFor=Exception.class)
  public int createFollowUp(FollowUp record)
  {
    FollowUp followUp = followUpMapper.getAll();
    if(null == followUp)
    {
      record.setFollowUpId((long)0);
    }
    else
    {
      record.setFollowUpId(followUp.getFollowUpId()+1);
    }
    return followUpMapper.insert(record);
  }


}
