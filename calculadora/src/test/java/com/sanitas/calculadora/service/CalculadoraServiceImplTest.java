package com.sanitas.calculadora.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculadoraServiceImplTest {

	@Autowired
	private CalculadoraServiceImpl calculadoraService;
	private int numero1;
	private int numero2;

	@BeforeEach
	public void init() {
		this.numero1 = 3;
		this.numero2 = 2;
	}

	@Test
	public void sumar() {

		int resultado = this.calculadoraService.sumar(this.numero1, this.numero2);

		int expected = this.numero1 + this.numero2;

		assertThat(expected).isEqualTo(resultado);
	}

	@Test
	public void restar() {

		int resultado = this.calculadoraService.restar(this.numero1, this.numero2);

		int expected = this.numero1 - this.numero2;

		assertThat(expected).isEqualTo(resultado);
	}
}
