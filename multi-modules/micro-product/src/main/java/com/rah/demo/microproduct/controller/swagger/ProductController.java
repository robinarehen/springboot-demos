package com.rah.demo.microproduct.controller.swagger;

import com.rah.demo.microproduct.model.ProductVo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Product")
public interface ProductController {

	@Operation(summary = "Post add new Product")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Product was create"),
			@ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
			@ApiResponse(responseCode = "404", description = "Product not found", content = @Content) })
	public String addProduct(ProductVo productVo);

	@Operation(summary = "Get a Product by its id")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Found the Product", content = @Content),
			@ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
			@ApiResponse(responseCode = "404", description = "Product not found", content = @Content) })
	public String getProduct(String id);
}
