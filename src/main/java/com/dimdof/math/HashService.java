package com.dimdof.math;

import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.math.ec.ECPoint;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.util.Base64;

public class HashService {
    private static final String HEXES = "0123456789ABCDEF";
    private static MessageDigest sha256;
    private static MessageDigest ripeMD160;
    private static ECNamedCurveParameterSpec spec;
    private static byte[] P256_HEAD = Base64.getDecoder().decode("MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAE");

    public static void init() throws NoSuchAlgorithmException, NoSuchProviderException {
        Security.addProvider(new BouncyCastleProvider());
        ripeMD160 = MessageDigest.getInstance("RipeMD160", "BC");
        sha256 = MessageDigest.getInstance("SHA-256");
        spec = ECNamedCurveTable.getParameterSpec("secp256k1");
    }

    public static byte[] calcSHA256(byte[] inputData) throws NoSuchAlgorithmException {
        return sha256.digest(inputData);
    }

    public static byte[] calcRipeMD160(byte[] inputData) {
        return ripeMD160.digest(inputData);
    }

    public static String getHex(byte[] raw) {
        final StringBuilder hex = new StringBuilder(2 * raw.length);
        for (final byte b : raw) {
            hex.append(HEXES.charAt((b & 0xF0) >> 4)).append(HEXES.charAt((b & 0x0F)));
        }
        return hex.toString();
    }


    public static byte[] getPublicKey(byte[] privateKey) {
        ECPoint pointQ = spec.getG().multiply(new BigInteger(1, privateKey));

        return pointQ.getEncoded(true);
    }
}