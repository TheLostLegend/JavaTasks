package com.epam.rd.autotasks.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EpamEmailValidation {

    public static boolean validateEpamEmail(String email) {
        if (email == null) return false;
        Pattern p = Pattern.compile("\\b[a-zA-Z]+[_][a-zA-Z]+[0-9]*+[@][e][p][a][m][.][c][o][m]\\b");
        Matcher m = p.matcher(email);
        return m.find();

    }
}





