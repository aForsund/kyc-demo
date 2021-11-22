package com.example.kycdemo.data.jsondeconstructionhelpers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyPerson {

  private CompanyPersonName navn;
  private String fodselsdato;

  public CompanyPerson() {
  }

  public void setNavn(CompanyPersonName navn) {
    this.navn = navn;
  }

  public void setFodselsdato(String dato) {
    this.fodselsdato = dato;
  }

  public CompanyPersonName getNavn() {
    return this.navn;
  }

  public String getFodselsdato() {
    return this.fodselsdato;
  }
}
