package GUI;

import Classes.Admin;
import java.io.IOException;
import javax.swing.JOptionPane;

public class ADMProfile extends javax.swing.JFrame {
    Admin adm;
    public ADMProfile() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
    public ADMProfile(Admin adm) {
        initComponents();
        this.adm = adm;
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        inline_initializeProfile();
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
        txtContactNo.setEnabled(inlineComponent);
    }
    private void inline_initializeProfile(){
        try {
            if(adm.InitializeProfile() == true){
                lblinlineUsername.setText(adm.getUsername());
                txtName.setText(adm.getName());
                txtEmail.setText(adm.getEmail());
                txtContactNo.setText(adm.getContactno());
                lblgender.setText(adm.getGender());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Fail to initialize profile!");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUsername = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblinlineUsername = new javax.swing.JLabel();
        lblgender = new javax.swing.JLabel();
        lblContactNumber = new javax.swing.JLabel();
        btnManage = new javax.swing.JButton();
        lblProfile = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtContactNo = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Manage Profile");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblUsername.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUsername.setText("Username: ");

        lblGender.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblGender.setText("Gender:");

        lblName.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblName.setText("Name:");

        lblinlineUsername.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblinlineUsername.setText("(Username)");

        lblgender.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblgender.setText("(Gender)");

        lblContactNumber.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblContactNumber.setText("Contact Number:");

        btnManage.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnManage.setText("Manage");
        btnManage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageActionPerformed(evt);
            }
        });

        lblProfile.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblProfile.setText("My Profile");

        lblEmail.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblEmail.setText("Email:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(lblProfile))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(lblUsername))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(lblName))
                            .addComponent(lblContactNumber)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblGender)
                                    .addComponent(lblEmail))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblinlineUsername)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblgender))))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnManage, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblProfile)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsername)
                    .addComponent(lblinlineUsername))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(lblName)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(lblContactNumber))
                    .addComponent(txtContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(lblEmail))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblgender)
                    .addComponent(lblGender))
                .addGap(18, 18, 18)
                .addComponent(btnManage)
                .addContainerGap())
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
                adm.setEmail(txtEmail.getText());
                adm.validateEmail();
                adm.setContactno(txtContactNo.getText());
                adm.validateContactNo();
                adm.setName(txtName.getText());
                if (adm.getErrormsg().size() > 0){
                    String msg = "";
                    for(String l : adm.getErrormsg()){
                        msg += l + "\n";
                    } 
                    JOptionPane.showMessageDialog(this, msg);
                    adm.clearErroMsg();
                }
                else{
                    if (txtName.getText().length() > 0 && txtEmail.getText().length() > 0 && txtContactNo.getText().length() > 0){
                        String msg =" Username: "+lblinlineUsername.getText()+" \n"+
                            " Name: "+txtName.getText()+" \n"+
                            " Contact Number: "+txtContactNo.getText()+" \n"+
                            " Email: "+txtEmail.getText()+" \n"+
                            " Gender: "+lblgender.getText();
                        int result = JOptionPane.showConfirmDialog(this, msg, "Update Confirmation",JOptionPane.YES_NO_OPTION);
                        if (result == JOptionPane.YES_OPTION){
                            try {
                                adm.UpdateProfile();
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
        new ADMainPage(adm).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(ADMProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ADMProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ADMProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ADMProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ADMProfile().setVisible(true);
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
    private javax.swing.JLabel lblUsername;
    public javax.swing.JLabel lblgender;
    public javax.swing.JLabel lblinlineUsername;
    private javax.swing.JTextField txtContactNo;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
