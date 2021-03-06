/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OCRS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author BryanL
 */
public class Stud_vProfile extends javax.swing.JFrame {

    /**
     * Creates new form Stud_vProfile
     */
    public Stud_vProfile() {
        initComponents();
    }
    public Stud_vProfile(String uname) {
        initComponents();
        String[] temp;
        try{
            FileReader fr = new FileReader("Student_Profile_DB.txt");
            BufferedReader br = new BufferedReader(fr);
            String reader;
            reader = br.readLine();
            while (reader.length() != 0) {
                temp = reader.split(",");
                if (uname.equals(temp[4])) {
                    name_lbl.setText(temp[0]);
                    id_lbl.setText(temp[1]);
                    degree_lbl.setText(temp[2]);
                    lvl_lbl.setText(temp[3]);
                    usr_lbl.setText(uname);
                    br.close();
                    fr.close();                    
                    break;
                }
                reader = br.readLine();
                if ("testnull".equals(reader)){
                    System.out.println("This should not occur, only to handle NullPointerException.");
                }
                else{
                    if(reader == null){
                        br.close();
                        fr.close();                        
                        break;
                    }
                }                
            }
            FileWriter fw = new FileWriter("Enrollment_List.txt", true);
            FileReader fr2 = new FileReader ("Enrollment_List.txt");
            BufferedReader br2 = new BufferedReader(fr2);
            reader = br2.readLine();
            int i = 0, j = 0;
            if ("testnull".equals(reader)){
                System.out.println("This should not occur, only to handle NullPointerException.");
            }
            else{
                if (reader == null){
                    br2.close();
                    fr2.close();
                    fw.close();
                    return;
                }
                else{
                    while (reader.length() != 0) {
                        temp = reader.split(",");
                        if (uname.equals(temp[0])) {
                            course_t.setValueAt(temp[1], i, j);
                            course_t.setValueAt(temp[2], i, j+1);
                            i++;
                        }
                        reader = br2.readLine();
                        if ("testnull".equals(reader)){
                            System.out.println("This should not occur, only to handle NullPointerException.");
                        }
                        else if(reader == null){
                            br2.close();
                            fr2.close();
                            fw.close();
                            break;
                        }                
                    }
                }
            }
        } catch (Exception f) {
            JOptionPane.showMessageDialog(null, "System error " + f);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        man_b = new javax.swing.JButton();
        cancel_b = new javax.swing.JButton();
        name_lbl = new javax.swing.JLabel();
        id_lbl = new javax.swing.JLabel();
        degree_lbl = new javax.swing.JLabel();
        lvl_lbl = new javax.swing.JLabel();
        usr_lbl = new javax.swing.JLabel();
        resetp_b = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        course_t = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel1.setText("M Y   P R O F I L E ");

        jLabel10.setText("Level:");

        jLabel2.setText("Name:");

        jLabel3.setText("ID:");

        jLabel4.setText("Degree:");

        jLabel6.setText("Username:");

        man_b.setText("Edit");
        man_b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                man_bActionPerformed(evt);
            }
        });

        cancel_b.setText("Back");
        cancel_b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_bActionPerformed(evt);
            }
        });

        name_lbl.setText("(Name will be replaced here)");

        id_lbl.setText("(ID will be replaced here)");

        degree_lbl.setText("(Degree will be replaced here)");

        lvl_lbl.setText("(Level will be replaced here)");

        usr_lbl.setText("(Username will be replaced here)");

        resetp_b.setText("Reset Password");
        resetp_b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetp_bActionPerformed(evt);
            }
        });

        course_t.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"No courses registered yet", null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Course", "Course Code"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(course_t);

        jLabel5.setText("Registered courses:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel10))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(name_lbl)
                                    .addComponent(id_lbl)
                                    .addComponent(degree_lbl)
                                    .addComponent(lvl_lbl)
                                    .addComponent(usr_lbl)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(man_b)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(resetp_b)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancel_b))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel6)))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(name_lbl))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(id_lbl))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(degree_lbl))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lvl_lbl))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(usr_lbl))
                .addGap(35, 35, 35)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(man_b)
                    .addComponent(cancel_b)
                    .addComponent(resetp_b))
                .addGap(21, 21, 21))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void man_bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_man_bActionPerformed
        String name = name_lbl.getText();
        String id = id_lbl.getText();
        String deg = degree_lbl.getText();
        String lvl = lvl_lbl.getText();
        String uname = usr_lbl.getText();
        Stud_manageprofile smp = new Stud_manageprofile(name,id,deg,lvl,uname);
        smp.setVisible(true);
        this.dispose();
        return;
    }//GEN-LAST:event_man_bActionPerformed

    private void resetp_bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetp_bActionPerformed
        String uname = usr_lbl.getText(), profile = "Student";
        String page = "svp";
        Changepass scp = new Changepass(uname,page,profile);
        scp.setVisible(true);
        this.dispose();
        return;
    }//GEN-LAST:event_resetp_bActionPerformed

    private void cancel_bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_bActionPerformed
        String uname = usr_lbl.getText();
        Stud_mMenu sm = new Stud_mMenu(uname);
        sm.setVisible(true);
        this.dispose();
        return;
    }//GEN-LAST:event_cancel_bActionPerformed

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
            java.util.logging.Logger.getLogger(Stud_vProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Stud_vProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Stud_vProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Stud_vProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Stud_vProfile().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel_b;
    private javax.swing.JTable course_t;
    private javax.swing.JLabel degree_lbl;
    private javax.swing.JLabel id_lbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lvl_lbl;
    private javax.swing.JButton man_b;
    private javax.swing.JLabel name_lbl;
    private javax.swing.JButton resetp_b;
    private javax.swing.JLabel usr_lbl;
    // End of variables declaration//GEN-END:variables
}
