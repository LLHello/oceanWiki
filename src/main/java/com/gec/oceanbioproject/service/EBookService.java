package com.gec.oceanbioproject.service;

import com.gec.oceanbioproject.req.EbookQueryReq;
import com.gec.oceanbioproject.resp.EbookQueryResp;

import java.util.List;

public interface EBookService {
    List<EbookQueryResp> list(EbookQueryReq req);
}
