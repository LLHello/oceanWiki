package com.gec.oceanbioproject.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gec.oceanbioproject.entity.Doc;
import com.gec.oceanbioproject.req.DocQueryReq;
import com.gec.oceanbioproject.req.DocSaveReq;
import com.gec.oceanbioproject.resp.DocQueryResp;
import com.gec.oceanbioproject.resp.PageResp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DocMapper extends BaseMapper<Doc> {
}
