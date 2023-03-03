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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class TransactionsOfFeb {
	WebDriver driver;
	Properties prt = new Properties();

	@Test
	public void febuaryTransactionOnly() {

		WebElement userName = driver.findElement(By.xpath(prt.getProperty("Usernamexpathlogin")));
		userName.sendKeys(prt.getProperty("UserName"));
		WebElement password = driver.findElement(By.xpath(prt.getProperty("Password1")));
		password.sendKeys(prt.getProperty("Passwordlogin"));
		WebElement login = driver.findElement(By.xpath(prt.getProperty("Login1")));
		login.click();


		WebElement accountOverview = driver.findElement(By.linkText(prt.getProperty("TotalBalance")));
		accountOverview.click();

		WebElement singleAccount = driver.findElement(By.linkText(prt.getProperty("AccountNumber")));
		singleAccount.click();

		Select month = new Select(driver.findElement(By.xpath(prt.getProperty("Month"))));
		month.selectByValue(prt.getProperty("whichmonth"));

		WebElement submit = driver.findElement(By.xpath(prt.getProperty("SubmitToSpecificTransaction")));
		submit.click();

	}
	@BeforeClass
	public void launchUrl(){

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
