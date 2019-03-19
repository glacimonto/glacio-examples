package com.github.fridujo.glacio.examples.glacio.stepdefs;

import com.github.fridujo.glacio.running.api.Given;
import com.github.fridujo.glacio.running.api.Then;
import com.github.fridujo.glacio.running.api.When;

public class TestCaseExecutionStepDef {

    @Given("the following step")
    public void the_following_step() {
        System.err.println("Glacio given");
    }

    @When("it is executed")
    public void it_is_executed() {
        System.err.println("Glacio when");
    }

    @Then("the execution succeed")
    public void the_execution_succeed() {
        System.err.println("Glacio then");
    }
}
