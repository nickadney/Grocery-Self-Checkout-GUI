package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import pointOffSale.Product;
import pointOffSale.ProductCollection;
import java.awt.BorderLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Nick's Grocer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Panel panel = new Panel();
		frame.getContentPane().add(panel);
	
		frame.pack();
		frame.setVisible(true);
		
		//this will caLL doClose upon the window being closed
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				panel.doClose();
			}
		});

	}
}
