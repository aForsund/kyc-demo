package com.example.kycdemo.model;

import java.util.ArrayList;
import java.util.List;

public class Person {

  private String name;
  private Birthdate date;
  private boolean isPEP;
  private String title;
  private List<Dataset> dataset = new ArrayList<>();

  public Person() {
    this.isPEP = false;
  }

  public List<Dataset> getDataset() {
    return dataset;
  }

  public void setDataset(List<Dataset> dataset) {
    this.dataset = dataset;
  }

  public void addDataset(Dataset dataset) {
    this.dataset.add(dataset);
  }

  public boolean isPEP() {
    return isPEP;
  }

  public void setPEP(boolean isPEP) {
    this.isPEP = isPEP;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Birthdate getDate() {
    return date;
  }

  public void setDate(Birthdate date) {
    this.date = date;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((date == null) ? 0 : date.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
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
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equalsIgnoreCase(other.name))
      return false;
    return true;
  }

}
