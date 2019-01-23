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



public class JsonParsefile {
	
	

	@Test
	    public  void parseJson() {

	        JSONParser parser = new JSONParser();

	        try {     
	            Object obj = parser.parse(new FileReader(("DataFiles/data.json")));

	            JSONArray objArray =  (JSONArray) obj;
	            String fileSuffix = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	            WriteLineToFile wl = new WriteLineToFile();
	            
	            String Filename = "CTX"+fileSuffix;
	            PrintWriter pw = wl.createfile(Filename);
	            
	            
	            
	            // loop array
	            
	            Iterator<JSONObject> iterator = objArray.iterator();
	            while (iterator.hasNext()) {
	            	JSONObject record = iterator.next();
	            	String one = (String) record.get("_id");
	            	wl.writeline(pw,one);
	             System.out.println(one);
	            }
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



