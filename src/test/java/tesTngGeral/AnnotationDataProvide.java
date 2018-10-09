package tesTngGeral;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AnnotationDataProvide {

	//@Test(dataProvider="loginData")
	
	@Test(dataProvider="loginTestData")
	private void Test1(String username,String passaword) {
		System.out.println(username);
		System.out.println(passaword);
		System.out.println("Test passed");
		
	}
	
	
//	@DataProvider
	@DataProvider(name="loginTestData")
	public Object[][] loginData()
	{
	String[][] testData= {{"UserName1","Passaword1"},{"UserName2","Passaword2"}
				
	};
	return testData;	
	}
	
	
}
