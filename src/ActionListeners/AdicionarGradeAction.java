package ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Frames.FrameAdicionaDisciplinaGrade;

public class AdicionarGradeAction {
	public static ActionListener getAlteraProfessor(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				FrameAdicionaDisciplinaGrade frame = new FrameAdicionaDisciplinaGrade();
			
			}
		};
	}
}
