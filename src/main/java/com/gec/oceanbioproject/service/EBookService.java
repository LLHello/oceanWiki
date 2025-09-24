package com.gec.oceanbioproject.service;

import com.gec.oceanbioproject.req.EbookQueryReq;
import com.gec.oceanbioproject.req.EbookSaveReq;
import com.gec.oceanbioproject.resp.EbookQueryResp;
import com.gec.oceanbioproject.resp.PageResp;

import java.util.List;

public interface EBookService {
    PageResp<EbookQueryResp> list(EbookQueryReq req);
    EbookQueryResp save(EbookSaveReq req);
    void deleteById(Long id);
}
