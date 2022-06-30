import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Browser {
    private static WebDriver driver;
    public static WebDriver invokeBrowser(){
        try{
            driver= WebDriverManager.chromedriver().create();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        }catch (Exception e){
            e.printStackTrace();
        }return driver;
    }
}
