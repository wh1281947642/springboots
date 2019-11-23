/*
 * 文件名：IAuthUserPwdService.java
 * 描述：山东国土资源厅行政审批系统
 * 修改人：Administrator
 * 修改时间：2018-9-11
 * 修改内容：新建
 * 系统名称：山东国土资源厅行政审批系统
 */

package com.example.springboots.service.framework;
import com.example.springboots.entity.framework.AuthUserPwdEntity;
import com.example.springboots.service.iface.ISupperService;
import com.example.springboots.utils.ResultData;


/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 * @author Administrator
 * @version 1.0 2018-9-11
 * @see IAuthUserPwdService
 * @since 1.0
 */
public interface IAuthUserPwdService extends ISupperService<AuthUserPwdEntity> {

    /**
     * 登陆验证
     * @param loginname 登陆名
     * @param password 登陆密码（明文）
     * @return ResultData.state 10000=成功 20000=登陆账号不存在 30000=密码错误 30001=密码未设置 40000=用户被禁用 50000=角色被禁用

     */
    ResultData login(String loginname, String password) throws Exception;

}
