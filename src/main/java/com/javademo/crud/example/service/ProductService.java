package com.javademo.crud.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javademo.crud.example.entity.Product;
import com.javademo.crud.example.repository.ProductRepository;

//This is a service class
@Service
public class ProductService {

	
	//ProductService will connect with repository , so we need to create object of it and autowire it
	@Autowired
	private ProductRepository repository;
	
	
	
	/* GET METHODS TO GET DATA FROM DB */
	
	//this method will get single product from DB based on Id
	public Product getProductById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	//this method will get single product from DB based on product name
	// *** NOTE:this method can return list of products , if two products have same name, but we are not handling that here ***
		public Product getProductByName(String name) {
			return repository.findByName(name);
		}
	
	//this method will get all the products from DB
	public List<Product> getProducts() {
		return repository.findAll();
	}
	
	
	
	
	
	/* POST METHODS TO SAVE DATA IN DB */
	
	//this method will save single product to DB
	public Product saveProduct(Product product) {
		return repository.save(product);
	}
	
	//this method will save list of products in DB, 
	public List<Product> saveProducts(List<Product> products) {
		return repository.saveAll(products);
	}
	
	
	
	
	
	/* DELETE METHOD TO DELETE DATA FROM DB */
	
	//this method will delete product based on the Id
	public String deleteProductById(int id) {
		repository.deleteById(id);
		return "Product removed successfully !! " +id;
	}
	
	
	
	
	/* UPDATE(PUT) METHOD TO UPDATE DATA IN DB */
	
	//this method will update product data in DB based on Id
	public Product updateProduct(Product product) {
		//first we will get the product by Id, then modify it.(BECAUSE THERE IS NO UPDATE METHOD IN SPRING DATA JPA, SO WE HAVE TO USE SAVE METHOD ON EXISTING FETCHED PRODUCT)
		Product existingProduct = repository.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setPrice(product.getPrice());
		return repository.save(existingProduct);
		
	}
	
	
	
}
