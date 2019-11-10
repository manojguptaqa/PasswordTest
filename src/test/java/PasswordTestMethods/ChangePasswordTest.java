package PasswordTestMethods;

import org.testng.annotations.Test;

import Enum.ExpectedResult;
import JsonReader.JsonDataReader;
import PasswordMethods.ExtentManager;
import PasswordMethods.PasswordImpl;
import UtilityClasses.Password;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class ChangePasswordTest extends BaseTest{
  
  @Test(dataProvider = "dp",description="Validate change password function.")
  public void PasswordChangeTests(Password data) {
	  
	  ExtentManager.getCurrentTest().get().info("<b>Test Data:</b></br>"+data.toString());
	  System.out.println("***************************************");
	  System.out.println("Password Change Test started....");
	  
	  System.out.println(data.toString());
	  System.out.println("Expected Output: "+data.getExpectedMessage());
	  
	  
	  boolean actualResult=PasswordImpl.changePassword(data.getOldPassword(),data.getNewPassword(),data.getOldPasswordMatched());

	  boolean expectedResult=data.getExpectedResult().equals(ExpectedResult.Valid.getExpectedResult())?true:false;
	  
	  
	  System.out.println("Expected Result: "+expectedResult);
	  System.out.println("Actual Result: "+actualResult);
	  
	 Assert.assertTrue(actualResult==expectedResult,"Expected was "+data.getExpectedMessage());
	 System.out.println("***************************************");
	  System.out.println("-----------------------------------------------------");
	  
	  System.out.println("\n");
	  
  }

  
  
  
  @DataProvider
  public Object[][] dp() {

	  JsonDataReader json=new JsonDataReader();
	  List<Password> testData=json.getJSONTestData();
	  System.out.println(testData.size());
	  
	  Object[][] data;
		data=new Object[testData.size()][1];
		for(int i=0;i<testData.size();i++)
		{
			data[i][0]=testData.get(i);
			
		}
		
		return data;

	  
  }
}
