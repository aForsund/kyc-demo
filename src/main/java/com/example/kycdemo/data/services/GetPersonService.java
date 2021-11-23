package com.example.kycdemo.data.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.kycdemo.data.jsondeconstructionhelpers.PersonResponse;
import com.example.kycdemo.model.Birthdate;
import com.example.kycdemo.model.Dataset;
import com.example.kycdemo.model.Person;

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

  public List<Person> getPerson(String name) throws Exception {

    // Get JSON response and convert to PersonResponse
    PersonResponse personResponse;
    try {

      personResponse = webClientBuilder.build().get()
          .uri("https://stacc-code-challenge-2021.azurewebsites.net/api/pep?name=" + name).retrieve()
          .bodyToMono(PersonResponse.class).block();
    } catch (Exception e) {
      return null;
    }

    List<Person> personList = new ArrayList<>();
    // Convert personResponse to PEPerson

    if (!personResponse.getHits().isEmpty()) {
      personResponse.getHits().forEach(hit -> {
        Person person = new Person();
        try {
          person.setName(hit.getName());
          Dataset dataset = new Dataset();
          dataset.setScore(hit.getScore());
          dataset.setDataset(hit.getDataset());
          person.addDataset(dataset);
          Birthdate birthdate = new Birthdate();
          List<String> dateArray = new ArrayList<>();
          try {
            Arrays.stream(hit.getBirth_date().split("-")).forEach(item -> {
              dateArray.add(item);
            });
            birthdate.setYear(Integer.parseInt(dateArray.get(0)));
            birthdate.setMonth(Integer.parseInt(dateArray.get(1)));
            birthdate.setDay(Integer.parseInt(dateArray.get(2)));
          } catch (Exception e) {
            e.printStackTrace();
          }

          person.setDate(birthdate);

        } catch (Exception e) {
          e.printStackTrace();
        }
        personList.add(person);

      });
    }

    return personList;
  }
}
