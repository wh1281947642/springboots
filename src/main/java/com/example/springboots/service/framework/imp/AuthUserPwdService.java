/*
 * 文件名：AuthUserPwdService.java
 * 描述：山东国土资源厅行政审批系统
 * 修改人：Administrator
 * 修改时间：2018-9-11
 * 修改内容：新建
 * 系统名称：山东国土资源厅行政审批系统
 */
 
package com.example.springboots.service.framework.imp;


import com.example.springboots.dao.framework.IAuthUserPwdMapper;
import com.example.springboots.entity.framework.AuthUserPwdEntity;
import com.example.springboots.entity.framework.vo.AuthUserVo;
import com.example.springboots.service.framework.IAuthUserPwdService;
import com.example.springboots.service.iface.ISupperMapper;
import com.example.springboots.service.iface.imp.FrameworkBaseService;
import com.example.springboots.utils.ResultData;
import com.example.springboots.utils.StringTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 * @author Administrator
 * @version 1.0 2018-9-11
 * @see AuthUserPwdService
 * @since 1.0
 */
@Service
public class AuthUserPwdService extends FrameworkBaseService<AuthUserPwdEntity> implements IAuthUserPwdService {

    @Autowired
    private IAuthUserPwdMapper authUserPwdMapper;

    @Override
    public ISupperMapper<AuthUserPwdEntity> getMapper() {
        return this.authUserPwdMapper;
    }

    
    /**
     * 登陆验证
     * @param loginname 登陆名
     * @param password 登陆密码（明文）
     * @return ResultData.state 10000=成功 20000=登陆账号不存在 30000=密码错误 30001=密码未设置 40000=用户被禁用 50000=角色被禁用
     */
    public ResultData login(String loginname, String password) throws Exception{
        ResultData rd = new ResultData();
        // 查询用户信息
        AuthUserVo authUserDto = authUserPwdMapper.queryLoginUserInfo(loginname.toUpperCase());
        if(authUserDto != null) {
            if(StringTools.isNullOrEmpty(authUserDto.getPassword())){//密码为空或未设置
                rd.setState(30001);
                rd.setMessage("登录密码未设置");
                return rd;
            }else if (!password.equals(authUserDto.getPassword())) {//密码不匹配
                rd.setState(30000);
                rd.setMessage("登录密码错误");
                return rd;
            } else if (authUserDto.getEnabled() != 1) {//账号禁用
                rd.setState(40000);
                rd.setMessage("该用户已被禁用，请联系管理员");
                return rd;
            } 
            rd.setObj(authUserDto);
            rd.setState(10000);
        } else {//账号不存在
            rd.setState(20000);
            rd.setMessage("用户名不存在");
            return rd;
        }
        return rd;
    }
}
