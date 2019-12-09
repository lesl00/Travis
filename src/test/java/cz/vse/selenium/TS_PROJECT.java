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

/**
 * Unit test for simple App.
 */

public class TS_PROJECT {
    private ChromeDriver driver;
    private String page="http://digitalnizena.cz/rukovoditel/index.php?module=users/login"

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
    public void project_withoutNAME() {
        driver.get(page);
        WebElement searchInput = driver.findElement(By.name("username"));
        searchInput.sendKeys("rukovoditel");
        searchInput = driver.findElement(By.name("password"));
        searchInput.sendKeys("vse456ru");
        searchInput.sendKeys(Keys.ENTER);
        Assert.assertTrue(driver.getTitle().startsWith("Rukovoditel | Dashboard"));
        driver.findElement(By.cssSelector(".li:nth-child(4) .title:nth-child(2)")).click();
        driver.findElement(By.cssSelector(".btn-primary:nth-child(1)")).click();
        WebDriverWait wait = new WebDriverWait(driver, 2);
        driver.findElement(By.cssSelector(".btn-primary-modal-action")).click();
        WebDriverWait wait = new WebDriverWait(driver, 2);
        Wait.until(ExpectedCondition.visibilityOfElementLocated(By.cssSelector(".alert")));
        Assert.assertTrue(driver.findElement(By.cssSelector(".alert")).isDisplayed());
        driver.quit();
    }

    @Test
    public void project_createdThanDELETED() {
        driver.get(page);
        WebElement searchInput = driver.findElement(By.name("username"));
        searchInput.sendKeys("rukovoditel");
        searchInput = driver.findElement(By.name("password"));
        searchInput.sendKeys("vse456ru");
        searchInput.sendKeys(Keys.ENTER);
        Assert.assertTrue(driver.getTitle().startsWith("Rukovoditel | Dashboard"));
        driver.findElement(By.cssSelector(".li:nth-child(4) .title:nth-child(2)")).click();
        driver.findElement(By.cssSelector(".btn-primary:nth-child(1)")).click();
        WebDriverWait wait = new WebDriverWait(driver, 2);
        driver.findElement(By.id("fields_156")).click();
        driver.findElement(By.id("fields_156")).select(1);
        Assert.assertTrue(driver.findElement(By.id("fields_156")).select(1).isDisplayed());
        driver.findElement(By.id("fields_157")).click();
        driver.findElement(By.id("fields_157")).select(2);
        driver.findElement(By.id("fields_157")).select(0);
        Assert.assertTrue(driver.findElement(By.id("fields_157")).select(0).isDisplayed());
        driver.findElement(By.id("fields_158")).click();
        driver.findElement(By.id("fields_158")).sendKeys("lesl00");
        Assert.assertTrue(driver.findElement(By.id("fields_158")).sendKeys("lesl00").isDisplayed());



        Assert.assertTrue(driver.findElement(By.id("fields_157")).select(0).isDisplayed());

        driver.findElement(By.cssSelector(".btn-primary-modal-action")).click();
        driver.quit();
    }

}





