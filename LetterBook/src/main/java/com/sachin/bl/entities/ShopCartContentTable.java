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
 * CREATE TABLE `shopcarcontenttable` (
  `SccID` int(11) NOT NULL AUTO_INCREMENT,
  `ScID` int(11) NOT NULL,
  `BoID` int(11) NOT NULL,
  `Number` int(11) NOT NULL,
  PRIMARY KEY (`SccID`),
  KEY `SccID_ScID` (`ScID`),
  KEY `SccID_BoID` (`BoID`),
  CONSTRAINT `SccID_BoID` FOREIGN KEY (`BoID`) REFERENCES `booktable` (`BoID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `SccID_ScID` FOREIGN KEY (`ScID`) REFERENCES `shopcartable` (`SCID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

 */
@Entity
@Table(name = "shopcarcontenttable", catalog = "booksonline")
public class ShopCartContentTable implements Serializable {

	private static final long serialVersionUID = 1L;
	  private Integer sccid;
	  private Integer number;
	  private ShopCartTable shopcar;
	  private BookTable book;
	  
	  public ShopCartContentTable() {}
	  
	  public ShopCartContentTable(Integer sccid)
	  {
	    this.sccid = sccid;
	  }
	  
	  @Id
	  @Column(name="SccID", unique=true, nullable=false)
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  public Integer getSccid()
	  {
	    return this.sccid;
	  }
	  
	  public void setSccid(Integer sccid)
	  {
	    this.sccid = sccid;
	  }
	  
	  @Column(name="Number")
	  public Integer getNumber()
	  {
	    return this.number;
	  }
	  
	  public void setNumber(Integer number)
	  {
	    this.number = number;
	  }
	  
	  @ManyToOne(targetEntity=ShopCartTable.class)
	  @JoinColumn(name="ScID")
	  public ShopCartTable getShopcar()
	  {
	    return this.shopcar;
	  }
	  
	  public void setShopcar(ShopCartTable shopcar)
	  {
	    this.shopcar = shopcar;
	  }
	  
	  @ManyToOne(targetEntity=BookTable.class)
	  @JoinColumn(name="BoID")
	  public BookTable getBook()
	  {
	    return this.book;
	  }
	  
	  public void setBook(BookTable book)
	  {
	    this.book = book;
	  }

}
