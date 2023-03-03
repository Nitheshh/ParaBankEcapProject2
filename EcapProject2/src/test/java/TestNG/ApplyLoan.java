package TestNG;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class ApplyLoan {
	WebDriver driver;
	Properties prt = new Properties();

	@Test
	public void loan() {

		//Run Register Classes once before runing this code

		WebElement userName = driver.findElement(By.xpath(prt.getProperty("Usernamexpathlogin")));
		userName.sendKeys(prt.getProperty("UserName"));
		WebElement password = driver.findElement(By.xpath(prt.getProperty("Password1")));
		password.sendKeys(prt.getProperty("Passwordlogin"));
		WebElement login = driver.findElement(By.xpath(prt.getProperty("Login1")));
		login.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement loan = driver.findElement(By.linkText(prt.getProperty("ApplyLoanxpath")));
		loan.click();
		WebElement loanAmount = driver.findElement(By.xpath(prt.getProperty("LoanAmountFeild")));
		loanAmount.sendKeys(prt.getProperty("LoanAmount"));
		WebElement downPayment = driver.findElement(By.xpath(prt.getProperty("DownPaymentFeild")));
		downPayment.sendKeys(prt.getProperty("DownPayment"));
		Select fromAcc = new Select(driver.findElement(By.xpath(prt.getProperty("From_Feild"))));
		fromAcc.selectByIndex(0);
		WebElement apply = driver.findElement(By.xpath(prt.getProperty("ApplyButton")));
		apply.click();
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
