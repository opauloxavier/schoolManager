package ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Frames.FrameExibeGrade;
import Frames.FrameExibeOferta;

public class ExibeOfertaAction {
	public static ActionListener getExibeOfertaAction(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				FrameExibeOferta frame = new FrameExibeOferta();
			
			}
		};
	}
}
