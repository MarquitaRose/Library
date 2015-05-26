
package panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
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

@SuppressWarnings("serial")
public class CatalogHome extends JPanel {
 
 
 private JLabel statusLabel;
 public  JPanel searchBarPlace;
 private JPanel theLogin;
 private JPanel recentlyAdded;
 
 
 JButton search = new JButton("Search");
 JButton login = new JButton("Login");
 
 Toolkit tk = Toolkit.getDefaultToolkit();
	int SWidth = ((int) tk.getScreenSize().getWidth());
	int SHeight = ((int) tk.getScreenSize().getHeight());
  	
  private JFrame mainFrame;
 
 public CatalogHome(){
  prepareGUI(); 
 }
 
 public static void main(String[] args){
  CatalogHome swingControlDemo = new CatalogHome();
  swingControlDemo.textfieldLayout(); 
 }
 
 private void prepareGUI(){
  /////Creates a new JFrame, determines it's layout and size\\\\\
   	mainFrame = new JFrame("Library of Coolness");
   	mainFrame.setSize(SWidth, SHeight);
   	mainFrame.setLayout(new GridLayout(4, 8));
  	
   	mainFrame.addWindowListener(new WindowAdapter() {
      	public void windowClosing(WindowEvent windowEvent){
         	System.exit(0);
      	}    	
   	});	
  
   	
 	/////Adding and designing new JPanels\\\\\
   	searchBarPlace = new JPanel();
    searchBarPlace.setBackground(Color.green);
   	theLogin = new JPanel();
   	recentlyAdded = new JPanel();
   	recentlyAdded.setBackground(Color.white);
   	JPanel meh = new JPanel();
   	meh.setBackground(Color.white);
   	
   	
   	/////Adds the Labels and JPanels into the JFrame\\\\\
   	mainFrame.add(theLogin);
   	mainFrame.add(searchBarPlace);
   	mainFrame.add(recentlyAdded);
   	mainFrame.add(meh);
   	mainFrame.setVisible(true); 
	}

 
 public void textfieldLayout(){
	 /////Creates and adds search bar\\\\\
  final JTextField searchContent = new JTextField(50);
  searchBarPlace.add(searchContent);
  /////adds search button to jPanel\\\\\
  searchBarPlace.add(search);
  
  statusLabel = new JLabel("");
  searchBarPlace.add(statusLabel);
 
  /////Sets font for search button\\\\\
  Font searchFont = new Font("old english text mt", Font.BOLD, 17);
  search.setFont(searchFont);
  
  /////Adds search button and sets what will happen when the button
                    ///// is clicked\\\\\
  search.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e){
   /////adds this string ("you searched" plus user's input) into a JLabel which is added to JPanel\\\\\
	String data= "You searched \"" + searchContent.getText() + "\".";
    statusLabel.setText(data);
    
    //////adds JLabel telling the user to log in first\\\\\
    JLabel mustLogIn = new JLabel("You must log in to check out this book.");
    searchBarPlace.add(mustLogIn);
   }
  });
 
  /////Creates and adds the text reading "username" and sets the font\\\\\
  JLabel username = new JLabel("Username:");
  Font wordUsername = new Font("old english text mt", Font.BOLD, 15);
  username.setFont(wordUsername);
  theLogin.add(username);
  
 /////Adds text field where the user inputs the username\\\\\
 final JTextField usernameInput = new JTextField(10);
  theLogin.add(usernameInput);
  
  /////Creates and adds the text reading "password" and sets the font\\\\\
  JLabel passcode = new JLabel("Password:", JLabel.LEFT);
  Font wordPassword = new Font("old english text mt", Font.BOLD, 15);
  passcode.setFont(wordPassword);
  theLogin.add(passcode);
  
  /////adds text field where the user inputs the password\\\\\
  final JTextField passwordInput = new JPasswordField(10);
  theLogin.add(passwordInput);
  
 /////adds the login button and sets font\\\\\
  theLogin.add(login);
  Font logButtonFont = new Font("old english text mt", Font.BOLD, 15);
  login.setFont(logButtonFont);
  
  
  /////Sets the function of the login button/////
  login.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
   @SuppressWarnings("unused")
   userInteraction mm = new userInteraction();
   }
  });
 }

 }