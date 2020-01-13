package com.controller;


import com.entity.FamilyMember;
import com.entity.FollowUp;
import com.entity.HealthKnowledge;
import com.entity.Inspection;
import com.entity.Notice;
import com.google.gson.Gson;
import com.service.FamilyAppService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/familyApp")
public class FamilyAppController
{

  @Autowired
  private FamilyAppService familyAppService;

  @ResponseBody
  @PostMapping("/login")
  public Map<Object,Object> login(FamilyMember familyMember)
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
  public Map<Object,Object> getFamilyMember(Map<Object,Object> requests)
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
  @PostMapping("/getAllInspection")
  public Map<Object,Object> getAllInspection(@RequestBody Map<Object,Object> requests)
  {
    Map<Object,Object> result = new HashMap<>();
    List<Inspection> list = familyAppService.getAllInspection((String)requests.get("cardId"));
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
