package com.gec.oceanbioproject.service;

import com.gec.oceanbioproject.req.DocQueryReq;
import com.gec.oceanbioproject.req.DocSaveReq;
import com.gec.oceanbioproject.resp.DocQueryResp;
import com.gec.oceanbioproject.resp.PageResp;

import java.util.List;

public interface DocService {
    PageResp<DocQueryResp> listByname(DocQueryReq req);
    void save(DocSaveReq req);
    void delete(Long id);
    List<DocQueryResp> all();
    void delete(List<Long> ids);
}
