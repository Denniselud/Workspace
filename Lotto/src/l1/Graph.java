package l1;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Graph extends JFrame {

	JPanel panel;

	public Graph(JPanel p) {
		setTitle("Graph");
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.panel = p;
		add(panel);
		setVisible(true);
	}

}
