package panels;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class CatalogHome extends JPanel {
 
	public static void initial(){
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
	}
}
