package panels;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
 
	private JLabel headerLabel;
  private JPanel controlPanel;
  private JLabel statusLabel;
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
	      mainFrame.setSize(400,400);
	      mainFrame.setLayout(new GridLayout(3, 1));
	      mainFrame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	            System.exit(0);
	         }        
	      });    
	      headerLabel = new JLabel("", JLabel.CENTER);        
	      statusLabel = new JLabel("",JLabel.CENTER);    

	      statusLabel.setSize(350,100);

	      controlPanel = new JPanel();
	      controlPanel.setLayout(new FlowLayout());

	      mainFrame.add(headerLabel);
	      mainFrame.add(controlPanel);
	      mainFrame.add(statusLabel);
	      mainFrame.setVisible(true);  
	   }

	private void showTextFieldDemo(){
		headerLabel.setText("Looking for something? Search it!");
		
		
		JLabel searchBar = new JLabel("", JLabel.CENTER);
		final JTextField searchContent = new JTextField(20);
		
		JButton search = new JButton("Search");
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				String data= "You searched \"" + searchContent.getText() + "\"";
				statusLabel.setText(data);
			}
		});
		
		
		controlPanel.add(searchBar);
		controlPanel.add(searchContent);
		controlPanel.add(search);
		mainFrame.setVisible(true);
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
