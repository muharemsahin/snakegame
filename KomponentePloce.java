package logika;
/**
 * Isjecak koda dolje prikazuje klasu KomponentePloce. KomponentePloce ima koordinate lokacije x, y i ikonu koja predstavlja komponentu.
 *  Getters i setters koriste se za dobivanje i postavljanje atributa KomponentePloce.
 * @author Muharem Sahinovic
 *
 */

public class KomponentePloce {
	
	private int x, y;
	private char icon;
	

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public char getIcon() {
		return icon;
	}

	public void setX(int newLocation) {
		this.x = newLocation;
	}
	
	public void setY(int newLocation) {
		this.y = newLocation;
	}
	
	public void setIcon(char newSymbol) {
		this.icon = newSymbol;
	}
}
