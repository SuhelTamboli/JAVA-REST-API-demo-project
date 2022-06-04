package com.javademo.crud.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javademo.crud.example.entity.Product;
import com.javademo.crud.example.service.ProductService;


//this is a REST controller class (contains REST endpoints)

@RestController
public class ProductController {

	//controller class will talk to service class, so we need to autowire it
	@Autowired
	private ProductService service;
	
	
	
	/* GET API*/
	
	@GetMapping("/products")
	public List<Product> findAllProducts() {
		return service.getProducts();
	}
	
	@GetMapping("/productById/{id}")
	public Product findProductById(@PathVariable int id) {
		return service.getProductById(id);
	}
	
	@GetMapping("/productByName/{name}")
	public Product findProductByName(@PathVariable String name) {
		return service.getProductByName(name);
	}
	
	
	
	
    /* POST API*/
	
	@PostMapping("/addProduct")                         //@RequestBody --> so that input JSON can be parsed to Product object
	public Product addProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}
	
	@PostMapping("/addProducts") 
	public List<Product> addProducts(@RequestBody List<Product> products) {
		return service.saveProducts(products);
	}
	
	
	
	/* PUT API*/
	
	@PutMapping("/update")                         //@RequestBody --> so that input JSON can be parsed to Product object
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}
	
	
	
	/* DELETE API*/
	
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		return service.deleteProductById(id);
	}
	
	
	
	
}
