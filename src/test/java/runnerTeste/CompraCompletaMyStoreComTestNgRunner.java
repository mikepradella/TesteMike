package runnerTeste;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

	@RunWith(Cucumber.class)
	@CucumberOptions(
	//plugin= {"json:target/cucumber.json","pretty"},
	plugin= {"pretty","json:target/cucumber-reports/Cucumber.json","html:target/cucumber-reports","junit:target/cucumber-reports/Cucumber.xml"},
	//plugin= {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
			//usado para formatar a saida no console com os cenarios
	//monochrome = true deixa bonito console
	monochrome = true,
	features="C:\\Users\\t-mike.pradella\\eclipse-workspace\\TesteMike\\src\\test\\resources\\Features",
	tags= {"@compraCompleta"},
	glue= {"compraCompletaMyStoreStepDefiniton"})
public class CompraCompletaMyStoreComTestNgRunner extends AbstractTestNGCucumberTests {
		
	}
	
	 