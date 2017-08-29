package com.sachin.bl.service;

import java.util.Map;

import com.sachin.bl.entities.BookTable;
import com.sachin.bl.entities.Pagination;

public interface BookService {
	 public abstract BookTable gainBookByBoName(String paramString);
	  
	  public abstract Pagination<BookTable> getListBookPage(Map paramMap);
	  
	  public abstract Pagination<BookTable> getListBookPageByBid(Map paramMap);
	  
	  public abstract BookTable getBookByBoID(Integer paramInteger);
	  
	  public abstract boolean deleteBookByBoID(Integer paramInteger);
	  
	  public abstract boolean saveBook(BookTable paramBookTable);
	  
	  public abstract boolean updateBook(BookTable paramBookTable);
	  
	  public abstract boolean isBookexist(BookTable paramBookTable);
}
