package com.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
 int retry_limit;
 int retry_count=0;
 
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		retry_limit=Integer.parseInt(System.getProperty("retry-count"));
		if (retry_count < retry_limit) {
			retry_count++;
		      return true;
		    }
		
		return false;
	}

}
