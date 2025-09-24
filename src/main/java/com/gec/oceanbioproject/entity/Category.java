package com.gec.oceanbioproject.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Category {
    private Long id;
    private Long parent;
    private String name;
    private Integer sort;
}
