package ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Frames.FrameAlteraSala;

public class EditarSalaAction {

	public static ActionListener getEditarSalaAction(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				FrameAlteraSala frame = new FrameAlteraSala();
			
			}
		};
	}
}
