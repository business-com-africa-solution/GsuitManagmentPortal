package com.bussinesscom.Africa.GsuitAfrica.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.google.api.client.util.DateTime;

public class Utilities {

	public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYY-MM-D");

	public static String convertTime(long time) {
		Date date = new Date(time);
		SimpleDateFormat format = new SimpleDateFormat("yyyy MM dd HH:mm:ss");
		return format.format(date);
	}

	public static String getStringNull(Object data) {

		try {
			return data.toString();
		} catch (Exception e) {
			return ",";
			// TODO: handle exception
		}

	}

	public static String getEmptyNullLongValue(DateTime longValue) {

		if (longValue != null) {

			return simpleDateFormat.format(longValue.getValue());
		} else {
			return "";
		}
	}

	public static String getEmptyNullStringValue(String string) {
		try {
//			System.out.println("Value---------"+string);
			return "" + string;
		} catch (NullPointerException e) {
			return " ";
			// TODO: handle exception
		}

	}

//	public static Integer getNullJsonArray(JSONArray jsArray) {
//		try {
//			System.out.println("Json Array Size-----" + jsArray.length());
//			return jsArray.length();
//		} catch (NullPointerException npe) {
//			// do something
//			return 0;
//		}
//	}

	public static Integer getNullStringList(List<String> jsArray) {
		try {
			System.out.println("Json Array Size-----" + jsArray.size());
			return jsArray.size();
		} catch (NullPointerException npe) {
			// do something
			return 0;
		}
	}

	public static Boolean getRightsAcess(Boolean Service, Boolean roleAcess) {

		if (Service && roleAcess) {
			return true;
		} else {
			return false;
		}
	}

}
