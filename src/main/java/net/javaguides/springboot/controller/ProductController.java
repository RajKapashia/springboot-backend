package net.javaguides.springboot.controller;

import java.io.IOException;
import java.util.*;

import net.javaguides.springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Product;
import net.javaguides.springboot.repository.ProductRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/earthboost/")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	private ProductService productService =new ProductService();
	// get all products
	@GetMapping("/products")
	public List<Product> getAllproducts(){
		return productRepository.findAll();
	}

	@GetMapping("/jsondata")
	public ArrayList<String> getAllJsonproducts() throws IOException {
		return productService.getDataJson();
	}

	@GetMapping("/loadjson")
	public void getJson() throws IOException {
		productService.loadDataFromJson();
	}
	
	// create product rest api
	@PostMapping("/products")
	public Product createproduct(@RequestBody Product product)
	{ if(productService.checkExistingEmailId(product.getEmailId(),productRepository))
		throw new ResourceNotFoundException("Already Exist");
		return productRepository.save(product);
	}
	
	// get product by id rest api
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getproductById(@PathVariable Long id) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("product not exist with id :" + id));
		return ResponseEntity.ok(product);
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateproduct(@PathVariable Long id, @RequestBody Product productDetails){
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("product not exist with id :" + productDetails.getProduct_id()));
		product.setProductName(productDetails.getProductName());
		product.setType(productDetails.getType());
		product.setEmailId(productDetails.getEmailId());
		Product updatedproduct = productRepository.save(product);
		return ResponseEntity.ok(updatedproduct);
	}
   //Login
	@PutMapping("/products/login")
	public ResponseEntity<Product> logInproduct(@RequestBody Product productDetails){
		Optional<Product> product = productRepository.findByEmailId(productDetails.getEmailId());
                if(product.isEmpty())
					throw new ResourceNotFoundException("product not exist with id :" + productDetails.getEmailId());
		return ResponseEntity.ok(product.get());
	}
	
	// delete product rest api
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteproduct(@PathVariable Long id){
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("product not exist with id :" + id));
		
		productRepository.delete(product);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
