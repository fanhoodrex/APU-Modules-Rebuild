package GUI;

import Classes.Consultation;
import static Classes.Consultation.saveConsultation;
import static Classes.Lecturer.getNameFromID;
import Classes.CustomCalendarHandler;
import Classes.Lecturer;
import Classes.Slot;
import Classes.Student;
import Classes.Venue;
import Exception.PrimaryKeyNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class StudentCancelConsultation extends javax.swing.JFrame {
    Consultation cl;
    Student student;
    public StudentCancelConsultation(){
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
    public StudentCancelConsultation(Student student){
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.student = student;
        cl = new Consultation(student);
        initializeConsultationtbl();
    }
    private void initializeConsultationtbl(){
        try {
            DefaultTableModel tblConsultation = (DefaultTableModel)jTableConsultation.getModel();
            while (jTableConsultation.getRowCount() > 0){
                tblConsultation.removeRow(0);
            }            
            for(String ConsultationInfos : cl.getStudentCurrentWeekConsultationList()){
                String[] ConsultationInfo = ConsultationInfos.split("\\|\\|");
                Object[] dataRows = {ConsultationInfo[0],ConsultationInfo[3],"30 Minutes",ConsultationInfo[4],ConsultationInfo[1] + " | " + getNameFromID(ConsultationInfo[1]),ConsultationInfo[6]};
                tblConsultation.addRow(dataRows);
                TableRowSorter<TableModel> sorter = new TableRowSorter<>(jTableConsultation.getModel());
                jTableConsultation.setRowSorter(sorter);                
                List<RowSorter.SortKey> sortKeys = new ArrayList<>();
                int columnIndexToSort = 0;              
                sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.DESCENDING));
                sorter.setSortKeys(sortKeys);
                sorter.sort();
            }
            
        } catch (IOException | ParseException ex) {
            JOptionPane.showMessageDialog(this,"Encounter error during initializing the consultation!");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableConsultation = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButtonCancel = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Student overview Consultation History");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTableConsultation.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jTableConsultation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Time", "Session", "Venue", "Lecturer", "Reason"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableConsultation.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableConsultation.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableConsultation);
        if (jTableConsultation.getColumnModel().getColumnCount() > 0) {
            jTableConsultation.getColumnModel().getColumn(0).setMinWidth(110);
            jTableConsultation.getColumnModel().getColumn(0).setMaxWidth(140);
            jTableConsultation.getColumnModel().getColumn(1).setMinWidth(90);
            jTableConsultation.getColumnModel().getColumn(1).setMaxWidth(110);
            jTableConsultation.getColumnModel().getColumn(2).setMinWidth(120);
            jTableConsultation.getColumnModel().getColumn(2).setMaxWidth(140);
            jTableConsultation.getColumnModel().getColumn(3).setMinWidth(110);
            jTableConsultation.getColumnModel().getColumn(3).setMaxWidth(130);
            jTableConsultation.getColumnModel().getColumn(5).setMinWidth(120);
            jTableConsultation.getColumnModel().getColumn(5).setMaxWidth(150);
        }

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setText("You are only allowed to cancel the consultation within this week!");

        jButtonCancel.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("This table only will contain this week and next week consultation history. ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCancel)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        DefaultTableModel tblConsultation = (DefaultTableModel)jTableConsultation.getModel();
        if (jTableConsultation.getSelectedRow() != -1){
            List<Consultation> clList = new ArrayList();
            String LecInfo = String.valueOf(jTableConsultation.getValueAt(jTableConsultation.getSelectedRow(), 4));
            String[] s_LecInfo = LecInfo.split("\\|");
            try {
                if (CustomCalendarHandler.validateDate(tblConsultation.getValueAt(jTableConsultation.convertRowIndexToModel(jTableConsultation.getSelectedRow()), 0).toString()) > 0){
                    cl = new Consultation(new Lecturer(s_LecInfo[0].replace(" ", "")),student,new Slot(tblConsultation.getValueAt(jTableConsultation.convertRowIndexToModel(jTableConsultation.getSelectedRow()), 1).toString()),new Venue(tblConsultation.getValueAt(jTableConsultation.convertRowIndexToModel(jTableConsultation.getSelectedRow()), 3).toString()),tblConsultation.getValueAt(jTableConsultation.convertRowIndexToModel(jTableConsultation.getSelectedRow()), 0).toString());
                    cl.CancelConsultation(student.getUserID());
                    clList.add(cl);
                    student.setConsultationList(clList);
                    if (saveConsultation(student.getConsultationList()).isEmpty()){
                        initializeConsultationtbl();
                        JOptionPane.showMessageDialog(this, "You have successfully cancel the consultation");
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "Fail to cancel the consultation!");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(this, "You can't remove the consultation on that day or after passing the exactly date");
                }
            } catch (ParseException ex) {
               JOptionPane.showMessageDialog(this,"Bad date format!");
            } catch (PrimaryKeyNotFoundException | IOException ex) {
                JOptionPane.showMessageDialog(this,"Encounter error during initializing the information!");
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Please select at least one row record!");
        }
    }//GEN-LAST:event_jButtonCancelActionPerformed

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
            java.util.logging.Logger.getLogger(StudentCancelConsultation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentCancelConsultation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentCancelConsultation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentCancelConsultation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentCancelConsultation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableConsultation;
    // End of variables declaration//GEN-END:variables
}
