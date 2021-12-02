package blkchain.core;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import blkchain.shautils.HashingUtils;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import org.javatuples.Septet;

public class Block implements Serializable {

    public Block(List<List<String>> data, String previoushash) {
        List<Septet<String, String, String, String, String, String, String>> hashes = 
                data.stream().map( elem -> Septet.fromCollection(elem) ).collect(Collectors.toList());
        this.previoushash = previoushash;
        this.data = hashes;
        this.timestamp = Calendar.getInstance().getTimeInMillis();
        this.currentHash = this.blockHashCode(Block.genByteArr(this.data), this.previoushash, this.timestamp);
    }
//    public Block(String data, String previoushash) {
//        this.data = data;
//        this.previoushash = previoushash;
//        this.timestamp = Calendar.getInstance().getTimeInMillis();
//        //gen current hash value
//        this.currentHash = this.blockHashCode(this.data, this.previoushash, this.timestamp);
//    }

    private String currentHash;
    private String previoushash;
//    private String data;
    private List<Septet<String, String, String, String, String, String, String>> data;
    private long timestamp;

    public List<Septet<String, String, String, String, String, String, String>> getData() {
        return data;
    }

    public void setData(List<Septet<String, String, String, String, String, String, String>> data) {
        this.data = data;
    }

    public String getCurrentHash() {
        return currentHash;
        
    }

    public String getPrevioushash() {
        return previoushash;
    }

    public void setCurrentHash(String currentHash) {
        this.currentHash = currentHash;
    }

    public void setPrevioushash(String previoushash) {
        this.previoushash = previoushash;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

//    ---- Unused method ----
//    public String blockHashCode() {
//        return HashingUtils.hash(Block.genByteArr(this), "SHA-256");
//    }

    public String blockHashCode(byte[] data, String prehash, long tmestamp) {
        return HashingUtils.newhash(
                data + prehash + tmestamp,
                "SHA-256");
    }

//    private static byte[] genByteArr(Block b) {
    private static byte[] genByteArr(List<Septet<String, String, String, String, String, String, String>> b) {
        ByteArrayOutputStream boas = new ByteArrayOutputStream();
        ObjectOutputStream out;
        if (b != null) {
            try {
                out = new ObjectOutputStream(boas);
                out.writeObject(b);
                out.flush();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                return null;
            }
            return boas.toByteArray();
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Current Hash:" + this.currentHash + "\nPrevious Hash:" + this.previoushash + "\n";
    }

}
