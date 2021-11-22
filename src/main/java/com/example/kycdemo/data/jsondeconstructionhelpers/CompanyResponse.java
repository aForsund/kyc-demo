package com.example.kycdemo.data.jsondeconstructionhelpers;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyResponse {

  private List<CompanyRoles> roller = new ArrayList<>();

  public CompanyResponse() {
  }

  public void setRollegrupper(List<CompanyRoles> roller) {
    this.roller = roller;
  }

  public List<CompanyRoles> getRollegrupper() {
    return this.roller;
  }

}
