package com.six.info.controller;

import com.alibaba.fastjson.JSONObject;
import com.six.info.entity.*;
import com.six.info.service.InfoService;
import com.six.info.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collections;
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
    public Object addUserInfo(Type type,String name, ServletRequest request){
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
                    info.setName(name);
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
    public Object updateUserInfo(Info info, ServletRequest request,ServletResponse servletResponse){
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", "*");
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
    public Object addUserApply(Application application, ServletRequest request,ServletResponse servletResponse) {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", "*");
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
    public Object findType( ServletResponse servletResponse) {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", "*");
        JSONObject jsonObject = new JSONObject();
        List data=infoService.findType();
        jsonObject.put("code", "200");
        jsonObject.put("message", "查询成功");
        jsonObject.put("data", data);
        return jsonObject;
    }
    //返回二级分类
    @GetMapping("/findProfessionF")
    public Object findProfessionF(String type,ServletResponse servletResponse) {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", "*");
        JSONObject jsonObject = new JSONObject();
        List data=infoService.findProfessionF(type);
        jsonObject.put("code", "200");
        jsonObject.put("message", "查询成功");
        jsonObject.put("data", data);
        return jsonObject;
    }
    @GetMapping("/findListByType")
    public Object findListByType(String type) {
        JSONObject jsonObject = new JSONObject();
        List data=infoService.findListByType(type);
        jsonObject.put("code", "200");
        jsonObject.put("message", "查询成功");
        jsonObject.put("data", data);
        return jsonObject;
    }

    //返回三级分类
    @GetMapping("/findProfessionS")
    public Object findProfessionS(String professionF,ServletResponse servletResponse) {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", "*");
        JSONObject jsonObject = new JSONObject();
        List data=infoService.findProfessionS(professionF);
        jsonObject.put("code", "200");
        jsonObject.put("message", "查询成功");
        jsonObject.put("data", data);
        return jsonObject;
    }
    //更新用户分数
    @PostMapping("/updateUserPoint")
    public Object updateUserPoint(String remark,int id,Integer point,ServletRequest request) {
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
                if(user.getType()==1){
                    Info info=new Info();
                    info.setId(id);
                    if(point!=null&&!point.equals("")){
                        info.setPoint(point);
                    }
                    if(remark!=null&&!remark.equals("")){
                        info.setRemark(remark);
                    }
                    info.setRemark(remark);
                    int data = infoService.updateUserPoint(info);
                    jsonObject.put("code", "200");
                    jsonObject.put("message", "修改成功");
                    jsonObject.put("data", data);
                }else {
                    jsonObject.put("code", "400");
                    jsonObject.put("message", "普通用户无权限！");
                }
            }
        }
        return jsonObject;
    }
    //根据id查询申报ID
    @GetMapping("/findApplyInfoById")
    public Object findApplyInfoById(int id,ServletResponse servletResponse){
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", "*");
        JSONObject jsonObject = new JSONObject();
        Application data=infoService.findApplyInfoById(id);
        jsonObject.put("code", "200");
        jsonObject.put("message", "查询成功");
        jsonObject.put("data", data);
        return jsonObject;
    }

    //根据id查询志愿信息
    @GetMapping("/findInfoById")
    public Object findInfoById(int id,ServletResponse servletResponse){
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", "*");
        JSONObject jsonObject = new JSONObject();
        Info data=infoService.findInfoById(id);
        jsonObject.put("code", "200");
        jsonObject.put("message", "查询成功");
        jsonObject.put("data", data);
        return jsonObject;
    }


    //查询信息列表
    @GetMapping("/findInfoList")
    public Object findInfoList(Type type,int page)throws Exception{
        JSONObject jsonObject = new JSONObject();
        List<Info> data=infoService.findInfoList(type);
        List<Info> data1=new ArrayList<Info>();
        for (int i =0;i<data.size();i++){
            if(data.get(i).getIsread()==1){
                data1.add(data.get(i));

            }
        }
        int  pages=data.size() % 8== 0 ? (data.size()/8) : (data.size()/8)+1;
        List<Info> list=new ArrayList<Info>();
        int firstIndex = (page - 1) * 8;
        int lastIndex = page * 8;
        try {
            if(lastIndex>data.size()){
                lastIndex=data.size();
            }
            list =   data.subList(firstIndex, lastIndex);
            //主要代码隐藏
        }catch (IndexOutOfBoundsException e){
            //处理数组越界异常
            e.getMessage();
        }
        jsonObject.put("code", "200");
        jsonObject.put("message", "查询成功");
        jsonObject.put("pages", pages);
        jsonObject.put("data", list);
        return jsonObject;
    }

    //查询信息列表
    @GetMapping("/findTypeById")
    public Object findTypeById(int id,ServletResponse servletResponse){
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", "*");
        JSONObject jsonObject = new JSONObject();
        Type type=infoService.findTypeById(id);
        jsonObject.put("code", "200");
        jsonObject.put("message", "查询成功");
        jsonObject.put("data", type);
        return jsonObject;
    }


    @GetMapping("/findInfoListByStatus")
    public Object findInfoListByStatus(int isread,int page)throws IndexOutOfBoundsException{

        JSONObject jsonObject = new JSONObject();
        //从第几条数据开始

        List<Info> data=infoService.findInfoListByStatus(isread);


        int  pages=data.size() % 8== 0 ? (data.size()/8) : (data.size()/8)+1;
        List<Info> list=new ArrayList<Info>();
        int firstIndex = (page - 1) * 8;
        int lastIndex = page * 8;
        try {
            if(lastIndex>data.size()){
                lastIndex=data.size();
            }
            list =   data.subList(firstIndex, lastIndex);
            //主要代码隐藏
        }catch (IndexOutOfBoundsException e){
            //处理数组越界异常
            e.getMessage();
        }
        jsonObject.put("code", "200");
        jsonObject.put("message", "查询成功");
        jsonObject.put("pages", pages);
        jsonObject.put("data", list);
        return jsonObject;
    }

    @GetMapping("/findTypeByProfession")
    public Object findTypeByProfession(Type type){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", "200");
        jsonObject.put("message", "查询成功");
        jsonObject.put("data",infoService.findTypeByProfession(type));
        return jsonObject;
    }

    @GetMapping("/findAllList")
    public Object findAllList(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", "200");
        jsonObject.put("message", "查询成功");
        jsonObject.put("data",infoService.findAllList());
        return jsonObject;
    }
}
