import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OpenGoogle {

         @Test
         public void TestPage(){
         WebDriver driver=new ChromeDriver();
         driver.manage().window().maximize();
         driver.get("https://www.google.com/");
     }
}
