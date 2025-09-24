package com.gec.oceanbioproject.controller;

import com.gec.oceanbioproject.resp.CommonResp;
import com.gec.oceanbioproject.service.ContentService;
import com.gec.oceanbioproject.service.Impl.ContentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/content")
public class ContentController {
    @Autowired
    private ContentServiceImpl contentService;
    @GetMapping("/findContent/{id}")
    public CommonResp findContent(@PathVariable Long id) {
        CommonResp<String> resp = new CommonResp<>();
        String content = contentService.findContent(id);
        resp.setContent(content);
        return resp;
    }
}
