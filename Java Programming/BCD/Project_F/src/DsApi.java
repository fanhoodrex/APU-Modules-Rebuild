package Code;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class DsApi {
    public static final String PUBLICKEY_FILE = "KeyPair/PublicKey";
    public static final String PRIVATEKEY_FILE = "KeyPair/PrivateKey";

    public static void Keygen(){
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(512);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            RSAPublicKey rsaPublicKey = (RSAPublicKey)keyPair.getPublic();
            RSAPrivateKey rsaPrivateKey = (RSAPrivateKey)keyPair.getPrivate();
            persist( "KeyPair/PublicKey", rsaPublicKey.getEncoded() );
            persist( "KeyPair/PrivateKey", rsaPrivateKey.getEncoded() );
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static String sign(String data) throws Exception{

        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(getPrivateKey().getEncoded());
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        Signature signature = Signature.getInstance("SHA256WithRSA");
        signature.initSign( privateKey );
        signature.update( data.getBytes() );
        //generate the digital signature
        byte[] dsBytes = signature.sign();
        return Base64.getEncoder().encodeToString(dsBytes);
    }

    public static boolean verify(String data, String DS) throws Exception{
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(getPublicKey().getEncoded());
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        Signature signature = Signature.getInstance("SHA256WithRSA");
        signature.initVerify(publicKey);
        signature.update( data.getBytes() );
        return signature.verify( Base64.getDecoder().decode(DS) );

    }

    public static void persist( String path, byte[] key ){
        File file = new File( path );
        file.getParentFile().mkdirs();
        try {
            //write key to file
            Files.write( Paths.get( path ), key, StandardOpenOption.CREATE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static PublicKey getPublicKey() throws Exception{
        byte[] keyBytes = Files.readAllBytes( Paths.get(PUBLICKEY_FILE) );
        X509EncodedKeySpec s = new X509EncodedKeySpec( keyBytes );
        return KeyFactory.getInstance("RSA").generatePublic(s);
    }

    private static PrivateKey getPrivateKey() throws Exception{
        byte[] keyBytes = Files.readAllBytes( Paths.get(PRIVATEKEY_FILE) );
        PKCS8EncodedKeySpec s = new PKCS8EncodedKeySpec( keyBytes );
        return KeyFactory.getInstance("RSA").generatePrivate(s);
    }
}