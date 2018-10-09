package pageObjects;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

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
public class TelaPagamento {

	FuncionalidadeUteis funcionalidadeUteis;

	WebDriver driver;

	// inicio mapeamento de campos

	@FindBy(css = "#total_price")
	@CacheLookup
	public WebElement totalIgual;
	
	@FindBy(id = "total_tax")
	@CacheLookup
	public WebElement taxa;
	
	

	@FindBy(css = "#HOOK_PAYMENT > div:nth-child(1) > div > p > a")
	@CacheLookup
	public WebElement pagamento;
	
	@FindBy(css = "#cart_navigation > button > span")
	@CacheLookup
	public WebElement confirma;
	
	

	@FindBy(xpath = "//*[@id=\"center_column\"]/div/p/strong")
	@CacheLookup
	public WebElement validaProcesso;


	// fim mapeamento de campos
	public TelaPagamento(WebDriver driver) {
		funcionalidadeUteis = new FuncionalidadeUteis(driver);
		PageFactory.initElements(driver, this);
		new MetodoEspera(driver);
	}

	public void clicarFormaPagamento() {

		try {
			pagamento.click();
			CapturaTela.capturaTela("clicando  forma pagamento");
		} catch (Exception e) {
			CapturaTela.capturaTela("erro ao clicar no forma pagamento ");
			throw new RuntimeException(e);
		}
	}

	public void validaValor(String valor) {
		try {

			String validae = totalIgual.getText();
			String taxa1 = taxa.getText();
			String result = validae.substring(1);
			String result1 = taxa1.substring(1);
			String valor1 = valor.substring(1);
			float resultado3 = Float.parseFloat(valor1);
			float resultado = Float.parseFloat(result);
			float resultado1 = Float.parseFloat(result1);
			assertEquals(resultado, resultado3+resultado1);
			CapturaTela.capturaTela("validacao registro com sucesso");
		} catch (Exception e) {
			CapturaTela.capturaTela("erro na validacao registro da apolice");
			throw new RuntimeException(e);
		}
	}
	

	public void clicarConfirmar() {

		try {
			confirma.click();
			CapturaTela.capturaTela("clicando  em confirmar");
		} catch (Exception e) {
			CapturaTela.capturaTela("erro ao clicar em confirmar ");
			throw new RuntimeException(e);
		}
	}
	

	public void validaProcesso(String msg) {
		try { 	

			String mensagem = validaProcesso.getText();
			assertTrue(mensagem.contains(msg));
			CapturaTela.capturaTela("validacao registro com sucesso");
		} catch (Exception e) {
			CapturaTela.capturaTela("erro na validacao registro da apolice");
			throw new RuntimeException(e);
		}
	}
	
	

}
