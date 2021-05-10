package com.work.service.impl;

import com.work.dao.RewardRepository;
import com.work.entity.Reward;
import com.work.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class RewardServiceImpl implements RewardService {
    @Autowired
    private RewardRepository rewardRepository;
    @Override
    public Reward getReward() {
        List<Reward>  list=rewardRepository.findAll();
        int size=list.size();
        Random random=new Random();
        return list.get(random.nextInt(size));
    }
}
