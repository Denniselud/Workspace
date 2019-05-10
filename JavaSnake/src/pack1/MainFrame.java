package pack1;

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
					MainFrame frame = new MainFrame(f);
					frame.setVisible(true);
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
		this.f = f;
		setBounds(500, 100, 580, 580);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(f);
		getContentPane().setLayout(null);
	}

}
