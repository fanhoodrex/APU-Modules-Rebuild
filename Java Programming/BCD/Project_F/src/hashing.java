import java.io.*;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.List;

public class hashing {
    //通过指定算法获取数据hash值
    public static String genHash(String data, String algorithm) throws Exception{
        MessageDigest md = MessageDigest.getInstance(algorithm);
        byte[] hashcode = md.digest(data.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < hashcode.length; i++) {
            sb.append(Integer.toString((hashcode[i] & 0xff) + 0x100, 16 ).substring(1));
        }
        return sb.toString();
    }

    //对包进行加密（各属性转换为数组后进行拼接生成一大串数组）
    public static String HashingBlock(String previoushash, List<String> data, long timestamp, String digitalSignature, String algorithm) throws Exception{
        byte[] B_data = ListToByteArray(data);
        byte[] B_previoushash = previoushash.getBytes("UTF-8");
        byte[] B_timestamp = longToBytes(timestamp);
        byte[] B_digitalSignature = digitalSignature.getBytes("UTF-8");
        byte[] B_input = MergeByte(MergeByte(MergeByte(B_data, B_previoushash), B_digitalSignature), B_timestamp);
        MessageDigest md = MessageDigest.getInstance(algorithm);
        byte[] blockhash = md.digest(B_input);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < blockhash.length; i++) {
            sb.append(Integer.toString((blockhash[i] & 0xff) + 0x100, 16 ).substring(1));
        }
        System.out.println(sb);
        return sb.toString();
    }

    //将两个数组合并为一个数组
    public static byte[] MergeByte(byte[] bt1, byte[] bt2){
        byte[] bt3 = new byte[bt1.length+bt2.length];
        System.arraycopy(bt1, 0, bt3, 0, bt1.length);
        System.arraycopy(bt2, 0, bt3, bt1.length, bt2.length);
        return bt3;
    }

    //将long格式转换为数组
    private static ByteBuffer buffer = ByteBuffer.allocate(8);
    private static byte[] longToBytes(long x) {
        buffer.putLong(0, x);
        return buffer.array();
    }

    //将list格式转换为数组
    public static byte[] ListToByteArray(List<String> data) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos;
        if (data != null) {
            try {
                oos = new ObjectOutputStream(baos);
                oos.writeObject(data);
                oos.flush();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                return null;
            }
            return baos.toByteArray();
        } else {
            return null;
        }
    }
}