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
 * CREATE TABLE `booktable` (
  `BoID` int(11) NOT NULL AUTO_INCREMENT,
  `BoName` varchar(255) NOT NULL,
  `BoAuthor` varchar(255) DEFAULT NULL,
  `BoPrice` float(11,2) NOT NULL,
  `BoPress` varchar(255) DEFAULT NULL,
  `BoTime` datetime DEFAULT NULL,
  `BoSummary` varchar(5000) DEFAULT NULL,
  `BoNumber` int(11) DEFAULT NULL,
  `BoAmount` int(11) DEFAULT NULL,
  `BoImg` varchar(255) DEFAULT NULL,
  `BID` int(11) NOT NULL,
  `Enabled` int(11) DEFAULT NULL,
  `CreateTime` datetime DEFAULT NULL,
  `UpdateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`BoID`),
  KEY `BoID_BID` (`BID`),
  CONSTRAINT `BoID_BID` FOREIGN KEY (`BID`) REFERENCES `businesstable` (`BID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;


 */
@Entity
@Table(name = "booktable", catalog = "booksonline")

public class BookTable implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer boid;
	private String boname;
	private String boauthor;
	private float boprice;
	private String bopress;
	private Timestamp botime;
	private String bosummary;
	private Integer bonumber;
	private Integer boamount;
	private String boimg;
	private Integer enabled;
	private Timestamp createtime;
	private Timestamp updatetime;
	private BusinessTable business;

	public BookTable() {
	}

	public BookTable(Integer boid) {
		this.boid = boid;
	}

	@Id
	@Column(name = "BoID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getBoid() {
		return this.boid;
	}

	public void setBoid(Integer boid) {
		this.boid = boid;
	}

	@Column(name = "BoName", length = 255)
	public String getBoname() {
		return this.boname;
	}

	public void setBoname(String boname) {
		this.boname = boname;
	}

	@Column(name = "BoAuthor", length = 255)
	public String getBoauthor() {
		return this.boauthor;
	}

	public void setBoauthor(String boauthor) {
		this.boauthor = boauthor;
	}

	@Column(name = "BoPrice")
	public float getBoprice() {
		return this.boprice;
	}

	public void setBoprice(float boprice) {
		this.boprice = boprice;
	}

	@Column(name = "BoPress")
	public String getBopress() {
		return this.bopress;
	}

	public void setBopress(String bopress) {
		this.bopress = bopress;
	}

	@Column(name = "BoTime")
	public Timestamp getBotime() {
		return this.botime;
	}

	public void setBotime(Timestamp botime) {
		this.botime = botime;
	}

	@Column(name = "BoSummary", length = 255)
	public String getBosummary() {
		return this.bosummary;
	}

	public void setBosummary(String bosummary) {
		this.bosummary = bosummary;
	}

	@Column(name = "BoNumber")
	public Integer getBonumber() {
		return this.bonumber;
	}

	public void setBonumber(Integer bonumber) {
		this.bonumber = bonumber;
	}

	@Column(name = "BoAmount")
	public Integer getBoamount() {
		return this.boamount;
	}

	public void setBoamount(Integer boamount) {
		this.boamount = boamount;
	}

	@Column(name = "BoImg", length = 255)
	public String getBoimg() {
		return this.boimg;
	}

	public void setBoimg(String boimg) {
		this.boimg = boimg;
	}

	@Column(name = "Enabled")
	public Integer getEnabled() {
		return this.enabled;
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


	@ManyToOne(targetEntity = BusinessTable.class)
	@JoinColumn(name = "BID")
	public BusinessTable getBusiness() {
		return this.business;
	}

	public void setBusiness(BusinessTable business) {
		this.business = business;
	}

}
