package Scripts;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class CreateJsonFile {
	@Test
	public void createJasonFile() throws Exception{
		JSONArray EmployeeArray = new JSONArray();
		for (int i = 1 ;i<=2000; i++){


			JSONObject obj = new JSONObject();
			obj.put("id",i );
			obj.put("Employename", "TestName"+i);
			obj.put("Employeecompany", "Company"+i);
			obj.put("CompanyID",2000-i);

			EmployeeArray.add(obj);

		}
		JSONObject empDetails = new JSONObject();
		empDetails.put("Employee", EmployeeArray);

		String path= "OutputFiles/data.json";
		File file = new File(path);
		FileWriter fw = new FileWriter(file);
		PrintWriter printWriter = new PrintWriter(fw);
		printWriter.print(empDetails);
	}
}


