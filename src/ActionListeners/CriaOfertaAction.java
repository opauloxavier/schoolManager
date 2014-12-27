package ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Frames.FrameCriaOfertaDisciplina;

public class CriaOfertaAction {
	public static ActionListener getCriarOfertaAction(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				FrameCriaOfertaDisciplina frame = new FrameCriaOfertaDisciplina();
			
			}
		};
	}
}
