package lambda_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Test1 {

    @Test
    public void enterForm(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remove-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.lambdatest.com/selenium-playground");
        WebElement inputForm= driver.findElement(By.linkText("Input Form Submit"));
        inputForm.click();
        WebElement name = driver.findElement(By.xpath("//input[@id='name']"));
        name.sendKeys("Darya");
        WebElement email = driver.findElement(By.xpath("//input[@id='inputEmail4']"));
        email.sendKeys("dar200490@gmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@id='inputPassword4']"));
        password.sendKeys("123648darya");
        WebElement company = driver.findElement(By.xpath("//input[@id='company']"));
        company.sendKeys("CodeFish");
        WebElement website = driver.findElement(By.xpath("//input[@id='websitename']"));
        website.sendKeys("www.codefish.com");
        WebElement country = driver.findElement(By.xpath("//option[@value='US']"));
        company.click();
        WebElement city = driver.findElement(By.xpath("//input[@id='inputCity']"));
        city.sendKeys("Feasterville");
        WebElement address1 = driver.findElement(By.xpath("//input[@id='inputAddress1']"));
        address1.sendKeys("238 Sycamore Cir");
        WebElement address2 = driver.findElement(By.xpath("//input[@id='inputAddress2']"));
        address2.sendKeys("238 Sycamore cir");
        WebElement state = driver.findElement(By.xpath("//input[@id='inputState']"));
        state.sendKeys("PA");
        WebElement zipCode = driver.findElement(By.xpath("//input[@id='inputZip']"));
        zipCode.sendKeys("19053");
        List<WebElement> allButtons = driver.findElements(By.cssSelector("button[type='submit']"));
        for(int i=0; i<allButtons.size();i++){
            if(allButtons.get(i).getText().equalsIgnoreCase("submit")){
               allButtons.get(i).click();
            }

        }
        List<WebElement> allMessages = driver.findElements(By.xpath("//p"));
        for(int i = 0; i< allMessages.size(); i++){
            if(allMessages.get(i).getText().contains("Thanks")){
                System.out.println(allMessages.get(i).getText());
                Assert.assertTrue(allMessages.get(i).isDisplayed());
            }
        }

    }
}
