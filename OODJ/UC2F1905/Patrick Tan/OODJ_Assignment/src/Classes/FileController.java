package Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileController{
    public static String ReadFirstLineOfTheFile(File file) throws FileNotFoundException, IOException{
        ArrayList<String> lazRec = ReadFile(file);
        int RecSize = lazRec.size();
        if (RecSize > 0){
            return lazRec.get(0);
        }
        else{
            return "";
        }
    }
    public static String ReadLastLineOfTheFile(File file) throws FileNotFoundException, IOException{
        ArrayList<String> lazRec = ReadFile(file);
        int RecSize = lazRec.size();
        if (RecSize > 0){
            return lazRec.get(RecSize-1);
        }
        else{
            return null;
        }
    }
    public static boolean DeleteRecordFromFile(File file,String ExpectedDeletedData) throws FileNotFoundException, IOException{
        boolean success = false;
        File f = new File(file.getName() + "-temp.txt");
        ArrayList<String> OriContents = ReadFile(file);
        int i = 0;
        try (PrintWriter pw = new PrintWriter(new FileWriter(f))) {
            
            for (String OriContent : OriContents){
                if (!OriContent.equals(ExpectedDeletedData)){
                    pw.println(OriContent);
                }
                else{
                    i++;
                }
            }
            pw.close();
            if (i > 0){
                if (file.delete()){
                    f.renameTo(file);
                    success = true;
                }
            }
            else{
                f.delete();
            }
        } 
        return success;
    }
    public static String ConstructArray(ArrayList<String> Arrays){
        int i = 1;
        String Result = "";
        for (String Array : Arrays){
            Result += Array;
            if (i != Arrays.size()){
                Result += "||";
            }
            i++;
        }
        return Result;
    }
    public static boolean reWriteFile(File FileTarget, ArrayList<String> DataContents) throws IOException{
        boolean success = false;
        int x = 0;
        try (PrintWriter pw = new PrintWriter(new FileWriter(FileTarget))) {
            for (String DataContent : DataContents){
                pw.println(DataContent);
                 x++;
            }
            pw.close();
        }        
        if (x > 0){
            success = true;
        }
        return success;
    }
    public static boolean WriteFile(File FileTarget,ArrayList<String> DataContents) throws IOException{
        boolean success = false;
        if (!DataContents.isEmpty()){
            success = true;
            if (!FileTarget.exists()){
                if (FileTarget.createNewFile()){
                    success = true;
                }
            }        
            int x = 0;
            try (PrintWriter pw = new PrintWriter(new FileWriter(FileTarget,true))) {
                for (String DataContent : DataContents){
                    pw.println(DataContent);
                    x++;
                }
                pw.close();
            }
            if (x > 0){
               success = true;
            }
        }
        return success;
    }
    public static boolean WriteFile(File FileTarget,String DataContents) throws IOException{
        boolean success = false;
        if (!DataContents.isEmpty()){
            if (!FileTarget.exists()){
               FileTarget.createNewFile();
            }        
            try (PrintWriter pw = new PrintWriter(new FileWriter(FileTarget,true))) {
                pw.println(DataContents);
                success = true;
                pw.close();
            }
        }
        return success;
    }
    //ReadFile(new File("users.txt"),{0,1},{"admin","admin"});
    public static ArrayList<String> ReadFile(File FileTarget,int[] PKs,String[] Vals) throws FileNotFoundException, IOException{
        ArrayList<String> FileContent = new ArrayList();
        Scanner sc = new Scanner(FileTarget); 
        if (PKs.length > 0 && Vals.length > 0 && sc.hasNextLine()){
            String Header = sc.nextLine();
            String[] s_Header = Header.split("\\|\\|");
                while (sc.hasNextLine()){
                    String Line = sc.nextLine();
                    String[] s_Line = Line.split("\\|\\|");
                    int i = 0;
                    boolean found = true;
                    for(int PK : PKs){
                        if (!s_Line[PK].equals(Vals[i])){
                            found = false;                   
                        }
                        i++;
                    }
                    if (found == true){
                        FileContent.add(Line);
                    }
                }
                sc.close();
        }    
        return FileContent;
    }
    public static ArrayList<String> ReadFile(File FileTarget) throws FileNotFoundException, IOException{        
        ArrayList<String> FileContent = new ArrayList();
        if (!FileTarget.exists()){
            FileTarget.createNewFile();
        }
        Scanner sc = new Scanner(FileTarget);
        while (sc.hasNextLine()){
            String Line = sc.nextLine();
            FileContent.add(Line);
        }
        sc.close();
        return FileContent;
    }
    public static ArrayList<String> ReadFile(File FileTarget,String dataContent) throws FileNotFoundException{
        ArrayList<String> FileContent = new ArrayList();
        if (FileTarget.exists()){
            Scanner sc = new Scanner(FileTarget);
            while (sc.hasNextLine()){
                String Line = sc.nextLine();
                if (Line.equals(dataContent)){
                    FileContent.add(Line);
                }
            }
            sc.close();
        }
        return FileContent;
    }
    //UpdateFile(new File("Users.txt"),{0,1},{"admin","admin"},{"admin","Ok!!"});
    public static boolean UpdateFile(File OldFile,int[] WherePKs,String[] WherePKVals,int[] UpdatePKs, String[] UpdatePKVals) throws FileNotFoundException, IOException{
        File NewFile = new File(OldFile.getName() + "-temp.txt");
        boolean success;
        if (WherePKs.length > 0 && WherePKVals.length > 0 && OldFile.exists() && UpdatePKVals.length > 0 && WherePKs.length == WherePKVals.length && UpdatePKs.length == UpdatePKVals.length){
            try (Scanner sc = new Scanner(OldFile); PrintWriter pw = new PrintWriter(new FileWriter(NewFile,true))) {
                while (sc.hasNextLine()){
                    String Line = sc.nextLine();
                    String[] s_Line = Line.split("\\|\\|");
                    int i = 0;
                    for(int PK : WherePKs){
                        if (s_Line[PK].equals(WherePKVals[i])){
                           i++;
                        }                        
                    }
                    if (i == WherePKs.length){
                        int x = 0;
                        for (int updatePK : UpdatePKs){
                            s_Line[updatePK] = UpdatePKVals[x]; 
                            x++;
                        }
                        int y = 0;
                        Line = "";
                        for (String val : s_Line){
                            Line += val;
                            if (y != s_Line.length-1){
                                Line += "||";
                            }
                            y++;
                        }
                    }
                    pw.println(Line);
                }
                sc.close();
                pw.close();
            }
            if (OldFile.delete()){
                NewFile.renameTo(OldFile);
                success = true;
            }
            else{
                NewFile.delete();
                success = false;
            }
        }
        else{
            success = false;
        }            
        return success;
    }
}