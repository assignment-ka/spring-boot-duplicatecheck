package com.example.duplicatecheck.controller;

import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.annotation.Validated;

import com.example.duplicatecheck.model.OpaqueToken;
import com.example.duplicatecheck.repository.OpaqueTokenRepository;

@RestController
@Validated
public class OpaqueTokenController {

  @Autowired
  private OpaqueTokenRepository repository;

  @RequestMapping("/key")
  public boolean checkDuplicate(
      @RequestParam(value = "value") @Size(min = 20, max = 20, message = "Value must be 20 alphanumeric characters in length") String value) {
    OpaqueToken opaqueToken = repository.findByValue(value);
    boolean isDuplicate = null != opaqueToken;
    if (isDuplicate) {
      return true;
    } else {
      OpaqueToken notPresent = new OpaqueToken(value);
      repository.save(notPresent);
      return false;
    }
  }
}