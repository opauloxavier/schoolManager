package ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Frames.FrameAdicionaDisciplina;


public class NovaDisciplinaAction {

	public static ActionListener getAction(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				FrameAdicionaDisciplina frame = new FrameAdicionaDisciplina();
				
			}
		};
	

	
}
}
