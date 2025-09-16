package com.gec.oceanbioproject.controller;

import com.gec.oceanbioproject.req.EbookQueryReq;
import com.gec.oceanbioproject.resp.CommonResp;
import com.gec.oceanbioproject.resp.EbookQueryResp;
import com.gec.oceanbioproject.service.EBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/ebook")
public class EBookController {
    private static final Logger LOG = LoggerFactory.getLogger(EBookController.class);

    @Resource
    private EBookService eBookService;

    @GetMapping("/list")
    public CommonResp<List<EbookQueryResp>> list(EbookQueryReq req) {
        CommonResp<List<EbookQueryResp>> resp = new CommonResp<>();
        try {
            List<EbookQueryResp> list = eBookService.list(req);
            resp.setContent(list);
        } catch (Exception e) {
            LOG.error("Error occurred while fetching ebook list: {}", e.getMessage(), e);
            resp.setSuccess(false);
            resp.setMessage("Failed to fetch ebook list: " + e.getMessage());
        }
        return resp;
    }
}
