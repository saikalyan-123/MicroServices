package com.google.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.dao.DataSourceException;
import com.google.dao.User;
import com.google.dao.UserDAO;

@Service
public class UserService {
	
	@Autowired
	public UserDAO userDAO = null;
	
	@Transactional(value=TxType.REQUIRED,dontRollbackOn=ServicesException.class)
	public void save(User user)throws ServicesException
	{
		try
		{
			userDAO.save(user);
		}catch (DataSourceException e) {
		 throw new ServicesException(e.getMessage());	
			
				}
	}
	
	@Transactional(value=TxType.REQUIRED,dontRollbackOn=ServicesException.class)
	public void update(User user)throws ServicesException
	{
		try
		{
			userDAO.update(user);
		}catch (DataSourceException e) {
			 throw new ServicesException(e.getMessage());	
		}
		
	}
	
	public List<User> getAll()throws ServicesException
	{
		List<User>userList = null;
		
		try
		{
			userList = userDAO.getAll();
		}catch (DataSourceException e) {
			 throw new ServicesException(e.getMessage());	
		}
		return userList;
		
	}
	
	public User getById(String userId)throws ServicesException
	{
		
		User user = null;
		try
		{
			user = userDAO.get(userId);
		}catch (DataSourceException e) {
			 throw new ServicesException(e.getMessage());	
		}
		return user;
		
	}
	
	
	@Transactional(value=TxType.REQUIRED,dontRollbackOn=ServicesException.class)
	public void DeleteById(String userId)throws ServicesException
	{
		
		
		try
		{
			 userDAO.delete(userId);
		}catch (DataSourceException e) {
			 throw new ServicesException(e.getMessage());	
		}
		
		
	}
	
	

}
