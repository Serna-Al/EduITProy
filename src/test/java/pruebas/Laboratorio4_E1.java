package pruebas;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import paginas.paginaLogin;


public class Laboratorio4_E1 {
	

	WebDriver driver;
	paginaLogin login;
	
	
	String URL="http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";
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
	public void irRegistroLogin() {
		login=new paginaLogin(driver);
		login.ingresoDatos("test1@gmail.com", "ABCD");
	    Assert.assertEquals(login.getTextTitleForm(), "AUTHENTICATION");
	}
	
}
