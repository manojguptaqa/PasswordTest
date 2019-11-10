package PasswordMethods;

import java.io.File;
import java.util.Date;
import com.aventstack.extentreports.AnalysisStrategy;

//

//http://relevantcodes.com/Tools/ExtentReports2/javadoc/index.html?com/relevantcodes/extentreports/ExtentReports.html

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	private static ExtentReports extent;
	private static ExtentHtmlReporter htmlReporter;

	private static ThreadLocal<ExtentTest> parentTest;
	private static ThreadLocal<ExtentTest> currentTest;

	public static ExtentReports GetExtent() {
		if (extent != null)
			return extent; // avoid creating new instance of html file
		extent = new ExtentReports();
		extent.attachReporter(getHtmlReporter());
		extent.setAnalysisStrategy(AnalysisStrategy.TEST);
		return extent;
	}

	private static ExtentHtmlReporter getHtmlReporter() {

		Date d = new Date();
		String fileName = "TestReport" + "_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
String folderPath=System.getProperty("user.dir") + "/TestReports/";
		
		File f = new File(folderPath);
		
		if(!f.exists() ) { 
		    f.mkdir();
		}
		
		File file = new File(folderPath+fileName);
		
		 
		htmlReporter = new ExtentHtmlReporter(file);

		htmlReporter.config().setChartVisibilityOnOpen(true);


		htmlReporter.config().setChartVisibilityOnOpen(false);
		htmlReporter.config().setDocumentTitle("Agoda Tests");
		htmlReporter.config().setEncoding("UTF-8");
		htmlReporter.config().setProtocol(Protocol.HTTPS);
		htmlReporter.config().setReportName("Agoda Test Automation Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("mm/dd/yyyy hh:mm:ss a");

		return htmlReporter;
	}

	public static ThreadLocal<ExtentTest> getParentTest() {
		if (parentTest == null)
			parentTest = new ThreadLocal<ExtentTest>();

		return parentTest;

	}

	public static ThreadLocal<ExtentTest> getCurrentTest() {
		if (currentTest == null)
			currentTest = new ThreadLocal<ExtentTest>();

		return currentTest;

	}

	public static void setParentTest(ExtentTest test) {
		getParentTest();
		parentTest.set(test);

	}

	public static void setCurrentTest(ExtentTest test) {
		getCurrentTest();
		currentTest.set(test);

	}

}