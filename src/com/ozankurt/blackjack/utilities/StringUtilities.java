package com.ozankurt.blackjack.utilities;

public class StringUtilities {

    private StringUtilities() {
    }

    public static String upperCaseFirst(String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase();
    }
}
