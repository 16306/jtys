package com.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.springframework.stereotype.Service;

@Service
public class Md5
{

  /**
   * 没用到的MD5加密
   * @param plainText
   * @return
   */
  public static String md5(String plainText)
  {

    byte[] secretBytes = null;
    try
    {
      plainText += "smn@cyz_";
      MessageDigest md = MessageDigest.getInstance("MD5");

      md.update(plainText.getBytes());

      secretBytes = md.digest();
    } catch (NoSuchAlgorithmException e)
    {
      throw new RuntimeException("没有md5这个算法！");
    }
    String md5code = new BigInteger(1, secretBytes).toString(16);
    for (int i = 0; i < 32 - md5code.length(); i++)
    {
      md5code = "0" + md5code;
    }
    return md5code;
  }

}
