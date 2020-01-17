package com.controller;


import com.entity.AllergyHistory;
import com.entity.Case;
import com.entity.Doctor;
import com.entity.FamilyHistory;
import com.entity.FamilyMember;
import com.entity.FollowUp;
import com.entity.HealthKnowledge;
import com.entity.Hospitalization;
import com.entity.Inspection;
import com.entity.Medication;
import com.entity.Notice;
import com.entity.ObstericalHistory;
import com.entity.OperationHistory;
import com.entity.PastHistory;
import com.entity.Surgery;
import com.google.gson.Gson;
import com.service.CaseService;
import com.service.FamilyAppService;
import com.service.HistoryService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/familyApp")
public class FamilyAppController
{

  @Autowired
  private FamilyAppService familyAppService;

  @Autowired
  private CaseService caseService;

  @Autowired
  private HistoryService historyService;

  @ResponseBody
  @PostMapping("/login")
  public Map<Object,Object> login(@RequestBody FamilyMember familyMember)
  {
    Map<Object,Object> result = new HashMap<>();
    if(familyAppService.login(familyMember) != null)
    {
      result.put("user_info", familyAppService.login(familyMember));
      result.put("status",1);
      return result;
    }
    result.put("status",0);
    return result;
  }

  @ResponseBody
  @PostMapping("/getFamilyMember")
  public Map<Object,Object> getFamilyMember(@RequestBody Map<Object,Object> requests)
  {
    Map<Object,Object> result = new HashMap<>();
    if(null != familyAppService.getAllMember(((Number) requests.get("familyId")).longValue()) && (int)requests.get("status") == 1)
    {
      result.put("member_info", familyAppService.getAllMember(((Number) requests.get("familyId")).longValue()));
      result.put("status",1);
      return result;
    }
    result.put("status",0);
    return result;
  }

  @ResponseBody
  @PostMapping("/findDoctor")
  public Map<Object,Object> findDoctor(@RequestBody Map<Object,Object> requests)
  {
    Map<Object,Object> result = new HashMap<>();
    List<Doctor> doctors = familyAppService.getDoctor(((Number) requests.get("familyId")).longValue());
    if(null != doctors && (int)requests.get("status") == 1)
    {
      result.put("member_info", doctors);
      result.put("status",1);
      return result;
    }
    result.put("status",0);
    return result;
  }

  @ResponseBody
  @PostMapping("/getNotice")
  public Map<Object,Object> getNotice(@RequestBody Map<Object,Object> requests)
  {
    Map<Object,Object> result = new HashMap<>();
    List<Notice> list = familyAppService.getAllNotice(((Number) requests.get("familyId")).longValue(),(String)requests.get("title"),(String)requests.get("publisher"));
    if(null !=  list && (int)requests.get("status") == 1)
    {
      result.put("Notice", list);
      result.put("status",1);
      return result;
    }
    result.put("status",0);
    return result;
  }

  @ResponseBody
  @PostMapping("/getAllCase")
  public Map<Object,Object> getAllCase(@RequestBody Map<Object,Object> requests)
  {
    Map<Object,Object> result = new HashMap<>();
    List<Case> list = caseService.getAllCase((String)requests.get("cardId"));
    if(null !=  list && (int)requests.get("status") == 1)
    {
      result.put("Case", list);
      result.put("status",1);
      return result;
    }
    result.put("status",0);
    return result;
  }

  @ResponseBody
  @PostMapping("/getAllHospitalization")
  public Map<Object,Object> getAllHospitalization(@RequestBody Map<Object,Object> requests)
  {
    Map<Object,Object> result = new HashMap<>();
    List<Hospitalization> list = caseService.getAllHospitalization((String)requests.get("cardId"));
    if(null !=  list && (int)requests.get("status") == 1)
    {
      result.put("Hospitalization", list);
      result.put("status",1);
      return result;
    }
    result.put("status",0);
    return result;
  }

  @ResponseBody
  @PostMapping("/getAllInspection")
  public Map<Object,Object> getAllInspection(@RequestBody Map<Object,Object> requests)
  {
    Map<Object,Object> result = new HashMap<>();
    List<Inspection> list = caseService.getAllInspection((String)requests.get("cardId"));
    if(null !=  list && (int)requests.get("status") == 1)
    {
      result.put("Inspection", list);
      result.put("status",1);
      return result;
    }
    result.put("status",0);
    return result;
  }

  @ResponseBody
  @PostMapping("/getAllMedication")
  public Map<Object,Object> getAllMedication(@RequestBody Map<Object,Object> requests)
  {
    Map<Object,Object> result = new HashMap<>();
    List<Medication> list = caseService.getAllMedication((String)requests.get("cardId"));
    if(null !=  list && (int)requests.get("status") == 1)
    {
      result.put("Medication", list);
      result.put("status",1);
      return result;
    }
    result.put("status",0);
    return result;
  }

  @ResponseBody
  @PostMapping("/getAllSurgery")
  public Map<Object,Object> getAllSurgery(@RequestBody Map<Object,Object> requests)
  {
    Map<Object,Object> result = new HashMap<>();
    List<Surgery> list = caseService.getAllSurgery((String)requests.get("cardId"));
    if(null !=  list && (int)requests.get("status") == 1)
    {
      result.put("Surgery", list);
      result.put("status",1);
      return result;
    }
    result.put("status",0);
    return result;
  }

  @ResponseBody
  @PostMapping("/getCase")
  public Map<Object,Object> getCase(@RequestBody Map<Object,Object> requests)
  {
    Map<Object,Object> result = new HashMap<>();
    Map<Object,Object> cases = caseService.getCaseByCaseId(((Number) requests.get("caseId")).longValue());
    if(null !=  cases && (int)requests.get("status") == 1)
    {
      result.put("case", cases);
      result.put("status",1);
      return result;
    }
    result.put("status",0);
    return result;
  }

  @ResponseBody
  @PostMapping("/getAllHealthKnowledge")
  public Map<Object,Object> getAllHealthKnowledge(@RequestBody Map<Object,Object> requests)
  {
    Map<Object,Object> result = new HashMap<>();
    List<HealthKnowledge> list = familyAppService.getAllHealthKnowledge();
    if(null !=  list && (int)requests.get("status") == 1)
    {
      result.put("HealthKnowledge", list);
      result.put("status",1);
      return result;
    }
    result.put("status",0);
    return result;
  }

  @ResponseBody
  @PostMapping("/getAllergyHistory")
  public Map<Object,Object> getAllergyHistory(@RequestBody Map<Object,Object> requests)
  {
    Map<Object,Object> result = new HashMap<>();
    List<AllergyHistory> list = historyService.getAllergyHistory((String)requests.get("cardId"));
    if(null !=  list && (int)requests.get("status") == 1)
    {
      result.put("AllergyHistory", list);
      result.put("status",1);
      return result;
    }
    result.put("status",0);
    return result;
  }

  @ResponseBody
  @PostMapping("/getFamilyHistory")
  public Map<Object,Object> getFamilyHistory(@RequestBody Map<Object,Object> requests)
  {
    Map<Object,Object> result = new HashMap<>();
    List<FamilyHistory> list = historyService.getFamilyHistory((String)requests.get("cardId"));
    if(null !=  list && (int)requests.get("status") == 1)
    {
      result.put("FamilyHistory", list);
      result.put("status",1);
      return result;
    }
    result.put("status",0);
    return result;
  }

  @ResponseBody
  @PostMapping("/getObstericalHistory")
  public Map<Object,Object> getObstericalHistory(@RequestBody Map<Object,Object> requests)
  {
    Map<Object,Object> result = new HashMap<>();
    List<ObstericalHistory> list = historyService.getObstericalHistory((String)requests.get("cardId"));
    if(null !=  list && (int)requests.get("status") == 1)
    {
      result.put("ObstericalHistory", list);
      result.put("status",1);
      return result;
    }
    result.put("status",0);
    return result;
  }

  @ResponseBody
  @PostMapping("/getOperationHistory")
  public Map<Object,Object> getOperationHistory(@RequestBody Map<Object,Object> requests)
  {
    Map<Object,Object> result = new HashMap<>();
    List<OperationHistory> list = historyService.getOperationHistory((String)requests.get("cardId"));
    if(null !=  list && (int)requests.get("status") == 1)
    {
      result.put("OperationHistory", list);
      result.put("status",1);
      return result;
    }
    result.put("status",0);
    return result;
  }


  @ResponseBody
  @PostMapping("/getPastHistory")
  public Map<Object,Object> getPastHistory(@RequestBody Map<Object,Object> requests)
  {
    Map<Object,Object> result = new HashMap<>();
    List<PastHistory> list = historyService.getPastHistory((String)requests.get("cardId"));
    if(null !=  list && (int)requests.get("status") == 1)
    {
      result.put("PastHistory", list);
      result.put("status",1);
      return result;
    }
    result.put("status",0);
    return result;
  }


  @ResponseBody
  @PostMapping("/saveFollowUp")
  public int saveFollowUp(@RequestBody Map<Object,Object> requests)
  {
    Gson gson = new Gson();
    String followjson = gson.toJson(requests.get("followup"));
    FollowUp followUp =  gson.fromJson(followjson, FollowUp.class);
    int status = 0;
    if((int)requests.get("status") == 1)
    {
      status = familyAppService.createFollowUp(followUp);
      return status;
    }
    return status;
  }
}
