import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import java.util.ArrayList;

public class BookMyShowAutomation {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe"); // Set the path to your ChromeDriver

        WebDriver driver = new ChromeDriver();
        driver.get("https://in.bookmyshow.com/explore/home");

        Thread.sleep(5000);

        // Create a WebDriverWait instance
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Step 1: Select Bengaluru (wait until the element is visible)
        WebElement element = driver.findElement(By.xpath("//img[@alt='BANG']"));
        element.click();

        Thread.sleep(5000);

        // Step 2: Click on Sign In
        WebElement element1 = driver.findElement(By.xpath("//div[@class='bwc__sc-1nbn7v6-14 khhVFa']"));
        element1.click();

        Thread.sleep(5000);

        // Step 3: Click on Continue with Email
        WebElement element2 = driver.findElement(By.xpath("//div[contains(text(),'Continue with Email')]"));
        element2.click();

        Thread.sleep(5000);

        // Step 4: Enter email and click on continue
        WebElement emailInput = driver.findElement(By.xpath("//input[@id='emailId']"));
        emailInput.sendKeys("selauto1@mailsac.com");

        WebElement continueButton = driver.findElement(By.xpath("//button[normalize-space()='Continue']"));
        continueButton.click();

        // Open a new tab using JavaScript
        ((JavascriptExecutor) driver).executeScript("window.open('', '_blank');");

        // Switch to the new tab
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        // Step 5: Go to Yopmail.com
        driver.get("https://mailsac.com");

        // Sleep to allow the page to load, you can replace this with explicit waits
        Thread.sleep(5000);
        

        WebElement mailSacInput = driver.findElement(By.id("field_a1xtj"));
        mailSacInput.sendKeys("selauto1");
        
        WebElement mailSacEmailSubmit = driver.findElement(By.xpath("//button[normalize-space()='Check the mail!']"));
        mailSacEmailSubmit.click();
        
        Thread.sleep(8000);

        // Switch back to the original tab
        driver.switchTo().window(tabs.get(0));

        // Continue with the rest of your automation on the original tab
         WebElement inputElement = driver.findElement(By.cssSelector(".bwc_sc-m1rlyj-3.bwc_sc-rwpctr-0.eYLSMR"));

        WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(5));

     // Locate each input element by CSS selector and send keys to them
        String inputValues = "665512"; // Specify the input values
        WebElement parentDiv = driver.findElement(By.cssSelector(".bwc_sc-m1rlyj-3.bwc_sc-rwpctr-0.eYLSMR"));

        for (int i = 0; i < inputValues.length(); i++) {
            WebElement inputElement1 = parentDiv.findElement(By.cssSelector("input:nth-of-type(" + (i + 1) + ")"));
            inputElement1.sendKeys(String.valueOf(inputValues.charAt(i)));
        }
        
        WebElement submitOtp = driver.findElement(By.xpath("//button[normalize-space()='Continue']"));
        submitOtp.click();
        System.out.println("done.");
        
//        driver.quit();
    }
}