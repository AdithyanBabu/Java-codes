package com.product.ProductManagement;

import com.product.ProductManagement.model.Product;
import com.product.ProductManagement.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductManagementApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private ProductRepository productRepository;

	@Test
	public void saveTestProduct() {
		Product product = new Product();
		product.setName("Test Product 2");
		product.setPrice(200.0);
		productRepository.save(product);
	}


}
