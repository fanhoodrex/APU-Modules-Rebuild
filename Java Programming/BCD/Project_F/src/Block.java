import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

public class Block implements Serializable {
    private String currenthash;
    private String previoushash;
    private List<String> data;
    private long timestamp;

    public Block(String previoushash, List<String> data) {
        this.previoushash = previoushash;
        this.currenthash = this.blockhash("SHA-256");
        this.data = data;
        this.timestamp = Calendar.getInstance().getTimeInMillis();
    }

    public String getCurrenthash() {
        return currenthash;
    }

    public void setCurrenthash(String currenthash) {
        this.currenthash = currenthash;
    }

    public String getPrevioushash() {
        return previoushash;
    }

    public void setPrevioushash(String previoushash) {
        this.previoushash = previoushash;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String blockhash (String algorithm){
        try {
            return hashing.BlockHash(this.previoushash, this.data, this.timestamp, algorithm);
        } catch (Exception e) {
            return null;
        }
    }

    public String getCurrentHash() {
        return currenthash;
    }
}