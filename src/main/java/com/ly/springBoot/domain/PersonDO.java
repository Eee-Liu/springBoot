package com.ly.springBoot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


/**
 * PersonDO
 *
 * @author
 */
@Entity
@Table(name = "auth_person")
public class PersonDO {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    //创建人
    @Column(name = "creator_id")
    private Long creatorId;
    //更新人
    @Column(name = "updater_id")
    private Long updaterId;
    //创建时间
    @Column(name = "create_time")
    private Date createTime;
    //更新时间
    @Column(name = "update_time")
    private Date updateTime;
    //0
    @Column(name = "is_delete")
    private Integer isDelete;
    @Column(name = "account")
    private String account;
    @Column(name = "phone")
    private String phone;
    @Column(name = "pwd")
    private String pwd;
    @Column(name = "can_login")

    private Integer canLogin;
    @Column(name = "is_admin")

    private Integer isAdmin;
    @Column(name = "super_pid")

    private Long superPid;
    @Column(name = "name")

    private String name;
    @Column(name = "email")

    private String email;
    @Column(name = "head_pic")

    private String headPic;
    //toC加价比率
    @Column(name = "to_cus_plus")

    private Float toCusPlus;
    //B-b加价比率,单位%
    @Column(name = "bus_subbus_plus")

    private Float busSubbusPlus;
    //B-b拥金,单位%
    @Column(name = "bus_subbus_com")

    private Float busSubbusCom;
    //地址
    @Column(name = "address")

    private String address;
    @Column(name = "logistic")

    //01干线 02支线 03直配, 多个;分隔
    private String logistic;

    //合同开始时间
    @Column(name = "contract_start_time")

    private Date contractStartTime;
    //合同失效时间
    @Column(name = "contract_end_time")

    private Date contractEndTime;
    @Column(name = "sap_no")

    private String sapNo;
    @Column(name = "ecard_no")

    //大B的eCard卡号
    private String ecardNo;
    @Column(name = "nick_name")

    //昵称
    private String nickName;
    @Column(name = "remark")

    //备注
    private String remark;
    @Column(name = "company")

    //所属公司名称
    private String company;
    @Column(name = "excel_no")

    //从excel导入的唯一标识
    private Long excelNo;
    @Column(name = "system_type")

    //客户端类型:1-app端;2-admin后台管理端
    private Integer systemType;
    //门店id
    @Column(name = "store_id")
    private Long storeId;
    //开发者姓名
    @Column(name = "pioneer_name")
    private String pioneerName;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public Long getCreatorId() {
        return this.creatorId;
    }

    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }

    public Long getUpdaterId() {
        return this.updaterId;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getIsDelete() {
        return this.isDelete;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccount() {
        return this.account;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPwd() {
        return this.pwd;
    }

    public void setCanLogin(Integer canLogin) {
        this.canLogin = canLogin;
    }

    public Integer getCanLogin() {
        return this.canLogin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Integer getIsAdmin() {
        return this.isAdmin;
    }

    public void setSuperPid(Long superPid) {
        this.superPid = superPid;
    }

    public Long getSuperPid() {
        return this.superPid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getHeadPic() {
        return this.headPic;
    }

    public void setToCusPlus(Float toCusPlus) {
        this.toCusPlus = toCusPlus;
    }

    public Float getToCusPlus() {
        return this.toCusPlus;
    }

    public void setBusSubbusPlus(Float busSubbusPlus) {
        this.busSubbusPlus = busSubbusPlus;
    }

    public Float getBusSubbusPlus() {
        return this.busSubbusPlus;
    }

    public void setBusSubbusCom(Float busSubbusCom) {
        this.busSubbusCom = busSubbusCom;
    }

    public Float getBusSubbusCom() {
        return this.busSubbusCom;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setLogistic(String logistic) {
        this.logistic = logistic;
    }

    public String getLogistic() {
        return this.logistic;
    }

    public void setContractStartTime(Date contractStartTime) {
        this.contractStartTime = contractStartTime;
    }

    public Date getContractStartTime() {
        return this.contractStartTime;
    }

    public void setContractEndTime(Date contractEndTime) {
        this.contractEndTime = contractEndTime;
    }

    public Date getContractEndTime() {
        return this.contractEndTime;
    }

    public void setSapNo(String sapNo) {
        this.sapNo = sapNo;
    }

    public String getSapNo() {
        return this.sapNo;
    }

    public void setEcardNo(String ecardNo) {
        this.ecardNo = ecardNo;
    }

    public String getEcardNo() {
        return this.ecardNo;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Long getExcelNo() {
        return excelNo;
    }

    public void setExcelNo(Long excelNo) {
        this.excelNo = excelNo;
    }

    public Integer getSystemType() {
        return systemType;
    }

    public void setSystemType(Integer systemType) {
        this.systemType = systemType;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getPioneerName() {
        return pioneerName;
    }

    public void setPioneerName(String pioneerName) {
        this.pioneerName = pioneerName;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", creatorId=" + creatorId +
                ", updaterId=" + updaterId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isDelete=" + isDelete +
                ", account='" + account + '\'' +
                ", phone='" + phone + '\'' +
                ", pwd='" + pwd + '\'' +
                ", canLogin=" + canLogin +
                ", isAdmin=" + isAdmin +
                ", superPid=" + superPid +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", headPic='" + headPic + '\'' +
                ", toCusPlus=" + toCusPlus +
                ", busSubbusPlus=" + busSubbusPlus +
                ", busSubbusCom=" + busSubbusCom +
                ", address='" + address + '\'' +
                ", logistic='" + logistic + '\'' +
                ", contractStartTime=" + contractStartTime +
                ", contractEndTime=" + contractEndTime +
                ", sapNo='" + sapNo + '\'' +
                ", ecardNo='" + ecardNo + '\'' +
                ", nickName='" + nickName + '\'' +
                ", remark='" + remark + '\'' +
                ", company='" + company + '\'' +
                ", excelNo=" + excelNo +
                ", systemType=" + systemType +
                '}';
    }
}