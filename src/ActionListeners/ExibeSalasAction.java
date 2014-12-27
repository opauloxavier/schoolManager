package ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Frames.FrameExibeSalas;

public class ExibeSalasAction {
	public static ActionListener getExibeSalas(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				FrameExibeSalas frame = new FrameExibeSalas();
			
			}
		};
	}
}
