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

public class RegisterQuery {
	WebDriver driver;
	Properties prt = new Properties();


	@Test
	public void customerCare() {
		WebElement customer = driver.findElement(By.linkText(prt.getProperty("Customercare")));
		customer.click();
		WebElement name = driver.findElement(By.xpath(prt.getProperty("namexpath")));
		name.sendKeys(prt.getProperty("name"));
		WebElement email = driver.findElement(By.xpath(prt.getProperty("emailxpath")));
		email.sendKeys(prt.getProperty("email"));
		WebElement phoneNumber = driver.findElement(By.xpath(prt.getProperty("phnumberxpath")));
		phoneNumber.sendKeys(prt.getProperty("phnumber"));
		WebElement message = driver.findElement(By.xpath(prt.getProperty("messagexpath")));
		message.sendKeys(prt.getProperty("message"));
		WebElement submit = driver.findElement(By.xpath(prt.getProperty("submitmessage")));
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
	public void close() {
		driver.close();
	}

}
