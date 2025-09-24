package com.gec.oceanbioproject.req;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class EbookQueryReq extends PageReq {
    private Long id;
    private String name;
    private Long categoryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
