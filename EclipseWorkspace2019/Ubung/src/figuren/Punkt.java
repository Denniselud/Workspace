package figuren;

@SuppressWarnings("unused")
class Punkt {

	private double x;
	private double y;
	private double z;

	public Punkt() {
		x = 0;
		y = 0;
		z = 0;
	}

	public Punkt(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public double abstandBerechnen(Punkt p2) {

		double a1 = p2.getX() - x;
		double a2 = p2.getY() - y;
		double a3 = p2.getZ() - z;

		double qp1 = Math.pow(a1, 2); // (q1-p1)^2
		double qp2 = Math.pow(a2, 2);// (q2-p2)^2
		double qp3 = Math.pow(a3, 2);// (q3-p3)^2

		double pq = Math.sqrt(qp1 + qp2 + qp3);

		return pq;
	}
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	@Override
	public String toString() {

		return "x " + x + " " + "y " + y + " " + "z " + z;
	}

}