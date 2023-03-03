package org.learn.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class HairCustomer {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private String firstName;
  private String lastName;
  private String middleName;
  private String email;
  private Date visitDate;

  public int getId() { return id; }

  public void setId(int id) { this.id = id; }

  public String getFirstName() { return firstName; }

  public void setFirstName(String firstName) { this.firstName = firstName; }

  public String getLastName() { return lastName; }

  public void setLastName(String lastName) { this.lastName = lastName; }

  public String getMiddleName() { return middleName; }

  public void setMiddleName(String middleName) { this.middleName = middleName; }

  public String getEmail() { return email; }

  public void setEmail(String email) { this.email = email; }

  public Date getVisitDate() { return visitDate; }

  public void setVisitDate(Date visitDate) { this.visitDate = visitDate; }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("HairCustomer{");
    sb.append("id=").append(id);
    sb.append(", firstName='").append(firstName).append('\'');
    sb.append(", lastName='").append(lastName).append('\'');
    sb.append(", middleName='").append(middleName).append('\'');
    sb.append(", email='").append(email).append('\'');
    sb.append(", visitDate=").append(visitDate);
    sb.append('}');
    return sb.toString();
  }
}
