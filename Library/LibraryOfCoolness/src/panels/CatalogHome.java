
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

@SuppressWarnings("serial")
public class CatalogHome extends JPanel {
 
 
 private JLabel statusLabel;
 private JLabel user;
 private JLabel password;
 private JLabel newThings;
 
 private JPanel searchBarPlace;
 private JPanel theLogin;
 private JPanel recentlyAdded;
 
 
 JButton search = new JButton("Search");
 JButton login = new JButton("Login");
 
 Toolkit tk = Toolkit.getDefaultToolkit();
	int SWidth = ((int) tk.getScreenSize().getWidth());
	int SHeight = ((int) tk.getScreenSize().getHeight());
 
   Graphics g;
	GridBagConstraints gbc = new GridBagConstraints();
  
   static Book[] books = new Book[InitArrays.fiction.length];
   
  	
  private JFrame mainFrame;
 
 public CatalogHome(){
  //paint(g);
  prepareGUI(); for (int i = 0; i < books.length-1; i++)
  {
	  books[i].setTitle(InitArrays.fiction[i]);
	 // books[i].setAuthor(InitArrays.fictionAuthors[i]);
	   
  }

 // System.out.println(books);
 }
 
 
 public void paint(Graphics g){
  Graphics2D g2 = (Graphics2D)g;
   	g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
   	RenderingHints.VALUE_ANTIALIAS_ON);
   	Font firstFont = new Font("old english mt", Font.PLAIN, 96);
   	g2.setFont(firstFont);
   	g2.drawString("Text", 40, 120);
  
  /*for (int i = 0; i < Library.books.length-1; i++ )
  {
   System.out.println(books[i].getTitle() + ", by " + books[i].getAuthor());
  }*/
   	
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
   	user = new JLabel();
   	password = new JLabel("");
   	newThings = new JLabel();
   	
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
   	mainFrame.add(user);
   	mainFrame.add(statusLabel);
   	mainFrame.add(password);
   	mainFrame.setVisible(true); 
	}
 
 public void textfieldLayout(){
  
  gbc.fill = GridBagConstraints.CENTER;
  //gbc.gridwidth = 8;
  //gbc.gridheight = 10;
  
  gbc.gridx = 4;
  gbc.gridy = 4;
  
  JLabel searchBar = new JLabel("", JLabel.CENTER);
  searchBarPlace.add(searchBar, gbc);
  
  final JTextField searchContent = new JTextField(50);
  searchBarPlace.add(searchContent);
  
  gbc.fill = GridBagConstraints.HORIZONTAL;
  gbc.gridx = 1;
  gbc.gridy = 5;
  searchBarPlace.add(search, gbc);
  gbc.fill = GridBagConstraints.CENTER;
  gbc.gridx = 2;
  searchBarPlace.add(statusLabel, gbc);
  /////MAKAELA/////
  Font searchFont = new Font("old english text mt", Font.BOLD, 17);
  search.setFont(searchFont);
  search.setBackground(Color.white);
  /////MAKAELA/////
  search.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e){
    String data= "You searched \"" + searchContent.getText() + "\"";
    
    statusLabel.setText(data);
    
    //data.setFont(dataFont);
   }
  });
 
  gbc.gridx = 4;
  gbc.gridy = 0;
  JLabel username = new JLabel("Username:");
  /////MAKAELA/////
  Font wordUsername = new Font("old english text mt", Font.BOLD, 15);
  username.setFont(wordUsername);;
  /////MAKAELA/////
  gbc.fill = GridBagConstraints.BELOW_BASELINE_TRAILING;
  theLogin.add(username, gbc);
  
  gbc.gridx = 5;
  gbc.gridy = 0;
  final JTextField usernameInput = new JTextField(10);
  theLogin.add(usernameInput, gbc);
  
  gbc.gridx = 6;
  gbc.gridy = 0;
  /////MAKAELA/////
  JLabel passcode = new JLabel("Password:", JLabel.LEFT);
  Font wordPassword = new Font("old english text mt", Font.BOLD, 15);
  passcode.setFont(wordPassword);
  /////MAKAELA/////
  theLogin.add(passcode, gbc);
  
  final JTextField passwordInput = new JPasswordField(10);
  gbc.gridx = 7;
  gbc.gridy = 0;
  theLogin.add(passwordInput, gbc);
  
  gbc.gridx= 6;
  gbc.gridy = 2;
  theLogin.add(login, gbc);
  gbc.fill = GridBagConstraints.CENTER;
  theLogin.add(user, gbc);
  /////MAKAELA////
  Font logButtonFont = new Font("old english text mt", Font.BOLD, 15);
  login.setFont(logButtonFont);
  /////MAKAELA/////
  login.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    //theLogin.removeNotify();
    String loginInfo = usernameInput.getText() + "!!! Hey, hey, " + usernameInput.getText() + "!! Hi!!!";
    user.setText(loginInfo);
   }
  });
  
  
 recentlyAdded.add(newThings);
  //controlPanel.add(daPanel);
  mainFrame.setVisible(true);
  
  
 }
 
}