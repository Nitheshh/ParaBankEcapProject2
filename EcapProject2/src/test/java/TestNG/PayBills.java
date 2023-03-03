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

public class PayBills {
	//Run Register Classes once before runing this code

	WebDriver driver;
	Properties prt = new Properties();

	@Test
	public void billsPayable() {
		WebElement userName = driver.findElement(By.xpath(prt.getProperty("Usernamexpathlogin")));
		userName.sendKeys(prt.getProperty("UserName"));
		WebElement password = driver.findElement(By.xpath(prt.getProperty("Password1")));
		password.sendKeys(prt.getProperty("Passwordlogin"));
		WebElement login = driver.findElement(By.xpath(prt.getProperty("Login1")));
		login.click();

		WebElement billsPay = driver.findElement(By.linkText(prt.getProperty("BillsPayFeild")));
		billsPay.click();
		WebElement payeeName = driver.findElement(By.xpath(prt.getProperty("PayeeNameFeild")));
		payeeName.sendKeys(prt.getProperty("PayeeName"));
		WebElement address = driver.findElement(By.xpath(prt.getProperty("PayAddressfeild")));
		address.sendKeys(prt.getProperty("address"));
		WebElement city = driver.findElement(By.xpath(prt.getProperty("PayCityFeild")));
		city.sendKeys(prt.getProperty("city"));
		WebElement state = driver.findElement(By.xpath(prt.getProperty("PayStateFeild")));
		state.sendKeys(prt.getProperty("State"));
		WebElement zipCode = driver.findElement(By.xpath(prt.getProperty("PayZipcodeFeild")));
		zipCode.sendKeys(prt.getProperty("Zipcode"));
		WebElement phoneNumber = driver.findElement(By.xpath(prt.getProperty("PayPhoneFeild")));
		phoneNumber.sendKeys(prt.getProperty("phone"));

		WebElement account = driver.findElement(By.xpath(prt.getProperty("PayAccountFeild")));
		account.sendKeys(prt.getProperty("PayAccount"));
		WebElement verifyAccount = driver.findElement(By.xpath(prt.getProperty("VerifyPayAccountFeild")));
		verifyAccount.sendKeys(prt.getProperty("PayAccount"));
		WebElement amount = driver.findElement(By.xpath(prt.getProperty("PayAmountFeild")));
		amount.sendKeys(prt.getProperty("PayAmount"));
		Select fromAcc = new Select(driver.findElement(By.xpath(prt.getProperty("FromAccountFeild"))));
		fromAcc.selectByIndex(0);
		WebElement sendPayment = driver.findElement(By.xpath(prt.getProperty("SendPaymentButton")));
		sendPayment.click();
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
