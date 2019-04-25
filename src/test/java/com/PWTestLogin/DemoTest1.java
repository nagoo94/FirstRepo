package com.PWTestLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DemoTest1 {

    WebDriver driver;


    @BeforeMethod
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver","E:\\Personal\\Chromewebdriver\\2.46\\chromedriver.exe");
        driver = new ChromeDriver();// launch the browser
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
        driver.get("https://google.com");
    }

    @Test
    public void LoginTest()
    {
        String title = driver.getTitle();
        System.out.println(title);
    }

    @Test
    public void imageTest()
    {
       boolean B = driver.findElement(By.xpath("//*[@id=\"hplogo\"]")).isDisplayed();
       System.out.println(B);
    }

    @Test
    public void maillinkTest()
    {
        boolean c =driver.findElement(By.linkText("Gmail")).isDisplayed();
        System.out.println(c);
    }

    @AfterMethod
    public void tearQuit()
    {
    driver.quit();
    }
}

