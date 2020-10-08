package GUI;

import static Classes.CustomCalendarHandler.getThisAndNextWeekAllWeekDay;
import Classes.FileController;
import Classes.Student;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class STDMainPage extends javax.swing.JFrame {
    Student student;
    public STDMainPage() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
    public STDMainPage(Student student) {
        initComponents();
        this.student = student;
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        lblID.setText(student.getUserID());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblid = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        btnLecPro = new javax.swing.JButton();
        btnBookConsHour = new javax.swing.JButton();
        btnViewConsHour = new javax.swing.JButton();
        btnConsultationReport = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student | Main Page");

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

        btnBookConsHour.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnBookConsHour.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/bookcns.png"))); // NOI18N
        btnBookConsHour.setText("Book Consultation Hour");
        btnBookConsHour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookConsHourActionPerformed(evt);
            }
        });

        btnViewConsHour.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnViewConsHour.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/consultation.png"))); // NOI18N
        btnViewConsHour.setText("Manage Consultaion");
        btnViewConsHour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewConsHourActionPerformed(evt);
            }
        });

        btnConsultationReport.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnConsultationReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/report.png"))); // NOI18N
        btnConsultationReport.setText("Consultation Report");
        btnConsultationReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultationReportActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBookConsHour, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLecPro, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnViewConsHour, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnConsultationReport, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(131, 131, 131))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblid)
                                .addGap(57, 57, 57)
                                .addComponent(lblID)
                                .addGap(212, 212, 212)))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblid)
                    .addComponent(lblID))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLecPro)
                    .addComponent(btnViewConsHour))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBookConsHour)
                    .addComponent(btnConsultationReport))
                .addGap(18, 18, 18)
                .addComponent(btnLogout)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLecProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLecProActionPerformed
        new STDProfile(student).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLecProActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        int msg = JOptionPane.showConfirmDialog(this,"Do You want to logout?", "Logout Confirmation", JOptionPane.YES_NO_OPTION);
        if(msg == JOptionPane.YES_OPTION){
            new LoginPage().setVisible(true);
            this.dispose();
        }     
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnViewConsHourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewConsHourActionPerformed
        try {
            int x = 0;
            for (String dte : getThisAndNextWeekAllWeekDay()){
                int[] PKs = {1};
                String[] Vals = {student.getUserID()};
                File f = new File("DATA/Consultation/" + dte + ".txt");
                if (f.exists()){
                    ArrayList<String> dteFile = FileController.ReadFile(f, PKs, Vals);
                    if (dteFile.size() > 0){
                        x = 1;
                    }
                }
            }
            if (x == 1){
                new StudentCancelConsultation(student).setVisible(true);
                this.dispose();    
            }
            else{
                JOptionPane.showMessageDialog(this, "You does not have consultation for this week and next week!\nYou are not allowed to access here!\nPlease book some consultation in order to access this feature!");
            }
        } catch (ParseException | IOException ex) {
            JOptionPane.showMessageDialog(this, "Encounter unexpected error!");
        }
            
    }//GEN-LAST:event_btnViewConsHourActionPerformed

    private void btnBookConsHourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookConsHourActionPerformed
        new StudentManageConsultation(student).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBookConsHourActionPerformed

    private void btnConsultationReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultationReportActionPerformed
        new ViewAllConsultation(student.getUserID()).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnConsultationReportActionPerformed

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
            java.util.logging.Logger.getLogger(STDMainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(STDMainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(STDMainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(STDMainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new STDMainPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBookConsHour;
    private javax.swing.JButton btnConsultationReport;
    private javax.swing.JButton btnLecPro;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnViewConsHour;
    public javax.swing.JLabel lblID;
    private javax.swing.JLabel lblid;
    // End of variables declaration//GEN-END:variables
}
