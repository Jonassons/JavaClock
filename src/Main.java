import model.Clock;
import view.Menu;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Clock clock = new Clock();
		Menu consoleMenu = new Menu(clock);

		consoleMenu.showMenu();

	}

}