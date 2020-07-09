package chess;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI{
	
	public GUI() {
		
		new GuiFrame();
	}
	
	
}

class GuiFrame extends JFrame{

	private JFrame frame = new JFrame();
	private Container contentPane;
	
	private final Color BLACK= new Color(0, 0, 0);
	private final Color WHITE = new Color(255, 255, 255);
	
	public GuiFrame(){
		
			
			
			frame.setTitle("Chess version 0.1");
			frame.setSize(700,700); // default size is 0,0
			frame.setLocationRelativeTo(null); //Centers window	
			frame.setVisible(true); //To make the frame visible
			frame.addWindowListener(new WindowAdapter() { //Makes frame properly close
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			} );
			
				

	}
}

class GuiPanel extends JPanel implements ActionListener{
	
	public GuiPanel() {
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}