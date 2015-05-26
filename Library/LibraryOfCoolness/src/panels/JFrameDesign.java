
package panels;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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
	/////Creates JFrame ex/////
         	public void run() {
             	JFrameDesign ex = new JFrameDesign();
             	ex.setVisible(true);
         	}
     	});
 }
 
 private void initUI(){
  /////Creates new JPanel\\\\\
  DrawStuff panel = new DrawStuff();
  //panel.setBackground(Color.blue);
  add(panel);
  pack();
  panel.setVisible(true);
  panel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
  
  setTitle("Library of Coolness");
 	setSize(SWidth, SHeight);
 	panel.setBackground(Color.white);
 	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 	setLocationRelativeTo(null);
 	
 	
  /////Creates button and designs the button and it's font\\\\\
  JButton welcome = new JButton("Go to Catalog");
	welcome.setBounds(((SWidth / 2)- 200), 600, 400, 50);
	Font welcomeButton = new Font("old english text mt", Font.BOLD, 30);
	welcome.setFont(welcomeButton);
	panel.add(welcome);

 
	
	/////Opens JFrame homie (which contains everything from the class CatalogHome) when button is clicked\\\\\
  welcome.addActionListener(new ActionListener(){
   @Override
   public void actionPerformed(ActionEvent event){
   /////adds the code in class CatalogHome when the welcome button is pressed\\\\\
	CatalogHome homie = new CatalogHome();
    homie.textfieldLayout();
    add(homie);
    homie.setVisible(true);
   }
  });
  
 }
 
}
 
@SuppressWarnings("serial")
class DrawStuff extends JPanel{
private ImageIcon welcome;
private JLabel welcomeIm;


DrawStuff(){
	/////sets the layout and adds the welcome gif\\\\\
	setLayout(new FlowLayout());
	welcome = new ImageIcon(getClass().getResource("Welcome.gif"));
	welcomeIm = new JLabel(welcome);
	add(welcomeIm);
}
}
