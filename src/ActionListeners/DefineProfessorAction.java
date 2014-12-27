package ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Frames.FrameDefineProfessor;

public class DefineProfessorAction {
	public static ActionListener getDefinirProfessorAction(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				FrameDefineProfessor frame = new FrameDefineProfessor();
			
			}
		};
	}
}
