package com.cursor.cursor.service;

import com.cursor.cursor.responseModel.CatFactResponseModel;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class catFactServiceImpl implements catFactService{
    @Override
    public CatFactResponseModel getCatFact() throws IOException, InterruptedException {

        var httpClient = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(URI.create("https://catfact.ninja/fact")).build();
        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.body(), CatFactResponseModel.class);
    }
}
