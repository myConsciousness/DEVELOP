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
	private static final Calendar cal = Calendar.getInstance();;

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
	 * @see #setDateFormat(String)
	 */
	public static CalendarHandler getInstance(String dateFormat) {

		InstanceHolder.INSTANCE.setDateFormat(dateFormat);

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
		private static final CalendarHandler INSTANCE = new CalendarHandler();
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
	 * <strong>CalendarHandler calendarHandler = new CalendarHandler();</strong><br>
	 * <strong>calendarHandler.getSystemDate();</strong><br>
	 * <strong>then "20190216"</strong><br>
	 * <br>
	 * <strong>CalendarHandler calendarHandler = new CalendarHandler(DateFormatInfo.FORMAT_COMMA.getFormat());</strong><br>
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
	 * Return enum class of week information linked to the argument.<br>
	 * </DD>
	 * <DT>Example:</DT>
	 * <DD>
	 * <strong>CalendarHandler calendarHandler = new CalendarHandler();</strong><br>
	 * <strong>WeekInfo weekInfo = calendarHandler.getDayOfWeekInfoByDateOf("20190216");</strong><br>
	 * <strong>weekInfo.getJapaneseName(); then "“y—j“ú"</strong><br>
	 * <br>
	 * <strong>CalendarHandler calendarHandler = new CalendarHandler(DateFormatInfo.FORMAT_COMMA.getFormat());</strong><br>
	 * <strong>WeekInfo weekInfo = calendarHandler.getDayOfWeekInfoByDateOf("2019.02.17");</strong><br>
	 * <strong>weekInfo.getEnglishName(); then "Saturday"</strong><br>
	 * </DD>
	 * </DL>
	 *
	 * @param date [i] The date to use for getting week information.
	 * @return Returns week information linked to the argument. See detail {@link WeekInfo}.
	 *
	 * @see #spritDate(String)
	 * @see java.util.CalendarHandler.ICalendarInfoEnum#getByCode(Class, int)
	 * @see WeekInfo
	 * @see FormatInfo#yyyy
	 * @see FormatInfo#MM
	 * @see FormatInfo#dd
	 */
	public WeekInfo getDayOfWeekInfoByDate(String date) {

		int code = -1;
		final Map<String, String> dateMap = this.spritDate(date);

		if (!dateMap.isEmpty()) {

			final int year = Integer.parseInt(dateMap.get(FormatInfo.yyyy.getFormat()));
			final int month = Integer.parseInt(dateMap.get(FormatInfo.MM.getFormat()));
			final int day = Integer.parseInt(dateMap.get(FormatInfo.dd.getFormat()));

			cal.clear();
			cal.set(year, month-1, day);

			code = cal.get(Calendar.DAY_OF_WEEK);
		}

		return ICalendarInfoEnum.getByCode(WeekInfo.class, code);
	}

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * Return enum class of month information linked to the argument.<br>
	 * </DD>
	 * <DT>Example:</DT>
	 * <DD>
	 * <strong>CalendarHandler calendarHandler = new CalendarHandler();</strong><br>
	 * <strong>MonthInfo weekInfo = calendarHandler.getMonthInfoByDateOf("20190216");</strong><br>
	 * <strong>monthInfo.getJapaneseName(); then "2ŒŽ"</strong><br>
	 * <br>
	 * <strong>CalendarHandler calendarHandler = new CalendarHandler(DateFormatInfo.FORMAT_COMMA.getFormat());</strong><br>
	 * <strong>MonthInfo weekInfo = calendarHandler.getMonthInfoByDateOf("2019.02.17");</strong><br>
	 * <strong>monthInfo.getEnglishName(); then "February"</strong><br>
	 * </DD>
	 * </DL>
	 *
	 * @param date [i] The date to use for getting month information.
	 * @return Returns month information linked to the argument. See detail {@link MonthInfo}.
	 *
	 * @see #spritDate(String)
	 * @see java.util.CalendarHandler.ICalendarInfoEnum#getByCode(Class, int)
	 * @see MonthInfo
	 * @see FormatInfo#yyyy
	 * @see FormatInfo#MM
	 * @see FormatInfo#dd
	 */
	public MonthInfo getMonthInfoByDate(String date) {

		int code = -1;
		final Map<String, String> dateMap = this.spritDate(date);

		if (!dateMap.isEmpty()) {

			final int year = Integer.parseInt(dateMap.get(FormatInfo.yyyy.getFormat()));
			final int month = Integer.parseInt(dateMap.get(FormatInfo.MM.getFormat()));
			final int day = Integer.parseInt(dateMap.get(FormatInfo.dd.getFormat()));

			cal.clear();
			cal.set(year, month-1, day);

			code = cal.get(Calendar.MONTH);
		}

		return ICalendarInfoEnum.getByCode(MonthInfo.class, code);
	}

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * Increase or decrease the date according to the argument.<br>
	 * </DD>
	 * <DT>Example:</DT>
	 * <DD>
	 * <strong>CalendarHandler calendarHandler = new CalendarHandler();</strong><br>
	 * <strong>calendarHandler.adjustDate("20190216", 1, 2, 0);</strong><br>
	 * <strong>then "20200416"</strong><br>
	 * <br>
	 * <strong>CalendarHandler calendarHandler = new CalendarHandler(DateFormatInfo.FORMAT_COMMA.getFormat());</strong><br>
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

		String resultDate = "";
		final Map<String, String> dateMap = this.spritDate(date);

		if (!dateMap.isEmpty()) {

			final int year = Integer.parseInt(dateMap.get(FormatInfo.yyyy.getFormat()));
			final int month = Integer.parseInt(dateMap.get(FormatInfo.MM.getFormat()));
			final int day = Integer.parseInt(dateMap.get(FormatInfo.dd.getFormat()));

			cal.clear();
			cal.set(year, month-1, day);

			cal.add(Calendar.YEAR, amountYear);
			cal.add(Calendar.MONTH, amountMonth);
			cal.add(Calendar.DAY_OF_MONTH, amountDay);

			resultDate = sdf.format(cal.getTime());
		}

		return resultDate;
	}

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * Increase or decrease the date according to the argument.<br>
	 * </DD>
	 * <DT>Example:</DT>
	 * <DD>
	 * <strong>CalendarHandler calendarHandler = new CalendarHandler();</strong><br>
	 * <strong>calendarHandler.getFirstDayOfMonthFrom("20190216");</strong><br>
	 * <strong>then 1</strong><br>
	 * <br>
	 * <strong>CalendarHandler calendarHandler = new CalendarHandler(DateFormatInfo.FORMAT_COMMA.getFormat());</strong><br>
	 * <strong>calendarHandler.getFirstDayOfMonthFrom("2019.02.17");</strong><br>
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

		int firstDay = -1;
		final Map<String, String> dateMap = this.spritDate(date);

		if (!dateMap.isEmpty()) {

			final int year = Integer.parseInt(dateMap.get(FormatInfo.yyyy.getFormat()));
			final int month = Integer.parseInt(dateMap.get(FormatInfo.MM.getFormat()));
			final int day = Integer.parseInt(dateMap.get(FormatInfo.dd.getFormat()));

			cal.clear();
			cal.set(year, month-1, day);

			firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
		}

		return firstDay;
	}

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * Increase or decrease the date according to the argument.<br>
	 * </DD>
	 * <DT>Example:</DT>
	 * <DD>
	 * <strong>CalendarHandler calendarHandler = new CalendarHandler();</strong><br>
	 * <strong>calendarHandler.getLastDayOfMonthFrom("20190216");</strong><br>
	 * <strong>then 28</strong><br>
	 * <br>
	 * <strong>CalendarHandler calendarHandler = new CalendarHandler(DateFormatInfo.FORMAT_COMMA.getFormat());</strong><br>
	 * <strong>calendarHandler.getLastDayOfMonthFrom("2019.01.17");</strong><br>
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

		int lastDay = -1;
		final Map<String, String> dateMap = this.spritDate(date);

		if (!dateMap.isEmpty()) {

			final int year = Integer.parseInt(dateMap.get(FormatInfo.yyyy.getFormat()));
			final int month = Integer.parseInt(dateMap.get(FormatInfo.MM.getFormat()));
			final int day = Integer.parseInt(dateMap.get(FormatInfo.dd.getFormat()));

			cal.clear();
			cal.set(year, month-1, day);

			lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		}

		return lastDay;
	}

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * Return the beginning day of the week.<br>
	 * </DD>
	 * <DT>Example:</DT>
	 * <DD>
	 * <strong>CalendarHandler calendarHandler = new CalendarHandler();</strong><br>
	 * <strong>calendarHandler.getBeginningDateOfWeekFrom("20190216");</strong><br>
	 * <strong>then TODO</strong><br>
	 * <br>
	 * <strong>CalendarHandler calendarHandler = new CalendarHandler(DateFormatInfo.FORMAT_COMMA.getFormat());</strong><br>
	 * <strong>calendarHandler.getBeginningDateOfWeekFrom("2019.01.17");</strong><br>
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

		String weekStart = "";
		final Map<String, String> dateMap = this.spritDate(date);

		if (!dateMap.isEmpty()) {

			final int year = Integer.parseInt(dateMap.get(FormatInfo.yyyy.getFormat()));
			final int month = Integer.parseInt(dateMap.get(FormatInfo.MM.getFormat()));
			final int day = Integer.parseInt(dateMap.get(FormatInfo.dd.getFormat()));

			cal.clear();
			cal.set(year, month-1, day);

			final int dayOfweek = cal.get(Calendar.DAY_OF_WEEK);
			cal.add(Calendar.DAY_OF_MONTH, -dayOfweek);

			weekStart = sdf.format(cal.getTime());
		}

		return weekStart;
	}

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * Return the end day of the week.<br>
	 * </DD>
	 * <DT>Example:</DT>
	 * <DD>
	 * <strong>CalendarHandler calendarHandler = new CalendarHandler();</strong><br>
	 * <strong>calendarHandler.getEndDateOfWeekFrom("20190216");</strong><br>
	 * <strong>then TODO</strong><br>
	 * <br>
	 * <strong>CalendarHandler calendarHandler = new CalendarHandler(DateFormatInfo.FORMAT_COMMA.getFormat());</strong><br>
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

		String weekEnd = "";
		final Map<String, String> dateMap = this.spritDate(date);

		if (!dateMap.isEmpty()) {

			final int year = Integer.parseInt(dateMap.get(FormatInfo.yyyy.getFormat()));
			final int month = Integer.parseInt(dateMap.get(FormatInfo.MM.getFormat()));
			final int day = Integer.parseInt(dateMap.get(FormatInfo.dd.getFormat()));

			cal.clear();
			cal.set(year, month-1, day);

			final int dayOfweek = cal.get(Calendar.DAY_OF_WEEK);
			cal.add(Calendar.DAY_OF_MONTH, -dayOfweek);
			cal.add(Calendar.DAY_OF_MONTH, 6);

			weekEnd = sdf.format(cal.getTime());
		}

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
	 * <strong>CalendarHandler calendarHandler = new CalendarHandler();</strong><br>
	 * <strong>calendarHandler.isEffectiveDate("20190216");</strong><br>
	 * <strong>then {@code true}</strong><br>
	 * <br>
	 * <strong>CalendarHandler calendarHandler = new CalendarHandler(DateFormatInfo.FORMAT_COMMA.getFormat());</strong><br>
	 * <strong>calendarHandler.isEffectiveDate("2019.01.17");</strong><br>
	 * <strong>then {@code true}</strong><br>
	 * </DD>
	 * </DL>
	 *
	 * @param date [i] Value of the date
	 * @return Returns {@code true} if the date is valid, or {@code false}
	 *
	 * @see java.util.common.StringChecker#isEffectiveString(String)
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
	 * <strong>CalendarHandler calendarHandler = new CalendarHandler();</strong><br>
	 * <strong>calendarHandler.isEffectiveDate(TODO);</strong><br>
	 * <strong>then {@code true}</strong><br>
	 * <br>
	 * <strong>CalendarHandler calendarHandler = new CalendarHandler(DateFormatInfo.FORMAT_COMMA.getFormat());</strong><br>
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
	 * @see java.util.common.StringChecker#isEffectiveString(String)
	 * @see java.util.CalendarHandler.IFormatInfoEnum#hasFormat(Class, String)
	 * @see DateFormatInfo
	 */
	public void setDateFormat(String format) {

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

		if (this.isEffectiveDate(date)) {
			return sdf.format(date);
		}

		// shouldn't happen
		assert false;

		return "";
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
	 * @return Returns converted date
	 *
	 * @see #isEffectiveDate(String)
	 */
	public Date toDate(String date) {

		if (this.isEffectiveDate(date)) {
			try {
				return sdf.parse(date);
			} catch (ParseException e) {
			}
		}

		// shouldn't happen
		assert false;

		return null;
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
	 * @param str [i] Value of date
	 * @return Returns trimmed string
	 *
	 * @see SymbolInfo
	 * @see SymbolInfo#getFormat()
	 */
	private String trimSymbolFrom(String str) {

		String trimmedString = str;
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
