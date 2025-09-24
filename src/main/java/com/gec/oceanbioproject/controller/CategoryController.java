package com.gec.oceanbioproject.controller;

import com.gec.oceanbioproject.req.CategoryQueryReq;
import com.gec.oceanbioproject.req.CategorySaveReq;
import com.gec.oceanbioproject.resp.CategoryQueryResp;
import com.gec.oceanbioproject.resp.CommonResp;
import com.gec.oceanbioproject.resp.PageResp;
import com.gec.oceanbioproject.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/list")
    public CommonResp list(@Valid CategoryQueryReq req) {
        CommonResp<PageResp<CategoryQueryResp>> resp = new CommonResp<>(true,"查 询成功",null);
                PageResp<CategoryQueryResp> pageResp = categoryService.listByname(req);
        resp.setContent(pageResp);
        return resp;
    }
    @PostMapping("/save")
    public CommonResp save(@Valid @RequestBody CategorySaveReq req) {
        CommonResp resp = new CommonResp<>(true,"成功",null);
        categoryService.save(req);
        return resp;
    }
    @DeleteMapping("/delete/{id}")
    public CommonResp delete(@PathVariable Long id) {
        CommonResp resp = new CommonResp<>(true,"删除成功",null);
        categoryService.delete(id);
        return resp;
    }
    @GetMapping("/all")
    public CommonResp all() {
        CommonResp<List<CategoryQueryResp>> resp = new CommonResp<>(true, "成功",null);
        List<CategoryQueryResp> list =  categoryService.all();
        resp.setContent(list);
        return resp;
    }
}

