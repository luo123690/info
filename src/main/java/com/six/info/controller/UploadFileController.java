package com.six.info.controller;

import com.alibaba.fastjson.JSONObject;
import com.six.info.entity.Info;
import com.six.info.entity.Login;
import com.six.info.entity.User;
import com.six.info.service.InfoService;
import com.six.info.service.UserService;
import com.six.info.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.UUID;

/**
 * @ClassName: UploadFileController
 * @Desc:  上传文件
 * swagger: http://localhost:8015/swagger-ui.html#/upload45file45controller
 * http://localhost:8015/upload
 *
 * @Author: liuhefei
 * @Date: 2019/1/12 10:59
 */
@RestController
public class UploadFileController {
    private UserService userService;
    private InfoService infoService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Value("${web.uploadPath}")
    private String path;
    private final ResourceLoader resourceLoader;

    @Autowired
    public UploadFileController(ResourceLoader resourceLoader, UserService userService, InfoService infoService) {
        this.resourceLoader = resourceLoader;
        this.userService = userService;
        this.infoService=infoService;
    }
    @PostMapping(value = "/uploadFile")
    public JSONObject uploadFile(@RequestParam("fileName") MultipartFile file,int id, ServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        //要上传的目标文件存放的路径
        HttpServletRequest req = (HttpServletRequest) request;
        String token = req.getHeader("token");
        if (token == null) {
            jsonObject.put("code", "405");
            jsonObject.put("message", "无token！");
        } else {
            Login login = userService.findUseridByToken(token);
            if (login == null) {
                jsonObject.put("code", "406");
                jsonObject.put("message", "查询失败");
            } else {
                String localPath = path;
                //上传成功或失败的提示信息
                Info info = new Info();
                String fileName = file.getOriginalFilename();
                if (fileName != null && !"".equalsIgnoreCase(fileName.trim())) {
                    if (FileUtil.upload(file, localPath, fileName)) {
                        //上传成功，给出页面提示
                        String fileNames = login.getUserid()+ file.getOriginalFilename();
                        logger.info("文件名：file", fileNames);
                        String realPath = path + File.separator + fileNames;  //原图地址
                        info.setFileName(realPath);
                        info.setId(id);
                        infoService.addInfo(info);
                        jsonObject.put("code", "200");
                        jsonObject.put("message", "文件上传成功");
                        jsonObject.put("fileName", fileName);
                    } else {
                        jsonObject.put("code", "400");
                        jsonObject.put("massage", "文件上传失败");
                    }
                }
            }
        }
        //显示图片
        return jsonObject;
    }
    @PostMapping(value = "/fileUpload")
    public JSONObject upload(@RequestParam("fileName") MultipartFile file[], ServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        //要上传的目标文件存放的路径
        HttpServletRequest req = (HttpServletRequest) request;
        String token = req.getHeader("token");
        if (token == null) {
            jsonObject.put("code", "405");
            jsonObject.put("message", "无token！");
        } else {
            Login login = userService.findUseridByToken(token);
            if (login == null) {
                jsonObject.put("code", "406");
                jsonObject.put("message", "查询失败");
            } else {
                String localPath = path;
                //上传成功或失败的提示信息
                if (file != null && file.length >= 1) {
                    BufferedOutputStream bw = null;
                    try {
                        for (MultipartFile files : file) {
                            User user = new User();
                            String fileName = files.getOriginalFilename();
                            if (fileName != null && !"".equalsIgnoreCase(fileName.trim())) {
                                if (FileUtil.upload(files, localPath, fileName)) {
                                    //上传成功，给出页面提示
                                    logger.info("文件名：file[]", fileName);
                                    String realPath = path + File.separator + fileName;  //原图地址
                                    user.setIntro(realPath);
                                    user.setId(login.getUserid());
                                    userService.updateUser(user);
                                    jsonObject.put("code", "200");
                                    jsonObject.put("message", "文件上传成功");
                                    jsonObject.put("fileName", fileName);
                                } else {
                                    jsonObject.put("code", "400");
                                    jsonObject.put("massage", "文件上传失败");
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            if (bw != null) {
                                bw.close();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        //显示图片
        return jsonObject;
    }



    @GetMapping(value = "/show")
    public ResponseEntity showPhotos(String fileName) {
        try {
            return ResponseEntity.ok(resourceLoader.getResource("file:" + path + File.separator + fileName));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


}

