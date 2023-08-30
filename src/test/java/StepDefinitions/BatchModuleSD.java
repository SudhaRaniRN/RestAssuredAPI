package StepDefinitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import Endpoints.URLs;
import Utilities.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import testdata.APITestData;

public class BatchModuleSD extends APITestData {
	
	Response response;
	Random rand = new Random();
	ExcelReader ER = new ExcelReader(); 
	static int programId1;
	String Batchname1, Batchname2;
	int BatchID1, BatchID2;

	

@Given("User creates POST Request {string} and {int} for the LMS batch api endpoints")
	public void user_creates_post_request_and_rownumber_for_the_lms_api_endpoint(String Sheetname, int rownumber) throws Exception {
		HashMap<String,Object>map = new HashMap<String,Object>(); 
		List<Map<String, String>>data = ER.getData(URLs.excelpath, Sheetname);
		rownumber = 0;
	      map.put("programDescription",data.get(0).get("programDescription") );
			map.put("programName", data.get(0).get("programName") + rand.nextInt(1000));
			map.put("programStatus", data.get(0).get("programStatus"));
			response = RestAssured.given().spec(createProgram()).body(map).when().post();
			response.then().log().all();
			programId1 = response.jsonPath().getInt("programId");
			
	}

	@Given("User creates POST Request {string} and {int} for the LMS API batch endpoint with mandatory field.")
	public void user_creates_post_request_for_the_lms_api_batch_endpoint(String Sheetname, int rownumber) throws Exception {
		Response[] responses= null;
		List<Map<String, String>>data = ER.getData(URLs.excelpath, Sheetname);
		HashMap<String, Object>map = new HashMap<String, Object>();
		map.put("batchName","SDET"+rand.nextInt(100));
		map.put("batchDescription", "SDET110");
		map.put("batchNoOfClasses", 10);
		map.put("programId", programId1);
		map.put("batchStatus", "Active");
		response = RestAssured.given()
				  .spec(createBatch())
				  .body(map)
				  .when().post();
		response.then().log().all();
		if(responses==null) {
			responses=new Response[data.size()];
		}
	    responses[rownumber]=response;
	    response.then().log().all();
	    if(rownumber==0) {
	    	Response storeresponse1 = responses[rownumber];
	    	String Batchname1= storeresponse1.jsonPath().getString("batchName");
	    	int BatchID1 = storeresponse1.jsonPath().getInt("batchId");
	    }else if(rownumber==1) {
	    	Response storeresponse2 = responses[rownumber];
	    	String Batchname2= storeresponse2.jsonPath().getString("batchName");
	    	int BatchID2 = storeresponse2.jsonPath().getInt("batchId");
	    }
	}

	@When("User sends HTTPS Request and  request Body with mandatory , additional  fields")
	public void user_sends_https_request_and_request_body_with_mandatory_additional_fields() {
	    System.out.println();
	}

}
