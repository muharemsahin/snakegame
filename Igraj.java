package konzola;

import java.util.Scanner;

import logika.MisElement;
import logika.Ploca;
import logika.ZidPloce;
import logika.SnakeElement;
/**
 * Isjeèak koda u nastavku prikazuje klasu Igraj.
 *  Klasa Igraj stvara zidove ploce .
Postavljeni su pocetni položaji zmije i misa. 
Kljucni dogadjaji su snimljeni za pomicanje zmija.
 * @author Sahinovic Muharem
 *
 */

public class Igraj {

	public static void main(String[] args) {

		final int sirina_ploce = 20; 
		final int visina_ploce = 10; 
		final int START_X = sirina_ploce / 2;
		final int START_Y = visina_ploce / 2;


		Ploca ploca = new Ploca(sirina_ploce, visina_ploce);
		ploca.pocetnaPloca();

		ZidPloce zid = new ZidPloce('^');
		zid.dodajRedPlocnogZida(ploca, zid, 0); 
		zid.dodajRedPlocnogZida(ploca, zid, ploca.getBoardHeight() - 1); 
		zid.dodajKolonuPlocnogZida(ploca, zid, 0); 
		zid.dodajKolonuPlocnogZida(ploca, zid, ploca.getBoardWidth() - 1); 

		SnakeElement snake = new SnakeElement('~', START_X, START_Y);
		ploca.setObjectOnLocation(snake, snake.getX(), snake.getY());

		MisElement mis = new MisElement('&');
		mis.dodajRandomHranu(ploca, mis);
		

		Scanner scanner = new Scanner(System.in);
		char input;


		boolean isRunning = true;

		while (isRunning) {
			ploca.ispisPloce();
			switch (input = scanner.nextLine().charAt(0)) {
			case 'l':
				snake.idiLijevo(ploca, snake);
				break;
			case 'r':
				snake.idiDesno(ploca, snake);
				break;
			case 'u':
				snake.idiGore(ploca, snake);
				break;
			case 'd':
				snake.idiDole(ploca, snake);
				break;
			}
		}
	}

}
