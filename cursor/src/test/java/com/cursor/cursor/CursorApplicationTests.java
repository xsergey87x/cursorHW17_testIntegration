package com.cursor.cursor;

import com.cursor.cursor.service.CatFactService;
import com.cursor.cursor.service.CatFactServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;

import java.io.IOException;

@SpringBootTest
@TestPropertySource(locations = "/mockService.properties")
class CursorApplicationTests {

	@Autowired
    protected Environment environment;

	@Bean
	private final CatFactService catFactService = new CatFactServiceImpl();

	@Test
	void contextLoads() throws IOException, InterruptedException {
		System.out.println(environment.getProperty("catService.url"));
		System.out.println(catFactService.getCatFact(environment.getProperty("catService.url")).toString());
	}

}
