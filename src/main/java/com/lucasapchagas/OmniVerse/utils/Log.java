package com.lucasapchagas.OmniVerse.utils;

import com.lucasapchagas.OmniVerse.Constant;

public class Log {

    public static void d (String TAG, String message) {
        if (Constant.DEBUG)
            System.out.println(TAG + ": " + message);
    }

    public static void i (String TAG, String message) {
        System.out.println(TAG + ": " + message);
    }
}
