import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;

public class blockchain {
    private static final String BCHAIN_FILE = "blockchain.dat";

    public static void persist( LinkedList<Block> chain ){
        try(FileOutputStream fos = new FileOutputStream( BCHAIN_FILE )) {
            ObjectOutputStream out = new ObjectOutputStream( fos );
            out.writeObject(chain);
        }catch (Exception e){ e.printStackTrace(); }
    }

    public static LinkedList<Block> get(){
        //read the LinkedList to the binary file
        try(FileInputStream fis = new FileInputStream( BCHAIN_FILE);
            ObjectInputStream in = new ObjectInputStream( fis ); ) {
            return (LinkedList<Block>)in.readObject();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void distribute( String temp ){
        try {
            Files.write(Paths.get("data.txt"),
                    temp.getBytes(),
                    StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void empty(){
        try {
            FileChannel.open(Paths.get(BCHAIN_FILE), StandardOpenOption.WRITE).truncate(0).close();
        } catch (IOException ex) { }
    }
}