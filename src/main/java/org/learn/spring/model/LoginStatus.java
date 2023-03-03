package org.learn.spring.model;

public class LoginStatus {
  private boolean success;
  private boolean locked;
  private String message;

  public boolean isSuccess() { return success; }

  public void setSuccess(boolean success) { this.success = success; }

  public boolean isLocked() { return locked; }

  public void setLocked(boolean locked) { this.locked = locked; }

  public String getMessage() { return message; }

  public void setMessage(String message) { this.message = message; }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("LoginStatus{");
    sb.append("success=").append(success);
    sb.append(", locked=").append(locked);
    sb.append(", message='").append(message).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
