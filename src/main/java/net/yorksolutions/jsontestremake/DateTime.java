package net.yorksolutions.jsontestremake;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class DateTime {
	@JsonProperty("date")
	String date;
	@JsonProperty("time")
	String time;

	public DateTime(Date current_date) {
		String date = new java.text.SimpleDateFormat("MM/dd/yyyy").format(current_date);
		String time = new java.text.SimpleDateFormat("hh:mm:ss aa").format(current_date);
		this.date = date;
		this.time = time;
	}
}
