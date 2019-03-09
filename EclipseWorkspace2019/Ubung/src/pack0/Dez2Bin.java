package pack0;

public class Dez2Bin {
	int zielbasis = 2;
	int dezimalZahl = 10;

	int rest = 0;

	public Dez2Bin() {
		// TODO Auto-generated constructor stub
	}

	public Dez2Bin(int dezimalZahl, int divisor) {
		int dw = dezimalZahl;
		while (dw > 0) {
			dezimalZahl = dezimalZahl % 2;

		}
	}

}
