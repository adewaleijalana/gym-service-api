package com.javaguru.gymservice.util;


public enum AppUtil {

    INSTANCE;

    public final boolean stringIsNullOrEmpty(String arg) {
        if ((arg == null)) return true;
        else
            return ("".equals(arg)) || (arg.trim().length() == 0);
    }


}
