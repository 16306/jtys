package com.service;


import com.entity.Case;
import com.entity.Family;
import com.entity.FamilyMember;
import com.entity.HealthKnowledge;
import com.entity.Inspection;
import com.entity.Notice;
import com.mapper.CaseMapper;
import com.mapper.DoctorGroupMapper;
import com.mapper.DoctorMapper;
import com.mapper.FamilyMapper;
import com.mapper.FamilyMemberMapper;
import com.mapper.HealthKnowledgeMapper;
import com.mapper.InspectionMapper;
import com.mapper.NoticeMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
  private InspectionMapper inspectionMapper;

  @Autowired
  private CaseMapper caseMapper;

  @Autowired
  private HealthKnowledgeMapper healthKnowledgeMapper;

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

  public List<Inspection> getAllInspection(String cardId)
  {
    List<Case> cases = caseMapper.selectByCardId(cardId);
    List<Inspection> inspection = new ArrayList<>();
    if(null != cases)
    {
      for(Case item : cases)
      {
        inspection.add(inspectionMapper.selectByCaseId(item.getCaseId()));
      }
    }
    return inspection;
  }

  public List<HealthKnowledge> getAllHealthKnowledge()
  {
    return healthKnowledgeMapper.getHealthKnowledgeList("1");
  }

}
