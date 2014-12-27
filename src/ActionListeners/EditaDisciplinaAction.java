package ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Frames.FrameCriaOfertaDisciplina;
import Frames.FrameEditaDisciplina;

public class EditaDisciplinaAction {
	public static ActionListener getEditaDisciplinaAction(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				FrameEditaDisciplina frame = new FrameEditaDisciplina();
			
			}
		};
	}
}
