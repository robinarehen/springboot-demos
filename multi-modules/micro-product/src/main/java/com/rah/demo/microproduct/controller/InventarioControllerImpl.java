package com.rah.demo.microproduct.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rah.demo.microproduct.controller.swagger.InventarioController;
import com.rah.demo.microproduct.model.ProductVo;

@RestController
@RequestMapping("/inventario")
public class InventarioControllerImpl implements InventarioController {

	@PostMapping
	public String addProduct(@RequestBody ProductVo productVo) {
		return "";
	}
}
