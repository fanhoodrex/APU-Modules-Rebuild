package GUI;

import Classes.Consultation;
import Classes.Lecturer;
import Classes.Slot;
import Classes.Student;
import Classes.Venue;
import Exception.PrimaryKeyNotFoundException;
import Exception.UnauthorizationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class StudentManageConsultation extends javax.swing.JFrame {
    Student student;
    Consultation cl;
    public StudentManageConsultation(){
        initializeLectList();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
    public StudentManageConsultation(Student student) {
        initComponents();
        this.student = student;
        cl = new Consultation(student);
        initializeLectList();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        jButtonConfirmConsultation.setEnabled(false);
        jButtonRemoveConfirmConsultation.setEnabled(false);
        jButtonAddConsultation.setEnabled(false);
    }
    private void initializeLectList(){
        jComboBoxLecturerName.addItem("--");
        try {
            for (String lectList : student.getLecList()){
                jComboBoxLecturerName.addItem(lectList);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }
        public boolean existsInTable(JTable table, Object[] entry) {
        int rowCount = table.getRowCount();
        int colCount = table.getColumnCount();
        String curEntry = "";
        for (Object o : entry) {
            String e = o.toString();
            curEntry = curEntry + " " + e;
        }
        for (int i = 0; i < rowCount; i++) {
            String rowEntry = "";
            for (int j = 0; j < colCount; j++)
                rowEntry = rowEntry + " " + table.getValueAt(i, j).toString();
            if (rowEntry.equalsIgnoreCase(curEntry)) {
                return true;
            }
        }
        return false;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBoxLecturerName = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButtonAddConsultation = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAvailableConsultation = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableConfirmConsultation = new javax.swing.JTable();
        jButtonConfirmConsultation = new javax.swing.JButton();
        jButtonRemoveConfirmConsultation = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Student Book Consultation");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jComboBoxLecturerName.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jComboBoxLecturerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxLecturerNameActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setText("Lecturer:");

        jButtonAddConsultation.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButtonAddConsultation.setText("Add");
        jButtonAddConsultation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddConsultationActionPerformed(evt);
            }
        });

        jTableAvailableConsultation.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jTableAvailableConsultation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Time", "Session", "Venue"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableAvailableConsultation.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableAvailableConsultation.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableAvailableConsultation);

        jTableConfirmConsultation.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jTableConfirmConsultation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Time", "Lecturer", "Session", "Venue", "Reason"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableConfirmConsultation.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableConfirmConsultation.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTableConfirmConsultation);
        if (jTableConfirmConsultation.getColumnModel().getColumnCount() > 0) {
            jTableConfirmConsultation.getColumnModel().getColumn(0).setMinWidth(120);
            jTableConfirmConsultation.getColumnModel().getColumn(0).setMaxWidth(150);
            jTableConfirmConsultation.getColumnModel().getColumn(1).setMinWidth(100);
            jTableConfirmConsultation.getColumnModel().getColumn(1).setMaxWidth(120);
            jTableConfirmConsultation.getColumnModel().getColumn(3).setMinWidth(100);
            jTableConfirmConsultation.getColumnModel().getColumn(3).setMaxWidth(120);
            jTableConfirmConsultation.getColumnModel().getColumn(4).setMinWidth(110);
            jTableConfirmConsultation.getColumnModel().getColumn(4).setMaxWidth(150);
            jTableConfirmConsultation.getColumnModel().getColumn(5).setMinWidth(150);
            jTableConfirmConsultation.getColumnModel().getColumn(5).setMaxWidth(180);
        }

        jButtonConfirmConsultation.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButtonConfirmConsultation.setText("Confirm");
        jButtonConfirmConsultation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmConsultationActionPerformed(evt);
            }
        });

        jButtonRemoveConfirmConsultation.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButtonRemoveConfirmConsultation.setText("Remove");
        jButtonRemoveConfirmConsultation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveConfirmConsultationActionPerformed(evt);
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
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxLecturerName, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 513, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 915, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonAddConsultation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButtonRemoveConfirmConsultation, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonConfirmConsultation, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxLecturerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAddConsultation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConfirmConsultation)
                    .addComponent(jButtonRemoveConfirmConsultation))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxLecturerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxLecturerNameActionPerformed
        DefaultTableModel tblAvailableConsultation = (DefaultTableModel)jTableAvailableConsultation.getModel();
        while (tblAvailableConsultation.getRowCount() > 0){
            tblAvailableConsultation.removeRow(0);
        }
        if (!jComboBoxLecturerName.getSelectedItem().toString().equals("--")){
            try {
                String cmbIdentity = jComboBoxLecturerName.getSelectedItem().toString();
                String[] s_cmbIdentity = cmbIdentity.split("\\|");
                ArrayList<String> clLists = cl.getAvailableConsultationList(s_cmbIdentity[0].replace(" ",""));
                if (clLists.isEmpty()){
                    JOptionPane.showMessageDialog(this, "This lecturer temporarily don't have any available consultation at the moment!");
                }
                else{
                    for (String clList : clLists){
                        String[] s_clList = clList.split("\\|\\|");
                        Object[] dataRows = {s_clList[0],s_clList[3],"30 Minutes",s_clList[4]};
                        tblAvailableConsultation.addRow(dataRows);
                    }
                    jButtonAddConsultation.setEnabled(true);
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Fail to read the file!");
            }
        }
    }//GEN-LAST:event_jComboBoxLecturerNameActionPerformed

    private void jButtonAddConsultationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddConsultationActionPerformed
        DefaultTableModel tblAvailableConsultation = (DefaultTableModel)jTableAvailableConsultation.getModel();
        DefaultTableModel tblConfirmConsultation = (DefaultTableModel)jTableConfirmConsultation.getModel();
        if (jTableAvailableConsultation.getSelectedRow() != -1){            
            Object[] selectedConsultation = {tblAvailableConsultation.getValueAt(jTableAvailableConsultation.getSelectedRow(),0),tblAvailableConsultation.getValueAt(jTableAvailableConsultation.getSelectedRow(),1),jComboBoxLecturerName.getSelectedItem().toString(),tblAvailableConsultation.getValueAt(jTableAvailableConsultation.getSelectedRow(),2),tblAvailableConsultation.getValueAt(jTableAvailableConsultation.getSelectedRow(),3),"--"};
            if (existsInTable(jTableConfirmConsultation,selectedConsultation) == false){
                tblConfirmConsultation.addRow(selectedConsultation);
                String[] selection = {"Assignment","Tutorial","FYP","Others"};
                JComboBox combo = new JComboBox<>(selection);
                TableColumn col = jTableConfirmConsultation.getColumnModel().getColumn(5);
                col.setCellEditor(new DefaultCellEditor(combo));
                jButtonConfirmConsultation.setEnabled(true);
                jButtonRemoveConfirmConsultation.setEnabled(true);
            }
            else{
                JOptionPane.showMessageDialog(this, "You have added this consultation in your confirmation table!\nPlease try other!");
            }  
        }
        else{
            JOptionPane.showMessageDialog(this, "Please select at least one row records!");
        }
    }//GEN-LAST:event_jButtonAddConsultationActionPerformed

    private void jButtonRemoveConfirmConsultationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveConfirmConsultationActionPerformed
        DefaultTableModel tblConfirmConsultation = (DefaultTableModel)jTableConfirmConsultation.getModel();
        if (jTableConfirmConsultation.getSelectedRow() != -1){
            tblConfirmConsultation.removeRow(jTableConfirmConsultation.getSelectedRow());
        }
        else{
            JOptionPane.showMessageDialog(this, "Please select at least one row records!");
        }
        if (tblConfirmConsultation.getRowCount() == 0){
            jButtonConfirmConsultation.setEnabled(false);
            jButtonRemoveConfirmConsultation.setEnabled(false);
        }
    }//GEN-LAST:event_jButtonRemoveConfirmConsultationActionPerformed

    private void jButtonConfirmConsultationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmConsultationActionPerformed
        DefaultTableModel tblConfirmConsultation = (DefaultTableModel)jTableConfirmConsultation.getModel();
        List<Consultation> clList = new ArrayList();
        for(int i =0;i<jTableConfirmConsultation.getRowCount();i++){
            String cmbIdentity = tblConfirmConsultation.getValueAt(i,2).toString();
            String[] s_cmbIdentity = cmbIdentity.split("\\|");
            cl = new Consultation(student,new Lecturer(s_cmbIdentity[0].replace(" ","")),new Slot(tblConfirmConsultation.getValueAt(i,1).toString()),new Venue(tblConfirmConsultation.getValueAt(i,4).toString()),tblConfirmConsultation.getValueAt(i,0).toString());
            try {
                cl.BookConsultation(tblConfirmConsultation.getValueAt(i,5).toString());
                clList.add(cl);
                student.setConsultationList(clList);
            } catch (PrimaryKeyNotFoundException | IOException | UnauthorizationException ex) {
                JOptionPane.showMessageDialog(this,ex.getMessage());
            }
        }
        try {
            if (Consultation.saveConsultation(clList).isEmpty()){
                jComboBoxLecturerName.setSelectedIndex(0);
                while (jTableConfirmConsultation.getRowCount() > 0){
                    tblConfirmConsultation.removeRow(0);
                }
                jComboBoxLecturerName.setSelectedIndex(0);
                jButtonConfirmConsultation.setEnabled(false);
                jButtonRemoveConfirmConsultation.setEnabled(false);
                JOptionPane.showMessageDialog(this, "You have successfully book the consultation!");
            }
            else{
                String error_msg = "You have fail to book the consultation slot as shown below\n";
                for(Consultation FailtoBookConsultationList : Consultation.saveConsultation(clList)){
                    String[] s_FailtoBookConsultationList = FailtoBookConsultationList.toString().split("\\|\\|");
                    error_msg +=  "Date: " + s_FailtoBookConsultationList[0] + ", Lecturer ID:" + s_FailtoBookConsultationList[1] + "Slot and Venue: " + s_FailtoBookConsultationList[3] + " & " + s_FailtoBookConsultationList[4] + "\n";
                }
                error_msg += "Please again later";
                JOptionPane.showMessageDialog(this, error_msg);
            }
        }catch (IOException | PrimaryKeyNotFoundException ex) {
            JOptionPane.showMessageDialog(this,ex.getMessage());
        }
    }//GEN-LAST:event_jButtonConfirmConsultationActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        new STDMainPage(student).setVisible(true);
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
            java.util.logging.Logger.getLogger(StudentManageConsultation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentManageConsultation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentManageConsultation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentManageConsultation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentManageConsultation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddConsultation;
    private javax.swing.JButton jButtonConfirmConsultation;
    private javax.swing.JButton jButtonRemoveConfirmConsultation;
    private javax.swing.JComboBox<String> jComboBoxLecturerName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableAvailableConsultation;
    private javax.swing.JTable jTableConfirmConsultation;
    // End of variables declaration//GEN-END:variables

}
