package GUI;

import Classes.Student;
import java.io.IOException;
import javax.swing.JOptionPane;

public class STDProfile extends javax.swing.JFrame {
    Student std;
    public STDProfile(){
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
    public STDProfile(Student std) {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.std = std;
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
        txtIntakecode.setEnabled(inlineComponent);
        txtContactNo.setEnabled(inlineComponent);
    }
    private void inline_initializeProfile(){
        try {
            if(std.InitializeProfile() == true){
                lblinlineUsername.setText(std.getUsername());
                txtName.setText(std.getName());
                txtEmail.setText(std.getEmail());
                txtIntakecode.setText(std.getIntakeCode());
                txtContactNo.setText(std.getContactno());
                lblgender.setText(std.getGender());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Fail to initialize profile!");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblGender = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblContactNumber = new javax.swing.JLabel();
        lblProfile = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblIntakeCode = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtContactNo = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtIntakecode = new javax.swing.JTextField();
        lblinlineUsername = new javax.swing.JLabel();
        lblgender = new javax.swing.JLabel();
        btnManage = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Manage Profile");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblGender.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblGender.setText("Gender:");

        lblName.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblName.setText("Name:");

        lblContactNumber.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblContactNumber.setText("Contact Number:");

        lblProfile.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblProfile.setText("My Profile");

        lblEmail.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblEmail.setText("Email:");

        lblUsername.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUsername.setText("Username:");

        lblIntakeCode.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblIntakeCode.setText("Intake Code:");

        lblinlineUsername.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblinlineUsername.setText("(Username)");

        lblgender.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblgender.setText("(Gender)");

        btnManage.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnManage.setText("Manage");
        btnManage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblName)
                            .addComponent(lblUsername))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblinlineUsername)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblIntakeCode)
                            .addComponent(lblEmail)
                            .addComponent(lblContactNumber)
                            .addComponent(lblGender))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                .addComponent(txtIntakecode)
                                .addComponent(txtContactNo))
                            .addComponent(lblgender))))
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblProfile)
                        .addGap(91, 91, 91))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnManage, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblProfile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblinlineUsername))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblName))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblContactNumber))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIntakeCode)
                    .addComponent(txtIntakecode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblgender)
                    .addComponent(lblGender))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                std.setEmail(txtEmail.getText());
                std.validateEmail();
                std.setContactno(txtContactNo.getText());
                std.validateContactNo();
                std.setName(txtName.getText());
                std.setContactno(txtContactNo.getText());
                std.setEmail(txtEmail.getText());
                std.setIntakeCode(txtIntakecode.getText());
                if (std.getErrormsg().size() > 0){
                    String msg = "";
                    for(String l : std.getErrormsg()){
                        msg += l + "\n";
                    } 
                    JOptionPane.showMessageDialog(this, msg);
                    std.clearErroMsg();
                }
                else{
                    if (txtContactNo.getText().length() > 0 && txtName.getText().length() > 0 && txtEmail.getText().length() > 0 && txtIntakecode.getText().length() > 0){
                        String msg =" Username: "+lblinlineUsername.getText()+" \n"+
                            " Name: "+txtName.getText()+" \n"+
                            " Contact Number: "+txtContactNo.getText()+" \n"+
                            " Email: "+txtEmail.getText()+" \n"+
                            " Intake Code: "+ txtIntakecode.getText()+" \n"+
                            " Gender: "+lblgender.getText();
                        int result = JOptionPane.showConfirmDialog(this, msg, "Update Confirmation",JOptionPane.YES_NO_OPTION);
                        if (result == JOptionPane.YES_OPTION){
                            try {
                                std.UpdateProfile();
                                btnManage.setText("Manage");
                                initializeDefaultComponent(false);
                                JOptionPane.showMessageDialog(this, "You have successfully updated your profile!");
                            } catch (IOException ex) {
                                JOptionPane.showMessageDialog(this, "The changes is not saved!\nPlease try again later!");
                            } 
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "You are required to completed all the empty field!");
                    }
                }
                break;
        }
    }//GEN-LAST:event_btnManageActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        new STDMainPage(std).setVisible(true);
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
            java.util.logging.Logger.getLogger(STDProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(STDProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(STDProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(STDProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new STDProfile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnManage;
    private javax.swing.JLabel lblContactNumber;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblIntakeCode;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblProfile;
    private javax.swing.JLabel lblUsername;
    public javax.swing.JLabel lblgender;
    public javax.swing.JLabel lblinlineUsername;
    private javax.swing.JTextField txtContactNo;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIntakecode;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
