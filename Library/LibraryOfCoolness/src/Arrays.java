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
		List<String> pop = new ArrayList<String>();
		try(BufferedReader br = new BufferedReader(new FileReader(new File("Book_1")))) {
		    for(String line; (line = br.readLine()) != null; ) {
		        pop.add(line);
		    }
		} catch (FileNotFoundException e) { 
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] popular = new String[pop.size()];
		for(int i = 0; i < pop.size(); i++){
			popular[i] = pop.get(i);
		}
		return null;
	}

	@Override
	public String music() {
		List<String> pop = new ArrayList<String>();
		try(BufferedReader br = new BufferedReader(new FileReader(new File("Untitled_2")))) {
		    for(String line; (line = br.readLine()) != null; ) {
		        pop.add(line);
		    }
		} catch (FileNotFoundException e) { 
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] popular = new String[pop.size()];
		for(int i = 0; i < pop.size(); i++){
			popular[i] = pop.get(i);
		}
		return null;
	}

	@Override
	public String movies() {
		// TODO Auto-generated method stub
		return null;
	}

}
