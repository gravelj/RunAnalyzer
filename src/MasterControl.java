import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class MasterControl extends JPanel implements ActionListener {
	
	private Dashboard model;
	
	public MasterControl(Dashboard model) {
		this.model = model;
		this.setBackground(Color.RED);
		this.setLayout(new MigLayout());
		
		JButton[] buttons = new JButton[5];
		
		buttons[0] = new JButton("Play");
		buttons[1] = new JButton("Pause");
		buttons[2] = new JButton("To Start");
		buttons[3] = new JButton("Step");
		buttons[4] = new JButton("Something Else");
		
		for (JButton button: buttons) {
			button.addActionListener(this);
			this.add(button);
		}
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(800, 40);
	}

	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		
		if (action.equals("Play")) {
			model.play();
		} else if (action.equals("Pause")) {
			model.pause();
		} else if (action.equals("To Start")) {
			model.toStart();
		} else if (action.equals("Step")) {
			model.step();
		} else if (action.equals("Something Else")) {
			
		}
	}
}
