package com.six.info.controller;

import com.alibaba.fastjson.JSONObject;
import com.six.info.entity.Application;
import com.six.info.entity.Info;
import com.six.info.entity.Login;
import com.six.info.entity.User;
import com.six.info.service.InfoService;
import com.six.info.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class InfoController {
    private InfoService infoService;
    private  UserService userService;
    public InfoController infoController;

    @Autowired
    public InfoController(InfoService infoService,UserService userService) {
        this.infoService = infoService;
        this.userService =userService;
    }
    @PostMapping("/addUserInfo")
    public Object addUserInfo(Info info, ServletRequest request){
        JSONObject jsonObject = new JSONObject();
        HttpServletRequest req = (HttpServletRequest) request;
        String token = req.getHeader("token");
        if (token == null) {
            jsonObject.put("code", "405");
            jsonObject.put("message", "无token！");
        }else{
            Login loginuser = userService.findUseridByToken(token);
            if(loginuser==null){
                jsonObject.put("code", "501");
                jsonObject.put("message", "没有此用户");
            }else{
                //数据库中的user信息
                User user = userService.findById(loginuser.getUserid());
                info.setUserid(user.getId());
                //从数据库返回的密码
                Info data=infoService.addUserInfo(info);
                jsonObject.put("code", "200");
                jsonObject.put("message", "修改成功");
                jsonObject.put("data",data);
                return jsonObject;
            }
        }
        return jsonObject;
    }
    @PostMapping("/addUserApply")
    public Object addUserApply(Application application, ServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        HttpServletRequest req = (HttpServletRequest) request;
        String token = req.getHeader("token");
        if (token == null) {
            jsonObject.put("code", "405");
            jsonObject.put("message", "无token！");
        } else {
            Login loginuser = userService.findUseridByToken(token);
            if (loginuser == null) {
                jsonObject.put("code", "501");
                jsonObject.put("message", "没有此用户");
            } else {
                //数据库中的user信息
                User user = userService.findById(loginuser.getUserid());
                application.setUserid(user.getId());
                Application data = infoService.addUserApply(application);
                jsonObject.put("code", "200");
                jsonObject.put("message", "修改成功");
                jsonObject.put("data", data);
            }
        }
        return jsonObject;
    }
    @GetMapping("/findType")
    public Object findType() {
        JSONObject jsonObject = new JSONObject();
        List data=infoService.findType();
        jsonObject.put("code", "200");
        jsonObject.put("message", "修改成功");
        jsonObject.put("data", data);
        return jsonObject;
    }
    @GetMapping("/findProfessionF")
    public Object findProfessionF(String type) {
        JSONObject jsonObject = new JSONObject();
        List data=infoService.findProfessionF(type);
        jsonObject.put("code", "200");
        jsonObject.put("message", "修改成功");
        jsonObject.put("data", data);
        return jsonObject;
    }
    @GetMapping("/findProfessionS")
    public Object findProfessionS(String professionF) {
        JSONObject jsonObject = new JSONObject();
        List data=infoService.findProfessionS(professionF);
        jsonObject.put("code", "200");
        jsonObject.put("message", "修改成功");
        jsonObject.put("data", data);
        return jsonObject;
    }
}
