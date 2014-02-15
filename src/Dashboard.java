import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import net.miginfocom.swing.MigLayout;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;


@SuppressWarnings("serial")
public class Dashboard extends JFrame {
	
	ArrayList<VideoPanel> videoPanels;
	
	private Dashboard() {
		super("Dashboard");
		NativeLibrary.addSearchPath(
				RuntimeUtil.getLibVlcLibraryName(),
				"C:\\Program Files (x86)\\VideoLAN\\VLC"
		);
		Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setLayout(new MigLayout());
		
		videoPanels = new ArrayList<VideoPanel>();
		videoPanels.add(new VideoPanel());
		videoPanels.add(new VideoPanel());
		
		// span 1 wide and tall enough to hold videoPanels + controls
		this.add(new WorkspaceView(), "span 1 " + videoPanels.size()+1);
		for (VideoPanel videoPanel: videoPanels) {
			this.add(videoPanel, "wrap 0");
		}
		this.add(new MasterControl(this), "wrap 0");

		this.pack();
		this.setVisible(true);
	}
	
	public void play() {
		for (VideoPanel videoPanel: videoPanels) {
			videoPanel.play();
		}
	}
	
	public void pause() {
		for (VideoPanel videoPanel: videoPanels) {
			videoPanel.pause();
		}
	}
	
	public void toStart() {
		for (VideoPanel videoPanel: videoPanels) {
			videoPanel.toStart();
		}
	}
	
	public void step() {
		for (VideoPanel videoPanel: videoPanels) {
			videoPanel.step();
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Dashboard();
			}
		});
	}
	
}
