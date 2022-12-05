package com.cursor.cursor;

import com.cursor.cursor.service.CatFactService;
import com.cursor.cursor.service.CatFactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class CursorApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(CursorApplication.class, args);

	}

}
