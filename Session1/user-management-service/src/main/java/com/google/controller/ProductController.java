package com.google.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.dao.ProductBean;
import com.google.service.ProductService;
import com.google.service.ServicesException;

@Controller

public class ProductController {

	@Autowired
	private ProductService productService = null;

	@GetMapping(path= "/product/products")
	public ResponseEntity<List<ProductBean>> getAll() throws ServicesException {
		List<ProductBean> prodList = null;
		try {
			prodList = productService.getAll();
		} catch (ServicesException e) {
			return new ResponseEntity<List<ProductBean>>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return new ResponseEntity<List<ProductBean>>(prodList, HttpStatus.OK);

	}

	@GetMapping(path = "/product/products/{pId}")
	public ResponseEntity<ProductBean> getById(@PathVariable("pId") Integer pId) 
	{
		ProductBean prod = null;
		try {
			prod = productService.getById(pId);

		} catch (ServicesException e) {
			return new ResponseEntity<ProductBean>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<ProductBean>(prod , HttpStatus.OK);
	}

	@PostMapping(path="/product/products")
	public ResponseEntity<ProductBean> save(@RequestBody ProductBean productBean) throws ServicesException

	{
		try {

			productService.saveOrUpdate(productBean);

		} catch (ServicesException e) {

			return new ResponseEntity<ProductBean>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<ProductBean>(productBean,HttpStatus.OK);
	}

	@PutMapping(path="/product/products")
	public ResponseEntity<ProductBean> update(@RequestBody ProductBean productBean) throws ServicesException

	{
		try {

			productService.saveOrUpdate(productBean);

		} catch (ServicesException e) {

			return new ResponseEntity<ProductBean>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<ProductBean>(productBean,HttpStatus.OK);

	}

	@DeleteMapping(path = "/product/products/{pId}")
	public ResponseEntity<ProductBean> delete(@PathVariable("pId") Integer pId) throws ServicesException

	{
		try {
			productService.delete(pId);
		} catch (ServicesException e) {
			return new ResponseEntity<ProductBean>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return new ResponseEntity<ProductBean>(HttpStatus.OK);
	}

}
