package GUI;

import Classes.Admin;
import Classes.Lecturer;
import java.io.IOException;
import javax.swing.JOptionPane;

public class LECRegister extends javax.swing.JFrame {
    Admin adm;
    public LECRegister() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
    public LECRegister(Admin adm) {
        initComponents();
        this.adm = adm;
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        lblRetypePass = new javax.swing.JLabel();
        lblContactno = new javax.swing.JLabel();
        txtContactNo = new javax.swing.JTextField();
        lblSpecialized = new javax.swing.JLabel();
        txtSpecialized = new javax.swing.JTextField();
        lblGender = new javax.swing.JLabel();
        rdbMale = new javax.swing.JRadioButton();
        rdbFemale = new javax.swing.JRadioButton();
        btnRegister = new javax.swing.JButton();
        lblName = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        txtRetyPass = new javax.swing.JPasswordField();
        lblRequirementGuide = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Lecturer Registration");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        lblTitle.setText("Lecturer Register");

        lblUsername.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUsername.setText("Username: ");

        lblPassword.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblPassword.setText("Password:");

        lblRetypePass.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblRetypePass.setText("Retype Password:");

        lblContactno.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblContactno.setText("Contact Number:");

        lblSpecialized.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblSpecialized.setText("Specialized:");

        lblGender.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblGender.setText("Gender:");

        rdbMale.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rdbMale.setText("Male");

        rdbFemale.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rdbFemale.setText("Female");

        btnRegister.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        lblName.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblName.setText("Name:");

        lblEmail.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblEmail.setText("Email:");

        lblRequirementGuide.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblRequirementGuide.setText("<html><p style=\"color:red;\">Registration Policy:<br/> The length of username is 8 to 15 while the initial value of<br/>the username must be alphabet, it can be uppercase or lowercase.<br/>The subsequent value can be alphabet and numerical<br/>but special character is not allowed.<br/> The minimum length of password must be 10,it accepts any<br/>alphabets and special character included any spaces.<br/> The maximum number of contact number is 10 digit.</p></html>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPassword)
                    .addComponent(lblUsername)
                    .addComponent(lblRetypePass)
                    .addComponent(lblSpecialized)
                    .addComponent(lblGender)
                    .addComponent(lblName)
                    .addComponent(lblEmail)
                    .addComponent(lblContactno))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rdbMale)
                        .addGap(51, 51, 51)
                        .addComponent(rdbFemale))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtSpecialized, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                        .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtContactNo, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtName, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtRetyPass, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtUsername, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblRequirementGuide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addGap(128, 128, 128))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnRegister)
                        .addGap(130, 130, 130))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRequirementGuide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRetypePass)
                    .addComponent(txtRetyPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContactno)
                    .addComponent(txtContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSpecialized)
                    .addComponent(txtSpecialized, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGender)
                    .addComponent(rdbMale)
                    .addComponent(rdbFemale))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegister)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        Lecturer LECT = new Lecturer();
        LECT.setUsername(txtUsername.getText());
        LECT.validateUsername();
        LECT.setPassword(String.valueOf(txtPassword.getPassword()));
        LECT.validatePassword();
        LECT.setEmail(txtEmail.getText());
        LECT.validateEmail();
        LECT.setContactno(txtContactNo.getText());
        LECT.validateContactNo();
        if (LECT.getErrormsg().size() > 0){
            String msg = "";
            for(String l : LECT.getErrormsg()){
                msg += l + "\n";
            } 
            JOptionPane.showMessageDialog(this, msg);
            LECT.clearErroMsg();
        }
        else{
            try {
                if (txtUsername.getText().length() > 0 && txtPassword.getPassword().length > 0 && txtRetyPass.getPassword().length > 0 && txtEmail.getText().length() > 0 && txtName.getText().length() > 0 && txtContactNo.getText().length() > 0 && txtSpecialized.getText().length() > 0){
                    if(LECT.checkUniqueusername()==true){
                        if(String.valueOf(txtPassword.getPassword()).equals(String.valueOf(txtRetyPass.getPassword()))){
                            LECT.setUsername(txtUsername.getText());
                            LECT.setPassword(String.valueOf(txtPassword.getPassword()));
                            LECT.setEmail(txtEmail.getText());
                            LECT.setContactno(txtContactNo.getText());
                            LECT.setName(txtName.getText());
                            LECT.setSpecialized(txtSpecialized.getText());
                            String gender;
                            if(rdbMale.isSelected()){
                                gender = "Male";
                            }
                            else{
                                gender = "Female";
                            }
                            if(!gender.isEmpty()){
                                LECT.setGender(gender);
                                try{
                                    if(LECT.register() == true){
                                        JOptionPane.showMessageDialog(this, "You are successfully register!");
                                        txtUsername.setText("");
                                        txtPassword.setText("");
                                        txtRetyPass.setText("");
                                        txtName.setText("");
                                        txtContactNo.setText("");
                                        txtEmail.setText("");
                                        txtSpecialized.setText("");
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(this, "Sorry, the registration is not saved!\nPlease try again later!");
                                    }
                                }
                                catch(IOException e){
                                    JOptionPane.showMessageDialog(this,"Encounter error during validating the information!");
                                }  
                            }
                            else{
                                JOptionPane.showMessageDialog(this, "Please select one gender!");
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(this, "Password and Retype-Password are not same!");
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "Your Username is already used! Please retype your Username again!");
                        txtUsername.setText("");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(this,"Please fill in all the text field!");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,"Fail to validate the unique username!");
            }    
        }
    }//GEN-LAST:event_btnRegisterActionPerformed

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
            java.util.logging.Logger.getLogger(LECRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LECRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LECRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LECRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LECRegister().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel lblContactno;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblRequirementGuide;
    private javax.swing.JLabel lblRetypePass;
    private javax.swing.JLabel lblSpecialized;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JRadioButton rdbFemale;
    private javax.swing.JRadioButton rdbMale;
    private javax.swing.JTextField txtContactNo;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtRetyPass;
    private javax.swing.JTextField txtSpecialized;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
