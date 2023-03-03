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

public class LoginWithWrongUsername {

	WebDriver driver;
	Properties prt = new Properties();


	@Test
	public void wrongUserName() {
		WebElement userName = driver.findElement(By.xpath(prt.getProperty("Usernamexpathlogin")));
		userName.sendKeys(prt.getProperty("UserName"));
		WebElement password = driver.findElement(By.xpath(prt.getProperty("Password1")));
		password.sendKeys(prt.getProperty("WrongUsername"));
		WebElement login = driver.findElement(By.xpath(prt.getProperty("Login1")));
		login.click();

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
