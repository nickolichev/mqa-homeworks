//package ru.netology.testing.uiautomator;
//
//import org.junit.Before;
//
//import java.net.MalformedURLException;
//import io.appium.java_client.MobileElement;
//import io.appium.java_client.android.AndroidDriver;
//import junit.framework.TestCase;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import java.net.MalformedURLException;
//import java.net.URL;
//import org.openqa.selenium.remote.DesiredCapabilities;
//
//public class AppiumTest {
//
//        private AndroidDriver driver;
//
//        @Before
//        public void setUp() throws MalformedURLException {
//            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//            desiredCapabilities.setCapability("platformName", "android");
//            desiredCapabilities.setCapability("appium:deviceName", "pixel");
//            desiredCapabilities.setCapability("appium:appPackage", "ru.netology.testing.uiautomator");
//            desiredCapabilities.setCapability("appium:appActivity", "ru.netology.testing.uiautomator.MainActivity");
//            desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
//            desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
//            desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
//            desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
//
//            URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
//
//            driver = new AndroidDriver(remoteUrl, desiredCapabilities);
//        }
//
//        @Test
//        public void sampleTest() {
//            MobileElement el1 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/userInput");
//            el1.click();
//            el1.sendKeys("    ");
//            MobileElement el2 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/buttonChange");
//            el2.click();
//            MobileElement el3 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/textToBeChanged");
//            el3.click();
//        }
//
//        @After
//        public void tearDown() {
//            driver.quit();
//        }
//    }