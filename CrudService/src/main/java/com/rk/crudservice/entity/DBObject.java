package com.rk.crudservice.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "DBOBJECT")
@JsonIgnoreProperties(ignoreUnknown = true)
public class DBObject {

	private long id;
	private String city;

	@JsonFormat(pattern = "mm/dd/yyyy")
	@JsonProperty("start_date")
	private Date start_date;

	@JsonFormat(pattern = "mm/dd/yyyy")
	@JsonProperty("end_date")
	private Date end_date;

	private String price;
	private String status;
	private String color;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "start_date", columnDefinition = "DATE")
	@DateTimeFormat(pattern = "mm/dd/yyyy")
	@Temporal(TemporalType.DATE)
	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	@Column(name = "end_date", columnDefinition = "DATE")
	@DateTimeFormat(pattern = "mm/dd/yyyy")
	@Temporal(TemporalType.DATE)
	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
