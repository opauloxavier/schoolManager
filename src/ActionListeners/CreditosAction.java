package ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Frames.FrameCreditos;

public class CreditosAction {
	public static ActionListener getCreditosAction(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				FrameCreditos frame = new FrameCreditos();
			
			}
		};
	}
}
