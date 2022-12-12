package com.dimdof;

import com.dimdof.math.FileService;
import com.dimdof.math.GeneratorStr;
import com.dimdof.math.HashService;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            HashService.init();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (NoSuchProviderException e) {
            throw new RuntimeException(e);
        }
        GeneratorStr genStr = new GeneratorStr("0123456789abcdefghijklmnopqrstuvwxyz".toCharArray());
        String brainWord = "0";
        byte[] brainBytes = brainWord.getBytes();

        String[] base = FileService.readBase("H:\\vsakie_raschety\\BrainWords-main\\Windows\\hashes160_sorted.txt");

        long time1 = System.nanoTime();
        while (true) {
            try {
                brainWord = genStr.next(brainWord);
                String hash160 = HashService.getHex(HashService.calcRipeMD160(HashService.calcSHA256(HashService.getPublicKey(HashService.calcSHA256(brainWord.getBytes())))));
                if (Arrays.binarySearch(base, hash160.toLowerCase()) >= 0) {
                    break;
                }
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
        long time2 = System.nanoTime();
        System.out.println(time2 - time1);
        System.out.println(brainWord);
    }
}