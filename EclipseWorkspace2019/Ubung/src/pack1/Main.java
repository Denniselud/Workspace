package pack1;

import java.util.Observable;
import java.util.Scanner;

import pack0.ZahlenUmwandeln;

public class Main extends Observable {
	

	public static void main(String[] args) {
		//GuiPack1 gui = new GuiPack1();
		flow(-1);
	}

	static void flow(int num) {
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("\n Bitte Ausw�len: " + "\n" + "1 f�r BinominalKoeffizent" + "\n" + "2 f�r Fakultet"
					+ "\n" + "3 f�r SatzDesHerons" + "\n" + "4 f�r Zahlen Umwandeln" + "\n"
					+ "5 Berechne Abstand zweier Punkte im Raum\n" + "0 f�r Stop");
			int l = num;
			if (num == -1) {
				l = sc.nextInt();
			}

			select(sc, l);

		} catch (Exception e) {
			System.err.println("Fehler");
			e.printStackTrace();
			flow(-1);
		}
	}

	private static void select(Scanner sc, int l) {
		switch (l) {
		case 1:
			System.out.println("Bitte geben Sie den wert von n ein: ");
			Long n = sc.nextLong();
			System.out.println("Bitte geben Sie den wert von k ein: ");
			Long k = sc.nextLong();
			System.out.println("Binominal Koeffizent: ");
			System.out.println(BinKoeffizent.calc(n, k));
			flow(-1);
			break;
		case 2:
			System.out.println("Bitte geben Sie den wert von f ein: ");
			System.out.println("Fakult�t: " + Fakultet.fakultet(sc.nextLong()));
			flow(-1);
			break;
		case 3:
			System.out.println("Bitte geben Sie die werte f�r a,b,c ein: ");
			double a = sc.nextDouble();
			double b = sc.nextDouble();
			double c = sc.nextDouble();
			System.out.println("SatzDesHeron: " + SatzDesHeron.satzDesHeron(a, b, c));
			flow(-1);
			break;
		case 4:
			System.out.println("Zahlen Umwandeln");
			ZahlenUmwandeln zl = new ZahlenUmwandeln();
			System.out.println("Dezimal Zahl eingeben: ");
			int dez = sc.nextInt();
			System.out.println("DezToBin: " + zl.dezToBin(dez));
			System.out.println("DezToHex: " + zl.dezToHex(dez));
			System.out.println("DezToOktal: " + zl.dezToOkt(dez));
			flow(-1);
			break;
		case 5:
			System.out.println("Koordinaten eingeben: ");
			System.out.println("Punkt 1: x= ");
			double x = sc.nextDouble();
			System.out.println("Punkt 1: y= ");
			double y = sc.nextDouble();
			System.out.println("Punkt 1: z= ");
			double z = sc.nextDouble();

			Punkt p1 = new Punkt(x, y, z);

			System.out.println("Punkt 2: x= ");
			x = sc.nextDouble();
			System.out.println("Punkt 2: y= ");
			y = sc.nextDouble();
			System.out.println("Punkt 2: z= ");
			z = sc.nextDouble();

			Punkt p2 = new Punkt(x, y, z);

			Abstand ab = new Abstand(p1, p2);
			System.out.println("Abstand: "+ab.abstandBerechnen());
			flow(-1);
			break;
		
		case 0:
			System.out.println("Ende");
			sc.close();
			System.exit(0);
			break;
		default:
			System.out.println("falsche eingabe");
			flow(-1);
			break;
		}

	}

}
