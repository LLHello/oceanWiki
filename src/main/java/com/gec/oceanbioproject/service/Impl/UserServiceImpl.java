package com.gec.oceanbioproject.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gec.oceanbioproject.entity.User;
import com.gec.oceanbioproject.exception.BusinessException;
import com.gec.oceanbioproject.exception.BusinessExceptionCode;
import com.gec.oceanbioproject.mapper.UserMapper;
import com.gec.oceanbioproject.req.UserQueryReq;
import com.gec.oceanbioproject.req.UserResetPasswordReq;
import com.gec.oceanbioproject.req.UserSaveReq;
import com.gec.oceanbioproject.resp.PageResp;
import com.gec.oceanbioproject.resp.UserQueryResp;
import com.gec.oceanbioproject.service.UserService;
import com.gec.oceanbioproject.util.CopyUtil;
import com.gec.oceanbioproject.util.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private SnowFlake snowFlake;
    public PageResp<UserQueryResp> listByName(UserQueryReq req) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
//第一个参数：该参数是一个布尔类型，只有该参数是true时，才将like条件拼接到sql中；本例中，如果name字段不为空，则拼接name字段的like查询条件；
        queryWrapper.like(StringUtils.isNotBlank(req.getName()), "name",
                req.getName());
        queryWrapper.or().like(StringUtils.isNotBlank(req.getLoginName()),
                "login_name", req.getLoginName());
//创建分页对象
        Page<User> page = new Page<>(req.getPage(), req.getSize());
        page = this.baseMapper.selectPage(page, queryWrapper);
        List<UserQueryResp> resps = CopyUtil.copyList(page.getRecords(),
                UserQueryResp.class);
//创建返回对象
        PageResp<UserQueryResp> pageResp = new PageResp<>();
        pageResp.setList(resps);
        pageResp.setTotal(page.getTotal());
        return pageResp;
    }

    @Override
    public void save(UserSaveReq req) {
        User user = CopyUtil.copy(req, User.class);
        if (ObjectUtils.isEmpty(req.getId())) {
// 新增
            User one = this.baseMapper.selectOne(new QueryWrapper<User>().eq("login_name", req.getLoginName()));
            if(ObjectUtils.isEmpty(one)){
// 新增
                long id = snowFlake.nextId();
                user.setId(id);
                this.baseMapper.insert(user);
            }else{
                throw new
                        BusinessException(BusinessExceptionCode.USER_LOGIN_NAME_EXIST);
            }
        } else {
// 更新
            user.setLoginName(null);//避免绕过前端 修改登录名
            this.baseMapper.updateById(user);
        }
    }
    @Override
    public void delete(Long id) {
        this.baseMapper.deleteById(id);
    }
    @Override
    public void resetPassword(UserResetPasswordReq req) {
        User user = CopyUtil.copy(req, User.class);
        this.baseMapper.updateById(user);
    }
}
