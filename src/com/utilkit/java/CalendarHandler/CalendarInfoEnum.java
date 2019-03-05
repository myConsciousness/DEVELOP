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

import java.util.Calendar;

/**
 * <DL>
 * <DT>Description:</DT>
 * <DD>
 * This enum class was defined to define the basic functions for manipulating calendar information.<br>
 * Each enum class implements an interface {@link com.utilkit.java.CalendarHandler.ICalendarInfoEnum} for efficiently manipulating calendar information<br>
 * Japanese name and English name operations are supported.<br>
 * </DD>
 * </DL>
 *
 * @author Kato Shinya
 * @since 2019.02.16
 * @version 1.0
 *
 * @see Calendar
 * @see com.utilkit.java.CalendarHandler.ICalendarInfoEnum
 */
public class CalendarInfoEnum {

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * This enum class was defined to efficiently manipulate week information.<br>
	 * This enum class implements an interface {@link com.utilkit.java.CalendarHandler.ICalendarInfoEnum} for efficiently manipulating calendar information<br>
	 * Japanese name and English name operations are supported.<br>
	 * </DD>
	 * </DL>
	 *
	 * @author : Kato Shinya
	 * @since : 2019.02.16
	 * @version : 1.0
	 *
	 * @see com.utilkit.java.CalendarHandler.ICalendarInfoEnum
	 */
	public enum WeekInfo implements ICalendarInfoEnum<WeekInfo> {

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * A constant field that represents Sunday.<br>
		 * It stores code value, Japanese name, English name, order value.<br>
		 * </DD>
		 * </DL>
		 *
		 * @see #Monday
		 * @see #Tuesday
		 * @see #Wednesday
		 * @see #Thursday
		 * @see #Friday
		 * @see #Saturday
		 * @see #isWeekend()
		 */
		Sunday(Calendar.SUNDAY, "ì˙ójì˙", "Sunday", 1) {
			@Override
			public boolean isWeekend() {
				return true;
			}
		},

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * A constant field that represents Monday.<br>
		 * It stores code value, Japanese name, English name, order value.<br>
		 * </DD>
		 * </DL>
		 *
		 * @see #Sunday
		 * @see #Tuesday
		 * @see #Wednesday
		 * @see #Thursday
		 * @see #Friday
		 * @see #Saturday
		 * @see #isWeekend()
		 */
		Monday(Calendar.MONDAY, "åéójì˙", "Monday", 2) {
			@Override
			public boolean isWeekend() {
				return false;
			}
		},

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * A constant field that represents Tuesday.<br>
		 * It stores code value, Japanese name, English name, order value.<br>
		 * </DD>
		 * </DL>
		 *
		 * @see #Sunday
		 * @see #Monday
		 * @see #Wednesday
		 * @see #Thursday
		 * @see #Friday
		 * @see #Saturday
		 * @see #isWeekend()
		 */
		Tuesday(Calendar.TUESDAY, "âŒójì˙", "Tuesday", 3) {
			@Override
			public boolean isWeekend() {
				return false;
			}
		},

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * A constant field that represents Wednesday.<br>
		 * It stores code value, Japanese name, English name, order value.<br>
		 * </DD>
		 * </DL>
		 *
		 * @see #Sunday
		 * @see #Monday
		 * @see #Tuesday
		 * @see #Thursday
		 * @see #Friday
		 * @see #Saturday
		 * @see #isWeekend()
		 */
		Wednesday(Calendar.WEDNESDAY, "êÖójì˙", "Wednesday", 4) {
			@Override
			public boolean isWeekend() {
				return false;
			}
		},

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * A constant field that represents Thursday.<br>
		 * It stores code value, Japanese name, English name, order value.<br>
		 * </DD>
		 * </DL>
		 *
		 * @see #Sunday
		 * @see #Monday
		 * @see #Tuesday
		 * @see #Wednesday
		 * @see #Friday
		 * @see #Saturday
		 * @see #isWeekend()
		 */
		Thursday(Calendar.THURSDAY, "ñÿójì˙", "Thursday", 5) {
			@Override
			public boolean isWeekend() {
				return false;
			}
		},

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * A constant field that represents Friday.<br>
		 * It stores code value, Japanese name, English name, order value.<br>
		 * </DD>
		 * </DL>
		 *
		 * @see #Sunday
		 * @see #Monday
		 * @see #Tuesday
		 * @see #Wednesday
		 * @see #Thursday
		 * @see #Saturday
		 * @see #isWeekend()
		 */
		Friday(Calendar.FRIDAY, "ã‡ójì˙", "Friday", 6) {
			@Override
			public boolean isWeekend() {
				return false;
			}
		},

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * A constant field that represents Saturday.<br>
		 * It stores code value, Japanese name, English name, order value.<br>
		 * </DD>
		 * </DL>
		 *
		 * @see #Sunday
		 * @see #Monday
		 * @see #Tuesday
		 * @see #Wednesday
		 * @see #Thursday
		 * @see #Friday
		 * @see #isWeekend()
		 */
		Saturday(Calendar.SATURDAY, "ìyójì˙", "Saturday", 7) {
			@Override
			public boolean isWeekend() {
				return true;
			}
		};

		private final int code;
		private final String japaneseName;
		private final String englishName;
		private final int order;

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * This constructor is used to initialise enum class.<br>
		 * </DD>
		 * </DL>
		 *
		 * @param code [i] Value of code
		 * @param japaneseName [i] Value of Japanese name
		 * @param englishName [i] Value of English name
		 * @param order [i] Value of order
		 */
		private WeekInfo(int code, String japaneseName, String englishName, int order) {
			this.code = code;
			this.japaneseName = japaneseName;
			this.englishName = englishName;
			this.order = order;
		}

		@Override
		public int getCode() {
			return this.code;
		}

		@Override
		public String getJapaneseName() {
			return this.japaneseName;
		}

		@Override
		public String getEnglishName() {
			return this.englishName;
		}

		@Override
		public int getOrder() {
			return this.order;
		}

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * This method is used to get boolean it is a weekend or not.<br>
		 * </DD>
		 * </DL>
		 *
		 * @return Returns {@code true} if it is a weekend, or {@code false}
		 */
		abstract public boolean isWeekend();
	}

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * This enum class was defined to efficiently manipulate month information.<br>
	 * This enum class implements an interface {@link com.utilkit.java.CalendarHandler.ICalendarInfoEnum} for efficiently manipulating calendar information<br>
	 * Japanese name and English name operations are supported.<br>
	 * </DD>
	 * <DT>Caution:</DT>
	 * <DD>
	 * The code value associated with the month follows the constant of the calendar class.<br>
	 * Therefore, the code value is {@code Month - 1}.<br>
	 * </DD>
	 * </DL>
	 *
	 * @author : Kato Shinya
	 * @since : 2019.02.16
	 * @version : 1.0
	 *
	 * @see Calendar
	 * @see com.utilkit.java.CalendarHandler.ICalendarInfoEnum
	 */
	public enum MonthInfo implements ICalendarInfoEnum<MonthInfo> {

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * A constant field that represents January.<br>
		 * It stores code value, Japanese name, English name, order value.<br>
		 * </DD>
		 * <DT>Caution:</DT>
		 * <DD>
		 * The code value associated with the month follows the constant of the calendar class.<br>
		 * Therefore, the code value is {@code Month - 1}.<br>
		 * </DD>
		 * </DL>
		 *
		 * @see #February
		 * @see #March
		 * @see #April
		 * @see #May
		 * @see #June
		 * @see #July
		 * @see #August
		 * @see #September
		 * @see #October
		 * @see #November
		 * @see #December
		 * @see #Undecimber
		 */
		January(Calendar.JANUARY, "1åé", "January", 1),

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * A constant field that represents February.<br>
		 * It stores code value, Japanese name, English name, order value.<br>
		 * </DD>
		 * <DT>Caution:</DT>
		 * <DD>
		 * The code value associated with the month follows the constant of the calendar class.<br>
		 * Therefore, the code value is {@code Month - 1}.<br>
		 * </DD>
		 * </DL>
		 *
		 * @see #January
		 * @see #March
		 * @see #April
		 * @see #May
		 * @see #June
		 * @see #July
		 * @see #August
		 * @see #September
		 * @see #October
		 * @see #November
		 * @see #December
		 * @see #Undecimber
		 */
		February(Calendar.FEBRUARY, "2åé", "February", 2),

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * A constant field that represents March.<br>
		 * It stores code value, Japanese name, English name, order value.<br>
		 * </DD>
		 * <DT>Caution:</DT>
		 * <DD>
		 * The code value associated with the month follows the constant of the calendar class.<br>
		 * Therefore, the code value is {@code Month - 1}.<br>
		 * </DD>
		 * </DL>
		 *
		 * @see #January
		 * @see #February
		 * @see #April
		 * @see #May
		 * @see #June
		 * @see #July
		 * @see #August
		 * @see #September
		 * @see #October
		 * @see #November
		 * @see #December
		 * @see #Undecimber
		 */
		March(Calendar.MARCH, "3åé", "March", 3),

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * A constant field that represents April.<br>
		 * It stores code value, Japanese name, English name, order value.<br>
		 * </DD>
		 * <DT>Caution:</DT>
		 * <DD>
		 * The code value associated with the month follows the constant of the calendar class.<br>
		 * Therefore, the code value is {@code Month - 1}.<br>
		 * </DD>
		 * </DL>
		 *
		 * @see #January
		 * @see #February
		 * @see #March
		 * @see #May
		 * @see #June
		 * @see #July
		 * @see #August
		 * @see #September
		 * @see #October
		 * @see #November
		 * @see #December
		 * @see #Undecimber
		 */
		April(Calendar.APRIL, "4åé", "April", 4),

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * A constant field that represents May.<br>
		 * It stores code value, Japanese name, English name, order value.<br>
		 * </DD>
		 * <DT>Caution:</DT>
		 * <DD>
		 * The code value associated with the month follows the constant of the calendar class.<br>
		 * Therefore, the code value is {@code Month - 1}.<br>
		 * </DD>
		 * </DL>
		 *
		 * @see #January
		 * @see #February
		 * @see #March
		 * @see #April
		 * @see #June
		 * @see #July
		 * @see #August
		 * @see #September
		 * @see #October
		 * @see #November
		 * @see #December
		 * @see #Undecimber
		 */
		May(Calendar.MAY, "5åé", "May", 5),

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * A constant field that represents June.<br>
		 * It stores code value, Japanese name, English name, order value.<br>
		 * </DD>
		 * <DT>Caution:</DT>
		 * <DD>
		 * The code value associated with the month follows the constant of the calendar class.<br>
		 * Therefore, the code value is {@code Month - 1}.<br>
		 * </DD>
		 * </DL>
		 *
		 * @see #January
		 * @see #February
		 * @see #March
		 * @see #April
		 * @see #May
		 * @see #July
		 * @see #August
		 * @see #September
		 * @see #October
		 * @see #November
		 * @see #December
		 * @see #Undecimber
		 */
		June(Calendar.JUNE, "6åé", "June", 6),

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * A constant field that represents July.<br>
		 * It stores code value, Japanese name, English name, order value.<br>
		 * </DD>
		 * <DT>Caution:</DT>
		 * <DD>
		 * The code value associated with the month follows the constant of the calendar class.<br>
		 * Therefore, the code value is {@code Month - 1}.<br>
		 * </DD>
		 * </DL>
		 *
		 * @see #January
		 * @see #February
		 * @see #March
		 * @see #April
		 * @see #May
		 * @see #June
		 * @see #August
		 * @see #September
		 * @see #October
		 * @see #November
		 * @see #December
		 * @see #Undecimber
		 */
		July(Calendar.JULY, "7åé", "July", 7),

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * A constant field that represents August.<br>
		 * It stores code value, Japanese name, English name, order value.<br>
		 * </DD>
		 * <DT>Caution:</DT>
		 * <DD>
		 * The code value associated with the month follows the constant of the calendar class.<br>
		 * Therefore, the code value is {@code Month - 1}.<br>
		 * </DD>
		 * </DL>
		 *
		 * @see #January
		 * @see #February
		 * @see #March
		 * @see #April
		 * @see #May
		 * @see #June
		 * @see #July
		 * @see #September
		 * @see #October
		 * @see #November
		 * @see #December
		 * @see #Undecimber
		 */
		August(Calendar.AUGUST, "8åé", "August", 8),

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * A constant field that represents September.<br>
		 * It stores code value, Japanese name, English name, order value.<br>
		 * </DD>
		 * <DT>Caution:</DT>
		 * <DD>
		 * The code value associated with the month follows the constant of the calendar class.<br>
		 * Therefore, the code value is {@code Month - 1}.<br>
		 * </DD>
		 * </DL>
		 *
		 * @see #January
		 * @see #February
		 * @see #March
		 * @see #April
		 * @see #May
		 * @see #June
		 * @see #July
		 * @see #August
		 * @see #October
		 * @see #November
		 * @see #December
		 * @see #Undecimber
		 */
		September(Calendar.SEPTEMBER, "9åé", "September", 9),

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * A constant field that represents October.<br>
		 * It stores code value, Japanese name, English name, order value.<br>
		 * </DD>
		 * <DT>Caution:</DT>
		 * <DD>
		 * The code value associated with the month follows the constant of the calendar class.<br>
		 * Therefore, the code value is {@code Month - 1}.<br>
		 * </DD>
		 * </DL>
		 *
		 * @see #January
		 * @see #February
		 * @see #March
		 * @see #April
		 * @see #May
		 * @see #June
		 * @see #July
		 * @see #August
		 * @see #September
		 * @see #November
		 * @see #December
		 * @see #Undecimber
		 */
		October(Calendar.OCTOBER, "10åé", "October", 10),

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * A constant field that represents November.<br>
		 * It stores code value, Japanese name, English name, order value.<br>
		 * </DD>
		 * <DT>Caution:</DT>
		 * <DD>
		 * The code value associated with the month follows the constant of the calendar class.<br>
		 * Therefore, the code value is {@code Month - 1}.<br>
		 * </DD>
		 * </DL>
		 *
		 * @see #January
		 * @see #February
		 * @see #March
		 * @see #April
		 * @see #May
		 * @see #June
		 * @see #July
		 * @see #August
		 * @see #September
		 * @see #October
		 * @see #December
		 * @see #Undecimber
		 */
		November(Calendar.NOVEMBER, "11åé", "November", 11),

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * A constant field that represents December.<br>
		 * It stores code value, Japanese name, English name, order value.<br>
		 * </DD>
		 * <DT>Caution:</DT>
		 * <DD>
		 * The code value associated with the month follows the constant of the calendar class.<br>
		 * Therefore, the code value is {@code Month - 1}.<br>
		 * </DD>
		 * </DL>
		 *
		 * @see #January
		 * @see #February
		 * @see #March
		 * @see #April
		 * @see #May
		 * @see #June
		 * @see #July
		 * @see #August
		 * @see #September
		 * @see #October
		 * @see #November
		 * @see #Undecimber
		 */
		December(Calendar.DECEMBER, "12åé", "December", 12),

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * A constant field that represents Undecimber.<br>
		 * It stores code value, Japanese name, English name, order value.<br>
		 * <br>
		 * Undecimber or Undecember is a name for a thirteenth month in a calendar that normally has twelve months.<br>
		 * Duodecimber or Duodecember is similarly a fourteenth month.<br>
		 * </DD>
		 * <DT>Caution:</DT>
		 * <DD>
		 * The code value associated with the month follows the constant of the calendar class.<br>
		 * Therefore, the code value is {@code Month - 1}.<br>
		 * </DD>
		 * </DL>
		 *
		 * @see #January
		 * @see #February
		 * @see #March
		 * @see #April
		 * @see #May
		 * @see #June
		 * @see #July
		 * @see #August
		 * @see #September
		 * @see #October
		 * @see #November
		 * @see #December
		 */
		Undecimber(Calendar.UNDECIMBER, "13åé", "Undecimber", Calendar.UNDECIMBER+1);

		private final int code;
		private final String japaneseName;
		private final String englishName;
		private final int order;

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * This constructor is used to initialise enum class.<br>
		 * </DD>
		 * </DL>
		 *
		 * @param code [i] Value of code.
		 * @param japaneseName [i] Value of Japanese name.
		 * @param englishName [i] Value of English name.
		 * @param order [i] Value of order.
		 */
		private MonthInfo(int code, String japaneseName, String englishName, int order) {
			this.code = code;
			this.japaneseName = japaneseName;
			this.englishName = englishName;
			this.order = order;
		}

		@Override
		public int getCode() {
			return this.code;
		}

		@Override
		public String getJapaneseName() {
			return this.japaneseName;
		}

		@Override
		public String getEnglishName() {
			return this.englishName;
		}

		@Override
		public int getOrder() {
			return this.order;
		}
	}
}
