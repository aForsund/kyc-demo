package com.example.kycdemo.data.jsondeconstructionhelpers;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonResponse {

  private List<PersonPEP> hits;

  public PersonResponse() {
  }

  public List<PersonPEP> getHits() {
    return hits;
  }

  public void setHits(List<PersonPEP> hits) {
    this.hits = hits;
  }

}
