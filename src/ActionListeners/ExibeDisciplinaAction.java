package ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Frames.FrameExibeDisciplina;

public class ExibeDisciplinaAction {
	
	public static ActionListener getExibeDisciplinaAction(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				FrameExibeDisciplina frame = new FrameExibeDisciplina();
			
			}
		};
	}
}
