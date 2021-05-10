package com.work.dao;

import com.work.entity.Reward;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardRepository extends MongoRepository<Reward,String> {

}
