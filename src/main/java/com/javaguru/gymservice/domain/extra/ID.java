package com.javaguru.gymservice.domain.extra;


import java.util.UUID;

/**
 * @author: adewaleijalana
 * @email: adewaleijalana@gmail.com
 * @date: 11/24/23
 * @time: 9:55PM
 **/

public enum ID {

    INSTANCE;

    public static String generateUUIDString() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replaceAll("-", "").toUpperCase();

    }


}

