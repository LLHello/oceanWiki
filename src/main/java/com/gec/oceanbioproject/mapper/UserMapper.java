package com.gec.oceanbioproject.mapper;

import com.gec.oceanbioproject.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserMapper {
    User getUserById(Long id);
    List<User> getAllUsers();
}

