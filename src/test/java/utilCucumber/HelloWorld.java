package utilCucumber;

import com.util.URIConstants;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import util.ChromeWebDriverSetup;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HelloWorld {

    private static WebDriver driver = null;

    @Given("^open google$")
    public static void openPage() throws Throwable {
        driver = new ChromeDriver();
        ChromeWebDriverSetup.setDriver(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(URIConstants.GOOGLE_BY_URI);
    }

    @When("^search for \"([^\"]*)\"$")
    public void searchParameter(String searchCriteria) throws Throwable {
        WebElement searchField = driver.findElement(By.id("lst-ib"));
        searchField.sendKeys(searchCriteria);

        searchField.submit();
    }

    @Then("^\"([^\"]*)\" found in search result$")
    public void verifySearchResults(String searchCriteria) throws Throwable {
        List<WebElement> searchResults = driver.findElements(By.cssSelector(".r"));

        for (WebElement searchResult : searchResults) {
            if (!searchResult.getText().toLowerCase().contains(searchCriteria)) {
                Assert.fail("Not all elements contain search param");
            }
        }

        driver.quit();
    }
}
