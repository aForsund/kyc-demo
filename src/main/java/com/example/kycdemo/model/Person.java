package com.example.kycdemo.model;

public class Person {

  private String firstName;
  private String lastName;
  private Birthdate date;
  private boolean isPEP;

  public Person() {
    this.isPEP = false;
  }

  public boolean isPEP() {
    return isPEP;
  }

  public void setPEP(boolean isPEP) {
    this.isPEP = isPEP;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Birthdate getDate() {
    return date;
  }

  public void setDate(Birthdate date) {
    this.date = date;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Person other = (Person) obj;
    if (date == null) {
      if (other.date != null)
        return false;
    } else if (!date.equals(other.date))
      return false;
    if (firstName == null) {
      if (other.firstName != null)
        return false;
    } else if (!firstName.equals(other.firstName))
      return false;
    if (lastName == null) {
      if (other.lastName != null)
        return false;
    } else if (!lastName.equals(other.lastName))
      return false;
    return true;
  }

}
