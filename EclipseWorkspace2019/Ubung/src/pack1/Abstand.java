package pack1;

@SuppressWarnings("unused")
public class Abstand {

	private Punkt p1;
	private Punkt p2;

	public Abstand(Punkt p1, Punkt p2) {
		this.p1 = p1;
		this.p2 = p2;
		System.out.println(p1.toString());
		System.out.println(p2.toString());
	}

	public Abstand() {
		double x = Math.random() * 100;
		double y = Math.random() * 100;
		double z = Math.random() * 100;
		p1 = new Punkt(x, y, z);
		System.out.println(p1.toString());
		x = Math.random() * 100;
		y = Math.random() * 100;
		z = Math.random() * 100;
		p2 = new Punkt(x, y, z);
		System.out.println(p2.toString());
	}

	public double abstandBerechnen() {

		double a1 = p2.getX() - p1.getX();
		double a2 = p2.getY() - p1.getY();
		double a3 = p2.getZ() - p1.getZ();

		double qp1 = Math.pow(a1, 2); // (q1-p1)^2
		double qp2 = Math.pow(a2, 2);// (q2-p2)^2
		double qp3 = Math.pow(a3, 2);// (q3-p3)^2

		double pq = Math.sqrt(qp1 + qp2 + qp3);

		return pq;
	}

}