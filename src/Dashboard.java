import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import net.miginfocom.swing.MigLayout;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;


@SuppressWarnings("serial")
public class Dashboard extends JFrame {
	
	private Dashboard() {
		super("Dashboard");
		NativeLibrary.addSearchPath(
				RuntimeUtil.getLibVlcLibraryName(),
				"C:\\Program Files (x86)\\VideoLAN\\VLC"
		);
		Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setLayout(new MigLayout());
		
		this.add(new WorkspaceView(), "span 1 3");
		this.add(new VideoPanel(), "wrap 0");
		this.add(new VideoPanel(), "wrap 0");
		this.add(new MasterControl(), "wrap 0");

		this.pack();
		this.setVisible(true);
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
