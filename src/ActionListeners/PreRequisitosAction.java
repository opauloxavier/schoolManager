package ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Frames.FramePreRequisito;


public class PreRequisitosAction {
	public static ActionListener getAction(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				FramePreRequisito frame = new FramePreRequisito();
				
			}
		};
	}
}
