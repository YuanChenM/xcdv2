package com.framework.core.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>正则表达式工具类。</p>
 *
 * @Author xia_xiaojie
 * @CreateDate 2016/10/21
 * @Version 1.0
 */
public final class RegexUtils {
    /** the pattern of dd-MMM-yyyy */
    public static final Pattern PATTERN_DATE = Pattern.compile("^([0-2]\\d|3[0,1])-\\b(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)\\b-(\\d{2}|\\d{4})$");
    /** the pattern of dd-MMM-yyyy */
    public static final Pattern PATTERN_DATE_DDMMYYYY = Pattern.compile("^([0-2]\\d|3[0,1])-([0-1]?\\d)-(\\d{2}|\\d{4})$");
    /** the pattern of dd-MMM-yyyy HH:mm:ss */
    public static final Pattern PATTERN_TIME = Pattern.compile("^([0-2]\\d|3[0,1])-\\b(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)\\b-(\\d{2}|\\d{4}) ([0-1]\\d|2[0-3]):([0-5]\\d):([0-5]\\d)$");

    public static boolean find(String regex, String str) {
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(str);
        return mat.find();
    }

    public static boolean matchs(String regex, String str) {
        return Pattern.matches(regex, str);
    }

    public static List<String> splitStrings(String regex, String str) {
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(str);
        if (!mat.find()) {
            return null;
        }

        List<String> list = new ArrayList<>();
        for (int i = 1; i <= mat.groupCount(); i++) {
            list.add(mat.group(i));
        }
        return list;
    }

}
