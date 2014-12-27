package ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Frames.FrameAlteraProfessor;
import Frames.FrameCadastroProfessor;

public class AlteraProfessorAction {

	public static ActionListener getAlteraProfessor(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				FrameAlteraProfessor frame = new FrameAlteraProfessor();
			
			}
		};
	}
	
}
