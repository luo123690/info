package com.six.info.controller;

import com.alibaba.fastjson.JSONObject;
import com.six.info.entity.*;
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
    //添加一条志愿信息
    @PostMapping("/addUserInfo")
    public Object addUserInfo(Type type, ServletRequest request){
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
                Info info =new Info();
                info.setUserid(user.getId());
                if(infoService.findTypeByProfession(type)!=null){
                    info.setTypeid(infoService.findTypeByProfession(type).getId());
                    //从数据库返回的密码
                    infoService.addUserInfo(info);
                    jsonObject.put("code", "200");
                    jsonObject.put("message", "添加成功");
                    jsonObject.put("data", info);
                }
                else {
                    jsonObject.put("code", "400");
                    jsonObject.put("message", "添加失败！请重新选择");
                }
            }
        }
        return jsonObject;
    }
    //补全志愿信息资料
    @PostMapping("/updateUserInfo")
    public Object updateUserInfo(Info info, ServletRequest request){
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

                //从数据库返回的密码
                Info data=infoService.addInfo(info);
                jsonObject.put("code", "200");
                jsonObject.put("message", "添加成功");
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
                jsonObject.put("message", "添加成功");
                jsonObject.put("data", data);
            }
        }
        return jsonObject;
    }
    //返回一级分类
    @GetMapping("/findType")
    public Object findType() {
        JSONObject jsonObject = new JSONObject();
        List data=infoService.findType();
        jsonObject.put("code", "200");
        jsonObject.put("message", "查询成功");
        jsonObject.put("data", data);
        return jsonObject;
    }
    //返回二级分类
    @GetMapping("/findProfessionF")
    public Object findProfessionF(String type) {
        JSONObject jsonObject = new JSONObject();
        List data=infoService.findProfessionF(type);
        jsonObject.put("code", "200");
        jsonObject.put("message", "查询成功");
        jsonObject.put("data", data);
        return jsonObject;
    }
    //返回三级分类
    @GetMapping("/findProfessionS")
    public Object findProfessionS(String professionF) {
        JSONObject jsonObject = new JSONObject();
        List data=infoService.findProfessionS(professionF);
        jsonObject.put("code", "200");
        jsonObject.put("message", "查询成功");
        jsonObject.put("data", data);
        return jsonObject;
    }
    //更新用户分数
    @PostMapping("/updateUserPoint")
    public Object updateUserPoint(Info info) {
        JSONObject jsonObject = new JSONObject();
        int data=infoService.updateUserPoint(info);
        jsonObject.put("code", "200");
        jsonObject.put("message", "修改成功");
        jsonObject.put("data", data);
        return jsonObject;
    }
    //根据id查询申报ID
    @GetMapping("/findApplyInfoById")
    public Object findApplyInfoById(int id){
        JSONObject jsonObject = new JSONObject();
        Application data=infoService.findApplyInfoById(id);
        jsonObject.put("code", "200");
        jsonObject.put("message", "查询成功");
        jsonObject.put("data", data);
        return jsonObject;
    }

    //根据id查询志愿信息
    @GetMapping("/findInfoById")
    public Object findInfoById(int id){
        JSONObject jsonObject = new JSONObject();
        Info data=infoService.findInfoById(id);
        jsonObject.put("code", "200");
        jsonObject.put("message", "查询成功");
        jsonObject.put("data", data);
        return jsonObject;
    }
    //查询信息列表
    @GetMapping("/findInfoList")
    public Object findInfoList(Type type){
        JSONObject jsonObject = new JSONObject();
        List<Info> data=infoService.findInfoList(type);
        jsonObject.put("code", "200");
        jsonObject.put("message", "查询成功");
        jsonObject.put("data", data);
        return jsonObject;
    }
    @GetMapping("/findTypeByProfession")
    public Object findTypeByProfession(Type type){
        JSONObject jsonObject = new JSONObject();
        System.out.println(type.getProfessionF()+type.getProfessionS());
        jsonObject.put("code", "200");
        jsonObject.put("message", "查询成功");
        jsonObject.put("data",infoService.findTypeByProfession(type));
        return jsonObject;
    }
}
