package pack1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Feld extends JPanel implements KeyListener, Runnable {

	private static final int stop = 0;
	private static final int links = 1;
	private static final int rechts = 2;
	private static final int oben = 3;
	private static final int unten = 4;
	int aktuelleRichtung = links;

	private static final int FELDGROSSE = 10;
	private static final int GROSSE = 50;
	private Point[][] feld;
	private ArrayList<Point> schlange;
	private ArrayList<Point> food;
	private Point kopf = new Point(25, 25);
	private int timerMillisec = 1000;
/*	Timer t = new Timer(3000, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			food = setRandomFood(50);

		}
	});
*/
	public Feld() {

		feld = new Point[GROSSE][GROSSE]; // Spielfeld erstellen
		for (int i = 0; i < feld.length; i++) {
			for (int j = 0; j < feld[i].length; j++) {
				feld[i][j] = new Point(i, j);
			}
		}

		schlange = new ArrayList<>(); // Schlange erstellen
		schlange.add(0, new Point(25, 25));
		schlange.add(1, new Point(26, 25));
		schlange.add(2, new Point(27, 25));
		food = setRandomFood(50);
		this.addKeyListener(this);
	}

	private boolean vergleiche(Point p1, Point p2) {
		if ((p1.x == p2.x) && (p1.y == p2.y)) {
			return true;
		} else {
			return false;
		}
	}

	private ArrayList<Point> setRandomFood(int anzahlApfel) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Point> apfel = new ArrayList<>();
		while (apfel.size() <= anzahlApfel) {
			Point apf = new Point(new Random().nextInt(51), new Random().nextInt(51));
			if (!(apfel.contains(apf)) && !(schlange.contains(apf))) {
				apfel.add(new Point(apf));
			}

		}
		return apfel;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		//drawField(g);
		drawFood(g);
		drawSnake(g);

	}

	private void drawFood(Graphics g) {
		for (int i = 0; i < food.size(); i++) {
			g.setColor(Color.RED);
			g.fillOval(food.get(i).x * FELDGROSSE, food.get(i).y * FELDGROSSE, 10, 10);

		}

	}

	private void drawSnake(Graphics g) {
		g.setColor(Color.GREEN);
		for (int i = 0; i < schlange.size(); i++) {
			g.fillOval(schlange.get(i).x * FELDGROSSE, schlange.get(i).y * FELDGROSSE, 10, 10);
		}

	}

	private void drawField(Graphics g) {
		g.setColor(Color.GREEN);
		for (int i = 0; i < feld.length; i++) {
			for (int j = 0; j < feld[i].length; j++) {
				g.drawOval(i * FELDGROSSE, j * FELDGROSSE, 10, 10);
			}
		}

	}

	private boolean collisionCheck() {
		if ((kopf.x < 0 || kopf.x > 50) || (kopf.y < 0 || kopf.y > 50)) {
			setaktuelleRichtung(stop);
			return true;
		}

		return false;
	}

	private void moveSnake(Point p, int richtung) {

		if (food.contains(p)) {
			kopf = new Point(p);
			schlange.add(0, p);
			food.remove(p);
			// food = setRandomFood();
			setTimer();
		} else {
			kopf = new Point(p);
			schlange.add(0, p);
			schlange.remove(schlange.size() - 1);
		}

	}

	private int setTimer() {
		System.out.println(timerMillisec);

		if (timerMillisec <= 100) {
			timerMillisec = timerMillisec - 5;
			return timerMillisec;
		}
		if (timerMillisec <= 200) {
			timerMillisec = timerMillisec - 10;
			return timerMillisec;
		}
		if (timerMillisec <= 500) {
			timerMillisec = timerMillisec - 100;
			return timerMillisec;
		}
		if (timerMillisec <= 1000) {
			timerMillisec = timerMillisec - 200;
			return timerMillisec;
		}

		return timerMillisec;

	}

	@Override
	public void run() {
		
		//t.start();
		while (aktuelleRichtung != stop) {
			collisionCheck();
			switch (aktuelleRichtung) {
			case links:
				if (aktuelleRichtung != rechts) {
					System.out.println("links");
					moveSnake(new Point(kopf.x - 1, kopf.y), links);
					setaktuelleRichtung(links);// aktuelleRichtung = links;
				}
				repaint();
				break;

			case rechts:
				if (aktuelleRichtung != links) {
					System.out.println("rechts");
					moveSnake(new Point(kopf.x + 1, kopf.y), rechts);
					setaktuelleRichtung(rechts);
				}
				repaint();
				break;
			case oben:
				if (aktuelleRichtung != unten) {
					System.out.println("oben");
					moveSnake(new Point(kopf.x, kopf.y - 1), oben);
					setaktuelleRichtung(oben);
				}
				repaint();
				break;
			case unten:
				if (aktuelleRichtung != oben) {
					System.out.println("unten");
					moveSnake(new Point(kopf.x, kopf.y + 1), links);
					setaktuelleRichtung(unten);
				}
				repaint();
				break;
			default:
				break;
			}

			try {
				Thread.sleep(timerMillisec);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	synchronized void setaktuelleRichtung(int richtung) {
		this.aktuelleRichtung = richtung;

	}

	@Override
	public void keyReleased(KeyEvent e) {

		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			setaktuelleRichtung(links);
			// repaint();
			break;
		case KeyEvent.VK_RIGHT:
			setaktuelleRichtung(rechts);
			// repaint();
			break;
		case KeyEvent.VK_UP:
			setaktuelleRichtung(oben);
			// repaint();
			break;
		case KeyEvent.VK_DOWN:
			setaktuelleRichtung(unten);
			// repaint();
			break;
		default:
			break;
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
