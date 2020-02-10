package com.controller;

import com.entity.Family;
import com.entity.FamilyDoctor;
import com.service.DoctorGroupService;
import com.service.FamilyDoctorService;
import com.service.FamilyService;
import com.util.FindUser;
import com.util.MyPageHelper;
import com.util.SetData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/info_manager")
public class InfoManagerController
{
  @Autowired
  private FamilyDoctorService familyDoctorService;

  @Autowired
  private FamilyService familyService;

  @Autowired
  private DoctorGroupService doctorGroupService;


  @RequestMapping("/doctor_manager")
  @PreAuthorize("hasPermission('/info_manager/doctor_manager','r')")
  public String doctorGroupInfo()
  {
    return "infoManager/doctor_manager";
  }

  @RequestMapping("/user_manager")
  @PreAuthorize("hasPermission('/info_manager/user_manager','r')")
  public String inform()
  {
    return "infoManager/user_manager";
  }

  @ResponseBody
  @RequestMapping("/Contract")
  @PreAuthorize("hasPermission('/info_manager/user_manager','u')")
  public String contract(String ids)
  {
    List<String> idList = Arrays.asList(ids.split(","));
    Long doctorGroupId = Long.parseLong(idList.get(idList.size() - 1));
    for(int i = 0; i < idList.size() - 1; i++)
    {
      FamilyDoctor familyDoctor = familyDoctorService.selectByFamilyId(Long.parseLong(idList.get(i)));
      familyDoctor.setDoctorGroupId(doctorGroupId);
      familyDoctor.setDateOfContract(SetData.setDate());
      familyDoctor.setContractContent("合同内容");
      familyDoctor.setContractDuration(1);
      familyDoctorService.update(familyDoctor);
    }
    return "s";
  }

  @ResponseBody
  @RequestMapping("/getFamilyList")
  @PreAuthorize("hasPermission('/info_manager/user_manager','r')")
  public Map<String, Object> getFamilyList(@RequestParam("id")long id,@RequestParam("page")int page, @RequestParam("limit")int limit,
      @RequestParam(value = "householderName",defaultValue = "null")String householderName,
      @RequestParam(value = "householderPhone",defaultValue = "null")String householderPhone,
      @RequestParam(value = "address",defaultValue = "null")String address)
  {
    FindUser findUser = new FindUser();
    com.entity.User user = findUser.getuser();

    List<Long> familyIds = familyDoctorService.selectByNoContract(id);
    if(!familyIds.isEmpty())
    {
      List<Family> familyList = new ArrayList<>();
      for(Long familyId : familyIds)
      {
        Family family = familyService.selectByPrimaryKey(familyId);
        if(family.getHospitalId().equals(user.getHospitalId()) && householderName.equals("null") && householderPhone.equals("null") && address.equals("null"))
        {
          familyList.add(family);
        }
        else if(!householderName.isEmpty() || !householderPhone.isEmpty())
        {
          if((family.getHouseholderName().matches(".*"+ householderName + ".*") || family.getHouseholderPhone().matches(".*"+householderPhone+".*") || family.getAddress().matches(".*"+address+".*")) && family.getHospitalId().equals(user.getHospitalId()))
          {
            familyList.add(family);
          }
        }
      }

      return SetData.getStringObjectMap(new MyPageHelper<>(familyList, page, limit));
    }
    return SetData.returnNull();
  }

  @RequestMapping("/showContract")
  @PreAuthorize("hasPermission('/info_manager/doctor_manager','r')")
  public String showContract(Model model)
  {
    String contract = "合约内容";
    model.addAttribute("Contract", contract);
    return "infoManager/showContract";
  }

  @ResponseBody
  @RequestMapping("deleteById")
  @PreAuthorize("hasPermission('/info_manager/doctor_manager','d')")
  public String deleteById(Long id)
  {
    FamilyDoctor familyDoctor = familyDoctorService.selectByFamilyId(id);
    familyDoctor.setDoctorGroupId((long) -1);
    familyDoctorService.update(familyDoctor);
    return "s";
  }
}
