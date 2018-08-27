package demo.controller;

import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class TestForm {
	@Size(max = 3)
	private String test;
}
