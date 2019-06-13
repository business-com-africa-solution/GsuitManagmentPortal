package com.bussinesscom.Africa.GsuitAfrica.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.google.gson.JsonArray;

public class Utilities {


	public static String convertTime(long time){
	    Date date = new Date(time);
	    SimpleDateFormat format = new SimpleDateFormat("yyyy MM dd HH:mm:ss");
	    return format.format(date);
	}
	
	public static String getStringNull(Object data) 
	{
		
		try {
			return data.toString();
		}catch (Exception e) {
			return ",";
			// TODO: handle exception
		}
		
	}
	
	public static Integer getNullJsonArray(JsonArray jsArray) 
	{	try { 
			System.out.println("Json Array Size-----"+jsArray.size());
			return jsArray.size();
		} catch (NullPointerException npe) {
		    //do something
			return 0;
		}
	}
	public static Integer getNullStringList(List<String> jsArray) 
	{	try { 
			System.out.println("Json Array Size-----"+jsArray.size());
			return jsArray.size();
		} catch (NullPointerException npe) {
		    //do something
			return 0;
		}
	}

	
	
}
