package selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set the path to the chromedriver executable
        // System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Login only once before any test
        login();
    }

    @After
    public void tearDown() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

    @Test
    public void testLogin() {
        login();

        // Check if the URL path is as expected
        String expectedURL = "http://127.0.0.1:8080/farmer-system-app/";
        Assert.assertTrue("URL path is not as expected", driver.getCurrentUrl().contains(expectedURL));

    }

    @Test
    public void getSellPage(){

        login();
        //span[normalize-space()='Sell']
        WebElement sellBtn = driver.findElement(By.xpath("//span[normalize-space()='Sell']"));

        String expectedUrl = "http://127.0.0.1:8080/farmer-system-app/sell";

        sellBtn.click();

        Assert.assertEquals("URL path is not as expected",expectedUrl, driver.getCurrentUrl().contains(expectedUrl));
    }

    @Test
    public void addItem(WebDriver driver){
        getSellPage();

        WebElement itemName = driver.findElement(By.xpath("//input[@placeholder='E.g. Maize']"));     

        itemName.sendKeys("Maize");

        WebElement itemDescription = driver.findElement(By.xpath("//input[@placeholder='your description']"));     
        
        itemDescription.sendKeys("White maize available on sale");

        WebElement itemQuantity = driver.findElement(By.xpath("//input[@placeholder='E.g.. 200']"));        

        itemQuantity.sendKeys("25");

        WebElement itemPrice = driver.findElement(By.xpath("//input[@placeholder='Enter amount']"));        

        itemPrice.sendKeys("40");

        WebElement prodDropDown = driver.findElement(By.xpath("//select[@id='productCategory']"));

        Select selectDropDown = new Select(prodDropDown);
        selectDropDown.selectByVisibleText("CEREALS");

        WebElement fileInput = driver.findElement(By.xpath("//input[@placeholder='imageName']"));
        String imagePath ="/home/mabera/Documents/FarmerConsumerSystem/src/main/webapp/images/barley.jpg";

        fileInput.sendKeys(imagePath);
        
    }

    @Test
    public void login() {
        driver.get("http://127.0.0.1:8080/farmer-system-app/login");

        driver.manage().window().maximize();

        // WebElement login =
        // driver.findElement(By.xpath("//a[normalize-space()='Login']"));

        // login.click();

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

        Assert.assertEquals(logoText, "Ukulima Bora");

        // perform more tests
        testLogin();

    }
}