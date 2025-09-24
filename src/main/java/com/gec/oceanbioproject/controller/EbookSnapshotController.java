package com.gec.oceanbioproject.controller;

import com.gec.oceanbioproject.entity.EbookSnapshot;
import com.gec.oceanbioproject.resp.CommonResp;
import com.gec.oceanbioproject.service.Impl.SnapshotServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/snapshot")
public class EbookSnapshotController {
    @Autowired
    private SnapshotServiceImpl snapshotService;

    @GetMapping("{id}")
    public CommonResp getSnapshot(@RequestParam("id") Long id) {
        CommonResp commonResp = new CommonResp();
        EbookSnapshot snapshot = snapshotService.getSnapshot(id);
        commonResp.setSuccess(true);
        commonResp.setMessage("success");
        commonResp.setContent(snapshot);
        return commonResp;
    }
}
