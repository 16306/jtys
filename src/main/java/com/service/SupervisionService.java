package com.service;

import com.entity.Doctor;
import com.entity.Evaluation;
import com.entity.Family;
import com.entity.FamilyMember;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.DoctorGroupMapper;
import com.mapper.DoctorMapper;
import com.mapper.EvaluationMapper;
import com.mapper.FamilyMapper;
import com.mapper.FamilyMemberMapper;
import com.util.FindUser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupervisionService
{
  @Autowired
  private FamilyDoctorService familyDoctorService;

  @Autowired
  private FamilyMapper familyMapper;

  @Autowired
  private FamilyMemberMapper familyMemberMapper;

  @Autowired
  private DoctorGroupMapper doctorGroupMapper;

  @Autowired
  private DoctorMapper doctorMapper;

  @Autowired
  private EvaluationMapper evaluationMapper;


  /**
   * 查找医院签约信息
   * @return
   */
  public Map<String, Object> get_sign_info()
  {
    Map<String, Object> result = new HashMap<>();
    List<Long> no_sign = familyDoctorService.selectByNoContract((long)-1);
    List<Long> sign = familyDoctorService.selectByNoContract((long)1);
    result.put("no_sign",no_sign.size());
    result.put("sign",sign.size());
    return result;
  }

  /**
   * 查找医院人员信息
   * @return
   */
  public Map<String,Object> get_people_info()
  {
    Map<String, Object> result = new HashMap<>();
    FindUser findUser = new FindUser();
    com.entity.User user = findUser.getuser();
    Long hoapitalId = user.getHospitalId();
    int family = familyMapper.getAllFamilyList(hoapitalId).size();
    int familyMember = 0;
    for(Family familyItem:familyMapper.getAllFamilyList(hoapitalId))
    {
      familyMember += familyMemberMapper.getAllMemberList(familyItem.getFamilyId()).size();
    }
    int doctorGroup = doctorGroupMapper.getAllDoctorGroupList(hoapitalId,"null","null","null").size();
    int doctor = doctorMapper.getAllDoctorList(hoapitalId).size();
    result.put("family",family);
    result.put("familyMember",familyMember);
    result.put("doctorGroup",doctorGroup);
    result.put("doctor",doctor);
    return result;
  }

  /**
   * 数据处理
   * @param Evaluator
   * @param EvaluationContent
   * @param Name
   * @param Time
   * @return
   */
  public Map<Object,Object> setResult(Object Evaluator,Object EvaluationContent,Object Name,Object Time)
  {
    Map<Object, Object> result = new HashMap<>();
    result.put("evaluator",Evaluator);
    result.put("evaluationContent",EvaluationContent);
    result.put("doctor",Name);
    result.put("time",Time);
    return result;
  }

  /**
   * 查找评价信息
   * @param page
   * @param limit
   * @param mark
   * @param Evaluator
   * @param doctorName
   * @return
   */
  public PageInfo<Map<Object, Object>> get_estimate_info(int page,int limit,int mark,String Evaluator, String doctorName)
  {
    if(mark==1) {
      PageHelper.startPage(page, limit);      //分页核心代码
    }
    FindUser findUser = new FindUser();
    com.entity.User user = findUser.getuser();
    List<Map<Object, Object>> list= new ArrayList<Map<Object, Object>>();
    List<Evaluation> evaluations = evaluationMapper.selectAll();
    Map<Object, Object> result = null;
    for(Evaluation evaluation:evaluations)
    {
      Doctor doctor = doctorMapper.selectByPrimaryKey(evaluation.getDoctorId());
      if(doctor.getHospitalId().equals(user.getHospitalId()) && Evaluator.equals("null") && doctorName.equals("null"))
      {
        result = setResult(evaluation.getEvaluator(),evaluation.getEvaluationContent(),doctor.getName(),evaluation.getTime());
        list.add(result);
      }
      else if((evaluation.getEvaluator().matches(".*"+Evaluator+".*") || doctor.getName().matches(".*"+doctorName+".*")) && doctor.getHospitalId().equals(user.getHospitalId()))
      {
        result = setResult(evaluation.getEvaluator(),evaluation.getEvaluationContent(),doctor.getName(),evaluation.getTime());
        list.add(result);
      }
    }
    return new PageInfo<>(list);
  }

}
