package tesTngGeral;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestngParameters {

	private static WebDriver driver;


//  @Parameters({ "sUsername", "sPassword" })  
	// para pegar dataprovider de outra class so passardata>> ProviderClass = TestDataProvider.class
	// onde aqui e nome da class que esta o dataProvider(TestDataProvider.class)
  @Test(dataProvider = "Authentication",dataProviderClass = TestDataProvider.class)
  public void test(String sUsername, String sPassword) throws InterruptedException {

	  driver = new ChromeDriver();

      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

      driver.get("http://35.199.87.179:8081/registradora/login.xhtml");

      driver.findElement(By.cssSelector("[id$=cpf]")).click();

      driver.findElement(By.cssSelector("[id$=cpf]")).sendKeys(sUsername);

      driver.findElement(By.cssSelector("[type=password]")).sendKeys(sPassword);

     // driver.findElement(By.cssSelector("[type=submit]")).click();

      
      Thread.sleep(3000);
      driver.quit();

            
  }
//  
//
//  @DataProvider(name = "Authentication") 
//  public static Object[][] credentials() {
// 
//        return new Object[][] { { "11111111111", "123456" }, { "11111111111", "123456" }};
// 
//  }

}