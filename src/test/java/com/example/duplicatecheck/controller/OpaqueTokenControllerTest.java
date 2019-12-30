package com.example.duplicatecheck.controller;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.example.duplicatecheck.model.OpaqueToken;
import com.example.duplicatecheck.repository.OpaqueTokenRepository;
import com.example.duplicatecheck.controller.OpaqueTokenController;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class OpaqueTokenControllerTest {

  @Autowired
  private OpaqueTokenRepository repository;

  @Autowired
  private OpaqueTokenController controller;

  @Before
  public void setUp() throws Exception {
    repository.deleteAll();

    repository.save(new OpaqueToken("valid_valid_valid_va"));
    repository.save(new OpaqueToken("12345678901234567890"));
  }

  @Test
  public void testAbsent() throws IOException {
    boolean result = controller.checkDuplicate("absent_absent_absent");
    Assert.assertFalse(result);
  }

  @Test
  public void testPresent() throws IOException {
    boolean result = controller.checkDuplicate("12345678901234567890");
    Assert.assertTrue(result);
  }

}
