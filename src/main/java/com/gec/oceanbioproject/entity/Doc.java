package com.gec.oceanbioproject.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@Getter
@Setter
public class Doc implements Serializable {
    private Long id;
    private Long ebook_id;
    private Long parent;
    private String name;
    private Integer sort;
    private Integer view_count;
    private Integer vote_count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEbook_id() {
        return ebook_id;
    }

    public void setEbook_id(Long ebook_id) {
        this.ebook_id = ebook_id;
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
        return view_count;
    }

    public void setViewCount(Integer view_count) {
        this.view_count = view_count;
    }

    public Integer getVoteCount() {
        return vote_count;
    }

    public void setVoteCount(Integer vote_count) {
        this.vote_count = vote_count;
    }
}
