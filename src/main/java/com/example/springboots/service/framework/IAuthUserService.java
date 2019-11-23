package com.example.springboots.service.framework;


import com.example.springboots.entity.framework.AuthUserEntity;
import com.example.springboots.service.iface.ISupperService;

import java.util.List;

public interface IAuthUserService extends ISupperService<AuthUserEntity> {

    public AuthUserEntity queryUser(String id);

    public List<AuthUserEntity> getAll();

    public List<AuthUserEntity> queryList(String organCode, String username);

    public AuthUserEntity QyeryUser(String id);

    public int updateUser(AuthUserEntity authUserEntity);

    public int deleteUser(String id);

    public int addUser(AuthUserEntity authUserEntity);

}
