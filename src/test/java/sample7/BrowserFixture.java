package sample7;

import org.junit.ClassRule;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFixture {

  protected static WebDriver driver;

  @ClassRule
  public static ExternalResource driverRule = new ExternalResource() {
    @Override
    protected void before() throws Throwable {
      System.out.println("Starting a browser");
      System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
      driver = new ChromeDriver();
    };

    @Override
    protected void after() {
      System.out.println("Stopping the browser");
      if (driver != null) {
        driver.quit();
      }
    };
  };

}
