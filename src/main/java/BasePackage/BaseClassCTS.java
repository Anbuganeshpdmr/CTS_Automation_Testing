package BasePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClassCTS {

    public static WebDriver driver,driver_user_1,driver_user_2,driver_user_3;

    public static WebDriverWait wait;

    public static Properties prop1;

    public static void launchApplication(String browser) throws IOException {
        FileInputStream file = new FileInputStream("src/main/resources/credential.properties");
        prop1 = new Properties();
        prop1.load(file);
        file.close();

        if(browser.contains("chrome")){
            driver = new ChromeDriver();
        } else if (browser.contains("edge")) {
            driver = new EdgeDriver();
        } else if (browser.contains("firefox")) {
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.get(prop1.getProperty("url"));
    }

    public static void reloadDashboard(){
        driver.get(prop1.getProperty("dashboardURL"));
    }
}
