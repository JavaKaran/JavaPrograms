import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.lang.reflect.*;
import javax.imageio.*;

public class ImageFilterDemo extends Frame implements ActionListener{
	Image img;
	PlugInFilter pif;
	Image fimg;
	Image curImg;
	LoadedImage lim;
	Label lab;
	Button reset;
	
	String[] filters = { "Grayscale", "Invert", "Contrast", "Blur", "Sharpen"};
	
	public ImageFilterDemo() {
		Panel p = new Panel();
		add(p, BorderLayout.SOUTH);
		
		for(String fstr: filters) {
			Button b = new Button(fstr);
			b.addActionListener(this);
			p.add(b);
		}
		
		lab = new Label("");
		add(lab, BorderLayout.NORTH);
		try {
			File imageFile = new File("Lilies.jpg");
			
			img= ImageIO.read(imageFile);
		}catch(IOException exc) {
			System.out.println("Cannot load image file");
			System.exit(0);
		}
		
		lim = new LoadedImage(img);
		add(lim, BorderLayout.CENTER);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}
	
	public void actionPerformed(ActionEvent ae) {
		String a = "";
		
		try {
			a = ae.getActionCommand();
			if(a.equals("Reset")) {
				lim.set(img);
				lab.setText("Normal");
			}
			else {
				pif = (PlugInFilter)(Class.forName(a)).getConstructor().newInstance();
				fimg = pif.filter(this, img);
				lim.set(fimg);
				lab.setText("Filtered: " + a);
			}
			repaint();
		}catch(ClassNotFoundException e) {
			lab.setText(a + "not found");
			lim.set(img);
		}catch(InstantiationException e) {
			lab.setText("couldn't new" + a);
		}catch(IllegalAccessException e) {
			lab.setText("no access:" + a);
		}catch(NoSuchMethodException | InvocationTargetException e) {
			lab.setText("Filter creation error" + e);
		}
	}
	
	public static void main(String[] args) {
		ImageFilterDemo appwin = new ImageFilterDemo();
		
		appwin.setSize(new Dimension(420,420));
		appwin.setTitle("Image Filter Demo");
		appwin.setVisible(true);
	}
	
	interface PlugInFilter{
		java.awt.Image filter(java.awt.Frame f, java.awt.Image in);
	}
	
	public class LoadedImage extends Canvas{
		Image img;
		
		public LoadedImage(Image i) {
			set(i);
		}
		
		void set(Image i) {
			img = i;
			repaint();
		}
		
		public void paint(Graphics g) {
			if(img==null) {
				g.drawString("no image",10,30);
			}else {
				g.drawImage(img,0,0,this);
			}
		}
		
		public Dimension getPrefferedSize() {
			return new Dimension(img.getWidth(this),img.getHeight(this));
		}
		
		public Dimension getMinimumSize() {
			return getPrefferedSize();
		}
	}
}
