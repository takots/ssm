package com.example.springmvc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.UUID;
import javax.servlet.ServletContext;

@Controller
public class FileUpAndDownController {

    @RequestMapping("test/up")
    public String testUp(MultipartFile photo, HttpSession session) throws IOException {
        // 獲取上傳的文件名
        String originalFilename = photo.getOriginalFilename();
        // 後綴名
        String hzName = originalFilename.substring(originalFilename.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString();
        originalFilename = uuid + hzName;

        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取當前工程的真实路径
        String photoPath = servletContext.getRealPath("photo");
        // 創建photopath的File對象
        File file = new File(photoPath);
        // 是否存在
        if(!file.exists()){
            file.mkdir();
        }
        String finalPath = photoPath + File.separator + originalFilename;
        // 上傳文件
        photo.transferTo(new File(finalPath));
        return "success";
    }


    @RequestMapping("/test/down")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
//    public String testResponseEntity(HttpSession session) throws IOException {
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取服务器中文件的真实路径
//        String realPath = servletContext.getRealPath("");
//        System.out.println(realPath);

        String realPath = servletContext.getRealPath("static");
        realPath = realPath + File.separator + "images" + File.separator + "1.jpg";
//        System.out.println(realPath2);
//        return "success";

        //创建输入流
        InputStream is = new FileInputStream(realPath);
        //创建字节数组
        byte[] bytes = new byte[is.available()];
        //将流读到字节数组中
        is.read(bytes);
        //创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        //设置要下载方式以及下载文件的名字
        headers.add("Content-Disposition", "attachment;filename=1.jpg");
        //设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);
        //关闭输入流
        is.close();
        return responseEntity;
    }
}
