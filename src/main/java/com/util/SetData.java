package com.util;

import com.github.pagehelper.PageInfo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class SetData
{

  public static Map<String, Object> setdata(@NotNull PageInfo<?> data)
  {
    Map<String,Object> result = new HashMap<>();
    result.put("code",0);
    result.put("msg","");
    result.put("count",data.getTotal());
    result.put("data",data.getList());
    return result;
  }

  public static Date setDate()
  {
    Date date = new Date();
    Date date3 = null;
    SimpleDateFormat temp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    String date2 = temp.format(date);
    try
    {
      date3 = temp.parse(date2);
    } catch (ParseException e)
    {
      e.printStackTrace();
    }
    return date3;
  }

}
