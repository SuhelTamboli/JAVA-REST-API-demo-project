package com.javademo.crud.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javademo.crud.example.entity.Product;

//repository layer for Product Model

                                                      //JpaRepository<Model Name, Data type of primary key>
public interface ProductRepository extends JpaRepository<Product, Integer>{

	Product findByName(String name);
	
	

}
