package com.gec.oceanbioproject.service;


import com.gec.oceanbioproject.entity.Content;
import org.springframework.stereotype.Service;

@Service
public interface ContentService {
    String findContent(Long id);

    boolean save(Content content);

    boolean updateById(Content content);
}
