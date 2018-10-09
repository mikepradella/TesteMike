package funcionalidadesUtils;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * @author t-mike.pradella
 *
 */
public class FuncionalidadeUteis {
	WebDriver driver;
	Actions  acao;
	JavascriptExecutor jse;	
	Robot robot;
	
	public FuncionalidadeUteis(WebDriver driver) {
		this.driver =driver;
		acao =new Actions(driver);
		jse = (JavascriptExecutor)driver;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void clicarBotaoDireitoMouse(WebElement elemento) {				
		acao.contextClick(elemento).perform();
	}
				
	
	public static void selecionarOpcaoDropDrownPorTexto(WebElement eLementoDropdown,String texto) {
		Select  porTextos = new Select(eLementoDropdown);	 
		porTextos.selectByVisibleText(texto);
	}
	
	public void duploCliqe(WebElement elemento) {
		acao.doubleClick(elemento).perform();		
	}
	
	
	// nao funcionou 
	public void focoElementoJavaScript(WebElement elemento) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("document.getElementById('elemento').focus();");		
	}
	
	public void scrollElementoJavaScript(WebElement elemento) {
		 jse.executeScript("arguments[0].scrollIntoView(true);",elemento);		
	}
	
	public void highlightingElementoJavaScript(WebElement elemento) {
		 jse.executeScript("arguments[0].setAttribute('style',arguments(1));",elemento,"background:"+"yellow;color:Red;border:4px dotted solid yellow;");		
	}
	
	
	
	
	// metodo que move para o elemento que recebe no paramentro 
	//e clica sobre o elemento
	public void moveMouseElemento(WebElement elemento) {
		acao.moveToElement(elemento).perform();		
	}
	
	public void clicarJavaScript(WebElement elemento) {
		
		if (elemento.isEnabled() && elemento.isDisplayed()) {
			  jse.executeScript("arguments[0].click();", elemento);			  
			  CapturaTela.capturaTela("clique aba Tomador com sucesso");	
		} else {
				System.out.println("nao houve click on elemento");
				CapturaTela.capturaTela("nao houve click on elemento");
		}	  
	}
	
	

	
	public static void scrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView();", element);
    }
	 
	
	public static void scrollToBottom(WebDriver driver) {
	        ((JavascriptExecutor) driver)
	                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	
	// seleciona elemento na lista(DROPDOWN) com TEXTO
	public static void selecionarValorPorTextoDropDown(WebElement element) {
		
		try{			
		
		List<WebElement> options = element.findElements(By.tagName("li"));

		for (WebElement option : options) {

		if(element.equals(option.getText()))

		 option.click();   
		}				
			CapturaTela.capturaTela("selecionado com sucesso");
		} catch (Exception e) {
			CapturaTela.capturaTela("erro ao selecionar ");
			throw new RuntimeException(e);
		}
	}
	
	
}
