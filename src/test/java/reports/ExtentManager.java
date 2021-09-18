package reports;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.util.Date;

public class ExtentManager {
    
    private static ExtentReports extent;
    public static String screenshotFolderPath;
    
    public static ExtentReports getInstance(String reportPath) {
    	if (extent == null){
    		// generate report folder
    		String fileName="Report.html";
    		Date d = new Date();
    		String folderName=d.toString().replace(":", "_");
    		
    		// directory of the report folder
    		new File(reportPath+folderName+"//screenshots").mkdirs();
    		
    		reportPath=reportPath+folderName+"//";
    		screenshotFolderPath=reportPath+"screenshots//";
    		System.out.println(reportPath+fileName);
    		createInstance(reportPath);
    	}
    	
        return extent;
    }
    
    public static ExtentReports createInstance(String reportPath) {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        /*sparkReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        sparkReporter.config().setChartVisibilityOnOpen(true);*/
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setDocumentTitle("Reports");
        sparkReporter.config().setEncoding("utf-8");
        sparkReporter.config().setReportName("Reports - Automation Testing");
        
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        
        return extent;
    }
}