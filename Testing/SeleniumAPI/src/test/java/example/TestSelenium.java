package example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSelenium {
    private static int getTemperature() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\danie\\Desktop\\Backpacker-Documentation\\trunk\\Testing\\SeleniumAPI\\src\\test\\java\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().setSize(new Dimension(1265, 1372));
        driver.findElement(By.xpath("//*[@id=\"W0wltc\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/textarea")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/textarea")).sendKeys("Meteo Roma");
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/textarea")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        WebElement value = driver.findElement(By.xpath("/html/body/div[6]/div/div[10]/div/div[2]/div[2]/div/div/div[1]/div/div/div/div/div[1]/div[1]/div/div[1]/span[1]"));
        int res = Integer.parseInt(value.getText());
        System.out.println(res);
        driver.close();
        return res;
    }

    @Test
    public void testTemperature() throws InterruptedException {
        int temp = getTemperature();
        if(temp > 25){
            System.out.println("The temperature is very high. It is advisable to stay in cool places.");
        }
        assertTrue(temp > 25);
    }
}