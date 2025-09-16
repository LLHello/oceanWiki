package com.gec.oceanbioproject.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gec.oceanbioproject.entity.Ebook;
import com.gec.oceanbioproject.mapper.EBookMapper;
import com.gec.oceanbioproject.req.EbookQueryReq;
import com.gec.oceanbioproject.resp.EbookQueryResp;
import com.gec.oceanbioproject.service.EBookService;
import com.gec.oceanbioproject.util.CopyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class EBookServiceImpl extends ServiceImpl<EBookMapper, Ebook> implements EBookService {
    private static final Logger LOG = LoggerFactory.getLogger(EBookServiceImpl.class);

    @Override
    public List<EbookQueryResp> list(EbookQueryReq req) {
        try {
            QueryWrapper<Ebook> wrapper = new QueryWrapper<>();
            wrapper.orderByDesc("id");
            List<Ebook> ebooks = baseMapper.selectList(wrapper);
            
            if (ObjectUtils.isEmpty(ebooks)) {
                LOG.info("No ebooks found");
                return new ArrayList<>();
            }
            
            List<EbookQueryResp> list = CopyUtil.copyList(ebooks, EbookQueryResp.class);
            LOG.info("Found {} ebooks", list.size());
            return list;
        } catch (Exception e) {
            LOG.error("Error occurred while fetching ebooks: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to fetch ebooks", e);
        }
    }
}
