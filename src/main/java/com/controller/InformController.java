package com.controller;

import com.entity.*;
import com.github.pagehelper.PageInfo;
import com.service.*;
import com.util.FindUser;
import com.util.MyPageHelper;
import com.util.SetData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/inform")
public class InformController
{
  @Autowired
  private FamilyService familyService;

  @Autowired
  private IoService ioService;

  @Autowired
  private FamilyMemberService familyMemberService;


  @Autowired
  private DoctorGroupService doctorGroupService;

  @Autowired
  private DoctorService doctorService;

  @Autowired
  private UserService userService;

  @Autowired
  private UserRoleService userRoleService;

  @Autowired
  private FamilyDoctorService familyDoctorService;

  @Autowired
  private ServiceRecordService serviceRecordService;


  @ResponseBody
  @RequestMapping("/getServiceRecord")
  @PreAuthorize("hasPermission('/inform/service_info','r')")
  public Map<String, Object> getServiceRecord(@RequestParam("page")int page, @RequestParam("limit")int limit,
      @RequestParam(value = "familyMemberName",defaultValue = "null")String familyMemberName,
      @RequestParam(value = "doctorGroupLeaderName",defaultValue = "null")String doctorGroupLeaderName)
  {
    FindUser findUser = new FindUser();
    com.entity.User user = findUser.getuser();
    MyPageHelper pageInfo;
    pageInfo = serviceRecordService.selectByHospitalId(user.getHospitalId(),page - 1,limit,1,familyMemberName,doctorGroupLeaderName);
    return SetData.getStringObjectMap(pageInfo);
  }

  @ResponseBody
  @RequestMapping("/getDoctorGroupList")
  @PreAuthorize("hasPermission('/inform/doctor_group_info','r')")
  public Map<String, Object> getDoctorGroupList(@RequestParam("page")int page, @RequestParam("limit")int limit,
      @RequestParam(value = "name",defaultValue = "null")String name,
      @RequestParam(value = "groupLeaderName",defaultValue = "null")String groupLeaderName,
      @RequestParam(value = "serviceArea",defaultValue = "null")String serviceArea)
  {
    FindUser findUser = new FindUser();
    com.entity.User user = findUser.getuser();
    PageInfo<DoctorGroup> pageInfo;
    pageInfo = doctorGroupService
        .getAllDoctorGroupList(user.getHospitalId(),name,groupLeaderName,serviceArea,page,limit,1);
    Map<String, Object> result = SetData.setdata(pageInfo);
    return result;
  }

  @ResponseBody
  @RequestMapping("/getFamilyList")
  @PreAuthorize("hasPermission('/inform/user_family_info','r')")
  public Map<String, Object> getFamilyList(@RequestParam("page")int page, @RequestParam("limit")int limit,
      @RequestParam(value = "householderName",defaultValue = "null")String householderName,
      @RequestParam(value = "householderPhone",defaultValue = "null")String householderPhone)
  {
    FindUser findUser = new FindUser();
    com.entity.User user = findUser.getuser();
    PageInfo<Family> pageInfo;
    pageInfo = familyService.getFamilyList(user.getHospitalId(),householderName,householderPhone,page,limit,1);
    Map<String, Object> result = SetData.setdata(pageInfo);
    return result;
  }

  @RequestMapping("/doctor_group_info")
  @PreAuthorize("hasPermission('/inform/doctor_group_info','r')")
  public String doctor_group_info()
  {
    return "inform/user_doctorgroup_info";
  }

  @RequestMapping("/service_info")
  @PreAuthorize("hasPermission('/inform/service_info','r')")
  public String service_info()
  {
    return "inform/service_info";
  }

  @RequestMapping("/user_family_info")
  @PreAuthorize("hasPermission('/inform/user_family_info','r')")
  public String inform()
  {
    return "inform/user_family_info";
  }

  @GetMapping("/addFamily")
  @PreAuthorize("hasPermission('/inform/user_family_info','c')")
  public String addFamily()
  {
    return "inform/addFamily";
  }

  @GetMapping("/addDoctorGroup")
  @PreAuthorize("hasPermission('/inform/doctor_group_info','c')")
  public String addNotice()
  {
    return "inform/addDoctorGroup";
  }

  @ResponseBody
  @PostMapping("/saveDoctorGroup")
  @PreAuthorize("hasPermission('/inform/doctor_group_info','c')")
  public String saveDoctorGroup(DoctorGroup doctorGroup)
  {
    FindUser findUser = new FindUser();
    com.entity.User user = findUser.getuser();
    Long id = doctorGroupService.getLastOne().getDoctorGroupId() + 1;
    doctorGroup.setDoctorGroupId(id);
    doctorGroup.setHospitalId(user.getHospitalId());
    int s = doctorGroupService.insert(doctorGroup);
    if(s == 1)
    {
      return "success";
    } else {
      return "error";
    }
  }

  @ResponseBody
  @PostMapping("/save")
  @PreAuthorize("hasPermission('/inform/user_family_info','c')")
  public String save(Family family)
  {
    FindUser findUser = new FindUser();
    com.entity.User user = findUser.getuser();
    Long id = familyService.getLastOne().getFamilyId() + 1;
    family.setFamilyId(id);
    family.setHospitalId(user.getHospitalId());
    FamilyDoctor familyDoctor = new FamilyDoctor();
    familyDoctor.setFamilyDoctorId(familyDoctorService.getLastOne().getFamilyDoctorId() + 1);
    familyDoctor.setFamilyId(family.getFamilyId());
    familyDoctor.setDoctorGroupId((long)-1);
    familyDoctor.setContractContent("11111111111");
    familyDoctor.setContractDuration(-1);
    familyDoctor.setDateOfContract(SetData.setDate());
    int s;
    s = familyService.insert(family);
    familyDoctorService.firstInsert(familyDoctor);
    if(s == 1)
    {
      return "success";
    } else {
      return "error";
    }
  }

  @ResponseBody
  @RequestMapping("/getDoctorList")
  @PreAuthorize("hasPermission('/inform/doctor_group_info','r')")
  public Map<String, Object> getDoctorList(Long id,@RequestParam("page")int page, @RequestParam("limit")int limit)
  {

    PageInfo<Doctor> pageInfo;
    pageInfo = doctorService.getDoctorList(id,page,limit,1);
    Map<String, Object> result = SetData.setdata(pageInfo);
    return result;
  }

  @ResponseBody
  @RequestMapping("/getFamilyMemberList")
  @PreAuthorize("hasPermission('/inform/user_family_info','r')")
  public Map<String, Object> getFamilyMemberList(Long id,@RequestParam("page")int page, @RequestParam("limit")int limit)
  {

    PageInfo<FamilyMember> pageInfo;
    pageInfo = familyMemberService.getAllMemberList(id,page,limit,1);
    Map<String, Object> result = SetData.setdata(pageInfo);
    return result;
  }

  @GetMapping("/showDoctorList")
  @PreAuthorize("hasPermission('/inform/doctor_group_info','r')")
  public String showDoctorList()
  {
    return "inform/showDoctorList";
  }

  @GetMapping("/showFamilyMemberList")
  @PreAuthorize("hasPermission('/inform/user_family_info','r')")
  public String showFamilyMember()
  {
    return "inform/showFamilyMemberList";
  }

  @GetMapping("/addDoctor")
  public String addDoctor()
  {
    return "inform/addDoctor";
  }

  @GetMapping("/editDoctor")
  @PreAuthorize("hasPermission('/inform/doctor_group_info','u')")
  public String userDoctor(Model model, Long id)
  {
    Doctor Doctor = doctorService.selectByPrimaryKey(id);
    model.addAttribute("member", Doctor);
    return "inform/addDoctor";
  }

  @GetMapping("/addFamilyMember")
  @PreAuthorize("hasPermission('/inform/user_family_info','c')")
  public String addFamilyMember()
  {
    return "inform/addFamilyMember";
  }

  @GetMapping("/editFamilyMember")
  @PreAuthorize("hasPermission('/inform/user_family_info','u')")
  public String user_family_info(Model model, Long id)
  {
    FamilyMember familyMember = familyMemberService.selectByPrimaryKey(id);
    model.addAttribute("member", familyMember);
    return "inform/addFamilyMember";
  }



  @ResponseBody
  @PostMapping("/deleteById")
  @PreAuthorize("hasPermission('/inform/user_family_info','d')")
  public String deleteById(Long id)
  {
    Family family = familyService.selectByPrimaryKey(id);
    List<FamilyMember> mlist = familyMemberService.getAllMember(family.getFamilyId());
    FamilyDoctor familyDoctor = familyDoctorService.selectByFamilyId(family.getFamilyId());
    for(FamilyMember familyMember : mlist)
    {
      familyMemberService.deleteByPrimaryKey(familyMember.getFamilyMemberId());
    }
    familyService.deleteByPrimaryKey(id);
    familyDoctorService.delete(familyDoctor.getFamilyDoctorId());
    return "删除成功";
  }

  @ResponseBody
  @PostMapping("/deleteDoctorGroupById")
  @PreAuthorize("hasPermission('/inform/doctor_group_info','d')")
  public String deleteDoctorGroupById(Long id)
  {
    DoctorGroup doctorGroup = doctorGroupService.selectByPrimaryKey(id);
    List<Doctor> mlist = doctorService.getAllDoctorList(doctorGroup.getDoctorGroupId());
    for(Doctor doctor : mlist)
    {
      doctorService.deleteByPrimaryKey(doctor.getDoctorId());
    }
    doctorGroupService.deleteByPrimaryKey(id);
    return "删除成功";
  }


  @ResponseBody
  @PostMapping("/deleteDoctorById")
  @PreAuthorize("hasPermission('/inform/doctor_group_info','d')")
  public String deleteDoctorById(Long id)
  {

    doctorService.deleteByPrimaryKey(id);
    return "删除成功";
  }

  @ResponseBody
  @PostMapping("/saveDoctor")
  public String saveDoctor(Doctor doctor)
  {
    Long id;
    int s;
    FindUser findUser = new FindUser();
    Long hospitalId = findUser.getuser().getHospitalId();
    Long userId= userService.getMaxId();
    if(doctor.getDoctorId() == null)
    {
      UserRole userRole = new UserRole();
      userRole.setUserRoleId(userRoleService.getMaxId());
      userRole.setRoleId((long) 1);
      userRole.setUserId(userId);
      User user = new User();
      user.setUesrId(userId);
      user.setUserName(doctor.getCardId().substring(doctor.getCardId().length()-6).trim());
      user.setHospitalId(hospitalId);
      String encodedPassword = null;
      BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
      encodedPassword = passwordEncoder.encode(doctor.getCardId().substring(doctor.getCardId().length()-6).trim());
      user.setPassword(encodedPassword);
      id = doctorService.getLastOne().getDoctorId() + 1;
      user.setDoctorId(id);
      doctor.setDoctorId(id);
      doctor.setHospitalId(hospitalId);
      userService.insert(user);
      userRoleService.insert(userRole);
      s = doctorService.insert(doctor);
    }else
    {
      s = doctorService.updateByPrimaryKey(doctor) + 1;
    }

    if (s == 1)
    {
      return "success";
    } else if(s == 2)
    {
      return "update";
    }else
    {
      return "error";
    }
  }

  @ResponseBody
  @PostMapping("/deleteMemberById")
  @PreAuthorize("hasPermission('/inform/user_family_info','d')")
  public String deleteMemberById(Long id)
  {
    familyMemberService.deleteByPrimaryKey(id);
    return "删除成功";
  }


  @ResponseBody
  @PostMapping("/saveMember")
  @PreAuthorize("hasPermission('/inform/user_family_info','c')")
  public String saveMember(FamilyMember familyMember)
  {
    Long id;
    int s;
    String encodedPassword = null;
    if(familyMember.getPassword().isEmpty())
    {
      BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
      encodedPassword = passwordEncoder.encode(familyMember.getCardId().substring(familyMember.getCardId().length()-6).trim());
    }
    if(familyMember.getFamilyMemberId() == null)
    {

      id = familyMemberService.getLastOne().getFamilyMemberId() + 1;
      familyMember.setFamilyMemberId(id);
      familyMember.setPassword(encodedPassword);
      s = familyMemberService.insert(familyMember);
    }else
    {
      s = familyMemberService.updateByPrimaryKey(familyMember) + 1;
    }

    if (s == 1)
    {
      return "success";
    } else if(s == 2)
    {
      return "update";
    }else
    {
      return "error";
    }
  }


  @ResponseBody
  @PostMapping("/inputInfo")
  @PreAuthorize("hasPermission('/inform/user_family_info','i')")
  public Map<String, String> inputInfo(@RequestParam("file") MultipartFile file)
  {
    String str = "";
    Map<String, String> resObj = new HashMap<>();
    if (!file.isEmpty()) {
    try {
      String filename = file.getOriginalFilename();
      str = ioService.importService(filename, file);
    } catch (IOException e) {
      resObj.put("msg", "error");
      resObj.put("code", "1");
      return resObj;
    }
    resObj.put("msg", str);
    resObj.put("code", "0");
    return resObj;
    } else {
      resObj.put("msg", "error");
      resObj.put("code", "1");
      return resObj;
    }
  }

  @GetMapping(value = "/outputInfo")
  @PreAuthorize("hasPermission('/inform/user_family_info','o')")
  public void download(HttpServletResponse response,String ids) throws IOException {
    ioService.OutputInfo(response,ids);
  }

}
