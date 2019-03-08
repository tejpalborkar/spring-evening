package com.gcp.demo;

import java.util.Collections;

import com.google.cloud.MonitoredResource;
import com.google.cloud.logging.LogEntry;
import com.google.cloud.logging.Logging;
import com.google.cloud.logging.LoggingOptions;
import com.google.cloud.logging.Payload.StringPayload;
import com.google.cloud.logging.Severity;

/**
 * This sample demonstrates writing logs using the Stackdriver Logging API. The
 * library also offers a java.util.logging Handler
 * `com.google.cloud.logging.LoggingHandler` Logback integration is also
 * available : https://goo.gl/DNMoRh Using the java.util.logging handler /
 * Logback appender should be preferred to using the API directly.
 */
public class QuickstartSample {

	/** Expects a new or existing Stackdriver log name as the first argument. */
	public static void main(String... args) throws Exception {

		// Instantiates a client
		Logging logging = LoggingOptions.getDefaultInstance().getService();

		// The name of the log to write to
		String logName = "my-log-tejpal"; // "my-log";

		
		// The data to write to the log
		String text = "Hello, world!";

		LogEntry entry = LogEntry.newBuilder(StringPayload.of(text)).setSeverity(Severity.ERROR).setLogName(logName)
				.setResource(MonitoredResource.newBuilder("global").build()).build();

		// Writes the log entry asynchronously
		logging.write(Collections.singleton(entry));

		System.out.printf("Logged: %s%n", text);
	}
}