package BasicUtils;

import BasePackage.BaseClassCTS;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;


public class TestngAnnotatedMethods extends BaseClassCTS {

    public static ExtentReports extentReports;
    public static ExtentSparkReporter sparkReporter;
    public static ExtentTest extentTest;
    WebDriverWait wait;
    HomePage homePage;
    LoginPage loginPage;

    @Parameters({"browser"})
    @BeforeSuite
    public void initializeTestSuite(String browser) throws IOException, InterruptedException {
        launchApplication(browser);
    }

    @Parameters({"currentUser"})
    @BeforeTest
    public void startTest(String user){

        loginPage = new LoginPage(driver);
        String id="",pwd="";

        if(user.equalsIgnoreCase("productionManager")){
            id=prop1.getProperty("ProductionManagerId");
            pwd=prop1.getProperty("ProductionManagerPwd");
        }
        else if (user.equalsIgnoreCase("projectManager")) {
            id=prop1.getProperty("ProjectManagerId");
            pwd=prop1.getProperty("ProjectManagerPwd");
        }
        else if (user.equalsIgnoreCase("AssistantManager")) {
            id=prop1.getProperty("AssistantManagerId");
            pwd=prop1.getProperty("AssistantManagerPwd");
        }
        else if (user.equalsIgnoreCase("graphicsUser")) {
            id=prop1.getProperty("GraphicsUserId");
            pwd=prop1.getProperty("GraphicsUserPwd");
        }
        else if (user.equalsIgnoreCase("graphicsTL")) {
            id=prop1.getProperty("GraphicsTlId");
            pwd=prop1.getProperty("GraphicsTlPwd");
        }
        else if (user.equalsIgnoreCase("tcUser")) {
            id=prop1.getProperty("TCUserId");
            pwd=prop1.getProperty("TCUserPwd");
        }
        else if (user.equalsIgnoreCase("tcTl")) {
            id=prop1.getProperty("TCTlId");
            pwd=prop1.getProperty("TCTlPwd");
        }
        else if (user.equalsIgnoreCase("peUser")) {
            id=prop1.getProperty("PEUserId");
            pwd=prop1.getProperty("PEUserPwd");
        }
        else if (user.equalsIgnoreCase("peTl")) {
            id=prop1.getProperty("PETlId");
            pwd=prop1.getProperty("PETlPwd");
        }
        else if (user.equalsIgnoreCase("qcUser")) {
            id=prop1.getProperty("QCUserId");
            pwd=prop1.getProperty("QCUserPwd");
        }
        else if (user.equalsIgnoreCase("qcTl")) {
            id=prop1.getProperty("QCTlId");
            pwd=prop1.getProperty("QCTlPwd");
        }
        else if (user.equalsIgnoreCase("qaUser")) {
            id=prop1.getProperty("QAUserId");
            pwd=prop1.getProperty("QAUserPwd");
        }
        else if (user.equalsIgnoreCase("qaTl")) {
            id=prop1.getProperty("QATlId");
            pwd=prop1.getProperty("QATlPwd");
        }
        else if (user.equalsIgnoreCase("tsmUser")) {
            id=prop1.getProperty("TSMUserId");
            pwd=prop1.getProperty("TSMUserPwd");
        }
        else if (user.equalsIgnoreCase("tsmTl")) {
            id=prop1.getProperty("TSMTlId");
            pwd=prop1.getProperty("TSMTlPwd");
        }
        else {
            Assert.fail("Please provide valid User:!!!");
        }


        loginPage.loginToApplication(id, pwd);

        extentReports = new ExtentReports();
        sparkReporter = new ExtentSparkReporter("Generated HTML Report (for "+user+").html");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setReportName("CTS Application Test Report"); //Displayed inside Document
        sparkReporter.config().setDocumentTitle("Automation Test Report"); //Displayed in Browser tab
        extentReports.attachReporter(sparkReporter);

    }

    @AfterTest
    public void closeTest() {
        homePage = new HomePage(driver);
        homePage.logoutUser();
    }

    @AfterSuite
    public void closeSuite(){
        extentReports.flush();
        driver.quit();
    }


}
