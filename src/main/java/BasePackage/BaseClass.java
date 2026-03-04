package BasePackage;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import Utils.Log;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	
	protected static WebDriver driver;
    protected Properties prop;
    public static Logger logger;
    
    
    @BeforeMethod
    public void setUp() {

        prop = new Properties();

        try {
            FileInputStream fis = new FileInputStream(
                    System.getProperty("user.dir")
                    + "/src/main/resources/PropertyFile/config.properties");

            prop.load(fis);

        } catch (Exception e) {
            e.printStackTrace();
        }

        String browser = prop.getProperty("browser");
        String url = prop.getProperty("url");
        int waitTime = Integer.parseInt(prop.getProperty("implicitWait"));
        Log.info("Launching browser");

        // Browser setup
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

           

        }

        // Browser settings
        driver.manage().window().maximize();
        driver.manage().timeouts()
              .implicitlyWait(Duration.ofSeconds(waitTime));

        // Launch application
        driver.get(url);
    }

 @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}
