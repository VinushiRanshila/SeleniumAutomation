import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Testautomationpractice {
        WebDriver driver;
        @BeforeMethod
        public void TestPage(){
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://testautomationpractice.blogspot.com/");
        }
        @Test
  //Check  Textbox
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
        //Check radio button
        @Test
        public void CheckRadioButtons(){
            WebElement RadioButton= driver.findElement(By.id("male"));
            RadioButton.click();
        }
        //Check checkboxes
        @Test
        public void CheckCheckBoxes(){
            WebElement Checkbox= driver.findElement(By.id("sunday"));
            Checkbox.click();
        }

        //Check TestBox
    @Test
    public void checkTextBox(){
        WebElement TextBox= driver.findElement(By.id("textarea"));
        TextBox.sendKeys("No:111/B,Thammita,Makevita");

    }

  //Check Radio Buttons
    @Test
    public void CheckRadioButt(){
        WebElement RadioButton=  driver.findElement(By.id("male"));
        RadioButton.click();;
    }

    //Check Drop Down
    @Test
    public void CheckDropDown() throws InterruptedException {
        WebElement dropdown=   driver.findElement(By.xpath("//select[@id='country']"));
        Select select=new Select(dropdown);
        select.selectByIndex(1);
        Thread.sleep(3000);
        select.selectByIndex(3);
        Thread.sleep(3000);
        dropdown.sendKeys("china");

        WebElement Colors=driver.findElement(By.id("colors"));
        Select select1=new Select(Colors);
        select1.selectByIndex(1);
        Thread.sleep(3000);
        select1.selectByIndex(2);


        WebElement Animal=driver.findElement(By.id("animals"));
        Select select2=new Select(Animal);
        select2.selectByIndex(1);
        Thread.sleep(3000);
    }

    //Pick Date
    @Test
    public void PickDate() throws InterruptedException {
        WebElement DatePicker1 =   driver.findElement(By.xpath("//input[@id='datepicker']"));
        DatePicker1.sendKeys("10/10/2024");
        Thread.sleep(3000);
        WebElement DatePicker2=driver.findElement(By.id("txtDate"));
        DatePicker2.sendKeys("2023/10/23");


    }


}
