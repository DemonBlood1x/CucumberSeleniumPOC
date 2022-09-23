package stepDefinitions;

import amazonPOM.Amazon;
import chromeConnection.BrowsersConnection;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {

    final String CHROME = "chrome";
    final String FIREFOX = "firefox";
    final String EDGE = "edge";

    private BrowsersConnection connection;
    private Amazon amazon;

    @Given("the user open amazon web page")
    public void the_user_open_amazon_web_page() {
        System.out.println("Cucumber with Selenium POC!");
        connection = new BrowsersConnection();
        amazon = new Amazon(connection.setup(CHROME));
    }

    @When("the user searches {string} on amazon")
    public void the_user_searches_on_amazon(String strSearch) {
        System.out.println("Search in amazon: " + strSearch);

        amazon.setSearchTxtB(strSearch);
    }

    @When("the user entered the {word} on amazon")
    public void the_user_entered_the_on_amazon(String strWord) {
        System.out.println("Search in amazon: " + strWord);

        amazon.setSearchTxtB(strWord);
    }

    @When("hits submit")
    public void hits_submit() {
        System.out.println("Submit button");

        amazon.setSearchButton();
    }

    @Then("the user see the different products")
    public void the_user_see_the_different_products() {
        System.out.println("See result");

//        amazon.setResultView();
    }

}
