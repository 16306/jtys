package com.service;

import com.entity.ServiceRecord;
import com.entity.ServiceRecordExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.DoctorGroupMapper;
import com.mapper.FamilyMapper;
import com.mapper.FamilyMemberMapper;
import com.mapper.ServiceRecordMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceRecordService
{
  @Autowired
  private ServiceRecordMapper serviceRecordMapper;

  @Autowired
  private FamilyMemberMapper familyMemberMapper;

  @Autowired
  private FamilyMapper familyMapper;

  @Autowired
  private DoctorGroupMapper doctorGroupMapper;


  /**
   * 处理数据
   * @param familyMemberName
   * @param familyHouseholderName
   * @param doctorGroupLeaderName
   * @param time
   * @param type
   * @param content
   * @param evaluation
   * @return
   */
  public Map<Object,Object> setResult(Object familyMemberName, Object familyHouseholderName, Object doctorGroupLeaderName, Object time, Object type, Object content, Object evaluation)
  {
    Map<Object, Object> result = new HashMap<>();
    result.put("familyMemberName",familyMemberName);
    result.put("familyHouseholderName",familyHouseholderName);
    result.put("doctorGroupLeaderName",doctorGroupLeaderName);
    result.put("time",time);
    result.put("type",type);
    result.put("content",content);
    result.put("evaluation",evaluation);
    return result;
  }


  /**
   * 查找某一医院的服务记录，允许通过FamilyMemberName和DoctorLeaderName筛选数据
   * @param id
   * @param page
   * @param limit
   * @param mark
   * @param MemberName
   * @param LeaderName
   * @return 分页器
   */
  public PageInfo<Map<Object, Object>> selectByHospitalId(Long id,int page,int limit,int mark,String MemberName, String LeaderName)
  {
    if(mark==1) {
      PageHelper.startPage(page, limit);      //分页核心代码
    }
    List<Map<Object, Object>> list= new ArrayList<Map<Object, Object>>();
    ServiceRecordExample example = new ServiceRecordExample();
    ServiceRecordExample.Criteria criteria = example.createCriteria();
    criteria.andHospitalIdEqualTo(id);
    List<ServiceRecord> serviceRecords = serviceRecordMapper.selectByExample(example);
    Map<Object, Object> result = null;
    for(ServiceRecord serviceRecord : serviceRecords)
    {
      String familyMemberName = familyMemberMapper.selectByPrimaryKey(serviceRecord.getFamilyMemberId()).getName();
      String familyHouseholderName = familyMapper.selectByPrimaryKey(serviceRecord.getFamilyId()).getHouseholderName();
      String doctorGroupLeaderName = doctorGroupMapper.selectByPrimaryKey(serviceRecord.getDoctorGroupId()).getGroupLeaderName();
      if(MemberName.equals("null") && LeaderName.equals("null"))
      {
        result = setResult(familyMemberName,familyHouseholderName,doctorGroupLeaderName,serviceRecord.getServiceTime(),serviceRecord.getServiceType(),serviceRecord.getServiceContent(),serviceRecord.getServiceEvaluation());
        list.add(result);
      }
      else if(familyMemberName.matches(".*"+MemberName+".*") || doctorGroupLeaderName.matches(".*"+LeaderName+".*"))
      {
        result = setResult(familyMemberName,familyHouseholderName,doctorGroupLeaderName,serviceRecord.getServiceTime(),serviceRecord.getServiceType(),serviceRecord.getServiceContent(),serviceRecord.getServiceEvaluation());
        list.add(result);
      }

    }
    return new PageInfo<>(list);
  }




}
