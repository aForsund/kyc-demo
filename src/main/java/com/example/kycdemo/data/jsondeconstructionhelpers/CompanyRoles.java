package com.example.kycdemo.data.jsondeconstructionhelpers;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyRoles {
  private List<CompanyRole> roller = new ArrayList<>();

  public CompanyRoles() {
  }

  public void setRoller(List<CompanyRole> roller) {
    this.roller = roller;
  }

  public List<CompanyRole> getRoller() {
    return this.roller;
  }
}
