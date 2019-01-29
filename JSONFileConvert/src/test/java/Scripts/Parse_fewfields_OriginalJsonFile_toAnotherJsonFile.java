package Scripts;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import Utils.WriteLineToFile;



public class Parse_fewfields_OriginalJsonFile_toAnotherJsonFile {



	@Test
	public  void parseJson() {

		JSONParser parser = new JSONParser();

		try {     
			Object obj = parser.parse(new FileReader(("DataFiles/data.json")));

			JSONObject empObject = (JSONObject) obj;


			JSONArray objArray =  (JSONArray) empObject.get("Employee");
			String fileSuffix = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			WriteLineToFile wl = new WriteLineToFile();

			String Filename = "sub-data"+fileSuffix;
			PrintWriter pw = wl.createfile(Filename,"json");

			JSONArray Emp = new JSONArray();


			// loop array

			Iterator<JSONObject> iterator = objArray.iterator();
			while (iterator.hasNext()) {
				JSONObject record = iterator.next();
				JSONObject row = new JSONObject();
				String one = (String) record.get("EmpID");
				row.put("EmpID", one);
				String two = (String) record.get("CompanyID");
				row.put("CompanyID", two);
				Emp.add(row);
			}
			//         wl.writeline(pw,one);
			System.out.println(Emp);
			wl.closefile(pw);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}



