package com.ly.springBoot.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author: LiuYi
 * @Description: 单文件上传/多文件上传
 * @Date: Created in 2018/5/19 17:10
 */
@Controller
@RequestMapping("/common")
public class CommonAction {
    @ResponseBody
    @RequestMapping(value = "/upload.do", method = RequestMethod.POST)
    public String upload(HttpServletRequest request, MultipartFile fileData) {
        if (null == fileData) {
            return "请选择想要上传的文件.";
        }
        //上传目录地址
        String uploadDir = request.getSession().getServletContext().getRealPath("/") + "upload/";
        try {
            //创建文件夹
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            transferTo(uploadDir, fileData);
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败";
        }
        return "ok";
    }

    @ResponseBody
    @RequestMapping(value = "/uploads.do", method = RequestMethod.POST)
    public String upload(HttpServletRequest request, MultipartFile[] fileData) {
        if (null == fileData || fileData.length <= 0) {
            return "请选择想要上传的文件.";
        }
        //上传目录地址
        String uploadDir = request.getSession().getServletContext().getRealPath("/") + "upload/";
        try {
            //创建文件夹
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            for (int i = 0; i < fileData.length; i++) {
                MultipartFile aFile = fileData[i];
                transferTo(uploadDir, aFile);
            }

        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败";
        }
        return "ok";
    }

    private void transferTo(String uploadDir, MultipartFile fileData) throws IOException {
        if (null == fileData) {
            return;
        }
        //文件后缀名
        String suffix = fileData.getOriginalFilename().substring(fileData.getOriginalFilename().lastIndexOf("."));
        //文件名
        String fileName = UUID.randomUUID() + suffix;
        //服务端保存的文件对象
        File serverFile = new File(uploadDir + fileName);
        fileData.transferTo(serverFile);

    }
}
