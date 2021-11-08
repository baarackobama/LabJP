import java.util.HashMap;
import java.util.Map;

import javax.swing.SwingUtilities;

public class Login {
	
	public static void main(String[] args){
		
		runMain();
	}


public static void runMain() {
	SwingUtilities.invokeLater(new Runnable() {
        public void run() {
        	Okno okno = new Okno();
        }
    });
}
}
