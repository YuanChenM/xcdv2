package com.framework.core.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * <p>字符串转义工具类，提供了转义和还原各种特殊字符的方法。</p>
 *
 * @Author xia_xiaojie
 * @CreateDate 2016/10/21
 * @Version 1.0
 */
public final class StringEscapeUtils extends org.apache.commons.lang3.StringEscapeUtils {

    /**
     * <p>转义字符串中的逗号。</p>
     * <pre>
     * StringEscapeUtils.escapeComma(null)      = ""
     * StringEscapeUtils.escapeComma(" ")       = " "
     * StringEscapeUtils.escapeComma("abc,def") = "abc\,def"
     * </pre>
     *
     * @param str 含逗号的字符串
     * @return 若参数{@code str}是{@code null}，则返回{@code ""}，否则返回转义后的字符串
     */
    public static String escapeComma(String str) {
        if (str == null) {
            return "";
        }
        return str.replaceAll(",", "\\\\,");
    }

    /**
     * <p>还原字符串中的逗号。</p>
     * <pre>
     * StringEscapeUtils.unescapeComma(null)        = ""
     * StringEscapeUtils.unescapeComma(" ")         = " "
     * StringEscapeUtils.unescapeComma("abc\\,def") = "abc,def"
     * </pre>
     *
     * @param str 含逗号的字符串
     * @return 若参数{@code str}是{@code null}，则返回{@code ""}，否则返回还原后的字符串
     */
    public static String unescapeComma(String str) {
        if (str == null) {
            return "";
        }
        return str.replaceAll("\\\\,", ",");
    }

    /**
     * <p>转义字符串中的HTML标签。</p>
     * <pre>
     * StringEscapeUtils.escapeHtml(null)            = "";
     * StringEscapeUtils.escapeHtml(" ")             = " ";
     * StringEscapeUtils.escapeHtml("example<br />") = "example&lt;br /&gt;";
     * </pre>
     *
     * @param str 含HTML标签的字符串
     * @return 若参数{@code str}是{@code null}，则返回{@code ""}，否则返回转义后的字符串
     */
    public static String escapeHtml(String str) {
        if (str == null) {
            return "";
        }
        return escapeHtml4(str);
    }

    /**
     * <p>转义HTML标签和空格。</p>
     * <pre>
     * StringEscapeUtils.escapeHtmlWithSpace(null)            = null;
     * StringEscapeUtils.escapeHtmlWithSpace("example<br />") = "example&lt;br&nbsp;/&gt;";
     * </pre>
     *
     * @param str 含HTML标签和空格的字符串
     * @return 若参数{@code str}是{@code null}，则返回{@code ""}，否则返回转义后的字符串
     */
    public static String escapeHtmlWithSpace(String str) {
        if (str == null) {
            return "";
        }
        return escapeHtml4(str).replaceAll(" ", "&nbsp;");
    }

    /**
     * <p>转义ECMAScript字符串规则的字符串。</p>
     * <p>Example:</p>
     * <pre>
     * input string: He didn't say, "Stop!"
     * output string: He didn\'t say, \"Stop!\"
     * </pre>
     *
     * @param str 要转义的字符串
     * @return 若字符串为空指针，则返回null，否则返回转义后的字符串
     */
    public static String escapeJavaScript(String str) {
        if (str == null) {
            return "";
        }
        return escapeEcmaScript(str);
    }

    public static String escapeWildcard(String input, String[] escapeCharacters, String escapeCharacter) {
        String ret = input;
        String escapeChar = escapeCharacter;
        if(escapeCharacter == null || escapeCharacter.length() != 1) {
            escapeChar = "!";
        }

        if(input != null && escapeCharacters != null) {
            List al = Arrays.asList(escapeCharacters);
            HashSet set = new HashSet();
            set.addAll(al);
            if(set.contains(escapeChar)) {
                ret = input.replaceAll(escapeChar, escapeChar + escapeChar);
                set.remove(escapeChar);
            }

            Iterator it = set.iterator();
            while(it.hasNext()) {
                String cur = (String) it.next();
                if(input.contains(cur)) {
                    ret = ret.replaceAll("\\\\" + cur, escapeChar + cur);   //原代码ret = ret.replaceAll("\\" + cur, escapeChar + cur);
                }
            }
        }

        if(ret != null && ret.contains("!\'")) {
            ret = ret.replaceAll("!\\\'", "\'");
        }
        return ret;
    }

    public static String escapeWildcard(String input, HashSet<String> escapeCharacters, String escapeCharacter) {
        if(input != null && escapeCharacters != null) {
            String escapeChar = escapeCharacter;
            if(escapeCharacter == null || escapeCharacter.length() != 1) {
                escapeChar = "!";
            }
            return escapeWildcard(input, escapeCharacters.toArray(new String[0]), escapeChar);
        } else {
            return input;
        }
    }

    public static String escapeWildcard(String input) {
        final String[] escapeCharacters = {"_", "%", "'", "!"};
        final String escapeCharacter = "!";
        if (input == null) {
            return input;
        } else {
            return escapeWildcard(input, escapeCharacters, escapeCharacter);
        }
    }

}
