package com.cursor.cursor.rest;

import com.cursor.cursor.responseModel.CatFactResponseModel;
import com.cursor.cursor.service.CatFactService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(value = "/")
public class restController {

 private final CatFactService catFactService;

 public restController(CatFactService catFactService) {
  this.catFactService = catFactService;
 }

 @GetMapping(value = "/getCatFact")
 public CatFactResponseModel getCatFact() throws IOException, InterruptedException {
  return catFactService.getCatFact();
}


}
