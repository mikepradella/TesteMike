package funcionalidadesUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class CapturaTela extends IniciarBrowser{
	
	public CapturaTela() {
		super();
	}
	
	public static  void capturaTela(String idNome) {

		// pega a captura de tela e armazena em formato de arquivo
		// Take screenshot and store as a file format
		try {
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
//			LocalDateTime atual = LocalDateTime.now();
			Date data = new Date();
			SimpleDateFormat dataformatado = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
			String dataFormatada = dataformatado.format(data).replace(":", "-");
			
		 // now copy the  screenshot to desired location using copyFile //method
		String path = System.getProperty("user.dir");
		FileUtils.copyFile(src, new File(path + "\\target\\evidencias\\"+ idNome +" "+ dataFormatada +".PNG"));
		}
		 
		catch (IOException e)
		 {
		  System.out.println("Erro ao capturar a tela do navegador"+ e.getMessage());
	}}
}
