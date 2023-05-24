import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App {
    public static void main(String[] args) throws Exception {
        //Run chrome driver (assuming chrome driver is used)
        String path = "C:\\Users\\ramya"; //change the path based on where chromedriver is placed in your system
        System.setProperty("webdriver.chrome.driver", path + "\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //Load the browser/ web page
        driver.get("https://thg-greenair.dev.wgv.onpier.de/onboarding");

        //Get the actual title and compare it with expected title
        String actualTitle = driver.getTitle();
        if(actualTitle.equals("THG Prämie"))
        {
            System.out.println("Title of the page is as expected");
        }
        else
        {
            System.out.println("Title of the page is not as expected");
        }

        //Wait until the page is loaded and verify the second step with text exists
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[@class ='black-custom custom-text-weight text-center'])[2]")));
        
        //Scroll the element Step 2 into view
        WebElement checkStepTwo = driver.findElement(By.xpath("(//p[@class ='black-custom custom-text-weight text-center'])[2]"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();", checkStepTwo);

        //Verify if second step with number and round in it exists
        Boolean twoWithRoundIcon = driver.findElement(By.xpath("(//div[contains(text(),'2')])[1]")).isDisplayed();
        if(twoWithRoundIcon == true)
        {
            System.out.println("Step Two is present on the screen with round icon");
        }
        else
        {
            System.out.println("Step Two is not present on the screen with round icon");
        }

        //Verify if Step 2 with round icon is clickable
        WebElement twoWithRoundIconClickable = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(text(),'2')])[1]")));
        try{
            twoWithRoundIconClickable.click();
            System.out.println("Step Two with round icon is a link and clickable");

        }
        catch(Exception E)
        {
            System.out.println("Step Two with round icon is not a link and not clickable");
        }
        

        //Verify if Step 2 with Text is clickable
        WebElement twoWithTextisClickable = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//p[@class ='black-custom custom-text-weight text-center'])[2]")));
        try{
            twoWithTextisClickable.click();
            System.out.println("Step Two with text is a link and clickable");
        }
        catch(Exception E)
        {
            System.out.println("Step Two with text is not a link and not clickable");
        }
        
        //Verify the text of step 2
        String stepTwoText = checkStepTwo.getText();
        if(stepTwoText.equals("Geben Sie Ihre persönlichen Daten ein."))
        {
            System.out.println("The text of step 2 is as expected");
        }
        else
        {
            System.out.println("The text of step 2 is not as expected");
        }
        
        driver.quit();   
    }

    
}