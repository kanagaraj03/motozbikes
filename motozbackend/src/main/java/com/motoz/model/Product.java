package com.motoz.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	@Column
	String name;
	@Column
	String description;
@Column
int quantity;
@Column
int price;
@Column
String Suppliername;
@Column
String categoryname;
@Transient
MultipartFile ProdImage;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getSuppliername() {
	return Suppliername;
}
public void setSuppliername(String suppliername) {
	Suppliername = suppliername;
}
public String getCategoryname() {
	return categoryname;
}
public void setCategoryname(String categoryname) {
	this.categoryname = categoryname;
}
public MultipartFile getProdImage()  {
	return ProdImage;
}
public void setProdImage(MultipartFile ProdImage) {
	this.ProdImage = ProdImage;
}

}
