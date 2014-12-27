package ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class SairAction {
	
	public static ActionListener getAction(){
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		};
	}

}
