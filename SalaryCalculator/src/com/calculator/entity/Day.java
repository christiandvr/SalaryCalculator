package com.calculator.entity;
/**
 * @author cvillavicencio[Christian Villavicencio]
 * @version 1.0.0 15 abr. 2019
 */

import java.time.LocalTime;

public class Day {
	
	private LocalTime start;
	private LocalTime end;
	private double amount;
	private String day;	
	
	public Day(LocalTime start, LocalTime end, double amount, String day) {
		super();
		this.start = start;
		this.end = end;
		this.amount = amount;
		this.day = day;
	}
	
	public LocalTime getStart() {
		return start;
	}
	public void setStart(LocalTime start) {
		this.start = start;
	}
	public LocalTime getEnd() {
		return end;
	}
	public void setEnd(LocalTime end) {
		this.end = end;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}	
}
