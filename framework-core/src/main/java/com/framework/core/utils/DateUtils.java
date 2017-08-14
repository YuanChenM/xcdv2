package com.framework.core.utils;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * <p>日期和时间的工具类。</p>
 *
 * @Author xia_xiaojie
 * @CreateDate 2016/10/21
 * @Version 1.0
 */
public final class DateUtils extends org.apache.commons.lang3.time.DateUtils {
    public static final String FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    public static final String FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
    public static final String FORMAT_YYYY_MM = "yyyy-MM";
    public static final String FORMAT_MM_DD = "MM-dd";

    public static final String FORMAT_YYYY1MM1DD_HH_MM_SS = "yyyy/MM/dd HH:mm:ss";
    public static final String FORMAT_YYYY1MM1DD_HH_MM = "yyyy/MM/dd HH:mm";
    public static final String FORMAT_YYYY1MM1DD = "yyyy/MM/dd";
    public static final String FORMAT_YYYY1MM = "yyyy/MM";
    public static final String FORMAT_MM1DD = "MM/dd";

    public static final String FORMAT_HH_MM_SS = "HH:mm:ss";
    public static final String FORMAT_HH_MM = "HH:mm";

    public static final String FORMAT_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String FORMAT_YYYYMMDDHHMM = "yyyyMMddHHmm";
    public static final String FORMAT_YYYYMMDD = "yyyyMMdd";
    public static final String FORMAT_YYYYMM = "yyyyMM";
    public static final String FORMAT_MMDD = "MMdd";
    public static final String FORMAT_DD = "dd";

    public static final String FORMAT_YYMMDDHHMMSS = "yyMMddHHmmss";
    public static final String FORMAT_YYMMDDHHMM = "yyMMddHHmm";
    public static final String FORMAT_YYMMDD = "yyMMdd";
    public static final String FORMAT_YYMM = "yyMM";

    public static final String FORMAT_DDMMMYYYYHHMMSS = "dd MMM yyyy HH:mm:ss";
    public static final String FORMAT_DDMMMYYYY = "dd MMM yyyy";
    public static final String FORMAT_MMMYYYY = "MMM yyyy";
    public static final String FORMAT_DDMMM = "dd MMM";
    public static final String FORMAT_MMM = "MMM";

    /**
     * Daylight Saving Time Offset.
     */
    public static final int DAYLIGHT_SAVING_TIME_OFFSET = 3600000;

    public static enum DatetimeType {
        /**
         * yyyy-MM-dd 23:59:59.99999
         */
        MAX,

        /**
         * yyyy-MM-dd 00:00:00.00000
         */
        MIN,

        /**
         * yyyy-MM-dd hh:mm:ss.SSSSS
         */
        CURRENT
    }

    public static String format(String targetFormat, String originalFormat, String dateString) {
        if (dateString == null || dateString.trim().length() == 0) {
            return "";
        }
        if (targetFormat == null || targetFormat.trim().length() == 0) {
            return dateString;
        }
        if (originalFormat == null || originalFormat.trim().length() == 0) {
            return dateString;
        }

        String retDate;
        try {
            Date date = new SimpleDateFormat(originalFormat, Locale.US).parse(dateString.trim());
            retDate = new SimpleDateFormat(targetFormat, Locale.US).format(date);
        } catch (ParseException e) {
            retDate = "";
        }
        return retDate;
    }

    public static String toNumDate(String string) {
        SimpleDateFormat strToDateFmt = new SimpleDateFormat("MMM-yyyy", Locale.US);
        ParsePosition pos = new ParsePosition(0);
        Date date = strToDateFmt.parse(string, pos);
        if (null == date) {
            return "";
        } else {
            SimpleDateFormat dateToStrFmt = new SimpleDateFormat("yyyyMM", Locale.US);
            return dateToStrFmt.format(date);
        }
    }

    public static String format(String format, Date date) {
        if (date == null || date.toString().length() == 0) {
            return "";
        }
        if (format == null || format.trim().length() == 0) {
            return new SimpleDateFormat(FORMAT_YYYY_MM_DD_HH_MM_SS, Locale.US).format(date);
        }
        return new SimpleDateFormat(format, Locale.US).format(date);
    }

    public static String formatDateTime(Date date) {
        return format(FORMAT_YYYY_MM_DD_HH_MM_SS, date);
    }

    public static String formatDate(Date date) {
        return format(FORMAT_YYYY_MM_DD, date);
    }

    public static Date parse(String format, String dateString) {
        if (dateString == null || dateString.trim().length() == 0) {
            return null;
        }
        if (format == null || format.trim().length() == 0) {
            format = FORMAT_YYYY_MM_DD_HH_MM_SS;
        }

        try {
            SimpleDateFormat df = new SimpleDateFormat(format, Locale.US);
            df.setLenient(false);
            Date date = df.parse(dateString);
            if (isValid(date)) {
                return date;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static Date parseDateTime(String ymdhms) {
        return parse(FORMAT_YYYY_MM_DD_HH_MM_SS, ymdhms);
    }

    public static Date parseDate(String ymd) {
        return parse(FORMAT_YYYY_MM_DD, ymd);
    }

    public static boolean isValid(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        final int maxYear = 9999;
        final int minYear = 1900;
        if (calendar.get(Calendar.YEAR) > maxYear || calendar.get(Calendar.YEAR) < minYear) {
            return false;
        }
        return true;
    }

    public static Date getCurrent() {
        return new Date();
    }

    public static String fmtCurrent() {
        return format(FORMAT_YYYY_MM_DD_HH_MM_SS, new Date());
    }

    public static Date getToday() {
        return parse(FORMAT_YYYY_MM_DD, format(FORMAT_YYYY_MM_DD_HH_MM_SS, new Date()));
    }

    public static String fmtToday() {
        return format(FORMAT_YYYY_MM_DD, new Date());
    }

    public static int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(1);
    }

    public static int getMonthOfYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(2) + 1;
    }

    public static int getDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(5);
    }

    public static Date getMinMonthDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(5, calendar.getActualMinimum(5));
        return calendar.getTime();
    }

    public static Date getMaxMonthDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(5, calendar.getActualMaximum(5));
        return calendar.getTime();
    }

    public static Timestamp convertDateToTimestamp(java.sql.Date date, DatetimeType timeType) {
        if (date == null) {
            return null;
        }
        if (DatetimeType.CURRENT.equals(timeType)) {
            return new Timestamp(date.getTime());
        }

        String format = new SimpleDateFormat(FORMAT_YYYY_MM_DD, Locale.US).format(date);
        java.sql.Date newDate = java.sql.Date.valueOf(format);
        long newTime = newDate.getTime();
        if (DatetimeType.MAX.equals(timeType)) {
            newTime = newDate.getTime() + (1000 * 60 * 60 * 24 - 1);
        }
        Timestamp timeStamp = new Timestamp(newTime);
        return timeStamp;
    }

    public static String convertTimezoneToGMT(String timezone) {
        if (StringUtils.isBlank(timezone)) {
            return timezone;
        } else {
            String standardTimezone = timezone;
            if (StringUtils.isNumeric(timezone)) {
                if (timezone.indexOf(43) == 0) {
                    standardTimezone = timezone.substring(1);
                }

                int timezoneValue = Integer.valueOf(standardTimezone);
                int prefix = Math.abs(timezoneValue) / 100;
                if (timezoneValue / 100 > 12 || timezoneValue / 100 < -13) {
                    return null;
                }

                int remainder = Math.abs(timezoneValue) % 100;
                String remainderStr = remainder < 10 ? "0" + remainder : "" + remainder;
                standardTimezone = (timezoneValue > 0 ? "GMT+" : "GMT-") + prefix + ":" + remainderStr;
            }
            return standardTimezone;
        }
    }

    public static Timestamp convertTimezone(Timestamp timestamp, String sourceTimeZone, String targetTimeZone) {
        Long time = Long.valueOf(timestamp.getTime());
        Long sourceRelativelyGMT = Long.valueOf(time.longValue() - (long) TimeZone.getTimeZone(convertTimezoneToGMT(sourceTimeZone)).getRawOffset());
        Long targetTime = Long.valueOf(sourceRelativelyGMT.longValue() + (long) TimeZone.getTimeZone(convertTimezoneToGMT(targetTimeZone)).getRawOffset());
        Timestamp result = new Timestamp(targetTime.longValue());
        result.setNanos(timestamp.getNanos());
        return result;
    }

    public static Date convertTimezone(Date dateTime, String sourceTimeZone, String targetTimeZone) {
        Long time = Long.valueOf(dateTime.getTime());
        Long sourceRelativelyGMT = Long.valueOf(time.longValue() - (long) TimeZone.getTimeZone(sourceTimeZone).getRawOffset());
        Long targetTime = Long.valueOf(sourceRelativelyGMT.longValue() + (long) TimeZone.getTimeZone(targetTimeZone).getRawOffset());
        return new Date(targetTime.longValue());
    }

}
