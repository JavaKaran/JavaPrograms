import java.awt.*;
import java.awt.event.*;
public class MouseEventsDemo extends Frame {
	String msg="";
	int mouseX=0,mouseY=0;
	
	public MouseEventsDemo() {
		addMouseListener(new MyMouseAdapter());
		addMouseMotionListener(new MyMouseAdapter());
	    addWindowListener(new MyWindowsAdapter()); 
	}
	
	class MyMouseAdapter extends MouseAdapter {
	
	public void mouseClicked(MouseEvent me) {
		msg=msg+"click recieved";
		repaint();
	}
	
	public void mouseEntered(MouseEvent me) {
		mouseX=100;
		mouseY=100;
		msg="Mouse Entered";
		repaint();
	}
	
	public void mouseExited(MouseEvent me) {
		mouseX=100;
		mouseY=100;
		msg="Mouse Exited";
		repaint();
	}
	
	public void mousePressed(MouseEvent me) {
		mouseX=me.getX();
		mouseY=me.getY();
		msg="Mouse Pressed";
		repaint();
	}
	
	public void mouseDragged(MouseEvent me) {
		mouseX=me.getX();
		mouseY=me.getY();
		msg="*" + "mouse at" + mouseX + "," + mouseY;
		repaint();
	}
	
	public void mouseReleased(MouseEvent me) {
		mouseX=me.getX();
		mouseY=me.getY();
		msg="Mouse Released";
		repaint();
	}
	
	public void mouseMoved(MouseEvent me) {
		msg="Mouse moved to" + me.getX() + "," + me.getY();
		repaint();
	}
	
	}	
public void paint(Graphics g) {
	g.drawString(msg, 20, 80);
}

public static void main(String[] args) {
	MouseEventsDemo appwin= new MouseEventsDemo();
	appwin.setSize(new Dimension(400,400));
	appwin.setTitle("AnonymousInnerClassDemo");
	appwin.setVisible(true);	
}

class MyWindowsAdapter extends WindowAdapter {
	public void WindowClosing(WindowEvent we) {
		System.exit(0);
	}
}

}
