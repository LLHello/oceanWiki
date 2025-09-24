package com.gec.oceanbioproject.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Content {
    private Long id;
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
