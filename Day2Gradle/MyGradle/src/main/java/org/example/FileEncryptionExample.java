package org.example;

import java.io.*;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.salt.StringFixedSaltGenerator;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileEncryptionExample {
    public static void main(String[] args) throws IOException {
        String encryptedOutputFilePath = "encrypted_abc.txt";
        String decryptedOutputFilePath = "decrypted_abc.txt";

        final String PW = "12341234";
        final String ALGORITHM = "PBEWithMD5AndDES";
        final String SALT_GENERATOR = "someFixedSalt";

        // TODO: 위 정보를 이용해서 "encryptedOutputFilePath" 파일을 읽고 복호화 하영합니다.
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        encryptor.setPassword(PW);
        encryptor.setAlgorithm(ALGORITHM);
        encryptor.setSaltGenerator(SALT_GENERATOR);

        System.out.println("Decryption completed successfully.");
    }

    private static String readTextFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }
}