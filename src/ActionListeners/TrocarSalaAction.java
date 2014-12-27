package ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Frames.FrameTrocarSala;

public class TrocarSalaAction {
	
	public static ActionListener getTrocarSalaAction(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				FrameTrocarSala frame = new FrameTrocarSala();
			
			}
		};
	}

}
