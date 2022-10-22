package com.rah.demo.microproduct.controller.swagger;

import com.rah.demo.microproduct.model.ProductVo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Inventario")
public interface InventarioController {

	@Operation(summary = "Post add new Inventario")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Inventario was create"),
			@ApiResponse(responseCode = "400", description = "Bad request"),
			@ApiResponse(responseCode = "404", description = "Inventario not found") })
	public String addProduct(ProductVo productVo);
}
