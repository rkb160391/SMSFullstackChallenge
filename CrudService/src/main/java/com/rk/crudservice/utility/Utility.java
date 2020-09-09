package com.rk.crudservice.utility;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Utility {

	public static LocalDate getDate(String date) {
		SimpleDateFormat myFormat = new SimpleDateFormat("MM/DD/yyyy");
		String reformattedStr = myFormat.format(date);
		return LocalDate.parse(reformattedStr);
	}

}
