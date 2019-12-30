package com.example.duplicatecheck.repository;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.duplicatecheck.model.OpaqueToken;
import com.example.duplicatecheck.repository.OpaqueTokenRepository;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class OpaqueTokenRepositoryTest {

  @Autowired
  OpaqueTokenRepository repository;

  @Before
  public void setUp() {

    repository.deleteAll();

    repository.save(new OpaqueToken("valid_valid_valid_va"));
    repository.save(new OpaqueToken("1234567890"));
    repository.save(new OpaqueToken("12345678901234567890"));
  }

  @Test
  public void setsIdOnSave() {
    OpaqueToken valid = repository.save(new OpaqueToken("12345678901234567890"));
    Assert.assertNotNull(valid.id);
  }

  @Test
  public void findsByValue() {
    OpaqueToken result = repository.findByValue("12345678901234567890");
    Assert.assertNotNull(result);
    Assert.assertEquals("12345678901234567890", result.value);
  }

}
