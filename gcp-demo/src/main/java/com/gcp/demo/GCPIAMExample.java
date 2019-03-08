package com.gcp.demo;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.iam.v1.Iam;
import com.google.api.services.iam.v1.Iam.IamPolicies;
import com.google.api.services.iam.v1.Iam.IamPolicies.QueryAuditableServices;
import com.google.api.services.iam.v1.IamScopes;
import com.google.api.services.iam.v1.model.ListRolesResponse;
import com.google.api.services.iam.v1.model.QueryAuditableServicesRequest;
import com.google.api.services.iam.v1.model.Role;
import com.google.api.services.iam.v1.model.ServiceAccount;
import com.google.api.services.iam.v1.model.ServiceAccountKey;

import java.util.Collections;
import java.util.List;

public class GCPIAMExample {

	public static void main(String[] args) throws Exception {
		// Get credentials
		GoogleCredential credential = GoogleCredential.getApplicationDefault()
				.createScoped(Collections.singleton(IamScopes.CLOUD_PLATFORM));

		// Create the Cloud IAM service object
		Iam service = new Iam.Builder(GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(),
				credential).setApplicationName("quickstart").build();

		IamPolicies policies=service.iamPolicies();
		
		 QueryAuditableServicesRequest request =new QueryAuditableServicesRequest();
		 
		QueryAuditableServices policiesr=policies.queryAuditableServices(request);
		
/*		// Call the Cloud IAM Roles API
		ListRolesResponse response = service.roles().list().execute();
		List<Role> roles = response.getRoles();

		// Process the response
		for (Role role : roles) {
			System.out.println("Title: " + role.getTitle());
			System.out.println("Name: " + role.getName());
			System.out.println("Description: " + role.getDescription());
			System.out.println();
		}
*/
		/*ServiceAccounts sc = new ServiceAccounts();
		List<ServiceAccount> sa=sc.listServiceAccounts("utility-emitter-228206");
		ServiceAccountKeys keys= new ServiceAccountKeys();
		for (ServiceAccount serviceAccount : sa) {
			List<ServiceAccountKey> serviceaccountKeys=keys.listKeys(serviceAccount.getEmail());
			for (ServiceAccountKey serviceAccountKey : serviceaccountKeys) {
				System.out.println(serviceAccountKey);
				System.out.println(serviceAccountKey.getValidAfterTime());
				System.out.println(serviceAccountKey.getPublicKeyData());
				System.out.println(serviceAccountKey.getPrivateKeyData());
			}
		}
		*/
		CloudResourceManagerExample e=new CloudResourceManagerExample();
		e.listIamPolicies();
		
	}
}