package com.sachin.bl.dao;

import java.util.List;
import java.util.Map;

import com.sachin.bl.entities.BookTable;

public interface BookDao {

	  public abstract Integer getListBookCount(Map paramMap);
	  
	  public abstract List<BookTable> getListBookPage(Map paramMap);
	  
	  public abstract Integer getListBookCountByBID(Map paramMap);
	  
	  public abstract List<BookTable> getListBookPageByBID(Map paramMap);
	  
	  public abstract BookTable gainBookByBoName(String paramString);
	  
	  public abstract BookTable getBookByBoID(Integer paramInteger);
	  
	  public abstract boolean deleteBookByBoID(Integer paramInteger);
	  
	  public abstract boolean saveBook(BookTable paramBookTable);
	  
	  public abstract boolean updateBook(BookTable paramBookTable);
	  
	  public abstract List<BookTable> getAllBook();
}
