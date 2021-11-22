package com.example.kycdemo.controller;

import java.util.Objects;

import com.example.kycdemo.data.jsondeconstructionhelpers.CompanyResponse;

import com.example.kycdemo.data.services.GetCompanyService;
import com.example.kycdemo.model.Company;

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
@RequestMapping("api/company")
public class CompanyController {

  @Autowired
  private WebClient.Builder webClientBuilder;

  @Autowired
  private GetCompanyService getCompanyService;

  @GetMapping("/test")
  public ResponseEntity<Mono<CompanyResponse>> test() {

    Mono<CompanyResponse> responseJSON = webClientBuilder.build().get()
        .uri("https://data.brreg.no/enhetsregisteret/api/enheter/988971375/roller").retrieve()
        .bodyToMono(CompanyResponse.class);

    return new ResponseEntity<Mono<CompanyResponse>>(responseJSON, HttpStatus.OK);
  }

  /*
   * @GetMapping("/{number}") public ResponseEntity<Mono<CompanyResponse>>
   * getCompany(@PathVariable String number) {
   * 
   * Mono<CompanyResponse> responseJSON; try { responseJSON =
   * getCompanyService.getCompanyResponse(number); return new
   * ResponseEntity<Mono<CompanyResponse>>(responseJSON, HttpStatus.OK); } catch
   * (Exception e) { e.printStackTrace(); return new
   * ResponseEntity<>(HttpStatus.NOT_FOUND); }
   * 
   * }
   */
  @GetMapping("/{number}")
  public ResponseEntity<Company> getCompany(@PathVariable String number) {

    Company company;
    try {
      company = getCompanyService.getCompany(number);

    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<Company>(company, Objects.isNull(company) ? HttpStatus.NOT_FOUND : HttpStatus.OK);
  }

}