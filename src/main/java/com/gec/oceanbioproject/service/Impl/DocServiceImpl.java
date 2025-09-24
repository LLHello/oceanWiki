package com.gec.oceanbioproject.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gec.oceanbioproject.entity.Doc;
import com.gec.oceanbioproject.mapper.DocMapper;
import com.gec.oceanbioproject.req.DocQueryReq;
import com.gec.oceanbioproject.req.DocSaveReq;
import com.gec.oceanbioproject.resp.DocQueryResp;
import com.gec.oceanbioproject.resp.PageResp;
import com.gec.oceanbioproject.service.ContentService;
import com.gec.oceanbioproject.service.DocService;
import com.gec.oceanbioproject.util.CopyUtil;
import com.gec.oceanbioproject.util.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import com.gec.oceanbioproject.entity.Content;
import java.util.List;

@Service
public class DocServiceImpl extends ServiceImpl<DocMapper, Doc> implements DocService {
    @Autowired
    private SnowFlake snowFlake;
    public PageResp<DocQueryResp> listByname(DocQueryReq req) {
        QueryWrapper<Doc> queryWrapper = new QueryWrapper<Doc>();
//第一个参数：该参数是一个布尔类型，只有该参数是true时，才将like条件拼接到sql中；本例中，如果name字段不为空，则拼接name字段的like查询条件；
        queryWrapper.like(StringUtils.isNotBlank(req.getName()),"name",req.getName());
//创建分页对象
        Page<Doc> page = new Page<>(req.getPage(),req.getSize());
        page = this.baseMapper.selectPage(page, queryWrapper);
        List<DocQueryResp> resps = CopyUtil.copyList(page.getRecords(),
                DocQueryResp.class);
//创建返回对象
        PageResp<DocQueryResp> pageResp = new PageResp<>();
        pageResp.setList(resps);
        pageResp.setTotal(page.getTotal());
        return pageResp;
    }
    @Autowired
    private ContentService contentService;
    public void save(DocSaveReq req) {
        Doc doc = CopyUtil.copy(req, Doc.class);
        Content content = CopyUtil.copy(req, Content.class);
        if (ObjectUtils.isEmpty(req.getId())) {
// 新增文档
            long id = snowFlake.nextId();
            doc.setId(id);
            doc.setViewCount(0);//默认查看点赞为0
            doc.setVoteCount(0);
            this.baseMapper.insert(doc);
//新增内容
            content.setId(id);
            contentService.save(content);
        } else {
// 更新文档
            this.baseMapper.updateById(doc);
            boolean b = contentService.updateById(content);//更新内容
            if(!b){//根据id更新失败,执行新增功能
                contentService.save(content);
            }
        }
    }
    public void delete(Long id) {
        this.baseMapper.deleteById(id);
    }
    public List<DocQueryResp> all() {
        List<Doc> categories = this.baseMapper.selectList(new QueryWrapper<Doc>
                ().orderByAsc("sort"));
        List<DocQueryResp> list = CopyUtil.copyList(categories,
                DocQueryResp.class);
        return list;
    }
    public void delete(List<Long> ids) {
        this.baseMapper.deleteBatchIds(ids);
    }

    public List<DocQueryResp> allbyEbookId(Long ebookId) {
        QueryWrapper<Doc> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("ebook_id", ebookId).orderByAsc("sort");
        List<Doc> doclist = this.baseMapper.selectList(queryWrapper);
        // 列表复制
        List<DocQueryResp> list = CopyUtil.copyList(doclist, DocQueryResp.class);
        return list;
    }
}
