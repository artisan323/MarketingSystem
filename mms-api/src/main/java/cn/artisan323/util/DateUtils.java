package cn.artisan323.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {

    public static final String DATEFORMATLONG14 = "yyyyMMddHHmmss";
    public static final String DATEFORMATLONG23 = "yyyy-MM-dd HH:mm:ss.SSS";

    public static final String DATEFORMATLONG17 = "yyyyMMdd HH:mm:ss";
    public static final String DATEFORMATLONG19 = "yyyy-MM-dd HH:mm:ss";
    public static final String DATEFORMATMEDIUM = "yyyy-MM-dd HH:mm";
    public static final String DATE_FORMAT_YMDH = "yyyyMMddHH";
    public static final String DATEFORMATSHORT10 = "yyyy-MM-dd";
    public static final String DATEFORMATSHORT11 = "HH:mm:ss";
    public static final String DATE_SHORT_YEARMONTH = "yyyy-MM";
    public static final String DATENUMBERFORMAT8 = "yyyyMMdd";
    public static final String DATEHOURNUMBERFORMAT = "yyyyMMddHH";
    public static final String DATE_FORMAT_HOUR = "H";
    private static Logger logger = LoggerFactory.getLogger(DateUtils.class);

    public static Date getCurrentDate() {
        return new Date();
    }

    public static long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }

    public static String getCurrentYearMonthDate() {
        return getCurrentFormatDate("yyyy-MM");
    }

    public static int cutTwoDateToDay(Date a, Date b) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        int theday = 0;
        try {
            Date beginDate = format.parse(format.format(a));
            Date endDate = format.parse(format.format(b));

            calendar.setTime(beginDate);
            long begin = calendar.getTimeInMillis();
            calendar.setTime(endDate);
            long end = calendar.getTimeInMillis();

            theday = (int) ((end - begin) / 86400000L);
        } catch (ParseException e) {
            logger.debug("日期转换出错!", e);
        }
        return theday;
    }

    public static String intToTimeString(int time) {
        String hour = String.valueOf(time / 60);
        String minute = String.valueOf(time - time / 60 * 60);

        if (hour.length() < 2) {
            hour = "0" + hour;
        }
        if (minute.length() < 2) {
            minute = "0" + minute;
        }
        return hour + ":" + minute;
    }

    public static Date maxDate(Date data1, Date data2) {
        if (data1.before(data2)) {
            return data2;
        }
        return data1;
    }

    public static Date minDate(Date a, Date b) {
        if (a.before(b)) {
            return a;
        }
        return b;
    }

    public static int getWeekOfDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(7) - 1;
        if (w == 0) {
            w = 7;
        }
        return w;
    }

    public static int getDayOfWeek() {
        int dayOfWeek = Calendar.getInstance().get(7);

        if (dayOfWeek == 1) {
            dayOfWeek = 7;
        } else {
            dayOfWeek--;
        }
        return dayOfWeek;
    }

    public static String formatDate(Date date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    public static Date createDate(String dateString, String pattern)
            throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.parse(dateString);
    }

    public static String getCurrentFormatDate(String formatDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        Date dateInstance = getCurrentDate();
        simpleDateFormat.applyPattern(formatDate);
        return simpleDateFormat.format(dateInstance);
    }

    public static void main(String[] args) {
        String id = "371327199408013510";
        int age = DateUtils.getYear() - Integer.valueOf(id.substring(6,10));
        System.out.println(age);
    }

    public static String getCurrentFormatDateShort10() {
        return getCurrentFormatDate("yyyy-MM-dd");
    }

    public static String getCurrentFormatDateShort11() {
        return getCurrentFormatDate("HH:mm:ss");
    }

    public static String getCurrentFormatDateShort8() {
        return getCurrentFormatDate("yyyyMMdd");
    }

    public static String getCurrentFormatDateShortNowTime() {
        return getCurrentFormatDate("HH:mm:ss");
    }

    public static String getCurrentFormatDateShortNowTime2() {
        return getCurrentFormatDate("HHmmss");
    }


    public static String getCurrentFormatDateLong17() {
        return getCurrentFormatDate("yyyyMMdd HH:mm:ss");
    }

    public static String getCurrentFormatDateLong19() {
        return getCurrentFormatDate("yyyy-MM-dd HH:mm:ss");
    }
    public static String getCurrentFormatDateLong20() {
        return getCurrentFormatDate("yyyy年MM月dd日");
    }
    public static String getCurrentFormatDateLong23() {
        return getCurrentFormatDate("yyyy-MM-dd HH:mm:ss.SSS");
    }


    public static String getCurrentFormatDateLong14() {
        return getCurrentFormatDate("yyyyMMddHHmmss");
    }


    public static String getCurrentFormatDateMedium() {
        return getCurrentFormatDate("yyyy-MM-dd HH:mm");
    }


    private static String getDate2String(String format, Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern(format);
        return simpleDateFormat.format(date);
    }

    public static String getDate2LongString(Date date) {
        return getDate2String("yyyy-MM-dd HH:mm:ss", date);
    }

    public static String getDate2ShortString10(Date date) {
        return getDate2String("yyyy-MM-dd", date);
    }

    public static String getDate2LongString17(Date date) {
        return getDate2String("yyyyMMdd HH:mm:ss", date);
    }

    public static String getDate2LongString19(Date date) {
        return getDate2String("yyyy-MM-dd HH:mm:ss", date);
    }

    public static String getDate2LongString23(Date date) {
        return getDate2String("yyyy-MM-dd HH:mm:ss.SSS", date);
    }

    public static String getDate2MediumString(Date date) {
        return getDate2String("yyyy-MM-dd HH:mm", date);
    }


    public static String getDate2HourString(Date date) {
        return getDate2String("H", date);
    }

    public static String getDate2NumberString8(Date date) {
        return getDate2String("yyyyMMdd", date);
    }

    public static String getLong2LongString(long l) {
        Date dateInstance = getLong2Date(l);
        return getDate2LongString(dateInstance);
    }

    public static String getLong2MediumString(long l) {
        Date dateInstance = getLong2Date(l);
        return getDate2MediumString(dateInstance);
    }

    public static String getLong2ShortString10(long l) {
        Date dateInstance = getLong2Date(l);
        return getDate2ShortString10(dateInstance);
    }

    private static Date getString2Date(String format, String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern(format);
        ParsePosition parseposition = new ParsePosition(0);
        return simpleDateFormat.parse(str, parseposition);
    }

    public static Date getString2LongDate(String str) {
        return getString2Date("yyyy-MM-dd HH:mm:ss", str);
    }


    public static Date getString2ShortDate10(String str) {
        return getString2Date("yyyy-MM-dd", str);
    }

    public static Date getString2LongDate17(String str) {
        return getString2Date("yyyyMMdd HH:mm:ss", str);
    }

    public static Date getString2LongDate19(String str) {
        return getString2Date("yyyy-MM-dd HH:mm:ss", str);
    }

    public static Date getString2LongDate23(String str) {
        return getString2Date("yyyy-MM-dd HH:mm:ss.SSS", str);
    }

    public static Date getString2MediumDate(String str) {
        return getString2Date("yyyy-MM-dd HH:mm", str);
    }

    public static Date getString2NumberDate8(String str) {
        return getString2Date("yyyyMMdd", str);
    }

    public static Date getString2YmdhDate(String str) {
        return getString2Date("yyyyMMddHH", str);
    }

    public static Date getEmptyDate() {
        return getString2ShortDate10("1971-01-01");
    }

    public static String getEmptyDateString() {
        return "1971-01-01";
    }

    public static Date getLong2Date(long l) {
        return new Date(l);
    }

    public static int getOffMinutes(long l) {
        return getOffMinutes(l, getCurrentTimeMillis());
    }

    public static int getOffMinutes(long from, long to) {
        return (int) ((to - from) / 60000L);
    }

    public static int getYear() {
        return Calendar.getInstance().get(1);
    }

    public static int getMonth() {
        return Calendar.getInstance().get(2) + 1;
    }

    public static int getDay() {
        return Calendar.getInstance().get(5);
    }

    public static int getHour() {
        return Calendar.getInstance().get(11);
    }

    public static int getMinute() {
        return Calendar.getInstance().get(12);
    }

    public static int getSecond() {
        return Calendar.getInstance().get(13);
    }

    public static String add(int day) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.add(5, day);
        Date dateInstance = gregorianCalendar.getTime();
        return getDate2String("yyyy-MM-dd", dateInstance);
    }

    public static String subtract(int day) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.add(5, -day);
        Date dateInstance = gregorianCalendar.getTime();
        return getDate2String("yyyy-MM-dd", dateInstance);
    }

    public static String getlastMonth() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM");
        GregorianCalendar gc = new GregorianCalendar();
        gc.roll(2, false);
        return sdf.format(gc.getTime());
    }

    public static String getCurrentLastMonth() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        Calendar cal = Calendar.getInstance();
        cal.add(2, -1);
        return format.format(cal.getTime());
    }

    /**
     * 计算距离当前日期最近一个月的日期
     * 默认yyyy-MM-dd
     *
     * @param date 当前日期
     * @return 日期
     */
    public static String getCurrentDayLastMonth(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        // 设置为当前时间
        calendar.setTime(date);
        // 设置为上一个月
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
        date = calendar.getTime();
        return dateFormat.format(date);
    }

    /**
     * 计算距离当前日期最近几个月的日期
     *
     * @param date   当前日期
     * @param format 日期格式
     * @param num    几个月
     * @return 日期
     */
    public static String getCurrentDayLastMonth(Date date, String format, int num) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        Calendar calendar = Calendar.getInstance();
        // 设置为当前时间
        calendar.setTime(date);
        // 设置为前几个月
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - num);
        date = calendar.getTime();
        return dateFormat.format(date);
    }

    public static String[] getCurrentLastWeek() {
        String[] weeks = new String[2];
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.add(6, -cal.get(7));
        weeks[1] = format.format(cal.getTime());
        cal.add(6, -6);
        weeks[0] = format.format(cal.getTime());
        return weeks;
    }

    /**
     * 计算距离当前日期最近一周的日期（算当天）
     *
     * @param date       当前日期
     * @param dateformat 日期格式
     * @return 日期
     */
    public static String getCurrentLastWeek(Date date, String dateformat) {
        SimpleDateFormat format = new SimpleDateFormat(dateformat);
        Calendar c = Calendar.getInstance();
        //过去七天
        c.setTime(date);
        c.add(Calendar.DATE, -6);
        Date d = c.getTime();
        String day = format.format(d);
        return day;
    }

    public static boolean isStartLessEndTime(String start, String end)
            throws ParseException {
        if (("".equals(start)) || ("".equals(end))) {
            return false;
        }
        Date startDate = DateFormat.getDateInstance().parse(start);
        Date endDate = DateFormat.getDateInstance().parse(end);
        if (startDate.compareTo(endDate) >= 0) {
            return false;
        }
        return true;
    }

    public static Date getToday() {
        Calendar cal = Calendar.getInstance();
        return cal.getTime();
    }

    public static Date getYesterday() {
        Calendar cal = Calendar.getInstance();
        cal.add(5, -1);
        return cal.getTime();
    }

    public static Date getFirstDayOfThisWeek() {
        Date today = getToday();
        return getFirstDayInWeek(today);
    }

    public static Date getFirstDayInMonth(int year, int month) {
        month--;
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(year, month, 1);
        return cal.getTime();
    }

    public static Date getLastDayInMonth(int year, int month) {
        Date firstDay = getFirstDayInMonth(year, month);
        Calendar firstCal = getCalendarByDate(firstDay);
        firstCal.add(2, 1);
        firstCal.add(6, -1);
        return firstCal.getTime();
    }

    public static Date getFirstDayOfThisMonth() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(1);
        int month = cal.get(2);
        month++;
        return getFirstDayInMonth(year, month);
    }

    public static Date getFirstDayOfLastMonth() {
        int year = getYearOfLastMonth();
        int month = getMonthOfLastMonth();
        return getFirstDayInMonth(year, month);
    }

    private static int getYearOfLastMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(2, -1);
        return cal.get(1);
    }

    private static int getMonthOfLastMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(2, -1);
        int month = cal.get(2);
        month++;
        return month;
    }

    public static int getThisMonth() {
        Calendar cal = Calendar.getInstance();
        int month = cal.get(2);
        month++;
        return month;
    }

    public static Date getFirstDayInYear(int year) {
        int month = 0;
        int day = 1;
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, day);
        return cal.getTime();
    }

    public static Date getLastDayInYear(int year) {
        int month = 11;
        int day = 31;
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, day);
        return cal.getTime();
    }

    public static int getThisYear() {
        Calendar cal = Calendar.getInstance();
        return cal.get(1);
    }

    public static int getLastYear() {
        Calendar cal = Calendar.getInstance();
        cal.add(1, -1);
        return cal.get(1);
    }

    public static Date getFirstDayInWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int thisweek = cal.get(3);
        int lastweek = thisweek;
        Date thisday = null;
        while (lastweek == thisweek) {
            thisday = cal.getTime();
            cal.add(5, -1);
            lastweek = cal.get(3);
        }
        return thisday;
    }

    public static Date getLastDayInWeek(Date date) {
        Date firstdayofweek = getFirstDayInWeek(date);
        Calendar cal = getCalendarByDate(firstdayofweek);
        cal.add(6, 6);
        return cal.getTime();
    }

    private static Calendar getCalendarByDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    public static String getDateStr(Date date) {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    public static String getMonthStr(Date date) {
        String pattern = "yyyy-MM";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    public static Date getDateByStr(String dateStr) {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = format.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException("wrong date format, should be " + pattern);
        }

        return date;
    }

    public static String addHour(int hour) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.add(10, hour);
        Date dateInstance = gregorianCalendar.getTime();
        return getDate2String("yyyyMMddHH", dateInstance);
    }

    public static Date addHour2Date(int hour) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.add(10, hour);
        Date dateInstance = gregorianCalendar.getTime();
        return dateInstance;
    }

    public static String addHourReturnShortDate(int hour) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.add(10, hour);
        Date dateInstance = gregorianCalendar.getTime();
        return getDate2String("yyyy-MM-dd", dateInstance);
    }

    public static Date getNextHourDate(int hour) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.add(10, hour);
        Date dateInstance = gregorianCalendar.getTime();
        String longDateTime = getDate2LongString(dateInstance);
        String nextDateHour = longDateTime.subSequence(0, 14) + "00:00";
        return getString2LongDate(nextDateHour);
    }

    public static Date getNextMinuteDate(int minute) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.add(12, minute);
        Date dateInstance = gregorianCalendar.getTime();
        String longDateTime = getDate2LongString(dateInstance);
        String nextDateMinute = longDateTime.subSequence(0, 17) + "00";
        return getString2LongDate(nextDateMinute);
    }

    public static boolean inDateRange(Date startDate, Date endDate, Date date) {
        if ((startDate == null) || (endDate == null) || (date == null)) {
            return false;
        }

        return ((startDate.before(date)) || (startDate.equals(date))) && ((endDate.after(date)) || (endDate.equals(date)));
    }

    /**
     * @Author: xiaobing
     * @Description: 上个月这个时间
     * @Date: 2019/1/25
     */
    public static String beforeNowMonth() {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cl = Calendar.getInstance();
        cl.add(Calendar.MONTH, -1);
        Date dateFrom = cl.getTime();
        return ft.format(dateFrom);
    }

    /**
     * @Author: xiaobing
     * @Description: 获得本月第一天日期
     * @Date: 2019/1/25
     */
    public static String nowMonthFristDay() {
        SimpleDateFormat ft2 = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return  ft2.format(cal.getTime());
    }

    /**
     * 获取当前日期的最近一周日期
     *
     * @author Luxin.xiao
     * @date 2019/2/26 13:40
     * @param date 当前日期
     * @return String
     */
    public static String lastWeek(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        // 当前日期
        c.setTime(date);
        // 最近一个周
        c.add(Calendar.DATE, - 6);
        Date d = c.getTime();
        String day = format.format(d);
        return day;
    }

    /**
     * 获取当前时间最近几个月的日期
     *
     * @author Luxin.xiao
     * @date 2019/2/26 14:18
     * @param date 当前日期
     * @return String
     */
    public static String lastMonth(Date date, int month) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        // 当前日期
        c.setTime(date);
        // 最近month个月
        c.add(Calendar.MONTH, month);
        Date m = c.getTime();
        String mon = format.format(m);
        return mon;
    }
    public static final long convertLongTime(String space)
    {
        if ((space == null) || (space.length() < 2)) {
            return 0L;
        }
        long time = 0L;
        char ss = space.charAt(0);
        int extent = Integer.parseInt(space.substring(1, space.length()));
        switch (ss)
        {
            case 'D':
                time = extent * 24 * 3600 * 1000;
                break;
            case 'd':
                time = extent * 24 * 3600 * 1000;
                break;
            case 'H':
                time = extent * 3600 * 1000;
                break;
            case 'h':
                time = extent * 3600 * 1000;
        }
        return time;
    }

    /**
     * @description: 获取所传日期上个月的日期
     * @author xuejl
     * @date 2018/8/29 11:11
     */
    public static String getBeforeMonthDay(String currDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        Calendar calendar = Calendar.getInstance();
        // 设置为当前时间
        try {
            calendar.setTime(dateFormat.parse(currDate));
        } catch (ParseException e) {
            e.printStackTrace();
            logger.error("获取所传日期上个月的日期-转换格式异常！");
        }
        // 设置为上一个月
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
        Date date = calendar.getTime();
        return  dateFormat.format(date);
    }
    /**
     * @Description: yyyyMMdd:hhmmss
     * @Author:  chengjiali
     * @Date:  10:47 2019/10/25 0025
     */
    public static String getCurrentFormatDateLong15() {
        return getCurrentFormatDate("yyyyMMdd:hhmmss");
    }


}

