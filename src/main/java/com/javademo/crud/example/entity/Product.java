package com.javademo.crud.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Product is model class

//since we are using Lombok , no need to write getters ans setters
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity                          //specifies that below class is an entity, should be persisted in DB
@Table(name = "PRODUCT_TBL")     //creates table with given table name
public class Product {

	@Id                          //specifies primary key
	@GeneratedValue             //specifies auto generation for primary key
	private int id;
	private String name;
	private int quantity;
	private double price;
	
	
}
