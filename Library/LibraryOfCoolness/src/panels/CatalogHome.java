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
import java.util.Arrays;

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
	private JPanel controlPanel;
	
	JButton search = new JButton("Search");
	JButton login = new JButton("LOGIN");
	
	Toolkit tk = Toolkit.getDefaultToolkit();
    int SWidth = ((int) tk.getScreenSize().getWidth());
    int SHeight = ((int) tk.getScreenSize().getHeight());
  
    Graphics g;
    
   // static Book[] books = new Book[Arrays.fiction.length];
    
  private JFrame mainFrame;
  
	public CatalogHome(){
		paint(g);
		prepareGUI();
		
	}
	
	
	public void paint(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		 g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		Font fong = new Font("Serif", Font.PLAIN, 96);
		g2d.setFont(fong);
		g2d.drawString("Text", 300,  700);
		
		for (int i = 0; i < Library.books.length-1; i++ )
		{
			System.out.println(books[i].getTitle() + ", by " + books[i].getAuthor());
		}
	}

	public static void main(String[] args){
		CatalogHome swingControlDemo = new CatalogHome();
		swingControlDemo.textfieldLayout();
	}
	
	private void prepareGUI(){
	      mainFrame = new JFrame("Library of Coolness");
	      Toolkit tk = Toolkit.getDefaultToolkit();
	      int SWidth = ((int) tk.getScreenSize().getWidth());
	      int SHeight = ((int) tk.getScreenSize().getHeight());
	      mainFrame.setSize(SWidth, SHeight);
	      mainFrame.setLayout(new GridLayout(5, 1));
	      mainFrame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	            System.exit(0);
	         }        
	      });    
	      headerLabel = new JLabel("", JLabel.CENTER);        
	      statusLabel = new JLabel("",JLabel.CENTER);   
	      user = new JLabel();
	      user.setLayout(null);
	      user.setLocation(200, 600);
	      password = new JLabel("", JLabel.LEFT);

	     // statusLabel.setSize(350,100);
	      //user.setSize(550, 100);
	      
	      controlPanel = new JPanel();
	      controlPanel.setBackground(Color.green);
	      controlPanel.setLayout(new FlowLayout());

	      mainFrame.add(headerLabel);
	      mainFrame.add(controlPanel);
	      mainFrame.add(statusLabel);
	      mainFrame.add(user);
	      mainFrame.add(password);
	      mainFrame.setVisible(true);  
	   }

	public void textfieldLayout(){
		//headerLabel.setText("Looking for something? Search it!");
		
		JPanel daPanel = new JPanel();
		daPanel.setBackground(Color.green);
		daPanel.setSize(900, 900);
		GridBagLayout homeScreen = new GridBagLayout();
		
		daPanel.setLayout(homeScreen);
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.fill = GridBagConstraints.NORTH;
		gbc.gridwidth = 8;
		gbc.gridx = 0;
		gbc.gridy =5;
		
		
		JLabel searchBar = new JLabel("", JLabel.CENTER);
		daPanel.add(searchBar, gbc);
		
		final JTextField searchContent = new JTextField(50);
		daPanel.add(searchContent);
		
		
		gbc.gridx = 1;
		gbc.gridy = 5;
		daPanel.add(search, gbc);
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				String data= "You searched \"" + searchContent.getText() + "\"";
				statusLabel.setText(data);
			}
		});
		
		JLabel username = new JLabel("Username:");
		gbc.fill = GridBagConstraints.BELOW_BASELINE_TRAILING;
		gbc.gridx = 1;
		gbc.gridy = 0;
		daPanel.add(username, gbc);
		
		final JTextField usernameInput = new JTextField(10);
		gbc.gridx = 2;
		gbc.gridy = 0;
		daPanel.add(usernameInput, gbc);
		
		
		JLabel passcode = new JLabel("Password:", JLabel.LEFT);
		gbc.gridx = 3;
		gbc.gridy = 0;
		daPanel.add(passcode, gbc);
		
		final JTextField passwordInput = new JPasswordField(10);
		gbc.gridx = 4;
		gbc.gridy = 0;
		daPanel.add(passwordInput, gbc);
		
		gbc.gridx= 2;
		gbc.gridy = 1;
		daPanel.add(login, gbc);
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String loginInfo = usernameInput.getText() + "!!! Hey, hey, " + usernameInput.getText() + "!!";
				user.setText(loginInfo);
			}
		});
		
	
		
		
		/*controlPanel.add(searchBar);
		controlPanel.add(searchContent);
		controlPanel.add(search);
	
		controlPanel.add(username);
		controlPanel.add(usernameInput);
		controlPanel.add(passcode);
		controlPanel.add(passwordInput);
		controlPanel.add(login);
		*/
		controlPanel.add(daPanel);
		mainFrame.setVisible(true);
		
		
	}
	
	/*public void paintComponent(Graphics g){
		Graphics2D recent = (Graphics2D) g;
		recent.setPaint(Color.black);
		recent.drawString(myMessage, 100, 600);
	}
	*/
	
	
	
	/*public static boolean useList(String[] popular, String searchContent){
		return Arrays.asList(popular).contains(searchContent);
	} */
	
}
