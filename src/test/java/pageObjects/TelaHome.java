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
public class TelaHome {

	FuncionalidadeUteis funcionalidadeUteis;

	WebDriver driver;

	// inicio mapeamento de campos

	@FindBy(css = "#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line")
	@CacheLookup
	public WebElement movePrimeiroProduto;

	@FindBy(css = "#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default > span")
	@CacheLookup
	public WebElement adicionarCarrinho;

	

	@FindBy(xpath = "//*[contains(text(),'to checkout')]")
	@CacheLookup
	public WebElement botaoCheckout;


	@FindBy(css = "#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div:nth-child(4) > span")
	@CacheLookup
	public WebElement total;
	
	
	@FindBy(css = "#product_1_1_0_0 > td.cart_avail > span")
	@CacheLookup
	public WebElement validaCarrinhoTexto;


		
	public String totalGuarda;
	

    
	// fim mapeamento de campos
	public TelaHome(WebDriver driver) {
		funcionalidadeUteis = new FuncionalidadeUteis(driver);
		PageFactory.initElements(driver, this);
		new MetodoEspera(driver);
	}

	public void moverProduto() {
		try {
			funcionalidadeUteis.moveMouseElemento(movePrimeiroProduto);
			CapturaTela.capturaTela("move para o elemento");
		} catch (Exception e) {
			CapturaTela.capturaTela("erro ao mover para o elemento");
			throw new RuntimeException(e);
		}
	}

	
	public void adicionarProduto() {
		try {
			adicionarCarrinho.click();
			CapturaTela.capturaTela("adiciona ao carrinho");
		} catch (Exception e) {
			CapturaTela.capturaTela("erro ao adicionar ao carrinho");
			throw new RuntimeException(e);
		}
	}

	public void clicarCheckout() {
		

			MetodoEspera.espera(total);
			totalGuarda=total.getText();
			
		try {
				MetodoEspera.espera(botaoCheckout);
				funcionalidadeUteis.moveMouseElemento(botaoCheckout);

				funcionalidadeUteis.clicarJavaScript(botaoCheckout);


		  } catch(StaleElementReferenceException e){
			  ;

		  } }
	
	
	public void validaCarrinho() {
		try {
			MetodoEspera.espera(validaCarrinhoTexto);
			validaCarrinhoTexto.isDisplayed();
			CapturaTela.capturaTela("validacao registro com sucesso");
		} catch (Exception e) {
			CapturaTela.capturaTela("erro na validacao ");
			throw new RuntimeException(e);
		}
	}

	
	public String total() {
	 return totalGuarda;
	}
	
	
}
