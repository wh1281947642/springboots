package com.example.springboots.entity.utore;

import java.util.Date;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UtoStorage entity. @author MyEclipse Persistence Tools
 */
@Table(name = "UTO_STORAGE")
public class UtoStorageEntity implements java.io.Serializable {

    // Fields

    /**
     * 统一附件存储信息
     */
    private static final long serialVersionUID = 1L;
    /**
     * 主键，流程定义ID，系统生成
     */
    @Id
    private String id;
    /**
     * 开发者KEY
     */
    private String dkey;
    /**
     * 开发者名称
     */
    private String dname;
    /**
     * 应用KEY
     */
    private String akey;
    /**
     * 应用名称
     */
    private String aname;
    /**
     * 关联资源ID
     */
    private String sid;
    /**
     * 关联资源编码
     */
    private String scode;
    /**
     * 关联资源名称
     */
    private String sname;
    /**
     * 流程定义ID
     */
    private String procDefId;
    /**
     * 流程定义KEY
     */
    private String procDefKey;
    /**
     * 流程定义名称
     */
    private String procDefName;
    /**
     * 流程运行实例ID
     */
    private String procInstId;
    /**
     * 关联业务标识
     */
    private String businessKey;
    /**
     * 完整原始文件名（包含扩展名，不包含路径）
     */
    private String originalFilename;
    /**
     * 完整存储文件名（包含扩展名，不包含路径）
     */
    private String storageFilename;
    /**
     * 完整存储文件路径（包含完整存储文件名)
     */
    private String absolutePath;
    /**
     *文件类型
     */
    private String contentType;
    /**
     * 文件大小（单位：字节）
     */
    private long contentSize;
    /**
     * 已上传文件大小（单位：字节）
     */
    private long completeSize;
    /**
     * 文件扩展名（如：.doc、.txt）
     */
    private String extension;
    /**
     * 完整预览文件存储路径
     */
    private String previewPath;
    /**
     * 记录创建时间
     */
    private Date createDatetime;
    /**
     * 记录创建人（标识
     */
    private String createUserid;
    /**
     * 记录创建人（名称、姓名）
     */
    private String createUsernem;
    /**
     * 记录更新时间
     */
    private Date updateDatetime;
    /**
     * 记录更新人（标识）
     */
    private String updateUserid;
    /**
     * 记录更新人（名称、姓名
     */
    private String updateUsername;
    
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getDkey() {
        return this.dkey;
    }

    public void setDkey(String dkey) {
        this.dkey = dkey;
    }
    
    public String getDname() {
        return this.dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }
    
    public String getAkey() {
        return this.akey;
    }

    public void setAkey(String akey) {
        this.akey = akey;
    }

    public String getAname() {
        return this.aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getSid() {
        return this.sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
   
    public String getScode() {
        return this.scode;
    }

    public void setScode(String scode) {
        this.scode = scode;
    }

    public String getSname() {
        return this.sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
    
    public String getProcDefId() {
        return this.procDefId;
    }

    public void setProcDefId(String procDefId) {
        this.procDefId = procDefId;
    }
    
    public String getProcDefKey() {
        return this.procDefKey;
    }

    public void setProcDefKey(String procDefKey) {
        this.procDefKey = procDefKey;
    }

    public String getProcDefName() {
        return this.procDefName;
    }

    public void setProcDefName(String procDefName) {
        this.procDefName = procDefName;
    }
   
    public String getProcInstId() {
        return this.procInstId;
    }

    public void setProcInstId(String procInstId) {
        this.procInstId = procInstId;
    }
    
    public String getBusinessKey() {
        return this.businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }
    
    public String getOriginalFilename() {
        return this.originalFilename;
    }

    public void setOriginalFilename(String originalFilename) {
        this.originalFilename = originalFilename;
    }

    public String getStorageFilename() {
        return this.storageFilename;
    }

    public void setStorageFilename(String storageFilename) {
        this.storageFilename = storageFilename;
    }
   
    public String getAbsolutePath() {
        return this.absolutePath;
    }

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }

    public String getContentType() {
        return this.contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
    
    public long getContentSize() {
        return this.contentSize;
    }

    public void setContentSize(long contentSize) {
        this.contentSize = contentSize;
    }

    public String getExtension() {
        return this.extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
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
    
    public String getCreateUsernem() {
        return this.createUsernem;
    }

    public void setCreateUsernem(String createUsernem) {
        this.createUsernem = createUsernem;
    }

    public Date getUpdateDatetime() {
        return this.updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }
    
    public String getUpdateUserid() {
        return this.updateUserid;
    }

    public void setUpdateUserid(String updateUserid) {
        this.updateUserid = updateUserid;
    }

    public String getUpdateUsername() {
        return this.updateUsername;
    }

    public void setUpdateUsername(String updateUsername) {
        this.updateUsername = updateUsername;
    }
    
    public String getPreviewPath() {
        return previewPath;
    }
    
    public void setPreviewPath(String previewPath) {
        this.previewPath = previewPath;
    }

	public long getCompleteSize() {
		return completeSize;
	}

	public void setCompleteSize(long completeSize) {
		this.completeSize = completeSize;
	}
}