package sample7;

import org.junit.ClassRule;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.By;

public class LoginFixture extends BrowserFixture {

  @ClassRule
  public static ExternalResource loginRule = new ExternalResource() {
    @Override
    protected void before() throws Throwable {
      System.out.println("Login");
      driver.get("https://opensource-demo.orangehrmlive.com/");
      driver.findElement(By.id("txtUsername")).sendKeys("admin");
      driver.findElement(By.id("txtPassword")).sendKeys("admin");
      driver.findElement(By.id("btnLogin")).click();
    };

    @Override
    protected void after() {
      System.out.println("Logout");
      //driver.findElement(By.name("logout")).click();
    };
  };

}
