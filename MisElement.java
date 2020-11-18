package logika;

/**
 * Isjecak koda u nastavku prikazuje klasu MisElement.
 *  Ova klasa prosiruje klasu KomponentePloce.
 *  Ima konstruktor koji uzima simbol kontruktor ima parametar.
 *   Ima metodu dodajRandomHranu metodu za postavljanje misa na plocu.
 * @author Muharem Sahinovic
 *
 */

public class MisElement extends KomponentePloce {

	public MisElement(char symbol) {
		setIcon(symbol);
	}

	public void dodajRandomHranu(Ploca screen, MisElement mis) {
		
		int x = (int) (((Math.random()) * (screen.getBoardWidth() - 1)));
		int y = (int) (((Math.random()) * (screen.getBoardHeight() - 1)));

		if(x==0)
		{
			x = 2;
		}
		
		if(y==0)
		{
			y= 2;
		}
		screen.setObjectOnLocation(mis,x,y);
				
	}
}
