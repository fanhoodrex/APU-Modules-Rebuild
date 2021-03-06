
import java.awt.Color;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DragonKimchi
 */
public class MakePaymentListMenu extends javax.swing.JFrame {

    /**
     * Creates new form MakePaymentListMenu
     */
    int checkSearch = 0;
    String studID, studName, courseID, courseName, Fees, PaymentStatus;
    
    public MakePaymentListMenu() {
        initComponents();
        this.setLocationRelativeTo(null); // This will display the user interface at the middle
        String x = "SaveFile/StudentCourseRegisted.txt";
        StudentRegisterCourseClass srcc = new StudentRegisterCourseClass();
        srcc.ViewPending(StudentCourseRegisted, x);
        this.getContentPane().setBackground(new Color(245,245,245));
        TableColumnModel tcm = StudentCourseRegisted.getColumnModel();
        tcm.getColumn(0).setPreferredWidth(150);
        tcm.getColumn(1).setPreferredWidth(150);
        tcm.getColumn(2).setPreferredWidth(150);
        tcm.getColumn(3).setPreferredWidth(150);
        tcm.getColumn(4).setPreferredWidth(50);
        tcm.getColumn(5).setPreferredWidth(150);
        ConfirmPayment.setEnabled(false);
    }
    
    String id, fn;
    public void PassVariable(String ID, String fullname)
    {
        id = ID;
        fn = fullname;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Search_text = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        StudentCourseRegisted = new javax.swing.JTable();
        Back = new javax.swing.JToggleButton();
        ConfirmPayment = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Search_text.setText("Search......");
        Search_text.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Search_textMousePressed(evt);
            }
        });
        Search_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Search_textActionPerformed(evt);
            }
        });
        Search_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Search_textKeyReleased(evt);
            }
        });

        StudentCourseRegisted.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Student Name", "Course Code", "Course Name", "Fees", "Payment Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        StudentCourseRegisted.getTableHeader().setReorderingAllowed(false);
        StudentCourseRegisted.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StudentCourseRegistedMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                StudentCourseRegistedMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(StudentCourseRegisted);

        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        ConfirmPayment.setText("Confirm Payment");
        ConfirmPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmPaymentActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Make Payment Menu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ConfirmPayment)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Search_text, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 832, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(297, 297, 297)
                                .addComponent(Back)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Back)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ConfirmPayment)
                    .addComponent(Search_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Search_textMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Search_textMousePressed
        // TODO add your handling code here:
        Search_text.setText("");
    }//GEN-LAST:event_Search_textMousePressed

    private void Search_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Search_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Search_textActionPerformed

    private void Search_textKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Search_textKeyReleased
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel)StudentCourseRegisted.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(table);
        StudentCourseRegisted.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter("(?i)" + Search_text.getText()));

        //infrom that search is trigger
        checkSearch = 1;
    }//GEN-LAST:event_Search_textKeyReleased

    private void StudentCourseRegistedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StudentCourseRegistedMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_StudentCourseRegistedMouseClicked

    private void StudentCourseRegistedMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StudentCourseRegistedMousePressed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)StudentCourseRegisted.getModel();
        int selectedRowIndex = StudentCourseRegisted.getSelectedRow();

        //if got search then the view and the model will not match, use convertRowIndexToModel method to convert the index of the view to the model
        //Eg in view it is 1, model is 6
        if (checkSearch == 1)
        {
            selectedRowIndex = StudentCourseRegisted.convertRowIndexToModel(selectedRowIndex);
            checkSearch = 0;
        }
        
        //String studID, studName, courseID, courseName, Fees, PaymentStatus
        studID = (model.getValueAt(selectedRowIndex, 0).toString());
        studName = (model.getValueAt(selectedRowIndex, 1).toString());
        courseID = (model.getValueAt(selectedRowIndex, 2).toString());
        courseName = (model.getValueAt(selectedRowIndex, 3).toString());
        Fees = (model.getValueAt(selectedRowIndex, 4).toString());
        PaymentStatus = (model.getValueAt(selectedRowIndex, 5).toString());
        
        ConfirmPayment.setEnabled(true);
    }//GEN-LAST:event_StudentCourseRegistedMousePressed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
        dispose();
        AdminMenu am = new AdminMenu(id, fn);
        am.setVisible(true);
    }//GEN-LAST:event_BackActionPerformed

    private void ConfirmPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmPaymentActionPerformed
        // TODO add your handling code here:
//        EditStudentMenu es = new EditStudentMenu();
//        es.setEditStudent(ID, fullname, username, password, contact, email, degreeLevel);
        
        dispose();
        //String user = "Admin";
        ConfirmPaymentMenu cpm = new ConfirmPaymentMenu();
        cpm.setPaymentDetails(studID, studName, courseID, courseName, Fees, PaymentStatus);
        cpm.PassVariable(id, fn);
        cpm.setVisible(true);
    }//GEN-LAST:event_ConfirmPaymentActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MakePaymentListMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MakePaymentListMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MakePaymentListMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MakePaymentListMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MakePaymentListMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Back;
    private javax.swing.JButton ConfirmPayment;
    private javax.swing.JTextField Search_text;
    private javax.swing.JTable StudentCourseRegisted;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
