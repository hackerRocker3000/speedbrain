package com.dimdof;

import com.dimdof.math.FileService;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] base = FileService.readBase("H:\\vsakie_raschety\\BrainWords-main\\Windows\\Bitcoin_addresses_November_20_2022.txt");

        byte[] existValue = "1EWqhfPMtKUutHdjPrXQUnyYx1oe2SJCd".getBytes(StandardCharsets.UTF_8);
        byte[] notExistValue = "3FrpMoH1WJCqDxS8RQ7Kn1j6LZtDh9cg00".getBytes(StandardCharsets.UTF_8);

        long time1 = System.nanoTime();
        for (int i = 0; i < 100; i++) Arrays.binarySearch(base, new String(existValue));
        long time2 = System.nanoTime();
        System.out.println(time1 - time2);
        System.out.println(Arrays.binarySearch(base, new String(existValue)));


        time1 = System.nanoTime();
        for (int i = 0; i < 100; i++) Arrays.binarySearch(base,  new String(notExistValue));
        time2 = System.nanoTime();
        System.out.println(time1 - time2);

//        time1 = System.nanoTime();
//        for (int i = 0; i < 100; i++) SearchService.compare(str1, str2);
//        time2 = System.nanoTime();
//        System.out.println(time1 - time2);
//
//        time1 = System.nanoTime();
//        for (int i = 0; i < 100; i++) args[1].compareTo(new String(str1));
//        time2 = System.nanoTime();
//        System.out.println(time1 - time2);


//        try {
//            HashService.init();
//            byte[] inputData = args[0].getBytes(StandardCharsets.UTF_8);
//            byte[] privateKey = HashService.calcSHA256(inputData);
//            long time1 = System.nanoTime();
//            for (int i = 0; i < 100; i++) HashService.calcSHA256(inputData);
//            long time2 = System.nanoTime();
//            System.out.println(time1 - time2);
//
//            byte[] publicKey = HashService.getPublicKey( privateKey);
//            time1 = System.nanoTime();
//            for (int i = 0; i < 100; i++) HashService.getPublicKey( privateKey);
//            time2 = System.nanoTime();
//            System.out.println(time1 - time2);
//
//            byte[]  publicSha256 = HashService.calcSHA256( publicKey);
//            time1 = System.nanoTime();
//            for (int i = 0; i < 100; i++) HashService.calcSHA256( publicKey);
//            time2 = System.nanoTime();
//            System.out.println(time1 - time2);
//
//            time1 = System.nanoTime();
//            for (int i = 0; i < 100; i++) HashService.calcRipeMD160( publicSha256);
//            time2 = System.nanoTime();
//            System.out.println(time1 - time2);
//
//            time1 = System.nanoTime();
//            for (int i = 0; i < 100; i++) {
//                HashService.calcRipeMD160(HashService.calcSHA256(HashService.getPublicKey(HashService.calcSHA256(inputData))));
//            }
//            time2 = System.nanoTime();
//            System.out.println(time1 - time2);
//        } catch (NoSuchAlgorithmException e) {
//            throw new RuntimeException(e);
//        } catch (NoSuchProviderException e) {
//            throw new RuntimeException(e);
//        }
    }
}