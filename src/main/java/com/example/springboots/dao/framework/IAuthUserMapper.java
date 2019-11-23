package com.example.springboots.dao.framework;


import java.util.List;

import com.example.springboots.entity.framework.AuthUserEntity;
import com.example.springboots.service.iface.ISupperMapper;
import org.apache.ibatis.annotations.Param;

import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
public interface IAuthUserMapper extends ISupperMapper<AuthUserEntity> {

    public List<AuthUserEntity> queryList(@Param("organCode") String organCode, @Param("username") String username);

}
