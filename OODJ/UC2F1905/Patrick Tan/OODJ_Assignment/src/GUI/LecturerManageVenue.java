package GUI;

import Classes.Lecturer;
import Classes.Venue;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class LecturerManageVenue extends javax.swing.JFrame {

    DefaultListModel DefaultVenuejList = new DefaultListModel();
    DefaultListModel UserVenuejList = new DefaultListModel();
    Venue v;
    Lecturer lect;
    public LecturerManageVenue(){
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
    public LecturerManageVenue(Lecturer lect) {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        jButtonAdd.setEnabled(false);
        this.lect = lect;
        this.v = new Venue(lect);
        jListDefaultVenue.setModel(DefaultVenuejList);
        jListUserDefinedVenue.setModel(UserVenuejList);
        initializeUserDefinedVenue();
        initializeDefaultVenue();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jListDefaultVenue = new javax.swing.JList<>();
        jButtonRemove = new javax.swing.JButton();
        jButtonManage = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListUserDefinedVenue = new javax.swing.JList<>();
        jButtonAdd = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Lecturer Manage Venue");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jListDefaultVenue.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jListDefaultVenue.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jListDefaultVenue);

        jButtonRemove.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButtonRemove.setText("Remove");
        jButtonRemove.setEnabled(false);
        jButtonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveActionPerformed(evt);
            }
        });

        jButtonManage.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButtonManage.setText("Manage");
        jButtonManage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonManageActionPerformed(evt);
            }
        });

        jListUserDefinedVenue.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jListUserDefinedVenue.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListUserDefinedVenue.setEnabled(false);
        jScrollPane2.setViewportView(jListUserDefinedVenue);

        jButtonAdd.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButtonAdd.setText("+");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setText("Your preference venue:");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("Default Venue:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(223, 223, 223)
                            .addComponent(jButtonManage, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButtonRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(14, 14, 14)
                            .addComponent(jButtonAdd)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jButtonAdd)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonRemove)
                            .addComponent(jButtonManage))))
                .addGap(4, 4, 4))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void initializeUserDefinedVenue(){
        try {
            if (v.getUserDefinedVenues().isEmpty()){
                JOptionPane.showMessageDialog(this, "Please add at least one preference venue in order to define your consultation slot!");
            }
            else{
                for(String venues : v.getUserDefinedVenues()){
                    UserVenuejList.addElement(venues);
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,"Fail to initialize the user defined venue");
        }
    }
    private void initializeDefaultVenue(){
        try{
            for (String x : v.getDefaultVenues()){
                DefaultVenuejList.addElement(x);
            }
        }
        catch (FileNotFoundException e){
            JOptionPane.showMessageDialog(this, "Fail to initialize venue!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Fail to initialize venue!");
        }
    }
    private void jButtonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveActionPerformed
        int index = jListUserDefinedVenue.getSelectedIndex();
        if (index != -1){
            UserVenuejList.removeElementAt(index);
            if (jListUserDefinedVenue.getModel().getSize() == 0){
                jButtonRemove.setEnabled(false);
            }
        }
        else{
            JOptionPane.showMessageDialog(this,"Please at least select one","Index check",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonRemoveActionPerformed

    private void jButtonManageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonManageActionPerformed
        switch (jButtonManage.getText()){
            case "Manage":
                jListUserDefinedVenue.setEnabled(true);
                jButtonManage.setText("Save");
                jButtonRemove.setEnabled(true);
                jButtonAdd.setEnabled(true);
                break;
            case "Save":
                jButtonAdd.setEnabled(false);
                jListUserDefinedVenue.setEnabled(false);
                jButtonManage.setText("Manage");
                jListUserDefinedVenue.clearSelection();
                jButtonRemove.setEnabled(false);
                if (jListUserDefinedVenue.getModel().getSize() == 0){
                    new File("DATA/Venues/" + lect.getUserID() + "-Venue.txt").delete();
                    JOptionPane.showMessageDialog(this,"You have not defined any venue yet!");
                }
                else{
                    for(int i =0;i<UserVenuejList.size();i++){
                        v.setDefinedVenue(UserVenuejList.getElementAt(i).toString());
                    }
                    try {
                        v.saveDefinedVenue();
                        JOptionPane.showMessageDialog(this, "Successfully updated your preference venue!","Successful Save Venue Message",JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(this,"Fail to save\nPlease try again later!","Saving Failure Message",JOptionPane.ERROR_MESSAGE);
                    }
                }
                break;
        }
    }//GEN-LAST:event_jButtonManageActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        if (jListDefaultVenue.getSelectedIndex() > -1){
            if (!UserVenuejList.contains(jListDefaultVenue.getSelectedValue())){
                UserVenuejList.addElement(jListDefaultVenue.getSelectedValue());
            }
            else{
                JOptionPane.showMessageDialog(this, "No duplicated is allowed","Duplication detection",JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        new LECMainPage(lect).setVisible(true);
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
            java.util.logging.Logger.getLogger(LecturerManageVenue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LecturerManageVenue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LecturerManageVenue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LecturerManageVenue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LecturerManageVenue().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonManage;
    private javax.swing.JButton jButtonRemove;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jListDefaultVenue;
    private javax.swing.JList<String> jListUserDefinedVenue;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
