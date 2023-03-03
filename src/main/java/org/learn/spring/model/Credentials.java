package org.learn.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Credentials {


  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private String userName;
  private String password;
  private String email;

  public int getId() { return id; }

  public void setId(int id) { this.id = id; }

  public String getUserName() { return userName; }

  public void setUserName(String userName) { this.userName = userName; }

  public String getPassword() { return password; }

  public void setPassword(String password) { this.password = password; }

  public String getEmail() { return email; }

  public void setEmail(String email) { this.email = email; }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Credentials{");
    sb.append("id=").append(id);
    sb.append(", userName='").append(userName).append('\'');
    sb.append(", password='").append(password).append('\'');
    sb.append(", email='").append(email).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
