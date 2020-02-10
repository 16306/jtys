package com.controller;

import com.entity.Threshold;
import com.entity.WarningHistory;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.*;
import com.util.MyPageHelper;
import com.util.SetData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/warning")
public class WarningContorller
{
  @Autowired
  private FamilyDoctorService familyDoctorService;

  @Autowired
  private FamilyService familyService;

  @Autowired
  private FamilyMemberService familyMemberService;

  @Autowired
  private WarningService warningService;

  @Autowired
  private ThresholdService thresholdService;


  @GetMapping("/warning_info")
  @PreAuthorize("hasPermission('/warning/warning_info','r')")
  public String warning_info()
  {
    return "warning/warning_info/warning";
  }

  @GetMapping("/showFamilyMemberList")
  @PreAuthorize("hasPermission('/warning/warning_info','r')")
  public String showFamilyMember()
  {
    return "warning/warning_info/familyMember";
  }

  @GetMapping("/getMemberWarning")
  @PreAuthorize("hasPermission('/warning/warning_info','r')")
  public String getMemberWarning(Model model, String id)
  {
    model.addAttribute("cardId", id);
    return "warning/warning_info/getMemberWarning";
  }

  @GetMapping("/history_info")
@PreAuthorize("hasPermission('/warning/history_info','r')")
public String history_info()
{
  return "warning/history_info/history_info";
}

  @GetMapping("/history_info/showFamilyMemberList")
  @PreAuthorize("hasPermission('/warning/history_info','r')")
  public String showMember()
  {
    return "warning/history_info/familyMember";
  }

  @GetMapping("/history_info/getMemberWarning")
  @PreAuthorize("hasPermission('/warning/history_info','r')")
  public String getHistory(Model model, String id)
  {
    model.addAttribute("cardId", id);
    return "warning/history_info/getMemberWarning";
  }

  @GetMapping("/set_threshold")
  @PreAuthorize("hasPermission('/warning/set_threshold','r')")
  public String set_threshold()
  {
    return "warning/threshold/threshold";
  }

  @GetMapping("/set_threshold/showFamilyMemberList")
  @PreAuthorize("hasPermission('/warning/history_info','r')")
  public String showMemberThreshold()
  {
    return "warning/threshold/familyMember";
  }

  @GetMapping("/set_threshold/getThreshold")
  @PreAuthorize("hasPermission('/warning/history_info','r')")
  public String getThreshold(Model model, String id)
  {
    model.addAttribute("cardId", id);
    return "warning/threshold/getThreshold";
  }

  @GetMapping("/addThreshold")
  @PreAuthorize("hasPermission('/warning/set_threshold','r&c')")
  public String addThreshold(Model model, String cardId)
  {
    model.addAttribute("cardId", cardId);
    return "warning/threshold/addThreshold";
  }

  @GetMapping("/updateThreshold")
  @PreAuthorize("hasPermission('/warning/set_threshold','r&c')")
  public String updateThreshold(Model model, Long id)
  {
    Threshold threshold = thresholdService.selectByPrimaryKey(id);
    model.addAttribute("threshold", threshold);
    return "warning/threshold/updateThreshold";
  }

  @ResponseBody
  @RequestMapping("/deleteThreshold")
  public int deleteThreshold(Long id)
  {
    return thresholdService.delete(id);
  }

  @ResponseBody
  @RequestMapping("/selectThresholdByCardId")
  public Map<String, Object> selectThresholdByCardId(String cardId,@RequestParam("page")int page, @RequestParam("limit")int limit)
  {
    return thresholdService.selectByCardId(cardId,page-1,limit);
  }

  @ResponseBody
  @PostMapping("/saveThreshold")
  public String insert(Threshold threshold)
  {
    int n = thresholdService.insert(threshold);
    if(n == 1)
    {
      return "success";
    }
    else
    {
      return "error";
    }
  }

  @ResponseBody
  @RequestMapping("/update")
  public String update(Threshold threshold)
  {
    int n = thresholdService.update(threshold);
    if(n == 1)
    {
      return "success";
    }
    else
    {
      return "error";
    }
  }

  @ResponseBody
  @RequestMapping("/selectWarningHistoryByCardId")
  public Map<String, Object> selectWarningHistoryByCardId(String cardId,@RequestParam("page")int page, @RequestParam("limit")int limit)
  {
    List<WarningHistory> warningHistories = warningService.selectByCardId(cardId);
    MyPageHelper myPageInfo = new MyPageHelper<>(warningHistories,page-1,limit);
    if (null != warningHistories)
    {
      return SetData.getStringObjectMap(myPageInfo);
    }
    return SetData.returnNull();
  }


  @ResponseBody
  @RequestMapping("/selectWarningHistoryByTime")
  public Map<String, Object> selectWarningHistoryByTime(String cardId,@RequestParam("page")int page, @RequestParam("limit")int limit)
  {
    PageHelper.startPage(page,limit);
    List<WarningHistory> warningHistories = warningService.selectByTime(cardId);
    PageInfo<WarningHistory> pageInfo = new PageInfo<>(warningHistories);
    return SetData.setdata(pageInfo);
  }

}
