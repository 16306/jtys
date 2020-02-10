package com.controller;


import com.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/layEdit")
public class LayEditController {

    @Autowired
    private FileService fileService;

    @ResponseBody
    @RequestMapping(value = "/upload")
    public Object upload(MultipartFile file) {
        String filename = file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        boolean boole = fileService.saveFile(file, uuid);
        if (boole) {
            Map<String,Object> map = new HashMap<>();
            Map<String,Object> map2 = new HashMap<>();
            map.put("code", 0);	//0表示上传成功
            map.put("msg","上传成功"); //提示消息
            map2.put("src", "http://localhost:8080/layEdit/download?uuid="+uuid);
            map2.put("title", filename);
            map.put("data", map2);
            return map;
        } else {
            return file.getOriginalFilename();
        }
    }

    //下载方法
    @ResponseBody
    @RequestMapping(value = "/download")
    private void download(String uuid, HttpServletRequest request, HttpServletResponse response) {
        fileService.download(uuid, request, response);
    }
}
