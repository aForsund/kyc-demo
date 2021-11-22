package com.example.kycdemo.data.services;

import com.example.kycdemo.model.Birthdate;

import org.springframework.stereotype.Service;

@Service
public class RegexDateService {

  public Birthdate getDate(String string) {
    Birthdate date = new Birthdate();

    return date;
  }
}
