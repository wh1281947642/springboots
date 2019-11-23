package com.example.springboots.entity.framework;


import java.util.Date;

public class AuthUserPwdEntity implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    
    /**
     * 主键
     */

    private String id;
    
    /**
     * 用户密码
     */
    private String password;
    
    /**
     * 加密密码
     */
    private String encryption;
    
    /**
     * 记录创建时间
     */
    private Date createDatetime;
    
    /**
     * 记录创建人ID
     */
    private String createUserid;
    
    /**
     * 记录创建人用户名
     */
    private String createUsername;

    
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEncryption() {
        return this.encryption;
    }

    public void setEncryption(String encryption) {
        this.encryption = encryption;
    }


    public Date getCreateDatetime() {
        return this.createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public String getCreateUserid() {
        return this.createUserid;
    }

    public void setCreateUserid(String createUserid) {
        this.createUserid = createUserid;
    }

    public String getCreateUsername() {
        return this.createUsername;
    }

    public void setCreateUsername(String createUsername) {
        this.createUsername = createUsername;
    }

}