package com.demo.client.webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.client.webservice.service.CalculadoraService;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

	@Autowired
	private CalculadoraService service;
	
	@GetMapping("/sumar/{numberA}/{numberB}")
	public ResponseEntity<Integer> sumar(@PathVariable int numberA, @PathVariable int numberB) {	
		return ResponseEntity.ok(this.service.sumar(numberA, numberB)); 
	}
	
	@GetMapping("/restar/{numberA}/{numberB}")
	public ResponseEntity<Integer> restar(@PathVariable int numberA, @PathVariable int numberB) {	
		return ResponseEntity.ok(this.service.restar(numberA, numberB)); 
	}
}
