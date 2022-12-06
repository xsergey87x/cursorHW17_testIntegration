package com.cursor.cursor;

import com.cursor.cursor.responseModel.CatFactResponseModel;
import com.cursor.cursor.service.CatFactService;
import com.cursor.cursor.service.CatFactServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.apache.http.entity.ContentType;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static org.springframework.test.annotation.DirtiesContext.HierarchyMode.CURRENT_LEVEL;

@SpringBootTest
@TestPropertySource(locations = "/catService.properties")
class CursorApplicationTests {

    @Autowired
    protected Environment environment;

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(wireMockConfig().port(8080));


    @Test
    void catFactLoadAndPrint() throws IOException, InterruptedException {

//        wireMockServer = new WireMockServer(8080);
//        wireMockServer.start();
//
//        wireMockServer.stubFor(WireMock.get(WireMock.urlEqualTo("getCatFact"))
//                .willReturn(aResponse()
//                        .withStatus(HttpStatus.OK.ordinal())
//                        .withHeader("content-type", ContentType.APPLICATION_JSON.toString())
//                        .withBody("[{\"fact\":\"A female cat is called a queen or a molly.\",\"length\":42}]")));

        var httpClient = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(URI.create(environment.getProperty("catService.url"))).build();
        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        Assertions.assertFalse(response.body().isEmpty());

        System.out.println(response.body());
    }

//    @Test
//    @DirtiesContext(hierarchyMode = CURRENT_LEVEL)
//    void catFactPrint() throws IOException, InterruptedException {
//
//
//
//        CatFactService catFactService = new CatFactServiceImpl();
//        Assertions.assertTrue(catFactService.getCatFact(environment.getProperty("catService.url")).getLength() > 0);
//
//        System.out.println(catFactService.getCatFact(environment.getProperty("catService.url")).getFact());
//        wireMockServer.stop();
//    }

    private void configureStubs() {
        configureFor("localhost", 8080);
        stubFor(get(urlEqualTo("/getCatFact"))
                .willReturn(aResponse().withBody("[{\"fact\":\"A female cat is called a queen or a molly.\",\"length\":42}]")));

    }
}
