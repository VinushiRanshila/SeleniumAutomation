import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class Testautomationpractice {
    WebDriver driver;

    @BeforeMethod
    public void TestPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
    }

    @Test
    //Check  Textbox
    public void CheckGUIElements() {

        //Enter Name
        WebElement Name = driver.findElement(By.xpath("//input[@id='name']"));
        Name.sendKeys("Praveena");

        //Enter Email
        WebElement Email = driver.findElement(By.xpath("//input[@id='email']"));
        Email.sendKeys("Pree@gmail.com");

        //Enter Phone
        WebElement Phone = driver.findElement(By.xpath("//input[@id='phone']"));
        Phone.sendKeys("0761001236");

        //Enter Address

        WebElement Textarea = driver.findElement(By.xpath("//textarea[@id='textarea']"));
        Textarea.sendKeys("No:111/B,Thammita,Makevita");
    }

    //Check radio button
    @Test
    public void CheckRadioButtons() {
        WebElement RadioButton = driver.findElement(By.id("male"));
        RadioButton.click();
    }

    //Check checkboxes
    @Test
    public void CheckCheckBoxes() {
        WebElement Checkbox = driver.findElement(By.id("sunday"));
        Checkbox.click();
    }

    //Check TestBox
    @Test
    public void checkTextBox() {
        WebElement TextBox = driver.findElement(By.id("textarea"));
        TextBox.sendKeys("No:111/B,Thammita,Makevita");

    }

    //Check Radio Buttons
    @Test
    public void CheckRadioButt() {
        WebElement RadioButton = driver.findElement(By.id("male"));
        RadioButton.click();
        ;
    }

    //Check Drop Down
    @Test
    public void CheckDropDown() throws InterruptedException {
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='country']"));
        Select select = new Select(dropdown);
        select.selectByIndex(1);
        Thread.sleep(3000);
        select.selectByIndex(3);
        Thread.sleep(3000);
        dropdown.sendKeys("china");

        WebElement Colors = driver.findElement(By.id("colors"));
        Select select1 = new Select(Colors);
        select1.selectByIndex(1);
        Thread.sleep(3000);
        select1.selectByIndex(2);


        WebElement Animal = driver.findElement(By.id("animals"));
        Select select2 = new Select(Animal);
        select2.selectByIndex(1);
        Thread.sleep(3000);
    }

    //Pick Date
    @Test
    public void PickDate() throws InterruptedException {
        WebElement DatePicker1 = driver.findElement(By.xpath("//input[@id='datepicker']"));
        DatePicker1.sendKeys("10/10/2024");
        Thread.sleep(3000);
        WebElement DatePicker2 = driver.findElement(By.id("txtDate"));
        DatePicker2.sendKeys("2023/10/23");
    }

    //Upload File
    @Test
    public void uploadFile() {
        String path = ("C:\\Users\\vinushi\\Downloads\\flower.jpg");
        WebElement uploadFile = driver.findElement(By.id("singleFileInput"));
        uploadFile.sendKeys(path);
    }

    //Upload MultipleFiles
    @Test
    public void UploadMultipleFile() {
        String path1 = ("C:\\Users\\vinushi\\Downloads\\flower.jpg");
        String path2 = ("C:\\Users\\vinushi\\Downloads\\flower1.jpg");
        String path3 = ("C:\\Users\\vinushi\\Downloads\\flower2.jpg");
        WebElement UploadMultipleFiles = driver.findElement(By.id("multipleFilesInput"));
        UploadMultipleFiles.sendKeys(path1 + "\n" + path2 + "\n" + path3);
    }

    //Test Static Table
    @Test
    public void TestStaticTable() {
        int HeadsCount = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr/th")).size();
        System.out.println("Number of TableHeads : " + HeadsCount);

        String TableValue = driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr[2]/td[3]")).getText();
        System.out.println("Value is: " + TableValue);

        //Row Count in table
        int RowCount = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr")).size();
        System.out.println("Number of Rows: " + RowCount);

        //Column Count in the table
        int ColumnCount = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr/th")).size();
        System.out.println("Column Count is " + ColumnCount);
    }

    //Pagination WebTable
    @Test
    public void paginationTable() throws InterruptedException {
        int Pagitabcolumns = driver.findElements(By.xpath("//table[@id='productTable']/thead/tr/th")).size();
        System.out.println("Number of Table Columns: " + Pagitabcolumns);

        int Pagitabrows = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr")).size();
        System.out.println("Number of Rows :  " + Pagitabrows);


        //Retrieve all the data from table

        for (int i = 1; i < Pagitabrows; i++) {//rows
            for (int j = 1; j < Pagitabcolumns; j++) {
                String tbldata = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[" + i + "]/td[" + j + "]")).getText();
                System.out.println(tbldata + " ");
            }
            System.out.println();
        }

        //Print id and name

        for (int i = 1; i <= Pagitabrows; i++) {
            String TableId = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[" + i + "]/td[1]")).getText();
            String ProductName = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[" + i + "]/td[2]")).getText();
            System.out.println("Table id : " + TableId + "Product Name is: " + ProductName);

            if (ProductName.equals("Product 3")) {
                String productPrice = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[" + i + "]/td[3]")).getText();
                System.out.println(ProductName + " Price is : " + productPrice);
                break;
            }

        }

        //Select All checkBoxes
        int pagecount = driver.findElements(By.xpath("//ul[@id='pagination']/li")).size();
        List<WebElement> pages = driver.findElements(By.xpath("//ul[@id='pagination']/li"));

        for (int k = 0; k < pagecount; k++) {
            pages.get(k).click();
            Thread.sleep(1000);
            for (int i = 1; i <= Pagitabcolumns; i++) {
                boolean att = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[" + i + "]/td[4]/input")).isSelected();
                if (!att) {
                    driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[" + i + "]/td[4]/input")).click();
                    Thread.sleep(3000);
                }
            }
        }
    }

    //Test Dynamic Table
    @Test
    public void TestDynamicWebTable() {
        WebElement webTable = driver.findElement(By.xpath("//table[@id='taskTable']"));
        List<WebElement> rows = webTable.findElements(By.tagName("tr"));
        int rowcount = rows.size();
        for (int i = 0; i < rowcount; i++) {
            List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
            int columcount = columns.size();

            for (int j = 0; j < columcount; j++) {
                String cellText = columns.get(j).getText();
                if (cellText.equals("Chrome")) {
                    System.out.println("CPU load of Chrome process : " + columns.get(2).getText());
                }
                if (cellText.equals("Firefox")) {
                    System.out.println("Memory Size of Firefox process: " + columns.get(1).getText());
                }
                if (cellText.equals("Chrome")) {
                    System.out.println("Network speed of chrome process : " + columns.get(1).getText());
                }
                if (cellText.equals("Firefox")) {
                    System.out.println("Disk Space of Firefox process: " + columns.get(1).getText());

                }
            }
        }
    }

    //Test The Form
    @Test
    public void TestForm() throws InterruptedException {
        WebElement Section1 = driver.findElement(By.xpath("//input[@id='input1']"));
        Section1.sendKeys("Hello World!!!!!!");
        WebElement Btn1 = driver.findElement(By.xpath("//button[@id='btn1']"));
        Btn1.click();
        Thread.sleep(3000);

        WebElement Section2 = driver.findElement(By.xpath("//input[@id='input2']"));
        Section2.sendKeys("Hello!! How are You?");
        WebElement Btn2 = driver.findElement(By.xpath("//button[@id='btn2']"));
        Btn2.click();
        Thread.sleep(3000);


        WebElement Section3 = driver.findElement(By.xpath("//input[@id='input3']"));
        Section3.sendKeys("Hello!! My name is Ann. What is your name?");
        WebElement Btn3 = driver.findElement(By.xpath("//button[@id='btn3']"));
        Btn3.click();
    }


    ////Test Footer Link////
    //1.Home Link
    @Test
    public void TestFooterLink() throws InterruptedException {
        WebElement HomeLink = driver.findElement(By.linkText("Home"));
        HomeLink.click();
        Thread.sleep(3000);

    }

    //2.Hidden Elements Ajax//
    //2.1Test Input Box
    @Test
    public void TestInputBox() {
        WebElement HiddenElements = driver.findElement(By.linkText("Hidden Elements & AJAX"));
        HiddenElements.click();
        WebElement InputBox1 = driver.findElement(By.xpath(" //input[@id='input1']"));
        InputBox1.sendKeys("Hello World!!");
        WebElement ToggleInputBox2 = driver.findElement(By.xpath("//button[@id='toggleInput']"));
        ToggleInputBox2.click();
        WebElement InputBox2 = driver.findElement(By.xpath("//input[@id='input2']"));
        InputBox2.sendKeys("Hello World!! Hello!!");
        WebElement LoadStatus = driver.findElement(By.xpath("//span[@id='statusLabel']"));
        String ShowStatus = LoadStatus.getText();
        System.out.println("Status is " + ShowStatus);
        WebElement GoHome = driver.findElement(By.linkText("Home"));
        GoHome.click();
    }

    //2.2Test Toggle CheckBox
    @Test
    public void TestToggleCheckBox() {
        WebElement HiddenElements = driver.findElement(By.linkText("Hidden Elements & AJAX"));
        HiddenElements.click();
        WebElement CheckBox1 = driver.findElement(By.xpath("//input[@id='checkbox1']"));
        if (!CheckBox1.isSelected()) {
            CheckBox1.click();
        }
        WebElement ToggleCheckBox = driver.findElement(By.xpath("//button[@id='toggleCheckbox']"));
        ToggleCheckBox.click();
        WebElement Checkbox2 = driver.findElement(By.xpath("//input[@id='checkbox2']"));
        if (!Checkbox2.isSelected()) {
            Checkbox2.click();
        }

        WebElement LoadStatus = driver.findElement(By.xpath("//span[@id='statusLabel']"));
        String ShowStatus = LoadStatus.getText();
        System.out.println("Status is " + ShowStatus);
        WebElement GoHome = driver.findElement(By.linkText("Home"));
        GoHome.click();

    }

    //2.3Test Content Load
    @Test
    public void TestContentLoad() throws InterruptedException {
        WebElement HiddenElements = driver.findElement(By.linkText("Hidden Elements & AJAX"));
        HiddenElements.click();
        WebElement LoadContentButton = driver.findElement(By.xpath("//button[@id='loadContent']"));
        LoadContentButton.click();
        Thread.sleep(3000);
        WebElement LoadStatus = driver.findElement(By.xpath("//span[@id='statusLabel']"));
        String ShowStatus = LoadStatus.getText();
        System.out.println("Status is " + ShowStatus);
        WebElement GoHome = driver.findElement(By.linkText("Home"));
        GoHome.click();
    }


    //3.Download Files//
    @Test
    public void DownloadFile() {
        WebElement DownloadFiles = driver.findElement(By.linkText("Download Files"));
        DownloadFiles.click();
        WebElement TextArea = driver.findElement(By.xpath("//textarea[@id='inputText']"));
        TextArea.sendKeys("Hello World!!!!");
        WebElement GenerateDownloadTextFile1 = driver.findElement(By.xpath("//button[@id='generateTxt']"));
        GenerateDownloadTextFile1.click();
        WebElement TextDownloadLink=driver.findElement(By.xpath("//a[@id='txtDownloadLink']"));
        TextDownloadLink.click();
        WebElement GenerateandDownloadPdfFile2= driver.findElement(By.xpath("//[@id='generatePdf']"));
        GenerateandDownloadPdfFile2.click();
        WebElement DownloadPdfFIle= driver.findElement(By.xpath("//a[@id='pdfDownloadLink']"));
        DownloadPdfFIle.click();
    }

    //Test Tabs
    @Test
    public void TestWekipedia() throws InterruptedException {
        WebElement SearchBar= driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']"));
        SearchBar.sendKeys("Colombo");
        Thread.sleep(3000);



        List<WebElement> searchResults = driver.findElements(By.xpath("//*[@id='Wikipedia1_wikipedia-search-results']"));
        for (WebElement result : searchResults) {
            if (result.getText().equals("Colombo")) {
                result.click();
                break;
            }
        }


        }


        //Test Alerts & Popups
    @Test
    public void TestAlerts() throws InterruptedException {

        //1.Simple Alert
        WebElement AlertBox=  driver.findElement(By.xpath("//button[@id='alertBtn']"));
        AlertBox.click();
        Alert alert=driver.switchTo().alert();
        Thread.sleep(3000);
        alert.accept();


        //Confirmation Alert
        WebElement ConfirmationAlert= driver.findElement(By.xpath("//button[@id='confirmBtn']"));
        ConfirmationAlert.click();
        Alert conAlert=  driver.switchTo().alert();
        Thread.sleep(3000);
        conAlert.dismiss();

        //prompt Alert
        WebElement PromptAlert=driver.findElement(By.xpath("//button[@id='promptBtn']"));
        PromptAlert.click();
        Alert proAlert=driver.switchTo().alert();
        Thread.sleep(3000);
        String AlertText= proAlert.getText();
        System.out.println("Alert text is : " + AlertText );
        proAlert.sendKeys("Annn Perera");
        proAlert.accept();

    }
    @Test
//Drag and Drop
    public void TestDragandDrop(){
        Actions actions=new Actions(driver);
        WebElement From=driver.findElement(By.id("draggable"));
        WebElement To=driver.findElement(By.id("droppable"));
        actions.dragAndDrop(From,To).perform();
    }



    }


































