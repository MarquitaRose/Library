package Library;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;




@SuppressWarnings("serial")
public class userInteraction extends JFrame{
	static int maxCustomers = 100;
	static int lastCustomer = 0;
	
	static int maxBooks = 100;
	static int lastBook = 0;
	static Customer[] customers = new Customer[maxCustomers];
    static int answer = 0;
   
    private static Scanner tInput = new Scanner(System.in);
	private static Scanner nInput = new Scanner(System.in);
	
	
    Toolkit tk = Toolkit.getDefaultToolkit();
   	int SWidth = ((int) tk.getScreenSize().getWidth());
   	int SHeight = ((int) tk.getScreenSize().getHeight());
   	
   	private JFrame ofAwesomness;
   	private JPanel withUser;
   	private JPanel theButtons;
   	private JPanel buttonFunctions;
   	private JPanel donate;
   	private JButton itemCheckIn;
   	private JButton itemCheckOut;
   	private JButton donateButton;
   	private JButton search;
   	private JButton newSearch;
   	private JLabel alreadyHere;
   	private JLabel checkOutNow;
   	private JLabel checkInNow;
   	private JLabel statusLabel;
   	JTextField searchContent;
   	boolean checkOut = false;
   	
   	public static String[] fiction = new String[]{
        "The Fault in our Stars", "Speak", "Wintergirls", "The Impossible Knife of Memory", 
        "Fangirl", "Eleanor and Park", "Looking for Alaska", "An Abundance of Katherines", "Paper Towns",
};
   	
	
	public static void main(String[] args) {
		/////Adds JPanel mm\\\\\
		userInteraction mm = new userInteraction();
		mm.JPanelAddBooks();
	}
	
	public userInteraction(){
		preparingJPanel();
		searchBar();
		addCustomer();
	}
	
public void preparingJPanel(){
	/////Creates new JFrame and adjusts its size and layout\\\\\
	//for (int i = 0; i < fiction.length-1; i++ )
	  //{
	   //System.out.println(fiction[i]);
	  //} 
	
	ofAwesomness = new JFrame();
	 ofAwesomness.setLayout(new GridLayout(4, 8));
	ofAwesomness.setSize(SWidth, SHeight);
	ofAwesomness.addWindowListener(new WindowAdapter() {
      	public void windowClosing(WindowEvent windowEvent){
         	System.exit(0);
      	}    	
   	});	
	
	/////Creates and adds new JPanels\\\\\
	theButtons = new JPanel();
	
	withUser = new JPanel();
	withUser.setBackground(Color.green);
	
	buttonFunctions = new JPanel();
	
	donate = new JPanel();
	
	
	ofAwesomness.add(theButtons);
	ofAwesomness.add(withUser); 
	ofAwesomness.add(buttonFunctions);
	ofAwesomness.add(donate);
	ofAwesomness.setVisible(true);

}

	public void searchBar(){
		  /////Creates and adds textfield where user's search is entered\\\\\
		  searchContent = new JTextField(50);
		  withUser.add(searchContent);
		  search = new JButton("Search");
		  withUser.add(search);
		  
		  /////Adds JLabel that search will be stored into\\\\\
		  statusLabel = new JLabel("");
		  withUser.add(statusLabel);
		 
		  /////Sets font and background for search button\\\\\
		  Font searchFont = new Font("old english text mt", Font.BOLD, 17);
		  withUser.setFont(searchFont);
		  
		  /////Adds search button and sets what will happen when the button
		                    ///// is clicked\\\\\
		  search.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent e){
		    String data= "You searched \"" + searchContent.getText() + "\"";
		    statusLabel.setText(data);
		    
		    /////adds check in button and decides it's function\\\\\
		    itemCheckIn = new JButton("Check in");
			itemCheckIn.addActionListener(new ActionListener() {
				   public void actionPerformed(ActionEvent e){
					   checkin();
				   }
				  });
			
			withUser.add(itemCheckIn, JPanel.CENTER_ALIGNMENT);
			
			/////adds check out button and decides it's function\\\\\
			itemCheckOut = new JButton("Check out");
			itemCheckOut.addActionListener(new ActionListener() {
				   public void actionPerformed(ActionEvent e){
					  checkout();
				   }
				  });
			

			withUser.add(itemCheckOut);
		   }
		  });
		 
		  ofAwesomness.setVisible(true);
		  
		  findBook();
	}
	
	private static void addCustomer()
	{
		int numCusts = nInput.nextInt();
		
		int c = 0;
		
		for (c = 0; c < customers.length && !customers[c].getFName().equals(""); c++)
		{
			
		}
		lastBook = c;
		System.out.println(lastBook);
		
		for (int i = lastCustomer; i < numCusts+lastCustomer && i < maxCustomers; i++ )
		{
			System.out.println("Enter the First name");
			customers[i].setFName(tInput.nextLine());
			System.out.println("the Last Name?");
			customers[i].setLName(tInput.nextLine());
			System.out.println("ID?");
			customers[i].setID((long)Math.random()*9999);
			
		}
		lastBook = c+numCusts;

	
	
	} 
	
	public int findBook()
	{
		/////creates and adds JLabel where the user will input the book\\\\\
		int i;
		String adios = searchContent.getText();	
		
		for ( i = 0; i < fiction.length-1; i++ )
		  {
		   System.out.println(fiction[i].equalsIgnoreCase(adios));
		  }
	
		return 0;
	}
	
	public void checkin()
	{
		/////removes the named buttons when this method is called\\\\\
		withUser.remove(itemCheckOut);
		withUser.remove(itemCheckIn);
		
	/////removes the search bar and it's button\\\\\
			withUser.remove(searchContent);
			withUser.remove(search);
			withUser.remove(statusLabel);
			
		///// adds new button that will return the user to the page he/she was on before 
				///// checking out a book\\\\\
		final JButton newSearch = new JButton("Back");
		withUser.add(newSearch);
		newSearch.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e){
				  searchBar();
				  withUser.remove(newSearch);
			   }
			  });
		/////If the book is checked out, it is now no longer checked out\\\\\
		if (checkOut)
		{
			checkOut = false;
		}
		/////if the book isn't checked out, the user will receive a message\\\\\
		else
			{
			alreadyHere = new JLabel("This book is already checked in.");
			withUser.add(alreadyHere);
		}
		ofAwesomness.setVisible(true);
	}
	
	public void checkout()
	{
		/////removes the two named buttons when this method is called\\\\\
		withUser.remove(itemCheckOut);
		withUser.remove(itemCheckIn);
		
		/////removes the search bar and it's button\\\\\
		withUser.remove(searchContent);
		withUser.remove(search);
		withUser.remove(statusLabel);
		
		/////Adds button that will return the user to the page he or she was at before checking out
									///// the book\\\\\
		final JButton newSearch = new JButton("Back");
		withUser.add(newSearch);
		newSearch.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e){
				  searchBar();
				  withUser.remove(newSearch);
			   }
			  });
		
		/////if the book is not checked out, the user will be allowed to check it out\\\\\
		if (checkOut == false){
			String titleSearched = searchContent.getText() + " is now checked out";
			checkOutNow = new JLabel(titleSearched);
			withUser.add(checkOutNow);
			checkOut = true;
		}
		
		///// otherwise, if the book is checked out, the user will get a message saying that 
		////// the book is checked out and to try checking it out at another time later\\\\\
		else{
			checkInNow = new JLabel(searchContent.getText() + " has already been checked out. Check again later :)");
			withUser.add(checkInNow);
		}
		ofAwesomness.setVisible(true);
	}
	
	public void JPanelAddBooks(){
		/////Creates & adds donate button and decides it's function\\\\
		donateButton = new JButton("Donate!");
		buttonFunctions.add(donateButton);
		donateButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				donateQuestion();
			}
				}); 
		
	}
		public void donateQuestion(){
		/////donate button removed from the JPanel\\\\\
		buttonFunctions.remove(donateButton);
		/////creates and adds JLabels and inputs for author and book name based on the input of the user\\\\\
		JLabel booksName = new JLabel("Book's name:");
		final JTextField itemInput = new JTextField(10);
		buttonFunctions.add(booksName);
		buttonFunctions.add(itemInput);
		
		JLabel authorsName = new JLabel("Author's name");
		final JTextField itemAuthorInput = new JTextField(10);
		buttonFunctions.add(authorsName);
		buttonFunctions.add(itemAuthorInput);
	
		/////creates and adds the enter button and determines it's function\\\\\
	JButton enter = new JButton("Enter");
	buttonFunctions.add(enter);
	enter.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			/////program re-draws everything written in class userInteraction\\\\\
			userInteraction mm = new userInteraction();
			mm.JPanelAddBooks();
		
			/////stores inputs\\\\\
		String newBook = itemInput.getText();
		String booksAuthor = itemAuthorInput.getText();
		System.out.println(newBook + " by " +booksAuthor);
		}
	});
	
	ofAwesomness.setVisible(true);	
	}
}
