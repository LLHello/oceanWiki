package com.gec.oceanbioproject.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gec.oceanbioproject.entity.Ebook;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface EBookMapper extends BaseMapper<Ebook> {
}
