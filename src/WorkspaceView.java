import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class WorkspaceView extends JPanel {

	public WorkspaceView() {
		this.setBackground(Color.BLUE);
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(300, 640);
	}
}
