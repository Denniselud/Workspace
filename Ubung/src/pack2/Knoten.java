package pack2;

public class Knoten {
	private String zeichen;
	private int heufigkeit;
	private Knoten links;
	private Knoten rechts;

	public Knoten(String zeichen, int heufigkeit, Knoten links, Knoten rechts) {
		this.zeichen = zeichen;
		this.links = links;
		this.rechts = rechts;
		this.heufigkeit = heufigkeit;

	}

	public Knoten(Knoten k) {
		this.zeichen = k.zeichen;
		this.links = k.links;
		this.rechts = k.rechts;
		this.heufigkeit = k.heufigkeit;
	}

	public String toString() {

		return this.zeichen + " " + this.heufigkeit;
	}

	public String getZeichen() {
		return zeichen;
	}

	public void setZeichen(String zeichen) {
		this.zeichen = zeichen;
	}

	public int getHeufigkeit() {
		return heufigkeit;
	}

	public void setHeufigkeitkeit(int warscheinlichkeit) {
		this.heufigkeit = warscheinlichkeit;
	}

	public Knoten getLinks() {
		return links;
	}

	public void setLinks(Knoten links) {
		this.links = links;
	}

	public Knoten getRechts() {
		return rechts;
	}

	public void setRechts(Knoten rechts) {
		this.rechts = rechts;
	}

}
