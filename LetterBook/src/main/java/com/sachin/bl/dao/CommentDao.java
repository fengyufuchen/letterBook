package com.sachin.bl.dao;

import java.util.List;
import java.util.Map;

import com.sachin.bl.entities.CommentTable;

public interface CommentDao {
	public abstract Integer getListCommentCount(Map paramMap);
	  
	  public abstract List<CommentTable> getListCommentPage(Map paramMap);
	  
	  public abstract List<CommentTable> getListCommentPages(Map paramMap);
	  
	  public abstract List<CommentTable> getListCommentPageByUid(Map paramMap);
	  
	  public abstract Integer getListCommentCountByUid(Map paramMap);
	  
	  public abstract List<CommentTable> getListCommentPageByBoid(Map paramMap);
	  
	  public abstract Integer getListCommentCountByBoid(Map paramMap);
	  
	  public abstract boolean deleteCommentByCoID(Integer paramInteger);
	  
	  public abstract boolean saveComment(CommentTable paramCommentTable);
	  
	  public abstract boolean updateComment(CommentTable paramCommentTable);
	  
	  public abstract boolean userupdateComment(CommentTable paramCommentTable);
	  
	  public abstract CommentTable getCommentByUid(Integer paramInteger);
	  
	  public abstract CommentTable getCommentByCoId(Integer paramInteger);
	  
	  public abstract CommentTable getCommentByUidAndBoid(Integer paramInteger1, Integer paramInteger2);
	  
	  public abstract List<CommentTable> getAllComment();
	  
	  public abstract CommentTable gainCommentByBoID(Integer paramInteger);
}
