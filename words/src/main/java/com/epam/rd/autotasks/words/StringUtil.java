package com.epam.rd.autotasks.words;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    public static int countEqualIgnoreCaseAndSpaces(String[] words, String sample) {
        int count = 0;
        if (sample == null || words == null || sample.equals("")) return 0;
        sample = sample.replace("\t", "").trim();
        for (String word: words ) {
            word = word.replace("\t", "").trim();
            if (word.matches("(?i)" + sample))
                count++;
        }
        return count;
    }

    public static String[] splitWords(String text) {
        if(text == null || text.equals("")) return null;
        Pattern pattern = Pattern.compile("[,.;: ?!]");
        String[] res1 = pattern.split(text);
        int i = res1.length;
        for (String row: res1) {
            if (row.equals("")) i--;
        }
        String[] result = new String[i];
        i=0;
        for (String row: res1) {
            if (!row.equals("")) {result[i] = row; i++;}
        }
        if (i==0) return null;
        return result;
    }

    public static String convertPath(String path, boolean toWin) {
        if (path == null || path.equals("")) return null;
        if(path.equals("/") && toWin) return "C:\\";
        if(path.equals("C:\\") && !toWin) return "/";
        Matcher m;
        Pattern p;
//        String temp = "^/$";
//        "aaaaa".matches(temp);
        String winRegex = "^(C:)?(\\\\?)(([a-zA-Z0-9._ ])+(\\\\)?)*$";
        String unixRegex = "^(~)?(/)?([a-zA-Z0-9._ ]+(/)?)*$";

        boolean matchesWin = path.matches(winRegex);
        boolean matchesUnix = path.matches(unixRegex);
        if ((matchesWin && toWin) || (matchesUnix && !toWin)) {
            return path;
        }

        if ((toWin && !matchesUnix) || (!toWin && !matchesWin)) {
            return null;
        }
        if (toWin) {return path.replace("/root", "C:\\root").replace("/","\\").replace("~","C:\\User");}
        else return path.replace("C:\\root", "/root").replace("C:\\User","~").replace("\\","/");
    }

    public static String joinWords(String[] words) {
        if(words == null) return null;
        int i=0;
        StringBuilder result= new StringBuilder("[");
        for (String row: words) {
            if (!(row == null) &&!row.equals("")) {
                if (i == 0) result.append(row);
                else result.append(", ").append(row);
                i++;
            }
        }
        if (i == 0) return null;
        else return result + "]";

    }

    public static void main(String[] args) {
//        System.out.println("Test 1: countEqualIgnoreCaseAndSpaces");
//        String[] words = new String[]{" WordS    \t", "words", "w0rds", "WOR  DS", };
//        String sample = "words";
//        int countResult = countEqualIgnoreCaseAndSpaces(words, sample);
//        System.out.println("Result: " + countResult);
//        int expectedCount = 2;
//        System.out.println("Must be: " + expectedCount);
//
//        System.out.println("Test 2: splitWords");
//        String text = "   ,, first, second!!!! third";
//        String[] splitResult = splitWords(text);
//        System.out.println("Result : " + Arrays.toString(splitResult));
//        String[] expectedSplit = new String[]{"first", "second", "third"};
//        System.out.println("Must be: " + Arrays.toString(expectedSplit));
//
//        System.out.println("Test 3: convertPath");
//        String unixPath = "/some/unix/path";
//        String convertResult = convertPath(unixPath, true);
//        System.out.println("Result: " + convertResult);
//        String expectedWinPath = "C:\\some\\unix\\path";
//        System.out.println("Must be: " + expectedWinPath);
//
//        System.out.println("Test 4: joinWords");
//        String[] toJoin = new String[]{"go", "with", "the", "", "FLOW"};
//        String joinResult = joinWords(toJoin);
//        System.out.println("Result: " + joinResult);
//        String expectedJoin = "[go, with, the, FLOW]";
//        System.out.println("Must be: " + expectedJoin);

        String pattern = "^(~)?(/)?([a-zA-Z0-9.]+(/)?)+$";
        String testInput = "/user/logger";

        System.out.println(testInput.matches(pattern));
    }
}