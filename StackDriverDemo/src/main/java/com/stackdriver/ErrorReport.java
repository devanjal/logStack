package com.stackdriver;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.fluentd.logger.FluentLogger;

public class ErrorReport {
	private static FluentLogger LOGGER = FluentLogger.getLogger("errorReport");
	public static void main(String[] args) {

		try {
			throw new Exception("General Error");
		}catch(Exception e) {
			StringWriter exceptionWriter = new StringWriter();
		    e.printStackTrace(new PrintWriter(exceptionWriter));
			Map<String, Object> errorData = new HashMap<String, Object>();
			errorData.put("message", exceptionWriter.toString());
			LOGGER.log("error", errorData);
		}
		Map<String, Object> data = new HashMap<String, Object>();
	    data.put("message", "Some Logger");
	    Map<String,String> serviceContextData = new HashMap<String,String>();
	    serviceContextData.put("service", "errorReport");
	    data.put("serviceContext", serviceContextData);
	    LOGGER.log("info", data);
	    

	}

}
