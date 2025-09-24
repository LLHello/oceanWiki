package com.gec.oceanbioproject.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gec.oceanbioproject.entity.Ebook;
import com.gec.oceanbioproject.mapper.EBookMapper;
import com.gec.oceanbioproject.req.EbookQueryReq;
import com.gec.oceanbioproject.req.EbookSaveReq;
import com.gec.oceanbioproject.resp.EbookQueryResp;
import com.gec.oceanbioproject.resp.PageResp;
import com.gec.oceanbioproject.service.EBookService;
import com.gec.oceanbioproject.util.CopyUtil;
import com.gec.oceanbioproject.util.SnowFlake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EBookServiceImpl extends ServiceImpl<EBookMapper, Ebook> implements EBookService {
    private static final Logger LOG = LoggerFactory.getLogger(EBookServiceImpl.class);
    private final SnowFlake snowFlake;

    public EBookServiceImpl(SnowFlake snowFlake) {
        this.snowFlake = snowFlake;
    }

    @Override
    public PageResp<EbookQueryResp> list(EbookQueryReq req) {
        LOG.info("开始查询电子书列表，请求参数：{}", req);
        
        // 1. 构建查询条件
        QueryWrapper<Ebook> queryWrapper = new QueryWrapper<>();
        // 添加名称模糊查询
        if (StringUtils.isNotBlank(req.getName())) {
            queryWrapper.like("name", req.getName());
            LOG.info("添加名称查询条件：{}", req.getName());
        }
        // 添加分类查询
        if (ObjectUtils.isNotEmpty(req.getCategoryId())) {
            queryWrapper.eq("category2_id", req.getCategoryId());
            LOG.info("添加分类查询条件：{}", req.getCategoryId());
        }
        // 添加排序
        queryWrapper.orderByDesc("id");

        // 2. 处理分页参数（页码从1开始）
        long pageNum = Math.max(1, req.getPage());
        long pageSize = Math.max(2, req.getSize());
        LOG.info("处理后的分页参数：page={}, size={}", pageNum, pageSize);

        // 3. 执行分页查询
        Page<Ebook> page = new Page<>(pageNum, pageSize);
        page = this.baseMapper.selectPage(page, queryWrapper);
        
        // 4. 转换查询结果
        List<EbookQueryResp> list = CopyUtil.copyList(page.getRecords(), EbookQueryResp.class);
        LOG.info("查询到 {} 条记录", list.size());

        // 5. 封装返回结果
        PageResp<EbookQueryResp> pageResp = new PageResp<>();
        pageResp.setTotal(page.getTotal());
        pageResp.setList(list);
        
        LOG.info("分页查询完成，总记录数：{}，当前页记录数：{}", page.getTotal(), list.size());
        return pageResp;
    }
    @Override
    public EbookQueryResp save(EbookSaveReq req) {
        LOG.info("保存电子书开始：{}", req);
        Ebook ebook = CopyUtil.copy(req, Ebook.class);
        
        if(ObjectUtils.isNotEmpty(req.getId())) {
            // 更新
            LOG.info("更新电子书，ID：{}", req.getId());
            int updateCount = this.baseMapper.updateById(ebook);
            LOG.info("更新结果：{}", updateCount);
            if (updateCount == 0) {
                LOG.error("更新失败，可能记录不存在，id：{}", req.getId());
                return null;
            }
        } else {
            // 新增
            LOG.info("新增电子书");
            // 生成雪花算法ID
            long id = snowFlake.nextId();
            ebook.setId(id);
            LOG.info("生成ID：{}", id);
            
            // 初始化其他字段
            if (ebook.getDocCount() == null) {
                ebook.setDocCount(0);
            }
            if (ebook.getViewCount() == null) {
                ebook.setViewCount(0);
            }
            if (ebook.getVoteCount() == null) {
                ebook.setVoteCount(0);
            }
            
            int insertCount = this.baseMapper.insert(ebook);
            LOG.info("插入结果：{}", insertCount);
            if (insertCount == 0) {
                LOG.error("插入失败");
                return null;
            }
        }
        
        // 查询并返回最新的数据
        Ebook savedEbook = this.baseMapper.selectById(ebook.getId());
        LOG.info("保存电子书结束，返回保存后的数据：{}", savedEbook);
        return CopyUtil.copy(savedEbook, EbookQueryResp.class);
    }
    public void deleteById(Long id) {
        this.baseMapper.deleteById(id);
    }
}
