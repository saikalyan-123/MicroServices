package com.google.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserAccountDAO {

	@Autowired
	private EntityManager entityManager = null;

	public void save(UserAccount userAccount) throws DataSourceException {
		try {
			Session session = entityManager.unwrap(Session.class);
			session.save(userAccount);

		} catch (HibernateException e) {
			throw new DataSourceException(e.getMessage());

		}

	}

	public void update(UserAccount userAccount) throws DataSourceException {
		try {
			Session session = entityManager.unwrap(Session.class);
			session.update(userAccount);

		} catch (HibernateException e) {
			throw new DataSourceException(e.getMessage());

		}

	}

	public UserAccount getById(String userId) throws DataSourceException {
		UserAccount userAccount = null;

		try {
			Session session = entityManager.unwrap(Session.class);
			userAccount = session.get(UserAccount.class, userId);

		} catch (HibernateException e) {

		}

		return userAccount;
	}
	public UserAccount DeleteById(String userId) throws DataSourceException {
		UserAccount userAccount = null;

		try {
			Session session = entityManager.unwrap(Session.class);
			userAccount = session.get(UserAccount.class, userId);
			if(userAccount !=null)
				session.delete(userAccount);

		} catch (HibernateException e) {
		}

		return userAccount;
	}
	
	
	public List<UserAccount> getAll()throws DataSourceException
	{
		List<UserAccount> userList  = null;
		
		try
		{
			Session session = entityManager.unwrap(Session.class);
			TypedQuery<UserAccount> query = session.createQuery("select ua From UserAccount as ua", UserAccount.class);
			query.getResultList();
		}catch (HibernateException e) {
			
			
			
		}
		return userList;
	}

}
