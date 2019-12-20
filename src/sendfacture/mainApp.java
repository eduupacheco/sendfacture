
package sendfacture;

import java.io.File;

public class mainApp {
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new windowMain();
            }
        });
    }
}
