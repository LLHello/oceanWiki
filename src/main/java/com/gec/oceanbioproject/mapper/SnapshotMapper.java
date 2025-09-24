package com.gec.oceanbioproject.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gec.oceanbioproject.entity.EbookSnapshot;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SnapshotMapper extends BaseMapper<EbookSnapshot> {
}
