package com.gec.oceanbioproject.req;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CategorySaveReq {
    private Long id;
    //父id
    private Long parent;
    //名称
    private String name;
    //顺序
    private Integer sort;
}
