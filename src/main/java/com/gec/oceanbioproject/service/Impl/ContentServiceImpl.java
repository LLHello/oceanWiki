package com.gec.oceanbioproject.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gec.oceanbioproject.entity.Content;
import com.gec.oceanbioproject.mapper.ContentMapper;
import com.gec.oceanbioproject.service.ContentService;
import org.springframework.stereotype.Service;

@Service
public class ContentServiceImpl extends ServiceImpl<ContentMapper, Content> implements ContentService {

    public String findContent(Long id) {
        Content content = this.baseMapper.selectById(id);
        if(content !=null){
            return content.getContent();
        }
        return null;
    }
    public boolean save(Content content){
        this.baseMapper.insert(content);
        return true;
    }
    public boolean updateById(Content content){
        this.baseMapper.updateById(content);
        return true;
    }
}
