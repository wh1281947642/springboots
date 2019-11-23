/*
 * 文件名：AuthUserPwdMapper.java
 * 描述：山东国土资源厅行政审批系统
 * 修改人：Administrator
 * 修改时间：2018-9-5
 * 修改内容：新建
 * 系统名称：山东国土资源厅行政审批系统
 */
 
package com.example.springboots.dao.framework;




import com.example.springboots.entity.framework.AuthUserPwdEntity;
import com.example.springboots.entity.framework.vo.AuthUserVo;
import com.example.springboots.service.iface.ISupperMapper;
import org.apache.ibatis.annotations.Param;


/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 * @author Administrator
 * @version 1.0 2018-9-5
 * @see IAuthUserPwdMapper
 * @since 1.0
 */


public interface IAuthUserPwdMapper extends ISupperMapper<AuthUserPwdEntity> {
    public AuthUserVo queryLoginUserInfo(@Param("loginName") String loginName);

}
