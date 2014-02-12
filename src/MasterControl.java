import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MasterControl extends JPanel {
	
	public MasterControl() {
		this.setBackground(Color.RED);
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(800, 40);
	}
}
