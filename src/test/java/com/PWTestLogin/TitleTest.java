package com.PWTestLogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TitleTest {

    WebDriver driver;

    @BeforeMethod
    public void config() {
        System.setProperty("webdriver.chrome.driver", "E:\\Personal\\Chromewebdriver\\2.46\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

    }

    @Test
    public void TitleTest()
    {
        driver.get("https://www.peoplepeopleworks.ind.in/");
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title, "PW | Login", "PW Sucks");
    }

    @AfterMethod
    public void CloseBrowser()
    {
        driver.quit();
    }

}