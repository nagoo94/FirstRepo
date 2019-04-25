package SeleniumInDepth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FrameHandle

{
    WebDriver driver;
    @BeforeMethod
    public void BrowserConfig()
    {
        System.setProperty("webdriver.chrome.driver", "E:\\Personal\\Chromewebdriver\\2.46\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
    }

    @Test
    public void FrameHandling () throws InterruptedException

    {
        driver.get("https://freecrm.com/");
        Thread.sleep(5000);
        driver.findElement(By.linkText("LOG IN")).click();

    }

    @AfterMethod
    public void quit()
    {
        driver.quit();
    }
}
