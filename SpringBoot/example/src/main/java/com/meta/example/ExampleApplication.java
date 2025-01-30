package com.meta.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {

		var ctx = SpringApplication.run(ExampleApplication.class, args);
		MyFirstClass hi = ctx.getBean(MyFirstClass.class);
		System.out.println(hi.hello());
	}

}
