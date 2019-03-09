package figuren;

public class Dreieck {
	
	private Punkt p1;
	private Punkt p2;
	private Punkt p3;
	
	private double seiteA;
	private double seiteB;
	private double seiteC;
	
	private double winkelA;
	private double winkelB;
	private double winkelC;
	
	private double fleche;
	
	public Dreieck(Punkt p1,Punkt p2,Punkt p3) {
		this.p1=p1;
		this.p2=p2;
		this.p3=p3;
		seiteA=p1.abstandBerechnen(p2);
		seiteB=p2.abstandBerechnen(p3);
		seiteC=p3.abstandBerechnen(p1);
		
	}

}
