package com.gec.oceanbioproject.service;

import com.gec.oceanbioproject.req.UserQueryReq;
import com.gec.oceanbioproject.req.UserResetPasswordReq;
import com.gec.oceanbioproject.req.UserSaveReq;
import com.gec.oceanbioproject.resp.PageResp;
import com.gec.oceanbioproject.resp.UserQueryResp;

public interface UserService {
    PageResp<UserQueryResp> listByName(UserQueryReq userQueryReq);
    void save(UserSaveReq userSaveReq);
    void delete(Long id);
    void resetPassword(UserResetPasswordReq userResetPasswordReq);
}
