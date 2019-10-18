package com.six.info.controller;

import com.alibaba.fastjson.JSONObject;
import com.six.info.entity.Info;
import com.six.info.service.InfoService;
import com.six.info.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {
    private InfoService infoService;
    public InfoController infoController;

    @Autowired
    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }
    @PostMapping("/addUserInfo")
    public Object addUserInfo(Info info){
        JSONObject jsonObject = new JSONObject();
        infoService.addUserInfo(info);
        jsonObject.put("code", "200");
        jsonObject.put("message", "修改成功");

        return jsonObject;
    }
}
