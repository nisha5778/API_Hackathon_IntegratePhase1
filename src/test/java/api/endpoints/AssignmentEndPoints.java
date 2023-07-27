package api.endpoints;
import static io.restassured.RestAssured.given;

import com.google.gson.JsonObject;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import api.payload.*;

public class AssignmentEndPoints {
	public static ValidatableResponse createAssignment(AssignmentPayload assignmentPayload){
		ValidatableResponse vResponse = given().contentType(ContentType.JSON).
				body(assignmentPayload).when().post(Routes.postAssignment_url).
				then().assertThat().body(JsonSchemaValidator.
				matchesJsonSchemaInClasspath("SVAssignment.json")); 
		return vResponse;
	}
	
	public static Response readAllAssignments() {
		Response response = given().get(Routes.getAllAssignments_url);
		return response;
	}
	
	public static Response readAssignmentByAssignmentId(int id ) {
		Response response = given().pathParam("id", id).
				when().get(Routes.getAssignmentByAssignmentId_url);
		return response;
	}
	
	public static Response readAssignmentsByBatchId(int batchId) {
		Response response = given().pathParam("batchId", batchId).
				when().get(Routes.getAssignmentsByBatchId_url);
		return response;
	}
	
	public static Response updateAssignment(int id, AssignmentPayload payload ) {
		
//		Response response = given().contentType(ContentType.JSON).
//				pathParam("id", id).
//				body(payload).when().put(Routes.putAssignment_url);
//		return response;		
//		
		Response response=given()
				.contentType(ContentType.JSON)//in swagger document header and content type is present that is passed here 
				.accept(ContentType.JSON)
				.auth().none()
				.pathParam("id",id)
				.body(payload)
				.when()
			.put(Routes.putAssignment_url);// post request url here 
			
			return response;
	}

	public static Response deleteAssignment(int id) {
		Response response = given().pathParam("id", id).
				when().delete(Routes.deleteAssignment_url);
		return response;	
	}
}