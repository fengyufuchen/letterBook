package com.sachin.bl.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sachin.bl.dao.BookDao;
import com.sachin.bl.entities.BookTable;
import com.sachin.bl.entities.Pagination;
import com.sachin.bl.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;

	@Override
	public BookTable gainBookByBoName(String paramString) {
		// TODO Auto-generated method stub

		BookTable gainBookByBoName = bookDao.gainBookByBoName(paramString);

		return gainBookByBoName;
	}

	@Override
	public Pagination<BookTable> getListBookPage(Map paramMap) {
		// TODO Auto-generated method stub

		Pagination<BookTable> page = new Pagination<>();
		List<BookTable> listBookPage = bookDao.getListBookPage(paramMap);
		page.setContent(listBookPage);
		page.setCurrentPage(Integer.valueOf(paramMap.get("pageNum").toString()));
		page.setNumPerPage(Integer.valueOf(paramMap.get("pageSize").toString()));
		page.setTotalCount(bookDao.getListBookCount(paramMap));
		page.calculatePage();

		return page;
	}

	@Override
	public Pagination<BookTable> getListBookPageByBid(Map paramMap) {
		// TODO Auto-generated method stub
		bookDao.getListBookCountByBID(paramMap);
		return null;
	}

	/*
	 * 
	 * 根据书籍的id查询书籍的简介信息
	 */
	@Override
	public BookTable getBookByBoID(Integer boid) {
		// TODO Auto-generated method stub

		return bookDao.getBookByBoID(boid);

	}

	@Override
	public boolean deleteBookByBoID(Integer paramInteger) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveBook(BookTable paramBookTable) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateBook(BookTable paramBookTable) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isBookexist(BookTable paramBookTable) {
		// TODO Auto-generated method stub
		return false;
	}

}
