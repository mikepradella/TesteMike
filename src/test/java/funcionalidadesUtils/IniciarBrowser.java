package funcionalidadesUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IniciarBrowser {
	public static WebDriver driver;

	// pego os alguns dados via arquivo properties , neste caso estou pegando a url
	// quero testar
	ManipularDados prop = new ManipularDados();
	

	public WebDriver startBrowser(String browserName, String url) {

		
		// existe duas possibilidades de escolher o navegar, uma pelo arquivo properties ou passado
		// o nome do navegador pelo construtor, estou ultizando o do arquivo properties
		
		try {
			browserName=ManipularDados.getProp().getProperty("browser");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		// abre o navegador Chrome
		if (browserName.equalsIgnoreCase("chrome")) {
		
			// 03/10/2018, Existe novo formato onde nao precisamos mais usar o codigo abaixo,
			// webdrivermanager, onde ele pode ser nova opcao de usar os driver, as duas opçoes funcionam
//			System.setProperty("webdriver.chrome.driver",
//					"C:\\Users\\t-mike.pradella\\automacaoProjetoSeguro\\chromedriver.exe");
//			
			
			WebDriverManager.chromedriver().setup();
			// esta opcao desativa a barra de informacao do navegador chrome
//			 >> chrome is being controlled by automated test software			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");

			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			// abre o navigator FIREFOX
		} else if (browserName.equalsIgnoreCase("firefox")) {
			
			// 03/10/2018, Existe novo formato onde nao precisamos mais usar o codigo abaixo,
			// webdrivermanager, onde ele pode ser nova opcao de usar os driver, as duas opçoes funcionam
			
			//webdriver.firefox.marionette -- Nao funcionou
			//webdriver.gecko.driver
//			System.setProperty("webdriver.gecko.driver",
//					"C:\\Users\\t-mike.pradella\\automacaoProjetoSeguro\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			// abre o navegador OPera
		} else if (browserName.equalsIgnoreCase("opera")) {
			// 03/10/2018, Existe novo formato onde nao precisamos mais usar o codigo abaixo,
//			 webdrivermanager, onde ele pode ser nova opcao de usar os driver, as duas opçoes funcionam
			System.setProperty("webdriver.opera.driver", "/home/t-mike.pradella/Downloads/DriversSelenium/operadriver");
			
//			WebDriverManager.operadriver().setup();
			driver = new SafariDriver();
//			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		driver.manage().window().maximize();
		try {
			driver.get(ManipularDados.getProp().getProperty("url"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return driver;

	}

	public void fecharNavegadores() {	
		driver.quit();
		System.out.println("Navegador fechado");
	}
//
}
