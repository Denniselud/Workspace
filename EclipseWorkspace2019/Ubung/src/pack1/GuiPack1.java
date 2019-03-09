package pack1;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class GuiPack1 extends JFrame {

	JFrame fr;
	JPanel jp;
	JButton b0;
	JButton b1;
	JButton b2;
	JButton b3;
	JButton b4;
	JButton b5;
	JTextPane textPane;
	MouseListener l = new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			JButton b=(JButton)e.getSource();
			Main.flow(Integer.parseInt(b.getText()));
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	};

	public GuiPack1() {
	
		jp = new JPanel();
		b0 = new JButton("0");
		b0.addMouseListener(l);
		b0.setBounds(103, 5, 41, 29);
		b1 = new JButton("1");
		b1.setBounds(149, 5, 41, 29);
		b2 = new JButton("2");
		b2.setBounds(195, 5, 41, 29);
		b3 = new JButton("3");
		b3.setBounds(241, 5, 41, 29);
		b4 = new JButton("4");
		b4.setBounds(287, 5, 41, 29);
		b5 = new JButton("5");
		b5.setBounds(333, 5, 41, 29);
		fr = new JFrame("GuiPack1");
		fr.setDefaultCloseOperation(EXIT_ON_CLOSE);
		fr.setSize(500, 500);
		fr.setLocation(500, 100);
		jp.setLayout(null);
		jp.add(b0);
		jp.add(b1);
		jp.add(b2);
		jp.add(b3);
		jp.add(b4);
		jp.add(b5);
		fr.getContentPane().add(jp);
		textPane = new JTextPane();
		textPane.setBorder(BorderFactory.createLineBorder(Color.black));
		textPane.setBounds(15, 71, 448, 357);
		jp.add(textPane);
		setResizable(false);
		setAlwaysOnTop(true);
		fr.setVisible(true);
	}

	public JFrame getFr() {
		return fr;
	}

}
