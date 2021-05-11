package com.work.controller;

import com.work.resp.Response;
import com.work.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("reward")
@CrossOrigin
public class RewardController {
    @Autowired
    private RewardService service;

    @GetMapping("/get/pic")
    public Response getImg(){
        Response response=new Response();
        response.success();
        response.setData(service.getReward());
        return response;
    }
}
