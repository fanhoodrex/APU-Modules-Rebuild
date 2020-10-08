package Classes;

import java.io.*;
import java.util.ArrayList;
public class Slot{
    private final int SESSIONPERSLOT = 30;
    private String TimeFrame;
    public Slot(){
    
    }
    public Slot(String timeframe){
        setTimeFrame(timeframe);
    }
    private void setTimeFrame(String TimeFrame){
        this.TimeFrame = TimeFrame;
    }
    public String getTimeFrame() {
        return TimeFrame;
    }
    
    public ArrayList<String> DefaultSlotsGenerator(){
        ArrayList<String> sessions = new ArrayList();
        for (int i = 10;i<=17;i++){
            for(int x = 60;x>1;x-=SESSIONPERSLOT){                
                sessions.add(i + ":" + ((x == 60) ? "00" : x));
            }
        }
        return sessions;
    }
    public boolean SaveDefaultSlotList() throws Exception{
        ArrayList<String>arrDefaultSlots = DefaultSlotsGenerator();
        return FileController.WriteFile(new File("ConsultationSlot(Default).txt"),arrDefaultSlots);
    }
    public ArrayList<String> readSlotFromDB() throws FileNotFoundException, IOException{
        File f = new File("DATA/Default/ConsultationSlot(Default).txt");
        ArrayList<String> slotList = new ArrayList();
        if (f.exists()){
            slotList = FileController.ReadFile(f);
        }
        return slotList;
    }
}