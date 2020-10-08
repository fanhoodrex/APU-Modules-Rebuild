package GUI;

import Classes.Lecturer;
import java.io.IOException;
import javax.swing.JOptionPane;

public class LECProfile extends javax.swing.JFrame {
    Lecturer LECT;
    public LECProfile() {
        initComponents();
    }
    public LECProfile(Lecturer LECT) {
        initComponents();
        this.LECT = LECT;
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        initializeDefaultComponent(false);
    }
    private void initializeDefaultComponent(boolean enabled){        
        inline_initializeProfile();
        boolean inlineComponent = true;
        if (enabled == false){
            inlineComponent = false;
        }
        txtName.setEnabled(inlineComponent);
        txtEmail.setEnabled(inlineComponent);
        txtSpecialized.setEnabled(inlineComponent);
        txtContactNo.setEnabled(inlineComponent);
    }
    private void inline_initializeProfile(){
        try {
            if(LECT.InitializeProfile() == true){
                lblinlineUsername.setText(LECT.getUsername());
                txtName.setText(LECT.getName());
                txtEmail.setText(LECT.getEmail());
                txtSpecialized.setText(LECT.getSpecialized());
                txtContactNo.setText(LECT.getContactno());
                lblgender.setText(LECT.getGender());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Fail to initialize profile!");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblProfile = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblContactNumber = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblSpecialized = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtSpecialized = new javax.swing.JTextField();
        txtContactNo = new javax.swing.JTextField();
        lblgender = new javax.swing.JLabel();
        btnManage = new javax.swing.JButton();
        lblinlineUsername = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Manage Profile");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblProfile.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblProfile.setText("My Profile");

        lblUsername.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUsername.setText("Username: ");

        lblName.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblName.setText("Name:");

        lblContactNumber.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblContactNumber.setText("Contact Number:");

        lblEmail.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblEmail.setText("Email:");

        lblSpecialized.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblSpecialized.setText("Specialized:");

        lblGender.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblGender.setText("Gender:");

        lblgender.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblgender.setText("(Gender)");

        btnManage.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnManage.setText("Manage");
        btnManage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageActionPerformed(evt);
            }
        });

        lblinlineUsername.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblinlineUsername.setText("Dummy");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(lblProfile))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(lblUsername)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblinlineUsername))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(btnManage))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(lblSpecialized))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(lblContactNumber))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(lblEmail))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addComponent(lblName))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addComponent(lblGender)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblgender)
                            .addComponent(txtSpecialized, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblProfile)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername)
                    .addComponent(lblinlineUsername))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblName)
                        .addGap(15, 15, 15)
                        .addComponent(lblEmail)
                        .addGap(14, 14, 14)
                        .addComponent(lblSpecialized)
                        .addGap(14, 14, 14)
                        .addComponent(lblContactNumber)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGender)
                            .addComponent(lblgender))
                        .addGap(11, 11, 11)
                        .addComponent(btnManage))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtSpecialized, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageActionPerformed
        switch (btnManage.getText()){
            case "Manage":
                initializeDefaultComponent(true);
                btnManage.setText("Update");
                break;
            case "Update":
                LECT.setEmail(txtEmail.getText());
                LECT.validateEmail();
                LECT.setContactno(txtContactNo.getText());
                LECT.validateContactNo();
                LECT.setName(txtName.getText());
                LECT.setSpecialized(txtSpecialized.getText());
                if (LECT.getErrormsg().size() > 0){
                    String msg = "";
                    for(String l : LECT.getErrormsg()){
                        msg += l + "\n";
                    } 
                    JOptionPane.showMessageDialog(this, msg);
                    LECT.clearErroMsg();
                }
                else{
                    if (txtEmail.getText().length() > 0 && txtName.getText().length() > 0 && txtContactNo.getText().length() > 0 && txtSpecialized.getText().length() > 0){
                        String msg =" Username: "+lblinlineUsername.getText()+" \n"+
                           " Name: "+txtName.getText()+" \n"+
                           " Contact Number: "+txtContactNo.getText()+" \n"+
                           " Email: "+txtEmail.getText()+" \n"+
                           " Specialized: "+txtSpecialized.getText()+" \n"+
                           " Gender: "+lblgender.getText();
                       int result = JOptionPane.showConfirmDialog(this, msg, "Update Confirmation",JOptionPane.YES_NO_OPTION);
                       if (result == JOptionPane.YES_OPTION){
                           try {
                               LECT.UpdateProfile();
                               btnManage.setText("Manage");
                               initializeDefaultComponent(false);
                               JOptionPane.showMessageDialog(this, "You have successfully updated your profile!");
                           } catch (IOException ex) {
                               JOptionPane.showMessageDialog(this, "The changes is not saved!\nPlease try again later!");
                           }
                       }
                    }
                    else{
                        JOptionPane.showMessageDialog(this,"Please fill in all the text field!");
                    }
                }
                break;
        }
    }//GEN-LAST:event_btnManageActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        new LECMainPage(LECT).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LECProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LECProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LECProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LECProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LECProfile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnManage;
    private javax.swing.JLabel lblContactNumber;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblProfile;
    private javax.swing.JLabel lblSpecialized;
    private javax.swing.JLabel lblUsername;
    public javax.swing.JLabel lblgender;
    private javax.swing.JLabel lblinlineUsername;
    private javax.swing.JTextField txtContactNo;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSpecialized;
    // End of variables declaration//GEN-END:variables
}
