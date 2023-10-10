package model;

import interfaces.ChangeInterface;
import java.time.LocalDate;
import java.time.LocalTime;

public class Clock implements ChangeInterface {

	private STATE currentState = STATE.ShowTime;
	private Time time = new Time();
	private Day date = new Day();

	public enum STATE {
		ShowTime, ShowDate, ChangeDate, ChangeTime
	}

	// Check state when wanting to change time or date
	@Override
	public void readyToSet() {
		if (currentState == STATE.ShowTime) {
			currentState = STATE.ChangeTime;
		} else if (currentState == STATE.ShowDate) {
			currentState = STATE.ChangeDate;
		} else {
			System.out.println("Invalid choice");
		}
	}

	// Show time or state
	@Override
	public void set() {
		if (currentState == STATE.ChangeTime) {
			currentState = STATE.ShowTime;
		} else if (currentState == STATE.ChangeDate) {
			currentState = STATE.ShowDate;
		} else {
			System.out.println("Invalid choice");
		}
	}

	// Changing between time and date
	@Override
	public void changeMode() {
		if (currentState == STATE.ShowTime) {
			currentState = STATE.ShowDate;
		} else if (currentState == STATE.ShowDate) {
			currentState = STATE.ShowTime;
		} else {
			System.out.println("Invalid choice");
		}
	}

	public LocalTime getTime() {
		return time.getLocalTime();
	}

	// Set new time
	public void setTime(String timeInput) {
		try {
			time.setLocalTime(LocalTime.parse(timeInput));
		} catch (Exception e) {
			System.out.println("Invalid time format. Please enter time in HH:mm:ss format.");
		}
	}

	public LocalDate getDate() {
		return date.getLocalDate();
	}

	// Set new date
	public void setDate(String dateInput) {
		try {
			date.setLocalDate(LocalDate.parse(dateInput));
		} catch (Exception e) {
			System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format.");
		}
	}

	public STATE getCurrentState() {
		return currentState;
	}
}