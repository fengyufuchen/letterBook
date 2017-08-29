package com.sachin.bl.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/*
 * CREATE TABLE `usertable` (
  `UID` int(11) NOT NULL AUTO_INCREMENT,
  `UAccount` varchar(255) NOT NULL,
  `UName` varchar(255) DEFAULT NULL,
  `UPsw` varchar(255) DEFAULT NULL,
  `USex` char(1) DEFAULT NULL,
  `UPhone` varchar(255) DEFAULT NULL,
  `UEmail` varchar(255) DEFAULT NULL,
  `UAdr` varchar(255) DEFAULT NULL,
  `Enabled` int(11) DEFAULT NULL,
  `CreateTime` datetime DEFAULT NULL,
  `UpdateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`UID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

 */

@Entity
@Table(name = "usertable", catalog = "booksonline")
public class UserTable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer uid;
	private String uaccount;
	private String uname;
	private String upsw;
	private String usex;
	private String uphone;
	private String uemail;
	private String uadr;
	private Integer enabled;
	private Timestamp createtime;
	private Timestamp updatetime;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UID")
	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	@Column(name = "UAccount")
	public String getUaccount() {

		return uaccount;
	}

	public void setUaccount(String uaccount) {
		this.uaccount = uaccount;
	}

	@Column(name = "UName")

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	@Column(name = "UPsw")
	public String getUpsw() {
		return upsw;
	}

	public void setUpsw(String upsw) {
		this.upsw = upsw;
	}

	@Column(name = "USex")
	public String getUsex() {
		return usex;
	}

	public void setUsex(String usex) {
		this.usex = usex;
	}

	@Column(name = "UPhone")
	public String getUphone() {
		return uphone;
	}

	public void setUphone(String uphone) {
		this.uphone = uphone;
	}

	@Column(name = "UEmail")
	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	@Column(name = "UAdr")
	public String getUadr() {
		return uadr;
	}

	public void setUadr(String uadr) {
		this.uadr = uadr;
	}

	@Column(name = "Enabled")
	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	@Column(name = "CreateTime")
	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp craeteTime) {
		this.createtime = craeteTime;
	}

	@Column(name = "UpdateTime")
	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updateTime) {
		this.updatetime = updateTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
