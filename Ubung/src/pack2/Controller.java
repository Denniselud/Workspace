package pack2;

import java.io.BufferedReader;
import java.io.FileReader;

public class Controller {

	private BinBaum baum;
	private String txt = "";

	@SuppressWarnings("unused")

	public Controller() {

	}

	public String leseTxt(String path) {

		FileReader f;
		BufferedReader b;
		try {
			f = new FileReader(path);
			b = new BufferedReader(f);
			this.txt = b.readLine();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return txt;
	}

	/*
	 * public String textGen(int textLenge) { txt = "";
	 * 
	 * for (int i = 0; i < textLenge; i++) { txt = txt + zeichenTabelle.charAt((int)
	 * (Math.random() * zeichenTabelle.length())); }
	 * System.out.println("Generierter text :" + txt.length() + "\n" +
	 * toString(txt)); return txt;
	 * 
	 * }
	 */
	private int kleinsteHeufigkeit(String x1) {

		for (int i = 0; i < x1.length(); i++) {
			if (getHeufigkeit(x1.charAt(i)) == (i + 1)) {
				return i;
			}
		}

		return 0;

	}

	public void baumErstellen(String x) {
		baum = new BinBaum();
		Knoten[] k = new Knoten[x.length()];
		String x1 = new String(x);

		for (int i = 0; i < k.length; i++) {
			k[i] = new Knoten(x.charAt(i) + "", getHeufigkeit(x.charAt(i)), null, null);
		}

		while (x1.length() > 0) {
			int i = kleinsteHeufigkeit(x1);
			Knoten k1 = new Knoten(k[i]);
			x1 = x1.substring(i, i + 1) + x1.substring(i + 1);

			int i2 = kleinsteHeufigkeit(x1);
			Knoten k2 = new Knoten(k[i2]);
			x1 = x1.substring(i2, i2 + 1) + x1.substring(i2 + 1);

			if (baum.getWurzel() == null) {
				baum.setWurzel(
						new Knoten(k1.getZeichen() + k2.getZeichen(), k1.getHeufigkeit() + k2.getHeufigkeit(), k1, k2));
			}else {
				
			}

		}

	}

	/**
	 * Die methode rechnet wie oft der Zeichen zeichen im String zeichenTabelle
	 * vorkommt
	 * 
	 * 
	 */
	private int getHeufigkeit(char zeichen) {
		int heufg = 0;
		for (int i = 0; i < txt.length(); i++) {
			if (zeichen == txt.charAt(i)) {
				heufg++;
			}
		}
		// System.out.println(wahrscheinlichkeit);
		return heufg;

	}

	public BinBaum getBaum() {
		return baum;
	}

	public void setBaum(BinBaum baum) {
		this.baum = baum;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public String toString(String s) {
		String t = "";
		for (int i = 0; i < s.length(); i++) {
			if (i % 100 == 0) {
				if (i == 0) {
					t = t + s.charAt(i);
				} else {
					t = t + s.charAt(i) + "\n";
				}
			} else {
				t = t + s.charAt(i);
			}
		}
		return t;
	}

}
