package ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Frames.FrameProfessoresAptos;

public class ExibeProfessorAptoAction {
	
	public static ActionListener getExibeProfessorAptoAction(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				FrameProfessoresAptos frame = new FrameProfessoresAptos();
			
			}
		};
	}
}
