package sendfacture;

import com.placeholder.PlaceHolder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import static sendfacture.windowMain.RUTE_MY_INFO;

public class windowInfoOptions extends javax.swing.JFrame {

    windowMain wd;

    public windowInfoOptions(windowMain w) {
        this.wd = w;
        initComponents();
        getData(wd);

        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("SendFacture 1.0.0 - Logo Options");
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtcity = new javax.swing.JTextField();
        txtpostalcode = new javax.swing.JTextField();
        btnsave = new javax.swing.JButton();
        txtname = new javax.swing.JTextField();
        txtphonenumber = new javax.swing.JTextField();
        txtaddress = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtpostalcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                doFormatterPostalCode(evt);
            }
        });

        btnsave.setText("Guardar");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsavedoActionSaveChanges(evt);
            }
        });

        txtphonenumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                doFormatterPhoneNumber(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtpostalcode, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtphonenumber, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtcity)
                    .addComponent(txtaddress)
                    .addComponent(txtname))
                .addGap(72, 72, 72))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtcity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtphonenumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpostalcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
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

    private void doFormatterPhoneNumber(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_doFormatterPhoneNumber
        char ch = evt.getKeyChar();
        if (((ch < '0') || (ch > '9')) && (ch != '\b')) {
            evt.consume();
        }
    }//GEN-LAST:event_doFormatterPhoneNumber

    private void doFormatterPostalCode(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_doFormatterPostalCode
        char ch = evt.getKeyChar();
        if (((ch < '0') || (ch > '9')) && (ch != '\b')) {
            evt.consume();
        }
    }//GEN-LAST:event_doFormatterPostalCode

    public void getData(windowMain w) {
        PlaceHolder holder;
        holder = new PlaceHolder(txtname, "Nombre");
        txtname.setText(w.name);
        holder = new PlaceHolder(txtcity, "Ciudad");
        txtcity.setText(w.city);
        holder = new PlaceHolder(txtaddress, "Dirección");
        txtaddress.setText(w.address);
        holder = new PlaceHolder(txtphonenumber, "Teléfono");
        txtphonenumber.setText(w.phone_number);
        holder = new PlaceHolder(txtpostalcode, "Código Postal");
        txtpostalcode.setText(w.postal_code);
    }

    public void setSaveChanges(windowMain w) {
        if (txtname.getText().equals("Nombre") || txtname.getText().length() <= 0
                || txtcity.getText().equals("Nombre") || txtcity.getText().length() <= 0
                || txtaddress.getText().equals("Nombre") || txtaddress.getText().length() <= 0
                || txtphonenumber.getText().equals("Nombre") || txtphonenumber.getText().length() <= 0
                || txtpostalcode.getText().equals("Nombre") || txtpostalcode.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "Hay campos sin rellenar.", "", JOptionPane.INFORMATION_MESSAGE);
        } else {

            // NEW DATA TO FILL THE FIELDS
            String newname = txtname.getText();
            String newcity = txtcity.getText();
            String newaddress = txtaddress.getText();
            String newphonenumber = txtphonenumber.getText();
            String newpostalcode = txtpostalcode.getText();
            String logorute = "";

            // GETTING THE LOGO RUTE
            String file = w.RUTE_MY_INFO;
            try {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);

                String line;
                while ((line = br.readLine()) != null) {
                    if (line.startsWith("logo_rute:")) {
                        logorute = line.substring(11);
                    }
                }

                fr.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al leer los indicios en myinfo.txt", "", JOptionPane.ERROR_MESSAGE);
            }

            FileWriter fw = null;
            try {
                fw = new FileWriter(w.RUTE_MY_INFO);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("name:-" + newname + "\n"
                        + "logo_rute:-" + logorute + "\n"
                        + "address:-" + newaddress + "\n"
                        + "city:-" + newcity + "\n"
                        + "postal_code:-" + newpostalcode + "\n"
                        + "phone_number:-" + newphonenumber + "");
                bw.close();
                
                w.setRefreshData();
                this.dispose();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "No parece ser un nombre adecuado. Inténtelo de nuevo.", "", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsave;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JTextField txtcity;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtphonenumber;
    private javax.swing.JTextField txtpostalcode;
    // End of variables declaration//GEN-END:variables
}
