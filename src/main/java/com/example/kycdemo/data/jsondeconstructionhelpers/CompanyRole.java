package com.example.kycdemo.data.jsondeconstructionhelpers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyRole {

  private CompanyRoleType type;
  private CompanyPerson person;

  public CompanyRole() {
  }

  public void setType(CompanyRoleType type) {
    this.type = type;
  }

  public void setPerson(CompanyPerson person) {
    this.person = person;
  }

  public CompanyRoleType getType() {
    return this.type;
  }

  public CompanyPerson getPerson() {
    return this.person;
  }

}
