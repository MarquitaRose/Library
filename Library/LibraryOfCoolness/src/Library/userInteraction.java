package Library;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
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

import panels.CatalogHome;
import panels.JFrameDesign;



@SuppressWarnings("serial")
public class userInteraction extends JFrame{
	static int maxCustomers = 100;
	static int maxBooks = 100;
	static int lastBook = 0;
	static Customer[] customers = new Customer[maxCustomers];
    static Book[] books = new Book[maxBooks];
    static int answer = 0;
    
    Toolkit tk = Toolkit.getDefaultToolkit();
   	int SWidth = ((int) tk.getScreenSize().getWidth());
   	int SHeight = ((int) tk.getScreenSize().getHeight());
   	
   	private JFrame ofAwesomness;
   	private JPanel withUser;
   	private JPanel theButtons;
   	private JButton itemCheckIn;
   	private JButton itemCheckOut;
   	private JButton addItem;
   	private static JLabel bookSearch;
    
	//Create a scanner object each for text and numbers
	private static Scanner tInput = new Scanner(System.in);
	private static Scanner nInput = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			/////Creates JFrame use/////
		         	public void run() {
		             	userInteraction use = new userInteraction();
		             	//use.setVisible(true);
		         	}
		     	});*/
		
		  userInteraction mm = new userInteraction();
		 mm.menu();

		
		//Initialize Books
		
		for (int i = 0; i < books.length; i++)
			books[i] = new Book();
		
		//Add the books
		addBooks();
		
		//Menu
		//menu();

		
		
	}
	
	public userInteraction(){
		preparingJPanel();
	}
	
public void preparingJPanel(){
	 ofAwesomness = new JFrame();
	 ofAwesomness.setLayout(new GridLayout(4, 8));
	ofAwesomness.setSize(SWidth, SHeight);
	ofAwesomness.addWindowListener(new WindowAdapter() {
      	public void windowClosing(WindowEvent windowEvent){
         	System.exit(0);
      	}    	
   	});	
	
	theButtons = new JPanel();
	
	withUser = new JPanel();
	withUser.setBackground(Color.green);
	
	
	ofAwesomness.add(theButtons);
	ofAwesomness.add(withUser); 
	ofAwesomness.setVisible(true);
}

public void menu(){
	
		itemCheckIn = new JButton("Item check in");
		itemCheckIn.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e){
			 checkout();
			   }
			  });
		
		itemCheckOut = new JButton("Item check out");
		itemCheckOut.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e){
			    checkin();
			   }
			  });
		
		addItem = new JButton("Donate!");
		addItem.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e){
			 addBooks();
			   }
			  });
		
		theButtons.add(itemCheckIn);
		theButtons.add(itemCheckOut);
		theButtons.add(addItem);
}

	public static int findBook()
	{
		bookSearch = new JLabel("");
		int i;
		System.out.println("Which book");
		String t = tInput.nextLine();
		System.out.println(lastBook);
		for (i = 0; i < lastBook; i++)
		{
			if (books[i].getTitle().toLowerCase().equals(t.toLowerCase()))
				return 1;
			System.out.println(i);
		}
		return 0;
	}
	
	
	public void checkout()
	{
		int bookI = findBook();
		if (bookI!=0)
		{
			books[bookI].checkOut(1);
			System.out.println(books[bookI].getTitle() + " is now checked out");
		}
		else
			System.out.println("The book wasn't found.");
			
		
	}
	
	private static void checkin()
	{
		
		
	}
	
	/*public void JPanelAddBooks(){
		JLabel enterBooks = new JLabel("How many books do you want to enter?");
		Font enterBooksFont = new Font ("Serif", Font.PLAIN, 30);
		enterBooks.setFont(enterBooksFont);
		withUser.add(enterBooks);
	}*/
	
	public static void addBooks()
	{
		
		
		int numBooks = nInput.nextInt();
		
		int b = 0;
		
		for (b = 0; b < books.length && !books[b].getTitle().equals(""); b++)
		{
			
		}
		lastBook = b;
		System.out.println(lastBook);
		
		for (int i = lastBook; i < numBooks+lastBook && i < maxBooks; i++ )
		{
			System.out.println("Enter a book name");
			books[i].setTitle(tInput.nextLine());
			System.out.println("the Author?");
			books[i].setAuthor(tInput.nextLine());
			
		}
		lastBook = b+numBooks;

	}
	
	private static void displayBooks()
	{
		for (int i = 0; i < lastBook; i++ )
		{
			System.out.println(books[i].getTitle() + ", by " + books[i].getAuthor() + " " + books[i].getCheckedOut());
		}
		

	}

}
