package com.calculator.enumeration;
/**
 * @author cvillavicencio[Christian Villavicencio]
 * @version 1.0.0 15 abr. 2019
 */
public enum DayEnum {
	MONDAY("MO"),
	TUESDAY("TU"),
	WEDNESDAY("WE"),
	THURSDAY("TH"),
	FRIDAY("FR"),
	SATURDAY("SA"),
	SUNDAY("SU");
	
	private final String value;

	private DayEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
