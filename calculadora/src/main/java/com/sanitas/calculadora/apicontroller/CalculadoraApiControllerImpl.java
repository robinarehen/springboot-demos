package com.sanitas.calculadora.apicontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanitas.calculadora.dto.CalculadoraDto;
import com.sanitas.calculadora.dto.TraceDto;
import com.sanitas.calculadora.service.CalculadoraServiceImpl;

import io.corp.calculator.TracerImpl;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraApiControllerImpl implements CalculadoraApiController {

	private CalculadoraServiceImpl calculadoraService;
	private TraceDto traceDto;
	private TracerImpl tracerImpl;

	public CalculadoraApiControllerImpl(CalculadoraServiceImpl calculadoraService) {
		super();
		this.calculadoraService = calculadoraService;
		this.tracerImpl = new TracerImpl();
	}

	@GetMapping
	public String getStatus() {
		return "Online";
	}

	@GetMapping("/sumar")
	public ResponseEntity<Integer> sumar(Integer numero1, Integer numero2) {
		int resultado = this.calculadoraService.sumar(numero1, numero2);
		this.traceDto = new TraceDto("suma", numero1, numero2, resultado);
		this.tracerImpl.trace(this.traceDto.trace());
		return ResponseEntity.ok(resultado);
	}

	@GetMapping("/restar/{numero1}/{numero2}")
	public ResponseEntity<Integer> restar(Integer numero1, Integer numero2) {
		int resultado = this.calculadoraService.restar(numero1, numero2);
		this.traceDto = new TraceDto("resta", numero1, numero2, resultado);
		this.tracerImpl.trace(this.traceDto.trace());
		return ResponseEntity.ok(resultado);
	}

	@PostMapping("/operacion")
	public ResponseEntity<Integer> calculadora(CalculadoraDto calculadoraDto) {
		int resultado = this.calculadoraService.realizarOperacion(calculadoraDto);
		this.traceDto = new TraceDto(calculadoraDto.getOperador(), calculadoraDto.getNum1(), calculadoraDto.getNum2(),
				resultado);
		this.tracerImpl.trace(this.traceDto.trace());
		return ResponseEntity.ok(resultado);
	}
}
