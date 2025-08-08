package com.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
 int retry_limit=3;
 int retry_count=0;
 
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if (retry_count < retry_limit) {
			retry_count++;
		      return true;
		    }
		
		return false;
	}

}
