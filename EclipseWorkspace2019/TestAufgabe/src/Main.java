import java.util.Scanner;

public class Main {
	/**
	 * @author Dennis
	 * @param args
	 */
	public static void main(String[] args) {

		TestAufgabe t = new TestAufgabe();
		Scanner sc = new Scanner(System.in);
		System.out.println("Zahlen eingabe: ");
		String st = sc.nextLine();
		/**
		 * Solange wir kein "stop" eingeben ,konnen wir weiter zahlen eingeben
		 */
		while (st.compareTo("stop") != 0) {
			t.zahlenEingabe(st);
			System.out.println("Zahlen eingabe: ");
			st = sc.nextLine();
		}

	}

}
