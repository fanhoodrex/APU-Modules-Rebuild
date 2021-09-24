package GUI;

import Classes.FileController;
import Classes.Lecturer;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class LECMainPage extends javax.swing.JFrame {
    Lecturer lect;
    public LECMainPage() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
    public LECMainPage(Lecturer lect) {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.lect = lect;
        lblID.setText(lect.getUserID());
    }
    private boolean CheckAvailableConsultationSlot() throws IOException{
        File dir = new File("DATA/Consultation");
        int i = 0;
        boolean success = false;
        for (File file : dir.listFiles()){
            int PKs[] = {0};
            String[] Vals = {lect.getUserID()};
            ArrayList<String> ContainsConsultation = FileController.ReadFile(new File(file.toString()), PKs, Vals);
            if (ContainsConsultation.size() > 0){
                i++;
            }
        }
        if (i > 0){
            success = true;
        }
        return success;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblid = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        btnLecPro = new javax.swing.JButton();
        btnConsVenue = new javax.swing.JButton();
        btnManageCons = new javax.swing.JButton();
        btnConsReport = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lecturer | Main Page");

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

        btnConsVenue.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnConsVenue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/venue.png"))); // NOI18N
        btnConsVenue.setText("Consultation Venue");
        btnConsVenue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsVenueActionPerformed(evt);
            }
        });

        btnManageCons.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnManageCons.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/consultation.png"))); // NOI18N
        btnManageCons.setText("Manage Consultation");
        btnManageCons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageConsActionPerformed(evt);
            }
        });

        btnConsReport.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnConsReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/report.png"))); // NOI18N
        btnConsReport.setText("Consultation Report");
        btnConsReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsReportActionPerformed(evt);
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
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblid)
                        .addGap(57, 57, 57)
                        .addComponent(lblID)
                        .addGap(207, 207, 207))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnConsVenue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLecPro, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnManageCons)
                                    .addComponent(btnConsReport, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(120, 120, 120)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblid)
                    .addComponent(lblID))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLecPro)
                    .addComponent(btnManageCons))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsVenue)
                    .addComponent(btnConsReport))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLogout)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLecProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLecProActionPerformed
        new LECProfile(lect).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLecProActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        int msg = JOptionPane.showConfirmDialog(this,"Are you sure to logout?", "Logout Confirmation", JOptionPane.YES_NO_OPTION);
        if(msg == JOptionPane.YES_OPTION){
            this.dispose();
            new LoginPage().setVisible(true);
        }     
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnManageConsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageConsActionPerformed
        File venueFile = new File("DATA/Venues/" + lect.getUserID() + "-Venue.txt");
        if (venueFile.exists()){
            new LecturerManageConsultation(lect).setVisible(true);
            this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(this, "You currently don't have any user defined venue!\nPlease add some venue first before proceed to the define consultation!");
        }
            
    }//GEN-LAST:event_btnManageConsActionPerformed

    private void btnConsVenueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsVenueActionPerformed
        new LecturerManageVenue(lect).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnConsVenueActionPerformed

    private void btnConsReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsReportActionPerformed
        try {
            if (CheckAvailableConsultationSlot()){
                new ViewAllConsultation(lect.getUserID()).setVisible(true);
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(this, "You have not had any consultation at the moment!\nPlease check back when you have defined the consultation!","Bad consultation report request",JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "IO Exception!");
        }
    }//GEN-LAST:event_btnConsReportActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LECMainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LECMainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LECMainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LECMainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LECMainPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsReport;
    private javax.swing.JButton btnConsVenue;
    private javax.swing.JButton btnLecPro;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnManageCons;
    public javax.swing.JLabel lblID;
    private javax.swing.JLabel lblid;
    // End of variables declaration//GEN-END:variables
}
