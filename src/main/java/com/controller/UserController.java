package com.controller;

import com.util.VerifyCodeImageUtil;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController
{
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
  public String text()
  {
    return "Index";
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