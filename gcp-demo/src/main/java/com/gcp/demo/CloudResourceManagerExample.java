package com.gcp.demo;

/*
 * BEFORE RUNNING:
 * ---------------
 * 1. If not already done, enable the Cloud Resource Manager API
 *    and check the quota for your project at
 *    https://console.developers.google.com/apis/api/cloudresourcemanager
 * 2. This sample uses Application Default Credentials for authentication.
 *    If not already done, install the gcloud CLI from
 *    https://cloud.google.com/sdk and run
 *    `gcloud beta auth application-default login`.
 *    For more information, see
 *    https://developers.google.com/identity/protocols/application-default-credentials
 * 3. Install the Java client library on Maven or Gradle. Check installation
 *    instructions at https://github.com/google/google-api-java-client.
 *    On other build systems, you can add the jar files to your project from
 *    https://developers.google.com/resources/api-libraries/download/cloudresourcemanager/v1/java
 */
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.cloudresourcemanager.CloudResourceManager;
import com.google.api.services.cloudresourcemanager.CloudResourceManager.Projects;
import com.google.api.services.cloudresourcemanager.model.GetIamPolicyRequest;
import com.google.api.services.cloudresourcemanager.model.Policy;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;

public class CloudResourceManagerExample {
	String resource = "utility-emitter-228206"; // TODO: Update placeholder value.

	public static void main(String args[]) throws IOException, GeneralSecurityException {
		// REQUIRED: The resource for which the policy is being requested.
		// See the operation documentation for the appropriate value for this field.

		// TODO: Assign values to desired fields of `requestBody`:
		GetIamPolicyRequest requestBody = new GetIamPolicyRequest();
		String resource = "utility-emitter-228206";
		CloudResourceManager cloudResourceManagerService = createCloudResourceManagerService();
		
		Projects projects =cloudResourceManagerService.projects();
		CloudResourceManager.Projects.GetIamPolicy request = cloudResourceManagerService.projects()
				.getIamPolicy(resource, requestBody);

		Policy response = request.execute();

		// TODO: Change code below to process the `response` object:
		System.out.println(response);
	}

	public static CloudResourceManager createCloudResourceManagerService()
			throws IOException, GeneralSecurityException {
		HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
		JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();

		GoogleCredential credential = GoogleCredential.getApplicationDefault();
		if (credential.createScopedRequired()) {
			credential = credential.createScoped(Arrays.asList("https://www.googleapis.com/auth/cloud-platform"));
		}

		return new CloudResourceManager.Builder(httpTransport, jsonFactory, credential)
				.setApplicationName("utility-emitter-228206").build();
	}

	public void listIamPolicies() {

		// TODO: Assign values to desired fields of `requestBody`:
		GetIamPolicyRequest requestBody = new GetIamPolicyRequest();

		CloudResourceManager.Projects.GetIamPolicy request;
		try {
			CloudResourceManager cloudResourceManagerService = createCloudResourceManagerService();
			request = cloudResourceManagerService.projects().getIamPolicy(resource, requestBody);
			Policy response = request.execute();
			System.out.println(response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}