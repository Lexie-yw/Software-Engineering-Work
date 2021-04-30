package com.work.controller;

import com.work.entity.User;
import com.work.resp.Response;
import com.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserContorller {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public Response register(@RequestBody User user){
        Response response=new Response();
        if(StringUtils.isEmpty(user.getEmail())||StringUtils.isEmpty(user.getUserName())||StringUtils.isEmpty(user.getPassword())){
            response.paramEmpty();
            return response;
        }
        User dbUser=userService.getUserByEamil(user.getEmail());
        if(dbUser!=null){
            response.hasUser();
            return response;
        }
        userService.addUser(user);
        response.success();
        return response;
    }

    @PostMapping("/login")
    public Response login(@RequestBody User user){
        Response response=new Response();
        if(StringUtils.isEmpty(user.getEmail())||StringUtils.isEmpty(user.getPassword())){
            response.paramEmpty();
            return response;
        }

        User loginUser=userService.login(user.getEmail(),user.getPassword());
        if(loginUser==null){
            response.noUser();
            return response;
        }
        response.success();
        response.setData(loginUser);
        return response;
    }

    @GetMapping("/del/{userId}")
    public Response delUser(@PathVariable String userId){
        Response response=new Response();
        if(StringUtils.isEmpty(userId)){
            response.paramEmpty();
            return response;
        }
        userService.delUser(userId);
        response.success();
        return response;
    }

    @PostMapping("/update/pwd")
    public Response updatePwd(@RequestBody User user){
        Response response=new Response();
        if(StringUtils.isEmpty(user.getUserId())||StringUtils.isEmpty(user.getPassword())){
            response.paramEmpty();
            return response;
        }

        User dbUser=userService.getUserByUserId(user.getUserId());
        if(dbUser==null){
            response.noUser();
            return response;
        }
        dbUser.setPassword(user.getPassword());
        userService.updateUser(dbUser);
        response.success();
        return response;
    }
}
