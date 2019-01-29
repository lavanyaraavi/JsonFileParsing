package Scripts;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import Utils.WriteLineToFile;

public class CreateJsonFile {
	@Test
	public void createJsonFile() throws Exception{
		WriteLineToFile wl = new WriteLineToFile();
		JSONArray EmployeeArray = new JSONArray();
		
		for (int i = 1 ;i<2000; i++){
			JSONObject obj = new JSONObject();
			obj.put("EmpID",Integer.toString(i) );
			obj.put("EmpName", "TestName".concat(Integer.toString(i)));
			obj.put("CompanyName", "Company".concat(Integer.toString(i)));
			int J = 2000-i;
			obj.put("CompanyID",Integer.toString(J));

			EmployeeArray.add(obj);
			System.out.println(obj.toString());

		}
		JSONObject empDetails = new JSONObject();
		empDetails.put("Employee", EmployeeArray);
		System.out.println("changed as object");
		
		  
          
		String fileSuffix = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		//String path= "OutputFiles/data"+fileSuffix+".json";
		String Filename = "data".concat(fileSuffix);
        PrintWriter printWriter = wl.createfile(Filename,"json");
		
		//File file = new File(path);
		//FileWriter fw = new FileWriter(file);
		//PrintWriter printWriter = new PrintWriter(fw);
		//printWriter.print(empDetails);
		printWriter.println(empDetails);
		printWriter.flush();
		printWriter.close();
	}
}


