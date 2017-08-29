package com.sachin.bl.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/*
 * CREATE TABLE `ordercontenttable` (
  `OcID` int(11) NOT NULL AUTO_INCREMENT,
  `OID` int(11) NOT NULL,
  `BoID` int(11) NOT NULL,
  `Number` int(11) NOT NULL,
  PRIMARY KEY (`OcID`),
  KEY `OcID_OID` (`OID`),
  KEY `OcID_BoID` (`BoID`),
  CONSTRAINT `OcID_BoID` FOREIGN KEY (`BoID`) REFERENCES `booktable` (`BoID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `OcID_OID` FOREIGN KEY (`OID`) REFERENCES `ordertable` (`OID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;


 */

@Entity
@Table(name = "ordercontenttable", catalog = "booksonline")
public class OrderContentTable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer ocid;
	private OrderTable orderTable;
	private BookTable bookTable;
	private Integer number;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OcID")

	public Integer getOcid() {
		return ocid;
	}

	public void setOcid(Integer ocid) {
		this.ocid = ocid;
	}

	@ManyToOne(targetEntity = OrderTable.class)
	@JoinColumn(name = "OID")
	public OrderTable getOrderTable() {
		return orderTable;
	}

	public void setOrderTable(OrderTable orderTable) {
		this.orderTable = orderTable;
	}

	@ManyToOne
	@JoinColumn(name = "BoID")
	public BookTable getBookTable() {
		return bookTable;
	}

	/*
	 * 觉得这个地方不太合理
	 */

	public void setBookTable(BookTable bookTable) {
		this.bookTable = bookTable;
	}

	@Column(name = "Number")
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
