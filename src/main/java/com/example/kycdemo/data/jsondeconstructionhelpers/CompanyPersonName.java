package com.example.kycdemo.data.jsondeconstructionhelpers;

public class CompanyPersonName {

  private String fornavn;
  private String etternavn;

  public CompanyPersonName() {
  }

  public void setFornavn(String fornavn) {
    this.fornavn = fornavn;
  }

  public void setEtternavn(String etternavn) {
    this.etternavn = etternavn;
  }

  public String getFornavn() {
    return this.fornavn;
  }

  public String getEtternavn() {
    return this.etternavn;
  }

}
