package logika;
/**
 *  Isjecak koda u nastavku prikazuje klasu SnakeElement.
 *   SnakeElement je potklasa KomponentePloce-a.
 *    Ima konstruktor za postavljanje simbola i koordinata lokacije x i y.
 * @author Sahinovic Muharem
 *
 */

public class SnakeElement extends KomponentePloce {

	public SnakeElement(char symbol, int xStartingLocation, int yStartingLocation) {
		setIcon(symbol);
		setX(xStartingLocation);
		setY(yStartingLocation);
	}
	
	public void idiLijevo(Ploca screen, SnakeElement snake) {
		snake.setX(getX() - 1);
		screen.setObjectOnLocation(snake, snake.getX(), snake.getY());
		screen.ClearScreenLocation(snake.getX() + 1, snake.getY());
	}
	
	public void idiDesno(Ploca screen, SnakeElement snake) {
		snake.setX(getX() + 1);
		screen.setObjectOnLocation(snake, snake.getX(), snake.getY());
		screen.ClearScreenLocation(snake.getX() - 1, snake.getY());
	}
	
	public void idiGore(Ploca screen, SnakeElement snake) {
		snake.setY(getY() - 1);
		screen.setObjectOnLocation(snake, snake.getX(), snake.getY());
		screen.ClearScreenLocation(snake.getX(), snake.getY() + 1);
	}
	
	public void idiDole(Ploca screen, SnakeElement snake) {
		snake.setY(getY() + 1);
		screen.setObjectOnLocation(snake, snake.getX(), snake.getY());
		screen.ClearScreenLocation(snake.getX(), snake.getY() - 1);
	}
}