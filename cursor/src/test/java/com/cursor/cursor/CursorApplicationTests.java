package com.cursor.cursor;

import com.cursor.cursor.responseModel.CatFactResponseModel;
import com.cursor.cursor.service.CatFactService;
import com.cursor.cursor.service.CatFactServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.springframework.test.annotation.DirtiesContext.HierarchyMode.CURRENT_LEVEL;

@SpringBootTest
@TestPropertySource(locations = "/catService.properties")
class CursorApplicationTests {

    @Autowired
    protected Environment environment;

    @Test
    void catFactLoadAndPrint() throws IOException, InterruptedException {
        var httpClient = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(URI.create(environment.getProperty("catService.url"))).build();
        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        Assertions.assertFalse(response.body().isEmpty());

        System.out.println(response.body());
    }

    @Test
    @DirtiesContext(hierarchyMode = CURRENT_LEVEL)
    void catFactPrint() throws IOException, InterruptedException {
        CatFactService catFactService = new CatFactServiceImpl();
        Assertions.assertTrue(catFactService.getCatFact(environment.getProperty("catService.url")).getLength() > 0);

        System.out.println(catFactService.getCatFact(environment.getProperty("catService.url")).getFact());
    }

}
