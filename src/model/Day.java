package model;

import java.time.LocalDate;

public class Day {

	private LocalDate localDate = LocalDate.now();

	public LocalDate getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}
}