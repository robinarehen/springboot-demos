package com.sanitas.calculadora.apicontroller;

import javax.websocket.server.PathParam;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.sanitas.calculadora.dto.CalculadoraDto;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

public interface CalculadoraApiController {

	@ApiOperation("metodo el cual nos permite sumar dos numeros.")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "retorna el resultado de la suma")
			//we can implement other codes like 404, 500, etc
	})
	ResponseEntity<Integer> sumar(@PathParam("numero1") Integer numero1, @PathParam("numero2") Integer numero2);
	
	@ApiOperation("metodo el cual nos permite restar dos numeros.")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "retorna el resultado de la resta")
	})
	ResponseEntity<Integer> restar(@PathVariable Integer numero1, @PathVariable Integer numero2);
	
	@ApiOperation("metodo el cual nos permite realizar operaciones como suma, resta y multiplicación.")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "retorna el resultado de la resta")
	})
	ResponseEntity<Integer> calculadora(@RequestBody CalculadoraDto calculadoraDto);
}
