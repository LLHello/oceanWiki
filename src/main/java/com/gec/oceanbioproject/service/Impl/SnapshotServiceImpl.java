package com.gec.oceanbioproject.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gec.oceanbioproject.entity.EbookSnapshot;
import com.gec.oceanbioproject.mapper.SnapshotMapper;
import org.springframework.stereotype.Service;

@Service
public class SnapshotServiceImpl extends ServiceImpl<SnapshotMapper, EbookSnapshot> {
    public EbookSnapshot getSnapshot(Long id){
        return baseMapper.selectById(id);
    }
}
