package com.example.kycdemo.data.services;

import com.example.kycdemo.data.jsondeconstructionhelpers.CompanyResponse;
import com.example.kycdemo.model.Company;

import org.springframework.stereotype.Service;

@Service
public class CompanyResponseToCompanyService {

  public Company generateCompany(CompanyResponse response, String number) {
    if (response == null)
      return null;

    Company company = new Company();

    company.setNumber(number);

    return company;
  }

}
