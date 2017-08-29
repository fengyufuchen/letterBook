package com.sachin.bl.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * CREATE TABLE `ordertable` (
  `OID` int(11) NOT NULL AUTO_INCREMENT,
  `OName` varchar(255) DEFAULT NULL,
  `OAdr` varchar(255) DEFAULT NULL,
  `OPhone` varchar(255) DEFAULT NULL,
  `BID` int(11) NOT NULL,
  `UID` int(11) NOT NULL,
  `OTime` datetime DEFAULT NULL,
  `OPrice` float(11,2) NOT NULL,
  `OState` int(11) DEFAULT NULL,
  `Enabled` int(11) DEFAULT NULL,
  `CreateTime` datetime DEFAULT NULL,
  `UpdateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`OID`),
  KEY `OID_BoID` (`OName`),
  KEY `OID_BID` (`BID`),
  KEY `OID_UID` (`UID`),
  CONSTRAINT `OID_BID` FOREIGN KEY (`BID`) REFERENCES `businesstable` (`BID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `OID_UID` FOREIGN KEY (`UID`) REFERENCES `usertable` (`UID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;


 */
@Entity
@Table(name = "ordertable", catalog = "booksonline")

public class OrderTable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer oid;
	private String oname;
	private String oadr;
	private String ophone;
	private BusinessTable businessTable;
	private UserTable userTable;
	private Timestamp otime;
	private Float oprice;
	private Integer ostate;
	private Integer enabled;
	private Timestamp createtime;
	private Timestamp updatetime;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OID")
	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {

		this.oid = oid;
	}

	@Column(name = "OName")
	public String getOname() {
		return oname;
	}

	public void setOname(String oname) {
		this.oname = oname;
	}

	@Column(name = "OAdr")
	public String getOadr() {
		return oadr;
	}

	public void setOadr(String oadr) {
		this.oadr = oadr;
	}

	@Column(name = "OPhone")
	public String getOphone() {
		return ophone;
	}

	public void setOphone(String ophone) {
		this.ophone = ophone;
	}

	@ManyToOne(targetEntity = BusinessTable.class)
	@JoinColumn(name = "BID")

	public BusinessTable getBusinessTable() {
		return businessTable;
	}

	public void setBusinessTable(BusinessTable businessTable) {
		this.businessTable = businessTable;
	}

	@ManyToOne(targetEntity = UserTable.class)
	@JoinColumn(name = "UID")
	public UserTable getUserTable() {
		return userTable;
	}

	public void setUserTable(UserTable userTable) {
		this.userTable = userTable;
	}

	@Column(name = "OTime")
	public Timestamp getOtime() {
		return otime;
	}

	public void setOtime(Timestamp otime) {
		this.otime = otime;
	}

	@Column(name = "OPrice")
	public Float getOprice() {
		return oprice;
	}

	public void setOprice(Float oprice) {
		this.oprice = oprice;
	}

	@Column(name = "OState")
	public Integer getOstate() {
		return ostate;
	}

	public void setOstate(Integer ostate) {
		this.ostate = ostate;
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

	@Override
	public String toString() {
		return "OrderTable [oid=" + oid + ", oname=" + oname + ", oadr=" + oadr + ", ophone=" + ophone
				+ ", businessTable=" + businessTable + ", userTable=" + userTable + ", otime=" + otime + ", oprice="
				+ oprice + ", ostate=" + ostate + ", enabled=" + enabled + ", createtime=" + createtime
				+ ", updatetime=" + updatetime + "]";
	}
	

}
