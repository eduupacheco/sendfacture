
package sendfacture;

import com.placeholder.PlaceHolder;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class windowEmailOptions extends javax.swing.JFrame {

    windowMain wd;
    
    public windowEmailOptions(windowMain w) {
        this.wd = w;
        initComponents();
        getData(wd);
        
        
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("SendFacture 1.0.0 - Email Options");
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtemail = new javax.swing.JTextField();
        btnsave = new javax.swing.JButton();
        txtpassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnsave.setText("Guardar");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsavedoActionSaveChanges(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtemail)
                    .addComponent(btnsave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                    .addComponent(txtpassword))
                .addGap(72, 72, 72))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(btnsave)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsavedoActionSaveChanges(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsavedoActionSaveChanges
        int reply = JOptionPane.showConfirmDialog(null, "¿Deseas guardar los cambios?", "", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            setSaveChanges(wd);
        }
    }//GEN-LAST:event_btnsavedoActionSaveChanges

    public void getData(windowMain w){
        PlaceHolder holder;
        holder = new PlaceHolder(txtemail, "Email");
        txtemail.setText(w.from_email);
        holder = new PlaceHolder(txtemail, "Password");
    }
    
    public void setSaveChanges(windowMain w){
        if (txtemail.getText().equals("Email") || txtemail.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "No se ha introducido ningún email", "", JOptionPane.INFORMATION_MESSAGE);
        } 
        else if(txtpassword.getText().equals("Password") || txtpassword.getText().length() <= 0){
           JOptionPane.showMessageDialog(null, "No se ha introducido ningún password", "", JOptionPane.INFORMATION_MESSAGE); 
        } else {
            String newemail = txtemail.getText();
            String newpassword = txtpassword.getText();
            FileWriter fw = null;
            try {
                fw = new FileWriter(w.RUTE_MY_EMAIL);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("email:-" +newemail+"\npassword:-"+newpassword);
                bw.close();
                
                w.setRefreshData();
                this.dispose();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "No se han podido guardar los datos de email.", "", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsave;
    private javax.swing.JTextField txtemail;
    private javax.swing.JPasswordField txtpassword;
    // End of variables declaration//GEN-END:variables
}
