package tesTngGeral;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
	
	//Essa classe eu tenho o dataprovider e posso chamar ela em outra class passando @Test(dataProvider = "Authentication",dataProviderClass = TestDataProvider.class)
	  @DataProvider(name = "Authentication") 
	  public static Object[][] credentials() {
	 
	        return new Object[][] { { "11111111111", "123456" }, { "11111111111", "123456" }};
//	        return new Object[][] { { "", "" }, { "", "" }};
	 
	  }

}
