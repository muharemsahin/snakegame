package logika;
/**
 * Isjeèak koda u nastavku prikazuje klasu ZidPloce. To je podrazred klase KomponentePloce.
 *  Ima konstruktore za postavljanje zadate ikone ili prilagodjene ikone za celije zida. 
 * Da biste postavili zidove na sjever, jug, zapad i istok, metode dodajKolonuPlocnogZida i dodajRedPlocnogZida su u klasi ZidPloce.
 * @author Sahin
 *
 */

public class ZidPloce extends KomponentePloce {

	public ZidPloce() {
		setIcon('^');
	}

	public ZidPloce(char icon) {
		setIcon(icon);
	}


	public void dodajRedPlocnogZida(Ploca board, ZidPloce wall, int rowNumber) {
		for (int i = 0; i < board.getBoardWidth(); i++) {
			board.setObjectOnLocation(wall, i, rowNumber);
		}
	}

	public void dodajKolonuPlocnogZida(Ploca board, ZidPloce wall, int columnNumber) {
		for (int i = 0; i < board.getBoardHeight(); i++) {
			board.setObjectOnLocation(wall, columnNumber, i);
		}
	}
}
