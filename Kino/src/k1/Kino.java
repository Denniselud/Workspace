package k1;

public class Kino {

	private boolean[][] sitze;

	public Kino(int reien, int sitze) {
		setSitze(new boolean[reien][sitze]);
		setzeSitzeZufellig();
	}

	private void setzeSitzeZufellig() {

		for (int i = 0; i < sitze.length; i++) {
			for (int j = 0; j < sitze[i].length; j++) {
				double random = Math.random();
				if (random > 0.5) {
					sitze[i][j] = true;
				} else {
					sitze[i][j] = false;
				}

			}
		}

	}

	boolean sucheNachSitze(int fSitze) {

		int z = fSitze;

		for (int i = 0; i < sitze.length; i++) {
			for (int j = 0; j < sitze[i].length - fSitze; j++) {
				if (sitze[i][j] == false) {
					z--;
					if (z == 0) {
						return true;

					}
				}
				// System.out.print(sitze[i][j] + " ");
			}
		}
		return false;
	}

	public boolean[][] getSitze() {
		return sitze;
	}

	public void setSitze(boolean[][] sitze) {
		this.sitze = sitze;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < sitze.length; i++) {
			s = s + "\n";
			for (int j = 0; j < sitze[i].length; j++) {
				s = s + "[" + sitze[i][j] + "]" + " ";
			}
		}
		return s;
	}
}
