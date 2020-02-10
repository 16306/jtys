package com.controller;

import com.entity.Doctor;
import com.entity.User;
import com.service.DoctorGroupService;
import com.service.DoctorService;
import com.service.UserService;
import com.util.FindUser;
import com.util.VerifyCodeImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class UserController
{

  @Autowired
  private DoctorService doctorService;

  @Autowired
  private DoctorGroupService doctorGroupService;

  @Autowired
  private UserService userService;

  @RequestMapping("/login")
  public String login()
  {
    return "login";
  }

  @RequestMapping("/index")
  public String index()
  {
    return "Index";
  }

  @RequestMapping("/self_center/my_info")
  @PreAuthorize("hasPermission('/self_center/my_info','r&c')")
  public String text(Model model)
  {
    FindUser findUser = new FindUser();
    User user = findUser.getuser();
    if(user.getDoctorId() != null)
    {
      Doctor info = doctorService.selectByPrimaryKey(user.getDoctorId());
      model.addAttribute("info", info);
      return "self_info";
    }
    return "self_info";
  }

  @GetMapping("/self_center/edit")
  @PreAuthorize("hasPermission('/self_center/my_info','r&u')")
  public String userDoctor(Model model, Long id)
  {
    Doctor Doctor = doctorService.selectByPrimaryKey(id);
    model.addAttribute("member", Doctor);
    return "inform/addDoctor";
  }

  @RequestMapping("/self_center/my_team")
  @PreAuthorize("hasPermission('/self_center/my_team','r')")
  public String my_team()
  {
    return "my_team";
  }

  @ResponseBody
  @GetMapping("/self_center/getDoctorList")
  @PreAuthorize("hasPermission('/self_center/my_team','r')")
  public List<Doctor> DoctorList()
  {
    FindUser findUser = new FindUser();
    User user = findUser.getuser();
    if(user.getDoctorId() != null)
    {
      Doctor doctor = doctorService.selectByPrimaryKey(user.getDoctorId());
      return doctorService.DoctorList(doctor.getDoctorGroupId());
    }
    return null;
  }

  @RequestMapping("/changePassword")
  public String changePassword()
  {
    return "changePassword";
  }

  @ResponseBody
  @PostMapping("/change")
  public String change(@RequestBody Map<Object,Object> request)
  {
    FindUser findUser = new FindUser();
    User user = findUser.getuser();
    User nowUser = userService.selectByPrimaryKey(user.getUesrId());
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    if ((request.get("nowPassword")).equals(request.get("nowPasswordA")))
    {
      if (passwordEncoder.matches((String) request.get("oldPassword"), nowUser.getPassword()))
      {
        nowUser.setPassword(passwordEncoder.encode((String) request.get("nowPassword")));
        userService.updateByPrimaryKeySelective(nowUser);
        return "success";
      }
      else
        return "passwordError";
    }
    return "secondPasswordError";
  }


  @RequestMapping("/getVerifyCodeImage")
  public void getVerifyCodeImage(HttpServletRequest request, HttpServletResponse response) throws IOException
  {
    //设置页面不缓存
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
    response.getOutputStream();
    String verifyCode = VerifyCodeImageUtil.generateTextCode(VerifyCodeImageUtil.TYPE_NUM_UPPER, 4, null);

    //将验证码放到HttpSession里面
    request.getSession().setAttribute("verifyCode", verifyCode);
    System.out.println("本次生成的验证码为：" + verifyCode + ",已存放到HttpSession中");

    //设置输出的内容的类型为JPEG图像
    response.setContentType("image/jpeg");
    BufferedImage bufferedImage = VerifyCodeImageUtil.generateImageCode(verifyCode, 90, 30, 3, true, Color.WHITE, Color.BLACK, null);

    //写给浏览器
    ImageIO.write(bufferedImage, "JPEG", response.getOutputStream());
  }

}
