package com.example.kycdemo.model;

public class Birthdate {

  private int year;
  private int month;
  private int day;

  public Birthdate() {
  }

  public void setYear(int year) {
    this.year = year;
  }

  public void setMonth(int month) {
    this.month = month;
  }

  public void setDay(int day) {
    this.day = day;
  }

  public int getYear() {
    return year;
  }

  public int getMonth() {
    return month;
  }

  public int getDay() {
    return day;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Birthdate other = (Birthdate) obj;
    if (year != other.year)
      return false;
    if (month != other.month)
      return false;
    if (day != other.day)
      return false;

    return true;
  }

}
