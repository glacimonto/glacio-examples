package com.github.fridujo.glacio.examples.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
  strict   = true,
  plugin   = { "pretty", "json:target/cucumber-report.json" },
  features = { "classpath:features" },
  glue     = { "com.github.fridujo.glacio.examples.cucumber.stepdefs" },
  tags     = { "not @Ignore" })
public class ATCucumberTest {

}
