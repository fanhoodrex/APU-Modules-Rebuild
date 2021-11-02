package Code;

import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class run {
    static LinkedList<Block> bchain = new LinkedList();

    public static void main(String[] args) throws Exception {
        String msg = "Admin";
        String ds = DsApi.sign(msg);
        if (DsApi.verify(msg,ds)){
            System.out.println("Authentication succeeded");
            //firstBlock();
            for (int i = 1; i < 4; i++){
                nextBlock(i);
            }
            System.out.println("Encrypted successfully");
        }
    }

    public static void firstBlock() {
        String[] data = new String[8];
        List<String> content = run.readFileByLines("transaction", 1);
        for (int j=0; j<8;j++) {
            try {
                data[j] = "val"+ j + ": " + hashing.genHash(content.get(j), "SHA-256");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Block fb = new Block("0", data); //genesis block
        bchain.add(fb);
        blockchain.empty();
        blockchain.persist(bchain);
        format2json(bchain);

    }

    public static void nextBlock(int i){
        String[] data = new String[8];
        List<String> content = run.readFileByLines("transaction", i);
        for (int j=0; j<8;j++) {
            try {
                data[j] = "val"+ j + ": " + hashing.genHash(content.get(j), "SHA-256");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        bchain = blockchain.get();
        Block fb = new Block(bchain.getLast().getCurrentHash(), data);
        bchain.add(fb);
        blockchain.empty();
        blockchain.persist(bchain);
        format2json(bchain);
    }

    public static List<String> readFileByLines(String fileName, int line) {
        File file = new File(fileName);
        BufferedReader reader = null;
        String content = null;
        List<String> Listcontent = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            for(int i=0; i<line; i++){
                content = reader.readLine();
            }
            Listcontent = Arrays.asList(content.split("\\*"));
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return Listcontent;
    }

    public static void format2json(LinkedList<Block> bchain){
        String temp = new GsonBuilder().setPrettyPrinting().create().toJson(bchain);
        blockchain.distribute(temp);
    }
}

