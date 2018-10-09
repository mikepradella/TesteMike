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
import funcionalidadesUtils.NumeroRandomicos;

/**
 * @author t-mike.pradella
 *
 */
public class CriarConta {

	FuncionalidadeUteis funcionalidadeUteis;

	WebDriver driver;

	// inicio mapeamento de campos

	@FindBy(id = "email_create")
	@CacheLookup
	public WebElement email;
	
	
	
	@FindBy(css = "#SubmitCreate > span > i")
	@CacheLookup
	public WebElement criarConta;
	
				   	
	@FindBy(css= "#customer_firstname")
	@CacheLookup
	public WebElement primeiroNome;
	
	@FindBy(css = "#customer_lastname")
	@CacheLookup
	public WebElement ultimoNome;
	
	
	@FindBy(id = "passwd")
	@CacheLookup
	public WebElement senha;
	
	@FindBy(xpath = "//input[@id=\"firstname\"]")
	@CacheLookup
	public WebElement primeiroNomeEndereco;
    

	@FindBy(xpath = "//input[@id=\"lastname\"]")
	@CacheLookup
	public WebElement segundoNomeEndereco;
	
	@FindBy(id = "address1")
	@CacheLookup
	public WebElement endereco;
	
	@FindBy(id = "city")
	@CacheLookup
	public WebElement cidade;
	
	
	@FindBy(id = "id_state")
	@CacheLookup
	public WebElement estado;
	
	
	@FindBy(id = "postcode")
	@CacheLookup
	public WebElement zip;
	
	
	@FindBy(id = "id_country")
	@CacheLookup
	public WebElement pais;
	
	
	@FindBy(id = "phone_mobile")
	@CacheLookup
	public WebElement telefone;
	
	
	@FindBy(css = "#submitAccount > span")
	@CacheLookup
	public WebElement registrar;
	
	
	
	
	// fim mapeamento de campos
	public CriarConta(WebDriver driver) {
		funcionalidadeUteis = new FuncionalidadeUteis(driver);
		PageFactory.initElements(driver, this);
		new MetodoEspera(driver);
	}



	

		public void preencherEmail(String recebiEmail) {
			try {
				
				email.sendKeys(NumeroRandomicos.gerarNumeroRandomicoStatico() + recebiEmail);
				CapturaTela.capturaTela("email preenchido");
				
			} catch (Exception e) {
				CapturaTela.capturaTela("erro clicar ao preencher Email");
				throw new RuntimeException(e);
			}
		}
		
		
		public void clicarCriarConta() {
			try {
				criarConta.click();
				CapturaTela.capturaTela("clique na conta com sucesso");
			} catch (Exception e) {
				CapturaTela.capturaTela("erro ao clicar em criar conta");
				throw new RuntimeException(e);
			}
		}
		
		public void preencherObrigatorios() {
			try {
				primeiroNome.sendKeys("mike");
				ultimoNome.sendKeys("ultimo");
				primeiroNomeEndereco.clear();
				primeiroNomeEndereco.sendKeys("teste");
				segundoNomeEndereco.clear();
				segundoNomeEndereco.sendKeys("certo");
				senha.sendKeys("123456");
				endereco.sendKeys("endereco");
				cidade.sendKeys("osasco");
				FuncionalidadeUteis.selecionarOpcaoDropDrownPorTexto(estado,"Alabama");
				zip.sendKeys("12345");
				FuncionalidadeUteis.selecionarOpcaoDropDrownPorTexto(pais,"United States");
				telefone.sendKeys("123456789");
				CapturaTela.capturaTela("campos obrigatorios");
				
			} catch (Exception e) {
				CapturaTela.capturaTela("erro clicar ao preencher obrigatorios");
				throw new RuntimeException(e);
			}
		}
		
		public void clicarRegistrar() {
			try {
				registrar.click();
				CapturaTela.capturaTela("clique em registrar com sucesso");
			} catch (Exception e) {
				CapturaTela.capturaTela("erro ao clicar em registrar");
				throw new RuntimeException(e);
			}
		}
		


	
	
}
