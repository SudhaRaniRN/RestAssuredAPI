package Endpoints;

public class URLs {
	
	public static String base_URL = "https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms";
	public static String programpost_URL =  "/saveprogram";
	public static String getAllProgram_URL =  "/allPrograms";
	public static String getByProgramID =  "/programs/{programId}";
	public static String putbyProgramName =  "/program/{programName}";
	public static String putbyProgramID =  "/putprogram/{programId}";
	public static String deletebyProgramID =  "/deletebyprogid/{programId}";
	public static String deletebyProgramName =  "/deletebyprogname/{programName}";
	public static String batchpost_URL = "/batches";
	public static String getAllBatches_URL =  "/batches";
	public static String getByBatchID_URL =  "/batches/batchId/{batchId}";
	public static String getByBatchName_URL =  "/batches/batchName/{batchName}";
	public static String putBatchbyProgramID = ":/batches/program/{programId}";
	public static String putbyBatchID =  "/batches/{batchId}";
	public static String deletebyBatch = "/batches/{id}";
	
	public static String excelpath = "C:\\Users\\SuManaSvi\\git\\RestAssuredAPI\\src\\main\\resources\\testdata.xlsx";
	
}
