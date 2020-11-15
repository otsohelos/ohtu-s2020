package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {

    public static void main(String[] args) {
        //WebDriver driver = new ChromeDriver();
        WebDriver driver = new HtmlUnitDriver();

        driver.get("http://localhost:4567");
        System.out.println(driver.getPageSource());

        // test pekka-appek login
//        WebElement element = driver.findElement(By.linkText("login"));
//        element.click();
//        System.out.println(driver.getPageSource());
//
//
//        element = driver.findElement(By.name("username"));
//        element.sendKeys("pekka");
//        element = driver.findElement(By.name("password"));
//        element.sendKeys("akkep");
//        element = driver.findElement(By.name("login"));
//
//        element.submit();
//        System.out.println(driver.getPageSource());
        // test wrong password login 
//        WebElement element = driver.findElement(By.linkText("login"));
//        element.click();
//        System.out.println(driver.getPageSource());
//
//        element = driver.findElement(By.name("username"));
//        element.sendKeys("pekka");
//        element = driver.findElement(By.name("password"));
//        element.sendKeys("wrong");
//        element = driver.findElement(By.name("login"));
//
//        element.submit();
//        System.out.println(driver.getPageSource());
        // test user creation and logout
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
        System.out.println(driver.getPageSource());

        element = driver.findElement(By.name("username"));
        element.sendKeys("kyllikki");
        element = driver.findElement(By.name("password"));
        element.sendKeys("ikkillyk");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("ikkillyk");
        element = driver.findElement(By.name("signup"));
        element.click();
        System.out.println(driver.getPageSource());

        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        element = driver.findElement(By.linkText("logout"));
        element.click();

        System.out.println(driver.getPageSource());
        driver.quit();
    }

    private static void sleep(int n) {
        try {
            Thread.sleep(n * 1000);
        } catch (Exception e) {
        }
    }
}
