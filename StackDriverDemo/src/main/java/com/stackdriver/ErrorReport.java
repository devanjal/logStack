package com.stackdriver;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.fluentd.logger.FluentLogger;

public class ErrorReport {
	private static FluentLogger LOGGER = FluentLogger.getLogger(ErrorReport.class.getName());
	public static void main(String[] args) {

		try {
			throw new Exception("General Error");
		}catch(Exception e) {
			StringWriter exceptionWriter = new StringWriter();
		    e.printStackTrace(new PrintWriter(exceptionWriter));
//			Map<String, Object> errorData = new HashMap<String, Object>();
//			errorData.put("message", exceptionWriter.toString());
//			LOGGER.log("error", errorData);
			LOGGER.log("error",exceptionWriter.toString() , ErrorReport.class.getName());
		}
	    LOGGER.log("info", "Simple Entry", ErrorReport.class.getName());
	    

	}

}
