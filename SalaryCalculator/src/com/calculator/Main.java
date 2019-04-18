package com.calculator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.calculator.entity.Day;

/**
 * @author cvillavicencio[Christian Villavicencio]
 * @version 1.0.0 15 abr. 2019
 */
public class Main {

	/**
	 * this method execute the main application.
	 * @param args
	 */
	public static void main(String[] args) {

		DayConfiguration configuration = new DayConfiguration();
		List<Day> configurations = configuration.configurate();
		Path path = Paths.get("employees.txt");
		try {
			@SuppressWarnings("resource")
			Stream<String> rows = Files.lines(path);
			rows.forEach(row -> {
				String name = row.split("=")[0];
				String schedules = row.split("=")[1];
				System.out.println("The amount to pay " + name + " is " + calculateAmount(schedules, configurations));
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method calculate value of pay for each registry.
	 * @param schedules periods of time
	 * @param configurations configurations os the days
	 * @return value to pay
	 */
	private static String calculateAmount(String schedules, List<Day> configurations) {
		String[] periods = schedules.split(",");
		double amount = 0;
		for (String period : periods) {
			String day = period.substring(0, 2);
			String[] hours = period.substring(2, period.length()).split("-");
			amount += recursivelyCalculate(LocalTime.parse(hours[0]), LocalTime.parse(hours[1]), configurations.stream().filter(conf -> conf.getDay().equals(day)).collect(Collectors.toList()), 0);
		}
		return String.valueOf(amount);
	}

	/**
	 * This method calculate recursively the value to pay for each employee.
	 * @param startTime
	 * @param endTime
	 * @param configurations
	 * @param amount
	 * @return value to pay
	 */
	private static double recursivelyCalculate(LocalTime startTime, LocalTime endTime, List<Day> configurations, double amount) {
		if (startTime.compareTo(endTime) != 0 && startTime.compareTo(validateEndHour(endTime)) <= 0) {
			Optional<Day> day = configurations.stream().filter(x -> x.getStart().compareTo(startTime.plusMinutes(1)) <= 0 && validateEndHour(x.getEnd()).compareTo(validateEndHour(startTime.plusHours(1))) >= 0).findFirst();
			if (day.isPresent()) {
				amount += recursivelyCalculate(startTime.plusHours(1), endTime, configurations, day.get().getAmount());
			} else {
				System.out.println("Not configuration from " + startTime + " to " + endTime + " period");
			}
		}
		return amount;
	}

	/**
	 * This method validate the end hour.
	 * @param endTime
	 * @return time validated
	 */
	private static LocalTime validateEndHour(LocalTime endTime) {
		if (endTime.compareTo(LocalTime.parse("00:00")) == 0) {
			return LocalTime.parse("23:59");
		}
		return endTime;
	}

}
