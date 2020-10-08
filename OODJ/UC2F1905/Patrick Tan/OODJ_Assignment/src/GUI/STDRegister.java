package GUI;

import Classes.Admin;
import Classes.Student;
import java.io.IOException;
import javax.swing.JOptionPane;

public class STDRegister extends javax.swing.JFrame {
    Admin adm;
    public STDRegister() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
    public STDRegister(Admin adm){
        initComponents();
        this.adm = adm;
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblContactno = new javax.swing.JLabel();
        txtContactNo = new javax.swing.JTextField();
        lblIntakeCode = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        txtIntakeCode = new javax.swing.JTextField();
        lblGender = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        rdbMale = new javax.swing.JRadioButton();
        rdbFemale = new javax.swing.JRadioButton();
        lblPassword = new javax.swing.JLabel();
        btnRegister = new javax.swing.JButton();
        lblRetypePass = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        txtRetypePass = new javax.swing.JPasswordField();
        jLabelRegistrationRequirement = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Student Registration");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblContactno.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblContactno.setText("Contact Number:");

        lblIntakeCode.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblIntakeCode.setText("Intake Code:");

        lblTitle.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblTitle.setText("Student Register");

        lblGender.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblGender.setText("Gender:");

        lblUsername.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUsername.setText("Username: ");

        rdbMale.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rdbMale.setText("Male");

        rdbFemale.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        rdbFemale.setText("Female");

        lblPassword.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblPassword.setText("Password:");

        btnRegister.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        lblRetypePass.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblRetypePass.setText("Retype Password:");

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setText("Email: ");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("Name:");

        jLabelRegistrationRequirement.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabelRegistrationRequirement.setText("<html><p style=\"color:red;\">Registration Policy:<br/> The length of username is 8 to 15 while the initial value of<br/>the username must be alphabet, it can be uppercase or lowercase.<br/>The subsequent value can be alphabet and numerical<br/>but special character is not allowed.<br/> The minimum length of password must be 10,it accepts any<br/>alphabets and special character included any spaces.<br/> The maximum number of contact number is 10 digit.</p></html>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(lblPassword)
                    .addComponent(lblUsername)
                    .addComponent(lblRetypePass)
                    .addComponent(lblContactno)
                    .addComponent(lblIntakeCode)
                    .addComponent(lblGender))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rdbMale)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(rdbFemale))
                    .addComponent(txtIntakeCode)
                    .addComponent(txtContactNo)
                    .addComponent(txtUsername)
                    .addComponent(txtEmail)
                    .addComponent(txtName)
                    .addComponent(txtPassword)
                    .addComponent(txtRetypePass))
                .addGap(66, 66, 66))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnRegister)
                        .addGap(103, 103, 103))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelRegistrationRequirement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addGap(111, 111, 111))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addComponent(jLabelRegistrationRequirement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(txtRetypePass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContactno)
                    .addComponent(txtContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIntakeCode)
                    .addComponent(txtIntakeCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGender)
                    .addComponent(rdbMale)
                    .addComponent(rdbFemale))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegister)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        Student STD = new Student();
        STD.setUsername(txtUsername.getText());
        STD.validateUsername();
        STD.setPassword(String.valueOf(txtPassword.getPassword()));
        STD.validatePassword();
        STD.setEmail(txtEmail.getText());
        STD.validateEmail();
        STD.setContactno(txtContactNo.getText());
        STD.validateContactNo();
        if (STD.getErrormsg().size() > 0){
            String msg = "";
            for(String l : STD.getErrormsg()){
                msg += l + "\n";
            } 
            JOptionPane.showMessageDialog(this, msg);
            STD.clearErroMsg();
        }
        else{
            try {
                if (txtUsername.getText().length() > 0 && txtPassword.getPassword().length > 0 && txtRetypePass.getPassword().length > 0 && txtContactNo.getText().length() > 0 && txtName.getText().length() > 0 && txtEmail.getText().length() > 0 && txtIntakeCode.getText().length() > 0){
                    if(STD.checkUniqueusername()==true){
                        if(String.valueOf(txtPassword.getPassword()).equals(String.valueOf(txtRetypePass.getPassword()))){
                            STD.setUsername(txtUsername.getText());
                            STD.setPassword(String.valueOf(txtPassword.getPassword()));
                            STD.setEmail(txtEmail.getText());
                            STD.setContactno(txtContactNo.getText());
                            STD.setName(txtName.getText());
                            STD.setIntakeCode(txtIntakeCode.getText());
                            String gender;
                            if(rdbMale.isSelected()){
                                gender = "Male";
                            }
                            else{
                                gender = "Female";
                            }
                            if(!gender.isEmpty()){
                                STD.setGender(gender);
                                try{
                                    if(STD.register() == true){
                                        JOptionPane.showMessageDialog(this, "You are successfully register!");
                                        txtUsername.setText("");
                                        txtPassword.setText("");
                                        txtRetypePass.setText("");
                                        txtName.setText("");
                                        txtContactNo.setText("");
                                        txtEmail.setText("");
                                        txtIntakeCode.setText("");
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(this, "You are register fail!");
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
                        txtUsername.setText("");
                        JOptionPane.showMessageDialog(this, "Your Username is already used! Please retype your Username again!");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(this, "You are required to completed all the empty field!");
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
            java.util.logging.Logger.getLogger(STDRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(STDRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(STDRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(STDRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new STDRegister().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelRegistrationRequirement;
    private javax.swing.JLabel lblContactno;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblIntakeCode;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblRetypePass;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JRadioButton rdbFemale;
    private javax.swing.JRadioButton rdbMale;
    private javax.swing.JTextField txtContactNo;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIntakeCode;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtRetypePass;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
