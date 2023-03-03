package org.learn.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Vehicle implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;


  private int customerId;
  private String vin;
  private String make;
  private String model;
  private int year;

  public int getId() { return id; }

  public void setId(int id) { this.id = id; }

  public int getCustomerId() { return customerId; }

  public void setCustomerId(int customerId) { this.customerId = customerId; }

  public String getVin() { return vin; }

  public void setVin(String vin) { this.vin = vin; }

  public String getMake() { return make; }

  public void setMake(String make) { this.make = make; }

  public String getModel() { return model; }

  public void setModel(String model) { this.model = model; }

  public int getYear() { return year; }

  public void setYear(int year) { this.year = year; }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Vehicle{");
    sb.append("id=").append(id);
    sb.append(", customerId=").append(customerId);
    sb.append(", vin='").append(vin).append('\'');
    sb.append(", make='").append(make).append('\'');
    sb.append(", model='").append(model).append('\'');
    sb.append(", year='").append(year).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
