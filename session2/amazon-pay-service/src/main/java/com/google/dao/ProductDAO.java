package com.google.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAO {

	@Autowired
	private EntityManager entityManager = null;

	public void saveOrUpdate(ProductBean productBean) throws DataSourceException {
		try {
			Session session = entityManager.unwrap(Session.class);
			session.saveOrUpdate(productBean);
		} catch (HibernateException e) {
			throw new DataSourceException(e.getMessage());

		}

	}

	public List<ProductBean> getAll() throws DataSourceException {
		List<ProductBean> prodList = null;

		try {
			Session session = entityManager.unwrap(Session.class);
			prodList = session.createQuery("select p From ProductBean as p", ProductBean.class).getResultList();

		} catch (HibernateException e) {
			throw new DataSourceException(e.getMessage());
		}
		return prodList;
	}

	public ProductBean getById(Integer pId) throws DataSourceException {
		ProductBean prod = null;
		try {
			Session session = entityManager.unwrap(Session.class);
			TypedQuery<ProductBean> query = session
					.createQuery("Select p from ProductBean as p where p.productId = :id", ProductBean.class);
			query.setParameter("id", pId);
			prod = query.getSingleResult();

		} catch (NoResultException exp) {
			return null;
		} catch (HibernateException e) {
			throw new DataSourceException(e.getMessage());
		}
		return prod;
	}

	public void delete(Integer pId) throws DataAccessException, DataSourceException {
		ProductBean prod = null;
		try {
			Session session = entityManager.unwrap(Session.class);
			prod = session.get(ProductBean.class, pId);
			session.delete(prod);

		} catch (HibernateException e) {
			throw new DataSourceException(e.getMessage());
		}
	}

}
