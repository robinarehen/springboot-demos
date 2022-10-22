package com.sanitas.calculadora.util;

public enum Operadores {

	suma("suma"), resta("resta"), multiplicacion("multiplicacion");

	private String operacion;

	private Operadores(String value) {
		// TODO Auto-generated constructor stub
		this.operacion = value;
	}

	public String getOperacion() {
		return operacion;
	}

}
