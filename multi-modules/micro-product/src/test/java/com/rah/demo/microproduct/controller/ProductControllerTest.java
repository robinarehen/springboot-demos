package com.rah.demo.microproduct.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.rah.demo.microproduct.controller.swagger.ProductController;
import com.rah.demo.microproduct.model.ProductVo;

public class ProductControllerTest {

	private ProductController controller;
	
	@BeforeEach
	void init() {
		this.controller = new ProductControllerImpl();
	}
	
	@Test
	void addProductTest() {
		ProductVo productVo = new ProductVo();
		productVo.setId(10);
		String response = this.controller.addProduct(productVo);
		assertNotNull(response);
		String expected = String.format("El valor recibido fue: %s", productVo.getId());
		assertEquals(expected, response);
	}
}
