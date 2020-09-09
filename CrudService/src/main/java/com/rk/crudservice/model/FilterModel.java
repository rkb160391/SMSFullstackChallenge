package com.rk.crudservice.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FilterModel {

	@JsonFormat(pattern = "mm/dd/yyyy")
	@JsonProperty("start_date")
	private Date startDate;

	@JsonFormat(pattern = "mm/dd/yyyy")
	@JsonProperty("end_date")
	private Date endDate;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	};

}
