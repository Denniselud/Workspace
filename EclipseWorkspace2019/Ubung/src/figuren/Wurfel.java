package figuren;

public class Wurfel implements Figur {

	private Punkt p1;
	private Punkt p2;
	private Punkt p3;
	private Punkt p4;
	private double seitenlenge;
	private double fl�che;
	private double volumen;

	public Wurfel(Punkt p1, Punkt p2, Punkt p3, Punkt p4) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.p4 = p4;
		seitenlenge = p1.abstandBerechnen(p2);
		fl�che = 6 * Math.pow(seitenlenge, 2);
		volumen = Math.pow(seitenlenge, 3);
	}

	public Punkt getP1() {
		return p1;
	}

	public void setP1(Punkt p1) {
		this.p1 = p1;
	}

	public Punkt getP2() {
		return p2;
	}

	public void setP2(Punkt p2) {
		this.p2 = p2;
	}

	public Punkt getP3() {
		return p3;
	}

	public void setP3(Punkt p3) {
		this.p3 = p3;
	}

	public Punkt getP4() {
		return p4;
	}

	public void setP4(Punkt p4) {
		this.p4 = p4;
	}

	public double getSeitenlenge() {
		return seitenlenge;
	}

	public void setSeitenlenge(double seitenlenge) {
		this.seitenlenge = seitenlenge;
	}

	public double getFl�che() {
		return fl�che;
	}

	public void setFl�che(double fl�che) {
		this.fl�che = fl�che;
	}

	public double getVolumen() {
		return volumen;
	}

	public void setVolumen(double volumen) {
		this.volumen = volumen;
	}
}
