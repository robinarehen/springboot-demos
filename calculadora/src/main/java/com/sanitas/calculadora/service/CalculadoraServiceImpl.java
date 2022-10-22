package com.sanitas.calculadora.service;

import org.springframework.stereotype.Service;

import com.sanitas.calculadora.dto.CalculadoraDto;
import com.sanitas.calculadora.util.Operadores;

@Service
public class CalculadoraServiceImpl {

	private CalculadoraService calculadoraService;

	public int sumar(int numero1, int numero2) {
		// TODO Auto-generated method stub
		calculadoraService = (n1, n2) -> numero1 + numero2;
		return calculadoraService.operacion(numero1, numero2);
	}

	public int restar(int numero1, int numero2) {
		// TODO Auto-generated method stub
		calculadoraService = (n1, n2) -> numero1 - numero2;
		return calculadoraService.operacion(numero1, numero2);
	}

	public int multiplicacion(int numero1, int numero2) {
		// TODO Auto-generated method stub
		calculadoraService = (n1, n2) -> numero1 * numero2;
		return calculadoraService.operacion(numero1, numero2);
	}

	public Integer realizarOperacion(CalculadoraDto calculadoraDto) {

		switch (Operadores.valueOf(calculadoraDto.getOperador())) {
		case suma:
			this.calculadoraService = (n1, n2) -> calculadoraDto.getNum1() + calculadoraDto.getNum2();
			break;
		case resta:
			this.calculadoraService = (n1, n2) -> calculadoraDto.getNum1() - calculadoraDto.getNum2();
			break;
		case multiplicacion:
			this.calculadoraService = (n1, n2) -> calculadoraDto.getNum1() * calculadoraDto.getNum2();
			break;
		}

		return this.calculadoraService.operacion(calculadoraDto.getNum1(), calculadoraDto.getNum2());
	}
}
