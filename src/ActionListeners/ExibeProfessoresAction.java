package ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Frames.FrameExibeProfessores;

public class ExibeProfessoresAction {
	
	public static ActionListener getExibeProfessores(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				FrameExibeProfessores frame = new FrameExibeProfessores();
			
			}
		};
	}
}
