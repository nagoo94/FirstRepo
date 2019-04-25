package com.PWTestLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class DemoTest2 {

    WebDriver driver;

    @BeforeClass
    @Parameters({"browser"})
    public void ChromeConfigSetting(String browser)
    {
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "E:\\Personal\\Chromewebdriver\\2.46\\chromedriver.exe");
            driver = new ChromeDriver();// launch the browser

        }

        else if (browser.equals("firefox"))
        {
            System.setProperty("webdriver.gecko.driver", "E:\\Personal\\Firefox webdriver\\geckodriver.exe");

          driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    }

    @BeforeMethod
    @Parameters({"url","username"})
    public void login(String url, String username)
    {
        driver.get(url);
        driver.findElement(By.name("UserName")).sendKeys(username);
        // driver.findElement(By.name("Password")).sendKeys("JFS@1234");
        JavascriptExecutor passwordEntry = (JavascriptExecutor) driver;
        passwordEntry.executeScript("$('#Password').val(\"JFS@1234\")");
        driver.findElement(By.id("btnlogin")).click();
    }
//title test
       // @Test(priority=1)


    // Testing the home page for Tabs.
    @Test(priority = 1)
    public void HomePage()
    {
    boolean a = driver.findElement(By.linkText("MY SELF")).isDisplayed();
    boolean b = driver.findElement(By.linkText("REPORTS")).isDisplayed();
    System.out.println(a);
    System.out.println(b);
    }


    @Test(priority = 2)
    public void ApplyLeave()
    {
    driver.findElement(By.linkText("MY SELF")).click();
    driver.findElement(By.linkText("My Leave")).click();
    driver.findElement(By.linkText("Apply/Cancel Leave")).click();
    driver.findElement(By.id("btnApply")).click();

    driver.findElement(By.cssSelector("#dropLeaveType")).click();
    Select preference = new Select(driver.findElement(By.cssSelector("#dropApprover")));
    preference.selectByValue("f6cf016f-20a7-4846-b7bd-5b5419f8ca30");
    //driver
    }

    /* @Test

     public void CheckAttendance()
     {


     }
 */
    @AfterMethod
    public void Logout()
    {
        driver.findElement(By.cssSelector("#p_settingimg")).click();
        driver.findElement(By.cssSelector("#p_setting > div > table > tbody > tr:nth-child(3) > td > a")).click();
    }

    @AfterClass
    public void CloseBrowser()

    {
        driver.quit();
    }
}

