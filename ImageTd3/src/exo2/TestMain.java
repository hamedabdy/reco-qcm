package exo2;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestMain {

	public TestMain() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame jf = new JFrame();
		JPanel panel = new Histogramme();
		JPanel panel2 = new HistoHoriz();
		JPanel panel3 = new HistoVerti();
		jf.getContentPane().add(panel, BorderLayout.WEST);
		jf.getContentPane().add(panel2, BorderLayout.CENTER);
		jf.getContentPane().add(panel3, BorderLayout.EAST);
		jf.pack();
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
