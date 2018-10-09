package compraCompletaMyStoreStepDefiniton;

import java.util.Set;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.es.Dado;
import cucumber.api.java.pt.Entao;
import funcionalidadesUtils.CapturaTela;
import funcionalidadesUtils.FuncionalidadeUteis;
import funcionalidadesUtils.IniciarBrowser;
import funcionalidadesUtils.NumeroRandomicos;
import pageObjects.CriarConta;
import pageObjects.TelaHome;
import pageObjects.TelaPagamento;
import pageObjects.TelaProcesso;
import pageObjects.TelaRemessa;
import pageObjects.ValidaEndereco;

public class CompraCompletaMyStoreStepDefinition {

	public WebDriver driver;

	IniciarBrowser iniciarBrowser;
	CapturaTela capturaTela;

	TelaHome telaHome;
	TelaProcesso telaProcesso;
	CriarConta criarConta;
	NumeroRandomicos numeroRandomicos;
	FuncionalidadeUteis funcionalidadeUteis;
	ValidaEndereco validaEndereco;
	TelaRemessa telaRemessa;
	TelaPagamento telaPagamento;
	
	
	public void setUp() throws InterruptedException {
		System.out.println("Navegador iniciado");
		iniciarBrowser = new IniciarBrowser();
		// posso iniciar por aqui ou utilizando arquivo de propriedade, estou usando o
		// arquivo propriedade
		WebDriver driver = iniciarBrowser.startBrowser("CHROME", "https://www.google.com.br");
		this.driver = driver;
		telaHome = new TelaHome(driver);
		telaProcesso = new TelaProcesso(driver);
		criarConta = new CriarConta(driver);
		validaEndereco = new ValidaEndereco(driver);
		telaRemessa= new TelaRemessa(driver);
		numeroRandomicos = new NumeroRandomicos();
		telaPagamento  = new TelaPagamento(driver);
		funcionalidadeUteis = new FuncionalidadeUteis(driver);

	}

	@After
	public void setUpFinal() {
		iniciarBrowser.fecharNavegadores();
	}

	@Dado("^que estou na pagina http://automationpractice\\.com/index\\.php$")
	public void que_estou_na_pagina_http_automationpractice_com_index_php() throws Throwable {
		this.setUp();

	}

	@Dado("^seleciono o primeiro produto na lista$")
	public void seleciono_o_primeiro_produto_na_lista() throws Throwable {
		telaHome.moverProduto();
	}

	@Entao("^devera ser apresentado a tela produto adicionado no carrinho \"([^\"]*)\"$")
	public void devera_ser_apresentado_a_tela_produto_adicionado_no_carrinho(String arg1) throws Throwable {
		telaHome.adicionarProduto();
		Set<String> handle = driver.getWindowHandles();
		System.out.println(handle);

	}

	@Entao("^clicar no botao Proceed to checkout$")
	public void clicar_no_botao_Proceed_to_checkout() throws Throwable {
		telaHome.clicarCheckout();

	}

	@Entao("^devera ser apresentado produto adicionado ao carrinho$")
	public void devera_ser_apresentado_produto_adicionado_ao_carrinho() throws Throwable {
		// Thread.sleep(5000);
		telaHome.validaCarrinho();
	}

	@Entao("^clicar no botao verde Proceed to checkout$")
	public void clicar_no_botao_verde_Proceed_to_checkout() throws Throwable {
		telaProcesso.clicarVerdeCheckout();
	}

	@Entao("^Preencher \"([^\"]*)\" valido$")
	public void preencher_valido(String email) throws Throwable {
		criarConta.preencherEmail(email);
	
	}

	@Entao("^clicar no botao Create an Account$")
	public void clicar_no_botao_Create_an_Account() throws Throwable {
		criarConta.clicarCriarConta();
		
	}

	@Entao("^preencher todos os campos obrigatorios$")
	public void preencher_todos_os_campos_obrigatorios() throws Throwable {
		criarConta.preencherObrigatorios();
		
	}

	@Entao("^clicar no botao Register$")
	public void clicar_no_botao_Register() throws Throwable {
		criarConta.clicarRegistrar();
		
	}

	@Entao("^devera refletir endereço corretamente$")
	public void devera_refletir_endereço_corretamente() throws Throwable {
		validaEndereco.validaRegistroEndereco();
			
	}

	@Entao("^clicar no botao Proceed$")
	public void clicar_no_botao_Proceed() throws Throwable {
		validaEndereco.clicarProceed();
		 
	}

	@Entao("^clicar no Terms of service$")
	public void clicar_no_Terms_of_service() throws Throwable {
		telaRemessa.clicarCheckBox();
		
	}

	@Entao("^clicar no botao Proceed too checkout$")
	public void clicar_no_botao_Proceed_too_checkout() throws Throwable {
		telaRemessa.clicarToCheckout();
		
	}

	@Entao("^o valor da compra devera ser o mesmo selecionado$")
	public void o_valor_da_compra_devera_ser_o_mesmo_selecionado() throws Throwable {
		String totalIguais = telaHome.total();
		telaPagamento.validaValor(totalIguais);
	}

	@Entao("^clicar em Pay by bank wire$")
	public void clicar_em_Pay_by_bank_wire() throws Throwable {
		telaPagamento.clicarFormaPagamento();
	}

	@Entao("^clicar no botao I confirm my order$")
	public void clicar_no_botao_I_confirm_my_order() throws Throwable {
		telaPagamento.clicarConfirmar();
	}

	@Entao("^devera aparecer \"([^\"]*)\"$")
	public void devera_aparecer(String msg) throws Throwable {
		telaPagamento.validaProcesso(msg);
	}

}
