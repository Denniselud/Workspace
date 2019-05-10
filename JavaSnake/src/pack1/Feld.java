package pack1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;

public class Feld extends JPanel implements KeyListener, Runnable {

	private static final int links = 1;
	private static final int rechts = 2;
	private static final int oben = 3;
	private static final int unten = 4;
	private int aktuelleRichtung = links;

	private static final int FELDGROSSE = 10;
	private static final int GROSSE = 50;
	private Point[][] feld;
	private Point[] schlange;
	private Point food;
	private Point kopf = new Point(25, 25);

	public Feld() {
		setFocusable(true);
		requestFocus();
		food = getFood();
		this.setBounds(25, 25, 500, 500);
		this.setBackground(Color.BLACK);

		feld = new Point[GROSSE][GROSSE]; // Spielfeld erstellen
		for (int i = 0; i < feld.length; i++) {
			for (int j = 0; j < feld[i].length; j++) {
				feld[i][j] = new Point(i, j);
			}
		}

		schlange = new Point[3]; // Schlange erstellen
		// schlange[0] = kopf;
		schlange[0] = kopf;
		schlange[1] = new Point(26, 25);
		schlange[2] = new Point(27, 25);
		this.addKeyListener(this);
	}

	private Point[] schlangeVergrossern(Point p) {
		Point[] schlange2 = null;
		if (vergleiche(kopf, p)) {
			schlange2 = new Point[schlange.length + 1];
			for (int i = 0; i < schlange.length; i++) {
				schlange2[i] = schlange[i];

			}
			schlange2[schlange2.length - 1] = p;
		}

		return schlange2;
	}

	private void links() {

		if (aktuelleRichtung != rechts) {
			kopf.x = kopf.x - 1;
			for (int i = schlange.length - 1; i >= 1; i--) {
				schlange[i] = schlange[i - 1];
				schlange[i] = schlange[i - 1];
			}
		}
		aktuelleRichtung = links;
	}

	private void rechts() {
		if (aktuelleRichtung != links) {
			kopf.x = kopf.x + 1;
			for (int i = schlange.length - 1; i >= 1; i--) {
				schlange[i] = schlange[i - 1];
				schlange[i] = schlange[i - 1];
			}
		}
		aktuelleRichtung = rechts;
	}

	private void oben() {
		if (aktuelleRichtung != unten) {
			kopf.y = kopf.y - 1;
			for (int i = schlange.length - 1; i >= 1; i--) {
				schlange[i] = schlange[i - 1];
				schlange[i] = schlange[i - 1];
			}
		}
		aktuelleRichtung = oben;
	}

	private void unten() {
		if (aktuelleRichtung != oben) {
			kopf.y = kopf.y + 1;
			for (int i = schlange.length - 1; i >= 1; i--) {
				schlange[i] = schlange[i - 1];
				schlange[i] = schlange[i - 1];
			}
		}
		aktuelleRichtung = unten;
	}

	private boolean vergleiche(Point p1, Point p2) {
		if ((p1.x == p2.x) && (p1.y == p2.y)) {
			return true;
		} else {
			return false;
		}
	}

	private Point getFood() {
		int x, y;
		x = new Random().nextInt(51);
		y = new Random().nextInt(51);
		Point food = new Point(x, y);
		return food;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.GREEN);
		for (int i = 0; i < feld.length; i++) {
			for (int j = 0; j < feld[i].length; j++) {
				for (int j2 = 0; j2 < schlange.length; j2++) {
					if (vergleiche(feld[i][j], schlange[j2])) {
						g.fillOval(i * FELDGROSSE, j * FELDGROSSE, 10, 10);
					} else {
						if (vergleiche(feld[i][j], food)) {
							g.setColor(Color.RED);
							g.fillOval(i * FELDGROSSE, j * FELDGROSSE, 10, 10);
							g.setColor(Color.GREEN);
						}
						g.drawOval(i * FELDGROSSE, j * FELDGROSSE, 10, 10);
					}
				}
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			System.out.println("links");
			links();
			repaint();
			break;
		case KeyEvent.VK_RIGHT:
			System.out.println("rechts");
			rechts();
			repaint();
			break;
		case KeyEvent.VK_UP:
			System.out.println("oben");
			oben();
			repaint();
			break;
		case KeyEvent.VK_DOWN:
			System.out.println("unten");
			unten();
			repaint();
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

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
}
