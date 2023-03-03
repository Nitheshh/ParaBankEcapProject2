package TestNG;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Register {

	WebDriver driver;
	Properties prt = new Properties();

	@Test
	public void registerUser() {

		WebElement register = driver.findElement(By.linkText(prt.getProperty("Register")));
		register.click();
		WebElement firstName = driver.findElement(By.xpath(prt.getProperty("firstnamexapth")));
		firstName.sendKeys(prt.getProperty("firstname"));
		WebElement lastName = driver.findElement(By.xpath(prt.getProperty("lastnamexpath")));
		lastName.sendKeys(prt.getProperty("lastname"));
		WebElement address = driver.findElement(By.xpath(prt.getProperty("addressxpath")));
		address.sendKeys(prt.getProperty("address"));
		WebElement city = driver.findElement(By.xpath(prt.getProperty("cityxpath")));
		city.sendKeys(prt.getProperty("city"));
		WebElement state = driver.findElement(By.xpath(prt.getProperty("Statexpath")));
		state.sendKeys(prt.getProperty("State"));
		WebElement zipCode = driver.findElement(By.xpath(prt.getProperty("Zipcodexpath")));
		zipCode.sendKeys(prt.getProperty("Zipcode"));
		WebElement phoneNumber = driver.findElement(By.xpath(prt.getProperty("phonexpath")));
		phoneNumber.sendKeys(prt.getProperty("phone"));
		WebElement ssn = driver.findElement(By.xpath(prt.getProperty("ssnxpath")));
		ssn.sendKeys(prt.getProperty("ssn"));
		WebElement userName = driver.findElement(By.xpath(prt.getProperty("usernamexpath")));
		userName.sendKeys(prt.getProperty("username"));
		WebElement password = driver.findElement(By.xpath(prt.getProperty("passwordxpath")));
		password.sendKeys(prt.getProperty("password"));
		WebElement confirmPassword = driver.findElement(By.xpath(prt.getProperty("confirmpssxpath")));
		confirmPassword.sendKeys(prt.getProperty("confirmpss"));
		WebElement submit = driver.findElement(By.xpath(prt.getProperty("Submitxpath")));
		submit.click();


	}
	@BeforeClass
	public void launchUrl() {

		try {
			FileInputStream inputstream = new FileInputStream("C:\\Users\\nithe\\eclipse-workspace\\EcapProject2\\properties\\testdata.properties");
			prt.load(inputstream);
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(prt.getProperty("Url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

	@AfterClass
	public void afterClass() {
		driver.close();

	}

}

