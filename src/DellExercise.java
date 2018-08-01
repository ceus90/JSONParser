import org.json.simple.*;
import java.io.*;
import org.json.simple.parser.*;

public class DellExercise {

	public static void main(String[] args) {
		DataReader dataRdr = new DataReader();
		JSONArray jarray = dataRdr.Parse("input_data.json"); //JSON file
		dataRdr.Check(jarray); //The function which checks for the value Hospital in the field services
	}
}

class DataReader {
	
	public JSONArray Parse(String filename) {
		JSONParser parser = new JSONParser();
		JSONArray dataArray = null;
		try {
			dataArray = (JSONArray) parser.parse(new FileReader(filename)); //Converting from JSON object to JSON array
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return dataArray;
	}

	public void Check(JSONArray arr)
	{	int i = 0;
	
		for(Object jobj:arr) //iterate through the JSON file
		{
			JSONObject j_obj = (JSONObject)jobj;
			String fac_name = (String)j_obj.get("facility_name"); //holds the facility name
			JSONObject location = (JSONObject)j_obj.get("location"); //holds the location
			String services_str = (String) j_obj.get("services"); //holds the services
			if(services_str.equals("Hospital")) //check if services is Hospital
				System.out.println(++i +".  "+ fac_name+" : "+location +" -> "+services_str);
		}
	}

}
