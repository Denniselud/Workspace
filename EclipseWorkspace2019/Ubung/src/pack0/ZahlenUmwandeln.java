package pack0;

public class ZahlenUmwandeln {

	public String dezToBin(int dez) {

		String s = "";
		while (dez != 0) {
			s = s + (dez % 2);
			dez = dez / 2;
		}

		String x = reverseString(s);

		return x;
	}

	public String dezToHex(int dez) {

		String s = "";
		while (dez != 0) {

			switch (dez % 16) {
			case 0:
				s = s + "0";
				break;
			case 1:
				s = s + "1";
				break;
			case 2:
				s = s + "2";
				break;
			case 3:
				s = s + "3";
				break;
			case 4:
				s = s + "4";
				break;
			case 5:
				s = s + "5";
				break;
			case 6:
				s = s + "6";
				break;
			case 7:
				s = s + "7";
				break;
			case 8:
				s = s + "8";
				break;
			case 9:
				s = s + "9";
				break;
			case 10:
				s = s + "A";
				break;
			case 11:
				s = s + "B";
				break;
			case 12:
				s = s + "C";
				break;
			case 13:
				s = s + "D";
				break;
			case 14:
				s = s + "E";
				break;
			case 15:
				s = s + "F";
				break;

			default:
				System.out.println("!!!");
				break;
			}

			dez = dez / 16;
		}
		s = reverseString(s);

		return s;
	}

	public String dezToOkt(int dez) {
		String s = "";

		while (dez != 0) {
			s = s + (dez % 8);
			dez = dez / 8;
		}
		s = reverseString(s);
		return s;
	}

	private String reverseString(String s) {
		String x = "";

		for (int i = s.length() - 1; i >= 0; i--) {
			x = x + s.charAt(i);
		}
		return x;

	}

}
