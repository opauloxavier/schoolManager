package ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Frames.FrameCadastroSala;


public class NovaSalaAction {
	public static ActionListener getSalaAction(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				FrameCadastroSala frame = new FrameCadastroSala();
			
			}
		};
	}
}
