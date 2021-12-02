import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Demo {
    static LinkedList<Block> bchain = new LinkedList();

    public static void main(String[] args) throws Exception {
        GenesisBlock();
        for (int i = 3; i < 14; i++){
            genNextBlock(i);
        }
        System.out.println("Encrypted successfully");
    }
//生成第一个块的代码
    public static void GenesisBlock() throws Exception {
        String msg = "Staff";
        String DigitalSignature = Ds.sign(msg);
        if (Ds.verify(msg,DigitalSignature)){
            List<String> filedata = FileReader("data/Data.txt", 2);
            List<String> data = new ArrayList();
            for (int j=0; j<9;j++) {
                try {
                    data.add("val" + j + ": " + hashing.genHash(filedata.get(j), "SHA-256"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Block firstblock = new Block("0", data, DigitalSignature); //genesis block
            bchain.add(firstblock);
            blockchain.empty();
            blockchain.persist(bchain);
            format2json(bchain);
        }
        else {
            System.out.println("The data provided seems to be tampered, or the key is invalid.");
        }
    }
    //生成后续块的代码
    public static void genNextBlock(int i) throws Exception {
        String msg = "Staff";
        String DigitalSignature = Ds.sign(msg);
        if (Ds.verify(msg,DigitalSignature)){
        //利用数字签名对msg进行加密并且验证该块由私钥持有者进行加密

            List<String> filedata = FileReader("data/Data.txt", i);
            List<String> data = new ArrayList();
            for (int j=0; j<9; j++) {
                try {
                    data.add("val" + j + ": " + hashing.genHash(filedata.get(j), "SHA-256"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            //代码来自老师sample，推荐查看上课视频
            bchain = blockchain.get();
            Block block = new Block(bchain.getLast().getCurrentHash(), data, DigitalSignature);
            bchain.add(block);
            blockchain.empty();
            blockchain.persist(bchain);
            format2json(bchain);
        }
        else {
            System.out.println("The data provided seems to be tampered, or the key is invalid.");
        }
    }

    //读取文件所需行，以+为分隔符保存至Listcontent
    public static List<String> FileReader(String fileName, int line) {
        File file = new File(fileName);
        BufferedReader reader = null;
        String content = null;
        List<String> Listcontent = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            for(int i=0; i<line; i++){
                content = reader.readLine();
            }
            Listcontent = Arrays.asList(content.split("\\+"));
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

    //将linkedlist格式转换为json（使用gson包）
    public static void format2json(LinkedList<Block> bchain){
        String temp = new GsonBuilder().setPrettyPrinting().create().toJson(bchain);
        blockchain.distribute(temp);
    }
}