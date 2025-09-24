package com.gec.oceanbioproject.entity;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
@Data
@ToString
public class EbookSnapshot {
    private Long id;
    private Long ebook_id;
    private LocalDateTime date;
    private Integer view_count;
    private Integer vote_count;
    private Integer view_increase;
    private Integer vote_increase;

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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Integer getView_count() {
        return view_count;
    }

    public void setView_count(Integer view_count) {
        this.view_count = view_count;
    }

    public Integer getVote_count() {
        return vote_count;
    }

    public void setVote_count(Integer vote_count) {
        this.vote_count = vote_count;
    }

    public Integer getView_increase() {
        return view_increase;
    }

    public void setView_increase(Integer view_increase) {
        this.view_increase = view_increase;
    }

    public Integer getVote_increase() {
        return vote_increase;
    }

    public void setVote_increase(Integer vote_increase) {
        this.vote_increase = vote_increase;
    }
}
