package com.example.kycdemo.data.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.kycdemo.data.jsondeconstructionhelpers.CompanyResponse;
import com.example.kycdemo.model.Birthdate;
import com.example.kycdemo.model.Company;
import com.example.kycdemo.model.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class GetCompanyService {

  @Autowired
  private WebClient.Builder webClientBuilder;

  public Company getCompany(String number) throws Exception {

    Company company = new Company();

    // Get JSON response and convert to CompanyResponse
    CompanyResponse companyResponse;
    try {
      companyResponse = webClientBuilder.build().get()
          .uri("https://data.brreg.no/enhetsregisteret/api/enheter/" + number + "/roller").retrieve()
          .bodyToMono(CompanyResponse.class).block();
    } catch (Exception e) {

      return null;
    }
    // Get company name
    String name = "Dummy name";

    // Set Company details
    company.setName(name);
    company.setNumber(number);

    // Convert companyResponse to company
    if (!companyResponse.getRollegrupper().isEmpty()) {
      companyResponse.getRollegrupper().forEach(companyRoles -> {
        if (!companyRoles.getRoller().isEmpty()) {
          companyRoles.getRoller().forEach(companyRole -> {
            Person person = new Person();
            try{
            person.setTitle(companyRole.getType().getBeskrivelse());
            person.setFirstName(companyRole.getPerson().getNavn().getFornavn());
            person.setLastName(companyRole.getPerson().getNavn().getEtternavn());
            } catch(Exception e){
              e.printStackTrace();
            }
            Birthdate birthdate = new Birthdate();
            List<String> dateArray = new ArrayList<>();
            try {
              Arrays.stream(companyRole.getPerson().getFodselsdato().split("-")).forEach(item -> {
                dateArray.add(item);
              });
              birthdate.setYear(Integer.parseInt(dateArray.get(0)));
              birthdate.setMonth(Integer.parseInt(dateArray.get(1)));
              birthdate.setDay(Integer.parseInt(dateArray.get(2)));
            } catch(Exception e){
              e.printStackTrace();
            }

            person.setDate(birthdate);
            company.addPerson(person);
          });
        }
      });
    }

    // Validate persons in company
    company.getPersons().forEach(person -> {

    });

    return company;

  }

  // used for testing
  public Mono<CompanyResponse> getCompanyResponse(String number) throws Exception {

    Mono<CompanyResponse> companyResponse = webClientBuilder.build().get()
        .uri("https://data.brreg.no/enhetsregisteret/api/enheter/" + number + "/roller").retrieve()
        .bodyToMono(CompanyResponse.class);

    return companyResponse;
  }

}
