package Library;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arrays {

//	public static String books() {
		static String[] popular = new String[]{
				"Harry Potter Series", "Gregor the Underworlder", "Hunger Games Series", 
				"Divergent Series", "Mortal Instruments Series", "Infernal Devices Series",
				"The Fault in our Stars", "Maze Runner", "Speak"
			};
		
		static String[] popularAuthors = new String []{
			"J.R.R. Rowlings", "No Idea", "Maybe", "Dunno", "Huh?", "Whaa?", "???", "Who", "bark"
		};
	//	return null;
	//}

	public String music() {
		String[] albums = new String[]{
				"1989", "Red", "Speak Now", "Native", "Dreaming out Loud", "Waking Up", 
				"Encore", "Infinate", "Four", "Midnight Memories", "Prism", "Unapologetic", 
				"Adele 21", "Rock or Bust"
			};
		return null;
	}

	public String movies() {
		String[] newest = new String[]{
				"Guardians of the Galaxy", "Avengers", "The Fault in our Stars", "Divergent",
				"X-Men Days of Future Past", "Interstellar", "American Sniper", "Wolf of Wall Street",
				"Frozen", "Gravity", "Fast and Furious 6", "World War Z"
			};
		return null;
	}

}
