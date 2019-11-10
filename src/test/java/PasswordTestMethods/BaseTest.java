package PasswordTestMethods;

import java.lang.reflect.Method;


import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import PasswordMethods.ExtentManager;

public abstract class BaseTest {
	
	private static ExtentReports extent;	
	
	@BeforeSuite
	public void beforeSuite() {
		extent = ExtentManager.GetExtent();
		
		System.out.println("Test Started.................");
	}
	
    @BeforeClass
    public synchronized void beforeClass() {
        ExtentTest parent = extent.createTest(getClass().getName().substring(getClass().getName().indexOf(".")+1)).assignAuthor("Manoj Gupta");
        ExtentManager.setParentTest(parent);
    }

    @BeforeMethod
    public synchronized void beforeMethod(Method method) {    	
    	Test test = method.getAnnotation(Test.class);
    	String TestCaseName=method.getName();
        ExtentTest child = ExtentManager.getParentTest().get().createNode("<b>"+TestCaseName+"</b>", test.description());
        ExtentManager.setCurrentTest(child);
        
    }

    @AfterMethod
    public synchronized void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE)
        { String message=result.getThrowable().getMessage();
        if(!message.equals(""))
        {
        	ExtentManager.getCurrentTest().get().fail(message);
        }
        else
        	ExtentManager.getCurrentTest().get().fail(result.getThrowable());
        
        }
        else if (result.getStatus() == ITestResult.SKIP)
        	ExtentManager.getCurrentTest().get().skip(result.getThrowable());
        else
        	ExtentManager.getCurrentTest().get().pass("Test passed");

        extent.flush();
    }
    
   
    @AfterSuite
	public void afterSuite() {
		extent = ExtentManager.GetExtent();
		
		System.out.println("Test Finished.................");
	}
   
}

