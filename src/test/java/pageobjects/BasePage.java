package pageobjects;

import java.io.File;
import java.io.IOException;
import HelperClasses.BasePageHelper;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import reports.ExtentManager;

import com.aventstack.extentreports.ExtentReports;

import java.io.InputStream;
import java.time.Duration;
import java.time.Month;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static utils.Constants.*;

public class BasePage extends BasePageHelper {

    public static SoftAssertions softAssert = null;
    public static WebDriver driver = null;
    public static WebDriverWait wait = null;
    public static  ExtentReports  reports = null;
    public static ExtentTest scenario = null;

    public static WebDriver initializeDriver() {
        String os = System.getProperty("os.name").toLowerCase();

        String browserName=null;
        try {
            InputStream input = BasePageHelper.class.getClassLoader().getResourceAsStream("config/paths.properties");

            Properties prop = new Properties();

            prop.load(input);

            browserName=  prop.getProperty("browser");
            if(browserName.equalsIgnoreCase("Mozilla")){
                if (os.contains("win")){
                    System.setProperty("webdriver.gecko.driver", FIREFOX_DRIVER_EXE_WINDOWS);
                }
                else if (os.contains("mac")){
                    System.setProperty("webdriver.gecko.driver", FIREFOX_DRIVER_EXE_MAC);
                }
                driver = new FirefoxDriver();
                driver = new FirefoxDriver(loadFirefoxOptions());

            }
            else if(browserName.equals("Chrome")){
                if (os.contains("win")){
                    System.setProperty("webdriver.chrome.driver",CHROME_DRIVER_EXE_WINDOWS);
                }
                else if (os.contains("mac")){
                    System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_EXE_MAC);
                }
                driver= new ChromeDriver(loadChromeOptions());
            }

            driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
            driver.manage().window().maximize();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return driver;

    }

    public static void generateReport(String scenarioName){
        reports = ExtentManager.getInstance(REPORTS_PATH);
        scenario = reports.createTest(scenarioName);

    }
    public static void flushReports(){
        if(reports!=null)
            reports.flush();
    }

public void infoLog(String message){
        scenario.log(Status.INFO, message);
}

public void failureLog(String errorMessage){
    scenario.log(Status.FAIL, errorMessage);
    takeSceenShot();

}

    public void takeSceenShot(){
        // fileName of the screenshot
        Date d=new Date();
        String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
        // take screenshot
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            // get the dynamic folder name
            FileUtils.copyFile(srcFile, new File(ExtentManager.screenshotFolderPath+screenshotFile));
            //put screenshot file in reports
            scenario.log(Status.FAIL,"Screenshot-> "+ scenario.addScreenCaptureFromPath(ExtentManager.screenshotFolderPath+screenshotFile));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public static int getMonthNumber(String monthName) {
        return Month.valueOf(monthName.toUpperCase()).getValue();
    }

    public static WebDriverWait explicitWait(){
        wait  = new WebDriverWait(driver , 30);
        return wait;
    }
    }
