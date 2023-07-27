package api.tests;

import api.endpoints.AssignmentSubEndPoints;

import api.payload.Submissionpayload;
import api.utilities.Loggerload;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.experimental.theories.internal.Assignments;
import org.testng.Assert;

import com.github.javafaker.Faker;

import Global.GlobalVar;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class AssignmentSubTests {

	static Faker faker = new Faker();
	 
	ValidatableResponse valresponseschema;

	public static Response response;
	public static String extractresponse;
	public static int actualcode;
	public static int subid;
	public static  int id;
	public static String duedate;
 
	public void TestPostUser(String subDesc,String subComments,String subPathAttach1,String subPathAttach2,String subPathAttach3,String subPathAttach4,String subPathAttach5)
	{		
		Submissionpayload userPayload=new Submissionpayload();	
		 id=GlobalVar.assignmentId;
		userPayload.setAssignmentId(GlobalVar.assignmentId);
		userPayload.setUserId(GlobalVar.userId);
		userPayload.setSubDesc(subDesc);
		userPayload.setSubComments(subComments);
		userPayload.setSubPathAttach1(subPathAttach1);
		userPayload.setSubPathAttach2(subPathAttach2);
		userPayload.setSubPathAttach3(subPathAttach3);	
		userPayload.setSubPathAttach4(subPathAttach4);
		userPayload.setSubPathAttach5(subPathAttach5);			
		LocalDateTime currentDate = LocalDateTime.now();
		String subdate= currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		userPayload.setSubDateTime(subdate);

	LocalDateTime currentDate1 = LocalDateTime.now();
			//SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//.format(DateTimeFormatter.ofPattern("yyyy-MMM-dd HH:mm:ss"))
			String duedate= currentDate1.plusDays(2).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		
			System.out.println("subdate is "+subdate);
		System.out.println("duedate is "+duedate);
		userPayload.setGradedBy(GlobalVar.userId);
		userPayload.setGradedDateTime(duedate);
		userPayload.setGrade(-1); 
		Loggerload.info("*********************** Submitting Assignment*************");
		
		response= AssignmentSubEndPoints.createAssignsub(userPayload);
		response.then().log().all();
		extractresponse=response.then().log().all().extract().response().asString();
		actualcode=response.getStatusCode();
		JsonPath js=new JsonPath(extractresponse);
		System.out.println("assignment id :"+id);
			subid=js.getInt("submissionId");
			System.out.println("value of id"+subid);
			GlobalVar.varforsubid=subid;	
		
			Assert.assertEquals(actualcode,201);
			response.then().log().all();

			Loggerload.info("*********************** status is been verified ****************");
		
		
		Loggerload.info("*********************** successfully assignment submitted ****************");
	}
	public void TestPostUserneg(String assignid,String userID,String subDesc,String subComments,String subPathAttach1,String subPathAttach2,String subPathAttach3,String subPathAttach4,String subPathAttach5)

	{
		Submissionpayload userPayload=new Submissionpayload();
		
		userPayload.setAssignmentId(1471);
		userPayload.setUserId(userID);
		userPayload.setSubDesc(subDesc);
		userPayload.setSubComments(subComments);
		userPayload.setSubPathAttach1(subPathAttach1);
		userPayload.setSubPathAttach2(subPathAttach2);
		userPayload.setSubPathAttach3(subPathAttach3);	
		userPayload.setSubPathAttach4(subPathAttach4);
		userPayload.setSubPathAttach5(subPathAttach5);			
		LocalDateTime currentDate = LocalDateTime.now();
		String subdate= currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		userPayload.setSubDateTime(subdate);

	LocalDateTime currentDate1 = LocalDateTime.now();
			//SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//.format(DateTimeFormatter.ofPattern("yyyy-MMM-dd HH:mm:ss"))
			String duedate= currentDate1.plusDays(2).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		userPayload.setSubDateTime(subdate);
		userPayload.setGradedBy(userID);
		userPayload.setGradedDateTime(duedate);
		userPayload.setGrade(-1);
		Loggerload.info("*********************** Assignment submission for negative scenario****************");
		response= AssignmentSubEndPoints.createAssignsub(userPayload);
		response.then().log().all();
		actualcode=response.getStatusCode();
		Assert.assertEquals(actualcode,200);
		response.then().log().all();

		Loggerload.info("*********************** status is been verified ****************");
		
	}
	
	
	public void TestputUpdate(String subDesc,String subComments,String subPathAttach1,String subPathAttach2,String subPathAttach3,String subPathAttach4,String subPathAttach5)
	{
		

		
			Submissionpayload userPayload=new Submissionpayload();
			
			userPayload.setAssignmentId(GlobalVar.assignmentId);
			userPayload.setUserId(GlobalVar.userId);
			userPayload.setSubDesc(subDesc);
			userPayload.setSubComments(subComments);
			userPayload.setSubPathAttach1(subPathAttach1);
			userPayload.setSubPathAttach2(subPathAttach2);
			userPayload.setSubPathAttach3(subPathAttach3);	
			userPayload.setSubPathAttach4(subPathAttach4);
			userPayload.setSubPathAttach5(subPathAttach5);			

		LocalDateTime currentDate = LocalDateTime.now();
			String subdate= currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			userPayload.setSubDateTime(subdate);

		LocalDateTime currentDate1 = LocalDateTime.now();
				//SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//.format(DateTimeFormatter.ofPattern("yyyy-MMM-dd HH:mm:ss"))
				String duedate= currentDate1.plusDays(2).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			
			System.out.println("duedate is "+duedate);
			userPayload.setGradedBy(GlobalVar.userId);
			userPayload.setGradedDateTime(duedate);
			userPayload.setGrade(1);
			 
			Loggerload.info("*********************** Put request resubmit assignment*************");
			GlobalVar.assignmentId=subid;
			response= AssignmentSubEndPoints.updateAssignSub(GlobalVar.assignmentId,userPayload);
			response.then().log().ifValidationFails();
			response.then().log().all();
			actualcode=response.getStatusCode();
			Loggerload.info("*********************** Put request resubmit assignment updated *************");
	
	}
	public void Testputgrade(String assingid,String uid,String subDesc,String subComments,String subPathAttach1,String subPathAttach2,String subPathAttach3,String subPathAttach4,String subPathAttach5)
	{
		

		{
			Submissionpayload userPayload=new Submissionpayload();
			//int assingmentidint=Integer.parseInt(assignmentid);
			userPayload.setAssignmentId(GlobalVar.assignmentId);
			userPayload.setUserId(GlobalVar.userId);
			userPayload.setSubDesc(subDesc);
			userPayload.setSubComments(subComments);
			userPayload.setSubPathAttach1(subPathAttach1);
			userPayload.setSubPathAttach2(subPathAttach2);
			userPayload.setSubPathAttach3(subPathAttach3);	
			userPayload.setSubPathAttach4(subPathAttach4);
			userPayload.setSubPathAttach5(subPathAttach5);			
			LocalDateTime currentDate = LocalDateTime.now();
			String subdate= currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			userPayload.setSubDateTime(subdate);

		LocalDateTime currentDate1 = LocalDateTime.now();
				//SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//.format(DateTimeFormatter.ofPattern("yyyy-MMM-dd HH:mm:ss"))
				String duedate= currentDate1.plusDays(2).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			userPayload.setSubDateTime(subdate);
			
//			Date dt = new Date();
//		    SimpleDateFormat dateFormat = 
//		    		new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//		    String dueDate = dateFormat.format(dt);
			System.out.println("duedate is "+duedate);
			userPayload.setGradedBy(GlobalVar.userId);
			userPayload.setGradedDateTime(duedate);
			userPayload.setGrade(1);
			 
			Loggerload.info("*********************** put for grade submission User *************");
			
			response= AssignmentSubEndPoints.updategradeSub(1528,userPayload);
//			response.then().log().ifValidationFails();
			response.then().log().all();
			actualcode=response.getStatusCode();
	}
	}
	

	public void verify_post_status(int code) {
		Assert.assertEquals(actualcode,code);
		response.then().log().all();

		Loggerload.info("*********************** status is been verified ****************");
	}

	public void testgetAssignmentbyid(int id) {
		
		response=AssignmentSubEndPoints.getAllAssignmentsbyID(id);
		response.then().log().all();
		Loggerload.info("-------------details retrieved by assignment id ------------------");
	}

	public void TestGetUser()

	{

		Loggerload.info("*********************** Retriving User *************");
		valresponseschema= AssignmentSubEndPoints.getAllAssignments();
		//int subid=getresponse.jsonPath(response.asString()).getInt("submissionID");//.getString("submissionID");// post request url here 
		
		response.then().log().all();
	}
	public void TestgetgradesbybatchID(int batchid)
	{
		Loggerload.info("------------ grades by batchid-----------");
		response=AssignmentSubEndPoints.getGradesbybatchid(batchid);
		response.then().log().all();
	}
	public void TestgetgradesbyuserID(String studeid)
	
	{
		Loggerload.info("------------ grades by userid-----------");
		response=AssignmentSubEndPoints.getGradesbyuserid(studeid);
		response.then().log().all();
	}

	public void TestgetgradesbysubUserID(String subuserid) {
		Loggerload.info("------------ grades by submission by userid-----------");
		response=AssignmentSubEndPoints.getGradesbysubUserid(subuserid);
		response.then().log().all();
	}
	public void TestgetgradesbysubBatchID(int batchid) {
		Loggerload.info("------------ grades by submission by batchid-----------");
		response=AssignmentSubEndPoints.getGradesbysubUserid(batchid);
		response.then().log().all();
		
	}	

	
	public void verify_get_status()

	{

		Assert.assertEquals(response.getStatusCode(),200);	
		//System.out.println(response.getCode())
		Assert.assertEquals(response.contentType(),"application/json");
		 Assert.assertEquals(response.header("Content-Type"),"application/json");
		 response.headers().get("Transfer-Encoding").equals("chunked");
		 Header value=response.headers().get("Connection");
		 System.out.println("header connections"+value);
		 Assert.assertEquals(value,"Connection=keep-alive");
		 long time = response.getTime();
		 System.out.println("time is------"+time);
		 Assert.assertEquals(time,200);
		 System.out.println("----------"+response.getSessionId()+"------");
		 System.out.println("------"+response.cookie(""));
		 response.then().log().ifValidationFails(LogDetail.METHOD);
		 response.then().log().ifValidationFails(LogDetail.BODY);
		 RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

		// To log request and response header
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.HEADERS);
		Loggerload.info("***********************  details are Displayed *************");

	}	

		

		public void TestDeleteUser(int int1 )

		{

			Loggerload.info("*********************** Deleting User *************");

			response= AssignmentSubEndPoints.deleteAssignsub(int1);

			//afterdelresponse.then().log().all();

		}
		
		
		public void Testnegscenario()
		{
			Assert.assertEquals(response.getStatusCode(),404);
			Loggerload.info("");
			extractresponse=response.then().log().all().extract().response().asString();
			JsonPath jsneg=new JsonPath(extractresponse);
			
			String resboolean=jsneg.getString("success");
			System.out.println("response boolean validation is success with :"+resboolean);
		
			response.then().log().ifValidationFails();
			
		}

		

		
	

	



}


