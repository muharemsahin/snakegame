package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
/**
 * Isjecak koda u nastavku prikazuje klasu IgrajSnake.
 *  Ova klasa ima zadani konstruktor koji inicijalizira ekran.
 *  Metoda initScreen kreira novi ScreenPanel. 
 *  SnakeGame JFrame je kreiran i postavljen je na setVisible.
 * @author Sahinovic Muharem
 *
 */

public class IgrajSnake extends JFrame {

    public IgrajSnake() {
        
        initScreen();
    }
    
    private void initScreen() {
        
        add(new ZaslonskaPloca());
               
        setResizable(false);
        pack();
        
        setTitle("Snake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

    public static void main(String[] args) {
        /**
         * EventQueue je klasa neovisna o platformi koja postavlja redove na redove dogadjaja,
         *  kako iz temeljnih vrsnjackih klasa, tako i iz klasa pouzdanih aplikacija.
         *  To jest, nije dopusteno istodobno slati nekoliko dogadjaja iz ovog reda.
         */
        EventQueue.invokeLater(() -> {
            JFrame frame = new IgrajSnake();
            frame.setVisible(true);
        });
    }
}
