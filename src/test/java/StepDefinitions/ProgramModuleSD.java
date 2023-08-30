package StepDefinitions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

//import java.util.ArrayList;
//import static org.hamcrest.Matchers.equalTo;
//import static org.hamcrest.Matchers.instanceOf;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import Endpoints.URLs;
import Utilities.ExcelReader;
import Utilities.LoggerLoad;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
import testdata.APITestData;


public class ProgramModuleSD extends APITestData  {
	
	Random rand = new Random();
	ExcelReader ER = new ExcelReader();   
	Response response;
	public static int programId1,programId2 ;
	public static String programName1, programName2;
	
	 
   
	@Given("User sets Authoization to No  Auth.")
	public void user_sets_authoization_to_no_auth() {
	   given().auth().none();
	}

	@Given("User creates POST Request {string} and {int} for the LMS API endpoint")
	public void user_creates_post_request_and_for_the_lms_api_endpoint(String Sheetname, Integer rownumber) throws Exception {
		Response[] responses = null;
	HashMap<String,Object>map = new HashMap<String,Object>(); 
		List<Map<String, String>>data = ER.getData(URLs.excelpath, Sheetname);
	      map.put("programDescription",data.get(rownumber).get("programDescription") );
			map.put("programName", data.get(rownumber).get("programName") + rand.nextInt(1000));
			map.put("programStatus", data.get(rownumber).get("programStatus"));
			response = RestAssured.given().spec(createProgram()).body(map).when().post();
			if (responses == null) {
	            responses = new Response[data.size()];
	        }
	        responses[rownumber] = response;
	        responses[rownumber].then().log().all();
	        if (rownumber == 0) {
	         Response   storedResponse1 = responses[rownumber];
	         programName1 = storedResponse1.jsonPath().getString("programName");
	         programId1 = storedResponse1.jsonPath().getInt("programId");
	        } else if (rownumber == 1) {
	           Response storedResponse2 = responses[rownumber];
	           programName2 = storedResponse2.jsonPath().getString("programName");
		         programId2 = storedResponse2.jsonPath().getInt("programId");
	           
	        }
	}

	@When("User sends HTTPS Request and  request Body with mandatory , additional  fields.")
	public void user_sends_https_request_and_request_body_with_mandatory_additional_fields() {
		
		
		System.out.println(programName1);
		System.out.println(programName2);
		System.out.println(programId1);
		System.out.println(programId2);
		LoggerLoad.info("the response of the rquest is " + response);
	}

	@Then("User receives {int} Created Status with response body.")
	public void user_receives_created_status_with_response_body(Integer int1) {
	    response.then().statusCode(201)
	    .body("programName", containsString("Sudha"))
	    .body("programStatus", equalTo("Active"))
        .header("Content-Type", equalTo("application/json"))
        .body("programName", instanceOf(String.class))
        .body("programId", instanceOf(Integer.class))
        .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("ProgramModule.json"));

	}

	@Given("User creates POST Request for the LMS API with {string}")
	public void user_creates_post_request_for_the_lms_api_with(String string) {
	    //RequestSpecification req2 ;
	    HashMap<String,Object>map3 = new HashMap<String,Object>();
	    map3.put("programName",programName1 );
	    map3.put("programDescription", programDescription);
	    map3.put("programStatus" , "Active");
	    response = RestAssured.given().spec(createProgram()).body(map3).when().post();
	   //response = req2.when().post();
	   System.out.println(programName1);
	}
	
	@When("User sends HTTPS Request and  request Body with mandatory , additional  fields with existing values.")
	public void user_sends_https_request_and_request_body_with_mandatory_additional_fields_with_existing_values() {
		
		response.then().log().all().extract().response();
		LoggerLoad.info("the response of the rquest is " + response);
	}

	@Then("User receives {int} Bad Request Status with message and boolean success details")
	public void user_receives_bad_request_status_with_message_and_boolean_success_details(Integer int1) {
	    response.then().statusCode(400);
	    
	  
	}

	@Given("User creates POST Request {string} and {int} for the LMS API endpoint with missing field.")
	public void user_creates_post_request_and_for_the_lms_api_endpoint_with_missing_field(String Sheetname, Integer rownumber) throws Exception {
		HashMap<String,Object>map2 = new HashMap<String,Object>();
		List<Map<String, String>>data = ER.getData(URLs.excelpath, Sheetname);
	        map2.put("programDescription",data.get(rownumber).get("programDescription") );
			//map2.put("programName", data.get(rownumber).get("programName") + rand.nextInt(1000));
			map2.put("programStatus", data.get(rownumber).get("programStatus"));
			
		 response = RestAssured.given().spec(createProgram()).body(map2).when().post();
			

		
	}

	@When("User sends HTTPS Request and  request Body with mandatory , additional  fields with missing data.")
	public void user_sends_https_request_and_request_body_with_mandatory_additional_fields_with_missing_data() {
		
		response.then().log().all().extract().response();
	}
	@Then("User receives {int} Bad Request2 Status with message and boolean success details")
	public void user_receives_bad_request2_status_with_message_and_boolean_success_details(Integer int1) {
	    response.then().statusCode(500);
	    
	}
	
	@Given("User creates GET Request for the LMS API endpoint")
	public void user_creates_get_request_for_the_lms_api_endpoint() {
	   
	   response = RestAssured.given().spec(getProgram()).when().get();
	   
	}

	@When("User sends HTTPS Request")
	public void user_sends_https_request() {
		//response.then().log().all().extract().response().body().path("[10]");
	   
	}

	@Then("User receives {int} OK Status with response body.")
	public void user_receives_ok_status_with_response_body(Integer int1) {

     response.then().statusCode(200);	
     }
	@Given("User creates GET Request with valid <programId> for the LMS API endpoint")
	public void user_creates_get_request_with_valid_program_id_for_the_lms_api_endpoint() {
	    response = RestAssured.given()
	    		   .spec(getProgramByID())
	    		   .pathParam("programId", programId1)
	    		   .when()
	    		   .get();
	    response.then().log().all();
	    System.out.println(programId1);
	}
	
	@Given("User creates GET Request with invalid <programId> for the LMS API endpoint")
	public void user_creates_get_request_with_invalid_program_id_for_the_lms_api_endpoint() {
	    response = RestAssured.given()
	    		   .spec(getProgramByID())
	    		   .pathParam("programId", 1234)
	    		   .when()
	    		   .get();
	    response.then().log().all();
	}
	
	@Given("User creates PUT Request for the LMS API endpoint  and Valid programID")
	public void user_creates_put_request_for_the_lms_api_endpoint_and_valid_program_id() {
       HashMap<String, Object>map = new HashMap<String, Object>();
       map.put("programName", programName1);
       map.put("programDescription","Rani" );
       map.put("programStatus", "Inactive");
       response = RestAssured.given()
    		      .spec(UpdateByProgramId())
    		      .pathParam("programId", programId1)
    		      .body(map)
    		      .when()
    		      .put();
       response.then().log().all();
       //programName = response.jsonPath().getString("programName");
	}

	
	@Given("User creates PUT Request for the LMS API endpoint  and inValid programID")
	public void user_creates_put_request_for_the_lms_api_endpoint_and_in_valid_program_id() {
		HashMap<String, Object>map = new HashMap<String, Object>();
	       map.put("programName", "sudha");
	       map.put("programDescription","Rani" );
	       map.put("programStatus", "Inactive");
		
		response = RestAssured.given()
			      .spec(UpdateByProgramId())
			      .pathParam("programId",1234)
			      .body(map)
			      .when()
			      .put();
		
		response.then().log().all();
	}

	@Given("User creates PUT Request for the LMS API endpoint  and Valid programID with mising fields")
	public void user_creates_put_request_for_the_lms_api_endpoint_and_valid_program_id_with_mising_fields() {
		 HashMap<String, Object>map = new HashMap<String, Object>();
	       //map.put("programName", "sudha");
	       map.put("programDescription","Rani" );
	       map.put("programStatus", "Inactive");
	       response = RestAssured.given()
	    		      .spec(UpdateByProgramId())
	    		      .pathParam("programId", programId1)
	    		      .body(map)
	    		      .when()
	    		      .put();
	       response.then().log().all();
	}

	@Given("User creates PUT Request for the LMS API endpoint  and Valid program Name")
	public void user_creates_put_request_for_the_lms_api_endpoint_and_valid_program_name() {
		HashMap<String, Object>map = new HashMap<String, Object>();
	       map.put("programName", programName1);
	       map.put("programDescription","restassured" );
	       map.put("programStatus", "active");
		
		response = RestAssured.given()
	    		   .spec(UpdateByProgramName())
	    		   .pathParam("programName", programName1)
	    		   .body(map)
	    		   .when()
	    		   .put();
		response.then().log().all();
	}

//	@When("User sends HTTPS Request  and  request Body with mandatory fields")
//	public void user_sends_https_request_and_request_body_with_mandatory_fields() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}

	@Given("User creates PUT Request for the LMS API endpoint  and inValid program Name")
	public void user_creates_put_request_for_the_lms_api_endpoint_and_in_valid_program_name() {
		HashMap<String, Object>map = new HashMap<String, Object>();
	      map.put("programName", "selenium");
	       map.put("programDescription","restassured" );
	       map.put("programStatus", "Inactive");
		
		response = RestAssured.given()
	    		   .spec(UpdateByProgramName())
	    		   .pathParam("programName", "Anchor")
	    		   .body(map)
	    		   .when()
	    		   .put();
		response.then().log().all();
	}

	@Given("User creates PUT Request for the LMS API endpoint  and  Valid program Name  and missing field")
	public void user_creates_put_request_for_the_lms_api_endpoint_and_valid_program_name_and_missing_field() {
		HashMap<String, Object>map = new HashMap<String, Object>();
	       //map.put("programName", "selenium");
	       map.put("programDescription","restassured" );
	       map.put("programStatus", "Inactive");
		
		response = RestAssured.given()
	    		   .spec(UpdateByProgramName())
	    		   .pathParam("programName", programName1)
	    		   .body(map)
	    		   .when()
	    		   .put();
		response.then().log().all();
	}

	@Given("User creates DELETE Request for the LMS API endpoint  and  valid programName")
	public void user_creates_delete_request_for_the_lms_api_endpoint_and_valid_program_name() {
	    response = RestAssured.given()
	    		   .spec(deleteByProgramName())
	    		   .pathParam("programName", programName1)
	    		   .when()
	    		   .delete();
	    response.then().log().all();
	    
	}

	@Then("User receives {int} Ok status with message")
	public void user_receives_ok_status_with_message(Integer int1) {
	    response.then().statusCode(200);
	}

	@Given("User creates DELETE Request for the LMS API endpoint  and  invalid programName")
	public void user_creates_delete_request_for_the_lms_api_endpoint_and_invalid_programName() {
		response = RestAssured.given()
	    		   .spec(deleteByProgramName())
	    		   .pathParam("programName", 1234)
	    		   .when()
	    		   .delete();
	    response.then().log().all();
	}

	@Then("User receives {int} Not Found Status with message and boolean success details")
	public void user_receives_not_found_status_with_message_and_boolean_success_details(Integer int1) {
	    response.then().statusCode(404);
	}

	@Given("User creates DELETE Request for the LMS API endpoint  and  valid program ID")
	public void user_creates_delete_request_for_the_lms_api_endpoint_and_valid_program_id() {
		response = RestAssured.given()
	    		   .spec(deleteByProgramId())
	    		   .pathParam("programId", programId2)
	    		   .when()
	    		   .delete();
	    response.then().log().all();
	}

	@Given("User creates DELETE Request for the LMS API endpoint  and  invalid program ID")
	public void user_creates_delete_request_for_the_lms_api_endpoint_and_invalid_program_id() {
		response = RestAssured.given()
	    		   .spec(deleteByProgramId())
	    		   .pathParam("programId", 1234)
	    		   .when()
	    		   .delete();
	    response.then().log().all();
	}
	
}
