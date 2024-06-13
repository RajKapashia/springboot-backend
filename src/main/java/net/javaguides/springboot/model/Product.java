package net.javaguides.springboot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long product_id;

	@Column(name = "product_name")
	@Size(min=2,max=15,message = "Name minimum length is 2 and max length 15 your length")
	private String productName;

	@Column(name = "type")
	private String type;
	
	@Column(name = "email_id")
	@Email(message="Not valid email")
	private String emailId;

	@Column(name= "house_no")
	private  String house_no;

	@ManyToOne(cascade=CascadeType.ALL)
	private Product product;
	
	public Product() {
		
	}

	public long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getHouse_no() {
		return house_no;
	}

	public void setHouse_no(String house_no) {
		this.house_no = house_no;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
