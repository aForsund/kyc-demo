package com.example.kycdemo.model;

import java.util.HashSet;
import java.util.Set;

public class Company {

  String name;
  String number;
  Set<Person> persons = new HashSet<>();

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public Set<Person> getPersons() {
    return persons;
  }

  public void setPersons(Set<Person> persons) {
    this.persons = persons;
  }

  public void addPerson(Person person) {
    this.persons.add(person);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Company other = (Company) obj;
    if (number == null) {
      if (other.number != null)
        return false;
    } else if (!number.equals(other.number))
      return false;

    return true;
  }

}
