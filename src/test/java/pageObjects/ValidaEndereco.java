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
public class ValidaEndereco {

	FuncionalidadeUteis funcionalidadeUteis;

	WebDriver driver;

	// inicio mapeamento de campos

	@FindBy(css = "#address_delivery > li.address_firstname.address_lastname")
	@CacheLookup
	public WebElement valida1;

	@FindBy(css = "#address_delivery > li.address_address1.address_address2")
	@CacheLookup
	public WebElement valida2;

	

	@FindBy(css = "#address_delivery > li.address_city.address_state_name.address_postcode")
	@CacheLookup
	public WebElement valida3;


	@FindBy(css = "#address_delivery > li.address_country_name")
	@CacheLookup
	public WebElement valida4;
	
	
	@FindBy(css = "#address_delivery > li.address_phone_mobile")
	@CacheLookup
	public WebElement valida5;

	
	@FindBy(css = "#center_column > form > p > button")
	@CacheLookup
	public WebElement proceed;

	
		
	
    
	// fim mapeamento de campos
	public ValidaEndereco(WebDriver driver) {
		funcionalidadeUteis = new FuncionalidadeUteis(driver);
		PageFactory.initElements(driver, this);
		new MetodoEspera(driver);
	}

	public void validaRegistroEndereco() {
		try {	
			String validaa = valida1.getText();
			assertTrue(validaa.contains("teste certo"));

			String validab = valida2.getText();
			assertTrue(validab.contains("endereco"));

			String validac = valida3.getText();
			assertTrue(validac.contains("osasco, Alabama 12345"));

			String validad = valida4.getText();
			assertTrue(validad.contains("United States"));

			String validae = valida5.getText();
			assertTrue(validae.contains("123456789"));
			CapturaTela.capturaTela("validacao registro com sucesso");
		} catch (Exception e) {
			CapturaTela.capturaTela("erro na validacao registro da apolice");
			throw new RuntimeException(e);
		}
	}
	
	public void clicarProceed() {
		
		try {
			proceed.click();
			CapturaTela.capturaTela("clicando botao proceed");
		} catch (Exception e) {
			CapturaTela.capturaTela("erro ao clicar botao proceed");
			throw new RuntimeException(e);
		}
	}

	  

	
	
}
