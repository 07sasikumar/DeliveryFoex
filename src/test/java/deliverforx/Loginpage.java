package deliverforx;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Loginpage {
    public static void main(String[] args) {
        // Initialize the FirefoxDriver
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://deliveryforx.trymydemo.com/merchant-login");
        
        // Find email, password fields, and login button
        WebElement email = driver.findElement(By.xpath("//*[@id=\"mer_email\"]"));
        WebElement pass = driver.findElement(By.xpath("//*[@id=\"mer_pass\"]"));
        WebElement login = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div/form/input[2]"));
        
        // Get and print the page title before login
        String titleBeforeLogin = driver.getTitle();
        System.out.println("Title before login: " + titleBeforeLogin);
        
        // Perform login by entering credentials and clicking the login button
        email.sendKeys("Indianpost@mailinator.com");
        pass.sendKeys("123456781");  // Assuming "1" is a password for testing
        login.click();
        
        // Get and print the page title after login
        String titleAfterLogin = driver.getTitle();
        System.out.println("Title after login: " + titleAfterLogin);
        
        // Compare the titles using equals() method
        if (titleBeforeLogin.equals(titleAfterLogin)) {
            System.out.println("Login failed");

            // Corrected loop logic
            int passCount = 123456781; // Declare an integer for counting
            while (passCount <= 123456791) {
                System.out.println(passCount);
                passCount++;  // Increment the count
            }
        } else {
            System.out.println("Login successful");
        }
        
        System.out.println("Search result selected");
        
        // Close the browser
        driver.quit();
    }
}
