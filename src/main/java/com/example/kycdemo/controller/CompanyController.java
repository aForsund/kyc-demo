package com.example.kycdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/company")
public class CompanyController {

  @Autowired
  private WebClient.Builder webClientBuilder;

  @GetMapping("/test")
  public ResponseEntity<Mono<String>> test() {

    Mono<String> responseJSON = webClientBuilder.build().get()
        .uri("https://data.brreg.no/enhetsregisteret/api/enheter/988971375/roller").retrieve().bodyToMono(String.class);

    return new ResponseEntity<Mono<String>>(responseJSON, HttpStatus.OK);
  }

}
