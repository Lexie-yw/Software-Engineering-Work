package com.work.service;

import com.work.entity.Goal;

import java.util.List;

public interface GoalService {
    List<Goal> getAllGoalByUserId(String userId);

    Goal getByGoalId(String goalId);

    void addGoal(Goal goal);

    void updateGoal(Goal goal);

    void delGoal(String goalId);
}
