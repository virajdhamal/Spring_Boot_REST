package com.restexample.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootRestApplicationTests {

	@Test
	void contextLoads() {
		try {
			throw new  AssertionError();
		} catch (Error e) {
			System.out.println("Error Handled");
		}
	}

}
