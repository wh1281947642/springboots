package com.example.springboots.service.utore.imp;

import com.example.springboots.dao.utore.IUtoStorageMapper;
import com.example.springboots.entity.framework.AuthUserPwdEntity;
import com.example.springboots.entity.utore.UtoStorageEntity;
import com.example.springboots.service.iface.ISupperMapper;
import com.example.springboots.service.iface.imp.UtoreBaseService;
import com.example.springboots.service.utore.IUtoStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UtoStorageService extends UtoreBaseService<UtoStorageEntity> implements IUtoStorageService {

    @Autowired
    private IUtoStorageMapper utoStorageMapper;

    @Override
    public ISupperMapper<UtoStorageEntity> getMapper() {
        return this.utoStorageMapper;
    }

    @Transactional(value = "utoreTransactionManager",readOnly=true)
    public List<UtoStorageEntity> queryList() {
        return utoStorageMapper.selectAll();
    }



}
