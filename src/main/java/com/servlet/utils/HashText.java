package com.servlet.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@PasswordTypeSelector(passwordEnum = PasswordEnum.SHA256)
public class HashText implements EncryptText {
    public String hash(String text) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(text.getBytes());

        return new String(messageDigest.digest());
    }
}
