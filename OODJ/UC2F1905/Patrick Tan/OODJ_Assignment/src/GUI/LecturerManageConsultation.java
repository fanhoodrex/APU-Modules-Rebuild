package GUI;
/* Combo box cannot be removed all elements */
import Classes.Consultation;
import static Classes.Consultation.saveConsultation;
import Classes.CustomCalendarHandler;
import static Classes.CustomCalendarHandler.getPrintAllWeekDay;
import static Classes.CustomCalendarHandler.weeksInCalendar;
import static Classes.Student.getNameFromID;
import Classes.Lecturer;
import Exception.PrimaryKeyNotFoundException;
import Classes.Slot;
import Classes.Student;
import Classes.Venue;
import Classes.FileController;
import Exception.UnauthorizationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class LecturerManageConsultation extends javax.swing.JFrame {
	Date date = new Date();
        Calendar cal = Calendar.getInstance();
        Consultation cl;
        Lecturer lect;
        ListSelectionModel ConsultationcellSelectionModel;
         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public LecturerManageConsultation(){
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
    public LecturerManageConsultation(Lecturer lect){
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.lect = lect;
        jTableConsultation.setEnabled(false);
        jButtonManageConsultation.setEnabled(false);
        validateEligible();
        cl = new Consultation(lect);
        EnableManageConsultationComponent(false);
        customActionLister();
        getSlot("Frame");
    }
    private void validateEligible(){
        if (validateVenueFile()){
            jComboBoxWeekly.addItem("--");
            initializeWeek();
            getVenue("Frame");
            jComboBoxWeekly.setEnabled(true);
            jComboBoxDays.setEnabled(true);
            jButtonNewConsultation.setEnabled(true);
        }
        else{
            jComboBoxWeekly.setEnabled(false);
            jComboBoxDays.setEnabled(false);
            jButtonNewConsultation.setEnabled(false);
            JOptionPane.showMessageDialog(this,"Please at least add one venue in your preference in order to define the consultation!");
        }
    }
    private boolean validateVenueFile(){
        boolean success = false;
        File VenueFile = new File("DATA/Venues/" + lect.getUserID() + "-Venue.txt");
        if (VenueFile.exists()){
            success = true;
        }
        return success;
    }
    public void initializeWeek(){  
        jComboBoxWeekly.setSelectedIndex(0);
//        for(int i=0;i<jComboBoxWeekly.getItemCount();i++){
//            jComboBoxWeekly.removeItemAt(0);
//        }
        ArrayList<String> WeeksArray = new ArrayList();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        WeeksArray.add(dateFormat.format(c.getTime()));
        c.add(Calendar.DATE, 7);
        WeeksArray.add(dateFormat.format(c.getTime()));
        for(String Week : WeeksArray){
            boolean exist = false;
            try {
                for (String Dates : getPrintAllWeekDay(Week)){
                    File f = new File("DATA/Consultation/" + Dates + ".txt");
                    if (f.exists()){
                        int[] PKs = {0};
                        String[] Vals = {lect.getUserID()};
                        ArrayList<String> FileContent = FileController.ReadFile(f,PKs,Vals);
                        if (FileContent.size() > 0){
                            exist = true;
                        }
                    }
                }
            } catch (ParseException | IOException ex) {
                JOptionPane.showMessageDialog(this, "Encounter unexpected error");
            }
            if (exist == true){
                jComboBoxWeekly.addItem(Week);
            }
        }
    }
    private void customActionLister(){
        ListSelectionModel cellSelectionModel = jTableConsultation.getSelectionModel();
        cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if (!lse.getValueIsAdjusting()){
                    
                    if (jTableConsultation.getSelectedRow() != - 1){
                        jButtonManageConsultation.setEnabled(true);
                        switch (jTableConsultation.getValueAt(jTableConsultation.getSelectedRow(), 3).toString()){
                            case "Available":
                                initializeStatusComboBox("Cancel");
                                break;
                            case "Booked":
                                initializeStatusComboBox("Delete");
                            break;
                        }
                        jComboBoxManageTime.setEnabled(false);
                        jComboBoxManageVenue.setEnabled(false);
                        jComboBoxManageTime.setSelectedItem(jTableConsultation.getValueAt(cellSelectionModel.getMinSelectionIndex(), 0));
                        jComboBoxManageVenue.setSelectedItem(jTableConsultation.getValueAt(cellSelectionModel.getMinSelectionIndex(), 1));
                    }
                }
            }
        });
    }
    private void initializeStatusComboBox(String exceptionCondition){
        jComboManageStatus.removeAllItems();
        String[] sts = {"No Changes","Cancel","Delete"};
        for (String st : sts){
            if (!exceptionCondition.equals("")){                
                if (!st.equals(exceptionCondition)){
                    jComboManageStatus.addItem(st);
                }
            }            
        }
        jComboManageStatus.setSelectedIndex(0);
    }
    private void getSlot(String location){
        Slot slot = new Slot();
            try {
                for (String time : slot.readSlotFromDB()){
                    switch(location){
                        case "Frame":
                            jComboBoxManageTime.addItem(time);
                            break;
                        case "Dialog":
                            jComboBoxManageNewTime.addItem(time);
                            break;
                    }
                }
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Default slot file is missing");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Fail to initialize slot list!");
            }
    }
    private void EnableManageConsultationComponent(boolean swt){
        boolean sth = false;
        if (swt == true){
            sth = true;
        }
        jComboBoxManageTime.setEnabled(sth);
        jComboBoxManageVenue.setEnabled(sth);
        jComboManageStatus.setEnabled(sth);
    }
    private void getVenue(String location){
        Venue vn = new Venue(lect);
            try {
                for (String venue : vn.getUserDefinedVenues()){
                    switch (location){
                        case "Frame":
                            jComboBoxManageVenue.addItem(venue);
                            break;
                        case "Dialog":
                            jComboBoxManageNewVenue.addItem(venue);
                            break;
                    }
                }  
            } catch (FileNotFoundException ex) {
               jComboBoxManageVenue.addItem("--");
            } catch (IOException ex) {
               JOptionPane.showMessageDialog(this,"Fail to initialize venue!");
            }
    }
    public void initializeDays(){
        jComboBoxDays.removeAllItems();
        if (!jComboBoxWeekly.getSelectedItem().toString().equals("--")){
            try {
                for(String l : CustomCalendarHandler.getPrintAllWeekDay(jComboBoxWeekly.getSelectedItem().toString())){
                    File f = new File("DATA/Consultation/" + l + ".txt");
                    if (f.exists()){
                        int[] PKs = {0};
                        String[] Vals = {lect.getUserID()};
                        ArrayList<String> ReadFile = FileController.ReadFile(f,PKs,Vals);
                        if (ReadFile.size() > 0){
                            jComboBoxDays.addItem(l);
                        }
                    }
                }   
            } catch (ParseException | IOException ex) {
                JOptionPane.showMessageDialog(this, "Encounter parsing error!");
            }
        }
    }
    public void initializeAvailableDays() throws ParseException{
        jComboBoxManageNewDay.removeAllItems();
        if (jComboBoxManageNewWeek.getItemCount() >= 1){
            String[] sDte = jComboBoxManageNewWeek.getSelectedItem().toString().split("\\-");
            Calendar cal2 = Calendar.getInstance();
            cal2.set(Calendar.YEAR, Integer.valueOf(sDte[0]));
            cal2.set(Calendar.MONTH, Integer.valueOf(sDte[1])-1);
            cal2.set(Calendar.DAY_OF_MONTH, Integer.valueOf(sDte[2]));
            int delta = -cal2.get(GregorianCalendar.DAY_OF_WEEK) + 1;
            cal2.add(Calendar.DAY_OF_MONTH, delta );
            Date date2;
            date = dateFormat.parse(dateFormat.format(new Date()));
            for (int i = 0; i < 5; i++){
                date2 = dateFormat.parse(dateFormat.format(cal2.getTime()));
                cal2.add(Calendar.DAY_OF_MONTH, 1);
                int left = (int)CustomCalendarHandler.calculateDifferenceInDays(date,date2,Locale.ENGLISH);
                if (left >= 0){
                    jComboBoxManageNewDay.addItem(dateFormat.format(cal2.getTime()));
                }
            }
        }
    }
    private void initializeAvailableWeek() throws ParseException{
        jComboBoxManageNewWeek.removeAllItems();
        Date date1,date2;
        date1 = dateFormat.parse(dateFormat.format(new Date()));
        for (LocalDate x : weeksInCalendar(YearMonth.now())){
            try {
                date2 = dateFormat.parse(x.toString());
                int left = (int)CustomCalendarHandler.calculateDifferenceInDays(date1,date2,Locale.ENGLISH);
                if (left > -3){
                    jComboBoxManageNewWeek.addItem(x.toString());
                }   
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this,"We have some trouble to initialize the week!\nPlease relaunch the application once again!");
            }   
         }
         jComboBoxManageNewWeek.setSelectedIndex(0);
    }
    private void PreviewConsultationTable(){
        Consultation inline_cl = new Consultation(lect);
        DefaultTableModel tblConsultation = (DefaultTableModel)jTableConsultation.getModel();
        while (jTableConsultation.getRowCount() > 0){
                tblConsultation.removeRow(0);
        }   
        if (jComboBoxDays.getModel().getSize() > 0){
            try {
                ArrayList<String> w = inline_cl.getConsultationList(jComboBoxDays.getSelectedItem().toString());
                if (w.size() > 0){
                    for (String y : w){
                        String[] s_Y = y.split("\\|\\|");
                        Object[] dataRows = {s_Y[2],s_Y[3],"30 Minutes",s_Y[4],s_Y[1] + " | " + getNameFromID(s_Y[1]),s_Y[5]};
                        tblConsultation.addRow(dataRows);
                    }
                    ConsultationcellSelectionModel = jTableConsultation.getSelectionModel();
                }
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this,"No found");
            }   catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Fail to construct table!");
            }
        }            
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogDefineNewConsultation = new javax.swing.JDialog();
        jLabelNewManageWeek = new javax.swing.JLabel();
        jLabelNewManageDay = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxManageNewWeek = new javax.swing.JComboBox<>();
        jComboBoxManageNewVenue = new javax.swing.JComboBox<>();
        jComboBoxManageNewTime = new javax.swing.JComboBox<>();
        jComboBoxManageNewDay = new javax.swing.JComboBox<>();
        jButtonCreateConsultation = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableConsultation = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxWeekly = new javax.swing.JComboBox<>();
        jComboBoxDays = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jButtonNewConsultation = new javax.swing.JButton();
        jButtonManageConsultation = new javax.swing.JButton();
        jLabelManageTime = new javax.swing.JLabel();
        jLabelManageTime1 = new javax.swing.JLabel();
        jComboBoxManageTime = new javax.swing.JComboBox<>();
        jComboBoxManageVenue = new javax.swing.JComboBox<>();
        jLabelManageTime2 = new javax.swing.JLabel();
        jComboManageStatus = new javax.swing.JComboBox<>();

        jDialogDefineNewConsultation.setMinimumSize(new java.awt.Dimension(300, 250));
        jDialogDefineNewConsultation.setModal(true);

        jLabelNewManageWeek.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabelNewManageWeek.setText("Week");

        jLabelNewManageDay.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabelNewManageDay.setText("Day");

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel5.setText("Time");

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel6.setText("Venue");

        jComboBoxManageNewWeek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxManageNewWeekActionPerformed(evt);
            }
        });

        jButtonCreateConsultation.setText("Create");
        jButtonCreateConsultation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateConsultationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogDefineNewConsultationLayout = new javax.swing.GroupLayout(jDialogDefineNewConsultation.getContentPane());
        jDialogDefineNewConsultation.getContentPane().setLayout(jDialogDefineNewConsultationLayout);
        jDialogDefineNewConsultationLayout.setHorizontalGroup(
            jDialogDefineNewConsultationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogDefineNewConsultationLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jDialogDefineNewConsultationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogDefineNewConsultationLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabelNewManageWeek)
                        .addGap(7, 7, 7)
                        .addComponent(jComboBoxManageNewWeek, 0, 106, Short.MAX_VALUE))
                    .addGroup(jDialogDefineNewConsultationLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jComboBoxManageNewDay, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jDialogDefineNewConsultationLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonCreateConsultation)
                        .addGap(17, 17, 17))
                    .addGroup(jDialogDefineNewConsultationLayout.createSequentialGroup()
                        .addGroup(jDialogDefineNewConsultationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDialogDefineNewConsultationLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel5))
                            .addGroup(jDialogDefineNewConsultationLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabelNewManageDay)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jDialogDefineNewConsultationLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(11, 11, 11)
                        .addGroup(jDialogDefineNewConsultationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxManageNewTime, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxManageNewVenue, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(31, 31, 31))
        );
        jDialogDefineNewConsultationLayout.setVerticalGroup(
            jDialogDefineNewConsultationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogDefineNewConsultationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogDefineNewConsultationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNewManageWeek)
                    .addComponent(jComboBoxManageNewWeek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jDialogDefineNewConsultationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNewManageDay)
                    .addComponent(jComboBoxManageNewDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialogDefineNewConsultationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxManageNewTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jDialogDefineNewConsultationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jComboBoxManageNewVenue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonCreateConsultation)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Lecturer Manage Consultation");
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
                "Time", "Venue", "Session", "Status", "Booked by", "Reason"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableConsultation.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableConsultation.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableConsultation);
        if (jTableConsultation.getColumnModel().getColumnCount() > 0) {
            jTableConsultation.getColumnModel().getColumn(0).setMinWidth(90);
            jTableConsultation.getColumnModel().getColumn(0).setMaxWidth(110);
            jTableConsultation.getColumnModel().getColumn(1).setMinWidth(110);
            jTableConsultation.getColumnModel().getColumn(1).setMaxWidth(130);
            jTableConsultation.getColumnModel().getColumn(2).setMinWidth(120);
            jTableConsultation.getColumnModel().getColumn(2).setMaxWidth(140);
            jTableConsultation.getColumnModel().getColumn(3).setMinWidth(100);
            jTableConsultation.getColumnModel().getColumn(3).setMaxWidth(130);
            jTableConsultation.getColumnModel().getColumn(5).setMinWidth(120);
            jTableConsultation.getColumnModel().getColumn(5).setMaxWidth(150);
        }

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setText("Weeks");

        jComboBoxWeekly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxWeeklyActionPerformed(evt);
            }
        });

        jComboBoxDays.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jComboBoxDays.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDaysActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("Days");

        jButtonNewConsultation.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButtonNewConsultation.setText("New");
        jButtonNewConsultation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewConsultationActionPerformed(evt);
            }
        });

        jButtonManageConsultation.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButtonManageConsultation.setText("Edit");
        jButtonManageConsultation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonManageConsultationActionPerformed(evt);
            }
        });

        jLabelManageTime.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabelManageTime.setText("Time:");

        jLabelManageTime1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabelManageTime1.setText("Venue:");

        jComboBoxManageTime.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jComboBoxManageVenue.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jLabelManageTime2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabelManageTime2.setText("Status:");

        jComboManageStatus.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jComboManageStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboManageStatusActionPerformed(evt);
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
                        .addComponent(jLabelManageTime, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxManageTime, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jLabelManageTime1)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxManageVenue, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jLabelManageTime2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboManageStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonManageConsultation))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxWeekly, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxDays, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jButtonNewConsultation, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxWeekly, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxDays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jButtonNewConsultation))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelManageTime)
                    .addComponent(jLabelManageTime1)
                    .addComponent(jComboBoxManageTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxManageVenue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelManageTime2)
                    .addComponent(jComboManageStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonManageConsultation))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxWeeklyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxWeeklyActionPerformed
        if (jComboBoxWeekly.getItemCount() > 0){
             if (!jComboBoxWeekly.getSelectedItem().toString().equals("--")){
                 initializeDays();
             }
             else{
                 jComboBoxDays.removeAllItems();
                 DefaultTableModel tblConsultation = (DefaultTableModel)jTableConsultation.getModel();
                 while (jTableConsultation.getRowCount() > 0){
                     tblConsultation.removeRow(0);
                 }   
             }
        }
    }//GEN-LAST:event_jComboBoxWeeklyActionPerformed

    private void jComboBoxDaysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDaysActionPerformed
        if (jComboBoxDays.getSelectedItem() != null){
            jTableConsultation.setEnabled(true);
            PreviewConsultationTable();
            jComboBoxManageTime.setEnabled(false);
            jComboBoxManageVenue.setEnabled(false);
            jComboManageStatus.setEnabled(false);
            jButtonManageConsultation.setText("Edit");
        }
    }//GEN-LAST:event_jComboBoxDaysActionPerformed

    private void jButtonManageConsultationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonManageConsultationActionPerformed
        if (jTableConsultation.getSelectedRow() != -1){
            switch (jButtonManageConsultation.getText()){
                case "Edit":
                    jTableConsultation.setEnabled(false);
                    EnableManageConsultationComponent(true);
                    jButtonManageConsultation.setText("Save");
                    jComboManageStatus.setSelectedIndex(0);
                    break;
                case "Save":
                    String stdInfo = String.valueOf(jTableConsultation.getValueAt(jTableConsultation.getSelectedRow(), 4));
                    String[] s_StdInfo = stdInfo.split("\\|");
                    jTableConsultation.setEnabled(true);
                    EnableManageConsultationComponent(false);
                    List<Consultation> clList = new ArrayList();
                    cl = new Consultation(lect,new Student(s_StdInfo[0].replace(" ", "")),new Slot(jComboBoxManageTime.getSelectedItem().toString()),new Venue(jComboBoxManageVenue.getSelectedItem().toString()),jComboBoxDays.getSelectedItem().toString());
                    switch (jComboManageStatus.getSelectedItem().toString()){
                        case "Cancel":
                                try {
                                    if (CustomCalendarHandler.validateDate(jComboBoxDays.getSelectedItem().toString()) > 0){
                                        cl.CancelConsultation(lect.getUserID());
                                        clList.add(cl);
                                        lect.setConsultationList(clList);
                                        if (saveConsultation(lect.getConsultationList()).isEmpty()){
                                            JOptionPane.showMessageDialog(this, "You have successfully cancel the consultation!");
                                        }
                                        else{
                                            JOptionPane.showMessageDialog(this, "Encounter unexpected error during saving this changes!");
                                        }
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(this, "You can't cancel the consultation on that day or after passing the exactly date");
                                    }
                                } catch (FileNotFoundException | PrimaryKeyNotFoundException ex) {
                                    JOptionPane.showMessageDialog(this, "Encounter Error during reading File");
                                } catch (IOException | ParseException ex) {
                                    JOptionPane.showMessageDialog(this, "Encounter Error of IO");
                                }
                                jTableConsultation.setEnabled(true); 
                                jButtonManageConsultation.setText("Edit");
                                jButtonManageConsultation.setEnabled(false);
                            break;
                        case "Delete":
                            String content = String.join("||",lect.getUserID(),s_StdInfo[0].replace(" ", ""),jTableConsultation.getValueAt(jTableConsultation.getSelectedRow(),0).toString(),jTableConsultation.getValueAt(jTableConsultation.getSelectedRow(),1).toString(),jTableConsultation.getValueAt(jTableConsultation.getSelectedRow(),3).toString(),jTableConsultation.getValueAt(jTableConsultation.getSelectedRow(),5).toString());
                            try {
                                if (CustomCalendarHandler.validateDate(jComboBoxDays.getSelectedItem().toString()) > 0){
                                    if (cl.DeleteConsultation(content)){
                                        File f = new File("DATA/Consultation/" + jComboBoxDays.getSelectedItem().toString() + ".txt");
                                        if (f.exists()){
                                            String FileContent = FileController.ReadLastLineOfTheFile(f);
                                            if (FileContent.startsWith("LectID")){
                                                f.delete();
                                            }
                                        }
                                        jButtonManageConsultation.setEnabled(false);
                                        jTableConsultation.setEnabled(true);                                    
                                        jButtonManageConsultation.setText("Edit");
                                        JOptionPane.showMessageDialog(this, "The changes has been successfully saved!");
                                    }
                                    else{
                                        jButtonManageConsultation.setEnabled(false);
                                        jTableConsultation.setEnabled(true);                                    
                                        jButtonManageConsultation.setText("Edit");
                                        JOptionPane.showMessageDialog(this, "Having trouble to save this changes!");
                                    }
                                }
                                else{
                                    jButtonManageConsultation.setEnabled(false);
                                    jTableConsultation.setEnabled(true);                                    
                                    jButtonManageConsultation.setText("Edit");
                                    JOptionPane.showMessageDialog(this, "You can't remove the consultation on that day or after passing the exactly date");
                                }
                            } catch (IOException | ParseException ex) {
                                jButtonManageConsultation.setEnabled(false);
                                jTableConsultation.setEnabled(true);                                    
                                jButtonManageConsultation.setText("Edit");
                                JOptionPane.showMessageDialog(this,"Something goes wrong\nPlease try again later!");
                            }
                            break;
                        case "No Changes":
                            try {
                                if (CustomCalendarHandler.validateDate(jComboBoxDays.getSelectedItem().toString()) > 0){
                                    if (!cl.ValidateConsultation()){
                                        if (cl.mConsultationVenueAndTime(jTableConsultation.getValueAt(jTableConsultation.getSelectedRow(),1).toString(),jTableConsultation.getValueAt(jTableConsultation.getSelectedRow(),0).toString(),jComboBoxManageVenue.getSelectedItem().toString(),jComboBoxManageTime.getSelectedItem().toString()) == true){
                                            jButtonManageConsultation.setEnabled(false);
                                            jButtonManageConsultation.setText("Edit");
                                            jTableConsultation.setEnabled(true);
                                            JOptionPane.showMessageDialog(this, "The changes has been successfully saved!");
                                        }
                                        else{
                                            jButtonManageConsultation.setEnabled(false);
                                            jTableConsultation.setEnabled(true);                                    
                                            jButtonManageConsultation.setText("Edit");
                                            JOptionPane.showMessageDialog(this, "Please at least change something!");
                                        }
                                    }
                                    else{
                                        jButtonManageConsultation.setEnabled(false);
                                        jTableConsultation.setEnabled(true);                                    
                                        jButtonManageConsultation.setText("Edit");
                                        JOptionPane.showMessageDialog(this, "This slot has been booked on your account early!");
                                    } 
                                }
                                else{
                                    jButtonManageConsultation.setEnabled(false);
                                    jTableConsultation.setEnabled(true);                                    
                                    jButtonManageConsultation.setText("Edit");
                                    JOptionPane.showMessageDialog(this, "You are not allowed the past consultation venue and time!");
                                }                                
                            } catch (IOException | ParseException ex) {
                                jButtonManageConsultation.setEnabled(false);
                                jTableConsultation.setEnabled(true);                                    
                                jButtonManageConsultation.setText("Edit");
                                JOptionPane.showMessageDialog(this,"We hv some problem now!");
                            }
                            break;
                    }
                jTableConsultation.clearSelection(); 
                DefaultComboBoxModel cmb = (DefaultComboBoxModel)jComboBoxWeekly.getModel();
                cmb.removeAllElements();
                jComboBoxDays.removeAllItems();
                jComboBoxWeekly.addItem("--");
                initializeWeek();                                       
                    break;
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Please select at least one row record");
        }
    }//GEN-LAST:event_jButtonManageConsultationActionPerformed
    
    private void jComboManageStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboManageStatusActionPerformed
        if (ConsultationcellSelectionModel.getMinSelectionIndex() != - 1 && jComboManageStatus.getSelectedItem() != null){
            switch (jComboManageStatus.getSelectedItem().toString()){
                case "No Changes":
                    if (jTableConsultation.getValueAt(jTableConsultation.getSelectedRow(), 3).toString().equals("Booked")){
                        jComboBoxManageTime.setEnabled(false);
                        jComboBoxManageVenue.setEnabled(false);
                    }
                    else{
                        jComboBoxManageTime.setEnabled(true);
                        jComboBoxManageVenue.setEnabled(true);
                    }
                    break;
                default:
                    jComboBoxManageTime.setEnabled(false);
                    jComboBoxManageVenue.setEnabled(false);
                    break;
            }
        }
    }//GEN-LAST:event_jComboManageStatusActionPerformed

    private void jButtonNewConsultationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewConsultationActionPerformed
        try {
            jComboBoxManageNewTime.removeAllItems();
            jComboBoxManageNewVenue.removeAllItems();
                initializeAvailableWeek();
                getSlot("Dialog");
                getVenue("Dialog");
                jDialogDefineNewConsultation.setLocationRelativeTo(this);
                jDialogDefineNewConsultation.setResizable(false);
                jDialogDefineNewConsultation.setVisible(true);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this,"We have problem initializing the available week!\nPlease relaunch the application to resolve this issue!");
            }
    }//GEN-LAST:event_jButtonNewConsultationActionPerformed

    private void jComboBoxManageNewWeekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxManageNewWeekActionPerformed
            try {        
                initializeAvailableDays();
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this,"We have issue to preview available days at this moment!\nPlease try again later!");
            }
    }//GEN-LAST:event_jComboBoxManageNewWeekActionPerformed
    
    private void jButtonCreateConsultationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateConsultationActionPerformed
        cl = new Consultation(lect,new Slot(jComboBoxManageNewTime.getSelectedItem().toString()),new Venue(jComboBoxManageNewVenue.getSelectedItem().toString()),jComboBoxManageNewDay.getSelectedItem().toString());
        List<Consultation> ConsultationList = new ArrayList();
        try {
            cl.CreateConsultation();
            ConsultationList.add(cl);
            lect.setConsultationList(ConsultationList);
            if (saveConsultation(lect.getConsultationList()).isEmpty()){
                jTableConsultation.clearSelection(); 
                DefaultComboBoxModel cmb = (DefaultComboBoxModel)jComboBoxWeekly.getModel();
                cmb.removeAllElements();
                jComboBoxWeekly.addItem("--");
                initializeWeek();
                JOptionPane.showMessageDialog(this, "The consultation is successfully defined!");
                jDialogDefineNewConsultation.dispose();
            }
            else{
                JOptionPane.showMessageDialog(this,"So sorry, you have previously defined this slot!\nPlease try another!");
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Encounter Error during checking unredundant consultation");
        } 
        catch (PrimaryKeyNotFoundException | UnauthorizationException | IOException e){
            JOptionPane.showMessageDialog(this, "Encounter Error during saving defined consultation!");
        }   
    }//GEN-LAST:event_jButtonCreateConsultationActionPerformed

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
            java.util.logging.Logger.getLogger(LecturerManageConsultation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LecturerManageConsultation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LecturerManageConsultation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LecturerManageConsultation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LecturerManageConsultation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCreateConsultation;
    private javax.swing.JButton jButtonManageConsultation;
    private javax.swing.JButton jButtonNewConsultation;
    private javax.swing.JComboBox<String> jComboBoxDays;
    private javax.swing.JComboBox<String> jComboBoxManageNewDay;
    private javax.swing.JComboBox<String> jComboBoxManageNewTime;
    private javax.swing.JComboBox<String> jComboBoxManageNewVenue;
    private javax.swing.JComboBox<String> jComboBoxManageNewWeek;
    private javax.swing.JComboBox<String> jComboBoxManageTime;
    private javax.swing.JComboBox<String> jComboBoxManageVenue;
    private javax.swing.JComboBox<String> jComboBoxWeekly;
    private javax.swing.JComboBox<String> jComboManageStatus;
    private javax.swing.JDialog jDialogDefineNewConsultation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelManageTime;
    private javax.swing.JLabel jLabelManageTime1;
    private javax.swing.JLabel jLabelManageTime2;
    private javax.swing.JLabel jLabelNewManageDay;
    private javax.swing.JLabel jLabelNewManageWeek;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableConsultation;
    // End of variables declaration//GEN-END:variables
}
