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
 * CREATE TABLE `businesstable` (
  `BID` int(11) NOT NULL AUTO_INCREMENT,
  `BAccount` varchar(255) NOT NULL,
  `BName` varchar(255) DEFAULT NULL,
  `BPsw` varchar(255) DEFAULT NULL,
  `BSex` char(1) DEFAULT NULL,
  `BPhone` varchar(255) DEFAULT NULL,
  `BEmail` varchar(255) DEFAULT NULL,
  `BAdr` varchar(255) DEFAULT NULL,
  `BIDcard` varchar(255) DEFAULT NULL,
  `Enabled` int(11) DEFAULT NULL,
  `CreateTime` datetime DEFAULT NULL,
  `UpdateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`BID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
 */

@Entity
@Table(name = "businesstable", catalog = "booksonline")
public class BusinessTable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer bid;

	private String baccount;
	private String bname;
	private String bpsw;
	private String bsex;
	private String bphone;
	private String bemail;
	private String badr;
	private String bidcard;
	private Integer enabled;

	private Timestamp createtime;
	private Timestamp updatetime;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BID")
	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {

		this.bid = bid;
	}

	@Column(name = "BAccount")
	public String getBaccount() {
		return baccount;
	}

	public void setBaccount(String baccount) {
		this.baccount = baccount;
	}

	@Column(name = "BSex")
	public String getBsex() {
		return bsex;
	}

	public void setBsex(String bsex) {
		this.bsex = bsex;
	}

	@Column(name = "BName")
	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	@Column(name = "BPsw")
	public String getBpsw() {
		return bpsw;
	}

	public void setBpsw(String bpsw) {
		this.bpsw = bpsw;
	}

	@Column(name = "BPhone")
	public String getBphone() {
		return bphone;
	}

	public void setBphone(String bphone) {
		this.bphone = bphone;
	}

	@Column(name = "BEmail")
	public String getBemail() {
		return bemail;
	}

	public void setBemail(String bemail) {
		this.bemail = bemail;
	}

	@Column(name = "BAdr")
	public String getBadr() {
		return badr;
	}

	public void setBadr(String badr) {
		this.badr = badr;
	}

	@Column(name = "BIDcard")

	public String getBidcard() {
		return bidcard;
	}

	public void setBidcard(String bidcard) {
		this.bidcard = bidcard;
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
