package panels;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
import Library.Library; 


@SuppressWarnings("serial")
public class CatalogHome extends JPanel {
 
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JLabel user;
	private JLabel password;
	private JPanel searchBarPlace;
	private JPanel theLogin;
	
	JButton search = new JButton("Search");
	JButton login = new JButton("LOGIN");
	
	Toolkit tk = Toolkit.getDefaultToolkit();
    int SWidth = ((int) tk.getScreenSize().getWidth());
    int SHeight = ((int) tk.getScreenSize().getHeight());
  
   Graphics g;
    GridBagConstraints gbc = new GridBagConstraints();
		
   // static Book[] books = new Book[Arrays.fiction.length];
    
  private JFrame mainFrame;
  
	public CatalogHome(){
		//paint(g);
		prepareGUI();
		
	}
	
	
	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
	      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	      RenderingHints.VALUE_ANTIALIAS_ON);
	      Font arial = new Font("Arial", Font.PLAIN, 96);
	      Font TimesNewRoman = new Font("TimesNewRoman", Font.PLAIN, 100);
	      g2.setFont(arial);
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
		mainFrame = new JFrame("Library of Coolness");
	       mainFrame.setBackground(Color.red);
	       Toolkit tk = Toolkit.getDefaultToolkit();
	      int SWidth = ((int) tk.getScreenSize().getWidth());
	      int SHeight = ((int) tk.getScreenSize().getHeight());
	      mainFrame.setSize(SWidth, SHeight);
	      mainFrame.setLayout(new GridLayout(4, 8));
	     
	      mainFrame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	            System.exit(0);
	         }        
	      });    
	      headerLabel = new JLabel("");        
	      statusLabel = new JLabel("");   
	      user = new JLabel();
	      password = new JLabel("");

	    
	      searchBarPlace = new JPanel();
	      /////MAKAELA/////
	      searchBarPlace.setBackground(Color.green);
	      searchBarPlace.setForeground(Color.red);
	      /////MAKAELA/////
	      gbc.fill = GridBagConstraints.WEST;
	      theLogin = new JPanel();
	      
	      
	      //theLogin.setLayout(new GridLayout(2, 8));
	      //controlPanel.setLayout(new GridLayout(10, 10));

	      //mainFrame.add(headerLabel); 
	      
	      
	      mainFrame.add(theLogin);
	      mainFrame.add(searchBarPlace);
	      mainFrame.add(user);
	      mainFrame.add(statusLabel); 
	      mainFrame.add(password);
	      
	      mainFrame.setVisible(true);  
	   }

	public void textfieldLayout(){
		//headerLabel.setText("Looking for something? Search it!");
		
		
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
		Font searchFont = new Font("Serif", Font.BOLD, 15);
		search.setFont(searchFont);
		search.setBackground(Color.red);
		search.setForeground(Color.white);
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
		Font wordUsername = new Font("TimesNewRoman", Font.BOLD, 15);
		username.setFont(wordUsername);
		username.setForeground(Color.black);
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
		Font wordPassword = new Font("TimesNewRoman", Font.BOLD, 15);
		passcode.setFont(wordPassword);
		passcode.setForeground(Color.black);
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
		Font logButtonFont = new Font("Serif", Font.BOLD, 15);
		login.setFont(logButtonFont);
		login.setForeground(Color.gray);
		login.setBackground(Color.cyan);
		/////MAKAELA/////
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//theLogin.removeNotify();
				String loginInfo = "Hey, " + usernameInput.getText();
				user.setText(loginInfo);
			}
		});
		
	
		//controlPanel.add(daPanel);
		mainFrame.setVisible(true);
		
		
	}
	
}
