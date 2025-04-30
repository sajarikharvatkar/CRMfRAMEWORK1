package com.comcas.crm.generic.fileutility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONUtility {
	//get data from JSON file
	public String getDataFromJsonFil(String key) throws IOException, ParseException
	{
		FileReader fr=new FileReader("./configAppData/commondata.json");
		JSONParser parser=new JSONParser();
		Object obj=	parser.parse(fr);
		JSONObject map=(JSONObject)obj;
	String data=map.get(key).toString();
		return data;
	}

}
