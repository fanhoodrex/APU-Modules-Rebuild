package Classes;

import Exception.InvalidConsultationException;
import Exception.UnauthorizationException;
import Exception.PrimaryKeyNotFoundException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* LectID||StdID||Time||Venue||Status||Reason */
public class Consultation{
    private Student student;
    private Lecturer lecturer; 
    private Venue venue;
    private Slot slot;
    private String reason, BookerID, DefinerID, strOfDate, FinalString, OwnerID;
    public Consultation(){
        this.FinalString = null;
    }
    public Consultation(Student student){
        this.FinalString = null;
        this.student = student;
        setOwnerID(student.getUserID());
    }
    public Consultation(Lecturer lecturer){
        this.FinalString = null;
        this.lecturer = lecturer;
        setOwnerID(lecturer.getUserID());
    }
    /* Used by Lecturer */
    public Consultation(Lecturer lecturer,Slot slot,Venue venue,String Date){
        this.FinalString = null;
        this.slot = slot;
        this.venue = venue;
        this.lecturer = lecturer;
        setDefinerID(lecturer.getUserID());
        setDate(Date);
        setOwnerID(lecturer.getUserID());
    }
    public Consultation(Lecturer lecturer,Student student,Slot slot,Venue venue,String Date){
        this.FinalString = null;
        this.slot = slot;
        this.venue = venue;
        this.lecturer = lecturer;
        this.student = student;
        setBookerID(student.getUserID());
        setDefinerID(lecturer.getUserID());
        setDate(Date);
        setOwnerID(lecturer.getUserID());
    }
    /* Used By Student */
    public Consultation(Student student,Lecturer lecturer,Slot slot,Venue venue,String Date){
        this.FinalString = null;
        this.slot = slot;
        this.venue = venue;
        this.lecturer = lecturer;
        setDefinerID(lecturer.getUserID());
        setBookerID(student.getUserID());
        setDate(Date);
        setOwnerID(student.getUserID());
    }
    private void setOwnerID(String OwnerID){
        this.OwnerID = OwnerID;
    }
    private void setDate(String strOfDate){
        this.strOfDate = strOfDate;
    }
    private void setBookerID(String BookerID){
        this.BookerID = BookerID;
    }
    private void setDefinerID(String DefinerID){
        this.DefinerID = DefinerID;
    }
    public void setReason(String reason){
        this.reason = reason;
    }
     public String getOwnerID() {
        return OwnerID;
    }
    public String getDate() {
        return strOfDate;
    }
    public String getBookerID(){
        return BookerID;
    }
    public String getDefinerID() {
        return DefinerID;
    }
    public String getReason(){
        return reason;
    }
    private static void setLogsToStudent(String Logs) throws IOException{
        /* 
        * 0 --> Date
        * 1 --> Time
        * 2 --> Venue
        * 3 --> Lecturer
        * 4 --> Reason
        */
        String[] s_Log = Logs.split("\\|\\|");
        String LogContent = String.join("||", s_Log[0],s_Log[3],s_Log[4],s_Log[1],s_Log[6]);
        File f = new File("DATA/ConsultationCancellation/" + s_Log[7] + "-ConsultationCancellationLogs.txt");
        if (!f.exists()){
            FileController.WriteFile(f,"Date||Time||Venue||Lecturer||Reason");
        }
        FileController.WriteFile(f,LogContent);
    }
    public boolean mConsultationVenueAndTime(String OldVenue,String OldTime,String NewVenue,String NewTime) throws IOException{
        int[] WherePKs = {0,2,3};
        String[] WherePKVals = {lecturer.getUserID(),OldTime,OldVenue};
        int[] UpdatePKs = {2,3};
        String[] UpdatePKVals = {NewTime,NewVenue};
        return FileController.UpdateFile(new File("DATA/Consultation/" + getDate() + ".txt"), WherePKs, WherePKVals, UpdatePKs, UpdatePKVals);
    }
    public ArrayList<String> getConsultationDateList() throws FileNotFoundException, PrimaryKeyNotFoundException, IOException{
        ArrayList<String> DateList = new ArrayList();
        File directory = new File("DATA/Consultation");
        String[] files = directory.list();
        for (String file : files){
            int[] PKs = {0};
            String[] Vals = {lecturer.getUserID()};
            ArrayList<String> ConsultationRecord = FileController.ReadFile(new File("DATA/Consultation/" + file), PKs, Vals);
            if (ConsultationRecord.size() > 0){
                DateList.add(file.replace(".txt","").replace("_","/"));
            }
        }
        return DateList;
    }
    public ArrayList<String> getConsultationList(String Date) throws FileNotFoundException, IOException{
        ArrayList<String> ConsultationList = new ArrayList();
        int[] PKs = {0};
        String[] Vals = {lecturer.getUserID()};
        ConsultationList = FileController.ReadFile(new File("DATA/Consultation/" + Date + ".txt"), PKs, Vals);
        return ConsultationList;
    }
    public ArrayList<String> getStudentCurrentWeekConsultationList() throws IOException, ParseException{
        ArrayList<String> clList = new ArrayList();
        for(String dte : CustomCalendarHandler.getThisAndNextWeekAllWeekDay()){
            int[] PKs = {1};
            String[] Vals = {student.getUserID()};
            File f = new File("DATA/Consultation/" + dte + ".txt");
            if (f.exists()){
                ArrayList<String> ConsultationBookedList = FileController.ReadFile(f, PKs, Vals);
                ConsultationBookedList.forEach((BookedList) -> {
                    clList.add(String.join("||", dte,BookedList));
                });
            }
        }
        return clList;
    }
    public ArrayList<String> getAvailableConsultationList(String lectID) throws IOException{
        ArrayList<String> clList = new ArrayList();
        File directory = new File("DATA/Consultation");
        String[] files = directory.list();
        for(String dte : files){
            int[] PKs = {0,4};
            String[] Vals = {lectID,"Available"};
            File f = new File("DATA/Consultation/" + dte);
            if (f.exists()){
                ArrayList<String> ConsultationBookedList = FileController.ReadFile(f, PKs, Vals);
                ConsultationBookedList.forEach((BookedList) -> {
                    try {
                        if (CustomCalendarHandler.validateDate(dte.replace(".txt", "")) > 0){
                            clList.add(String.join("||", dte.replace(".txt", ""),BookedList));
                        }
                    } catch (ParseException ex) {
                        Logger.getLogger(Consultation.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
            }
        }
        return clList;
    }
    /* 
    * This only apply for lecturer retrieving
    */
    private ArrayList<String> getStudentCancellationLogs() throws UnauthorizationException, FileNotFoundException, IOException{
        ArrayList<String> CancellationLogs = new ArrayList();
        if (getOwnerID().startsWith("STD")){
            File StudentLogs = new File("DATA/ConsultationCancellation/" + getOwnerID() + "-ConsultationCancellationLogs.txt");
            if (StudentLogs.exists()){
                ArrayList<String> StudentCancellationLogs = FileController.ReadFile(StudentLogs);
                for (String StudentCancellationLog : StudentCancellationLogs){       
                    if (!StudentCancellationLog.equals("Date||Time||Venue||Lecturer||Reason")){
                        String[] s_StudentCancellationLog = StudentCancellationLog.split("\\|\\|");
                        ArrayList<String> LogInfo = new ArrayList();
                        LogInfo.add(s_StudentCancellationLog[0]);
                        LogInfo.add(s_StudentCancellationLog[3]);
                        LogInfo.add(getOwnerID());
                        LogInfo.add(s_StudentCancellationLog[1]);
                        LogInfo.add(s_StudentCancellationLog[2]);
                        LogInfo.add("Cancellation");
                        LogInfo.add(s_StudentCancellationLog[4]);
                        String parseArray = FileController.ConstructArray(LogInfo);
                        CancellationLogs.add(parseArray);
                    }   
                }
            }
        }
        else{
            throw new UnauthorizationException("Does not have authorization to operate this method!");
        }
        return CancellationLogs;
    }
    public ArrayList<String> getGlobalConsultation(String viewType) throws FileNotFoundException,InvalidConsultationException, UnauthorizationException, IOException{
        ArrayList<String> ConsultationList = new ArrayList();
        File directory = new File("DATA/Consultation");
        String[] files = directory.list();
        if (getOwnerID().startsWith("STD") && viewType.equals("Cancellation")){
            for(String x : getStudentCancellationLogs()){
                ConsultationList.add(x);
            }           
        }
        else{
            if (getOwnerID().startsWith("STD") && viewType.equals("All")){
                for(String x : getStudentCancellationLogs()){
                    ConsultationList.add(x);
                }  
            }             
            for (String file : files){
                ArrayList<String> FileContents = FileController.ReadFile(new File("DATA/Consultation/" + file));
                FileContents.forEach((String FileContent) -> {
                    String[] sLine = FileContent.split("\\|\\|");
                    switch(viewType){
                        case "All":
                            if (getOwnerID().startsWith("LECT") && sLine[0].equals(getOwnerID())){
                                ConsultationList.add(String.join("||",file.replace(".txt",""),FileContent));
                            }
                            else if (getOwnerID().startsWith("STD") && sLine[1].equals(getOwnerID()) && sLine[0] != null){
                                ConsultationList.add(String.join("||",file.replace(".txt",""),FileContent));
                            }
                            break;
                        case "Booked":
                            if (getOwnerID().startsWith("LECT") && sLine[0].equals(getOwnerID()) && sLine[4].equals("Booked")){
                                ConsultationList.add(String.join("||",file.replace(".txt",""),FileContent));
                            } 
                            else if (getOwnerID().startsWith("STD") && sLine[1].equals(getOwnerID()) && sLine[4].equals("Booked")){
                                ConsultationList.add(String.join("||",file.replace(".txt",""),FileContent));
                            }
                            break;
                    }
                });
            }
        }
        return ConsultationList;
    }
    public boolean DeleteConsultation(String Content) throws IOException{
        return FileController.DeleteRecordFromFile(new File("DATA/Consultation/" + getDate() + ".txt"),Content);
    }
    public boolean ValidateConsultation() throws IOException{
        boolean found = false;
        File f = new File("DATA/Consultation/" + getDate() + ".txt");
        if (f.exists()){
            int[] PKs = {0,2,3};
            String[] Vals = {lecturer.getUserID(),slot.getTimeFrame(),venue.getAllocatedVenue()};
            ArrayList<String> readFile = FileController.ReadFile(f, PKs, Vals);
            if (readFile.size() > 0){
                found = true;
            }
        }
        return found;
    }
    public void CreateConsultation() throws FileNotFoundException, UnauthorizationException, IOException{
       /* LECT001|null||10:00||B-06-01||Available||null */ 
       if (getDefinerID() == null || getDefinerID().startsWith("STD")){
            throw new UnauthorizationException("Student does not have permission to create Consultation");
        }
        ArrayList<String> CreateConsultationInfo = new ArrayList();
        CreateConsultationInfo.add(getDefinerID());
        CreateConsultationInfo.add("null");
        CreateConsultationInfo.add(slot.getTimeFrame());
        CreateConsultationInfo.add(venue.getAllocatedVenue());
        CreateConsultationInfo.add("Available");
        CreateConsultationInfo.add("null");
        String parseArray = FileController.ConstructArray(CreateConsultationInfo);
        int[] PKs = {0,2};
        String[] Vals = {getDefinerID(),slot.getTimeFrame()};
        File f = new File("DATA/Consultation/" + getDate() + ".txt");
        if (!f.exists()){
            FinalString = String.join("||",getDate(), parseArray);
        }
        else{
            ArrayList<String> ReadFile = FileController.ReadFile((f),PKs,Vals);
            if (ReadFile.isEmpty()){
                FinalString = String.join("||",getDate(), parseArray);
            }
        }           
    }
    public void BookConsultation(String reason) throws FileNotFoundException, UnauthorizationException, PrimaryKeyNotFoundException, IOException{
        /* LECT001|STD0001||10:00||B-06-01||Booked||Reason */
        if (getBookerID().startsWith("LECT")){
           throw new UnauthorizationException("Lecturer cannot book a Consultation");
        }
         int PKs[] = {0,1,2,3,4,5};
         String Vals[] = {getDefinerID(),"null",slot.getTimeFrame(),venue.getAllocatedVenue(),"Available","null"};
         ArrayList<String> ReadFile = FileController.ReadFile(new File("DATA/Consultation/" + getDate() + ".txt"), PKs,Vals);
        if (ReadFile.size() == 1){
            setReason(reason);
            ArrayList<String> BookConsultationInfo = new ArrayList();
            BookConsultationInfo.add(getDate());
            BookConsultationInfo.add(getDefinerID());
            BookConsultationInfo.add(getBookerID());
            BookConsultationInfo.add(slot.getTimeFrame());
            BookConsultationInfo.add(venue.getAllocatedVenue());
            BookConsultationInfo.add("Booked");
            BookConsultationInfo.add(getReason());
            FinalString = FileController.ConstructArray(BookConsultationInfo);
        }
    }
    public void CancelConsultation(String CancelBy) throws FileNotFoundException, PrimaryKeyNotFoundException, IOException{
        setOwnerID(CancelBy);
        /*
        * Book --> LECT001|STD0001||10:00||B-06-01||Booked||Reason
        * Create and Cancel -- > LECT001|null||10:00||B-06-01||Available||null
        * 0 --> Date
        * 1 --> DefinerID
        * 2 --> BookerID
        * 3 --> Slot
        * 4 --> Venue
        * 5 --> Status
        * 6 --> Reason(Optional)
        * 7 --> DefinerID
        * Standard Format --> Date||DefinerID||BookerID||Slot||Venue||Status||Reason
        */
        int PKs[] = {0,1,2,3,4};
        String Vals[] = {getDefinerID(),getBookerID(),slot.getTimeFrame(),venue.getAllocatedVenue(),"Booked"};
        ArrayList<String> FileContent = FileController.ReadFile(new File("DATA/Consultation/" + getDate() + ".txt"), PKs,Vals);
        if (!FileContent.isEmpty()){
            ArrayList<String> BookConsultationInfo = new ArrayList();
            BookConsultationInfo.add(getDate());
            BookConsultationInfo.add(getDefinerID());
            BookConsultationInfo.add("null");
            BookConsultationInfo.add(slot.getTimeFrame());
            BookConsultationInfo.add(venue.getAllocatedVenue());
            BookConsultationInfo.add("Available");
            BookConsultationInfo.add("null");
            BookConsultationInfo.add(student.getUserID());
            FinalString = FileController.ConstructArray(BookConsultationInfo);
        } 
    }
    public static List<Consultation> saveConsultation(List<Consultation> ConsultationDetails) throws FileNotFoundException, IOException, PrimaryKeyNotFoundException{
        //error logs hvt settled
        List<Consultation> ErrorContent = new ArrayList<>();
        ErrorContent.addAll(ConsultationDetails);
        int z = 1;
        boolean success = false;
        for(Consultation ConsultationDetail : ConsultationDetails){
            if (ConsultationDetail.toString() != null){
                String[] s_ConsultationDetail = ConsultationDetail.toString().split("\\|\\|");
                if (s_ConsultationDetail[5].equals("Available") || s_ConsultationDetail[5].equals("Booked")){
                    switch (s_ConsultationDetail[5]){
                        case "Available":
                                int[] PKs = {0,2,3,4};
                                String[] Vals = {s_ConsultationDetail[1],s_ConsultationDetail[3],s_ConsultationDetail[4],"Booked"};
                                File f = new File("DATA/Consultation/" + s_ConsultationDetail[0] + ".txt");
                                if (!f.exists()){
                                    f.createNewFile();
                                    String CreateConsultationHeaderDetails = "LectID||StdID||Time||Venue||Status||Reason";
                                    if (!FileController.ReadFirstLineOfTheFile(f).equals(CreateConsultationHeaderDetails)){
                                        FileController.WriteFile(new File("DATA/Consultation/" + s_ConsultationDetail[0] + ".txt"),CreateConsultationHeaderDetails);
                                    }
                                }
                                ArrayList<String> ValidateConsultation = FileController.ReadFile(f, PKs, Vals);
                                if (ValidateConsultation.isEmpty()){
                                    String CreateConsultationDetails = s_ConsultationDetail[1] + "||" + s_ConsultationDetail[2] + "||" + s_ConsultationDetail[3] + "||" + s_ConsultationDetail[4] + "||" + s_ConsultationDetail[5] + "||" + s_ConsultationDetail[6];
                                    success = FileController.WriteFile(new File("DATA/Consultation/" + s_ConsultationDetail[0] + ".txt"),CreateConsultationDetails); 
                                }
                                else{
                                    int[] WherePKs = {0,2,3,4};
                                    String[] WhereVals = {s_ConsultationDetail[1],s_ConsultationDetail[3],s_ConsultationDetail[4],"Booked"};
                                    int[] UpdatePKs = {0,1,2,3,4,5};
                                    String[] UpdateVals = {s_ConsultationDetail[1],s_ConsultationDetail[2],s_ConsultationDetail[3],s_ConsultationDetail[4],s_ConsultationDetail[5],s_ConsultationDetail[6]};
                                    if (FileController.UpdateFile(new File("DATA/Consultation/" + s_ConsultationDetail[0] + ".txt"),WherePKs,WhereVals,UpdatePKs,UpdateVals) == true){
                                        success = true;
                                        if (s_ConsultationDetail[7].startsWith("STD")){
                                           setLogsToStudent(ConsultationDetail.toString());
                                        }
                                    }
                                }
                            break;
                        case "Booked":
                            int[] WherePKs = {0,2,3,4};
                            String[] WhereVals = {s_ConsultationDetail[1],s_ConsultationDetail[3],s_ConsultationDetail[4],"Available"};
                            int[] UpdatePKs = {0,1,2,3,4,5};
                            String[] UpdateVals = {s_ConsultationDetail[1],s_ConsultationDetail[2],s_ConsultationDetail[3],s_ConsultationDetail[4],s_ConsultationDetail[5],s_ConsultationDetail[6]};
                            success = FileController.UpdateFile(new File("DATA/Consultation/" + s_ConsultationDetail[0] + ".txt"),WherePKs,WhereVals,UpdatePKs,UpdateVals);
                            break;
                    }
                }
                else{
                    success = false;
                }
            }
            if (success == true){
                ErrorContent.remove(ConsultationDetail);
            }
            z++;
        }
        if (ConsultationDetails.equals(z)){
            ErrorContent.remove(null);
        }
        return ErrorContent;
    }
    @Override
    public String toString(){
        return FinalString;
    }
}