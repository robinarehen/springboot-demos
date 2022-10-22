package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDataVo {

	private String name;
	private double price;
	private String company;
}
