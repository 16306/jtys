package com.controller;


import com.github.pagehelper.PageInfo;
import com.service.DoctorGroupService;
import com.service.DoctorService;
import com.service.FamilyMemberService;
import com.service.FamilyService;
import com.service.SupervisionService;
import com.util.SetData;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/supervision")
public class SupervisionController
{
  @Autowired
  private SupervisionService supervisionService;

  @RequestMapping("/sign")
  @PreAuthorize("hasPermission('/supervision/sign','r')")
  public String sign()
  {
    return "/supervision/sign";
  }

  @ResponseBody
  @PostMapping("/sign_info")
  @PreAuthorize("hasPermission('/supervision/sign','r')")
  public Map<String, Object> get_sign_info()
  {
    return supervisionService.get_sign_info();
  }

  @ResponseBody
  @PostMapping("/people_info")
  @PreAuthorize("hasPermission('/supervision/sign','r')")
  public Map<String, Object> get_people_info()
  {
    return supervisionService.get_people_info();
  }

  @RequestMapping("/estimate")
  @PreAuthorize("hasPermission('/supervision/estimate','r')")
  public String estimate()
  {
    return "/supervision/estimate";
  }

  @ResponseBody
  @RequestMapping("/estimate_info")
  @PreAuthorize("hasPermission('/supervision/estimate','r')")
  public Map<String, Object> get_estimate_info(@RequestParam("page")int page, @RequestParam("limit")int limit,
      @RequestParam(value = "Evaluator",defaultValue = "null")String Evaluator,
      @RequestParam(value = "doctorName",defaultValue = "null")String doctorName)
  {
    PageInfo pageInfo;
    pageInfo = supervisionService.get_estimate_info(page,limit,1,Evaluator,doctorName);
    Map<String, Object> result = SetData.setdata(pageInfo);
    return result;
  }

}
