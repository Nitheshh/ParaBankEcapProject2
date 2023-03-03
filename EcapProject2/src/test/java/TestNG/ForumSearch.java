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

public class ForumSearch {
	WebDriver driver;
	Properties prt = new Properties();


	@Test
	public void searchBox() {

		WebElement forum = driver.findElement(By.linkText(prt.getProperty("forumxpath")));
		forum.click();
		WebElement search = driver.findElement(By.xpath(prt.getProperty("forumSearchBox")));
		search.sendKeys(prt.getProperty("Frouminput"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement button = driver.findElement(By.xpath(prt.getProperty("searchbuttonxpath")));
		button.click();

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
