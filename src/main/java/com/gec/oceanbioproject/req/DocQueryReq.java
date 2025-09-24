package com.gec.oceanbioproject.req;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class DocQueryReq extends PageReq {
    private Long ebook_id;
    private String name;

    public Long getEbookId() {
        return ebook_id;
    }

    public void setEbookId(Long ebookId) {
        this.ebook_id = ebookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
