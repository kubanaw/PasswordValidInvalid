package Password.steps;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {
	WebDriver driver;
	
	@Before() 
	public void setup() throws IOException {
		System.setProperty("webdriver.chrome.driver", Paths.get(System.getProperty("user.dir")).toRealPath() +  "\\src\\test\\java\\Password\\resources\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
	}
	

	@Given("^I access webdriverunivsity\\.com$")
	public void i_access_webdriverunivsity_com() throws Throwable {
		driver.get("http://www.webdriveruniversity.com");
	}

	@When("^I click on the login portal button$")
	public void i_click_on_the_login_portal_button() throws Throwable {
		driver.findElement(By.id("login-portal")).click();
	}

	@When("^I enter a username$")
	public void i_enter_a_username() throws Throwable {
		@SuppressWarnings("unused")
		String winHandlerBefore = driver.getWindowHandle();
	
		for(String winHandler: driver.getWindowHandles()) {
			driver.switchTo().window(winHandler);
		}
		
		driver.findElement(By.id("text")).sendKeys("webdriver");
	}

	@When("^I enter a \"([^\"]*)\" password$")
	public void i_enter_a_password(String password) throws Throwable {
		driver.findElement(By.id("password")).sendKeys(password); 
	}

	@When("^I click on the login button$")
	public void i_click_on_the_login_button() throws Throwable {
		driver.findElement(By.id("login-button")).click();

	}

	@Then("^I should be presented with a succesfful validation alert$")
	public void i_should_be_presented_with_a_succesfful_validation_alert() throws Throwable {
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		
		Assert.assertEquals(alert.getText(), "validation succeeded");
	}
	
	@Then("^I should be presented with a unsuccesfful validation alert$")
	public void i_should_be_presented_with_a_unsuccesfful_validation_alert() throws Throwable {
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		
		Assert.assertEquals(alert.getText(), "validation failed");
	}

}
