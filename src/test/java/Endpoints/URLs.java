package Endpoints;

public class URLs {
	
	public static String base_URL = "https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms";
	public static String programpost_URL = base_URL + "/saveprogram";
	public static String getAllProgram_URL = base_URL + "/allPrograms";
	public static String getByProgramID = base_URL + "/programs/{programId}";
	public static String putbyProgramName = base_URL + "/program/{programName}";
	public static String putbyProgramID = base_URL + "/putprogram/{programId}";
	public static String deletebyProgramID = base_URL + "/deletebyprogid/{programId}";
	public static String deletebyProgramName = base_URL + "/deletebyprogname/{programName}";
	public static String batchpost_URL = base_URL + "/batches";
	public static String getAllBatches_URL = base_URL + "/batches";
	public static String getByBatchID_URL = base_URL + "/batches/batchId/{batchId}";
	public static String getByBatchName_URL = base_URL + "/batches/batchName/{batchName}";
	public static String putBatchbyProgramID = base_URL + ":/batches/program/{programId}";
	public static String putbyBatchID = base_URL + "/batches/{batchId}";
	public static String deletebyBatch = base_URL + "/batches/{id}";
	
	public static String excelpath = "C:\\Users\\SuManaSvi\\eclipse-workspace\\API-Lms\\src\\main\\resources\\testdata.xlsx";
	
}
