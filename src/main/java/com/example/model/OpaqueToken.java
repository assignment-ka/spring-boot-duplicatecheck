package com.example.duplicatecheck.model;

import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;

public class OpaqueToken {

  @Id
  public String id;

  @Size(min = 20, max = 20, message = "Value must be 20 alphanumeric characters in length")
  public String value;

  public OpaqueToken() {
  }

  public OpaqueToken(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return String.format("OpaqueToken[id=%s, value='%s']", id, value);
  }

}