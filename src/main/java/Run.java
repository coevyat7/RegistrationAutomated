import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class Run {

        public static void main(String[] args) {
            WebDriver driver= Browser.invokeBrowser();
            Registration rp=new Registration(driver);
            driver.get("https://nxtgenaiacademy.com/demo-site/");
            driver.manage().window().maximize();
            rp.setFirstName("user");
            rp.setLastName("random");
            rp.setGender("M");
            rp.setAddress("Area 1");
            rp.setStreetAddress("street 1");
            rp.setApt("Apt 1 Enter B");
            rp.setRegion("Center City");
            rp.setCity("Tel Aviv");
            rp.setCountry("Israel");
            rp.setEmail("a1b1@xyz.com");
            rp.setDate("2024","November","7");
            rp.setTime("17","45");
            rp.setMobile("0501234567");
            rp.setCourses("Selenium WebDriver","TestNG","Core Java");
            rp.setBioQuery("Hey I'm Automation Tester");
            rp.setVerification("77");
            rp.setSubmitBtn();
            boolean registerSuccess=rp.verifyRegisterSuccessMsg();
            System.out.println("Registration Success: "+registerSuccess);


        }
    }

