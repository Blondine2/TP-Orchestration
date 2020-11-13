package com.eshop.ms.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.eshop.ms.model.Product;
import com.eshop.ms.model.UserBasket;

@Component
public class UserBasketRepository {
	
	private Map<String, Product> basketInMemory = new HashMap<>();
	

	
	public List<Product> getAllProducts(){
		
		return new ArrayList<Product>(basketInMemory.values());
		
	}
	
	public void addProduct(Product product){
		System.out.println("adding the product named : " + product.getProductName());
		basketInMemory.put(product.getProductName(), product);
	}
	
	public Product getProductByName(String productname){
		System.out.println("getting the product named : " + productname);
		return basketInMemory.get(productname);
	}
	
	public void deleteProduct(String productname){
		
		basketInMemory.remove(productname);
	}
	
	
}
