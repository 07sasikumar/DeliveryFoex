package deliverforx;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Loginpage2 {

	public static void main(String[] args) {
		// Initialize the FirefoxDriver
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://deliveryforx.trymydemo.com/merchant-login");

		// Get and print the page title before login
		String titleBeforeLogin = driver.getTitle();
		System.out.println("Title before login: " + titleBeforeLogin);

		// Initialize the email field and set static value
		WebElement email = driver.findElement(By.xpath("//*[@id=\"mer_email\"]"));
		email.sendKeys("Indianpost@mailinator.com");

		// Declare an initial password to start the loop
		int passCount = 123456770;

		// While loop to attempt login with incrementing passwords
		while (passCount <= 123456791) {
			// Clear the password field for each attempt
			WebElement pass = driver.findElement(By.xpath("//*[@id=\"mer_pass\"]"));
			pass.clear();

			// Enter the password and increment it
			pass.sendKeys(String.valueOf(passCount));
			WebElement login = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div/form/input[2]"));
			login.click();

			// Get the page title after login attempt
			String titleAfterLogin = driver.getTitle();
			System.out.println("Attempt with password: " + passCount);

			// Check if login is successful by comparing titles
			if (!titleBeforeLogin.equals(titleAfterLogin)) {
				System.out.println("Login successful with password: " + passCount);
				break; // Exit the loop if login is successful
			} else {
				System.out.println("Login failed with password: " + passCount);
			}

			// Increment the password for the next attempt
			passCount++;
		}

		// Close the browser
		driver.quit();
	}
}
