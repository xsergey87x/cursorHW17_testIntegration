package com.cursor.cursor.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class restController {

@GetMapping(value = "/getCatFact")
 public void getCatFact()
{

}


}
