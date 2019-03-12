package k1;

import java.util.Scanner;

public class KinoMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Bitte Reien eingeben: ");
		int reien = sc.nextInt();
		System.out.println("Bitte Sitze eingeben: ");
		int sitze = sc.nextInt();
		Kino k = new Kino(reien, sitze);
		
		System.out.println(k.toString());
		System.out.println(k.sucheNachSitze(5));

	}

}
