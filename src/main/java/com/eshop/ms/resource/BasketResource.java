package com.eshop.ms.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.eshop.ms.model.Product;
import com.eshop.ms.service.UserBasketService;

@RestController
@RequestMapping(value = "basket", produces = {"application/json"})
public class BasketResource {
	@Autowired
	private UserBasketService service;

	
	@GetMapping
	public List<Product> getAll(){
		return service.getAll();
	}
	@PostMapping()
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	public String addProduct(@RequestBody Product product){
		
		if(!"".equals(product.getProductName()) && !StringUtils.isEmpty(product.getPrice())) 
		
		service.addProduct(product);
		return "Product added";
		
	}
	
	@DeleteMapping("{productname}")
	public void deleteProduct(@PathVariable("productname") String productname){
		
		service.deleteProduct(productname);
	}

}
