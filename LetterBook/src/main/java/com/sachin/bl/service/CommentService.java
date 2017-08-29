package com.sachin.bl.service;

import java.util.List;
import java.util.Map;

import com.sachin.bl.entities.CommentTable;
import com.sachin.bl.entities.Pagination;

public interface CommentService {

	public abstract Pagination<CommentTable> getListCommentPage(Map paramMap);

	public abstract Pagination<CommentTable> getListCommentPages(Map paramMap);

	public abstract Pagination<CommentTable> getCommentPageByUid(Map paramMap);

	public abstract Pagination<CommentTable> getCommentPageByBoid(Map paramMap);

	public abstract boolean deleteCommentByCoID(Integer paramInteger);

	public abstract boolean saveComment(CommentTable paramCommentTable);

	public abstract boolean updateComment(CommentTable paramCommentTable);

	public abstract boolean userupdateComment(CommentTable paramCommentTable);

	public abstract CommentTable getCommentByUid(Integer paramInteger);

	public abstract CommentTable getCommentByUidAndBoid(Integer paramInteger1, Integer paramInteger2);

	public abstract List<CommentTable> getAllComment();

	public abstract CommentTable getCommentByCoId(Integer paramInteger);

	public abstract CommentTable gainCommentByBoID(Integer paramInteger);
}
