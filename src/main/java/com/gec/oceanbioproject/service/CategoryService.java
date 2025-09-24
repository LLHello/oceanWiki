package com.gec.oceanbioproject.service;

import com.gec.oceanbioproject.req.CategoryQueryReq;
import com.gec.oceanbioproject.req.CategorySaveReq;
import com.gec.oceanbioproject.resp.CategoryQueryResp;
import com.gec.oceanbioproject.resp.PageResp;

import java.util.List;

public interface CategoryService {
    PageResp<CategoryQueryResp> listByname(CategoryQueryReq req);
    void save(CategorySaveReq req);
    void delete(Long id);
    List<CategoryQueryResp> all();
}
