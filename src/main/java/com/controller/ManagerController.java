package com.controller;

import com.entity.HealthKnowledge;
import com.entity.Notice;
import com.github.pagehelper.PageInfo;
import com.service.HealthKnowledgeService;
import com.service.NoticeService;
import com.util.FindUser;
import com.util.SetData;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/manager")
public class ManagerController
{
  @Autowired
  private NoticeService noticeService;

  @Autowired
  private HealthKnowledgeService healthKnowledgeService;

  @RequestMapping("/inform")
  @PreAuthorize("hasPermission('/manager/inform','r')")
  public String inform()
  {
    return "manager/manager_inform";
  }

  @ResponseBody
  @RequestMapping("/getNoticeList")
  @PreAuthorize("hasPermission('/manager/inform','r')")
  public Map<String, Object> get_notice_list(@RequestParam("page")int page, @RequestParam("limit")int limit,
                                             @RequestParam(value = "title",defaultValue = "null")String title,
                                             @RequestParam(value = "publisher",defaultValue = "null")String publisher)
  {
    FindUser findUser = new FindUser();
    com.entity.User user = findUser.getuser();
    PageInfo<Notice> pageInfo;
    pageInfo = noticeService.getNoticeList(user.getHospitalId(),title,publisher,page,limit,1);
    Map<String, Object> result = SetData.setdata(pageInfo);
    return result;
  }

  @ResponseBody
  @PostMapping("/deleteById")
  @PreAuthorize("hasPermission('/manager/inform','d')")
  public String deleteById(Long id)
  {
    int a = noticeService.deleteByPrimaryKey(id);
    return "删除成功";
  }

  @GetMapping("/addNotice")
  @PreAuthorize("hasPermission('/manager/inform','c')")
  public String addNotice()
  {
   return "manager/addNotice";
  }

  @ResponseBody
  @PostMapping("/save")
  @PreAuthorize("hasPermission('/manager/inform','c')")
  public String save(Notice notice)
  {
    FindUser findUser = new FindUser();
    com.entity.User user = findUser.getuser();
    Long id = noticeService.getLastOne().getNoticeId() + 1;
    notice.setNoticeId(id);
    notice.setPublisher(user.getUserName());
    notice.setHospitalId(user.getHospitalId());
    int s = noticeService.insert(notice);
    if(s == 1)
    {
      return "success";
    } else {
      return "error";
    }
  }

  @GetMapping("/showNotice")
  @PreAuthorize("hasPermission('/manager/inform','r')")
  public String showNotice(Model model, Long id)
  {
    Notice notice = noticeService.selectByPrimaryKey(id);
    model.addAttribute("notice", notice);
    return "manager/showNotice";
  }

  @ResponseBody
  @GetMapping("/batchdelnotice")
  @PreAuthorize("hasPermission('/manager/inform','d')")
  public String batchDelNotice(String ids){
    List<String> listIds= Arrays.asList(ids.split(","));
    List<Long> listId = new ArrayList<>();
    for(String id : listIds)
    {
      listId.add(Long.parseLong(id));
    }
    noticeService.batchDeleteNotice(listId);
    return "批量删除操作成功！";
  }


  @RequestMapping("/audit")
  @PreAuthorize("hasPermission('/manager/audit','d&u&r')")
  public String audit()
  {
    return "manager/audit";
  }

  @ResponseBody
  @RequestMapping("/getHealthKnowledgeList")
  @PreAuthorize("hasPermission('/manager/audit','d&u&r')")
  public Map<String, Object> getHealthKnowledgeList(
      @RequestParam("page")int page, @RequestParam("limit")int limit,
      @RequestParam(value = "title",defaultValue = "null")String title)
  {
    PageInfo<HealthKnowledge> pageInfo;
    pageInfo = healthKnowledgeService.getHealthKnowledgeList("0",title,page,limit,1);

    Map<String, Object> result = SetData.setdata(pageInfo);

    return result;
  }

  @GetMapping("/showHealthKnowledge")
  @PreAuthorize("hasPermission('/manager/audit','r')")
  public String showHealthKnowledge(Model model, Long id)
  {
    HealthKnowledge healthKnowledge = healthKnowledgeService.selectByPrimaryKey(id);
    model.addAttribute("healthKnowledge", healthKnowledge);
    return "manager/showHealthKnowledge";
  }

  @ResponseBody
  @GetMapping("/agreeHealthKnowledge")
  @PreAuthorize("hasPermission('/manager/audit','r')")
  public String agreeHealthKnowledge(Long id)
  {
    return setRiewStatus(id,"1");
  }

  @ResponseBody
  @GetMapping("/disagreeHealthKnowledge")
  @PreAuthorize("hasPermission('/manager/audit','r')")
  public String disagreeHealthKnowledge(Long id)
  {
    return setRiewStatus(id,"-1");
  }


  private String setRiewStatus(Long id, @NotNull  String riewStatus)
  {
    FindUser findUser = new FindUser();
    com.entity.User user = findUser.getuser();
    HealthKnowledge healthKnowledge = healthKnowledgeService.selectByPrimaryKey(id);
    healthKnowledge.setReviewStatus(riewStatus);
    healthKnowledge.setReviewer(user.getUserName());
    healthKnowledge.setReviewTime(SetData.setDate());
    if(healthKnowledgeService.updateByPrimaryKey(healthKnowledge) == 1)
    {
      return "success";
    }else{
      return "error";
    }
  }

}
