package com.gec.oceanbioproject.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@TableName("ebook")
public class Ebook {
    private Long id;
    private String name;
    private Long category1Id;
    private Long category2Id;
    private String description;
    private String cover;
    private int docCount;
    private int viewCount;
    private int voteCount;


}
