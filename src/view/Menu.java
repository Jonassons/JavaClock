package view;

import model.Clock;

import java.util.Scanner;

public class Menu {
	private Clock clock;
	private Scanner sc;

	public Menu(Clock clock) {
		this.clock = clock;
		this.sc = new Scanner(System.in);
	}

	public void showMenu() {
		String userInput = "";

		while (!userInput.equals("q")) {
			System.out.println("Current state = " + clock.getCurrentState());

			if (clock.getCurrentState() == Clock.STATE.ShowTime) {
				if (ShowTimeMenu()) {
					break;
				}
			} else if (clock.getCurrentState() == Clock.STATE.ShowDate) {
				if (ShowDateMenu()) {
					break;
				}
			} else if (clock.getCurrentState() == Clock.STATE.ChangeTime) {
				if (changeTimeMenu()) {
					break;
				}
			} else if (clock.getCurrentState() == Clock.STATE.ChangeDate) {
				if (changeDateMenu()) {
					break;
				}
			}
		}
	}

	private boolean ShowTimeMenu() {
		System.out.println("Choose an option : ");
		System.out.println("1. Show Time");
		System.out.println("2. Change Time");
		System.out.println("3. Show Date");
		System.out.println("4. Quit application");

		String userInput = sc.nextLine();
		switch (userInput) {
		case "1":
			System.out.println(clock.getTime());
			break;
		case "2":
			clock.readyToSet();
			break;
		case "3":
			clock.changeMode();
			break;
		case "4":
			System.out.println(" Quitting ");
			return true;

		default:
			System.out.println("Invalid choice");
		}
		return false;
	}

	private boolean ShowDateMenu() {
		System.out.println("Please choose one of the options : ");
		System.out.println("1 Show Date");
		System.out.println("2. Change Date");
		System.out.println("3. Show Time");
		System.out.println("4. Quit");

		String userInput = sc.nextLine();
		switch (userInput) {
		case "1":
			System.out.println(clock.getDate());
			break;
		case "2":
			clock.readyToSet();
			break;
		case "3":
			clock.changeMode();
			break;
		case "4":
			System.out.println("Quitting");
			return true;
		default:
			System.out.println("Invalid choice");
		}
		return false;
	}

	private boolean changeTimeMenu() {
		System.out.println("1. Change Time");
		System.out.println("2. Show Time");
		System.out.println("3. Quit application");

		String userInput = sc.nextLine();
		switch (userInput) {
		case "1":
			System.out.println("What would you like the time to be?  (HH:mm:ss:) ");
			String newTimeInput = sc.nextLine();
			try {
				clock.setTime(newTimeInput);
				System.out.println("Timetravel completed");
			} catch (Exception e) {
				System.out.println("Wrong format, plese try HH:mm:ss.");
			}
			break;
		case "2":
			clock.set();
			break;
		case "3":
			System.out.println(" Quitting ");
			return true;

		default:
			System.out.println("Invalid choice");
		}
		return false;
	}

	private boolean changeDateMenu() {
		System.out.println("1. Change Date");
		System.out.println("2. Show Date");
		System.out.println("3. Quit application");

		String userInput = sc.nextLine();
		switch (userInput) {
		case "1":
			System.out.println("Enter new date (yyyy-MM-dd): ");
			String newDateInput = sc.nextLine();
			try {
				clock.setDate(newDateInput);
				System.out.println("Timetravel completed!");
			} catch (Exception e) {
				System.out.println("Please use yyyy-MM-dd format :) ");
			}
			break;
		case "2":
			clock.set();
			break;
		case "3":
			System.out.println("Quitting.");
			return true;
		default:
			System.out.println("Invalid choice");
		}
		return false;
	}

}