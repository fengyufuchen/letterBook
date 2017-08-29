package com.sachin.bl.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * CREATE TABLE `admintable` (
  `AID` int(11) NOT NULL AUTO_INCREMENT,
  `AName` varchar(255) NOT NULL,
  `APsw` varchar(255) DEFAULT NULL,
  `ASex` char(1) DEFAULT NULL,
  `APhone` varchar(255) DEFAULT NULL,
  `AEmail` varchar(255) DEFAULT NULL,
  `AAdr` varchar(255) DEFAULT NULL,
  `AIDcard` varchar(255) DEFAULT NULL,
  `Enabled` int(11) DEFAULT NULL,
  `CreateTime` datetime DEFAULT NULL,
  `UpdateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`AID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
 */

@javax.persistence.Entity
@Table(name = "admintable", catalog = "boosonline")
public class AdminTable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer aid;

	private String aname;
	private String apsw;
	private String asex;
	private String aphone;
	private String aemail;
	private String aadr;
	private String aidcard;
	private Integer enabled;
	private Timestamp createtime;
	private Timestamp updatetime;

	public AdminTable() {
		super();

	}

	public AdminTable(Integer aid) {
		super();
		this.aid = aid;
	}

	/*
	 * auto_increment sequence identity native foreign 主键策略是identity
	 * 依赖于底层数据库的自动增长
	 */
	@Id
	@Column(name = "AID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}
	@Column(name = "AName", length = 255)
	public String getAname() {
		return aname;
	}


	public void setAname(String aName) {
		this.aname = aName;
	}

	@Column(name = "APsw", length = 255)
	public String getApsw() {
		return apsw;
	}

	public void setApsw(String aPsw) {
		this.apsw = aPsw;
	}

	@Column(name = "ASex", length = 1)
	public String getAsex() {
		return asex;
	}

	public void setAsex(String aSex) {
		this.asex = aSex;
	}
	@Column(name = "APhone", length = 255)
	public String getAphone() {
		return aphone;
	}


	public void setAphone(String aPhone) {
		this.aphone = aPhone;
	}


	@Column(name = "AEmail", length = 255)
	public String getAemail() {
		return aemail;
	}

	public void setAemail(String aEmail) {
		this.aemail = aEmail;
	}
	@Column(name = "AAdr", length = 255)
	public String getAadr() {
		return aadr;
	}

	
	public void setAadr(String aAdr) {
		this.aadr = aAdr;
	}

	@Column(name = "AIDCard", length = 255)
	public String getAidcard() {
		return aidcard;
	}


	public void setAidcard(String aIDcard) {
		this.aidcard = aIDcard;
	}
	@Column(name = "Enabled", length = 11)
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

}
