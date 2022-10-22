package com.sanitas.calculadora.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalculadoraDto {
	
	private String operador;
	private Integer num1;
	private Integer num2;

}
