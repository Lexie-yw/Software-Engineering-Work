package com.work.service.impl;

import com.work.dao.GoalRepository;
import com.work.entity.Goal;
import com.work.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoalServiceImpl implements GoalService {
    @Autowired
    private GoalRepository goalRepository;
    @Override
    public List<Goal> getAllGoalByUserId(String userId) {
        Goal goal=new Goal();
        goal.setUserId(userId);
        ExampleMatcher matcher=ExampleMatcher
                .matching()
                .withMatcher("userId",ExampleMatcher.GenericPropertyMatchers.contains());
        Example<Goal> example=Example.of(goal,matcher);
        return goalRepository.findAll(example);
    }

    @Override
    public Goal getByGoalId(String goalId) {
        return goalRepository.findById(goalId).orElse(null);
    }

    @Override
    public void addGoal(Goal goal) {
        goalRepository.save(goal);
    }

    @Override
    public void updateGoal(Goal goal) {
        goalRepository.save(goal);
    }

    @Override
    public void delGoal(String goalId) {
        goalRepository.deleteById(goalId);
    }
}
