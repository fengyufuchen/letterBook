package com.sachin.bl.dao.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.xml.stream.events.Comment;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.cfg.CreateKeySecondPass;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sachin.bl.dao.CommentDao;
import com.sachin.bl.entities.CommentTable;

/**
 * @author lenovo
 *
 */
@Repository
public class CommentDaoImpl extends BaseDaoImpl implements CommentDao {

	/*
	 * (non-Javadoc) ��ȡ���۵�����
	 * 
	 */
	@Override
	public Integer getListCommentCount(Map paramMap) {
		// TODO Auto-generated method stub

		// ����һ���½�״̬�Ķ���
		// CommentTable commentTable = (CommentTable) paramMap.get("condition");

		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CommentTable.class);

		DetachedCriteria criteria = detachedCriteria.setProjection(Projections.countDistinct("coid"));
		Integer count = ((Long) this.hibernateTemplate.findByCriteria(criteria).get(0)).intValue();

		return count;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * ��ҳ��ȡ����
	 */
	@Override
	public List<CommentTable> getListCommentPage(Map paramMap) {
		// TODO Auto-generated method stub

		Integer curPageNum = Integer.valueOf(paramMap.get("pageNum").toString());
		Integer pageSize = Integer.valueOf(paramMap.get("pageSize").toString());

		DetachedCriteria detachedCritera = DetachedCriteria.forClass(CommentTable.class);

		String orderField = (String) paramMap.get("orderField");
		String direction = (String) paramMap.get("orderDirection");

		if (StringUtils.isNotEmpty(orderField) && StringUtils.isNotEmpty(direction)) {

			if ("asc".equalsIgnoreCase(direction)) {
				detachedCritera.addOrder(Order.asc(orderField));
			} else {
				detachedCritera.addOrder(Order.desc(orderField));
			}

		}

		List<CommentTable> ctList = (List<CommentTable>) this.hibernateTemplate.findByCriteria(detachedCritera,
				(curPageNum - 1) * pageSize, pageSize);

		// @formatter:on

		return ctList;
	}

	@Override
	public List<CommentTable> getListCommentPages(Map param) {
		// TODO Auto-generated method stub

		Integer pageNum = Integer.valueOf(param.get("pageNum").toString());
		Integer pageSize = Integer.valueOf(param.get("pageSize").toString());

		DetachedCriteria criteria = DetachedCriteria.forClass(CommentTable.class);

		List<CommentTable> comments = (List<CommentTable>) this.hibernateTemplate.findByCriteria(criteria,
				(pageNum.intValue() - 1) * pageSize.intValue(), pageSize.intValue());
		return comments;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * ��ȡĳһ���û�������
	 */
	@Override
	public List<CommentTable> getListCommentPageByUid(Map paramMap) {
		// TODO Auto-generated method stub

		Integer uid = Integer.valueOf(paramMap.get("uid").toString());
		Integer curPageNum = Integer.valueOf(paramMap.get("pageNum").toString());
		Integer pageSize = Integer.valueOf(paramMap.get("pageSize").toString());

		DetachedCriteria detachedCritera = DetachedCriteria.forClass(CommentTable.class);
		detachedCritera.createAlias("user", "u");
		// @formatter:on
		detachedCritera.add(Restrictions.eq("u.uid", uid));

		List<CommentTable> ctList = (List<CommentTable>) this.hibernateTemplate.findByCriteria(detachedCritera,
				(curPageNum - 1) * pageSize, pageSize);

		return ctList;
	}

	/*
	 * (non-Javadoc) ��ȡĳһ���û����۵�����
	 */
	@Override
	public Integer getListCommentCountByUid(Map paramMap) {
		// TODO Auto-generated method stub
		Integer uid = Integer.valueOf(paramMap.get("uid").toString());

		DetachedCriteria criteria = DetachedCriteria.forClass(CommentTable.class);

		criteria.createAlias("user", "u");
		criteria.add(Restrictions.eq("u.uid", uid));
		criteria.setProjection(Projections.countDistinct("coid"));

		Integer count = ((Long) this.hibernateTemplate.findByCriteria(criteria).get(0)).intValue();

		return count;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * ��ȡıһ���������
	 */
	@Override
	public List<CommentTable> getListCommentPageByBoid(Map paramMap) {
		// TODO Auto-generated method stub

		Integer boid = Integer.valueOf(paramMap.get("boid").toString());

		Integer curPageNum = Integer.valueOf(paramMap.get("pageNum").toString());
		Integer pageSize = Integer.valueOf(paramMap.get("pageSize").toString());

		DetachedCriteria detachedCritera = DetachedCriteria.forClass(CommentTable.class);
		detachedCritera.createAlias("bookTable", "b");
		detachedCritera.add(Restrictions.eq("b.boid", boid));

		List<CommentTable> ctList = (List<CommentTable>) this.hibernateTemplate.findByCriteria(detachedCritera,
				(curPageNum - 1) * pageSize, pageSize);

		return ctList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * ��ȡıһ��������۵� ����
	 */
	@Override
	public Integer getListCommentCountByBoid(Map paramMap) {
		// TODO Auto-generated method stub

		/*
		 * Integer boid = Integer.valueOf(paramMap.get("boid").toString());
		 * 
		 * DetachedCriteria detachedCritera =
		 * DetachedCriteria.forClass(CommentTable.class); DetachedCriteria
		 * createAlias = detachedCritera.createAlias("bookTable", "b");
		 * 
		 * detachedCritera.add(Restrictions.eq("b.boid", boid));
		 * 
		 * detachedCritera.setProjection(Projections.countDistinct("coid"));
		 * Integer count = (Integer)
		 * this.hibernateTemplate.findByCriteria(detachedCritera).get(0);
		 * 
		 * return count;
		 */
		Integer boid = Integer.valueOf(paramMap.get("boid").toString());
		DetachedCriteria criteria = DetachedCriteria.forClass(CommentTable.class);
		criteria = criteria.createAlias("bookTable", "b");
		criteria.add(Restrictions.eq("b.boid", boid));

		criteria = criteria.setProjection(Projections.countDistinct("coid"));
		List<?> list = this.hibernateTemplate.findByCriteria(criteria);
		Integer count = ((Long) list.get(0)).intValue();
		return count;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * ɾ������
	 * 
	 */
	@Override
	public boolean deleteCommentByCoID(Integer coid) {
		// TODO Auto-generated method stub

		String hql = "delete from CommentTable where coid=?";

		int bulkUpdate = this.hibernateTemplate.bulkUpdate(hql, coid);

		return true;
	}

	@Override
	public boolean saveComment(CommentTable commentTable) {
		// TODO Auto-generated method stub

		Timestamp t = new Timestamp(System.currentTimeMillis());

		commentTable.setUpdatetime(t);
		return saveObject(commentTable);

	}

	@Override
	public boolean updateComment(CommentTable comment) {
		// TODO Auto-generated method stub
		Session session = getSession();
		CommentTable com = (CommentTable) session.get(CommentTable.class, comment.getCoid());
		com.setCocomment(comment.getCocomment());
		com.setCoreply(comment.getCoreply());
		Timestamp t = new Timestamp(System.currentTimeMillis());
		com.setUpdatetime(t);
		session.update(com);
		return true;

	}

	@Override
	public boolean userupdateComment(CommentTable comment) {
		// TODO Auto-generated method stub

		Session session = this.getSession();
		CommentTable commentTable = (CommentTable) session.load(CommentTable.class, comment.getCoid());
		commentTable.setCocomment(comment.getCocomment());

		Timestamp t = new Timestamp(System.currentTimeMillis());
		commentTable.setUpdatetime(t);
		session.save(commentTable);

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * �����û���ȡ����
	 */
	@Override
	public CommentTable getCommentByUid(Integer uid) {
		// TODO Auto-generated method stub
		String hql = "from CommentTable where uid=?";
		List<CommentTable> ctList = (List<CommentTable>) this.hibernateTemplate.find(hql, uid);
		try {
			return ctList.get(0);
		} catch (Exception e) {
			return null;
			// TODO: handle exception
		}

	}

	@Override
	public CommentTable getCommentByCoId(Integer paramInteger) {
		// TODO Auto-generated method stub
		String hql = "from CommentTable where coid=?";
		List<CommentTable> ctList = (List<CommentTable>) this.hibernateTemplate.find(hql, paramInteger);

		try {
			return ctList.get(0);
		} catch (Exception e) {

			// TODO: handle exception
			return null;

		}
	}

	/*
	 * (non-Javadoc) �����û���id���鼮��ȡ��Ӧ ������
	 */
	@Override
	public CommentTable getCommentByUidAndBoid(Integer paramInteger1, Integer paramInteger2) {

		// TODO Auto-generated method stub
		String hql = "from CommentTable where uid=? and boid=?";
		List<CommentTable> ctList = (List<CommentTable>) this.hibernateTemplate.find(hql,
				new Object[] { paramInteger1, paramInteger2 });
		try {
			return ctList.get(0);
		} catch (Exception e) {

			// TODO: handle exception
			return null;
		}

	}

	@Override
	public List<CommentTable> getAllComment() {
		// TODO Auto-generated method stub

		String hql = "from CommentTable";

		return null;
	}

	@Override
	public CommentTable gainCommentByBoID(Integer paramInteger) {
		// TODO Auto-generated method stub
		String hql = "from CommentTable  where boid=?";
		List<CommentTable> ctList = (List<CommentTable>) this.hibernateTemplate.find(hql, paramInteger);
		try {
			return ctList.get(0);
		} catch (Exception e) {
			return null;
			// TODO: handle exception
		}

	}

}
