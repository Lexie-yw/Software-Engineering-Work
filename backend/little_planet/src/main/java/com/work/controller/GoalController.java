package com.work.controller;

import com.work.entity.Goal;
import com.work.resp.Response;
import com.work.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("goal")
@CrossOrigin
public class GoalController {
    @Autowired
    private GoalService goalService;

    @PostMapping("add")
    public Response addGoal(@RequestBody Goal goal){
        Response response=new Response();
        if(StringUtils.isEmpty(goal.getUserId())||StringUtils.isEmpty(goal.getGoalName())
                ||StringUtils.isEmpty(goal.getDescription())||StringUtils.isEmpty(goal.getStartTime())||
                StringUtils.isEmpty(goal.getEndTime())){
            response.paramEmpty();
            return response;
        }
        goal.setStatus(0);
        goalService.addGoal(goal);
        response.success();
        return response;
    }

    @GetMapping("get/{userId}")
    public Response getAllGoal(@PathVariable String userId){
        Response response=new Response();
        if(StringUtils.isEmpty(userId)){
            response.paramEmpty();
            return response;
        }
        List<Goal> list=goalService.getAllGoalByUserId(userId);
        response.success();
        response.setData(list);
        return response;
    }
    @PostMapping("update")
    public Response updateGoal(@RequestBody Goal goal){
        Response response=new Response();
        if(StringUtils.isEmpty(goal.getGoalId())){
            response.paramEmpty();
            return response;
        }
        goalService.updateGoal(goal);
        response.success();
        return response;
    }

    @GetMapping("del/{goalId}")
    public Response delGoal(@PathVariable String goalId){
        Response response=new Response();
        if(StringUtils.isEmpty(goalId)){
            response.paramEmpty();
            return response;
        }
        goalService.delGoal(goalId);
        response.success();
        return response;
    }
}
