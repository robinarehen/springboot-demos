package com.example.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.ProductController;
import com.example.demo.model.ProductVo;

@RestController
@RequestMapping("/products")
public class ProductControllerImpl implements ProductController {

	@Override
	@PostMapping
	public ResponseEntity<ProductVo> addProduct(@RequestBody ProductVo productVo) {
		return ResponseEntity.status(HttpStatus.CREATED).body(productVo);
	}

}
