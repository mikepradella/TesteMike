package tesTngGeral;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerDemo {

	public static void main(String[] args) throws InterruptedException {
		
		
		
	//	System.setProperty("webdriver.chrome.driver","C:\\Users\\t-mike.pradella\\automacaoProjetoSeguro\\chromedriver.exe");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver =  new ChromeDriver();
		driver.get("http://35.199.87.179:8081/registradora/login.xhtml");
		Thread.sleep(500);
		driver.quit();
		
		
		
		
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver2 =  new ChromeDriver();
//		driver2.get("http://35.199.87.179:8081/registradora/login.xhtml");
//		Thread.sleep(500);
//		driver2.quit();
	}

}
//2.42.591088