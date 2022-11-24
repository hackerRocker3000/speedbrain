package com.dimdof;

import com.dimdof.math.HashService;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class Main {
    public static void main(String[] args) {
        try {
            HashService.init();
            byte[] inputData = args[0].getBytes(StandardCharsets.UTF_8);
            byte[] privateKey = HashService.calcSHA256(inputData);
            long time1 = System.nanoTime();
            for (int i = 0; i < 100; i++) HashService.calcSHA256(inputData);
            long time2 = System.nanoTime();
            System.out.println(time1 - time2);

            byte[] publicKey = HashService.getPublicKey( privateKey);
            time1 = System.nanoTime();
            for (int i = 0; i < 100; i++) HashService.getPublicKey( privateKey);
            time2 = System.nanoTime();
            System.out.println(time1 - time2);

            byte[]  publicSha256 = HashService.calcSHA256( publicKey);
            time1 = System.nanoTime();
            for (int i = 0; i < 100; i++) HashService.calcSHA256( publicKey);
            time2 = System.nanoTime();
            System.out.println(time1 - time2);

            time1 = System.nanoTime();
            for (int i = 0; i < 100; i++) HashService.calcRipeMD160( publicSha256);
            time2 = System.nanoTime();
            System.out.println(time1 - time2);

            time1 = System.nanoTime();
            for (int i = 0; i < 100; i++) {
                HashService.calcRipeMD160(HashService.calcSHA256(HashService.getPublicKey(HashService.calcSHA256(inputData))));
            }
            time2 = System.nanoTime();
            System.out.println(time1 - time2);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (NoSuchProviderException e) {
            throw new RuntimeException(e);
        }
    }
}