package com.example.springboots.entity.framework.vo;

import com.example.springboots.entity.framework.AuthUserEntity;

/**
 * AuthUser扩展类
 * 〈功能详细描述〉
 * @author chenjunan
 * @version 1.0 2018年5月2日
 * @see AuthUserVo
 * @since 1.0
 */
public class AuthUserVo extends AuthUserEntity {
    /**
     * <意义，目的和功能，以及可能被用到的地方>
     */
    private static final long serialVersionUID = 1L;

    /**
     * 登陆密码（明文）
     */
    private String password;
   
    /**
     * 登陆密码（加密）
     */
    private String encryption;
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEncryption() {
        return encryption;
    }

    public void setEncryption(String encryption) {
        this.encryption = encryption;
    }
}
