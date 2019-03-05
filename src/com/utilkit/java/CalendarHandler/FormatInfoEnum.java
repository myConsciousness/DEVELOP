package com.utilkit.java.CalendarHandler;
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


/**
 * <DL>
 * <DT>Description:</DT>
 * <DD>
 * This enum class was defined to define the basic functions for manipulating format information.<br>
 * Each enum class implements an interface {@link com.utilkit.java.CalendarHandler.IFormatInfoEnum} for efficiently manipulating format information.<br>
 * </DD>
 * </DL>
 *
 * @author Kato Shinya
 * @since 2019.02.16
 * @version 1.0
 *
 * @see com.utilkit.java.CalendarHandler.IFormatInfoEnum
 */
public class FormatInfoEnum {

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * This enum class was defined to efficiently manipulate symbol information.<br>
	 * This enum class implements an interface {@link com.utilkit.java.CalendarHandler.IFormatInfoEnum} for efficiently manipulating format information.<br>
	 * </DD>
	 * </DL>
	 *
	 * @author : Kato Shinya
	 * @since : 2019.02.16
	 * @version : 1.0
	 *
	 * @see com.utilkit.java.CalendarHandler.IFormatInfoEnum
	 */
	public enum SymbolInfo implements IFormatInfoEnum<SymbolInfo> {

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * A constant field that represents slash.<br>
		 * It stores code value, format, order.<br>
		 * </DD>
		 * </DL>
		 *
		 * @see #COMMA
		 * @see #HYPHEN
		 * @see #SPACE
		 */
		SLASH(1, "/", 1),

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * A constant field that represents comma.<br>
		 * It stores code value, format, order.<br>
		 * </DD>
		 * </DL>
		 *
		 * @see #SLASH
		 * @see #HYPHEN
		 * @see #SPACE
		 */
		COMMA(2, ".", 2),

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * A constant field that represents hyphen.<br>
		 * It stores code value, format, order.<br>
		 * </DD>
		 * </DL>
		 *
		 * @see #SLASH
		 * @see #COMMA
		 * @see #SPACE
		 */
		HYPHEN(3, "-", 3),

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * A constant field that represents single byte space.<br>
		 * It stores code value, format, order.<br>
		 * </DD>
		 * </DL>
		 *
		 * @see #SLASH
		 * @see #COMMA
		 * @see #HYPHEN
		 */
		SPACE(4, " ", 4);

		private final int code;
		private final String format;
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
		 * @param format [i] Value of format
		 * @param order [i] Value of order
		 */
		private SymbolInfo(int code, String format, int order) {
			this.code = code;
			this.format = format;
			this.order = order;
		}

		@Override
		public int getCode() {
			return this.code;
		}

		@Override
		public String getFormat() {
			return this.format;
		}

		@Override
		public int getOrder() {
			return this.order;
		}
	}

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * This enum class was defined to efficiently manipulate date format information.<br>
	 * This enum class implements an interface {@link com.utilkit.java.CalendarHandler.IFormatInfoEnum} for efficiently manipulating format information.<br>
	 * </DD>
	 * </DL>
	 *
	 * @author : Kato Shinya
	 * @since : 2019.02.16
	 * @version : 1.0
	 *
	 * @see com.utilkit.java.CalendarHandler.IFormatInfoEnum
	 */
	public enum DateFormatInfo implements IFormatInfoEnum<DateFormatInfo> {

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * A constant field that represents yyyy/MM/dd format.<br>
		 * It stores code value, date format, order.<br>
		 * </DD>
		 * </DL>
		 *
		 * @see #COMMA
		 * @see #HYPHEN
		 * @see #SPACE
		 * @see #DEFALUT
		 * @see #AMERICA
		 * @see #CANADA
		 * @see #ENGLAND
		 * @see #FINLAND
		 * @see #FRANCE
		 * @see #THAILAND
		 * @see #GERMANY
		 * @see #DENMARK
		 * @see #SWEDEN
		 * @see #ITALY
		 * @see #NORWAY
		 * @see #SPAIN
		 */
		SLASH(1, "yyyy/MM/dd", 1),

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * A constant field that represents yyyy.MM.dd format.<br>
		 * It stores code value, date format, order.<br>
		 * </DD>
		 * </DL>
		 *
		 * @see #SLASH
		 * @see #HYPHEN
		 * @see #SPACE
		 * @see #DEFALUT
		 * @see #AMERICA
		 * @see #CANADA
		 * @see #ENGLAND
		 * @see #FINLAND
		 * @see #FRANCE
		 * @see #THAILAND
		 * @see #GERMANY
		 * @see #DENMARK
		 * @see #SWEDEN
		 * @see #ITALY
		 * @see #NORWAY
		 * @see #SPAIN
		 */
		COMMA(2, "yyyy.MM.dd", 2),

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * A constant field that represents yyyy-MM-dd format.<br>
		 * It stores code value, date format, order.<br>
		 * </DD>
		 * </DL>
		 *
		 * @see #SLASH
		 * @see #COMMA
		 * @see #SPACE
		 * @see #DEFALUT
		 * @see #AMERICA
		 * @see #CANADA
		 * @see #ENGLAND
		 * @see #FINLAND
		 * @see #FRANCE
		 * @see #THAILAND
		 * @see #GERMANY
		 * @see #DENMARK
		 * @see #SWEDEN
		 * @see #ITALY
		 * @see #NORWAY
		 * @see #SPAIN
		 */
		HYPHEN(3, "yyyy-MM-dd", 3),

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * A constant field that represents yyyy MM dd format.<br>
		 * It stores code value, date format, order.<br>
		 * </DD>
		 * </DL>
		 *
		 * @see #SLASH
		 * @see #COMMA
		 * @see #HYPHEN
		 * @see #DEFALUT
		 * @see #AMERICA
		 * @see #CANADA
		 * @see #ENGLAND
		 * @see #FINLAND
		 * @see #FRANCE
		 * @see #THAILAND
		 * @see #GERMANY
		 * @see #DENMARK
		 * @see #SWEDEN
		 * @see #ITALY
		 * @see #NORWAY
		 * @see #SPAIN
		 */
		SPACE(4, "yyyy MM dd", 4),

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * A constant field that represents yyyyMMdd format.<br>
		 * It stores code value, format.<br>
		 * </DD>
		 * </DL>
		 *
		 * @see #SLASH
		 * @see #COMMA
		 * @see #HYPHEN
		 * @see #SPACE
		 * @see #AMERICA
		 * @see #CANADA
		 * @see #ENGLAND
		 * @see #FINLAND
		 * @see #FRANCE
		 * @see #THAILAND
		 * @see #GERMANY
		 * @see #DENMARK
		 * @see #SWEDEN
		 * @see #ITALY
		 * @see #NORWAY
		 * @see #SPAIN
		 */
		DEFALUT(5, "yyyyMMdd", 5),

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * A constant field that represents MM-dd-yy format.<br>
		 * Date format used in the United States.<br>
		 * It stores code value, date format, order.<br>
		 * </DD>
		 * </DL>
		 *
		 * @see #SLASH
		 * @see #COMMA
		 * @see #HYPHEN
		 * @see #SPACE
		 * @see #DEFALUT
		 * @see #CANADA
		 * @see #ENGLAND
		 * @see #FINLAND
		 * @see #FRANCE
		 * @see #THAILAND
		 * @see #GERMANY
		 * @see #DENMARK
		 * @see #SWEDEN
		 * @see #ITALY
		 * @see #NORWAY
		 * @see #SPAIN
		 */
		AMERICA(6, "MM-dd-yy", 6),

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * A constant field that represents dd/MM/yy format.<br>
		 * Date format used in Canada.<br>
		 * It stores code value, date format, order.<br>
		 * </DD>
		 * </DL>
		 *
		 * @see #SLASH
		 * @see #COMMA
		 * @see #HYPHEN
		 * @see #SPACE
		 * @see #DEFALUT
		 * @see #AMERICA
		 * @see #ENGLAND
		 * @see #FINLAND
		 * @see #FRANCE
		 * @see #THAILAND
		 * @see #GERMANY
		 * @see #DENMARK
		 * @see #SWEDEN
		 * @see #ITALY
		 * @see #NORWAY
		 * @see #SPAIN
		 */
		CANADA(7, "dd/MM/yy", 7),

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * A constant field that represents dd/MM/yy format.<br>
		 * Date format used in England.<br>
		 * It stores code value, date format, order.<br>
		 * </DD>
		 * </DL>
		 *
		 * @see #SLASH
		 * @see #COMMA
		 * @see #HYPHEN
		 * @see #SPACE
		 * @see #DEFALUT
		 * @see #AMERICA
		 * @see #CANADA
		 * @see #FINLAND
		 * @see #FRANCE
		 * @see #THAILAND
		 * @see #GERMANY
		 * @see #DENMARK
		 * @see #SWEDEN
		 * @see #ITALY
		 * @see #NORWAY
		 * @see #SPAIN
		 */
		ENGLAND(8, "dd/MM/yy", 8),

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * A constant field that represents dd.MM.yyyy format.<br>
		 * Date format used in Finland.<br>
		 * It stores code value, date format, order.<br>
		 * </DD>
		 * </DL>
		 *
		 * @see #SLASH
		 * @see #COMMA
		 * @see #HYPHEN
		 * @see #SPACE
		 * @see #DEFALUT
		 * @see #AMERICA
		 * @see #CANADA
		 * @see #ENGLAND
		 * @see #FRANCE
		 * @see #THAILAND
		 * @see #GERMANY
		 * @see #DENMARK
		 * @see #SWEDEN
		 * @see #ITALY
		 * @see #NORWAY
		 * @see #SPAIN
		 */
		FINLAND(9, "dd.MM.yyyy", 9),

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * A constant field that represents dd/MM/yyyy format.<br>
		 * Date format used in France.<br>
		 * It stores code value, date format, order.<br>
		 * </DD>
		 * </DL>
		 *
		 * @see #SLASH
		 * @see #COMMA
		 * @see #HYPHEN
		 * @see #SPACE
		 * @see #DEFALUT
		 * @see #AMERICA
		 * @see #CANADA
		 * @see #ENGLAND
		 * @see #FINLAND
		 * @see #THAILAND
		 * @see #GERMANY
		 * @see #DENMARK
		 * @see #SWEDEN
		 * @see #ITALY
		 * @see #NORWAY
		 * @see #SPAIN
		 */
		FRANCE(10, "dd/MM/yyyy", 10),

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * A constant field that represents dd/MM/yyyy format.<br>
		 * Date format used in Thailand.<br>
		 * It stores code value, date format, order.<br>
		 * </DD>
		 * </DL>
		 *
		 * @see #SLASH
		 * @see #COMMA
		 * @see #HYPHEN
		 * @see #SPACE
		 * @see #DEFALUT
		 * @see #AMERICA
		 * @see #CANADA
		 * @see #ENGLAND
		 * @see #FINLAND
		 * @see #FRANCE
		 * @see #GERMANY
		 * @see #DENMARK
		 * @see #SWEDEN
		 * @see #ITALY
		 * @see #NORWAY
		 * @see #SPAIN
		 */
		THAILAND(11, "dd/MM/yyyy", 11),

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * A constant field that represents yyyy-MM-dd format.<br>
		 * Date format used in Germany.<br>
		 * It stores code value, date format, order.<br>
		 * </DD>
		 * </DL>
		 *
		 * @see #SLASH
		 * @see #COMMA
		 * @see #HYPHEN
		 * @see #SPACE
		 * @see #DEFALUT
		 * @see #AMERICA
		 * @see #CANADA
		 * @see #ENGLAND
		 * @see #FINLAND
		 * @see #FRANCE
		 * @see #THAILAND
		 * @see #DENMARK
		 * @see #SWEDEN
		 * @see #ITALY
		 * @see #NORWAY
		 * @see #SPAIN
		 */
		GERMANY(12, "yyyy-MM-dd", 12),

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * A constant field that represents yyyy-MM-dd format.<br>
		 * Date format used in Denmark.<br>
		 * It stores code value, date format, order.<br>
		 * </DD>
		 * </DL>
		 *
		 * @see #SLASH
		 * @see #COMMA
		 * @see #HYPHEN
		 * @see #SPACE
		 * @see #DEFALUT
		 * @see #AMERICA
		 * @see #CANADA
		 * @see #ENGLAND
		 * @see #FINLAND
		 * @see #FRANCE
		 * @see #THAILAND
		 * @see #GERMANY
		 * @see #SWEDEN
		 * @see #ITALY
		 * @see #NORWAY
		 * @see #SPAIN
		 */
		DENMARK(13, "yyyy-MM-dd", 13),

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * A constant field that represents yyyy-MM-dd format.<br>
		 * Date format used in Sweden.<br>
		 * It stores code value, date format, order.<br>
		 * </DD>
		 * </DL>
		 *
		 * @see #SLASH
		 * @see #COMMA
		 * @see #HYPHEN
		 * @see #SPACE
		 * @see #DEFALUT
		 * @see #AMERICA
		 * @see #CANADA
		 * @see #ENGLAND
		 * @see #FINLAND
		 * @see #FRANCE
		 * @see #THAILAND
		 * @see #GERMANY
		 * @see #DENMARK
		 * @see #ITALY
		 * @see #NORWAY
		 * @see #SPAIN
		 */
		SWEDEN(14, "yyyy-MM-dd", 14),

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * A constant field that represents dd/MM/yy format.<br>
		 * Date format used in Italy.<br>
		 * It stores code value, date format, order.<br>
		 * </DD>
		 * </DL>
		 *
		 * @see #SLASH
		 * @see #COMMA
		 * @see #HYPHEN
		 * @see #SPACE
		 * @see #DEFALUT
		 * @see #AMERICA
		 * @see #CANADA
		 * @see #ENGLAND
		 * @see #FINLAND
		 * @see #FRANCE
		 * @see #THAILAND
		 * @see #GERMANY
		 * @see #DENMARK
		 * @see #SWEDEN
		 * @see #NORWAY
		 * @see #SPAIN
		 */
		ITALY(15, "dd/MM/yy", 15),

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * A constant field that represents dd-MM-yy format.<br>
		 * Date format used in Norway, order.<br>
		 * It stores code value, date format, order.<br>
		 * </DD>
		 * </DL>
		 *
		 * @see #SLASH
		 * @see #COMMA
		 * @see #HYPHEN
		 * @see #SPACE
		 * @see #DEFALUT
		 * @see #AMERICA
		 * @see #CANADA
		 * @see #ENGLAND
		 * @see #FINLAND
		 * @see #FRANCE
		 * @see #THAILAND
		 * @see #GERMANY
		 * @see #DENMARK
		 * @see #SWEDEN
		 * @see #ITALY
		 * @see #SPAIN
		 */
		NORWAY(16, "dd-MM-yy", 16),

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * A constant field that represents dd-MM-yy format.<br>
		 * Date format used in Spain.<br>
		 * It stores code value, date format, order.<br>
		 * </DD>
		 * </DL>
		 *
		 * @see #SLASH
		 * @see #COMMA
		 * @see #HYPHEN
		 * @see #SPACE
		 * @see #DEFALUT
		 * @see #AMERICA
		 * @see #CANADA
		 * @see #ENGLAND
		 * @see #FINLAND
		 * @see #FRANCE
		 * @see #THAILAND
		 * @see #GERMANY
		 * @see #DENMARK
		 * @see #SWEDEN
		 * @see #ITALY
		 * @see #NORWAY
		 */
		SPAIN(17, "dd-MM-yy", 17);

		private final int code;
		private final String format;
		private final int order;

		/**
		 * <DL>
		 * <DD>
		 * This constructor is used to initialise enum class.<br>
		 * </DD>
		 * </DL>
		 *
		 * @param code [i] Value of code.
		 * @param format [i] Value of format.
		 * @param order [i] Value of order.
		 */
		private DateFormatInfo(int code, String format, int order) {
			this.code = code;
			this.format = format;
			this.order = order;
		}

		@Override
		public int getCode() {
			return this.code;
		}

		@Override
		public String getFormat() {
			return this.format;
		}

		@Override
		public int getOrder() {
			return this.order;
		}
	}

	/**
	 * <DL>
	 * <DT>Description:</DT>
	 * <DD>
	 * This enum class was defined to efficiently manipulate format information.<br>
	 * This enum class implements an interface {@link com.utilkit.java.CalendarHandler.IFormatInfoEnum} for efficiently manipulating format information.<br>
	 * </DD>
	 * </DL>
	 *
	 * @author Kato : Shinya
	 * @since : 2019.02.16
	 * @version : 1.0
	 *
	 * @see com.utilkit.java.CalendarHandler.IFormatInfoEnum
	 */
	public enum FormatInfo implements IFormatInfoEnum<FormatInfo> {

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * A constant field that represents yyyy format.<br>
		 * It stores code value, date format, order.<br>
		 * </DD>
		 * </DL>
		 *
		 * @see #yy
		 * @see #MM
		 * @see #dd
		 */
		yyyy(1, "yyyy", 1),

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * A constant field that represents yy format.<br>
		 * It stores code value, date format, order.<br>
		 * </DD>
		 * </DL>
		 *
		 * @see #yyyy
		 * @see #MM
		 * @see #dd
		 */
		yy(2, "yy", 2),

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * A constant field that represents MM format.<br>
		 * It stores code value, date format, order.<br>
		 * </DD>
		 * </DL>
		 *
		 * @see #yyyy
		 * @see #yy
		 * @see #dd
		 */
		MM(3, "MM", 3),

		/**
		 * <DL>
		 * <DT>Description:</DT>
		 * <DD>
		 * A constant field that represents dd format.<br>
		 * It stores code value, date format, order.<br>
		 * </DD>
		 * </DL>
		 *
		 * @see #yyyy
		 * @see #yy
		 * @see #MM
		 */
		dd(4, "dd", 4);

		private final int code;
		private final String format;
		private int order;

		/**
		 * <DL>
		 * <DD>
		 * This constructor is used to initialise enum class.<br>
		 * </DD>
		 * </DL>
		 *
		 * @param code [i] Value of code.
		 * @param format [i] Value of format.
		 * @param order [i] Value of order.
		 */
		private FormatInfo(int code, String format, int order) {
			this.code = code;
			this.format = format;
			this.order = order;
		}

		@Override
		public int getCode() {
			return this.code;
		}

		@Override
		public String getFormat() {
			return this.format;
		}

		@Override
		public int getOrder() {
			return this.order;
		}
	}
}
