package SeleniumInDepth;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PopUpAndAlerts {

    WebDriver driver;

    @BeforeMethod
    public void ChromeConfigSetting() {
        /*if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "E:\\Personal\\Chromewebdriver\\2.9\\chromedriver.exe");
            driver = new ChromeDriver();// launch the browser

        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "E:\\Personal\\Firefox webdriver\\geckodriver.exe");

            driver = new FirefoxDriver();
        }
*/
        System.setProperty("webdriver.chrome.driver", "E:\\Personal\\Chromewebdriver\\2.46\\chromedriver.exe");
        driver = new ChromeDriver();// launch the browser
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);


        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
}

    @Test(priority = 1)

    public void AlertAccept() throws InterruptedException {
        driver.findElement(By.name("proceed")).click();

        Alert alert = driver.switchTo().alert();
        String a = alert.getText();
        System.out.println(a);
        if (a.equals("Please enter a valid user name"))
        {
            System.out.println("Correct Bro");
        }
        else
        {
            System.out.println("Wrong Bro");
        }
        Thread.sleep(5000);
        alert.accept();

    }

    @Test(priority = 2)

    public void AlertReject() throws InterruptedException {

        driver.findElement(By.name("proceed")).click();

        Alert alert = driver.switchTo().alert();
        String a = alert.getText();
        System.out.println(a);
        if (a.equals("Please enter a valid user name"))
        {
            System.out.println("Correct Bro");
        }
        else
        {
            System.out.println("Wrong Bro");
        }

        Thread.sleep(5000);
        alert.dismiss();
    }

    @AfterMethod
    public void Quitting()

    {
        driver.get("https://www.peopleworks.ind.in");
        driver.quit();
    }

}