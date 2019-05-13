package pack1;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	private Feld f;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Feld f = new Feld();
					Thread t = new Thread(f);
					MainFrame frame = new MainFrame(f);
					frame.setVisible(true);
					t.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame(Feld f) {
		f.setFocusable(true);
		f.requestFocus();
		f.setBounds(50, 50, 500, 500);
		f.setBackground(Color.BLACK);
		this.f = f;
		setBounds(500, 100, 650, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(f);
		getContentPane().setLayout(null);
	}

}
