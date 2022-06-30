
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Registration {
    private WebDriver driver;
    private By firstName= By.id("vfb-5");
    private By lastName=By.id("vfb-7");
    private By maleGender=By.id("vfb-8-1");
    private By femaleGender=By.id("vfb-8-2");
    private By address=By.id("vfb-13-address");
    private By streetAddress=By.id("vfb-13-address-2");
    private By city=By.id("vfb-13-zip");
    private By region=By.id("vfb-13-state");
    private By apt=By.id("vfb-13-city");
    private By country=By.id("vfb-13-country");
    private By email=By.id("vfb-14");
    private By mobile=By.id("vfb-19");
    private By bioQuery=By.id("vfb-23");
    private By verification=By.id("vfb-3");
    private By hour=By.id("vfb-16-hour");
    private By minute=By.id("vfb-16-min");
    private By dateClicker=By.id("vfb-18");
    private By month=By.cssSelector(".ui-datepicker-month");
    private By year=By.cssSelector(".ui-datepicker-year");
    private By nextBtn=By.cssSelector("a[title='Next']>span");
    private By days=By.cssSelector("table.ui-datepicker-calendar>tbody>tr>td>a");
    private By courses=By.cssSelector("input[type='checkbox']");
    private By submitBtn=By.id("vfb-4");
    private By verifyRegisterMsg=By.cssSelector("div[data-id='2e9cde64']>div>div");


    public Registration(WebDriver driver){
        this.driver=driver;
    }
    private WebElement getElement(By locator){
        WebElement element=null;
        try{
            element=driver.findElement(locator);
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }return element;
    }
    private List<WebElement> getElements(By locator){
        List<WebElement>list=null;
        try{
            list=driver.findElements(locator);
        }catch (NoSuchElementException e){
            e.printStackTrace();

        }return list;
    }
    private void setMaleGender(){
        getElement(maleGender).click();
    }
    private void setFemaleGender(){
        getElement(femaleGender).click();
    }
    private Select getSelect(By locator){
        Select select=new Select(getElement(locator));
        return select;
    }
    public void setFirstName(String value){
        getElement(firstName).sendKeys(value);
    }
    public void setLastName(String value){
        getElement(lastName).sendKeys(value);
    }
    public void setAddress(String value){
        getElement(address).sendKeys(value);
    }
    public void setStreetAddress(String value){
        getElement(streetAddress).sendKeys(value);
    }
    public void setApt(String value){
        getElement(apt).sendKeys(value);
    }

    public void setGender(String value){
        if(value.equalsIgnoreCase("M")){
            setMaleGender();
        }else if(value.equalsIgnoreCase("F")){
            setFemaleGender();
        }else{
            System.out.println("Gender is not set");
        }
    }
    public void setRegion(String value){
        getElement(region).sendKeys(value);
    }
    public void setCity(String value){
        getElement(city).sendKeys(value);
    }
    public void setCountry(String value){
        getSelect(country).selectByVisibleText(value);
    }
    public void setEmail(String value){
        getElement(email).sendKeys(value);
    }
    public void setTime(String h,String m){
        getSelect(hour).selectByValue(h);
        getSelect(minute).selectByValue(m);
    }
    public void setMobile(String value){
        getElement(mobile).sendKeys(value);
    }
    public void setBioQuery(String value){
        getElement(bioQuery).sendKeys(value);
    }
    public void setVerification(String value){
        getElement(verification).sendKeys(value);
    }
    public void setSubmitBtn(){
        getElement(submitBtn).click();
    }
    public boolean verifyRegisterSuccessMsg(){
        WebElement element=getElement(verifyRegisterMsg);
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(element));
        if(element.isDisplayed()){
            return true;
        }
        else{
            return false;
        }
    }
    public void setDate(String year,String month,String day){
        getElement(dateClicker).click();
        while(true){
            String mo=getElement(this.month).getText();
            String yr=getElement(this.year).getText();
            if(mo.equalsIgnoreCase(month) && yr.equalsIgnoreCase(year)){
                break;
            }
            else{
                getElement(nextBtn).click();
            }

        }
        List<WebElement>d=getElements(this.days);
        for(WebElement element:d){
            if(element.getText().equalsIgnoreCase(day)){
                element.click();
                break;
            }
        }
    }
    public void setCourses(String ...str){
        List<WebElement>list=getElements(courses);
        if(!str[0].equalsIgnoreCase("All")){
            for(WebElement element:list){
                String s=element.getAttribute("Value");
                for(String st:str){
                    if(s.equalsIgnoreCase(st)){
                        element.click();
                        break;
                    }
                }
            }
        }else{
            for(WebElement element:list){
                element.click();
            }
        }

    }



}