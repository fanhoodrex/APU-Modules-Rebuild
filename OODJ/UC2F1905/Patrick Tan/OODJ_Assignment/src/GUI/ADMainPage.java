package GUI;

import Classes.Admin;
import javax.swing.JOptionPane;

public class ADMainPage extends javax.swing.JFrame {
    Admin admin;
    public ADMainPage() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
    public ADMainPage(Admin admin) {
        initComponents();
        lblID.setText(admin.getUserID());
        this.admin = admin;
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblid = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        btnLecPro = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnSTDreg = new javax.swing.JButton();
        btnLECreg = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin | Main Page");

        lblid.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblid.setText("ID:");

        lblID.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblID.setText("(ID)");

        btnLecPro.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnLecPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/profile.png"))); // NOI18N
        btnLecPro.setText("Profile");
        btnLecPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLecProActionPerformed(evt);
            }
        });

        btnLogout.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logout.png"))); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnSTDreg.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnSTDreg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/student.png"))); // NOI18N
        btnSTDreg.setText("Student Register");
        btnSTDreg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSTDregActionPerformed(evt);
            }
        });

        btnLECreg.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnLECreg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/lecturer.png"))); // NOI18N
        btnLECreg.setText("Lecturer Register");
        btnLECreg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLECregActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnLecPro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSTDreg, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLECreg, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnLogout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblid)
                        .addGap(57, 57, 57)
                        .addComponent(lblID)
                        .addGap(227, 227, 227))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblid)
                    .addComponent(lblID))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLecPro)
                        .addGap(18, 18, 18)
                        .addComponent(btnSTDreg))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLECreg)
                        .addGap(18, 18, 18)
                        .addComponent(btnLogout)))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        int msg = JOptionPane.showConfirmDialog(this,"Do You want to logout?", "Logout Confirmation", JOptionPane.YES_NO_OPTION);
        if(msg == JOptionPane.YES_OPTION){
            new LoginPage().setVisible(true);
            this.dispose();
        }     
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnLecProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLecProActionPerformed
        new ADMProfile(admin).setVisible(true);
        this.dispose();              
    }//GEN-LAST:event_btnLecProActionPerformed

    private void btnSTDregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSTDregActionPerformed
        new STDRegister(admin).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSTDregActionPerformed

    private void btnLECregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLECregActionPerformed
        new LECRegister(admin).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLECregActionPerformed

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
            java.util.logging.Logger.getLogger(ADMainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ADMainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ADMainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ADMainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ADMainPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLECreg;
    private javax.swing.JButton btnLecPro;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnSTDreg;
    public javax.swing.JLabel lblID;
    private javax.swing.JLabel lblid;
    // End of variables declaration//GEN-END:variables
}
