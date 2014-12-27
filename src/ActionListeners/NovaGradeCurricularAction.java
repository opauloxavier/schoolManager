package ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Frames.FrameAdicionaGradeCurricular;

public class NovaGradeCurricularAction {

	public static ActionListener getAction(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				FrameAdicionaGradeCurricular frame = new FrameAdicionaGradeCurricular();
				
			}
		};
}}
