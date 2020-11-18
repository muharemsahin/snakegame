package logika;
/**
 * Isjeèak koda u nastavku pokazuje klasu Ploca.
 *  Ploca ima skup celija s tackicama. Sirina i visina ploce postavljene su u konstruktoru.
 *   Predmeti zmija i mis mogu se postaviti na ploèu na celiji pomocu metode setObjectOnLocation.
 *    getObjectOnLocation koristi se za dohvacanje trenutnog objekta na mjestu celije.
 */

public class Ploca {

	private int sirina, visina;
	private char[][] matricaPloce;

	public Ploca(int width, int height) {
		this.sirina = width;
		this.visina = height;
		this.matricaPloce = new char[this.visina][this.sirina];
	}

	
	public void pocetnaPloca() {
		for (int i = 0; i < this.visina; i++) {
			for (int j = 0; j < this.sirina; j++) {
				this.matricaPloce[i][j] = '.';
			}
		}
	}

	
	public void ispisPloce() {
		for (int i = 0; i < this.visina; i++) {
			for (int j = 0; j < this.sirina; j++) {
				System.out.print(this.matricaPloce[i][j]);
			}
			System.out.println();
		}
	}

	
	public void ClearScreenLocation(int x, int y) {
		this.matricaPloce[y][x] = '.';
	}

	
	public int getBoardWidth() {
		return this.sirina;
	}

	public int getBoardHeight() {
		return this.visina;
	}

	public char getObjectOnLocation(int x, int y) {
		return this.matricaPloce[y][x];
	}

	
	public void setObjectOnLocation(KomponentePloce object, int x, int y) {
		this.matricaPloce[y][x] = object.getIcon();
	}
}
