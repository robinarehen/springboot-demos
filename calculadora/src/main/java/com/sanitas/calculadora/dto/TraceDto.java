package com.sanitas.calculadora.dto;

import com.sanitas.calculadora.util.Operadores;

import lombok.Data;

@Data
public class TraceDto {

	private String operador;
	private Integer[] parametros;

	public TraceDto(String operador, Integer... parametros) {
		this.operador = operador;
		this.parametros = parametros;
	}

	public String trace() {
		String mensaje = "No existe la operación";

		switch (Operadores.valueOf(this.operador)) {
		case suma:
			mensaje = String.format("La operación es SUMA: (%s + %s) = %s", this.parametros[0], this.parametros[1],
					this.parametros[2]);
			break;
		case resta:
			mensaje = String.format("La operación es RESTA: (%s - %s) = %s", this.parametros[0], this.parametros[1],
					this.parametros[2]);
			break;
		case multiplicacion:
			mensaje = String.format("La operación es MULTIPLICACION: (%s - %s) = %s", this.parametros[0],
					this.parametros[1], this.parametros[2]);
			break;
		}

		return mensaje;
	}
}
