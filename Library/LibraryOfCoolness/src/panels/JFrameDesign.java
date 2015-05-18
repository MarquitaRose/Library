package panels;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



@SuppressWarnings("serial")
public class JFrameDesign extends JFrame {
	 Toolkit tk = Toolkit.getDefaultToolkit();
	int SWidth = ((int) tk.getScreenSize().getWidth());
    int SHeight = ((int) tk.getScreenSize().getHeight());

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
		JButton welcome = new JButton("Go to Catalog");
		/////MAKAELA/////
		// This line right beneath what you are reading |vvv| adjusts the size of the button//
		  welcome.setBounds(((SWidth / 2)- 200), 600, 400, 50);
		  Font welcomeButton = new Font("Serif", Font.PLAIN, 30);
		  welcome.setFont(welcomeButton);
		welcome.setBackground(Color.magenta);
		  welcome.setForeground(Color.green);
	/////MAKAELA/////
		welcome.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event){
				CatalogHome homie = new CatalogHome();
				homie.textfieldLayout();
				homie.setBackground(Color.red);
				add(homie);
				homie.setVisible(true);
			}
		});
		
		createLayout(welcome);
		 
		
		DrawStuff panel = new DrawStuff();
		panel.setBackground(Color.blue);
		add(panel);
		pack();
		panel.setVisible(true);
   
		setTitle("Library of Coolness");
     setSize(SWidth, SHeight);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setLocationRelativeTo(null);
	}
	
	 private void createLayout(JComponent... arg) {

	        Container pane = getContentPane();
	        GroupLayout gl = new GroupLayout(pane);
	        pane.setLayout(null);

	        gl.setAutoCreateContainerGaps(true);

	        gl.setHorizontalGroup(gl.createSequentialGroup()
	                .addComponent(arg[0])
	        );

	        gl.setVerticalGroup(gl.createSequentialGroup()
	                .addComponent(arg[0])
	        );
	      
	    }
	
}

 
@SuppressWarnings("serial")
class DrawStuff extends JPanel{
	// Image Welcome = new ImageIcon("Welcome.gif").getImage();
	//Image Welcome = Toolkit.getDefaultToolkit().getImage("Welcome.gif");
	private BufferedImage welcome; 
	
	public void drawApp(Graphics2D g) {
	   BufferedImage sandy = null;
	   TexturePaint sandytp;
	   
	   	try{
	   			sandy = ImageIO.read(new File("hello.jpg"));
	   		} catch (IOException ex) {
	   			System.out.println("Uh, error!");
	   			Logger.getLogger(JFrameDesign.class.getName()).log(Level.SEVERE, null, ex);
	   		}
	  
	   		////Draws the water habitat////
		   Color water = new Color (39, 128, 216);
	   		g.setColor(water);
	   		g.fillRect(0, 0, 1600, 1000);
	   		sandytp = new TexturePaint(sandy, new Rectangle(10, 10, 100, 200));
	   		g.setPaint(sandytp);
	   		g.fillRect(0, 700, 1600, 200);
	   		System.out.println(" heyo");
	}

   /* public DrawStuff() {
    	BufferedImage sandy = null;
		   TexturePaint sandytp;
		   	try{
		   			sandy = ImageIO.read(new File("res/sand.jpg"));
		   		} catch (IOException ex) {
		   			System.out.println("Uh, error!");
		   			Logger.getLogger(JFrameDesign.class.getName()).log(Level.SEVERE, null, ex);
		   		}
    }*/
    
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(welcome, 0, 0, null);        
    }


	private void setSurfaceSize() {
	        
	        Dimension d = new Dimension();
	        d.width = welcome.getWidth(null);
	        d.height = welcome.getHeight(null);
	        setPreferredSize(d);        
	    }
	
	 private void doDrawing(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
 
    g2d.drawImage(welcome, 0, 0, this);
    g2d.finalize();
 
}

//@Override
/*public void paintComponent(Graphics g) {

    super.paintComponent(g);
    setSurfaceSize();
    doDrawing(g);
   
    System.out.println(" Meeeh");

}
*/
}