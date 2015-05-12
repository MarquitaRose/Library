import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arrays implements LibraryInterface{

	@Override
	public String books() {
		String[] fiction = new String[]{
				"The Fault in our Stars", "Speak", "Wintergirls", "The Impossible Knife of Memory", 
				"Fangirl", "Eleanor and Park", "Looking for Alaska", "An Abundance of Katherines", "Paper Towns",
				
		};
		String[] dystopia = new String[]{
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
		
				return null;
	}

	@Override
	public String music() {
		String[] rap = new String[]{
				"Encore", "Infinate", "The Pinkprint", "Ghetto Barbie", "Reasonable Doubt", "Yeezus"
			};
		
		String[] pop = new String[]{
				"1989", "Red", "Speak Now", "Midnight Memories", "Prism", "Unapologetic", "Four" , "Adele 21"
		};
		
		String[] rock = new String[]{
				"Native", "Dreaming out Loud", "Waking Up", "Rock or Bust", "Best of Kansas", "Back in Black", "Bad Blood"
		};
		return null;
	}

	@Override
	public String movies() {
		String[] marvel = new String[]{
				"Guardians of the Galaxy", "Avengers", "The Fault in our Stars", "Divergent",
				"X-Men Days of Future Past", "Interstellar", "American Sniper", "Wolf of Wall Street",
				"Frozen", "Gravity", "Fast and Furious 6", "World War Z"
			};
		
		return null;
	}

}
