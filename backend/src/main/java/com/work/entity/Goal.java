package com.work.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;
@Data
public class Goal {
    @Id
    private String goalId;
    private String userId;
    private String goalName;
    private String description;
    private Date  startTime;
    private Date endTime;
    private Integer status; //0 start 1 ongoing 2 end
    private Integer totalTimes;
    private Integer nowTimes;
}
