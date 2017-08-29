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
 * CREATE TABLE `commenttable` (
  `CoID` int(11) NOT NULL AUTO_INCREMENT,
  `BoID` int(11) NOT NULL,
  `UID` int(11) NOT NULL,
  `CoComment` varchar(5000) DEFAULT NULL,
  `CoReply` varchar(5000) DEFAULT NULL,
  `Enabled` int(11) DEFAULT NULL,
  `CreateTime` datetime DEFAULT NULL,
  `UpdateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`CoID`),
  KEY `CoID_BoID` (`BoID`),
  KEY `CoID_UID` (`UID`),
  CONSTRAINT `CoID_BoID` FOREIGN KEY (`BoID`) REFERENCES `booktable` (`BoID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `CoID_UID` FOREIGN KEY (`UID`) REFERENCES `usertable` (`UID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;


 */
@Entity
@Table(name = "commenttable", catalog = "booksonline")
public class CommentTable implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer coid;
	private BookTable bookTable;
	private UserTable user;
	private String cocomment;
	private String coreply;
	private Integer enabled;
	private Timestamp createtime;
	private Timestamp updatetime;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CoID", nullable = false, unique = true)
	public Integer getCoid() {
		return coid;
	}


	public void setCoid(Integer coid) {

		this.coid = coid;
	}

	@ManyToOne(targetEntity = BookTable.class)
	@JoinColumn(name = "BoID")
	public BookTable getBookTable() {
		return bookTable;
	}


	public void setBookTable(BookTable bookTable) {
		this.bookTable = bookTable;
	}
	@ManyToOne(targetEntity = UserTable.class)
	@JoinColumn(name = "UID")
	public UserTable getUser() {
		return user;
	}

	
	public void setUser(UserTable user) {
		this.user = user;
	}

	@Column(name = "CoComment")
	public String getCocomment() {
		return cocomment;
	}

	
	public void setCocomment(String cocommnet) {
		this.cocomment = cocommnet;
	}

	@Column(name = "CoReply")
	public String getCoreply() {
		return coreply;
	}

	public void setCoreply(String coReply) {
		this.coreply = coReply;
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
