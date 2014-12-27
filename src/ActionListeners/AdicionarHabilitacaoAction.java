package ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Frames.AdicionaDisciplinaHabilitada;

public class AdicionarHabilitacaoAction {
	public static ActionListener getAdicionaAlteracao(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				AdicionaDisciplinaHabilitada frame = new AdicionaDisciplinaHabilitada();
			
			}
		};
	}
}
