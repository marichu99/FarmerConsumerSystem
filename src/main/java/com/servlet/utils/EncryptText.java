package com.servlet.utils;

import java.security.NoSuchAlgorithmException;

public interface EncryptText {
    String hash(String text) throws NoSuchAlgorithmException;
}
