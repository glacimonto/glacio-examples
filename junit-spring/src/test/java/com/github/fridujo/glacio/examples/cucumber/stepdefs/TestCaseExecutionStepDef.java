package com.github.fridujo.glacio.examples.cucumber.stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestCaseExecutionStepDef {


  @Given("the following step")
  public void theFollowingStep() {
    System.err.println("Cucumber given");
  }

  @When("it is executed")
  public void itIsExecuted() {
    System.err.println("Cucumber when");
  }

  @Then("the execution succeed")
  public void theExecutionSucceed() {
    System.err.println("Cucumber then");
  }

}
