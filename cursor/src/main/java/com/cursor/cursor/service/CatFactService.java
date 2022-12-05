package com.cursor.cursor.service;

import com.cursor.cursor.responseModel.CatFactResponseModel;

import java.io.IOException;

public interface CatFactService {

    CatFactResponseModel getCatFact() throws IOException, InterruptedException;
}
