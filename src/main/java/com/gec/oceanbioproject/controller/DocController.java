package com.gec.oceanbioproject.controller;

import com.gec.oceanbioproject.req.DocQueryReq;
import com.gec.oceanbioproject.req.DocSaveReq;
import com.gec.oceanbioproject.resp.CommonResp;
import com.gec.oceanbioproject.resp.DocQueryResp;
import com.gec.oceanbioproject.resp.PageResp;
import com.gec.oceanbioproject.service.DocService;
import com.gec.oceanbioproject.service.Impl.DocServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doc")
public class DocController {
    @Autowired
    private DocServiceImpl docService;
    @GetMapping("/all")
    public CommonResp all() {
        CommonResp<List<DocQueryResp>> resp = new CommonResp<>(true,"查询成功",null);
        List<DocQueryResp> list = docService.all();
        resp.setContent(list);
        return resp;
    }
    @GetMapping("/list")
    public CommonResp list(@Valid DocQueryReq req) {
        CommonResp<List<DocQueryResp>> resp = new CommonResp<>(true,"查询成功",null);
        List<DocQueryResp> list = docService.allbyEbookId(req.getEbookId());
        resp.setContent(list);
        return resp;
    }
    @PostMapping("/save")
    public CommonResp save(@Valid @RequestBody DocSaveReq req) {
        CommonResp resp = new CommonResp<>(true,"成功",null);
        docService.save(req);
        return resp;
    }
    @DeleteMapping("/delete/{id}")
    public CommonResp delete(@PathVariable Long id) {
        CommonResp resp = new CommonResp<>(true,"删除成功",null);
        docService.delete(id);
        return resp;
    }
    @GetMapping("/remove")
    public CommonResp delete(@RequestParam("ids") List<Long> ids) {
        CommonResp resp = new CommonResp<>(true,"删除成功",null);
        docService.delete(ids);
        return resp;
    }
    @GetMapping("/all/{ebook_id}")
    public CommonResp allByEbookId(@PathVariable("ebook_id") Long ebookId) {
        CommonResp<List<DocQueryResp>> resp = new CommonResp<>();
        List<DocQueryResp> list = docService.allbyEbookId(ebookId);
        resp.setContent(list);
        return resp;
    }
}
