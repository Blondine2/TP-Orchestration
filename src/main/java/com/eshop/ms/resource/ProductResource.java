package com.eshop.ms.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.eshop.ms.model.Product;

import com.eshop.ms.service.ProductService;

@RestController
@RequestMapping(value = "products", produces = {"application/json"})
public class ProductResource {
	
	@Autowired
	private ProductService service;
	
	@GetMapping
	public List<Product> getAll(){
		return service.getAll();
	}
	
	@GetMapping("{productname}")
	public Product getOne(@PathVariable("productname") String productname){
		
		return service.getProduct(productname);
	}
	
	@PostMapping()
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	public String addProduct(@RequestBody Product product){
		
		if(!"".equals(product.getProductName()) && !StringUtils.isEmpty(product.getPrice())) 
		
		service.addProduct(product);
		return "Product added";
		
	}
	
	@PutMapping("{productname}")
	public void updateProduct(@PathVariable("productname") String productname, @RequestBody Product product){
		
		service.updateProduct(productname, product);
	}
	
	@DeleteMapping("{productname}")
	public void deleteProduct(@PathVariable("productname") String productname){
		
		service.deleteProduct(productname);
	}
	

}
