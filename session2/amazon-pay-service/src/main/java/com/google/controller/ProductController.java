package com.google.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
@RequestMapping("products")
public class ProductController {

	
	Logger log = LoggerFactory.getLogger(ProductController.class);	
	
	
	@Autowired
	private ProductService productService = null;
	
	
	@Value("${amazonpayservice-env}")
	private String environment = null;

	@GetMapping
	public ResponseEntity<List<ProductBean>> getAll() throws ServicesException {
		List<ProductBean> prodList = null;
		try {
			prodList = productService.getAll();
		} catch (ServicesException e) {
			return new ResponseEntity<List<ProductBean>>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return new ResponseEntity<List<ProductBean>>(prodList, HttpStatus.OK);

	}

	@GetMapping(path = "/{pId}")
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

	@PostMapping
	public ResponseEntity<ProductBean> save(@RequestBody ProductBean productBean) throws ServicesException

	{
		try {

			productService.saveOrUpdate(productBean);

		} catch (ServicesException e) {

			return new ResponseEntity<ProductBean>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		log.info(" *********  environment ********"+environment);
		return new ResponseEntity<ProductBean>(productBean,HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<ProductBean> update(@RequestBody ProductBean productBean) throws ServicesException

	{
		try {

			productService.saveOrUpdate(productBean);

		} catch (ServicesException e) {

			return new ResponseEntity<ProductBean>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<ProductBean>(productBean,HttpStatus.OK);

	}

	@DeleteMapping(path = "/{pId}")
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