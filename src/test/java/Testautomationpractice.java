import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Testautomationpractice {
        WebDriver driver;
        @BeforeMethod
        public void TestPage(){
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://testautomationpractice.blogspot.com/");
        }
        @Test

    public void CheckGUIElements(){

            //Enter Name
            WebElement Name=driver.findElement(By.xpath("//input[@id='name']"));
            Name.sendKeys("Praveena");

            //Enter Email
            WebElement Email=driver.findElement(By.xpath("//input[@id='email']"));
            Email.sendKeys("Pree@gmail.com");

            //Enter Phone
            WebElement Phone= driver.findElement(By.xpath("//input[@id='phone']"));
            Phone.sendKeys("0761001236");

            //Enter Address

            WebElement Textarea=driver.findElement(By.xpath("//textarea[@id='textarea']"));
            Textarea.sendKeys("No:111/B,Thammita,Makevita");
        }
        @Test
        public void CheckRadioButtons(){
            WebElement RadioButton= driver.findElement(By.id("male"));
            RadioButton.click();
        }
        @Test
        public void CheckCheckBoxes(){
            WebElement Checkbox= driver.findElement(By.id("sunday"));
            Checkbox.click();
        }



}
