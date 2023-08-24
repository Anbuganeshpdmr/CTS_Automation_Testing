package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void loginToApplication(String id, String pwd){

        WebElement userBox = driver.findElement(By.xpath("//*[@placeholder='Emp ID']"));
        WebElement passwordBox = driver.findElement(By.xpath("//*[@placeholder='Password']"));
        WebElement loginBtn = driver.findElement(By.xpath("//*[text()='Sign In']"));

        userBox.clear();
        userBox.sendKeys(id);
        passwordBox.clear();
        passwordBox.sendKeys(pwd);
        loginBtn.click();
    }
}
