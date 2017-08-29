package com.test;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sachin.bl.dao.impl.BaseDaoImpl;
import com.sachin.bl.dao.impl.BookDaoImpl;
import com.sachin.bl.dao.impl.CommentDaoImpl;
import com.sachin.bl.dao.impl.ShopCartContentDaoImpl;
import com.sachin.bl.dao.impl.ShopCartDaoImpl;
import com.sachin.bl.entities.BookTable;
import com.sachin.bl.entities.OrderContentTable;
import com.sachin.bl.entities.OrderTable;
import com.sachin.bl.entities.ShopCartContentTable;
import com.sachin.bl.entities.ShopCartTable;
import com.sachin.bl.entities.UserTable;

@Component
public class Hibernate {
	static ApplicationContext context;
	static BaseDaoImpl baseDaoImpl;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");

		Hibernate bean = context.getBean(Hibernate.class);
		bean.test1();

	}

	@Transactional
	public void test1() {

		/* CommentDaoImpl commentDao = context.getBean(CommentDaoImpl.class); */

		ShopCartContentDaoImpl shopCartContentDaoImpl = context.getBean(ShopCartContentDaoImpl.class);
		/*
		 * BookDaoImpl bookDaoImpl = context.getBean(BookDaoImpl.class);
		 * ShopCartDaoImpl shopCartDaoImpl =
		 * context.getBean(ShopCartDaoImpl.class);
		 */

		Session session = shopCartContentDaoImpl.getSessionFactory().openSession();
		Transaction beginTransaction = session.beginTransaction();

		BookTable bookTable = (BookTable) session.load(BookTable.class, 36);
		ShopCartTable shopCartTable = (ShopCartTable) session.load(ShopCartTable.class, 20);

		ShopCartContentTable contnet = new ShopCartContentTable();
		contnet.setBook(bookTable);
		contnet.setNumber(20);
		contnet.setShopcar(shopCartTable);
		session.save(contnet);
		session.flush();
		beginTransaction.commit();
		session.close();

		// System.out.println(contnet.getSccid());

	}

	public void test2() {

		CommentDaoImpl commentDao = context.getBean(CommentDaoImpl.class);

		ShopCartContentDaoImpl shopCartContentDaoImpl = context.getBean(ShopCartContentDaoImpl.class);
		BookDaoImpl bookDaoImpl = context.getBean(BookDaoImpl.class);
		ShopCartDaoImpl shopCartDaoImpl = context.getBean(ShopCartDaoImpl.class);

		Session session = shopCartContentDaoImpl.getSessionFactory().openSession();
		session.beginTransaction();

		Criteria criteria = session.createCriteria(ShopCartTable.class);
		// criteria.createAlias("userTable", "u");
		UserTable user = (UserTable) session.load(UserTable.class, 3);
		Criteria add = criteria.add(Restrictions.eq("userTable", user));

		List list = criteria.list();
		System.out.println(list.get(0));

	}

	@Transactional
	public void test3() {

		/* CommentDaoImpl commentDao = context.getBean(CommentDaoImpl.class); */

		ShopCartContentDaoImpl shopCartContentDaoImpl = context.getBean(ShopCartContentDaoImpl.class);
		/*
		 * BookDaoImpl bookDaoImpl = context.getBean(BookDaoImpl.class);
		 * ShopCartDaoImpl shopCartDaoImpl =
		 * context.getBean(ShopCartDaoImpl.class);
		 */

		Session session = shopCartContentDaoImpl.getSessionFactory().openSession();
		Transaction beginTransaction = session.beginTransaction();

		BookTable bookTable = (BookTable) session.load(BookTable.class, 36);
		OrderTable shopCartTable = (OrderTable) session.load(OrderTable.class, 2);

		OrderContentTable orderContent = new OrderContentTable();
		orderContent.setBookTable(bookTable);
		orderContent.setNumber(20);
		orderContent.setOrderTable(shopCartTable);
		session.save(orderContent);

		session.flush();
		beginTransaction.commit();

		session.close();

		// System.out.println(contnet.getSccid());

	}

	@Test
	public void testStringUitls() {

		System.out.println(StringUtils.isNoneEmpty(null));
		System.out.println(StringUtils.isNoneEmpty(""));
		System.out.println(StringUtils.isNoneEmpty("   "));

	}

}
