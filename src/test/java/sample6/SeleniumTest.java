package sample6;

import org.junit.Test;

public class SeleniumTest extends SeleniumClassFixture {

  @Test
  public void test1() {
    driver.get("https://selenium.dev/");
    System.out.println("selenium.dev web-site is opened");
  }

  @Test
  public void test2() {
    driver.get("https://webdriver.ru/");
    System.out.println("webdriver.ru web-site is opened");
  }


}
