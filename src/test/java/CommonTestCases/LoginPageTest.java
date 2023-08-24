package CommonTestCases;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static BasicUtils.TestngAnnotatedMethods.extentReports;
import static BasicUtils.TestngAnnotatedMethods.extentTest;

public class LoginPageTest {


    @Test
    public void b(){
        extentTest = extentReports.createTest("Sample").assignAuthor("Anbu");
        System.out.println("B");
    }

}
