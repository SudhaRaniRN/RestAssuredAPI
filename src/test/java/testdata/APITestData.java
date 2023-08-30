package testdata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import Endpoints.URLs;
import Utilities.ExcelReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static  io.restassured.RestAssured.given;


public class APITestData {
	
	Random rand = new Random();
	ExcelReader ER = new ExcelReader();
    public String programName, programDescription;
    public String programID;
    static RequestSpecBuilder req = new RequestSpecBuilder();
    
    
	public  RequestSpecification  createProgram()  {

		
		  req.setBaseUri(URLs.base_URL);
		  req.setBasePath(URLs.programpost_URL);
		  req.setContentType(ContentType.JSON);
		  req.setAccept(ContentType.JSON);
		  RequestSpecification reqspec = req.build();		
		  return reqspec;
		
		
	}
   public static RequestSpecification getProgram(){
		
		
		req.setBaseUri(URLs.base_URL);
		req.setBasePath(URLs.getAllProgram_URL);
		RequestSpecification reqspec = req.build();
		return reqspec;
	}
	
	public static RequestSpecification getProgramByID() {
		
		req.setBaseUri(URLs.base_URL);
		req.setBasePath(URLs.getByProgramID);
		RequestSpecification reqspec = req.build();
		return reqspec;
	}
	
	public static RequestSpecification UpdateByProgramName() {
		req.setBaseUri(URLs.base_URL);
		req.setBasePath(URLs.putbyProgramName);
		req.setAccept(ContentType.JSON);
		req.setContentType(ContentType.JSON);
		RequestSpecification reqspec= req.build();
		
		return reqspec;

	}
	
	public static RequestSpecification UpdateByProgramId()  {
		req.setBaseUri(URLs.base_URL);
		req.setBasePath(URLs.putbyProgramID);
		req.setAccept(ContentType.JSON);
		req.setContentType(ContentType.JSON);
		RequestSpecification reqspec= req.build();
		
		return reqspec;
	}
	
	public static RequestSpecification deleteByProgramName() {
		  
		req.setBaseUri(URLs.base_URL);
		req.setBasePath(URLs.deletebyProgramName);
		RequestSpecification reqspec = req.build();
		return reqspec;
	}
	
	public static RequestSpecification deleteByProgramId( ) {
		  
		req.setBaseUri(URLs.base_URL);
		req.setBasePath(URLs.deletebyProgramID);
		RequestSpecification reqspec = req.build();
		return reqspec;
	}	
  public static RequestSpecification createBatch() {
	  req.setBaseUri(URLs.base_URL);
		req.setBasePath(URLs.batchpost_URL);
		req.setAccept(ContentType.JSON);
		req.setContentType(ContentType.JSON);
		RequestSpecification reqspec = req.build();
		return reqspec;
	  
  }
}

	

