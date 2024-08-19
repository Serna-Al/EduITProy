package pruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class CrossBrowserTest {
	
	WebDriver driver = null;
	String URL="http://www.automationpractice.pl/index.php";
	String PATH="..\\EduITProy\\Drivers\\chromedriver.exe";
	String PATHF="..\\EduITProy\\Drivers\\geckodriver.exe";
	
	@BeforeMethod
	@Parameters("navegador")
	public void setUp(String navegador) {
		
		if (navegador.equalsIgnoreCase("chrome")){
		
		    System.setProperty("webdriver.chrome.driver", PATH);
		    driver=new ChromeDriver();
		}
		
		else {
		
		   System.setProperty("webdriver.gecko.driver", PATHF);
		   driver=new FirefoxDriver();
		}
		
		
		driver.get(URL);
		
		driver.manage().window().maximize();
	}
	
	
	
	@Test
	public void buscarPalabra() {

		WebElement txtBuscador=driver.findElement(By.cssSelector("input[placeholder='Search']"));

		txtBuscador.clear();

		txtBuscador.sendKeys("Blouse");

		txtBuscador.sendKeys(Keys.ENTER);
	}
	
	@AfterMethod
	public void cierreNavegador() {
		
		driver.close();
		
	}
	
}

