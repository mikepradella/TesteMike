package funcionalidadesUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

 	public class MetodoEspera {
	
	static WebDriver driver;
	
	public MetodoEspera(WebDriver driver) {
			this.driver  = driver;
	
	}

// este metodo espera o elemento por 10 segundos, envie por paramentro o elemento
	// este metodo verifica se elemento e clicavel
	public static void espera(WebElement elemento ) {	
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.elementToBeClickable(elemento));

	
}	
	public static void esperaVisivel(By elemento ) {	
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(elemento));
	
}	

	public static void esperaPresente(By string ) {	
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.presenceOfElementLocated(string));
	
	
}	
	

}
