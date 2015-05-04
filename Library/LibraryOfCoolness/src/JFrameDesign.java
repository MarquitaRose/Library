import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JFrameDesign extends JFrame {
	
	

	public JFrameDesign(){
		initUI();
		
	} 
	
	public static void main(String[]args){
		 EventQueue.invokeLater(new Runnable() {

	            public void run() {
	                JFrameDesign ex = new JFrameDesign();
	                ex.setVisible(true);
	            }
	        });
	}
	
	private void initUI(){ 
    Toolkit tk = Toolkit.getDefaultToolkit();
    int SWidth = ((int) tk.getScreenSize().getWidth());
    int SHeight = ((int) tk.getScreenSize().getHeight());
		setTitle("Library");
     setSize(SWidth, SHeight);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setLocationRelativeTo(null);
	}
}

 
@SuppressWarnings("serial")
class DrawStuff extends JPanel{
	 Image Welcome = new ImageIcon("Welcome.gif").getImage();
	
	 
	 private void doDrawing(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    System.out.println(" Meeeh");
    g2d.drawImage(Welcome, 0, 0, null);
}

@Override
public void paintComponent(Graphics g) {

    super.paintComponent(g);
    doDrawing(g);
}

}