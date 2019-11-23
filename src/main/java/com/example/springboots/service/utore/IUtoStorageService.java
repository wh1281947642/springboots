package com.example.springboots.service.utore;


import com.example.springboots.entity.utore.UtoStorageEntity;
import com.example.springboots.service.iface.ISupperService;

import java.util.List;

public interface IUtoStorageService extends ISupperService<UtoStorageEntity> {


    public List<UtoStorageEntity> queryList();
    

}
