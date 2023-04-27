package ru.netology;

import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;

import java.net.URL;

import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UiAutomatorTest {


  private AndroidDriver driver;
  ScreenUiAutomator app;

  @BeforeEach
  public void setUp() throws MalformedURLException {
    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    desiredCapabilities.setCapability("platformName", "android");
    desiredCapabilities.setCapability("appium:deviceName", "pixel");
    desiredCapabilities.setCapability("appium:appPackage", "ru.netology.testing.uiautomator");
    desiredCapabilities.setCapability("appium:appActivity", "ru.netology.testing.uiautomator.MainActivity");
    desiredCapabilities.setCapability("appium:newCommandTimeout", 3000);

    URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

    driver = new AndroidDriver(remoteUrl, desiredCapabilities);

    app = new ScreenUiAutomator(driver);
  }


  @Test
  public void settingEmptyStringTest() {
    String textToBeChanged = app.textToBeChanged.getText();
    app.userInput.isDisplayed();
    app.userInput.click();
    app.userInput.sendKeys("  ");
    app.buttonChange.isDisplayed();
    app.buttonChange.click();
    app.textToBeChanged.isDisplayed();

    Assertions.assertEquals(textToBeChanged, app.textToBeChanged.getText());

  }

  @Test
  public void openActivityTest() throws InterruptedException {
    app.userInput.isDisplayed();
    app.userInput.click();
    app.userInput.sendKeys("Netology");
    app.buttonActivity.isDisplayed();
    app.buttonActivity.click();
    Thread.sleep(5000);
    app.text.isDisplayed();

    Assertions.assertEquals("Netology", app.text.getText());
  }


  @AfterEach
  public void tearDown() {
    driver.quit();
  }
}

