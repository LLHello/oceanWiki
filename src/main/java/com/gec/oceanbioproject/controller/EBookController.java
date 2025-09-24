package com.gec.oceanbioproject.controller;

import com.gec.oceanbioproject.req.EbookQueryReq;
import com.gec.oceanbioproject.req.EbookSaveReq;
import com.gec.oceanbioproject.resp.CommonResp;
import com.gec.oceanbioproject.resp.EbookQueryResp;
import com.gec.oceanbioproject.resp.PageResp;
import com.gec.oceanbioproject.service.EBookService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/ebook")
public class EBookController {
    private static final Logger LOG = LoggerFactory.getLogger(EBookController.class);

    @Resource
    private EBookService eBookService;

    @GetMapping("/list")
    public CommonResp list(EbookQueryReq req) {
        CommonResp<PageResp<EbookQueryResp>> resp = new CommonResp<>();
        try {
            PageResp<EbookQueryResp> list = eBookService.list(req);
            resp.setContent(list);
        } catch (Exception e) {
            LOG.error("Error occurred while fetching ebook list: {}", e.getMessage(), e);
            resp.setSuccess(false);
            resp.setMessage("Failed to fetch ebook list: " + e.getMessage());
        }
        return resp;
    }
    @PostMapping("/save")
    public CommonResp save(@Valid @RequestBody EbookSaveReq req) {
        CommonResp resp = new CommonResp<>();
        EbookQueryResp savedEbook = eBookService.save(req);
        resp.setSuccess(true);
        resp.setMessage("成功");
        resp.setContent(savedEbook);
        return resp;
    }
    @DeleteMapping("/delete/{id}")
    public CommonResp delete(@PathVariable Long id) {
        eBookService.deleteById(id);

        return new CommonResp(true, "成功", null);
    }
}
