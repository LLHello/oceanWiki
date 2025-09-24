package com.gec.oceanbioproject.req;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class DocSaveReq {
    private Long id;
    @NotNull(message = "【电子书】不能为空")
    private Long ebook_id;
    @NotNull(message = "【父文档】不能为空")
    private Long parent;
    @NotNull(message = "【名称】不能为空")
    private String name;
    @NotNull(message = "【顺序】不能为空")
    private Integer sort;
    private Integer viewCount;
    private Integer voteCount;
    @NotNull(message = "【内容】不能为空")
    private String content;

    public Long getEbookId() {
        return ebook_id;
    }

    public void setEbookId(Long ebookId) {
        this.ebook_id = ebookId;
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}