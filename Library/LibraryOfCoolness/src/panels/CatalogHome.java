package panels;

import java.awt.BorderLayout;
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
  
  private JFrame mainFrame;
  
	public CatalogHome(){
		//initial();
		prepareGUI();
	}
	
	public static void main(String[] args){
		CatalogHome swingControlDemo = new CatalogHome();
		swingControlDemo.showTextFieldDemo();
	}
	
	private void prepareGUI(){
	      mainFrame = new JFrame("Library of Coolness");
	      Toolkit tk = Toolkit.getDefaultToolkit();
	      int SWidth = ((int) tk.getScreenSize().getWidth());
	      int SHeight = ((int) tk.getScreenSize().getHeight());
	      mainFrame.setSize(SWidth, SHeight);
	      mainFrame.setLayout(new GridLayout(3, 1));
	      mainFrame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	            System.exit(0);
	         }        
	      });    
	      headerLabel = new JLabel("", JLabel.CENTER);        
	      statusLabel = new JLabel("",JLabel.CENTER);   
	      user = new JLabel("", JLabel.LEFT);
	      password = new JLabel("", JLabel.LEFT);

	      statusLabel.setSize(350,100);
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

	public void showTextFieldDemo(){
		headerLabel.setText("Looking for something? Search it!");
		
		
		JLabel searchBar = new JLabel("", JLabel.CENTER);
		searchBar.setLayout(null);
		searchBar.setBounds(400, 500, 200, 20);
		final JTextField searchContent = new JTextField(50);
		
		
		JButton search = new JButton("Search");
		//search.setBounds(400, 500, 200, 20);
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				String data= "You searched \"" + searchContent.getText() + "\"";
				statusLabel.setText(data);
			}
		});
		
		
		JLabel username = new JLabel("Username:", JLabel.LEFT);
		final JTextField usernameInput = new JTextField(10);
		JLabel passcode = new JLabel("Password:", JLabel.LEFT);
		final JTextField passwordInput = new JPasswordField(10);
		
		JButton login = new JButton("LOGIN");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String loginInfo = usernameInput.getText() + "!!! Hey, hey, " + usernameInput.getText() + "!!!";
				user.setText(loginInfo);
			}
		});
		
		
		
		controlPanel.add(searchBar);
		controlPanel.add(searchContent);
		controlPanel.add(search);
	
		controlPanel.add(username);
		controlPanel.add(usernameInput);
		controlPanel.add(passcode);
		controlPanel.add(passwordInput);
		controlPanel.add(login);
		mainFrame.setVisible(true);
		
		
	}
			
	
	public static boolean useList(String[] popular, String searchContent){
		return Arrays.asList(popular).contains(searchContent);
	} 
	
	/*public static void initial(){
		System.out.println("Testing");
	 final JTextField search = new JTextField();
	search.setLayout(new BorderLayout());
		JLabel label = new JLabel("Howdy");
	label.setCursor(Cursor.getDefaultCursor());
	search.add(label, BorderLayout.LINE_END);
	label.addMouseListener(new MouseAdapter(){
		@Override
		public void mouseClicked(MouseEvent e){
			search.setText("");
		}
	});
	}*/
}
