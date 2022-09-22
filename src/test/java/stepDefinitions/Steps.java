package stepDefinitions;

import amazonPOM.Amazon;
import chromeConnection.ChromeConnection;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {

    ChromeConnection connection = new ChromeConnection();
    Amazon amazon = new Amazon(connection.setup());

    @Given("the user open amazon web page")
    public void the_user_open_amazon_web_page() {
        System.out.println("Cucumber with Selenium POC!");

    }

    @When("the user searches on amazon")
    public void the_user_searches_on_amazon() {
        System.out.println("Search in amazon");

        amazon.setSearchTxtB("Digimon");
    }

    @When("hits submit")
    public void hits_submit() {
        System.out.println("Submit button");

        amazon.setSearchButton();
    }

    @Then("the user see the different products")
    public void the_user_see_the_different_products() {
        System.out.println("See result");

        amazon.setResultView();
    }
}
