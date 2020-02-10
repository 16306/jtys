package com.util;

import com.github.pagehelper.PageInfo;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class SetData {

    /**
     * 将分页器数据处理成layUI规定的数据
     *
     * @param data
     * @return
     */
    public static Map<String, Object> setdata(@NotNull PageInfo<?> data) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("msg", "");
        result.put("count", data.getTotal());
        result.put("data", data.getList());
        return result;
    }

    public static Map<String, Object> returnNull() {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("msg", "");
        result.put("count", 0);
        result.put("data", null);
        return result;
    }


    public static Map<String, Object> getStringObjectMap(@NotNull MyPageHelper pageInfo) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("msg", "");
        result.put("count", pageInfo.getTotal());
        result.put("data", pageInfo.getList());
        return result;
    }

    /**
     * 得到并格式化当前时间
     */
    public static Date setDate() {
        Date date = new Date();
        Date date3 = null;
        SimpleDateFormat temp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date2 = temp.format(date);
        try {
            date3 = temp.parse(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date3;
    }

}
