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

public class PasswordValidationTest extends BaseTest{
  @Test(dataProvider = "dp",description="Validate input password comply with password rules.")
	public void PasswordValidationTests(Password data) {

		ExtentManager.getCurrentTest().get().info("<b>Test Data:</b></br>" + data.toString());
		System.out.println("***************************************");
		System.out.println("Password validation Test started....");

		System.out.println(data.toString());
		System.out.println("Expected Output: " + data.getExpectedMessage());

		boolean actualResult = PasswordImpl.is_Valid_Password(data.getNewPassword());

		boolean expectedResult = data.getExpectedResult().equals(ExpectedResult.Valid.getExpectedResult()) ? true
				: false;

		System.out.println("Expected Result: " + expectedResult);
		System.out.println("Actual Result: " + actualResult);

		Assert.assertTrue(actualResult == expectedResult, "Expected was " + data.getExpectedMessage());

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
