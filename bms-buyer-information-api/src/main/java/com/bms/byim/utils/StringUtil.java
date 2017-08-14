package com.bms.byim.utils;

/**
 * Created by zhou_yajun on 2017/1/23.
 */
public class StringUtil {

    public static String PadLeft(String value, int length, String pad) {

        String tmpStr = value;
        if (tmpStr == null) {
            tmpStr = "";
        }

        String tmpPad = "";

        if (tmpStr.length() < length) {
            for (int i = 1; i <= length - tmpStr.length(); i++) {
                tmpPad = pad.concat(tmpPad);
            }
        }

        return tmpPad.concat(tmpStr);
    }
}
