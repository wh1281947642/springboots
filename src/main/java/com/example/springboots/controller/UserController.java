package com.example.springboots.controller;


import com.example.springboots.entity.framework.AuthUserEntity;
import com.example.springboots.service.framework.IAuthUserService;
import com.example.springboots.utils.ResultData;
import com.example.springboots.utils.UUIDTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@EnableAutoConfiguration
public class UserController {

    @Autowired
    private IAuthUserService authUserService;


    /**
     * 查询所有用户
     * @return
     */
    @RequestMapping("/query-user")
    public AuthUserEntity queryUser(String id) {
        AuthUserEntity authUserEntity = null;
        if(id!=null){
            try {
                authUserEntity = this.authUserService.queryUser(id);
                if(authUserEntity!=null){
                    return  authUserEntity;
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return authUserEntity;
    }
    /**
     * 查询所有用户
     * @return
     */
    @RequestMapping("/query-all")
    public List<AuthUserEntity> getAll(){
        List<AuthUserEntity> list = authUserService.getAll();
        for (int i = 0; i <list.size() ; i++) {
            System.out.printf(list.get(i).toString());
        }
        return list;
    }

    /**
     * 根据条件查询用户列表
     * @return
     */
    @RequestMapping("/query-list")
    public List<AuthUserEntity> queryList(String organCode,String username){
        List<AuthUserEntity> list = authUserService.queryList(organCode,username);
        return list;
    }

    @RequestMapping("/add")
    public ResultData addUser(AuthUserEntity authUserEntity){
        ResultData rd = new ResultData();
        authUserEntity.setId(UUIDTools.randomUUID());
        try {
            authUserService.addUser(authUserEntity);
            rd.setMessage("新增成功");
            rd.setState(200);
        }
        catch (Exception e) {
            rd.setMessage("新增失败");
            rd.setState(999);
            e.printStackTrace();
        }

        return rd;
    }

    /**
     * 跟新
     * @param authUserEntity
     * @return
     */
    @RequestMapping("/update")
    public ResultData updateUser(AuthUserEntity authUserEntity){
        ResultData rd = new ResultData();
        if(authUserEntity.getId()!=null){
            try {
                authUserService.updateUser(authUserEntity);
                rd.setMessage("更新成功");
                rd.setState(200);
            }
            catch (Exception e) {
                rd.setMessage("更新失败");
                rd.setState(999);
                e.printStackTrace();
            }
        }
        return rd;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public ResultData deleteUser(String id){
        ResultData rd = new ResultData();
        AuthUserEntity user = authUserService.QyeryUser(id);
        if(user!=null){
            try {
                authUserService.deleteUser(id);
                rd.setMessage("删除成功");
                rd.setState(200);
            }
            catch (Exception e) {
                rd.setMessage("删除失败");
                rd.setState(999);
                e.printStackTrace();
            }
        }
        return rd;
    }

}
