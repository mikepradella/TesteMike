package pageObjects;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import funcionalidadesUtils.CapturaTela;
import funcionalidadesUtils.FuncionalidadeUteis;
import funcionalidadesUtils.MetodoEspera;

/**
 * @author t-mike.pradella
 *
 */
public class TelaProcesso {

	FuncionalidadeUteis funcionalidadeUteis;

	WebDriver driver;

	// inicio mapeamento de campos

	@FindBy(css = "#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium")
	@CacheLookup
	public WebElement praFrenteCheckout;

	
    
	// fim mapeamento de campos
	public TelaProcesso(WebDriver driver) {
		funcionalidadeUteis = new FuncionalidadeUteis(driver);
		PageFactory.initElements(driver, this);
		new MetodoEspera(driver);
	}



	public void clicarVerdeCheckout() {
			
		  try{

				funcionalidadeUteis.moveMouseElemento(praFrenteCheckout);

				funcionalidadeUteis.clicarJavaScript(praFrenteCheckout);


		  } catch(StaleElementReferenceException e){
			  ;

		  } }
	

	
	
}
