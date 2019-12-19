package sample7;

import org.junit.Test;
import org.openqa.selenium.By;

public class SeleniumTest extends LoginFixture {

  @Test
  public void test1() {
    System.out.println("Error message is " + driver.findElement(By.id("spanMessage")).getText());
  }

}
