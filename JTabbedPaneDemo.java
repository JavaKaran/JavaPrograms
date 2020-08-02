import javax.swing.*;
import java.awt.*;
public class JTabbedPaneDemo {
	public JTabbedPaneDemo() {
		
		JFrame jfrm = new JFrame("JTabbedPaneDemo");
		jfrm.setLayout(new FlowLayout());
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm.setSize(400,400);
		
		JTabbedPane jtp = new JTabbedPane();
		jtp.addTab("Cities", new CitiesPanel());
		jtp.addTab("Colors", new ColorsPanel());
		jtp.addTab("Flavours", new FlavoursPanel());
		jfrm.add(jtp);
		jfrm.setVisible(true);
	}
	
	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new JTabbedPaneDemo();
			}
		}
	);
	}
}

class CitiesPanel extends JPanel{
	public CitiesPanel() {
		JButton b1 = new JButton("New York");
		add(b1);
		JButton b2 = new JButton("London");
		add(b2);
		JButton b3 = new JButton("Hong Kong");
		add(b3);
		JButton b4 = new JButton("Tokyo");
		add(b4);
	}
}

class ColorsPanel extends JPanel{
	public ColorsPanel() {
		JCheckBox cb1 = new JCheckBox("Red");
		add(cb1);
		JCheckBox cb2 = new JCheckBox("Green");
		add(cb2);
		JCheckBox cb3 = new JCheckBox("Blue");
		add(cb3);
	}
}

class FlavoursPanel extends JPanel{
	public FlavoursPanel() {
		JComboBox<String> jcb = new JComboBox<String>();
		jcb.addItem("Vanilla");
		jcb.addItem("Chocolate");
		jcb.addItem("Strawberry");
		
		add(jcb);
	}
}