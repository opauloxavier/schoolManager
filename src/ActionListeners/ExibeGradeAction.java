package ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Frames.FrameExibeDisciplina;
import Frames.FrameExibeGrade;

public class ExibeGradeAction {
	public static ActionListener getExibeGradeAction(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				FrameExibeGrade frame = new FrameExibeGrade();
			
			}
		};
	}
}
