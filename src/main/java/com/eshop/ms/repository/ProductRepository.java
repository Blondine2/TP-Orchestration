package com.eshop.ms.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.eshop.ms.model.Product;


@Component
public class ProductRepository {

	private Map<String, Product> productInMemory = new HashMap<>();
	
	 
	public List<Product> getAll(){
		return new ArrayList<Product>(productInMemory.values());
	
	}
	
	public void addProduct(Product product){
		System.out.println("adding the product named : " + product.getProductName());
		productInMemory.put(product.getProductName(), product);
	}
	public Product getProductByName(String productname){
		System.out.println("getting the product named : " + productname);
		return productInMemory.get(productname);
	}
	
	public void updateProduct(Product product){
		System.out.println("updating the product named : " + product.getProductName());
		productInMemory.put(product.getProductName(), product);
	}
	public void deleteProductByName(String productname){
		System.out.println("deleting the product named : " + productname);
		productInMemory.remove(productname);
	}
}
