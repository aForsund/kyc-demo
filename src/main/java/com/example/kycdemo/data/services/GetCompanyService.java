package com.example.kycdemo.data.services;

import com.example.kycdemo.data.jsondeconstructionhelpers.CompanyResponse;
import com.example.kycdemo.model.Company;

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
    CompanyResponse companyResponse = webClientBuilder.build().get()
        .uri("https://data.brreg.no/enhetsregisteret/api/enheter/" + number + "/roller").retrieve()
        .bodyToMono(CompanyResponse.class).block();

    // Get company name
    String name = "Dummy name";

    // Set Company details
    company.setName(name);
    company.setNumber(number);

    if (!companyResponse.getRollegrupper().isEmpty()) {

    }
    return company;

  }

  public Mono<CompanyResponse> getCompanyResponse(String number) throws Exception {

    Mono<CompanyResponse> companyResponse = webClientBuilder.build().get()
        .uri("https://data.brreg.no/enhetsregisteret/api/enheter/" + number + "/roller").retrieve()
        .bodyToMono(CompanyResponse.class);

    return companyResponse;
  }

}
