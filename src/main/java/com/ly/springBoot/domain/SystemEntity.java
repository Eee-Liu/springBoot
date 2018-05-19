package com.ly.springBoot.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


/**
 * SystemDO 
 * @author  
 * 
 */
@Entity
@Table(name = "system")
public class SystemEntity {

   //id
    @Id
    @GeneratedValue
    @Column(name = "id")
	private Integer id;
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
   //系统编码
   @Column(name = "system_code")
	private String systemCode;
   //系统名
   @Column(name = "system_name")
	private String systemName;
   //备注
   @Column(name = "note")
	private String note;
   //1
   @Column(name = "state")
	private Integer state;


 public void setId(Integer id){
 this.id=id;
}

 public Integer  getId(){
    return this.id;
}

 public void setCreatorId(Long creatorId){
 this.creatorId=creatorId;
}

 public Long  getCreatorId(){
    return this.creatorId;
}

 public void setUpdaterId(Long updaterId){
 this.updaterId=updaterId;
}

 public Long  getUpdaterId(){
    return this.updaterId;
}

 public void setCreateTime(Date createTime){
 this.createTime=createTime;
}

 public Date  getCreateTime(){
    return this.createTime;
}

 public void setUpdateTime(Date updateTime){
 this.updateTime=updateTime;
}

 public Date  getUpdateTime(){
    return this.updateTime;
}

 public void setIsDelete(Integer isDelete){
 this.isDelete=isDelete;
}

 public Integer  getIsDelete(){
    return this.isDelete;
}

 public void setSystemCode(String systemCode){
 this.systemCode=systemCode;
}

 public String  getSystemCode(){
    return this.systemCode;
}

 public void setSystemName(String systemName){
 this.systemName=systemName;
}

 public String  getSystemName(){
    return this.systemName;
}

 public void setNote(String note){
 this.note=note;
}

 public String  getNote(){
    return this.note;
}

 public void setState(Integer state){
 this.state=state;
}

 public Integer  getState(){
    return this.state;
}


}