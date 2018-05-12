package com.darrenforsythe.jpa.unidirectional;

import java.util.List;

import lombok.Data;

@Data
public class Parent{
	
	private String content;
	
	private String title;
	
	private List<Child> children;
}
