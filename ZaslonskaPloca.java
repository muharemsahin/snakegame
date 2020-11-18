package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Isjecak koda u nastavku prikazuje klasu ZaslonskaPloca.
 *  ZaslonskaPloca klasa prosiruje JPanel i implementira ActionListener za slusanje dogadjanja na ekranu.
 *   Ima zadani konstruktor koji inicijalizira zaslonsku plocu. 
 *   InitScreenPanel metoda ucitava ikone i pokrece igru zmija stvarajuci misa i dijelove zmije.
 *    Akcijski dogadjaji na zaslonu pomicu zmiju na temelju trenutnog mjesta zmije i misa. 
 *    Ako se sudar dogodi, povecava se zmija. Ako zmija udari u zidove, igra je gotova.
 */

public class ZaslonskaPloca extends JPanel implements ActionListener {

    private final int sirina_zaslona = 300;
    private final int visina_zaslona = 300;
    private final int velicina_ikone = 10;
    private final int DOT_ICONS = 900;
    private final int rand_poz = 29;
    private final int razmak = 140;

    private final int x[] = new int[DOT_ICONS];
    private final int y[] = new int[DOT_ICONS];

    private int dijelovi;
    private int mis_x;
    private int mis_y;

    private boolean lijeviSmjer = false;
    private boolean desniSmjer = true;
    private boolean idi_gore = false;
    private boolean idi_dole = false;
    private boolean inSnakeGame = true;

    private Timer timer;
    private Image snakepart;
    private Image mis;
    private Image snakehead;

    public ZaslonskaPloca() {
        
        initScreenPanel();
    }
    
    private void initScreenPanel() {

        addKeyListener(new GameKeyAdapter());
        setBackground(Color.black);
        setFocusable(true);

        setPreferredSize(new Dimension(sirina_zaslona, visina_zaslona));
        loadIcons();
        initSnakeGame();
    }

    private void loadIcons() {

        ImageIcon iisnakepart = new ImageIcon("src/resources/snakepart.png");
        snakepart = iisnakepart.getImage();

        ImageIcon iimis = new ImageIcon("src/resources/mis.png");
        mis = iimis.getImage();

        ImageIcon iisnakehead = new ImageIcon("src/resources/snakehead.png");
        snakehead = iisnakehead.getImage();
    }

    private void initSnakeGame() {

        dijelovi = 5;

        for (int z = 0; z < dijelovi; z++) {
            x[z] = 50 - z * 10;
            y[z] = 50;
        }
        
        lokacijaMisa();

        timer = new Timer(razmak, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }
    
    private void doDrawing(Graphics g) {
        
        if (inSnakeGame) {

            g.drawImage(mis, mis_x, mis_y, this);

            for (int z = 0; z < dijelovi; z++) {
                if (z == 0) {
                    g.drawImage(snakehead, x[z], y[z], this);
                } else {
                    g.drawImage(snakepart, x[z], y[z], this);
                }
            }

            Toolkit.getDefaultToolkit().sync();

        } else {

            krajIgrice(g);
        }        
    }

    private void krajIgrice(Graphics g) {
        
        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (sirina_zaslona - metr.stringWidth(msg)) / 2, visina_zaslona / 2);
    }

    private void nadjiLokacijuMisa() {

        if ((x[0] == mis_x) && (y[0] == mis_y)) {

            dijelovi++;
            lokacijaMisa();
        }
    }

    private void shift() {

        for (int z = dijelovi; z > 0; z--) {
            x[z] = x[(z - 1)];
            y[z] = y[(z - 1)];
        }

        if (lijeviSmjer) {
            x[0] -= velicina_ikone;
        }

        if (desniSmjer) {
            x[0] += velicina_ikone;
        }

        if (idi_gore) {
            y[0] -= velicina_ikone;
        }

        if (idi_dole) {
            y[0] += velicina_ikone;
        }
    }

    private void findCollision() {

        for (int z = dijelovi; z > 0; z--) {

            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                inSnakeGame = false;
            }
        }

        if (y[0] >= visina_zaslona) {
            inSnakeGame = false;
        }

        if (y[0] < 0) {
            inSnakeGame = false;
        }

        if (x[0] >= sirina_zaslona) {
            inSnakeGame = false;
        }

        if (x[0] < 0) {
            inSnakeGame = false;
        }
        
        if (!inSnakeGame) {
            timer.stop();
        }
    }

    private void lokacijaMisa() {

        int r = (int) (Math.random() * rand_poz);
        mis_x = ((r * velicina_ikone));

        r = (int) (Math.random() * rand_poz);
        mis_y = ((r * velicina_ikone));
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        if (inSnakeGame) {

            nadjiLokacijuMisa();
            findCollision();
            shift();
        }

        repaint();
    }

    private class GameKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent event) {

            int key = event.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) && (!desniSmjer)) {
                lijeviSmjer = true;
                idi_gore = false;
                idi_dole = false;
            }

            if ((key == KeyEvent.VK_RIGHT) && (!lijeviSmjer)) {
                desniSmjer = true;
                idi_gore = false;
                idi_dole = false;
            }

            if ((key == KeyEvent.VK_UP) && (!idi_dole)) {
                idi_gore = true;
                desniSmjer = false;
                lijeviSmjer = false;
            }

            if ((key == KeyEvent.VK_DOWN) && (!idi_gore)) {
                idi_dole = true;
                desniSmjer = false;
                lijeviSmjer = false;
            }
        }
    }
}
