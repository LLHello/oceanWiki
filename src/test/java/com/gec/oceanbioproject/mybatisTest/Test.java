package com.gec.oceanbioproject.mybatisTest;

import com.gec.oceanbioproject.entity.User;
import com.gec.oceanbioproject.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
public class Test {
    @Autowired
    private UserMapper userMapper;
    @org.junit.jupiter.api.Test
    public void test() {
        List<User> users = userMapper.getAllUsers();
        for(User user : users) {
            System.out.println(user.getId() + " " + user.getLoginName() + " " + user.getName() + " " + user.getPassword());
        }
    }
}
