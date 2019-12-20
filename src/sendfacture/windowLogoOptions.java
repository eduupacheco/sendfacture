package sendfacture;

import com.placeholder.PlaceHolder;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import static sendfacture.windowMain.name_facture_memorial;

public class windowLogoOptions extends javax.swing.JFrame {

    windowMain wd;

    public windowLogoOptions(windowMain w) {
        this.wd = w;
        initComponents();
        getData(wd);

        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("SendFacture 1.0.0 - Profile Options");
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtlogoname = new javax.swing.JTextField();
        btnsave = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnsave.setText("Guardar");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsavedoActionSaveChanges(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Sukhumvit Set", 3, 14)); // NOI18N
        jLabel1.setText("./src/preferences/logo/");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtlogoname)
                    .addComponent(btnsave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtlogoname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
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

    public void getData(windowMain w) {
        PlaceHolder holder;
        holder = new PlaceHolder(txtlogoname, "nombredetulogo.extensión");
        txtlogoname.setText(w.logo_rute);
    }

    public void setSaveChanges(windowMain w) {
        if (txtlogoname.getText().equals("nombredetulogo.extensión") || txtlogoname.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "Hay campos sin rellenar.", "", JOptionPane.INFORMATION_MESSAGE);
        } else {

            if (isValid(txtlogoname.getText()) == true) {
                // NEW DATA TO FILL THE FIELDS
                String name = "";
                String city = "";
                String address = "";
                String phonenumber = "";
                String postalcode = "";
                String newlogorute = txtlogoname.getText();

                // GETTING THE REST FIELDS
                String file = w.RUTE_MY_INFO;
                try {
                    FileReader fr = new FileReader(file);
                    BufferedReader br = new BufferedReader(fr);

                    String line;
                    while ((line = br.readLine()) != null) {
                        if (line.startsWith("name:")) {
                            name = line.substring(6);
                        }
                        if (line.startsWith("address:")) {
                            address = line.substring(9);
                        }
                        if (line.startsWith("city:")) {
                            city = line.substring(6);
                        }
                        if (line.startsWith("postal_code:")) {
                            postalcode = line.substring(13);
                        }
                        if (line.startsWith("phone_number:")) {
                            phonenumber = line.substring(14);
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
                    bw.write("name:-" + name + "\n"
                            + "logo_rute:-" + newlogorute + "\n"
                            + "address:-" + address + "\n"
                            + "city:-" + city + "\n"
                            + "postal_code:-" + postalcode + "\n"
                            + "phone_number:-" + phonenumber + "");
                    bw.close();

                    w.setRefreshData();
                    this.dispose();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "No parece ser un nombre adecuado. Inténtelo de nuevo.", "", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public boolean isValid(String file) {
        boolean valid = false;
        File rute = new File(wd.RUTE_MY_LOGO_FOLDER + file);
        if (!rute.exists()) {
            JOptionPane.showMessageDialog(null, "No existe ningún archivo con ese nombre y extensión. Recuerde que debe introducir el logo en la ruta señalada.", "", JOptionPane.ERROR_MESSAGE);
            valid = false;
        } else {
            valid = true;
        }
        return valid;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtlogoname;
    // End of variables declaration//GEN-END:variables
}
