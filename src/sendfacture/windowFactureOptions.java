package sendfacture;

import com.placeholder.PlaceHolder;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import static sendfacture.windowMain.RUTE_HISTORICAL_FACTURE;
import static sendfacture.windowMain.name_facture_memorial;

public class windowFactureOptions extends javax.swing.JFrame {

    windowMain wd;

    public windowFactureOptions(windowMain w) {
        this.wd = w;
        initComponents();
        getData(wd);

        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("SendFacture 1.0.0 - Facture Options");

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtnamefacture = new javax.swing.JTextField();
        txtcodefacture = new javax.swing.JTextField();
        btnsave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnsave.setText("Guardar");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doActionSaveChanges(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtnamefacture)
                    .addComponent(txtcodefacture)
                    .addComponent(btnsave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))
                .addGap(72, 72, 72))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(txtnamefacture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtcodefacture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(btnsave)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void doActionSaveChanges(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doActionSaveChanges
        int reply = JOptionPane.showConfirmDialog(null, "¿Deseas guardar los cambios?", "", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            setSaveChanges(wd);
        }
    }//GEN-LAST:event_doActionSaveChanges

    public void getData(windowMain w) {
        PlaceHolder holder;
        holder = new PlaceHolder(txtnamefacture, "Name Code");
        txtnamefacture.setText(w.name_facture_memorial);

        txtcodefacture.setEditable(false);
        txtcodefacture.setText(w.code_facture_memorial);
    }

    public void setSaveChanges(windowMain w) {
        if (txtnamefacture.getText().equals("Name Code") || txtnamefacture.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "No se ha introducido ningún code name", "", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String newnamefacture = txtnamefacture.getText();
            FileWriter fw = null;
            try {
                fw = new FileWriter(w.RUTE_DATAFACTURE);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("namefacture:-" + newnamefacture);
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
    private javax.swing.JTextField txtcodefacture;
    private javax.swing.JTextField txtnamefacture;
    // End of variables declaration//GEN-END:variables
}
