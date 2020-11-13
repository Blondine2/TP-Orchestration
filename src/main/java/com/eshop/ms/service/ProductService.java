package com.eshop.ms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshop.ms.model.Product;
import com.eshop.ms.repository.ProductRepository;


@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public ProductRepository getRepository() {
		return repository;
	}

	public void setRepository(ProductRepository repository) {
		this.repository = repository;
	}

	public void addProduct(Product product){
		if("".equals(product.getProductName()) || "".equals(product.getPrice())){
			throw new RuntimeException("product exception");
		}
		repository.addProduct(product);
	}
	
	public Product getProduct(String productname){
		
		Product product = repository.getProductByName(productname);
		
		if(product == null){
			throw new RuntimeException("Product not found");
		}
		
		return product;
	}
	
	public List<Product> getAll(){
		return repository.getAll();
	}
	public void updateProduct(String productname, Product product){
		
		if(repository.getProductByName(productname) == null){
			throw new RuntimeException("Product not found");
		}
		
		repository.updateProduct(product);
	}
	
	public void deleteProduct(String productname){
		
		if(repository.getProductByName(productname) == null){
			throw new RuntimeException("Product not found");
		}
		
		repository.deleteProductByName(productname);
	}
}
