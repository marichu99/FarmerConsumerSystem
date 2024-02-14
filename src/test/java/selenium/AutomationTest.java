package selenium;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            loginToTheSystem(driver);

            cartItems(driver);

            proceedToPayment(driver);

        } catch (Exception e) {
            System.out.println("The error is " + e.getMessage());
        } finally {

            tearDown(driver);

        }

    }

    private static void tearDown(WebDriver driver) {
        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        driver.quit();
    }

    @Test
    private static void proceedToPayment(WebDriver driver) {
        WebElement phoneNumber = driver.findElement(By.xpath("//input[@id='phoneNumber']"));

        phoneNumber.sendKeys("254703750755");

    }

    @Test
    private static void cartItems(WebDriver driver) {
        WebElement cartItems = driver.findElement(By.xpath("//span[normalize-space()='Cart Items']"));

        cartItems.click();

        WebElement quantity = driver.findElement(By.xpath("//input[@id='numQuantity0']"));

        quantity.sendKeys("25");

        WebElement checkout = driver.findElement(By.xpath("//button[@id='myBtn']"));

        checkout.click();

    }

    @Test
    private static void loginToTheSystem(WebDriver driver) {
        driver.get("http://127.0.0.1:8080/farmer-system-app/");

        driver.manage().window().maximize();

        WebElement login = driver.findElement(By.xpath("//a[normalize-space()='Login']"));

        login.click();

        WebElement emailLogin = driver.findElement(By.xpath("//input[@id='email']"));

        WebElement passwordLogin = driver.findElement(By.xpath("//input[@id='password']"));

        emailLogin.sendKeys("mabera@gmail.com");
        passwordLogin.sendKeys("mabera");

        WebElement radioButton = driver.findElement(By.xpath("//input[@value='USER']"));

        radioButton.click();

        WebElement submit = driver.findElement(By.xpath("//input[@id='submit']"));

        submit.click();

        // get the Login Logo
        WebElement logo = driver.findElement(By.xpath("//span[@class='logo_name']"));

        String logoText = logo.getText();

        System.out.println("The logo is" + logoText);

        Assert.assertEquals(logoText, "Ukulima");

        // Ass.assertEquals(logoText, logoText);
    }
}
