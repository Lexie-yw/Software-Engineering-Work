package com.work.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Reward {
    @Id
    private String id;
    private String img_index;
    private String img_url;
    private String img_achieved;


}
