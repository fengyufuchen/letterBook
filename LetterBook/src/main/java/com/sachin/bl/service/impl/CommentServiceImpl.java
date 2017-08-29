package com.sachin.bl.service.impl;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sachin.bl.dao.CommentDao;
import com.sachin.bl.entities.CommentTable;
import com.sachin.bl.entities.Pagination;
import com.sachin.bl.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao;

	@Override
	public Pagination<CommentTable> getListCommentPage(Map paramMap) {
		// TODO Auto-generated method stub
		List<CommentTable> listCommentPages = commentDao.getListCommentPage(paramMap);

		Pagination<CommentTable> pagination = new Pagination<>();
		pagination.setContent(listCommentPages);

		pagination.setCurrentPage(Integer.valueOf(paramMap.get("pageNum").toString()));
		pagination.setNumPerPage(Integer.valueOf(paramMap.get("pageSize").toString()));

		pagination.setTotalCount(commentDao.getListCommentCount(paramMap));
		pagination.calculatePage();

		return pagination;
	}

	@Override
	public Pagination<CommentTable> getListCommentPages(Map paramMap) {
		// TODO Auto-generated method stub

		List<CommentTable> listCommentPages = commentDao.getListCommentPages(paramMap);

		Pagination<CommentTable> pagination = new Pagination<>();
		pagination.setContent(listCommentPages);

		pagination.setCurrentPage(Integer.valueOf(paramMap.get("pageNum").toString()));
		pagination.setNumPerPage(Integer.valueOf(paramMap.get("pageSize").toString()));

		pagination.setTotalCount(commentDao.getListCommentCount(paramMap));
		pagination.calculatePage();

		return pagination;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * ��ȡĳһ���û�������
	 */
	@Override
	public Pagination<CommentTable> getCommentPageByUid(Map paramMap) {
		// TODO Auto-generated method stub
		List<CommentTable> listCommentPages = commentDao.getListCommentPageByUid(paramMap);

		Pagination<CommentTable> pagination = new Pagination<>();
		pagination.setContent(listCommentPages);

		pagination.setCurrentPage(Integer.valueOf(paramMap.get("pageNum").toString()));
		pagination.setNumPerPage(Integer.valueOf(paramMap.get("pageSize").toString()));

		pagination.setTotalCount(commentDao.getListCommentCountByUid(paramMap));
		pagination.calculatePage();

		return pagination;

	}

	/*
	 * 
	 * 
	 * �����鼮id��ѯ��Ӧ��������Ϣ��Ȼ���������Ϣ���з�ҳ�� ��Ҫ�����۱���鼮��������Ӳ�ѯ
	 */
	@Override
	public Pagination<CommentTable> getCommentPageByBoid(Map paramMap) {
		// TODO Auto-generated method stub
		List<CommentTable> listCommentPageByBoid = commentDao.getListCommentPageByBoid(paramMap);

		Pagination<CommentTable> pagination = new Pagination<>();
		pagination.setContent(listCommentPageByBoid);
		pagination.setCurrentPage(Integer.valueOf(paramMap.get("pageNum").toString()));
		pagination.setNumPerPage(Integer.valueOf(paramMap.get("pageSize").toString()));

		pagination.setTotalCount(commentDao.getListCommentCountByBoid(paramMap));
		pagination.calculatePage();

		return pagination;

	}

	@Override
	public boolean deleteCommentByCoID(Integer paramInteger) {
		// TODO Auto-generated method stub
		return commentDao.deleteCommentByCoID(paramInteger);
	}

	@Override
	public boolean saveComment(CommentTable paramCommentTable) {
		// TODO Auto-generated method stub
		return commentDao.saveComment(paramCommentTable);
	}

	@Override
	public boolean updateComment(CommentTable paramCommentTable) {
		// TODO Auto-generated method stub
		return commentDao.updateComment(paramCommentTable);
	}

	@Override
	public boolean userupdateComment(CommentTable paramCommentTable) {
		// TODO Auto-generated method stub
		return commentDao.userupdateComment(paramCommentTable);
	}

	@Override
	public CommentTable getCommentByUid(Integer paramInteger) {
		// TODO Auto-generated method stub
		return commentDao.getCommentByUid(paramInteger);
	}

	@Override
	public CommentTable getCommentByUidAndBoid(Integer paramInteger1, Integer paramInteger2) {
		// TODO Auto-generated method stub
		return commentDao.getCommentByUidAndBoid(paramInteger1, paramInteger2);
	}

	@Override
	public List<CommentTable> getAllComment() {
		// TODO Auto-generated method stub
		return commentDao.getAllComment();
	}

	@Override
	public CommentTable getCommentByCoId(Integer paramInteger) {
		// TODO Auto-generated method stub
		return commentDao.getCommentByCoId(paramInteger);
	}

	@Override
	public CommentTable gainCommentByBoID(Integer paramInteger) {
		// TODO Auto-generated method stub
		return commentDao.gainCommentByBoID(paramInteger);
	}

}
