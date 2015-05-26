
package panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Library.Book;
//import Library.InitArrays;
import Library.Library;
import Library.userInteraction;

@SuppressWarnings("serial")
public class CatalogHome extends JPanel {
 
 
 private JLabel statusLabel;
 private JLabel password;
 
 public static JPanel searchBarPlace;
 private JPanel theLogin;
 private JPanel recentlyAdded;
 
 
 JButton search = new JButton("Search");
 JButton login = new JButton("Login");
 
 Toolkit tk = Toolkit.getDefaultToolkit();
	int SWidth = ((int) tk.getScreenSize().getWidth());
	int SHeight = ((int) tk.getScreenSize().getHeight());
 
   Graphics g;
	GridBagConstraints gbc = new GridBagConstraints();
  
   static Book[] books = new Book[Book.fiction.length];
   
  	
  private JFrame mainFrame;
 
 public CatalogHome(){
  //paint(g);
  prepareGUI(); 
 }
 
 
 public void paint(Graphics g){
  Graphics2D g2 = (Graphics2D)g;
   	g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
   	RenderingHints.VALUE_ANTIALIAS_ON);
   	Font firstFont = new Font("old english mt", Font.PLAIN, 96);
   	g2.setFont(firstFont);
   	g2.drawString("Text", 40, 120);
 }
 

 
 public static void main(String[] args){
  CatalogHome swingControlDemo = new CatalogHome();
  swingControlDemo.textfieldLayout(); 
 }
 
 private void prepareGUI(){
	 
  /////Creates a new JFrame\\\\\
   	mainFrame = new JFrame("Library of Coolness");
   	mainFrame.setSize(SWidth, SHeight);
   	mainFrame.setBackground(Color.magenta);
   	mainFrame.setLayout(new GridLayout(4, 8));
  	
   	mainFrame.addWindowListener(new WindowAdapter() {
      	public void windowClosing(WindowEvent windowEvent){
         	System.exit(0);
      	}    	
   	});	
  
   	/////Adds new JLabels\\\\\
   	statusLabel = new JLabel("");  
   	password = new JLabel("");
  
   	
 	/////Adding and designing new JPanels\\\\\
   	searchBarPlace = new JPanel();
   searchBarPlace.setBackground(Color.green);
   	theLogin = new JPanel();
   	recentlyAdded = new JPanel();
   	recentlyAdded.setBackground(Color.cyan);
   	
   	
   	/////Adds the Labels and JPanels into the JFrame\\\\\
   	mainFrame.add(theLogin);
   	mainFrame.add(searchBarPlace);
   	mainFrame.add(recentlyAdded);
   	mainFrame.add(statusLabel);
   	mainFrame.add(password);
   	mainFrame.setVisible(true); 
	}

 
 public void textfieldLayout(){
	 /////Creates and adds search bar\\\\\
  JLabel searchBar = new JLabel("", JLabel.CENTER);
  searchBarPlace.add(searchBar);
  
  final JTextField searchContent = new JTextField(50);
  searchBarPlace.add(searchContent);
  searchBarPlace.add(search);
  
  searchBarPlace.add(statusLabel);
 
  /////Sets font and background for search button\\\\\
  Font searchFont = new Font("old english text mt", Font.BOLD, 17);
  search.setFont(searchFont);
  search.setBackground(Color.white);
  
  /////Adds search button and sets what will happen when the button
                    ///// is clicked\\\\\
  search.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e){
    String data= "You searched \"" + searchContent.getText() + "\"";
    statusLabel.setText(data);
   }
  });
 
  /////Creates and adds the text reading "username" and sets the font\\\\\
  JLabel username = new JLabel("Username:");
  Font wordUsername = new Font("old english text mt", Font.BOLD, 15);
  username.setFont(wordUsername);;
  theLogin.add(username);
  
 /////Adds text field where the username is written\\\\\
 final JTextField usernameInput = new JTextField(10);
  theLogin.add(usernameInput);
  
  /////Creates and adds the text reading "password" and sets the font\\\\\
  JLabel passcode = new JLabel("Password:", JLabel.LEFT);
  Font wordPassword = new Font("old english text mt", Font.BOLD, 15);
  passcode.setFont(wordPassword);
  theLogin.add(passcode);
  
  /////adds text field where the password is written\\\\\
  final JTextField passwordInput = new JPasswordField(10);
  theLogin.add(passwordInput);
  
 /////adds the login button and sets font\\\\\
  theLogin.add(login);
  //theLogin.add(user);
  
  Font logButtonFont = new Font("old english text mt", Font.BOLD, 15);
  login.setFont(logButtonFont);
  /////Sets the function of the login button/////
  login.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
   userInteraction mm = new userInteraction();
   mm.JPanelAddBooks();
   }
  });
  
  /////creates JLabel reading "recently added" and sets font\\\\\
  JLabel newThings = new JLabel("RECENTLY ADDED"); 
  Font recentJLabel = new Font("serif", Font.PLAIN, 30);
  newThings.setFont(recentJLabel);
 recentlyAdded.add(newThings);
  mainFrame.setVisible(true);
  
  
 }

}