package com.rah.demo.microproduct.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rah.demo.microproduct.controller.swagger.ProductController;
import com.rah.demo.microproduct.model.ProductVo;

@RestController
@RequestMapping("/products")
//@Tag(name = "Product")
public class ProductControllerImpl implements ProductController {

	@PostMapping
//	@Operation(summary = "Post add new Product")
//	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Product was create"),
//			@ApiResponse(responseCode = "400", description = "Bad request"),
//			@ApiResponse(responseCode = "404", description = "Product not found") })
	public String addProduct(@RequestBody ProductVo productVo) {
		return String.format("El valor recibido fue: %s", productVo.getId());
	}

	@GetMapping("/{id}")
//	@Operation(summary = "Get a Product by its id")
//	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Found the Product"),
//			@ApiResponse(responseCode = "400", description = "Invalid id supplied"),
//			@ApiResponse(responseCode = "404", description = "Product not found") })
	public String getProduct(@PathVariable String id) {
		return String.format("El valor recibido fue: %s", id);
	}
}
