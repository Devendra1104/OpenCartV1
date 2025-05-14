package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	public Properties propObj;
	
	
	@BeforeClass(groups= {"Sanity","Master"})
	@Parameters({"browser","os"})
	public void setup(String br, String os) throws IOException, URISyntaxException {
		
		propObj = new Properties();
		InputStream input = new FileInputStream("C:\\Devendra\\Selenium\\Java\\WorkSpaces\\JavaSeleniumWorkSpace\\OpenCartV1\\src\\test\\resources\\config.properties");
		propObj.load(input);
		String url = propObj.getProperty("URL1");

		logger = LogManager.getLogger(this.getClass()); // automatically fetch log4j2 file into the the logger variable, we can use this variable to generate the logs statement.
		
		//OS
		if(propObj.getProperty("execution_env").equalsIgnoreCase("remote")){
			
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			switch(os.toLowerCase()) {
			
			case "windows":
				capabilities.setPlatform(Platform.WIN11);
				break;
				
			case "mac":
				capabilities.setPlatform(Platform.MAC);
				break;
				
			case "linux":
				capabilities.setPlatform(Platform.LINUX);
				break;
				
			default:
				System.out.println("Invalid OS detected");
				return;
			}
			
			switch(br.toLowerCase()) {
			
			case "chrome":
				capabilities.setBrowserName("chrome");
				break;
				
			case "edge":
				capabilities.setBrowserName("MicrosoftEdge");
				break;
				
			case "firefox":
				capabilities.setBrowserName("firefox");
				break;
				
			default:
				System.out.println("Invalid browser detected");
				return;
			}
			
			driver = new RemoteWebDriver(new URI("http://192.168.0.241:4444/wd/hub").toURL(),capabilities);
		}		
		
		//
		
		if(propObj.getProperty("execution_env").equalsIgnoreCase("local")) {
		switch(br.toLowerCase()) {
		
		case "chrome":
			driver = new ChromeDriver();
			break;
			
		case "edge":
			driver = new EdgeDriver();
			break;
			
		default:
			System.out.println("Invalid browser detected");
			return;
			}
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		
	}
	
	@AfterClass(groups= {"Sanity","Master"})
	public void teardown() {
		driver.quit();
	}
	
	public String captureScreen(String tname) {
		
		String timestamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot ts =(TakesScreenshot) driver;
		File sourcefile = ts.getScreenshotAs(OutputType.FILE);
		
		String targetfilePath = System.getProperty("user.dir")+"\\screenshots\\"+ tname +"_" + timestamp +".png";
		File targetFile = new File(targetfilePath);
		sourcefile.renameTo(targetFile);
		return targetfilePath;
	}
	

}
