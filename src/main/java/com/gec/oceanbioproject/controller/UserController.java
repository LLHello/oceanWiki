package com.gec.oceanbioproject.controller;

import com.gec.oceanbioproject.req.UserQueryReq;
import com.gec.oceanbioproject.req.UserResetPasswordReq;
import com.gec.oceanbioproject.req.UserSaveReq;
import com.gec.oceanbioproject.resp.CommonResp;
import com.gec.oceanbioproject.resp.PageResp;
import com.gec.oceanbioproject.resp.UserQueryResp;
import com.gec.oceanbioproject.service.Impl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/list")
    public CommonResp list(UserQueryReq userQueryReq) {
        CommonResp<PageResp<UserQueryResp>> resp = new CommonResp<>(true,"查询成 功",null);
        PageResp<UserQueryResp> pageResp = userService.listByName(userQueryReq);
        resp.setContent(pageResp);
        return resp;
    }
    @PostMapping("/save")
    public CommonResp save(@Valid @RequestBody UserSaveReq req) {
        log.info("前端加密后的密码：{}",req.getPassword());
        req.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes()));
        log.info("后端加密后的密码：{}",req.getPassword());
        CommonResp resp = new CommonResp<>(true,"成功",null);
        userService.save(req);
        return resp;
    }
    @DeleteMapping("/delete/{id}")
    public CommonResp delete(@PathVariable Long id) {
        CommonResp resp = new CommonResp<>(true,"删除成功",null);
        userService.delete(id);
        return resp;
    }
    @PostMapping("resetPassword")
    public CommonResp resetPassword(@Valid @RequestBody UserResetPasswordReq
                                            req) {
        req.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes()));
        CommonResp resp = new CommonResp<>(true,"成功",null);
        userService.resetPassword(req);
        return resp;
    }
}
