package Utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteLineToFile {
	PrintWriter printWriter;
	
	public PrintWriter createfile(String filename,String extenstion){
		try {
			 String path= "OutputFiles/".concat(filename).concat(extenstion);
			File file = new File(path);
			FileWriter fileWriter = new FileWriter(file);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			return printWriter;
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return printWriter;
		
	}
public void writeline(PrintWriter pr ,String Line){	
		pr.print(Line+"\n");
	
}

public void closefile(PrintWriter pr){
	pr.flush();
	pr.close();
}
}
