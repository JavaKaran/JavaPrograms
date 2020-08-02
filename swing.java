import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class swing {
	JLabel jlab;
	
	swing(){
		JFrame jfrm = new JFrame("An event Example");
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(220,90);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton jbtnAlpha = new JButton("Alpha");
		JButton jbtnBeta = new JButton("Beta");
		
		jbtnAlpha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				jlab.setText("Alpha was pressed");
			}
		});
		
		jbtnBeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				jlab.setText("Beta was pressed");
			}
		});
		
		jfrm.add(jbtnAlpha);
		jfrm.add(jbtnBeta);
		
		jlab = new JLabel("Press a Button");
		jfrm.add(jlab);
		jfrm.setVisible(true);
	}
	
	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new swing();
			}
		});
	}
}
