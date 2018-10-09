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
public class TelaRemessa {

	FuncionalidadeUteis funcionalidadeUteis;

	WebDriver driver;

	// inicio mapeamento de campos

	@FindBy(css = "#cgv")
	@CacheLookup
	public WebElement check;

	
	@FindBy(css = "#form > p > button > span")
	@CacheLookup
	public WebElement toCheckout;
	
	
    
	// fim mapeamento de campos
	public TelaRemessa(WebDriver driver) {
		funcionalidadeUteis = new FuncionalidadeUteis(driver);
		PageFactory.initElements(driver, this);
		new MetodoEspera(driver);
	}

	
	public void clicarCheckBox() {
		
		try {
			check.click();
			CapturaTela.capturaTela("clicando  checkbox");
		} catch (Exception e) {
			CapturaTela.capturaTela("erro ao clicar no checkBox ");
			throw new RuntimeException(e);
		}
	}

	  
	public void clicarToCheckout() {
		
		try {
			toCheckout.click();
			CapturaTela.capturaTela("clicando  checkout");
		} catch (Exception e) {
			CapturaTela.capturaTela("erro ao clicar no checkout ");
			throw new RuntimeException(e);
		}
	}

	 
	
	
}
