package hellocucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;

import static org.junit.Assert.assertEquals;


class IsItFriday {
    static String isItFriday(String today) {
        return "Friday".equals(today) ? "TGIF" : "Nope";
    }
}
public class Stepdefs {
    private String today;
    private String actualAnswer;

    private static final Logger LOGGER = LoggerFactory.getLogger(Stepdefs.class);

    @Given("today is {string}")
    public void today_is(String today) {
        boolean isDebugEnabled = LOGGER.isDebugEnabled();
        LOGGER.trace("Pasando por el método start() ");
        LOGGER.debug("Pasando por el método start() ");
        LOGGER.info("Pasando por el método start() ");
//        LOGGER.warn("Pasando por el método start() ");
        LOGGER.error("Pasando por el método start() ");
//        LOGGER.error("Pasando por el método start() con respuesta {}", "OK");
        this.today = today;
    }

    @When("I ask whether it's Friday yet")
    public void i_ask_whether_it_s_Friday_yet() {
        actualAnswer = IsItFriday.isItFriday(today);
    }

    @Then("I should be told {string}")
    public void i_should_be_told(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }
}
