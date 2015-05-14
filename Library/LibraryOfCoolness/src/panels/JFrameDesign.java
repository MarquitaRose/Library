package panels;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
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
		JButton welcome = new JButton("Go to Catalog");
		  welcome.setBounds(700, 600, 200, 25);
		 
		//welcome.setLocation(400, 500);
	
		welcome.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event){
				CatalogHome homie = new CatalogHome();
				homie.textfieldLayout();
				add(homie);
				homie.setVisible(true);
				/*CatalogHome homie = new CatalogHome();
				add(homie);
				pack();
				homie.setVisible(true);
				*/
			}
		});
		
		createLayout(welcome);
		 
		
		DrawStuff panel = new DrawStuff();
		add(panel);
		pack();
		panel.setVisible(true);
    Toolkit tk = Toolkit.getDefaultToolkit();
    int SWidth = ((int) tk.getScreenSize().getWidth());
    int SHeight = ((int) tk.getScreenSize().getHeight());
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
	Image Welcome = Toolkit.getDefaultToolkit().getImage("Welcome.gif");
	 
	private void setSurfaceSize() {
	        
	        Dimension d = new Dimension();
	        d.width = Welcome.getWidth(null);
	        d.height = Welcome.getHeight(null);
	        setPreferredSize(d);        
	    }
	
	 private void doDrawing(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
 
    g2d.drawImage(Welcome, 0, 0, this);
    g2d.finalize();
 
}

@Override
public void paintComponent(Graphics g) {

    super.paintComponent(g);
    setSurfaceSize();
    doDrawing(g);
   
    System.out.println(" Meeeh");

}

}