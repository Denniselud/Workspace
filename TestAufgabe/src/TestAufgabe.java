
import java.util.Collections;
import java.util.LinkedList;

/**
 * Die klasse enthält zwei verketteten listen. Eine für geraden und eine für ungeraden zahlen
 * @author Dennis
 *	
 */
public class TestAufgabe {

	private LinkedList<Integer> listGerade;
	private LinkedList<Integer> listUngerade;

	public TestAufgabe() {
		listGerade = new LinkedList<Integer>();
		listUngerade = new LinkedList<Integer>();
	}

	/**
	 * Die Methode prüft ob die eingegebenen zahl gerede bzw. ungerade ist  und ob die zahl bereits vorhanden ist
	 * Auserdem fangen wir mögliche Exeptions ab  
	 * @param s
	 */
	public void zahlenEingabe(String s) {

		// sc.useDelimiter(" ");

		try {
			String[] d = eingabeVerarbeiten(s);

			for (int i = 0; i < d.length; i++) {

				int zahl = (int) Math.round(Double.valueOf(d[i]));

				if (zahl % 2 == 0 && !zahlVorhanden(zahl)) {
					listGerade.add(zahl);
					Collections.sort(listGerade);
					System.out.print("Gerade: " + toString(listGerade));
				}
				if ((zahl % 2 == 1 || zahl % 2 == -1) && !zahlVorhanden(zahl)) {
					listUngerade.add(zahl);
					Collections.sort(listUngerade);
					System.out.print("Ungerade: " + toString(listUngerade));
				}

			}

		} catch (Exception e) {
			System.err.println("Ungültige eingabe " + e.getStackTrace());

		}

	}

	/**
	 * Die Methode prüft ob einen Zahl bereits vorhanden ist
	 * 
	 * @param zahl
	 * @return boolean
	 */
	private boolean zahlVorhanden(int zahl) {
		if (listGerade.contains(zahl)) {
			return true;
		}
		if (listUngerade.contains(zahl)) {
			return true;
		}
		return false;
	}

	/**
	 * Die Methode verarbeitet die eingabe und gibt den als String array zurück
	 * 
	 * @param s
	 * @return String[]
	 */
	private String[] eingabeVerarbeiten(String s) {
		String x = s;
		x = x.replaceAll(" ", ",");
		x = x.replaceAll(",,", ",");
		// x = x.replace(",", " ");
		String[] split = x.split(",");
		return split;
	}

	/**
	 * Die Methode gibt den inhalt von der liste als String zurück
	 * 
	 * @param l
	 * @return String
	 */
	public String toString(LinkedList<Integer> l) {
		String s = "";

		for (int i = 0; i < l.size(); i++) {
			s = s + l.get(i) + ", ";
		}
		return s + "\n";
	}

}
