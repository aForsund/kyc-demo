package com.example.kycdemo.data.services;

import com.example.kycdemo.model.Person;

import org.springframework.stereotype.Service;

@Service
public class PEPValidationService {

  public boolean validatePEP(Person personOne, Person personTwo) {
    return personOne.equals(personTwo);
  }

}
