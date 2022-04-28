package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class stepdefinition {
	WebDriver driver;


	@Given("Opening the OrangeHRM page for Login")
	public void opening_the_orange_hrm_page_for_login() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@name='Submit']")).click();
		String name = "Welcome Rahul123";
		Assert.assertEquals("Welcome Rahul123",name );
		
	}
	
	@When("Adding The Users in Admin")
	public void adding_the_users_in_admin() throws Exception {
		Actions action = new Actions(driver);
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
		driver.findElement(By.xpath("//input[@maxlength='200']")).sendKeys("Admin A");
		driver.findElement(By.xpath("//input[@maxlength='40']")).sendKeys("Hariharan.S");
		driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("QAwerty@#123qwerty");
		driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("QAwerty@#123qwerty");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='btnSave']")).click();
		Thread.sleep(1000);
		
		
	}
	@Then("Logout from OrangeHRM")
	public void logout_from_orange_hrm() throws Exception {
		
		driver.findElement(By.xpath("//a[@class='panelTrigger']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@href='/index.php/auth/logout']")).click();
		driver.close();
	}
	
	
	


}
