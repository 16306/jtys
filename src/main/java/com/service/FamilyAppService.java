package com.service;


import com.entity.Case;
import com.entity.Family;
import com.entity.FamilyMember;
import com.entity.FollowUp;
import com.entity.HealthKnowledge;
import com.entity.Hospitalization;
import com.entity.Inspection;
import com.entity.Notice;
import com.mapper.CaseMapper;
import com.mapper.DoctorGroupMapper;
import com.mapper.DoctorMapper;
import com.mapper.FamilyMapper;
import com.mapper.FamilyMemberMapper;
import com.mapper.FollowUpMapper;
import com.mapper.HealthKnowledgeMapper;
import com.mapper.HospitalizationMapper;
import com.mapper.InspectionMapper;
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
  private InspectionMapper inspectionMapper;

  @Autowired
  private CaseMapper caseMapper;

  @Autowired
  private HospitalizationMapper hospitalizationMapper;

  @Autowired
  private HealthKnowledgeMapper healthKnowledgeMapper;

  @Autowired
  private FollowUpMapper followUpMapper;

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

  @Transactional(rollbackFor=Exception.class)
  public int createCase(Case record)
  {
    Case item = caseMapper.getAll();
    if(null == item)
    {
      record.setCaseId((long)0);
    }
    else
    {
      record.setCaseId(item.getCaseId()+1);
    }
    return caseMapper.insert(record);
  }

  @Transactional(rollbackFor=Exception.class)
  public int createInspection(Inspection record)
  {
    Inspection item = inspectionMapper.getAll();
    if(null == item)
    {
      record.setInspectionId((long)0);
    }
    else
    {
      record.setInspectionId(item.getInspectionId()+1);
    }
    return inspectionMapper.insert(record);
  }

  @Transactional(rollbackFor=Exception.class)
  public int createHospitalization(Hospitalization record)
  {
    Hospitalization item = hospitalizationMapper.getAll();
    if(null == item)
    {
      record.setHospitalizationId((long)0);
    }
    else
    {
      record.setHospitalizationId(item.getHospitalizationId()+1);
    }
    return hospitalizationMapper.insert(record);
  }



}
