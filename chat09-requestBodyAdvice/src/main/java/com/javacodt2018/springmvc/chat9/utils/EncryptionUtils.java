package com.javacodt2018.springmvc.chat9.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import lombok.extern.java.Log;

/**
 * 加密工具类
 */
@Log
public class EncryptionUtils {

    private static String key = "abcdef0123456789";

    public static void main(String[] args) throws Exception {

        System.out.println(
                "\"oasdjfasldjflkads\".substring(0,5) = " + "oasdjfasldjflkads".substring(0, 5));
       /* m2();
        m1();*/
        /*splitDataToSaveFile(929000, new File(
                        "E:\\cache\\weixin\\Documents\\WeChat Files\\wxid_hx5fk5rxpy2v22\\FileStorage\\File\\2022-05\\nj202204.txt"),
                "C:\\Users\\crush\\Desktop\\ertertret");
*/
        /*File src = new File("E:\\cache\\weixin\\Documents\\WeChat Files\\wxid_hx5fk5rxpy2v22\\FileStorage\\File\\2022-05\\nj202204.txt");
        String cont = read(src);
        System.out.println(cont);
// 对得到的内容进行处理
        cont = cont.replaceAll("$", "'");
        System.out.println(cont);
// 更新源文件
        System.out.println(write(cont, src));*/
    }

    private static void m1() {
        String body = "{\"name\":\"路人\",\"age\":30}";
        String encryptBody = EncryptionUtils.encrypt(body);
        System.out.println(encryptBody);
        String desEncryptBody = EncryptionUtils.desEncrypt(encryptBody);
        System.out.println(desEncryptBody);
    }

    private static void m2() {
        String body = "[{\"name\":\"路人\",\"age\":30},{\"name\":\"springmvc高手系列\",\"age\":30}]";
        String encryptBody = EncryptionUtils.encrypt(body);
        System.out.println(encryptBody);
        String desEncryptBody = EncryptionUtils.desEncrypt(encryptBody);
        System.out.println(desEncryptBody);
    }

    private static String AESTYPE = "AES/CBC/PKCS5Padding";

    /**
     * 加密明文
     *
     * @param plainText 明文
     * @return
     * @throws Exception
     */
    public static String encrypt(String plainText) {
        try {
            Cipher cipher = Cipher.getInstance(AESTYPE);
            byte[] dataBytes = plainText.getBytes("utf-8");
            byte[] plaintext = new byte[dataBytes.length];
            System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(key.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
            byte[] encrypted = cipher.doFinal(plaintext);
            return new String(Base64.getEncoder().encode(encrypted), "UTF-8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 解密密文
     *
     * @param encryptData 密文
     * @return
     * @throws Exception
     */
    public static String desEncrypt(String encryptData) {
        try {
            Cipher cipher = Cipher.getInstance(AESTYPE);
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(key.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
            byte[] original = cipher.doFinal(
                    Base64.getDecoder().decode(encryptData.getBytes("UTF-8")));
            return new String(original, "utf-8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static List<File> splitDataToSaveFile(int rows, File sourceFile,
            String targetDirectoryPath) {
        long startTime = System.currentTimeMillis();
        List<File> fileList = new ArrayList<>();
        log.info("开始分割文件");
        File targetFile = new File(targetDirectoryPath);
        if (!sourceFile.exists() || rows <= 0 || sourceFile.isDirectory()) {
            return null;
        }
        if (targetFile.exists()) {
            if (!targetFile.isDirectory()) {
                return null;
            }
        } else {
            targetFile.mkdirs();
        }

        try (FileInputStream fileInputStream = new FileInputStream(
                sourceFile); InputStreamReader inputStreamReader = new InputStreamReader(
                fileInputStream,
                StandardCharsets.UTF_16LE); BufferedReader bufferedReader = new BufferedReader(
                inputStreamReader)) {
            StringBuilder stringBuilder = new StringBuilder();
            String lineStr;
            int lineNo = 1, fileNum = 1;
            while ((lineStr = bufferedReader.readLine()) != null) {
                stringBuilder.append(lineStr).append("\r\n");
                if (lineNo % rows == 0) {
                    File file = new File(
                            targetDirectoryPath + File.separator + fileNum + sourceFile.getName());
                    writeFile(stringBuilder.toString(), file);
                    //清空文本
                    stringBuilder.delete(0, stringBuilder.length());
                    fileNum++;
                    fileList.add(file);
                }
                lineNo++;
            }
            if ((lineNo - 1) % rows != 0) {
                File file = new File(
                        targetDirectoryPath + File.separator + fileNum + sourceFile.getName());
                writeFile(stringBuilder.toString(), file);
                fileList.add(file);
            }
            long endTime = System.currentTimeMillis();
            log.info("分割文件结束，耗时：{}秒" + (endTime - startTime) / 1000);
        } catch (Exception e) {
            log.info("分割文件异常");
        }
        return fileList;
    }

    private static void writeFile(String text, File file) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(
                file); OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                fileOutputStream,
                StandardCharsets.UTF_8); BufferedWriter bufferedWriter = new BufferedWriter(
                outputStreamWriter, 1024)) {
            bufferedWriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String read(File src) {
        StringBuffer res = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(src));
            while ((line = reader.readLine()) != null) {
                res.append(line + "\n");
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res.toString();
    }

    public static boolean write(String cont, File dist) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(dist));
            writer.write(cont);
            writer.flush();
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


}
