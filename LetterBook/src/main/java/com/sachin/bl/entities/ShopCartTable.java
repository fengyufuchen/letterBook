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
 * CREATE TABLE `shopcartable` (
  `SCID` int(11) NOT NULL AUTO_INCREMENT,
  `UID` int(11) NOT NULL,
  `Enabled` int(11) DEFAULT NULL,
  `CreateTime` datetime DEFAULT NULL,
  `UpdateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`SCID`),
  KEY `ScID_UID` (`UID`),
  CONSTRAINT `ScID_UID` FOREIGN KEY (`UID`) REFERENCES `usertable` (`UID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
e 'booksonline.shopcarttable' doesn't exist; SQL [n/a]; nested exception is org.hibernate.exception.SQLGrammarExc
 */
@Entity
@Table(name = "shopcartable", catalog = "booksonline")
public class ShopCartTable implements Serializable {

	private Integer scid;
	private UserTable userTable;

	private Integer enabled;
	private Timestamp createtime;
	private Timestamp updatetime;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ScID",unique=true,nullable=false)
	public Integer getScid() {
		return scid;
	}

	public void setScid(Integer scid) {
		this.scid = scid;
	}

	@ManyToOne(targetEntity = UserTable.class)
	@JoinColumn(name = "UID")

	public UserTable getUserTable() {
		return userTable;
	}

	public void setUserTable(UserTable userTable) {
		this.userTable = userTable;
	}

	public Integer getEnabled() {
		return enabled;
	}

	@Column(name = "Enabled")
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
