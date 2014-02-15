import java.awt.Color;
import java.awt.Dimension;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;


@SuppressWarnings("serial")
public class VideoPanel extends EmbeddedMediaPlayerComponent implements DropTargetListener {
	
	public VideoPanel() {
		super();
		this.setBackground(Color.BLACK);
		new DropTarget(this, DnDConstants.ACTION_COPY, this);
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(800, 300);
	}

	private void loadVideo(File file) {
		System.out.println(file);
		this.getMediaPlayer().prepareMedia(file.toString());
	}
	
	public void play() {
		this.getMediaPlayer().play();
	}
	
	public void pause() {
		this.getMediaPlayer().pause();
	}
	
	public void toStart() {
		this.getMediaPlayer().setPosition(0);
	}
	
	public void step() {
		this.getMediaPlayer().nextFrame();
	}

	@Override
	public void dragEnter(DropTargetDragEvent e) { /* do nothing */ }

	@Override
	public void dragExit(DropTargetEvent e) { /* do nothing */ }

	@Override
	public void dragOver(DropTargetDragEvent e) { /* do nothing */ }

	@Override
	public void dropActionChanged(DropTargetDragEvent e) { /* do nothing */ }

	@Override
	public void drop(DropTargetDropEvent e) {
		System.out.println("drop");
		
		Transferable transferable = e.getTransferable();
		if (e.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
			e.acceptDrop(e.getDropAction());
			try {
				@SuppressWarnings("unchecked")
				List<File> transferData = (List<File>) transferable.getTransferData(DataFlavor.javaFileListFlavor);
				loadVideo(transferData.get(0));
				e.dropComplete(true);
			} catch (UnsupportedFlavorException | IOException e1) {
				e1.printStackTrace();
			}
		} else {
			e.rejectDrop();
		}
	}
}
