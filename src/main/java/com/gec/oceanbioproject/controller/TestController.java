package com.gec.oceanbioproject.controller;

import com.gec.oceanbioproject.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gec.oceanbioproject.resp.Result;

@RestController
@Tag(name="测试web接口")
@RequestMapping("/test")
public class TestController {
    @PostMapping("/sayHello")
    @Operation(summary = "最简单的测试方法") //Swagger声明方法添加@ApiOperation注解,并说明
    public Result sayHello( User user){
//        Result result = new Result();
//        result.setSuccess(true);
//        result.setMessage("查询成功");
//        result.setContent("Hello World");
        return new Result<>(true,"查询成功","hello world!");
    }
}
