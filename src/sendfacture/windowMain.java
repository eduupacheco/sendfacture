package sendfacture;

import com.placeholder.PlaceHolder;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class windowMain extends javax.swing.JFrame {

    // ENTERPRISE EMAIL & PASSWORD
    public static String from_email;
    public static String password;

    // ENTERPRISE INFO
    public static String name;
    public static String logo_rute;
    public static String address;
    public static String city;
    public static String postal_code;
    public static String phone_number;

    // FACTURE INFO
    public static String facture_name;
    public static String facture_code;

    // MEMORIAL SYSTEM
    public static String code_facture_memorial;
    public static String name_facture_memorial;

    // RUTE SYSTEM
    public static String RUTE_FACTURES = "./src/factures/";
    public static String RUTE_HISTORICAL_FACTURE = "./src/factures/historical/historical.txt";
    public static String RUTE_DATAFACTURE = "./src/factures/historical/datafacture/datafacture.txt";
    public static String RUTE_MY_LOGO_FOLDER = "./src/preferences/logo/";
    public static String RUTE_MY_EMAIL = "./src/preferences/email/myemail.txt";
    public static String RUTE_MY_INFO = "./src/preferences/info/myinfo.txt";

    // COMPONENTS FOR TABLE
    DefaultTableModel modeldatatable;

    public windowMain() {
        initComponents();
        getHistoricalCodeFacture();
        getMyEmail();
        getMyInfo();
        setComponentsConfiguration();
        createTable();

        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("SendFacture 1.0.0");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnsendfacture = new javax.swing.JButton();
        txttoemail = new javax.swing.JTextField();
        txtsubject = new javax.swing.JTextField();
        txtfacturename = new javax.swing.JTextField();
        txtfacturecode = new javax.swing.JTextField();
        txtname = new javax.swing.JTextField();
        txtcity = new javax.swing.JTextField();
        txtpostalcode = new javax.swing.JTextField();
        txtaddress = new javax.swing.JTextField();
        txtphonenumber = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        txtdescription = new javax.swing.JTextField();
        quantityspinner = new javax.swing.JSpinner();
        btnadd = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btngeneratefacture = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        txtunitaryimport = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        txtsumfacture = new javax.swing.JLabel();
        btndeleteall = new javax.swing.JButton();
        labelshowalert = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtmsg = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnsendfacture.setText("Generate & Send Facture");
        btnsendfacture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoActionGenerateandSendFacture(evt);
            }
        });

        txttoemail.setToolTipText("Correo electrónico");

        txtpostalcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                doFormatterPostalCode(evt);
            }
        });

        txtphonenumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                doFormatterPhoneNumber(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ){public boolean isCellEditable(int row, int column){return false;}});
        jScrollPane1.setViewportView(table);

        btnadd.setText("Insertar");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoActionAdd(evt);
            }
        });

        btndelete.setText("ELIMINAR");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoActionDelete(evt);
            }
        });

        btngeneratefacture.setText("Generate Facture");
        btngeneratefacture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoActionGenerateFacture(evt);
            }
        });

        txtunitaryimport.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                doFormatterUnitaryImport(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtsumfacture.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtsumfacture, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtsumfacture, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btndeleteall.setText("ELIMINAR TODO");
        btndeleteall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doActionDeleteAll(evt);
            }
        });

        txtmsg.setColumns(10);
        txtmsg.setLineWrap(true);
        txtmsg.setRows(5);
        txtmsg.setMaximumSize(new java.awt.Dimension(25, 2147483647));
        jScrollPane2.setViewportView(txtmsg);

        jMenu1.setText("Archivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.META_MASK));
        jMenuItem1.setText("Nuevo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doActionOpenNewFile(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu5.setText("Editar");

        jMenuItem8.setText("Código Factura");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doActionOpenFactureOptions(evt);
            }
        });
        jMenu5.add(jMenuItem8);

        jMenuBar1.add(jMenu5);

        jMenu2.setText("Ver");

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.META_MASK));
        jMenuItem7.setText("Última Factura");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doActionViewLastFacture(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.META_MASK));
        jMenuItem3.setText("Facturas");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doActionOpenFactures(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Preferencias");

        jMenuItem4.setText("Perfil");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doActionOpenInfoOptions(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuItem5.setText("Email");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doActionOpenEmailOptions(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuItem6.setText("Logotipo");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doActionOpenLogoOptions(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Ayuda");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.META_MASK));
        jMenuItem2.setText("Documentación");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doActionOpenDocumentation(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtaddress)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txttoemail, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtphonenumber))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtcity, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtpostalcode))
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2)
                    .addComponent(txtname)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtdescription, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtunitaryimport, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(quantityspinner, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnadd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtfacturename, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtfacturecode, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                .addComponent(btngeneratefacture, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btndeleteall, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnsendfacture, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                                .addComponent(jSeparator3)
                                .addComponent(labelshowalert, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtsubject, javax.swing.GroupLayout.Alignment.TRAILING)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpostalcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtphonenumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttoemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantityspinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnadd)
                    .addComponent(txtunitaryimport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btndelete, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                            .addComponent(btndeleteall, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                        .addComponent(labelshowalert, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtsubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsendfacture, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfacturename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfacturecode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btngeneratefacture, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDoActionGenerateandSendFacture(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoActionGenerateandSendFacture
        int reply = JOptionPane.showConfirmDialog(null, "¿Deseas generar y envíar la factura?", "", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            setGenerateFacture();
            setSendFacture();
        }
    }//GEN-LAST:event_btnDoActionGenerateandSendFacture

    private void btnDoActionAdd(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoActionAdd

        DecimalFormat df = new DecimalFormat("#.00");
        String data[] = new String[4];

        if (txtdescription.getText().equals("Descripción")) {
            setShowAlert("No has introducido una descripción.", 2);
        } else if (txtunitaryimport.getText().equals("Importe Unitario")) {
            setShowAlert("No has introducido un importe.", 2);
        } else {
            data[0] = txtdescription.getText();
            data[1] = df.format(Float.parseFloat(txtunitaryimport.getText())).replace(',', '.');
            data[2] = quantityspinner.getValue().toString();
            String totalimport = "" + df.format(Integer.parseInt(quantityspinner.getValue().toString()) * Float.parseFloat(txtunitaryimport.getText()));
            data[3] = totalimport.replace(',', '.');
            modeldatatable.addRow(data);
            setCalculateFacture();
        }
    }//GEN-LAST:event_btnDoActionAdd

    private void btnDoActionDelete(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoActionDelete
        int rowselected = table.getSelectedRow();
        if (rowselected >= 0) {
            modeldatatable.removeRow(rowselected);
        }
        setCalculateFacture();
    }//GEN-LAST:event_btnDoActionDelete

    private void btnDoActionGenerateFacture(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoActionGenerateFacture
        int reply = JOptionPane.showConfirmDialog(null, "¿Deseas sólo generar la factura?", "", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            setGenerateFacture();
        }
    }//GEN-LAST:event_btnDoActionGenerateFacture

    private void doFormatterUnitaryImport(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_doFormatterUnitaryImport
        char ch = evt.getKeyChar();
        if (((ch < '0') || (ch > '9')) && (ch != '\b') && (ch != 46)) {
            evt.consume();
        }
    }//GEN-LAST:event_doFormatterUnitaryImport

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

    private void doActionDeleteAll(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doActionDeleteAll
        for (int i = 0; i < table.getRowCount(); i++) {
            modeldatatable.removeRow(i);
            i -= 1;
        }
        setCalculateFacture();
    }//GEN-LAST:event_doActionDeleteAll

    private void doActionOpenNewFile(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doActionOpenNewFile
        this.dispose();
        new windowMain();
    }//GEN-LAST:event_doActionOpenNewFile

    private void doActionOpenDocumentation(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doActionOpenDocumentation
        if (Desktop.isDesktopSupported()) {
            try {
                File rute = new File("./src/documentation/documentation.pdf");
                Desktop.getDesktop().open(rute);
            } catch (IOException ex) {
                System.out.println("NO SUPPORTED.");
            }
        }
    }//GEN-LAST:event_doActionOpenDocumentation

    private void doActionOpenFactures(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doActionOpenFactures
        try {
            File rute = new File("./src/factures/");
            if (!rute.exists()) {
                JOptionPane.showMessageDialog(null, "No existe el directorio facturas.", "", JOptionPane.ERROR_MESSAGE);
            } else {
                Desktop.getDesktop().open(rute);
            }
        } catch (IOException ex) {
            Logger.getLogger(windowMain.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No existe el directorio facturas.", "", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_doActionOpenFactures

    private void doActionViewLastFacture(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doActionViewLastFacture
        String lastcodefacture = convertToSTCodeFacture(Integer.parseInt(code_facture_memorial) - 1);
        if (Desktop.isDesktopSupported()) {
            try {
                File rute = new File("./src/factures/" + name_facture_memorial + lastcodefacture + ".pdf");
                if (!rute.exists()) {
                    JOptionPane.showMessageDialog(null, "No tiene facturas anteriores o ha renombrado la factura.", "", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    Desktop.getDesktop().open(rute);
                }
            } catch (IOException ex) {
                Logger.getLogger(windowMain.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "No tiene facturas anteriores o ha renombrado la factura.", "", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_doActionViewLastFacture

    private void doActionOpenFactureOptions(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doActionOpenFactureOptions
        new windowFactureOptions(this);
    }//GEN-LAST:event_doActionOpenFactureOptions

    private void doActionOpenEmailOptions(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doActionOpenEmailOptions
        new windowEmailOptions(this);
    }//GEN-LAST:event_doActionOpenEmailOptions

    private void doActionOpenLogoOptions(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doActionOpenLogoOptions
        new windowLogoOptions(this);
    }//GEN-LAST:event_doActionOpenLogoOptions

    private void doActionOpenInfoOptions(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doActionOpenInfoOptions
        new windowInfoOptions(this);
    }//GEN-LAST:event_doActionOpenInfoOptions

    public void setComponentsConfiguration() {
        PlaceHolder holder;
        holder = new PlaceHolder(txtname, "Nombre");
        holder = new PlaceHolder(txtcity, "Ciudad");
        holder = new PlaceHolder(txtpostalcode, "Código Postal");
        holder = new PlaceHolder(txtaddress, "Dirección");
        holder = new PlaceHolder(txtphonenumber, "Teléfono");
        holder = new PlaceHolder(txttoemail, "Email");
        holder = new PlaceHolder(txtsubject, "Asunto");
        holder = new PlaceHolder(txtmsg, "Escriba un mensaje para el destinatario");
        holder = new PlaceHolder(txtdescription, "Descripción");
        holder = new PlaceHolder(txtunitaryimport, "Importe Unitario");

        SpinnerNumberModel model = new SpinnerNumberModel(1, 1, 100000000, 1);
        quantityspinner.setModel(model);

        txtsumfacture.setText("0.00€");
        txtsumfacture.setFont(txtsumfacture.getFont().deriveFont(46f));

        txtfacturename.setEditable(false);
        txtfacturecode.setEditable(false);
    }

    public void createTable() {
        modeldatatable = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        modeldatatable.addColumn("DESCRIPCIÓN");
        modeldatatable.addColumn("PRECIO UNITARIO");
        modeldatatable.addColumn("CANTIDAD");
        modeldatatable.addColumn("IMPORTE");

        table.setModel(modeldatatable);
    }

    public void getMyInfo() {
        // GETTING INFO FROM MYINFO.TXT
        String file = RUTE_MY_INFO;
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("name:")) {
                    String name = line.substring(6);
                    this.name = name;
                }

                if (line.startsWith("logo_rute:")) {
                    String logo_rute = line.substring(11);
                    this.logo_rute = logo_rute;
                }

                if (line.startsWith("address:")) {
                    String address = line.substring(9);
                    this.address = address;
                }

                if (line.startsWith("city:")) {
                    String city = line.substring(6);
                    this.city = city;
                }

                if (line.startsWith("postal_code:")) {
                    String postal_code = line.substring(13);
                    this.postal_code = postal_code;
                }

                if (line.startsWith("phone_number:")) {
                    String phone_number = line.substring(14);
                    this.phone_number = phone_number;
                }
            }

            fr.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al leer los indicios en myinfo.txt", "", JOptionPane.ERROR_MESSAGE);
            setShowAlert("Error al leer los indicios en myinfo.txt", 3);
        }
    }

    public void getMyEmail() {
        // GETTING INFO FROM MYEMAIL.TXT
        String file = RUTE_MY_EMAIL;
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("email:")) {
                    String email = line.substring(7);
                    this.from_email = email;
                }

                if (line.startsWith("password:")) {
                    String password = line.substring(10);
                    this.password = password;
                }
            }

            fr.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al leer los indicios en myemail.txt", "", JOptionPane.ERROR_MESSAGE);
            setShowAlert("Error al leer los indicios en myemail.txt", 3);
        }
    }

    public void getHistoricalCodeFacture() {
        // GETTING INFO FROM MYEMAIL.TXT
        try {
            String file = RUTE_DATAFACTURE;
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("namefacture:")) {
                    String namefacture = line.substring(13);
                    name_facture_memorial = namefacture;
                    txtfacturename.setText("" + name_facture_memorial);
                }
            }

            fr.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(windowMain.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Missing [NAME CODE]", "", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(windowMain.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Missing [NAME CODE].", "", JOptionPane.ERROR_MESSAGE);
        }

        // GETTING INFO FROM HISTORY.TXT
        try {
            String file = RUTE_HISTORICAL_FACTURE;
            try (FileReader fr = new FileReader(file)) {
                BufferedReader br = new BufferedReader(fr);

                String linecode;
                String lastlinecode = "";

                while ((linecode = br.readLine()) != null) {
                    lastlinecode = linecode;
                }
                code_facture_memorial = lastlinecode;

                // SHOW CODE FACTURE
                txtfacturecode.setText("" + code_facture_memorial);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error crítico. No se ha encontrado el historial.", "", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setHistoricalCodeFacture(String st_codefacture_old) {
        // SETTING INFO TO HISTORY.TXT
        try {
            String file = RUTE_HISTORICAL_FACTURE;
            FileWriter fw = new FileWriter(file, true);
            PrintWriter pw = new PrintWriter(fw);

            String st_codefacture_new = convertToSTCodeFacture(Integer.parseInt(st_codefacture_old) + 1);
            pw.print(st_codefacture_new + "\n");

            fw.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error crítico. No se ha encontrado el historial.", "", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setGenerateFacture() {
        if (getVerifiedControlDataCustomer() == true) {

            // CUSTOMER DATA
            String customer_name = txtname.getText();
            String customer_city = txtcity.getText();
            String customer_postalcode = txtpostalcode.getText();
            String customer_address = txtaddress.getText();
            String customer_phonenumber = txtphonenumber.getText();
            String customer_email = txttoemail.getText();

            // FACTURE DATA
            facture_name = txtfacturename.getText();
            facture_code = txtfacturecode.getText();

            // SUM FACTURE
            String facture_sum = txtsumfacture.getText();

            new generateFacture(this, facture_name, facture_code,
                    name, logo_rute, address, city, postal_code, phone_number,
                    customer_name, customer_city, customer_postalcode, customer_address, customer_phonenumber, customer_email,
                    table, facture_sum);
            this.setEnabled(true);

            setHistoricalCodeFacture(code_facture_memorial);
            getHistoricalCodeFacture();
        }
    }

    public void setSendFacture() {
        if (getVerifiedControlDataCustomer() == true) {
            setShowAlert("Sending facture...", 1);

            String to_email = txttoemail.getText();
            String subject = txtsubject.getText();
            String text = txtmsg.getText();

            new sendFacture(this, to_email, subject, text, facture_name, facture_code, from_email, password);
            setCleanShowAlert();
        }
    }

    public void setCalculateFacture() {
        DecimalFormat df = new DecimalFormat("#.00");
        float total = 0;
        for (int row = 0; row < table.getRowCount(); row++) {
            total = total + Float.parseFloat(table.getValueAt(row, 3).toString());
        }
        if (total <= 999999999) {
            if (total == 0) {
                txtsumfacture.setText("0.00€");
            } else {
                txtsumfacture.setText(df.format(total).replace(',', '.') + "€");
            }
        } else {
            total = 999999999;
            txtsumfacture.setText(df.format(total).replace(',', '.') + "€");
            setShowAlert("La cantidad supera el máximo de lo que se puede operar.", 3);
        }
    }

    public String convertToSTCodeFacture(int int_codefacture) {
        String st_codefacture = Integer.toString(int_codefacture);

        if (st_codefacture.length() == 1) {
            st_codefacture = "000000000" + st_codefacture;
        }
        if (st_codefacture.length() == 2) {
            st_codefacture = "00000000" + st_codefacture;
        }
        if (st_codefacture.length() == 3) {
            st_codefacture = "0000000" + st_codefacture;
        }
        if (st_codefacture.length() == 4) {
            st_codefacture = "000000" + st_codefacture;
        }
        if (st_codefacture.length() == 5) {
            st_codefacture = "00000" + st_codefacture;
        }
        if (st_codefacture.length() == 6) {
            st_codefacture = "0000" + st_codefacture;
        }
        if (st_codefacture.length() == 7) {
            st_codefacture = "000" + st_codefacture;
        }
        if (st_codefacture.length() == 8) {
            st_codefacture = "00" + st_codefacture;
        }
        if (st_codefacture.length() == 9) {
            st_codefacture = "0" + st_codefacture;
        }
        if (st_codefacture.length() == 10) {
            int_codefacture = Integer.parseInt(st_codefacture);
        }
        return st_codefacture;
    }

    public boolean getVerifiedControlDataCustomer() {
        boolean verified = false;
        if (txtname.getText().equals("Nombre") || txtname.getText().length() <= 0) {
            setShowAlert("Introducir nombre del cliente.", 1);
        } else if (txtcity.getText().equals("Ciudad") || txtcity.getText().length() <= 0) {
            setShowAlert("Introducir ciudad del cliente.", 1);
        } else if (txtpostalcode.getText().equals("Código Postal") || txtpostalcode.getText().length() <= 0) {
            setShowAlert("Introducir código postal del cliente.", 1);
        } else if (txtaddress.getText().equals("Dirección") || txtaddress.getText().length() <= 0) {
            setShowAlert("Introducir dirección del cliente.", 1);
        } else if (txtphonenumber.getText().equals("Teléfono") || txtphonenumber.getText().length() <= 0) {
            setShowAlert("Introducir teléfono del cliente.", 1);
        } else if (txttoemail.getText().equals("Email") || txttoemail.getText().length() <= 0) {
            setShowAlert("Introducir email del cliente.", 1);
        } else {
            verified = true;
        }
        return verified;
    }

    public void setShowAlert(String alert, int type) {
        switch (type) {
            case 1:
                labelshowalert.setForeground(Color.BLUE);
                break;
            case 2:
                labelshowalert.setForeground(Color.ORANGE);
                break;
            case 3:
                labelshowalert.setForeground(Color.RED);
                break;
        }
        labelshowalert.setText(alert);
    }

    public void setCleanShowAlert() {
        labelshowalert.setText("");
    }
    
    public void setRefreshData(){
        getHistoricalCodeFacture();
        getMyEmail();
        getMyInfo();
        setComponentsConfiguration();
        createTable();

        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("SendFacture 1.0.0");
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btndeleteall;
    private javax.swing.JButton btngeneratefacture;
    private javax.swing.JButton btnsendfacture;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    public javax.swing.JLabel labelshowalert;
    private javax.swing.JSpinner quantityspinner;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JTextField txtcity;
    private javax.swing.JTextField txtdescription;
    private javax.swing.JTextField txtfacturecode;
    private javax.swing.JTextField txtfacturename;
    private javax.swing.JTextArea txtmsg;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtphonenumber;
    private javax.swing.JTextField txtpostalcode;
    private javax.swing.JTextField txtsubject;
    private javax.swing.JLabel txtsumfacture;
    private javax.swing.JTextField txttoemail;
    private javax.swing.JTextField txtunitaryimport;
    // End of variables declaration//GEN-END:variables
}
