package com.eshop.ms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshop.ms.model.Product;
import com.eshop.ms.model.User;
import com.eshop.ms.repository.UserBasketRepository;

@Service
public class UserBasketService {
	
	@Autowired
	private UserBasketRepository repository;

	public UserBasketRepository getRepository() {
		return repository;
	}

	public void setRepository(UserBasketRepository repository) {
		this.repository = repository;
	}
	
	public List<Product> getAll(){
		return repository.getAllProducts();
	}
	public void addProduct(Product product){
		if("".equals(product.getProductName()) || "".equals(product.getPrice())){
			throw new RuntimeException("product exception");
		}
		repository.addProduct(product);
	}
	
	public void deleteProduct(String productname){
		
		if(repository.getProductByName(productname) == null){
			throw new RuntimeException("Product not found");
		}
		
		repository.deleteProduct(productname);
	}
	
}
