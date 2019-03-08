package com.gcp.demo;
/*
 * BEFORE RUNNING:
 * ---------------
 * 1. If not already done, enable the Compute Engine API
 *    and check the quota for your project at
 *    https://console.developers.google.com/apis/api/compute
 * 2. This sample uses Application Default Credentials for authentication.
 *    If not already done, install the gcloud CLI from
 *    https://cloud.google.com/sdk and run
 *    `gcloud beta auth application-default login`.
 *    For more information, see
 *    https://developers.google.com/identity/protocols/application-default-credentials
 * 3. Install the Java client library on Maven or Gradle. Check installation
 *    instructions at https://github.com/google/google-api-java-client.
 *    On other build systems, you can add the jar files to your project from
 *    https://developers.google.com/resources/api-libraries/download/compute/v1/java
 

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.compute.Compute;
import com.google.api.services.compute.model.Instance;
import com.google.api.services.compute.model.InstanceList;

public class ComputeExample {
	public static void main(String args[]) throws IOException, GeneralSecurityException {
		// Project ID for this request.
		String project = "utility-emitter-228206"; // TODO: Update placeholder value.

		// The name of the zone for this request.
		String zone = "us-east1-b"; // TODO: Update placeholder value.

		Compute computeService = createComputeService();
		Compute.Instances.List request = computeService.instances().list(project, zone);

		InstanceList response;
		do {
			response = request.execute();
			if (response.getItems() == null) {
				continue;
			}
			for (Instance instance : response.getItems()) {
				// TODO: Change code below to process each `instance` resource:
				System.out.println(instance);
			}
			request.setPageToken(response.getNextPageToken());
		} while (response.getNextPageToken() != null);
	}

	public static Compute createComputeService() throws IOException, GeneralSecurityException {
		HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
		JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();

		GoogleCredential credential = GoogleCredential.getApplicationDefault();
		if (credential.createScopedRequired()) {
			credential = credential.createScoped(Arrays.asList("https://www.googleapis.com/auth/cloud-platform"));
		}

		return new Compute.Builder(httpTransport, jsonFactory, credential)
				.setApplicationName("Google-ComputeSample/0.1").build();
	}
}*/