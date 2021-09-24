package GUI;

import Exception.UnauthorizationException;
import Classes.Consultation;
import Classes.EmailHandler;
import Exception.InvalidConsultationException;
import Classes.Lecturer;
import Classes.Student;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ViewAllConsultation extends javax.swing.JFrame {
    String userID;
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();
    Consultation cl;
    public ViewAllConsultation(){
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    public ViewAllConsultation(String ID) {
        userID = ID;
        initComponents();
        jCheckBoxSendReport.setEnabled(false);
        jButtonGenerateReport.setEnabled(false);
        initializeViewTypeComboBox();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    private void setViewTypeComboBox(String ExcludeCondition){
        jComboBoxViewType.removeAllItems();
        String[] comboBoxSelections = {"All","Booked","Cancellation"};
        for (String comboBoxSelection : comboBoxSelections){
             if (!comboBoxSelection.equals(ExcludeCondition)){
                 jComboBoxViewType.addItem(comboBoxSelection);
             }
        }
    }
    private void initializeViewTypeComboBox(){
        if (userID.startsWith("STD")){
            setViewTypeComboBox("");
        }
        else if(userID.startsWith("LECT")){
            setViewTypeComboBox("Cancellation");
        }
    }
    private void InitializeConsultationTbl(String viewType){
        DefaultTableModel tblConsultation = (DefaultTableModel)jTableGlobalConsultation.getModel();
        while (tblConsultation.getRowCount() > 0){
            tblConsultation.removeRow(0);
        }
        if (userID.startsWith("STD")){
            cl = new Consultation(new Student(userID));
            jTableGlobalConsultation.getColumnModel().getColumn(4).setHeaderValue("Lecturer");
            jTableGlobalConsultation.getTableHeader().repaint();
        }
        else{
            cl = new Consultation(new Lecturer(userID));
            jTableGlobalConsultation.getColumnModel().getColumn(4).setHeaderValue("Student");
            jTableGlobalConsultation.getTableHeader().repaint();
        }
        try {
            ArrayList<String> GlobalConsultation = cl.getGlobalConsultation(viewType);
            if (GlobalConsultation.size() > 0){                            
                System.out.println(GlobalConsultation.size());
                for (String ConsultationDetail: GlobalConsultation){
                    String[] s_ConsultationDetail = ConsultationDetail.split("\\|\\|");
                    Object[] dataRows = {s_ConsultationDetail[0],s_ConsultationDetail[3],"30 Minutes",s_ConsultationDetail[4],(cl.getOwnerID().startsWith("STD") ? s_ConsultationDetail[1] + " | " + Student.getNameFromID(s_ConsultationDetail[1]) : s_ConsultationDetail[2] + " | " + Student.getNameFromID(s_ConsultationDetail[2])),s_ConsultationDetail[6],s_ConsultationDetail[5]};
                    tblConsultation.addRow(dataRows);
                }
                jCheckBoxSendReport.setEnabled(true);
                jButtonGenerateReport.setEnabled(true);
            }
            else{
                jCheckBoxSendReport.setEnabled(false);
                jButtonGenerateReport.setEnabled(false);
            }

            TableRowSorter<TableModel> sorter = new TableRowSorter<>(jTableGlobalConsultation.getModel());
                jTableGlobalConsultation.setRowSorter(sorter);
                List<RowSorter.SortKey> sortKeys = new ArrayList<>();
                int columnIndexToSort = 0;
                sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.DESCENDING));
                sorter.setSortKeys(sortKeys);
                sorter.sort();
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Fail to initialize table\nPlease contact tech support!");
        }catch (InvalidConsultationException | UnauthorizationException ex){
            JOptionPane.showMessageDialog(this, ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Fail to initialize table");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableGlobalConsultation = new javax.swing.JTable();
        jLabelViewType = new javax.swing.JLabel();
        jComboBoxViewType = new javax.swing.JComboBox<>();
        jButtonGenerateReport = new javax.swing.JButton();
        jCheckBoxSendReport = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Consultation History Report");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTableGlobalConsultation.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jTableGlobalConsultation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Time", "Session", "Venue", "Booked By", "Reason", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableGlobalConsultation.setColumnSelectionAllowed(true);
        jTableGlobalConsultation.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableGlobalConsultation);
        jTableGlobalConsultation.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTableGlobalConsultation.getColumnModel().getColumnCount() > 0) {
            jTableGlobalConsultation.getColumnModel().getColumn(0).setMinWidth(120);
            jTableGlobalConsultation.getColumnModel().getColumn(0).setMaxWidth(150);
            jTableGlobalConsultation.getColumnModel().getColumn(1).setMinWidth(85);
            jTableGlobalConsultation.getColumnModel().getColumn(1).setMaxWidth(110);
            jTableGlobalConsultation.getColumnModel().getColumn(2).setMinWidth(120);
            jTableGlobalConsultation.getColumnModel().getColumn(2).setMaxWidth(150);
            jTableGlobalConsultation.getColumnModel().getColumn(3).setMinWidth(150);
            jTableGlobalConsultation.getColumnModel().getColumn(3).setMaxWidth(180);
            jTableGlobalConsultation.getColumnModel().getColumn(5).setMinWidth(120);
            jTableGlobalConsultation.getColumnModel().getColumn(5).setMaxWidth(180);
            jTableGlobalConsultation.getColumnModel().getColumn(6).setMinWidth(100);
            jTableGlobalConsultation.getColumnModel().getColumn(6).setMaxWidth(120);
        }

        jLabelViewType.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabelViewType.setText("View Type:");

        jComboBoxViewType.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jComboBoxViewType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxViewTypeActionPerformed(evt);
            }
        });

        jButtonGenerateReport.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButtonGenerateReport.setText("Generate Report");
        jButtonGenerateReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerateReportActionPerformed(evt);
            }
        });

        jCheckBoxSendReport.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jCheckBoxSendReport.setText("Send report to register email");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 986, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelViewType)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxViewType, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jCheckBoxSendReport)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonGenerateReport, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelViewType)
                    .addComponent(jComboBoxViewType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGenerateReport)
                    .addComponent(jCheckBoxSendReport))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxViewTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxViewTypeActionPerformed
        InitializeConsultationTbl(jComboBoxViewType.getSelectedItem().toString());
    }//GEN-LAST:event_jComboBoxViewTypeActionPerformed
    private Long generateUniqueId() {
            long val = -1;
            do {
                val = UUID.randomUUID().getMostSignificantBits();
            } while (val < 0);
            return val;
    }
    
    private void jButtonGenerateReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerateReportActionPerformed
        String uniqueID = String.valueOf(generateUniqueId());
        try {
            Document doc = new Document();
            doc.setPageSize(PageSize.A4.rotate());
            PdfWriter.getInstance(doc, new FileOutputStream("DATA/Reports/" + uniqueID  + ".pdf"));
            doc.open();
            PdfPTable pdfTable = new PdfPTable(jTableGlobalConsultation.getColumnCount());
            String userFullName = "-";
            if (userID.startsWith("STD")){
                userFullName = Student.getNameFromID(userID);
            }
            else if (userID.startsWith("LECT")){
                 userFullName = Lecturer.getNameFromID(userID);
            }
            PdfPCell HeaderCell = new PdfPCell(new Phrase("Consultation Report\nGenerated by " + userFullName + " at " + dateFormat.format(date)));
            HeaderCell.setColspan(7);
            pdfTable.addCell(HeaderCell);
            for (int i = 0; i < jTableGlobalConsultation.getColumnCount(); i++) {
                pdfTable.addCell(jTableGlobalConsultation.getColumnName(i));
            }
            
            for (int rows = 0; rows < jTableGlobalConsultation.getRowCount(); rows++) {
                for (int cols = 0; cols < jTableGlobalConsultation.getColumnCount(); cols++) {
                    pdfTable.addCell(jTableGlobalConsultation.getModel().getValueAt(rows, cols).toString());
                }
            }
            int[] columnWidths = new int[]{150,105,125,200,200,200,180};
            pdfTable.setWidths(columnWidths);
            doc.add(pdfTable);
            doc.close();
            if (jCheckBoxSendReport.isSelected()){
                String email = JOptionPane.showInputDialog("Please enter a valid email address:");
                if (email != null){
                    if(email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
                        EmailHandler.sendMail(email,"Consultation Report","Your report is attached!",uniqueID  + ".pdf");
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "You have provided a bad email address!\nEmail is not delivered successfully!");
                    }  
                }
                else{
                    JOptionPane.showMessageDialog(this, "You have entered an empty email address!\nThe report will not be delivered to the email!");
                }
                                
            }
            JOptionPane.showMessageDialog(this, "The report is generated!");
            Desktop.getDesktop().open(new File("DATA/Reports/" + uniqueID  + ".pdf"));
        } catch (DocumentException ex) {
            JOptionPane.showMessageDialog(this, "Fail to initialize a document!\nPlease try again later!");
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "This is might not be existed in the system!");
        } catch (MessagingException | IOException ex) {
            JOptionPane.showMessageDialog(this, "Fail to delivers the attachment to the registered email!");
        } 
    }//GEN-LAST:event_jButtonGenerateReportActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (userID.startsWith("LECT")){
            new LECMainPage(new Lecturer(userID)).setVisible(true);
        }
        else{
            new STDMainPage(new Student(userID)).setVisible(true);
        }        
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewAllConsultation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAllConsultation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAllConsultation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAllConsultation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAllConsultation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGenerateReport;
    private javax.swing.JCheckBox jCheckBoxSendReport;
    private javax.swing.JComboBox<String> jComboBoxViewType;
    private javax.swing.JLabel jLabelViewType;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableGlobalConsultation;
    // End of variables declaration//GEN-END:variables
}
