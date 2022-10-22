package com.example.demo.api;

import org.springframework.http.ResponseEntity;

import com.example.demo.model.ProductVo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "products")
public interface ProductController {

	@Operation(summary = "Post create products", tags = "products")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Success|OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductVo.class))),
			@ApiResponse(responseCode = "401", description = "not authorized!", content = @Content),
			@ApiResponse(responseCode = "403", description = "forbidden!!!", content = @Content),
			@ApiResponse(responseCode = "404", description = "not found!!!", content = @Content) })
	public ResponseEntity<ProductVo> addProduct(ProductVo productVo);

}
