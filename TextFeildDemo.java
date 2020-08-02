import java.awt.*;
import java.awt.event.*;

public class TextFeildDemo extends Frame implements ActionListener {

TextField name,pass;
	
public TextFeildDemo() {
	
	setLayout(new FlowLayout());
	
	Label namep = new Label("Name : ", Label.RIGHT);
	Label passp = new Label("Password : ", Label.RIGHT);
	name = new TextField(12);
	pass = new TextField(8);
	pass.setEchoChar('*');
	
	add(namep);
	add(name);
	add(passp);
	add(pass);
	
	name.addActionListener(this);
	pass.addActionListener(this);
	
	addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent we) {
			System.exit(0);
		}
	});
	
}
	
		public void actionPerformed(ActionEvent ae){
		repaint();
	}
    
	public void paint(Graphics g){
		g.drawString("Name :" + name.getText(),20,100);
		g.drawString("Selected Text in Name :" + name.getSelectedText(),20,120);
		g.drawString("Password :" + pass.getText(),20,140);
	}
	
	public static void main(String[] args) {
		TextFeildDemo appwin = new TextFeildDemo();
		appwin.setSize(new Dimension(380,180));
		appwin.setTitle("TextFieldDemo");
		appwin.setVisible(true);
	}
	
  }

