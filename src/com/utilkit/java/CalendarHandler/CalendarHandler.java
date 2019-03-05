/**
 * Copyright (c) 2019 Kato Shinya
 * Released under the MIT license
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.utilkit.java.CalendarHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.utilkit.java.CalendarHandler.CalendarInfoEnum.MonthInfo;
import com.utilkit.java.CalendarHandler.CalendarInfoEnum.WeekInfo;
import com.utilkit.java.CalendarHandler.FormatInfoEnum.DateFormatInfo;
import com.utilkit.java.CalendarHandler.FormatInfoEnum.FormatInfo;
import com.utilkit.java.CalendarHandler.FormatInfoEnum.SymbolInfo;
import com.utilkit.java.common.StringChecker;

/**
 * <DL>
 * <DT>Description:</DT>
 * <DD>
 * This class was created to provide functions to efficiently manipulate the calendar from the date.<br>
 * </DD>
 * <DT>Recommended:</DT>
 * <DD>
 * Use the below enum class and interface when using some functions of this class.<br>
 * {@link com.utilkit.java.CalendarHandler.ICalendarInfoEnum}<br>
 * {@link com.utilkit.java.CalendarHandler.CalendarInfoEnum}<br>
 * {@link com.utilkit.java.CalendarHandler.IFormatInfoEnum}<br>
 * {@link com.utilkit.java.CalendarHandler.FormatInfoEnum}<br>
 * </DD>
 * </DL>
 *
 * @author Kato Shinya
 * @since 2019.02.16
 * @version 1.0
 *
 * @see com.utilkit.java.CalendarHandler.ICalendarInfoEnum
 * @see com.utilkit.java.CalendarHandler.CalendarInfoEnum
 */
public class CalendarHandler {

	// ================= class fields =====================================

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * This class was created to provide functions to efficiently manipulate the calendar from the date.<br>
	 * Since the instantiation of the calendar class is heavy, keep the instance as a class constant.<br>
	 * </DD>
	 * <DT>Note:</DT>
	 * <DD>
	 * Be sure to use {@code cal.clear()} first when using the calendar class in the method of this class, or it may not be able to derive the correct value.<br>
	 * </DD>
	 * </DL>
	 */
	private static final Calendar cal = Calendar.getInstance();

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * The date format class to be used in this class.<br>
	 * If no format is passed as an argument to the constructor, it is initialized in yyyyMMdd format as a default.<br>
	 * </DD>
	 * </DL>
	 */
	private static final SimpleDateFormat sdf = new SimpleDateFormat(DateFormatInfo.DEFALUT.getFormat());

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * Class field to hold the date required for data processing.<br>
	 *
	 * It is initialized with empty string at the time the instance is created.
	 * So when using some argumentless methods of the class,<br>
	 * you surely need to set the date using {@link #setDate}.<br>
	 * </DD>
	 * </DL>
	 */
	private String date = "";

	// ================= constructor =====================================

	/**
	 * This constructor is used for class initialization.
	 * The instance generated in this class is guaranteed to be singleton.
	 *
	 * Instead of using this constructor to initialize the class,
	 * you can get a singleton instance by using the static factory methods.
	 *
	 * @see #getInstance()
	 * @see #getInstance(String)
	 * @see InstanceHolder
	 */
	private CalendarHandler() {

		this.setLenient(false);
	}

	// ================= factories =====================================

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * This factory is used to initialise the class.<br>
	 * Set the strict analysis of the date to true when the factory is run.<br>
	 * The strict analysis setting can be changed after instance creation with {@link #setLenient}.<br>
	 * </DD>
	 * </DL>
	 */
	public static CalendarHandler getInstance() {

		return InstanceHolder.INSTANCE;
	}

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * This static factory is used to initialise the class with date format.<br>
	 * Set the strict analysis of the date to true when the factory is run.<br>
	 * The strict analysis setting can be changed after instance creation with {@link #setLenient}.<br>
	 * </DD>
	 * <DT>Caution:</DT>
	 * <DD>
	 * It is advisable to use {@link DateFormatInfo}, as only the specified format is acceptable.<br>
	 * If pass a format other than the format defined for the {@link DateFormatInfo} as the argument, IllegalArgumentException will be thrown.<br>
	 * </DD>
	 * </DL>
	 *
	 * @param dateFormat [i] Value of date format
	 * @throws IllegalArgumentException throws when the argument is not valid
	 *
	 * @see #applyPattern(String)
	 */
	public static CalendarHandler getInstance(String dateFormat) {

		InstanceHolder.INSTANCE.applyPattern(dateFormat);

		return InstanceHolder.INSTANCE;
	}

	/**
	 * This nested class was defined to create the singleton instance and to hold it.
	 *
	 * Singleton instance is not created when the CalendarHandler class is loaded.
	 * When using {@link CalendarHandler#getInstance()} for the first time,
	 * the {@link InstanceHolder} class is loaded and the singleton instance is created.
	 *
	 * It does not use synchronized, but it supports multithread processing.
	 * The reason for not using synchronized is to prevent performance degradation
	 * due to locking by specifying synchronized.
	 *
	 * @see CalendarHandler
	 * @see #getInstance()
	 * @see #getInstance(String)
	 */
	private static class InstanceHolder {

		/** The field to hold the singleton instance.
		 */
		private static final CalendarHandler INSTANCE = CalendarHandler.getInstance();
	}

	// ================= public methods =====================================

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * Return the client's system date in the format set in SimpleDateFormat.<br>
	 * </DD>
	 * <DT>Example:</DT>
	 * <DD>
	 * <strong>CalendarHandler calendarHandler = CalendarHandler.getInstance();</strong><br>
	 * <strong>calendarHandler.getSystemDate();</strong><br>
	 * <strong>then "20190216"</strong><br>
	 * <br>
	 * <strong>CalendarHandler calendarHandler = CalendarHandler.getInstance(DateFormatInfo.FORMAT_COMMA.getFormat());</strong><br>
	 * <strong>calendarHandler.getSystemDate();</strong><br>
	 * <strong>then "2019.02.16"</strong><br>
	 * </DD>
	 * </DL>
	 *
	 * @return Returns the client's system date
	 */
	public String getSystemDate() {

		return sdf.format(new Date());
	}

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * Set whether to allow lenient analysis of dates.<br>
	 * </DD>
	 * </DL>
	 *
	 * @param isLenient [i] Allow lenient analysis when it's {@code false}, else not allowed.
	 */
	public void setLenient(boolean isLenient) {

		sdf.setLenient(isLenient);
	}

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * Return enum class of week information linked to the date.<br>
	 * </DD>
	 * <DT>Note:</DT>
	 * <DD>
	 * If the corresponding week information does not exist, null will be returned.<br>
	 * </DD>
	 * <DT>Example:</DT>
	 * <DD>
	 * <strong>CalendarHandler calendarHandler = CalendarHandler.getInstance();</strong><br>
	 * <strong>WeekInfo weekInfo = calendarHandler.getDayOfWeekInfoByDate("20190216");</strong><br>
	 * <strong>weekInfo.getJapaneseName(); then "“y—j“ú"</strong><br>
	 * <br>
	 * <strong>CalendarHandler calendarHandler = CalendarHandler.getInstance(DateFormatInfo.FORMAT_COMMA.getFormat());</strong><br>
	 * <strong>WeekInfo weekInfo = calendarHandler.getDayOfWeekInfoByDate("2019.02.17");</strong><br>
	 * <strong>weekInfo.getEnglishName(); then "Saturday"</strong><br>
	 * </DD>
	 * </DL>
	 *
	 * @return Returns week information linked to the date. See detail {@link WeekInfo}.
	 *
	 * @see WeekInfo
	 * @see #getDayOfWeekInfoByDate(String)
	 */
	public WeekInfo getDayOfWeekInfoByDate() {

		String date = this.getDate();

		if (!StringChecker.isEffectiveString(date)) {
			return null;
		}

		return this.getDayOfWeekInfoByDate(date);
	}

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * Return enum class of week information linked to the argument.<br>
	 * </DD>
	 * <DT>Note:</DT>
	 * <DD>
	 * If the corresponding week information does not exist, null will be returned.<br>
	 * </DD>
	 * <DT>Example:</DT>
	 * <DD>
	 * <strong>CalendarHandler calendarHandler = CalendarHandler.getInstance();</strong><br>
	 * <strong>WeekInfo weekInfo = calendarHandler.getDayOfWeekInfoByDate("20190216");</strong><br>
	 * <strong>weekInfo.getJapaneseName(); then "“y—j“ú"</strong><br>
	 * <br>
	 * <strong>CalendarHandler calendarHandler = CalendarHandler.getInstance(DateFormatInfo.FORMAT_COMMA.getFormat());</strong><br>
	 * <strong>WeekInfo weekInfo = calendarHandler.getDayOfWeekInfoByDate("2019.02.17");</strong><br>
	 * <strong>weekInfo.getEnglishName(); then "Saturday"</strong><br>
	 * </DD>
	 * </DL>
	 *
	 * @param date [i] The date to use for getting week information.
	 * @return Returns week information linked to the argument. See detail {@link WeekInfo}.
	 *
	 * @see #spritDate(String)
	 * @see com.utilkit.java.CalendarHandler.ICalendarInfoEnum#getByCode(Class, int)
	 * @see WeekInfo
	 * @see FormatInfo#yyyy
	 * @see FormatInfo#MM
	 * @see FormatInfo#dd
	 */
	public WeekInfo getDayOfWeekInfoByDate(String date) {

		final Map<String, String> dateMap = this.spritDate(date);

		if (dateMap.isEmpty()) {
			return null;
		}

		final int year = Integer.parseInt(dateMap.get(FormatInfo.yyyy.getFormat()));
		final int month = Integer.parseInt(dateMap.get(FormatInfo.MM.getFormat()));
		final int day = Integer.parseInt(dateMap.get(FormatInfo.dd.getFormat()));

		cal.clear();
		cal.set(year, month-1, day);

		final int code = cal.get(Calendar.DAY_OF_WEEK);

		if (!ICalendarInfoEnum.hasCode(WeekInfo.class, code)) {
			return null;
		}

		return ICalendarInfoEnum.getByCode(WeekInfo.class, code);
	}

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * Return enum class of month information linked to the date.<br>
	 * </DD>
	 * <DT>Note:</DT>
	 * <DD>
	 * If the corresponding month information does not exist, null will be returned.<br>
	 * </DD>
	 * <DT>Example:</DT>
	 * <DD>
	 * <strong>CalendarHandler calendarHandler = CalendarHandler.getInstance();</strong><br>
	 * <strong>MonthInfo weekInfo = calendarHandler.getMonthInfoByDate("20190216");</strong><br>
	 * <strong>monthInfo.getJapaneseName(); then "2ŒŽ"</strong><br>
	 * <br>
	 * <strong>CalendarHandler calendarHandler = CalendarHandler.getInstance(DateFormatInfo.FORMAT_COMMA.getFormat());</strong><br>
	 * <strong>MonthInfo weekInfo = calendarHandler.getMonthInfoByDate("2019.02.17");</strong><br>
	 * <strong>monthInfo.getEnglishName(); then "February"</strong><br>
	 * </DD>
	 * </DL>
	 *
	 * @return Returns month information linked to the date. See detail {@link MonthInfo}.
	 *
	 * @see MonthInfo
	 * @see #getMonthInfoByDate(String)
	 */
	public MonthInfo getMonthInfoByDate() {

		String date = this.getDate();

		if (!StringChecker.isEffectiveString(date)) {
			return null;
		}

		return this.getMonthInfoByDate(date);
	}

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * Return enum class of month information linked to the argument.<br>
	 * </DD>
	 * <DT>Note:</DT>
	 * <DD>
	 * If the corresponding month information does not exist, null will be returned.<br>
	 * </DD>
	 * <DT>Example:</DT>
	 * <DD>
	 * <strong>CalendarHandler calendarHandler = CalendarHandler.getInstance();</strong><br>
	 * <strong>MonthInfo weekInfo = calendarHandler.getMonthInfoByDate("20190216");</strong><br>
	 * <strong>monthInfo.getJapaneseName(); then "2ŒŽ"</strong><br>
	 * <br>
	 * <strong>CalendarHandler calendarHandler = CalendarHandler.getInstance(DateFormatInfo.FORMAT_COMMA.getFormat());</strong><br>
	 * <strong>MonthInfo weekInfo = calendarHandler.getMonthInfoByDate("2019.02.17");</strong><br>
	 * <strong>monthInfo.getEnglishName(); then "February"</strong><br>
	 * </DD>
	 * </DL>
	 *
	 * @param date [i] The date to use for getting month information.
	 * @return Returns month information linked to the argument. See detail {@link MonthInfo}.
	 *
	 * @see #spritDate(String)
	 * @see com.utilkit.java.CalendarHandler.ICalendarInfoEnum#getByCode(Class, int)
	 * @see MonthInfo
	 * @see FormatInfo#yyyy
	 * @see FormatInfo#MM
	 * @see FormatInfo#dd
	 */
	public MonthInfo getMonthInfoByDate(String date) {

		final Map<String, String> dateMap = this.spritDate(date);

		if (dateMap.isEmpty()) {
			return null;
		}

		final int year = Integer.parseInt(dateMap.get(FormatInfo.yyyy.getFormat()));
		final int month = Integer.parseInt(dateMap.get(FormatInfo.MM.getFormat()));
		final int day = Integer.parseInt(dateMap.get(FormatInfo.dd.getFormat()));

		cal.clear();
		cal.set(year, month-1, day);

		final int code = cal.get(Calendar.MONTH);

		if (!ICalendarInfoEnum.hasCode(MonthInfo.class, code)) {
			return null;
		}

		return ICalendarInfoEnum.getByCode(MonthInfo.class, code);
	}

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * Increase or decrease the date according to the date.<br>
	 * </DD>
	 * <DT>Note:</DT>
	 * <DD>
	 * If the date does not exist, empty string will be returned.<br>
	 * </DD>
	 * <DT>Example:</DT>
	 * <DD>
	 * <strong>CalendarHandler calendarHandler = CalendarHandler.getInstance();</strong><br>
	 * <strong>calendarHandler.adjustDate("20190216", 1, 2, 0);</strong><br>
	 * <strong>then "20200416"</strong><br>
	 * <br>
	 * <strong>CalendarHandler calendarHandler = CalendarHandler.getInstance(DateFormatInfo.FORMAT_COMMA.getFormat());</strong><br>
	 * <strong>calendarHandler.adjustDate("2019.02.17", 0 -1, -1);</strong><br>
	 * <strong>then "2019.01.15"</strong><br>
	 * </DD>
	 * </DL>
	 *
	 * @param amountYear [i] Increase / Decrease in Year
	 * @param amountMonth [i] Increase / Decrease in Month
	 * @param amountDay [i] Increase / Decrease in day
	 * @return Returns an adjusted date
	 *
	 * @see #adjustDate(String, int, int, int)
	 */
	public String adjustDate(int amountYear, int amountMonth, int amountDay) {

		String date = this.getDate();

		if (!StringChecker.isEffectiveString(date)) {
			return "";
		}

		return this.adjustDate(date, amountYear, amountMonth, amountDay);
	}

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * Increase or decrease the date according to the argument.<br>
	 * </DD>
	 * <DT>Note:</DT>
	 * <DD>
	 * If the date does not exist, empty string will be returned.<br>
	 * </DD>
	 * <DT>Example:</DT>
	 * <DD>
	 * <strong>CalendarHandler calendarHandler = CalendarHandler.getInstance();</strong><br>
	 * <strong>calendarHandler.adjustDate("20190216", 1, 2, 0);</strong><br>
	 * <strong>then "20200416"</strong><br>
	 * <br>
	 * <strong>CalendarHandler calendarHandler = CalendarHandler.getInstance(DateFormatInfo.FORMAT_COMMA.getFormat());</strong><br>
	 * <strong>calendarHandler.adjustDate("2019.02.17", 0 -1, -1);</strong><br>
	 * <strong>then "2019.01.15"</strong><br>
	 * </DD>
	 * </DL>
	 *
	 * @param date [i] Value of the date to be adjusted
	 * @param amountYear [i] Increase / Decrease in Year
	 * @param amountMonth [i] Increase / Decrease in Month
	 * @param amountDay [i] Increase / Decrease in day
	 * @return Returns an adjusted date
	 *
	 * @see #spritDate(String)
	 * @see FormatInfo#yyyy
	 * @see FormatInfo#MM
	 * @see FormatInfo#dd
	 */
	public String adjustDate(String date, int amountYear, int amountMonth, int amountDay) {

		final Map<String, String> dateMap = this.spritDate(date);

		if (dateMap.isEmpty()) {
			return "";
		}

		final int year = Integer.parseInt(dateMap.get(FormatInfo.yyyy.getFormat()));
		final int month = Integer.parseInt(dateMap.get(FormatInfo.MM.getFormat()));
		final int day = Integer.parseInt(dateMap.get(FormatInfo.dd.getFormat()));

		cal.clear();
		cal.set(year, month-1, day);

		cal.add(Calendar.YEAR, amountYear);
		cal.add(Calendar.MONTH, amountMonth);
		cal.add(Calendar.DAY_OF_MONTH, amountDay);

		return sdf.format(cal.getTime());
	}

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * Increase or decrease the date according to the argument.<br>
	 * </DD>
	 * <DT>Note:</DT>
	 * <DD>
	 * If the date does not exist, -1 will be returned.<br>
	 * </DD>
	 * <DT>Example:</DT>
	 * <DD>
	 * <strong>CalendarHandler calendarHandler = CalendarHandler.getInstance();</strong><br>
	 * <strong>calendarHandler.getFirstDayOfMonth("20190216");</strong><br>
	 * <strong>then 1</strong><br>
	 * <br>
	 * <strong>CalendarHandler calendarHandler = CalendarHandler.getInstance(DateFormatInfo.FORMAT_COMMA.getFormat());</strong><br>
	 * <strong>calendarHandler.getFirstDayOfMonth("2019.02.17");</strong><br>
	 * <strong>then 1</strong><br>
	 * </DD>
	 * </DL>
	 *
	 * @return Returns the first day of the month
	 *
	 * @see #getFirstDayOfMonth(String)
	 */
	public int getFirstDayOfMonth() {

		String date = this.getDate();

		if (!StringChecker.isEffectiveString(date)) {
			return -1;
		}

		return this.getFirstDayOfMonth(date);
	}

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * Increase or decrease the date according to the argument.<br>
	 * </DD>
	 * <DT>Note:</DT>
	 * <DD>
	 * If the date does not exist, -1 will be returned.<br>
	 * </DD>
	 * <DT>Example:</DT>
	 * <DD>
	 * <strong>CalendarHandler calendarHandler = CalendarHandler.getInstance();</strong><br>
	 * <strong>calendarHandler.getFirstDayOfMonth("20190216");</strong><br>
	 * <strong>then 1</strong><br>
	 * <br>
	 * <strong>CalendarHandler calendarHandler = CalendarHandler.getInstance(DateFormatInfo.FORMAT_COMMA.getFormat());</strong><br>
	 * <strong>calendarHandler.getFirstDayOfMonth("2019.02.17");</strong><br>
	 * <strong>then 1</strong><br>
	 * </DD>
	 * </DL>
	 *
	 * @param date [i] Value of the date
	 * @return Returns the first day of the month
	 *
	 * @see #spritDate(String)
	 * @see FormatInfo#yyyy
	 * @see FormatInfo#MM
	 * @see FormatInfo#dd
	 */
	public int getFirstDayOfMonth(String date) {

		final Map<String, String> dateMap = this.spritDate(date);

		if (dateMap.isEmpty()) {
			return -1;
		}

		final int year = Integer.parseInt(dateMap.get(FormatInfo.yyyy.getFormat()));
		final int month = Integer.parseInt(dateMap.get(FormatInfo.MM.getFormat()));
		final int day = Integer.parseInt(dateMap.get(FormatInfo.dd.getFormat()));

		cal.clear();
		cal.set(year, month-1, day);

		return cal.getActualMinimum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * Increase or decrease the date according to the argument.<br>
	 * </DD>
	 * <DT>Note:</DT>
	 * <DD>
	 * If the date does not exist, -1 will be returned.<br>
	 * </DD>
	 * <DT>Example:</DT>
	 * <DD>
	 * <strong>CalendarHandler calendarHandler = CalendarHandler.getInstance();</strong><br>
	 * <strong>calendarHandler.getLastDayOfMonth("20190216");</strong><br>
	 * <strong>then 28</strong><br>
	 * <br>
	 * <strong>CalendarHandler calendarHandler = CalendarHandler.getInstance(DateFormatInfo.FORMAT_COMMA.getFormat());</strong><br>
	 * <strong>calendarHandler.getLastDayOfMonth("2019.01.17");</strong><br>
	 * <strong>then 31</strong><br>
	 * </DD>
	 * </DL>
	 *
	 * @return Returns the last day of the month
	 *
	 * @see #getLastDayOfMonth(String)
	 */
	public int getLastDayOfMonth() {

		String date = this.getDate();

		if (!StringChecker.isEffectiveString(date)) {
			return -1;
		}

		return this.getLastDayOfMonth(date);
	}

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * Increase or decrease the date according to the argument.<br>
	 * </DD>
	 * <DT>Note:</DT>
	 * <DD>
	 * If the date does not exist, -1 will be returned.<br>
	 * </DD>
	 * <DT>Example:</DT>
	 * <DD>
	 * <strong>CalendarHandler calendarHandler = CalendarHandler.getInstance();</strong><br>
	 * <strong>calendarHandler.getLastDayOfMonth("20190216");</strong><br>
	 * <strong>then 28</strong><br>
	 * <br>
	 * <strong>CalendarHandler calendarHandler = CalendarHandler.getInstance(DateFormatInfo.FORMAT_COMMA.getFormat());</strong><br>
	 * <strong>calendarHandler.getLastDayOfMonth("2019.01.17");</strong><br>
	 * <strong>then 31</strong><br>
	 * </DD>
	 * </DL>
	 *
	 * @param date [i] Value of the date
	 * @return Returns the last day of the month
	 *
	 * @see #spritDate(String)
	 * @see FormatInfo#yyyy
	 * @see FormatInfo#MM
	 * @see FormatInfo#dd
	 */
	public int getLastDayOfMonth(String date) {

		final Map<String, String> dateMap = this.spritDate(date);

		if (dateMap.isEmpty()) {
			return -1;
		}

		final int year = Integer.parseInt(dateMap.get(FormatInfo.yyyy.getFormat()));
		final int month = Integer.parseInt(dateMap.get(FormatInfo.MM.getFormat()));
		final int day = Integer.parseInt(dateMap.get(FormatInfo.dd.getFormat()));

		cal.clear();
		cal.set(year, month-1, day);

		return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * Return the beginning day of the week.<br>
	 * </DD>
	 * <DT>Note:</DT>
	 * <DD>
	 * If the date does not exist, empty string will be returned.<br>
	 * </DD>
	 * <DT>Example:</DT>
	 * <DD>
	 * <strong>CalendarHandler calendarHandler = CalendarHandler.getInstance();</strong><br>
	 * <strong>calendarHandler.getBeginningDateOfWeek("20190216");</strong><br>
	 * <strong>then TODO</strong><br>
	 * <br>
	 * <strong>CalendarHandler calendarHandler = CalendarHandler.getInstance(DateFormatInfo.FORMAT_COMMA.getFormat());</strong><br>
	 * <strong>calendarHandler.getBeginningDateOfWeek("2019.01.17");</strong><br>
	 * <strong>then TODO</strong><br>
	 * </DD>
	 * </DL>
	 *
	 * @return Returns the beginning day of the week
	 *
	 * @see #getBeginningDateOfWeek(String)
	 */
	public String getBeginningDateOfWeek() {

		String date = this.getDate();

		if (!StringChecker.isEffectiveString(date)) {
			return "";
		}

		return this.getBeginningDateOfWeek(date);
	}

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * Return the beginning day of the week.<br>
	 * </DD>
	 * <DT>Note:</DT>
	 * <DD>
	 * If the date does not exist, -1 will be returned.<br>
	 * </DD>
	 * <DT>Example:</DT>
	 * <DD>
	 * <strong>CalendarHandler calendarHandler = CalendarHandler.getInstance();</strong><br>
	 * <strong>calendarHandler.getBeginningDateOfWeek("20190216");</strong><br>
	 * <strong>then TODO</strong><br>
	 * <br>
	 * <strong>CalendarHandler calendarHandler = CalendarHandler.getInstance(DateFormatInfo.FORMAT_COMMA.getFormat());</strong><br>
	 * <strong>calendarHandler.getBeginningDateOfWeek("2019.01.17");</strong><br>
	 * <strong>then TODO</strong><br>
	 * </DD>
	 * </DL>
	 *
	 * @param date [i] Value of the date
	 * @return Returns the beginning day of the week
	 *
	 * @see #spritDate(String)
	 * @see FormatInfo#yyyy
	 * @see FormatInfo#MM
	 * @see FormatInfo#dd
	 */
	public String getBeginningDateOfWeek(String date) {

		final Map<String, String> dateMap = this.spritDate(date);

		if (dateMap.isEmpty()) {
			return "";
		}

		final int year = Integer.parseInt(dateMap.get(FormatInfo.yyyy.getFormat()));
		final int month = Integer.parseInt(dateMap.get(FormatInfo.MM.getFormat()));
		final int day = Integer.parseInt(dateMap.get(FormatInfo.dd.getFormat()));

		cal.clear();
		cal.set(year, month-1, day);

		final int dayOfweek = cal.get(Calendar.DAY_OF_WEEK);
		cal.add(Calendar.DAY_OF_MONTH, -dayOfweek);

		final String weekStart = sdf.format(cal.getTime());

		return weekStart;
	}

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * Return the end day of the week.<br>
	 * </DD>
	 * <DT>Note:</DT>
	 * <DD>
	 * If the date does not exist, empty string will be returned.<br>
	 * </DD>
	 * <DT>Example:</DT>
	 * <DD>
	 * <strong>CalendarHandler calendarHandler = CalendarHandler.getInstance();</strong><br>
	 * <strong>calendarHandler.getEndDateOfWeekFrom("20190216");</strong><br>
	 * <strong>then TODO</strong><br>
	 * <br>
	 * <strong>CalendarHandler calendarHandler = CalendarHandler.getInstance(DateFormatInfo.FORMAT_COMMA.getFormat());</strong><br>
	 * <strong>calendarHandler.getEndDateOfWeekFrom("2019.01.17");</strong><br>
	 * <strong>then TODO</strong><br>
	 * </DD>
	 * </DL>
	 *
	 * @return Returns the end day of the week
	 *
	 * @see #getEndDateOfWeek(String)
	 */
	public String getEndDateOfWeek() {

		String date = this.getDate();

		if (!StringChecker.isEffectiveString(date)) {
			return "";
		}

		return this.getEndDateOfWeek(date);
	}

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * Return the end day of the week.<br>
	 * </DD>
	 * <DT>Note:</DT>
	 * <DD>
	 * If the date does not exist, empty string will be returned.<br>
	 * </DD>
	 * <DT>Example:</DT>
	 * <DD>
	 * <strong>CalendarHandler calendarHandler = CalendarHandler.getInstance();</strong><br>
	 * <strong>calendarHandler.getEndDateOfWeekFrom("20190216");</strong><br>
	 * <strong>then TODO</strong><br>
	 * <br>
	 * <strong>CalendarHandler calendarHandler = CalendarHandler.getInstance(DateFormatInfo.FORMAT_COMMA.getFormat());</strong><br>
	 * <strong>calendarHandler.getEndDateOfWeekFrom("2019.01.17");</strong><br>
	 * <strong>then TODO</strong><br>
	 * </DD>
	 * </DL>
	 *
	 * @param date [i] Value of the date
	 * @return Returns the end day of the week
	 *
	 * @see #spritDate(String)
	 * @see FormatInfo#yyyy
	 * @see FormatInfo#MM
	 * @see FormatInfo#dd
	 */
	public String getEndDateOfWeek(String date) {

		final Map<String, String> dateMap = this.spritDate(date);

		if (dateMap.isEmpty()) {
			return "";
		}

		final int year = Integer.parseInt(dateMap.get(FormatInfo.yyyy.getFormat()));
		final int month = Integer.parseInt(dateMap.get(FormatInfo.MM.getFormat()));
		final int day = Integer.parseInt(dateMap.get(FormatInfo.dd.getFormat()));

		cal.clear();
		cal.set(year, month-1, day);

		final int dayOfweek = cal.get(Calendar.DAY_OF_WEEK);
		cal.add(Calendar.DAY_OF_MONTH, -dayOfweek);
		cal.add(Calendar.DAY_OF_MONTH, 6);

		final String weekEnd = sdf.format(cal.getTime());

		return weekEnd;
	}

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * Return boolean the date is valid or not.<br>
	 * </DD>
	 * <DT>Example:</DT>
	 * <DD>
	 * <strong>CalendarHandler calendarHandler = CalendarHandler.getInstance();</strong><br>
	 * <strong>calendarHandler.isEffectiveDate("20190216");</strong><br>
	 * <strong>then {@code true}</strong><br>
	 * <br>
	 * <strong>CalendarHandler calendarHandler = CalendarHandler.getInstance(DateFormatInfo.FORMAT_COMMA.getFormat());</strong><br>
	 * <strong>calendarHandler.isEffectiveDate("2019.01.17");</strong><br>
	 * <strong>then {@code true}</strong><br>
	 * </DD>
	 * </DL>
	 *
	 * @param date [i] Value of the date
	 * @return Returns {@code true} if the date is valid, or {@code false}
	 *
	 * @see com.utilkit.java.common.StringChecker#isEffectiveString(String)
	 */
	public boolean isEffectiveDate(String date) {

		if (!StringChecker.isEffectiveString(date)) {
			return false;
		}

		try {
			final Date tmpDate = sdf.parse(date);

			if (!date.equals(sdf.format(tmpDate))) {
				return false;
			}
		} catch (ParseException e) {
			return false;
		}

		return true;
	}

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * Return boolean the date is valid or not.<br>
	 * </DD>
	 * <DT>Example:</DT>
	 * <DD>
	 * <strong>CalendarHandler calendarHandler = CalendarHandler.getInstance();</strong><br>
	 * <strong>calendarHandler.isEffectiveDate(TODO);</strong><br>
	 * <strong>then {@code true}</strong><br>
	 * <br>
	 * <strong>CalendarHandler calendarHandler = CalendarHandler.getInstance(DateFormatInfo.FORMAT_COMMA.getFormat());</strong><br>
	 * <strong>calendarHandler.isEffectiveDate(TODO);</strong><br>
	 * <strong>then {@code true}</strong><br>
	 * </DD>
	 * </DL>
	 *
	 * @param date [i] Value of the date
	 * @return Returns {@code true} if the date is valid, or {@code false}
	 */
	public boolean isEffectiveDate(Date date) {

		if (date == null) {
			return false;
		}

		try {
			sdf.format(date);
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * Set date format.<br>
	 * </DD>
	 * <DT>Caution:</DT>
	 * <DD>
	 * It is advisable to use {@link DateFormatInfo}, as only the specified format is acceptable.<br>
	 * If pass a format other than the format defined for the {@link DateFormatInfo} as the argument, IllegalArgumentException will be thrown.<br>
	 * </DD>
	 * </DL>
	 *
	 * @param format [i] Value of date format
	 * @throws IllegalArgumentException throws when the argument is not valid
	 *
	 * @see com.utilkit.java.common.StringChecker#isEffectiveString(String)
	 * @see com.utilkit.java.CalendarHandler.IFormatInfoEnum#hasFormat(Class, String)
	 * @see DateFormatInfo
	 */
	public void applyPattern(String format) {

		if (!StringChecker.isEffectiveString(format)) {
			throw new IllegalArgumentException(String.format("Parameter [%s] is a invalid parameter.", format));
		}

		if (!IFormatInfoEnum.hasFormat(DateFormatInfo.class, format)) {
			throw new IllegalArgumentException(String.format("Parameter [%s] is a invalid format.", format));
		}

		sdf.applyPattern(format);
	}

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * Convert to String type from Date type.<br>
	 * </DD>
	 * </DL>
	 *
	 * @param date [i] Value of date
	 * @return Returns converted date
	 *
	 * @see #isEffectiveDate(Date)
	 */
	public String toString(Date date) {

		if (!this.isEffectiveDate(date)) {
			// shouldn't happen
			assert false;
			return "";
		}

		return sdf.format(date);
	}

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * Convert to Date type from String type.<br>
	 * </DD>
	 * </DL>
	 *
	 * @param date [i] Value of date
	 * @return Returns parsed date
	 *
	 * @see #isEffectiveDate(String)
	 */
	public Date toDate(String date) {

		if (!this.isEffectiveDate(date)) {
			// shouldn't happen
			assert false;
			return null;
		}

		Date parsedDate = null;

		try {
			parsedDate = sdf.parse(date);
		} catch (ParseException e) {
		}

		return parsedDate;
	}

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * Set the date.<br>
	 * </DD>
	 * </DL>
	 *
	 * @param date [i] Value of date
	 * @throws IllegalArgumentException throws when the argument is not valid
	 */
	public void setDate(String date) {

		if (!isEffectiveDate(date)) {
			throw new IllegalArgumentException(String.format("Parameter [%s] is a invalid parameter.", date));
		}

		this.date = date;
	}

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * Set the date.<br>
	 * </DD>
	 * </DL>
	 *
	 * @param Date [i] Value of date
	 * @throws IllegalArgumentException throws when the argument is not valid
	 */
	public void setDate(Date date) {

		final String strDate = this.toString(date);

		if (!StringChecker.isEffectiveString(strDate)) {
			throw new IllegalArgumentException(String.format("Parameter [%s] is a invalid parameter.", date));
		}

		this.date = strDate;
	}

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * Return the String date.<br>
	 * </DD>
	 * </DL>
	 *
	 * @return Returns the date.
	 */
	public String getDate() {

		return this.date;
	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;

		result = prime * result + ((date == null) ? 0 : date.hashCode());

		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (!(obj instanceof CalendarHandler)) {
			return false;
		}

		CalendarHandler other = (CalendarHandler) obj;

		if (date == null) {
			if (other.date != null) {
				return false;
			}
		} else if (!date.equals(other.date)) {
			return false;
		}

		return true;
	}

	@Override
	public String toString() {

		String date = this.getDate();
		StringBuilder sb = new StringBuilder();

		sb	.append("CalendarHandler [date=")
			.append(date)
			.append(", getDate()=")
			.append(date)
			.append(", getSystemDate()=" )
			.append(this.getSystemDate());

		if (StringChecker.isEffectiveString(date)) {

			// impossible to get results if date does not exist
			sb	.append(", getDayOfWeekInfoByDate()=")
				.append(this.getDayOfWeekInfoByDate())
				.append(", getMonthInfoByDate()=")
				.append(this.getMonthInfoByDate())
				.append(", getFirstDayOfMonth()=")
				.append(this.getFirstDayOfMonth())
				.append(", getLastDayOfMonth()=")
				.append(this.getLastDayOfMonth())
				.append(", getBeginningDateOfWeek()=")
				.append(this.getBeginningDateOfWeek())
				.append(", getEndDateOfWeek()=")
				.append(this.getEndDateOfWeek());
		}

		sb	.append(", hashCode()=")
			.append(this.hashCode())
			.append(", getClass()=")
			.append(this.getClass())
			.append(", toString()=")
			.append(super.toString())
			.append("]");

		return sb.toString();
	}

	// ================= private methods =====================================

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * Sprit the date passed as then argument and return as Map.<br>
	 * </DD>
	 * </DL>
	 *
	 * @param date [i] Value of date
	 * @return Returns Map with sprited date stored
	 *
	 * @see #isEffectiveDate(String)
	 * @see #trimSymbolFrom(String)
	 * @see FormatInfo#yyyy
	 * @see FormatInfo#MM
	 * @see FormatInfo#dd
	 */
	private Map<String, String> spritDate(String date) {

		final Map<String, String> dateMap = new HashMap<String, String>();

		if (!this.isEffectiveDate(date)) {
			return dateMap;
		}

		final String trimmedDate = this.trimSymbolFrom(date);

		if (trimmedDate.length() == 8) {
			dateMap.put(FormatInfo.yyyy.getFormat(), trimmedDate.substring(0, 4));
			dateMap.put(FormatInfo.MM.getFormat(), trimmedDate.substring(4, 6));
			dateMap.put(FormatInfo.dd.getFormat(), trimmedDate.substring(6, 8));
		}

		return dateMap;
	}

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * Trim the symbols contained in the string and return it.<br>
	 * </DD>
	 * </DL>
	 *
	 * @param string [i] Value of date
	 * @return Returns trimmed string
	 *
	 * @see SymbolInfo
	 * @see SymbolInfo#getFormat()
	 */
	private String trimSymbolFrom(String string) {

		String trimmedString = string;
		final SymbolInfo[] symbolInfo = SymbolInfo.values();

		for (SymbolInfo e : symbolInfo) {
			// trim symbols
			trimmedString = trimmedString.replace(e.getFormat(), "");
		}

		// should 8 bytes in yyyyMMdd format
		assert trimmedString.length() == 8;

		return trimmedString;
	}
}
