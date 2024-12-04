package testcases;

import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Random_details {
	public static WebDriver driver;
	public Properties p;

	@BeforeClass(groups = { "sanity", "master", "regression", "datadriven" })
	@Parameters({ "os", "browser" })
	public void setup(String os, String br) throws Exception {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--allow-cdp-version-mismatch");
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p = new Properties();
		p.load(file);
		switch (br.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver(options);
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Enter the valid browser name");
			return;
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(p.getProperty("appurl"));
	}

	@AfterClass(groups = { "sanity", "master", "regression", "datadriven" })
	public void teardown() {
		driver.quit();
	}

	@SuppressWarnings("deprecation")
	public String randomstring() {
		String generatedstring = RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}

	@SuppressWarnings("deprecation")
	public String randomnumber() {
		String generatednumber = RandomStringUtils.randomNumeric(10);
		return generatednumber;
	}

	public String randomalphanumberic() {
		@SuppressWarnings("deprecation")
		String generatedstring = RandomStringUtils.randomAlphabetic(5);
		@SuppressWarnings("deprecation")
		String generatednumber = RandomStringUtils.randomNumeric(10);
		return (generatedstring + generatednumber);
	}

	public String capturescreen(String tname) {
		String timestamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File srcfile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetfilepath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timestamp + ".png";
		File targetfile = new File(targetfilepath);
		srcfile.renameTo(targetfile);
		return targetfilepath;
	}

}
