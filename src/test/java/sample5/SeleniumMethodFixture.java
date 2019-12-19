package sample5;

import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumMethodFixture {

  protected static ChromeDriver driver;

  @Rule
  public ExternalResource browserRule = new ExternalResource() {
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
