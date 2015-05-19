package Library;



import java.util.Scanner;
import Library.Book;

public class Library {
	static int minCustomers = 100;
    static Book[] books = new Book[Arrays.popular.length];
	
	//Create a scanner object each for text and numbers
	
   
    
	public static void main(String[] args) {
		
		//Add the books
		addBooks();
		
		books[3].checkOut(21654987);
		
		for (int i = 0; i < books.length-1; i++ )
		{
			System.out.println(books[i].getTitle() + ", by " + books[i].getAuthor());
		}
		
		/*do 
		{
		System.out.println("What is the maximum amount of customers you expect?");
		} while (!(Integer.parseInt(tInput.nextLine())>=minCustomers));
		*/

		
		
	}
	
	private static int addCustomer()
	{
		return 0;
	} 
	
	private static void addBooks()
	{
		for (int i = 0; i < books.length-1; i++)
		{
			books[i] = new Book();
			books[i].setTitle(Arrays.popular[i]);
			books[i].setAuthor(Arrays.popularAuthors[i]);
		}
		
		
/*		for (int i = 0; i < books.length; i++ )
		{
			System.out.println("Enter a book name");
			books[i].setTitle(tInput.nextLine());
			System.out.println("the Author?");
			books[i].setAuthor(tInput.nextLine());
			
		}
	*/	

	}
	/*private static void removeBook(int delbook)
	{
		for (int i = delbook; i < books.length-1; i++)
		{
			books[i] = books[i+1];
		}
	}*/

}
