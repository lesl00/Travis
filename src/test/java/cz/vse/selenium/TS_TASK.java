package java.cz.vse.selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Unit test for simple App.
 */

public class TS_TASK {
    private ChromeDriver driver;
    private string page="http://digitalnizena.cz/rukovoditel/index.php?module=users/login"

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        ChromeOptions cho = new ChromeOptions();
        cho.addArguments("--headless");
        cho.addArguments("start-maximized");
        cho.addArguments("window-size=1200,1100");
        cho.addArguments("--disable-gpu");
        cho.addArguments("--disable-extensions");
       // driver = new ChromeDriver(cho);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
//        driver.close();
    }


    @Test
    public void login_rukovoditel() {
        driver.get(page);
        WebElement searchInput = driver.findElement(By.name("username"));
        searchInput.sendKeys("rukovoditel");
        searchInput = driver.findElement(By.name("password"));
        searchInput.sendKeys("vse456ru");
        searchInput.sendKeys(Keys.ENTER);
        Assert.assertTrue(driver.getTitle().startsWith("Rukovoditel | Dashboard"));
        driver.quit();
    }

    @Test
    public void login_negative_rukovoditel() {
        driver.get(page);
        WebElement searchInput = driver.findElement(By.name("username"));
        searchInput.sendKeys("haha");
        searchInput = driver.findElement(By.name("password"));
        searchInput.sendKeys("123");
        searchInput.sendKeys(Keys.ENTER);
        Assert.assertTrue(!driver.getTitle().startsWith("Rukovoditel | Dashboard"));
        driver.quit();
    }

    @Test
    public void logout_rukovoditel() {
        driver.get(page);
        WebElement searchInput = driver.findElement(By.name("username"));
        searchInput.sendKeys("rukovoditel");
        searchInput = driver.findElement(By.name("password"));
        searchInput.sendKeys("vse456ru");
        searchInput.sendKeys(Keys.ENTER);
        Assert.assertTrue(driver.getTitle().startsWith("Rukovoditel | Dashboard"));
        driver.findElement(By.cssSelector(".fa-angle-down")).click();
        driver.findElement(By.cssSelector(".user > .dropdown-toggle")).click();
        WebDriverWait wait = new WebDriverWait(driver, 1);
        driver.findElement(By.linkText("Logoff")).click();
        driver.quit();
    }

    }





