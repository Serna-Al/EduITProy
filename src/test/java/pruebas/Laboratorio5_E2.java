package pruebas;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;




public class Laboratorio5_E2 {
	
	WebDriver driver;

	
	
	String URL="https://demo.guru99.com/test/upload/";
	String PATH="..\\EduITProy\\Drivers\\chromedriver.exe";

	
	@BeforeSuite
	public void setUp() {
		
		    System.setProperty("webdriver.chrome.driver", PATH);
		    driver=new ChromeDriver();
		    driver.get(URL);
		    driver.manage().window().maximize();
	}
	
	
	@AfterSuite
	public void cierreNavegador() {
		
		driver.close();
		
	}

   @Test
   public void cargarArchivo() {
	   
	  WebElement rutaArchivo=driver.findElement(By.id("uploadfile_0"));
	  
	  rutaArchivo.sendKeys("C:\\Users\\mmontenegro\\IdeaProjects\\EduITProy\\pruebas.txt");
	   
   }

}
