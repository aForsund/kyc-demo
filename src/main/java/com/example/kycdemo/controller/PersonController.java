package com.example.kycdemo.controller;

import java.util.List;

import com.example.kycdemo.data.services.GetPersonService;

import com.example.kycdemo.model.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/person")
public class PersonController {

  @Autowired
  private WebClient.Builder webClientBuilder;

  @Autowired
  private GetPersonService getPersonService;

  @GetMapping("")
  public ResponseEntity<Mono<String>> test() {

    Mono<String> responseJSON = webClientBuilder.build().get()
        .uri("https://stacc-code-challenge-2021.azurewebsites.net/api/pep?name=Knut Arild Hareide").retrieve()
        .bodyToMono(String.class);

    return new ResponseEntity<Mono<String>>(responseJSON, HttpStatus.OK);

  }
  /*
   * @GetMapping("/{name}") public ResponseEntity<List<Person>> getPerson() {
   * 
   * Person person = new Person(); person.setFirstName("firstName");
   * person.setLastName("lastName");
   * 
   * List<Person> personList = new ArrayList<>();
   * 
   * personList.add(person);
   * 
   * return new ResponseEntity<List<Person>>(personList, HttpStatus.OK);
   * 
   * }
   */

  /*
   * @GetMapping("/{name}") public ResponseEntity<Mono<String>>
   * getPerson(@PathVariable String name) {
   * 
   * Mono<String> responseJSON; try { responseJSON =
   * getPersonService.getPerson(name); } catch (Exception e) {
   * e.printStackTrace(); return new ResponseEntity<>(HttpStatus.NOT_FOUND); }
   * 
   * return new ResponseEntity<Mono<String>>(responseJSON, HttpStatus.OK); }
   */

  @GetMapping("/{name}")
  public ResponseEntity<List<Person>> getPerson(@PathVariable String name) {

    List<Person> personList;
    try {
      personList = getPersonService.getPerson(name);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<List<Person>>(personList, HttpStatus.OK);
  }
}
