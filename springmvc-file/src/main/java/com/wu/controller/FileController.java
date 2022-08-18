package com.wu.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/8/17
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@RestController
public class FileController {

    static Logger logger = Logger.getLogger(FileController.class);

    @RequestMapping("/upload")
    public String upload(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        //获取文件名字
        String uploadFilename = file.getOriginalFilename();
        //文件名为空 返回到首页
        if ("".equals(uploadFilename)) {
            return "redirect:/index.jsp";
        }

        logger.info("上传文件名字" + uploadFilename);

        //保存上传路径 UUID
        String path = request.getSession().getServletContext().getRealPath("/upload");
        //String path = request.getServletContext().getRealPath("/upload");
        File realPath = new File(path);
        //路径不存在就创建一个
        if (!realPath.exists()) {
            realPath.mkdir();
        }
        logger.info("上传文件保存地址" + realPath);

        InputStream is = file.getInputStream();//文件输入流
        OutputStream os = new FileOutputStream(new File(realPath, uploadFilename));//文件输出流

        //读取写出
        int len = 0;
        byte[] buffer = new byte[1024];
        while ((len = is.read(buffer)) != -1) {
            os.write(buffer, 0, len);
            os.flush();
        }
        os.close();
        is.close();

        return "redirect:/index.jsp";
    }

    @RequestMapping("/upload2")
    public String upload2(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        //保存上传路径
        String path = request.getSession().getServletContext().getRealPath("/upload");
        File realPath = new File(path);
        //路径不存在就创建一个
        if (!realPath.exists()) {
            realPath.mkdir();
        }
        logger.info("上传文件保存地址" + realPath);

        //通过CommonsMultipartFile的方法直接写文件
        file.transferTo(new File(realPath + "/" + file.getOriginalFilename()));


        return "redirect:/index.jsp";
    }

    @RequestMapping("/download")
    public String download(HttpServletResponse response, HttpServletRequest request) throws IOException {
        //保存下载的图片路径
        String path = request.getSession().getServletContext().getRealPath("/upload");
        String fileName = "1.jpg";
        //设置response响应头
        response.reset();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("multipart/form-data");

        response.setHeader("Content-Disposition",
                "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));

        File file = new File(path, fileName);
        //读取文件 输入流
        FileInputStream input = new FileInputStream(file);
        //写出文件 输出流
        ServletOutputStream out = response.getOutputStream();

        int index = 0;
        byte[] buffer = new byte[1024];
        //执行 写出操作
        while ((index = input.read(buffer)) != -1) {
            out.write(buffer, 0, index);
            out.flush();
        }
        out.close();
        input.close();

        return "OK";
    }

}
