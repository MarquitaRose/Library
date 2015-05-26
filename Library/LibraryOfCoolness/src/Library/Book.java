package Library;

public class Book implements Item{

	private String callNumber;
	private boolean checkedOut;
	private long custID;
	private String title;
	private String author;
	
	public static String[] fiction = new String[]{
        "The Fault in our Stars", "Speak", "Wintergirls", "The Impossible Knife of Memory", 
        "Fangirl", "Eleanor and Park", "Looking for Alaska", "An Abundance of Katherines", "Paper Towns",
};

String[] dystopian = new String[]{
        "Hunger Games", "Catching Fire", "Mockingjay", "Divergent", "Insurgent", "Allegiant",
        "City of Bones", "City of Ashes", "City of Glass", "City of Fallen Angels", "City of Lost Souls",
        "City of Heavenly Fire", "Clockwork Angel", "Clockwork Prince", "Clockwork Princess", "Maze Runner", 
        "Cinder", "Scarlet", "Cress"

};

String[] fantasy = new String[]{

        "Harry Potter and the Sorcerer's Stone", "Harry Potter and the Chamber of Secrets",
        "Harry Potter and the Prisoner of Azkaban", "Harry Potter and the Goblet of Fire", 
        "Harry Potter and the Order of the Pheonix", "Harry Potter and the Half-Blood Prince",
        "Harry Potter and the Deathly Hallows", "The Lost Hero", "The Son of Neptune", "The Mark of Athena", 
        "The House of Hades", "The Blood of Olympus", "The Lightning Thief", "The Sea of Monsters", 
        "Titan's Curse", "Battle of the Labriynth", "The Last Olympian", "The Hobbit", "The Fellowship of the Ring",
        "Two Towers", "Return of the King"

};

String [] fiction_authors = new String[]{
        "Jonh Green", "Laurie Halse Anderson", "Laurie Halse Anderson", "Laurie Halse Anderson", "Rainbow Rowell",
        "Rainbow Rowell", "John Green", "John Green", "John Green"
};

String [] dystopia_authors = new String[]{
        "Suzanne Collins", "Suzanne Collins", "Suzanne Collins", "Veronica Roth", "Veronica Roth", "Veronica Roth", 
        "Cassandra Clare", "Cassandra Clare", "Cassandra Clare", "Cassandra Clare", "Cassandra Clare", 
        "Cassandra Clare", "Cassandra Clare", "Cassandra Clare", "Cassandra Clare", "James Dashner", 
        "Marissa Meyer", "Marissa Meyer", "Marissa Meyer"

};
String [] fantasy_authors = new String[]{

        "J. K. Rowling", "J. K. Rowling", "J. K. Rowling", "J. K. Rowling", "J. K. Rowling", 
        "J. K. Rowling", "J. K. Rowling", "Rick Riordan", "Rick Riordan", "Rick Riordan", 
        "Rick Riordan", "Rick Riordan", "Rick Riordan", "Rick Riordan", "Rick Riordan", 
        "Rick Riordan", "Rick Riordan", "J. R. R. Tolkien", "J. R. R. Tolkien", "J. R. R. Tolkien",
        "J. R. R. Tolkien"
};

	
	public Book()
	{
		title = "";
		author = "";
		custID = 0;
		checkedOut = false;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String t)
	{
		title = t;
	}
	
	public String getAuthor()
	{
		return author;
	}
	
	public void setAuthor(String a)
	{
		author = a;
	}
	
	@Override
	public void setCallNumber(String callNum) {
		callNumber = callNum;
		
	}

	@Override
	public String getCallNumber() {
		return callNumber;
	}

	@Override
	public boolean checkOut(long customerID) {
		if (checkedOut)
		return false;
		
		setCheckedOut(true);
		setCustomerID(customerID);
		return true;
	}

	@Override
	public void setCheckedOut(boolean checked) {
		checkedOut = checked;
	}

	@Override
	public boolean getCheckedOut() {
		return checkedOut;
	}

	@Override
	public void setCustomerID(long customerID) {
		
		
	}

	@Override
	public long getCustomerID() {
		return custID;
	}
}
