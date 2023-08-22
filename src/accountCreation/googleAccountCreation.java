package accountCreation;

import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Map;
import java.util.TreeMap;

import dev.failsafe.internal.util.Assert;

public class googleAccountCreation {

  public static void main(String[] args) throws Exception {
        //Run chrome driver (assuming chrome driver is used)
        String path = System.getProperty("user.dir"); //get path of the project
        Properties props = new Properties();
        FileReader reader = new FileReader("src\\accountCreation\\testData.properties");
        props.load(reader);

        //Set chrome driver path and open chrome browser
        System.setProperty("webdriver.chrome.driver", path + "\\src\\resources\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Maximize the chrome browser
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Navigate to gmail
        driver.get(props.getProperty("URL"));

        //Verify the title of the page
        String title = driver.getTitle();
        String expectedTitle = "Gmail";
        Assert.isTrue(title.equals(expectedTitle), "Title is not as expected");
        
        //verify the google icon is present on the screen
        String pageTitle = xpath.staticPageTitle;
        if(driver.findElement(By.xpath(pageTitle)).isDisplayed());
        {
            System.out.println("the logo is displayed");
        }

        //Click on create account button
        String createAccount = xpath.staticCreateAccount;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(createAccount)));
        driver.findElement(By.xpath(createAccount)).click();
        reusableComponents.takeSnapShot(driver, "src\\accountCreation\\Screenshots\\screenShot1.png");

        String personalUse = xpath.staticPersonalUse;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(personalUse)));
        driver.findElement(By.xpath(personalUse)).click();
        reusableComponents.takeSnapShot(driver, "src\\accountCreation\\Screenshots\\screenShot2.png");

        //Enter first name
        String firstName = xpath.staticFirstName;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(firstName)));
        String firstNameString = reusableComponents.randomStringWithAlphabets(7);
        driver.findElement(By.id(firstName)).sendKeys(firstNameString);
        
        
        //Enter last name
        String lastName = xpath.staticLastName;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(lastName)));
        String lastNameString = reusableComponents.randomStringWithAlphabets(4);
        driver.findElement(By.id(lastName)).sendKeys(lastNameString);
        reusableComponents.takeSnapShot(driver, "src\\accountCreation\\Screenshots\\screenShot3.png");

        //Click on next
        String nextBtn = xpath.staticNextBtn;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(nextBtn)));
        driver.findElement(By.xpath(nextBtn)).click();
        

        //Enter the Date of Date of birth
        String dateDOB = xpath.staticDateDOB;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(dateDOB))); 
        String date = String.valueOf(reusableComponents.randomNumber(1,28));
        driver.findElement(By.xpath(dateDOB)).sendKeys(date);

        //Select month from dropdown
        String monthDOB = xpath.staticMonthDOB;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(monthDOB))); 
       Select monthDOBSelect = new Select(driver.findElement(By.xpath(monthDOB)));
       int monthDOBInt = reusableComponents.randomNumber(1,12);
       monthDOBSelect.selectByIndex(monthDOBInt); 

       //Enter the year
       String yearDOB = xpath.staticYearDOB;
       wait.until(ExpectedConditions.presenceOfElementLocated(By.id(yearDOB))); 
       String year = String.valueOf(reusableComponents.randomNumber(1990,2010));
       driver.findElement(By.id(yearDOB)).sendKeys(year);

       String DOB = date + "-" + monthDOBInt + "-" + year;

       //Select the gender from dropdown
       String genderXpath = xpath.staticGender;
       wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(genderXpath))); 
       Select gender = new Select(driver.findElement(By.xpath(genderXpath)));
       gender.selectByIndex(reusableComponents.randomNumber(1,3));
       reusableComponents.takeSnapShot(driver, "src\\accountCreation\\Screenshots\\screenShot4.png");

       //Click on next
       wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(nextBtn))); 
       driver.findElement(By.xpath(nextBtn)).click();


        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath.staticLogo)));

        String radioBtnXpath = xpath.staticSelectGmailAdressRadioBtn;
        int isCorrect = driver.findElements(By.xpath(radioBtnXpath)).size();
        String emailAddress;
        if(isCorrect>0)
        {
          //Click on the first radio button and select the gmail account ID
          wait.until(ExpectedConditions.elementToBeClickable(By.xpath(radioBtnXpath)));
          WebElement radioBtn = driver.findElement(By.xpath(radioBtnXpath));
          radioBtn.click();
          emailAddress = radioBtn.getAttribute("data-value") + "@gmail.com" ;
          
        }
        else
        {
            //Enter usename of your selection
            String EnterGmailAddress = xpath.staticEnterGmailAddress;
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(EnterGmailAddress)));
            String emailAddress1 = reusableComponents.randomAlphanumericString(10);
            driver.findElement(By.xpath(EnterGmailAddress)).sendKeys(emailAddress1);
            emailAddress = emailAddress1 + "@gmail.com";
        }

        reusableComponents.takeSnapShot(driver, "src\\accountCreation\\Screenshots\\screenShot5.png");
        //Click on next
          wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(nextBtn))); 
          driver.findElement(By.xpath(nextBtn)).click();

          //Enter the Password
          String Password = reusableComponents.randomAlphanumericString(10);
          driver.findElement(By.xpath(xpath.staticEnterPassword)).sendKeys(Password);
          driver.findElement(By.xpath(xpath.staticEnterPasswordAgain)).sendKeys(Password);

          reusableComponents.takeSnapShot(driver, "src\\accountCreation\\Screenshots\\screenShot6.png");

          //Click on next
          String nextBtnPasswordPage = xpath.staticNextBtnPasswordPage;
          wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(nextBtnPasswordPage)));         
          driver.findElement(By.xpath(nextBtnPasswordPage)).click();

          // To write to an excel sheet
          Map<String, Object[]> userDetailsMap = new TreeMap<String, Object[]>();
          userDetailsMap.put("1", new Object[]{"First Name", "Last Name", "Date of Birth", "Email Address" , "Password"});
          userDetailsMap.put("2", new Object[]{firstNameString, lastNameString, DOB, emailAddress, Password});
          String sheetName = "User Details";
          reusableComponents.writeToExcel(sheetName, userDetailsMap);

          //Close current chrome window
          driver.close();
          


  }  
    
}
