package com.controller;

import com.entity.Doctor;
import com.entity.User;
import com.service.DoctorService;
import com.util.FindUser;
import com.util.VerifyCodeImageUtil;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController
{

  @Autowired
  private DoctorService doctorService;

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
  @PreAuthorize("hasPermission('/self_center/my_info','u')")
  public String userDoctor(Model model, Long id)
  {
    Doctor Doctor = doctorService.selectByPrimaryKey(id);
    model.addAttribute("member", Doctor);
    return "/inform/addDoctor";
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
