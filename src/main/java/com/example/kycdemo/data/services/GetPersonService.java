package com.example.kycdemo.data.services;

import com.example.kycdemo.data.jsondeconstructionhelpers.PersonResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

//import reactor.core.publisher.Mono;

@Service
public class GetPersonService {

  @Autowired
  private WebClient.Builder webClientBuilder;
  /*
   * public Mono<String> getPerson(String name) throws Exception {
   * 
   * Mono<String> responseJSON = webClientBuilder.build().get()
   * .uri("https://stacc-code-challenge-2021.azurewebsites.net/api/pep?name=" +
   * name).retrieve() .bodyToMono(String.class);
   * 
   * return responseJSON; }
   */

  public PersonResponse getPerson(String name) throws Exception {

    PersonResponse responseJSON = webClientBuilder.build().get()
        .uri("https://stacc-code-challenge-2021.azurewebsites.net/api/pep?name=" + name).retrieve()
        .bodyToMono(PersonResponse.class).block();

    return responseJSON;
  }
}
