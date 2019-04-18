package com.calculator;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.calculator.entity.Day;
import com.calculator.enumeration.DayEnum;

/**
 * @author cvillavicencio[Christian Villavicencio]
 * @version 1.0.0 15 abr. 2019
 */
public class DayConfiguration {
	/**
	 * This method configure the periods and values to pay.
	 * @return list of day s configuration
	 */
	public List<Day> configurate(){
		List<Day> list = new ArrayList<>();	
		list.add(new Day(setTime(0,1), setTime(9,0), 25, DayEnum.MONDAY.getValue()));		
		list.add(new Day(setTime(0,1), setTime(9,0), 25, DayEnum.TUESDAY.getValue()));		
		list.add(new Day(setTime(0,1), setTime(9,0), 25, DayEnum.WEDNESDAY.getValue()));		
		list.add(new Day(setTime(0,1), setTime(9,0), 25, DayEnum.THURSDAY.getValue()));		
		list.add(new Day(setTime(0,1), setTime(9,0), 25, DayEnum.FRIDAY.getValue()));		
		list.add(new Day(setTime(0,1), setTime(9,0), 30, DayEnum.SATURDAY.getValue()));		
		list.add(new Day(setTime(0,1), setTime(9,0), 30, DayEnum.SUNDAY.getValue()));		
		
		list.add(new Day(setTime(9,1), setTime(18,0), 15, DayEnum.MONDAY.getValue()));		
		list.add(new Day(setTime(9,1), setTime(18,0), 15, DayEnum.TUESDAY.getValue()));		
		list.add(new Day(setTime(9,1), setTime(18,0), 15, DayEnum.WEDNESDAY.getValue()));		
		list.add(new Day(setTime(9,1), setTime(18,0), 15, DayEnum.THURSDAY.getValue()));		
		list.add(new Day(setTime(9,1), setTime(18,0), 15, DayEnum.FRIDAY.getValue()));		
		list.add(new Day(setTime(9,1), setTime(18,0), 20, DayEnum.SATURDAY.getValue()));		
		list.add(new Day(setTime(9,1), setTime(18,0), 20, DayEnum.SUNDAY.getValue()));		
		
		list.add(new Day(setTime(18,1), setTime(0,0), 20, DayEnum.MONDAY.getValue()));		
		list.add(new Day(setTime(18,1), setTime(0,0), 20, DayEnum.TUESDAY.getValue()));		
		list.add(new Day(setTime(18,1), setTime(0,0), 20, DayEnum.WEDNESDAY.getValue()));		
		list.add(new Day(setTime(18,1), setTime(0,0), 20, DayEnum.THURSDAY.getValue()));		
		list.add(new Day(setTime(18,1), setTime(0,0), 20, DayEnum.FRIDAY.getValue()));		
		list.add(new Day(setTime(18,1), setTime(0,0), 25, DayEnum.SATURDAY.getValue()));		
		list.add(new Day(setTime(18,1), setTime(0,0), 25, DayEnum.SUNDAY.getValue()));
		return list;
	}
	
	/**
	 * This method set a time with hour and minutes.
	 * @param hour
	 * @param minute
	 * @param return object time
	 */
	private LocalTime setTime(int hour, int minute) {
		return LocalTime.now().withHour(hour).withMinute(minute).withSecond(0).withNano(0);
	}
}
