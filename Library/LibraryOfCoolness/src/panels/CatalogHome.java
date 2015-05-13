package panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



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
  
  private JFrame mainFrame;
  
	public CatalogHome(){
		prepareGUI();
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
	      controlPanel.setLayout(new FlowLayout());

	      mainFrame.add(headerLabel);
	      mainFrame.add(controlPanel);
	      mainFrame.add(statusLabel);
	      mainFrame.add(user);
	      mainFrame.add(password);
	      mainFrame.setVisible(true);  
	   }

	public void textfieldLayout(){
		headerLabel.setText("Looking for something? Search it!");
		
		JPanel daPanel = new JPanel();
		daPanel.setBackground(Color.pink);
		daPanel.setSize(SWidth, SHeight);
		BorderLayout homeScreen = new BorderLayout();
		homeScreen.setHgap(10);
		homeScreen.setVgap(10);
		daPanel.setLayout(homeScreen);
		
		
		JLabel searchBar = new JLabel("", JLabel.CENTER);
		searchBar.setLayout(null);
		searchBar.setLocation(400, 500);
		final JTextField searchContent = new JTextField(50);
		daPanel.add(search, BorderLayout.CENTER);
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				String data= "You searched \"" + searchContent.getText() + "\"";
				statusLabel.setText(data);
			}
		});
		
		JLabel username = new JLabel("Username:", JLabel.LEFT);
		final JTextField usernameInput = new JTextField(10);
		username.setLocation(200, 600);
		JLabel passcode = new JLabel("Password:", JLabel.LEFT);
		final JTextField passwordInput = new JPasswordField(10);
		
		daPanel.add(username);
		daPanel.add(usernameInput);
		daPanel.add(passcode);
		daPanel.add(passwordInput);
		
		daPanel.add(login, BorderLayout.NORTH);
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String loginInfo = usernameInput.getText() + "!!! Hey, hey, " + usernameInput.getText() + "!!!";
				user.setText(loginInfo);
			}
		});
		
		
		//search.setBounds(400, 500, 200, 20);
		
		
		
		
		
		
		
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
		
	
	public static boolean useList(String[] popular, String searchContent){
		return Arrays.asList(popular).contains(searchContent);
	} 
	
}
