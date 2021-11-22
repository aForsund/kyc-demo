package com.example.kycdemo.data.jsondeconstructionhelpers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class CompanyRoleType {

  private String beskrivelse;

  public CompanyRoleType() {
  }

  public void setBeskrivelse(String beskrivelse) {
    this.beskrivelse = beskrivelse;
  }

  public String getBeskrivelse() {
    return this.beskrivelse;
  }

}
