package com.example.springboots.service.framework.imp;

import java.util.List;

import com.example.springboots.dao.framework.IAuthUserMapper;
import com.example.springboots.entity.framework.AuthUserEntity;
import com.example.springboots.entity.framework.AuthUserPwdEntity;
import com.example.springboots.service.framework.IAuthUserService;
import com.example.springboots.service.iface.ISupperMapper;
import com.example.springboots.service.iface.imp.FrameworkBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthUserService extends FrameworkBaseService<AuthUserEntity> implements IAuthUserService {

    @Autowired
    private IAuthUserMapper userMapper;

    @Override
    public ISupperMapper<AuthUserEntity> getMapper() {
        return this.userMapper;
    }

    @Override
    public AuthUserEntity queryUser(String id) {
        return this.userMapper.selectByPrimaryKey(id);
    }

    public List<AuthUserEntity> getAll() {
        return userMapper.selectAll();
    }

    @Override
    public List<AuthUserEntity> queryList(String organCode, String username) {
        return this.userMapper.queryList(organCode,username);
    }

    @Override
    public AuthUserEntity QyeryUser(String id) {
        return this.userMapper.selectByPrimaryKey(id);
    }


    @Override
    public int updateUser(AuthUserEntity authUserEntity) {
        return this.userMapper.updateByPrimaryKeySelective(authUserEntity);
    }

    @Override
    public int deleteUser(String id) {
        return this.userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int addUser(AuthUserEntity authUserEntity) {
        return this.userMapper.insertSelective(authUserEntity);
    }

}
