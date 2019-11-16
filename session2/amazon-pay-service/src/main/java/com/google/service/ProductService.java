package com.google.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.service.ServicesException;
import com.google.dao.DataSourceException;
import com.google.dao.ProductBean;
import com.google.dao.ProductDAO;

@Service
public class ProductService {

	
	@Autowired
	private ProductDAO productDAO = null;
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = ServicesException.class)
	public void saveOrUpdate(ProductBean productBean)throws ServicesException
	{
		try
		{
			productDAO.saveOrUpdate(productBean);
			
		}catch (DataSourceException e) {
   throw new ServicesException(e.getMessage());			
			
		}
		
	}
	
	public List<ProductBean> getAll()throws ServicesException
	{
		List<ProductBean> prodList = null;
		try
		{
			prodList=productDAO.getAll();
		}catch (DataSourceException e) {
 throw new ServicesException(e.getMessage());			
		}
		return prodList;
	}
	
	public ProductBean getById(Integer pId)throws ServicesException
	{
		ProductBean prod = null;
		try
		{
			prod=productDAO.getById(pId);
		}catch (DataSourceException e) {
   throw new ServicesException(e.getMessage());			
		}
		return prod;
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = ServicesException.class)
	public void delete(Integer pId)throws ServicesException
	{
		try
		{
			productDAO.delete(pId);
			
		}catch (DataSourceException e) {
   throw new ServicesException(e.getMessage());			
		}
	}
}
