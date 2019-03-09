package pack0;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class ZahlensystemeGUI extends JFrame {

	ZahlenUmwandeln zu;
	JTextField tf;
	JLabel lbl;
	JTextPane tp;
	JPanel panel;
	JButton chb[];
	JTextPane textPane;

	public ZahlensystemeGUI() {
		chb = new JButton[64];
		zu = new ZahlenUmwandeln();
		setResizable(false);
		setSize(594, 576);
		setLocation(100, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		lbl = new JLabel("Dezimal Zahl eingeben :");
		lbl.setBounds(186, 16, 205, 20);
		getContentPane().add(lbl);

		tf = new JTextField();
		tf.setBounds(186, 56, 177, 26);
		tf.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

				if (tf.getText().charAt(0) == '-') {
					tp.setText("Negative zahlen erst ab v 2.0  ;)  ");
				} else {
					int zahl = Integer.parseInt(tf.getText());
					String a = "Bin " + zu.dezToBin(zahl);
					String b = "Okt " + zu.dezToOkt(zahl);
					String c = "Hex " + zu.dezToHex(zahl);
					tp.setText(a + "\n" + b + "\n" + c);
				}

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		getContentPane().add(tf);

		tp = new JTextPane();
		tp.setBounds(0, 102, 436, 138);
		tp.setText("???");
		getContentPane().add(tp);

		panel = new JPanel();
		panel.setBounds(0, 259, 573, 233);

		
		getContentPane().add(panel);

		textPane = new JTextPane();
		textPane.setBounds(82, 494, 411, 26);
		getContentPane().add(textPane);

		JLabel lblBitmanipulator = new JLabel("BITMANIPULATOR");
		lblBitmanipulator.setBounds(186, 239, 177, 20);
		getContentPane().add(lblBitmanipulator);

		setVisible(true);

	}
}
