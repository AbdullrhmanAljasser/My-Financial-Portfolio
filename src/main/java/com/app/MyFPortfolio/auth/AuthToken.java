package com.app.MyFPortfolio.auth;

import java.util.Date;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AuthToken {

    private final String token;
    private final String refresh;
    private final Date expiry;

    private static final Charset UTF_8 = StandardCharsets.UTF_8;

    public static byte[] digest(byte[] input, String algorithm) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
        byte[] result = md.digest(input);
        return result;
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    // public AuthToken() {
    // this.
    // }

    public AuthToken(String pwd) {
        String algorithm = "SHA3-256";
        this.refresh = "to be assigned refresh token retrieved";
        byte[] shaInBytes = AuthToken.digest(pwd.getBytes(UTF_8), algorithm);
        this.token = String.format(bytesToHex(shaInBytes));
        this.expiry = new Date();
    }


    public Date getExpiry() {
        return expiry;
    }

    public String getRefresh() {
        return refresh;
    }

    public String getToken() {
        return token;
    }
}